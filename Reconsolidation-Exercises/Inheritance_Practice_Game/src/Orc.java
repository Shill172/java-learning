import java.util.Random;

public class Orc extends Character {

    static int baseDamage = 10;

    Random rand = new Random();

    public Orc(String name, int health, String classType) {
        super(name, health, classType);
    }

    @Override
    public void attack(Character target, int damage) {
        System.out.println(getName() + " swings their club! Pummeling " + target.getName() + " for " + damage + " damage.");
    }

    @Override
    public int getDamage() {
        return baseDamage + rand.nextInt(5);
    }

    public void buff() {
        System.out.println(getName() + " Roars! Buffing it's base damage by 3");
        baseDamage += 3;
    }

    @Override
    public boolean getIsPlayer() {
        return false;
    }



}

