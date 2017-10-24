public class KnockKnockProtocol {
    private static final int WAITING = 0;
    private static final int SENTKNOCKKNOCK = 1;
    private static final int SENTCLUE = 2;
    private static final int ANOTHER = 3;
    private static final int NUMJOKES = 5;
    private int state = 0;
    private int currentJoke = 0;
    private String[] clues = new String[]{"Turnip", "Little Old Lady", "Atch", "Who", "Who"};
    private String[] answers = new String[]{"Turnip the heat, it's cold in here!", "I didn't know you could yodel!", "Bless you!", "Is there an owl in here?", "Is there an echo in here?"};

    public KnockKnockProtocol() {
    }

    public String processInput(String var1) {
        String var2 = null;
        if (this.state == 0) {
            var2 = "Knock! Knock!";
            this.state = 1;
        } else if (this.state == 1) {
            if (var1.equalsIgnoreCase("Who's there?")) {
                var2 = this.clues[this.currentJoke];
                this.state = 2;
            } else {
                var2 = "You're supposed to say \"Who's there?\"! Try again. Knock! Knock!";
            }
        } else if (this.state == 2) {
            if (var1.equalsIgnoreCase(this.clues[this.currentJoke] + " who?")) {
                var2 = this.answers[this.currentJoke] + " Want another? (y/n)";
                this.state = 3;
            } else {
                var2 = "You're supposed to say \"" + this.clues[this.currentJoke] + " who?\"! Try again. Knock! Knock!";
                this.state = 1;
            }
        } else if (this.state == 3) {
            if (var1.equalsIgnoreCase("y")) {
                var2 = "Knock! Knock!";
                if (this.currentJoke == 4) {
                    this.currentJoke = 0;
                } else {
                    ++this.currentJoke;
                }

                this.state = 1;
            } else {
                var2 = "Bye.";
                this.state = 0;
            }
        }

        return var2;
    }
}
