public class GodOfMercy implements Gods {
    @Override
    public String getFightDialogue() {
        return " attacks elegantly, dealing ";
    }

    public int getTargets() {
        return 2;
    }

    public int getDamage() {
        return baseDamage / getTargets() + (int) (Math.random() * 3);
    }


}
