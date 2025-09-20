import java.util.ArrayList;

public abstract class Character {

    String name;
    int health;
    String classType;
    boolean isPlayer = true;
    protected int damageMultiplier = 1;
    int maxHealth;

    public Character(String name, int maxHealth, String classType) {
        this.name = name;
        this.health = maxHealth;
        this.classType = classType;
        this.maxHealth = maxHealth;
    }

    public int getDamage() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }


    public abstract void attack(Character target, int damage);

    public Gods getGod() {
        return null;
    }

    public boolean getIsPlayer() {
        return isPlayer;
    }

    public String getClassType() {
        return classType;
    }

    public void buff() {

    }

    public void takeDamage(int damage) {
        if (isBlocking()) {
            System.out.println(name + " took no damage because the attack was blocked!");
        } else {
            health -= damage;
            System.out.println(name + " took " + damage + " damage! Leaving them with " + getHealth() + " health");
        }

    }

    @Override
    public String toString() {
        return name + " (" + classType + ")";
    }

    public void secondAction() {

    }

    public Mantra getMantra() {
        return null;
    }

    public void takeTurn(ArrayList<Character> character, ArrayList<Character> enemy) {

    }

    public boolean isBlocking() {
        return false;
    }
}
