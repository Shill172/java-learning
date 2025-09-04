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

    @Override
    public void secondAction() {
        System.out.println("not done yet");
    }

    @Override
    public String secondActionText() {
        return "Heal (5 HP)";
    }


}
