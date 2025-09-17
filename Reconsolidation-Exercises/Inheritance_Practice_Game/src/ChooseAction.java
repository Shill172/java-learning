import java.util.ArrayList;

public class ChooseAction {

    public static void chooseAction(ArrayList<Character> character, ArrayList<Character> enemy) {
        for (Character c : character) {
            if (CheckHealth.singleHealthCheck(c)) {
                c.takeTurn(character, enemy);
            } else {
                System.out.println(c.getName() + " cannot take turn because they're dead!");
            }
        }
    }
}