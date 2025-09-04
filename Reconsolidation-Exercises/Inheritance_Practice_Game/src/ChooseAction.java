import java.util.ArrayList;
import java.util.Scanner;

public class ChooseAction {

    public static void chooseAction(ArrayList<Character> character, ArrayList<Character> enemy) {
        Scanner actionScanner = new Scanner(System.in);

        for (Character c : character) {
            System.out.println("Your turn! Please choose an action: \n1. Attack");

            // Check if paladin
            Gods god = c.getGod();
            c.getGod();
            if (c.getGod() != null) {
                System.out.println("2. " + god.secondActionText());
            } else {
                System.out.println("reached not good case" + c.getGod());
            }

            switch (actionScanner.nextLine()) {
                case "1":
                    c.attack(enemy.getFirst());
            }

        }




    }

}
