public class PeaceMantra implements Mantra {

    private boolean channeling = true;

    @Override
    public String getFightDialogue() {
        return " Realises they must fight, dealing ";
    }

    @Override
    public String secondActionText() {
        return "Block (1 turn)";
    }

    @Override
    public String secondActionDialogue() {
        return " Goes into a trance, setting up a barrier for all allies for a single turn";
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
