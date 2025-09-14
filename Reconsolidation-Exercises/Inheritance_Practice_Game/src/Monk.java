import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Monk extends Character {
    private Mantra mantra;
    Scanner scanner = new Scanner(System.in);
    static int baseDamage = 10;
    Random rand = new Random();
    public boolean blocking = false;
    private boolean canBlock = true;

    public Monk(String name, int health, String classType) {
        super(name, health, classType);
        mantra = chooseMantra();
    }

    private Mantra chooseMantra() {
        System.out.println("""
                Please choose a mantra:
                1. Worthy
                2. Peace
                """);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.println("You are worthy!");
                return new WorthyMantra();
            case "2":
                System.out.println("You are at peace!");
                return new PeaceMantra();

            default:
                return null;
        }

    }

    @Override
    public int getDamage() {
        int dmg = (baseDamage + rand.nextInt(5));
        dmg *= damageMultiplier;
        damageMultiplier = 1;
        return dmg;
    }

    @Override
    public Mantra getMantra() {
        return mantra;
    }

    @Override
    public void attack(Character target, int damage) {
        System.out.println(name + mantra.getFightDialogue());
    }

    @Override
    public void secondAction() {
        System.out.println(getName() + mantra.secondActionDialogue());
    }

    @Override
    public boolean isBlocking() {
        return blocking;
    }

    public void setBlockingTrue() {
        blocking = true;
    }

    public void setBlockingFalse() {
        blocking = false;
    }

    @Override
    public void takeTurn(ArrayList<Character> character, ArrayList<Character> enemy) {
        boolean valid = false;
        while (!valid) {
            System.out.println("Your turn, " + name + "! Please choose an action:");
            if (mantra instanceof PeaceMantra) {
                System.out.println("1. Palm");
            } else {
                System.out.println("1. Barrage");
            }
            System.out.println("2. " + mantra.secondActionText());

            // Input
            switch (scanner.nextLine()) {
                case "1":
                    int damageRoll = getDamage();
                    if (mantra instanceof PeaceMantra) {
                        Character target = TargetChooser.chooseTarget(enemy);
                        attack(target, damageRoll);
                        target.takeDamage(damageRoll);
                        canBlock = true;
                        valid = true;
                        setBlockingFalse();
                        break;
                    } else {
                        for (Character targets : enemy) {
                            attack(targets, damageRoll / enemy.size());
                            targets.takeDamage(damageRoll / enemy.size());
                        }
                        valid = true;
                    }
                    break;
                case "2":
                    if (mantra instanceof PeaceMantra) {
                        if (canBlock) {
                            setBlockingTrue();
                            canBlock = false;
                            secondAction();
                            valid = true;
                        } else {
                            System.out.println("You cannot block because you blocked the previous turn!");
                        }
                    } else {
                        secondAction();
                        damageMultiplier *= 3;
                        valid = true;
                    }

                    break;
            }
        }
    }

}
