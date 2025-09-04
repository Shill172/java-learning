// Building a small game to practice inheritance.
// I will try to implement parent/subclasses, overriding, polymorphism, abstract classes, and interfaces

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        List<Character> players = new ArrayList<>();
        List<Character> enemies = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the game. Please select a class.");
        System.out.println("1. Paladin");

        Character paladin = null;
        switch (sc.nextLine()) {
            case "1":
                System.out.println("Enter your name: ");
                String name = sc.nextLine();
                paladin = new Paladin(name, 50, "Paladin");
                players.add(paladin);
        }

        System.out.println("How many enemies do you want to face? (1, 2, 3)");
        switch (sc.nextLine()) {
            case "1":
                System.out.println("Generating 1 enemy");
                enemies.add(EnemyCreator.generateEnemy());
        }


        System.out.println("Okay! Lets finally start the game. Kill your opponent(s): ");
        for (int i = 0; i < enemies.size(); i++) {
            System.out.print(enemies.get(i).getName() + " ");
        }


        paladin.attack(enemies.getFirst());

    }


}