import java.util.ArrayList;

class Round_info {

    private ArrayList<cardgen> playerHand;
    private cardgen topCard;
    private String outcome;

    public Round_info() {
        playerHand = new ArrayList<>();
    }

    public void setPlayerHand(ArrayList<cardgen> playerHand) {
        this.playerHand = playerHand;
    }

    public ArrayList<cardgen> getPlayerHand() {
        return playerHand;
    }

    public void setTopCard(cardgen topCard) {
        this.topCard = topCard;
    }

    public cardgen getTopCard() {
        return topCard;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getOutcome() {
        return outcome;
    }
}