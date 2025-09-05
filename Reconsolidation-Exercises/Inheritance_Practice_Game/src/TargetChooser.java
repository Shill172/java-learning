import java.util.ArrayList;
import java.util.Scanner;

public class TargetChooser {

    public static Character chooseTarget(ArrayList<Character> target) {
        System.out.println("Please choose your target:");
        Scanner sc = new Scanner(System.in);
        int i = 1;
        for (Character targetChar : target) {
            System.out.println(i + ": " + targetChar.getName());
            i++;
        }
        System.out.println();
        String targetString = sc.nextLine();
        return switch (targetString) {
            case "1" -> target.get(0);
            case "2" -> target.get(1);
            case "3" -> target.get(2);
            default -> null;
        };
    }

}
