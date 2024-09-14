class ScoreEntry implements Comparable<ScoreEntry> {
    private String playerName;
    private int score;

    public ScoreEntry(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(ScoreEntry other) {
        return Integer.compare(this.score, other.score);
    }

    @Override
    public String toString() {
        return playerName + ": " + score;
    }
}