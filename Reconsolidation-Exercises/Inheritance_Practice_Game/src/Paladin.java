import java.util.Random;
import java.util.Scanner;

public class Paladin extends Character {
    private Gods chosenGod;
    Scanner scanner = new Scanner(System.in);
    static int baseDamage = 10;
    Random rand = new Random();

    public Paladin(String name, int health, String classType) {
        super(name, health, classType);
        chosenGod = chooseGod();
    }

    private Gods chooseGod() {
        System.out.println("""
                Please choose one of the following gods:\s
                1. God of War (Self Buffing & Strong single target attacks)
                2. God of Mercy (Healing abilities & weak sweeping attacks)""");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.println("God of War chosen!");
                return new GodOfWar();

            case "2":
                System.out.println("God of Mercy chosen!");
                return new GodOfMercy();

            default:
                System.out.println("invalid choice");
        }
        return null;
    }

    @Override
    public int getDamage() {
        return baseDamage + rand.nextInt(10);
    }

    @Override
    public void buff() {
        baseDamage += 5;
    }


    @Override
    public Gods getGod() {
        return chosenGod;
    }

    @Override
    public void attack(Character target, int damage) {//Name        //attacks....                                   // monster 1 etc...
        System.out.println(getName() + chosenGod.getFightDialogue() + damage + " damage to " + target.getName());
    }

    @Override
    public void secondAction() {
        System.out.println(getName() + chosenGod.secondActionDialogue());
    }

}
