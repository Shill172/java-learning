// Building a small game to practice inheritance.
// I will try to implement parent/subclasses, overriding, polymorphism, abstract classes, and interfaces

import java.util.ArrayList;
import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        ArrayList<Character> players = new ArrayList<>();
        ArrayList<Character> enemies = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the game. Please select a class.");
        System.out.println("1. Paladin");
        System.out.println("2. Monk");

        switch (sc.nextLine()) {
            case "1":
                System.out.println("Enter your name: ");
                String paladinName = sc.nextLine();
                Character paladin = new Paladin(paladinName, 50, "Paladin");
                players.add(paladin);
                break;
            case "2":
                System.out.println("Enter your name: ");
                String monkName = sc.nextLine();
                Character monk = new Monk(monkName, 40, "Monk");
                players.add(monk);
                break;
        }

        System.out.println("How many enemies do you want to face? (1, 2, 3)");
        switch (sc.nextLine()) {
            case "1":
                System.out.println("Generating 1 enemy");
                enemies.add(EnemyCreator.generateEnemy());
                break;
            case "2":
                System.out.println("Generating 2 enemies");
                enemies.add(EnemyCreator.generateEnemy());
                enemies.add(EnemyCreator.generateEnemy());
                break;
            case "3":
                System.out.println("Generating 3 enemies");
                enemies.add(EnemyCreator.generateEnemy());
                enemies.add(EnemyCreator.generateEnemy());
                enemies.add(EnemyCreator.generateEnemy());
                break;

        }


        System.out.println("Okay! Lets finally start the game. Slay your opponent(s): ");
        for (int i = 0; i < enemies.size(); i++) {
            System.out.print(enemies.get(i).getName() + " ");
        }

        System.out.println();

        boolean running = true;
        while (running) {
            ChooseAction.chooseAction(players, enemies);
            running = CheckHealth.healthCheck(enemies);
            if (!running) {
                System.out.println("You win! ദ്ദി˙ ᴗ ˙ )");
                break;
            }

            ChooseAction.chooseAction(enemies, players);
            running = CheckHealth.healthCheck(players);
            if (!running) {
                System.out.println("Game over ☠");
                break;
            }

        }

    }

}