// Building a small game to practice inheritance.
// I will try to implement parent/subclasses, overriding, polymorphism, abstract classes, and interfaces

import java.util.ArrayList;
import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        ArrayList<Character> players = new ArrayList<>();
        ArrayList<Character> enemies = new ArrayList<>();

        // Creating allies
        Scanner sc = new Scanner(System.in);
        System.out.println("How many allies do you wish to create? (1, 2, 3)");
        int alliesInput = Validations.numberInputValidation(sc, 4);
        for (int i = 0; i < alliesInput; i++) {
            System.out.println("Welcome to the game. Please select a class for ally " + (i+1));
            System.out.println("1. Paladin");
            System.out.println("2. Monk");
            int charInput = Validations.numberInputValidation(sc, 3);
            sc.nextLine();

            System.out.println("Enter your name: ");
            switch (charInput) {
                case 1:
                    String paladinName = sc.nextLine();
                    Character paladin = new Paladin(paladinName, 50, "Paladin");
                    players.add(paladin);
                    break;
                case 2:
                    String monkName = sc.nextLine();
                    Character monk = new Monk(monkName, 40, "Monk");
                    players.add(monk);
                    break;
            }
        }

        // Creating enemies
        System.out.println("How many enemies do you want to face? (1, 2, 3)");
        int enemyInput = Validations.numberInputValidation(sc, 4);
        sc.nextLine();
        System.out.println("Creating " + enemyInput + " enemy(s).");
        for (int i = 0; i < enemyInput; i++) {
            enemies.add(EnemyCreator.generateEnemy());
        }

        // Game start
        System.out.println("Okay! Lets finally start the game. Slay your opponent(s): ");
        for (int i = 0; i < enemies.size(); i++) {
            System.out.print(enemies.get(i).getName() + " ");
        }

        System.out.println();

        boolean running = true;
        while (running) {
            // User turn
            ChooseAction.chooseAction(players, enemies);
            running = CheckHealth.healthCheck(enemies);
            if (!running) {
                System.out.println("You win! ദ്ദി˙ ᴗ ˙ )");
                break;
            }
            // Enemy turn
            ChooseAction.chooseAction(enemies, players);
            running = CheckHealth.healthCheck(players);
            if (!running) {
                System.out.println("Game over ☠");
                break;
            }
        }

    }

}