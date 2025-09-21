import java.util.ArrayList;
import java.util.Random;

public class Vampire extends Character {

    static int evasion = 0;

    public Vampire(String name, int health, String classType) {
        super(name, health, classType);
    }

    Random rand = new Random();

    final int baseDamage = 8;

    @Override
    public void attack(Character target, int damage) {
        System.out.println(getName() + " bites " + target + "! Draining their life force, dealing " + damage + " and recovering " + damage/2);
    }

    @Override
    public int getDamage() {
        return baseDamage + rand.nextInt(4);
    }

    public boolean getIsPlayer() {
        return false;
    }

    public void transform() {
        System.out.println("Vampire transforms! Increasing it's evasion.");
        evasion += 10;
    }

    @Override
    public void takeDamage(int damage) {
        int hit = rand.nextInt(100);
        if (hit >= evasion) {
            super.takeDamage(damage);
        }
        else {
            System.out.println(name + " Avoided the attack!");
        }
    }

    @Override
    public void takeTurn(ArrayList<Character> character, ArrayList<Character> enemy) {
        System.out.println(name + "'s turn!");
        if (rand.nextBoolean()) {
            System.out.println("Vampire chooses to attack!");
            int damageRoll = getDamage();
            Character target = TargetChooser.aiChooseTarget(enemy);
            attack(target, damageRoll);
            target.takeDamage(damageRoll);
            health = Math.min(health + damageRoll/2, maxHealth);
        } else {
            transform();
        }
    }


}
