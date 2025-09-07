public abstract class Character {

    String name;
    int health;
    String classType;
    boolean isPlayer = true;

    public Character(String name, int health, String classType) {
        this.name = name;
        this.health = health;
        this.classType = classType;
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
        health -= damage;
        System.out.println(name + " took " + damage + " damage! Leaving them with " + getHealth() + " health");
    }

    @Override
    public String toString() {
        return name + " (" + classType + ")";
    }

}
