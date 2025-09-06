public class GodOfWar implements Gods {

    static int buffDamage = 0;

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

    public String secondActionText() {
        return "Buff (+3) damage";
    }

    @Override
    public void secondAction() {
        buffDamage += 3;
    }
}
