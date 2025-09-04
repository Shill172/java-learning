abstract class Character {

    String name;
    int health;
    String classType;

    public Character(String name, int health, String classType) {
        this.name = name;
        this.health = health;
        this.classType = classType;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public int getDamage(int baseDamage) {
        return baseDamage + (int)(Math.random() + 5);
    }

    public abstract void attack(Character target);


}
