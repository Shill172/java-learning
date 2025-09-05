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
        return 5;
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

}
