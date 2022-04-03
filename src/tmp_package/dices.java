//import package_name // Change when used in the project
import java.util.Random;

/**
 * This Class is used when player throws dices
 */
public class dices {

    static Random rd = new Random(); // Static Random object to get random integer

    /**
     * This method is used to get 2 random integer for dice values
     * It is a static method so do not need to create dices object
     * @return 2 random integer between 1 and 6 
     */
    static int[] throwDice(){
        int dices[] = new int[2];
        dices[0] = rd.nextInt(1,7);
        dices[1] = rd.nextInt(1,7);
        return dices;
    }
}
