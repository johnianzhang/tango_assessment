import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Simulator {
    /* Constants */
    private final int MAXIMUM_ITERATION = 2000;
    private final int NUMBER_OF_CONTESTANT_SWITCHES = 1000;
    private final int NUMBER_OF_CONTESTANT_STAYS = MAXIMUM_ITERATION - NUMBER_OF_CONTESTANT_SWITCHES;
    private final int NUMBER_OF_BRIEFCASES = 3;
    // private final int NUMBER_OF_PRIZES = 1; ... may add more constants,
    // such as UNIT_PRISE, VALUE, ...

    private int totalWins = 0;
    private int switchWins = 0;
    private int noSwitchWins = 0;
    private double[] rates = new double[3];
    private Random rand = new Random(System.currentTimeMillis());

    /**
     * Get the index of a random briefcase
     * 
     * @return the index of a random briefcase, from 0 to NUMBER_OF_BRIEFCASES - 1.
     */
    public int getRandBriefcase() {
        return rand.nextInt(NUMBER_OF_BRIEFCASES);
    }

    /**
     * Simulate the game and upate the data in the fields.
     */
    public void simulate() {
        for (int i = 0; i < NUMBER_OF_CONTESTANT_SWITCHES; i++) {
            GameChecker gcSwitch = new GameChecker(getRandBriefcase(), getRandBriefcase(), true);
            if (gcSwitch.getResult()) {
                switchWins++;
                totalWins++;
            }

            GameChecker gcNotSwitch = new GameChecker(getRandBriefcase(), getRandBriefcase(), false);
            if (gcNotSwitch.getResult()) {
                noSwitchWins++;
                totalWins++;
            }
        }
        getRates();
    }

    /**
     * Compute the winning rates in 3 cases respectively: total winning rate,
     * winning rate of the CONTESTANT chose switch,
     * winning rate of the CONTESTANT chose stay
     */
    public void getRates() {
        double rates[] = { totalWins * 1.0 / (MAXIMUM_ITERATION),
                switchWins * 1.0 / NUMBER_OF_CONTESTANT_SWITCHES,
                noSwitchWins * 1.0 / NUMBER_OF_CONTESTANT_STAYS };
        this.rates = rates;
    }

    /**
     * Returns a string representation of the simulation.
     * 
     * @return a string representation of the simulation.
     */
    public String toString() {
        String outStr = "";
        outStr += ("Total simulations: " + MAXIMUM_ITERATION + "\n");
        outStr += ("Total number of the CONTESTANT chooses switch: " + NUMBER_OF_CONTESTANT_SWITCHES + "\n");
        outStr += ("Total number of the CONTESTANT chooses stay: " + NUMBER_OF_CONTESTANT_STAYS + "\n");
        outStr += ("Total number of wins: " + totalWins + "\n");
        outStr += ("Number of wins chose switch: " + switchWins + "\n");
        outStr += ("Number of wins chose stay: " + noSwitchWins + "\n");
        outStr += String.format("Winning rate: %.3f\n", rates[0]);
        outStr += String.format("Winning rate chose switch: %.3f\n", rates[1]);
        outStr += String.format("Winning rate chose stay: %.3f\n", rates[2]);
        outStr += String.format("Winning rate ratio: stay:switch = 1:%.0f\n", rates[1] / rates[2]);
        return outStr;
    }

    /**
     * Print out the resultant data from the simulations.
     */
    public void printResult() {
        System.out.println(this);
    }

    /**
     * Write the resultant data into a *.txt file.
     */
    public void writeFile() {
        int i = 1;
        String name = "";
        try {
            do {
                name = "briefcase_simulation_result_" + i + ".txt";
                File fp = new File(name);
                if (fp.createNewFile()) {
                    System.out.println("File created: " + fp.getName());
                    break;
                } else {
                    i++;
                }
            } while (true);

            FileWriter writer = new FileWriter(name);
            writer.write(this.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
