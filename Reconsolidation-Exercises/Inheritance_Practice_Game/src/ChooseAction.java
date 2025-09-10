import java.util.ArrayList;

public class ChooseAction {

    public static void chooseAction(ArrayList<Character> character, ArrayList<Character> enemy) {
        for (Character c : character) {
            c.takeTurn(character, enemy);
        }
    }
}