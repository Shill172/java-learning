public class WorthyMantra implements Mantra {

    private boolean channeling = false;

    @Override
    public String getFightDialogue() {
        return " Stands up to the enemy, showing their worth by dealing ";
    }

    @Override
    public String secondActionText() {
        return "Focus (Next attack is more than double strength)";
    }

    @Override
    public String secondActionDialogue() {
        return " Focuses, as they focus for all allies next attack.";
    }

    @Override
    public void channelMantra() {
        channeling =! channeling;
    }

    @Override
    public boolean getIfChanneling() {
        return channeling;
    }

}
