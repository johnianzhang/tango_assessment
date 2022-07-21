
public class GameChecker {
    private int winningIndex;
    private int originalChoiceIndex;
    private boolean isSwitch;

    /**
     * Construstor
     * 
     * @param winningIndex        the index of the briefcase with prize
     * @param originalChoiceIndex the index of the briefcase that the contestant
     *                            originally choise
     * @param isSwitch            true - switch, false - stay, after the host
     *                            eliminated an empty one
     */
    public GameChecker(int winningIndex, int originalChoiceIndex, boolean isSwitch) {
        this.winningIndex = winningIndex;
        this.originalChoiceIndex = originalChoiceIndex;
        this.isSwitch = isSwitch;
    }

    /**
     * Check if the contestant wins or not.
     * Winning condition: the contestant originally chose the correct one and stays,
     * or they originally chose the wrong one and switches.
     * 
     * @return true - win, false - lost.
     */
    public boolean getResult() {
        return (winningIndex == originalChoiceIndex) ^ isSwitch; // XOR
    }

    /**
     * Returns a string representation of the game.
     * 
     * @return a string representation of the game.
     */
    public String toString() {
        return "The winning briefcase is number " + (winningIndex + 1) +
                ".\n The contestant originally chose number" + (originalChoiceIndex + 1) +
                ".\n After the host eliminated an empty one, the contestant decided to " +
                (isSwitch ? "switch" : "stay") + " their choise.";
    }
}
