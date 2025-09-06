import java.util.ArrayList;

public class CheckHealth {

    public static String healthCheck(ArrayList<Character> players , ArrayList<Character> enemies) {
        System.out.println("Checking players health: ");
        boolean playersAlive = false;
        for (Character player : players) {
            if (player.getHealth() > 0) {
                System.out.println(player.getName() + " is alive with" + player.getHealth() + " health");
                playersAlive = true;
            } else {
                System.out.println(player.getName() + " is dead.");
            }
        }
        if (!playersAlive) {
            return "PlayerDeath";
        }

        System.out.println("Checking enemies health: ");
        boolean enemiesAlive = false;
        for (Character enemy : enemies) {
            if (enemy.getHealth() > 0) {
                System.out.println(enemy.getName() + " is alive with" + enemy.getHealth() + " health");
                enemiesAlive = true;
            } else {
                System.out.println(enemy.getName() + " is dead.");
            }
        }

        if (!enemiesAlive) {
            return "EnemyDeath";
        }

        return "All good";
    }

}
