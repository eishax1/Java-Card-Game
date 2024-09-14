import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private String[] ranks={"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private String[] Suits={"Clubs", "Diamonds", "Hearts", "Spades"};

    private int numrecard=52;
    private ArrayList<cardgen> cardDeck= new ArrayList<>();


    public int getdecksize(){
        return cardDeck.size();

    }
    public Deck(){
        deck();

    }


    public void deck() {
        for (String r : ranks) {
            for (String s : Suits) {
                cardgen card = new cardgen(r, s);
                cardDeck.add(card);

            }
        }
        Collections.shuffle(cardDeck);
    }
    public cardgen dealCard() {
        if (!cardDeck.isEmpty()) {
            numrecard--;
            return cardDeck.remove(0);

        } else {
            System.out.println("No more cards in the deck.");
            return null; // or throw an exception
        }
    }


    public void dealToPlayer(Player player) {
        cardgen card = dealCard();
        if (card != null) {
            player.addToHand(card);
        }
    }

    public cardgen peekTopCard() {
        if (!cardDeck.isEmpty()) {
            return cardDeck.get(0);
        }
        return null; // Deck is empty
    }

    public String toString() {
        return "Deck: " + cardDeck.toString();
    }


}
