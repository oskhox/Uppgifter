package Sprint4.Uppgift9;

public class RiddleProtocol {
    private static final int WELCOME = 0;
    private static final int ASKQUESTION = 1;
    private static final int YESORNO = 2;

    private int state = WELCOME;
    private int currentRiddle = 0;

    private final String[] riddles = {"Riddle: What has keys but can't open locks?",
            "Riddle: I’m tall when I’m young, and I’m short when I’m old. What am I?",
            "Riddle: The more you take, the more you leave behind. What am I?"};
    private final String[] answers = {"A piano", "A candle", "Footsteps"};

    // The first input is empty which  starts the WELCOME state, the game then advances through server looping user input
    // Each call to this protocol method only returns one String, the server calls in a loop if there is user input
    public String processInput(String theInput) {
        String theOutput = null;

        if (state == WELCOME) {
            theOutput = "Here's some riddles for ya: ";
            state = ASKQUESTION;
        }
        if (state == ASKQUESTION) {
            // Immediately show the first riddle once when the game first reaches ASKQUESTION state
            theOutput = riddles[currentRiddle];

            // Process the answer input from the user
            if (theInput != null && !theInput.isEmpty()) {
                if (theInput.equalsIgnoreCase(answers[currentRiddle])) {
                    theOutput = "That's right! The answer is " + answers[currentRiddle] + ". Want another one? (y/n)";
                    state = YESORNO;
                } else {
                    theOutput = "Nope, wrong answer. Want another one? (y/n)";
                    state = YESORNO;
                }
            }
        }
        // Process the Y/N and going back to ASKQUESTION as long as Y and there are riddles left or ending the game
        else if (state == YESORNO) {
            if (theInput.equalsIgnoreCase("y")) {
                currentRiddle++;
                if (currentRiddle < riddles.length) {
                    theOutput = riddles[currentRiddle]; // Ask any further riddles right here
                    state = ASKQUESTION;
                } else {
                    theOutput = "Bye.";
                    state = WELCOME; // Reset the game and does another round
                }
            } else if (theInput.equalsIgnoreCase("n")) {
                theOutput = "Bye.";
                state = WELCOME; // End of the game and does another round
            } else {
                theOutput = "I didn't understand that - please respond with a 'y' or 'n'";
            }
        }
        return theOutput; // The method only returns ONE string each time it runs
    }
}