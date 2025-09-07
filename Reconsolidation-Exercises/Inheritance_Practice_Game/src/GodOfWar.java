public class GodOfWar implements Gods {

    static int buffDamage = 0;

    @Override
    public String getFightDialogue() {
        return " attacks furiously! Dealing ";
    }

    public String secondActionText() {
        return "Buff (+5) damage";
    }

    public String secondActionDialogue() {
        return " Rages! Buffing their attack power by 5";
    }


}
