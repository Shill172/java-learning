import java.util.ArrayList;

public class CheckHealth {

    public static boolean healthCheck(ArrayList<Character> chars) {
        System.out.println("Checking " + chars  + " health: ");
        boolean alive = false;
        for (Character player : chars) {
            if (player.getHealth() > 0) {
                System.out.println(player.getName() + " is alive with " + player.getHealth() + " health");
                alive = true;
            } else {
                System.out.println(player.getName() + " is dead.");
            }
        }


        return alive;
    }

    public static boolean singleHealthCheck(Character chara) {
        if (chara.getHealth() > 0) {
            return true;
        } else {
            return false;
        }
    }

}
