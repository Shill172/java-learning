public class GodOfWar implements Gods {

    public String getAttackDialogue() {
        return "Rages in fury and ";
    }

    @Override
    public String getFightDialogue() {
        return " attacks furiously! Dealing ";
    }

    @Override
    public int getTargets() {
        return 1;
    }

    public int getDamage() {
        return baseDamage + (int) (Math.random() * 5);
    }
}
