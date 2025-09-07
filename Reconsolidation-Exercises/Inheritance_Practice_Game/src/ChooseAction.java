import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ChooseAction {

    public static void chooseAction(ArrayList<Character> character, ArrayList<Character> enemy) {
        Scanner actionScanner = new Scanner(System.in);

        for (Character c : character) {
            // Check if player
            if (c.getIsPlayer()) {
                System.out.println("\nYour turn! Please choose an action: \n1. Attack");
                // Check if paladin
                Gods god = c.getGod();
                c.getGod();
                if (c.getGod() != null) {
                    System.out.println("2. " + god.secondActionText());
                } else {
                    System.out.println("reached not good case" + c.getGod());
                }

                switch (actionScanner.nextLine()) {
                    case "1":
                        int damageRoll = c.getDamage();
                        if (c.getGod() instanceof GodOfWar) {
                            Character target = TargetChooser.chooseTarget(enemy);
                            c.attack(target, damageRoll);
                            target.takeDamage(damageRoll);
                        } else {
                            for (Character targets : enemy) {
                                c.attack(targets, damageRoll / enemy.size());
                                targets.takeDamage(damageRoll/enemy.size());
                            }
                        }
                    case "2":
                        c.secondAction();
                        if (c.getGod() instanceof GodOfWar) {
                            c.buff();
                        } else {
                            for (Character allies : character) {
                                allies.health += 10;
                            }
                        }

                }
            } else {
                System.out.println(c.getName() + "'s turn!");
                Random monsterRandom = new Random();
                if (c.getClassType().equals("Orc")) {
                    if (monsterRandom.nextBoolean()) {
                        System.out.println("Orc chooses to attack!");
                        int damageRoll = c.getDamage();
                        Character target = enemy.getFirst();
                        c.attack(target, damageRoll);
                        target.takeDamage(damageRoll);
                    } else {
                        System.out.println("Orc chooses to buff!");
                        c.buff();
                    }


                }

            }


        }

    }
}