public class GodOfMercy implements Gods {
    @Override
    public String getFightDialogue() {
        return " attacks elegantly, dealing ";
    }

    @Override
    public String secondActionText() {
        return "Heal (10 HP)";
    }

    @Override
    public String secondActionDialogue() {
        return " Prays! Healing 10HP for all allies.";
    }

}
