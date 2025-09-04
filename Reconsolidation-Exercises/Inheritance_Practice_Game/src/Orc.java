import java.util.Random;

public class Orc extends Character {

    Random rand = new Random();

    public Orc(String name, int health, String classType) {
        super(name, health, classType);
        int baseDamage = 10;
    }

    @Override
    public void attack(Character target) {

    }


}

