import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TargetChooser {

    public static Character chooseTarget(ArrayList<Character> target) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose your target:");
            for (int i = 0; i < target.size(); i++) {
                System.out.println((i + 1) + ": " + target.get(i).getName());
            }
            System.out.println();

            try {
                int choice = sc.nextInt();
                int i = choice - 1;

                if (i >= 0 && i < target.size()) {
                    Character chosen = target.get(i);
                    if (chosen.getHealth() > 0) {
                        return chosen;
                    } else if (target.stream().allMatch(t -> t.health <= 0)) {
                        return chosen;
                    }
                    System.out.println("You can't target the dead.");
                } else {
                    System.out.println("Please enter a valid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                sc.nextLine();
            }
        }

    }

    public static Character aiChooseTarget(ArrayList<Character> target) {
        Random targetRandom = new Random();

        ArrayList<Character> copyTargets = new ArrayList<>(target);

        for (Character t : copyTargets) {
            if (t.getHealth() < 0) {
                copyTargets.remove(t);
                int index = targetRandom.nextInt(copyTargets.size());
                return copyTargets.get(index);
            } else {
                int index = targetRandom.nextInt(copyTargets.size());
                return copyTargets.get(index);
            }
        }

        return null;
    }

}
