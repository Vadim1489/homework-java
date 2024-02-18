public class Points {
    private int score;
    private String playerName;

    public Points(String playerName) {
        this.playerName = playerName;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
