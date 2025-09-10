public class PeaceMantra implements Mantra {
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
        return " Focuses, setting up a wide barrier for 1 turn.";
    }

    @Override
    public void channelMantra() {

    }

}
