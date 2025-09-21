import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Paladin extends Character {
    private Gods chosenGod;
    Scanner scanner = new Scanner(System.in);
    int baseDamage = 10;
    Random rand = new Random();

    public Paladin(String name, int health, String classType) {
        super(name, health, classType);
        chosenGod = chooseGod();
    }

    private Gods chooseGod() {
        System.out.println("""
                Please choose one of the following gods:
                1. God of War (Self Buffing & Strong single target attacks)
                2. God of Mercy (Healing abilities & weak sweeping attacks)""");
        int choice = Validations.numberInputValidation(scanner, 3);
        switch (choice) {
            case 1:
                System.out.println("God of War chosen!");
                return new GodOfWar();
            case 2:
                System.out.println("God of Mercy chosen!");
                return new GodOfMercy();

            default:
                System.out.println("invalid choice");
        }
        return null;
    }

    @Override
    public int getDamage() {
        return getBaseDamage() + rand.nextInt(10);
    }

    @Override
    public void buff() {
        baseDamage += 5;
    }


    @Override
    public Gods getGod() {
        return chosenGod;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public void attack(Character target, int damage) {//Name        //attacks....                                   // monster 1 etc...
        System.out.println(getName() + chosenGod.getFightDialogue() + damage + " damage to " + target.getName());
    }

    @Override
    public void secondAction() {
        System.out.println(getName() + chosenGod.secondActionDialogue());
    }

    @Override
    public void takeTurn(ArrayList<Character> character, ArrayList<Character> enemy) {
        // Choosing Turn
        System.out.println("Your turn, " + name + "! Please choose an action:");
        if (chosenGod instanceof GodOfWar) {
            System.out.println("1. Slash");
        } else {
            System.out.println("1. Sweep");
        }
        System.out.println("2. " + chosenGod.secondActionText());

        // Input
        int paladinInput = Validations.numberInputValidation(scanner, 3);
        switch (paladinInput) {
            case 1:
                int damageRoll = getDamage();
                if (chosenGod instanceof GodOfWar) {
                    Character target = TargetChooser.chooseTarget(enemy);
                    attack(target, damageRoll);
                    target.takeDamage(damageRoll);
                    break;
                } else {
                    for (Character targets : enemy) {
                        attack(targets, damageRoll / enemy.size());
                        targets.takeDamage(damageRoll / enemy.size());
                    }
                    break;
                }
            case 2:
                secondAction();
                if (chosenGod instanceof GodOfWar) {
                    buff();
                } else {
                    for (Character allies : character) {
                        allies.health = Math.min(allies.health + 10, allies.maxHealth);
                    }
                }        break;
        }
    }

}
