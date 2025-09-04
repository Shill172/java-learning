import java.util.Random;

public class EnemyCreator {

    public static Character generateEnemy() {
        Random rand = new Random();
        int number = rand.nextInt(1);

        if (number == 0) {
            return new Orc("Orc", 50, "Orc");
        } else {
            return null;
        }
    }

}
