import java.util.Scanner;

public class Validations {

    public static int numberInputValidation(Scanner scanner, int boundary) {
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= boundary || input < 0) {
                    int rangeNum = boundary - 1;
                    System.out.println("Your input: " + input + "exceeds the boundary: 1-" + rangeNum + "\nTry again: ");
                } else {
                    return input;
                }
            } else {
                System.out.println("Not a number! Try again.");
                scanner.next();
            }
        }
    }

}
