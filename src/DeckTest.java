import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void testDeckInitialization() {
        Deck deck = new Deck();
        assertEquals(52, deck.getdecksize());
    }

    @Test
    void testDealCard() {
        Deck deck = new Deck();
        int initialSize = deck.getdecksize();
        cardgen dealtCard = deck.dealCard();
        assertEquals(initialSize - 1, deck.getdecksize());
        assertNotNull(dealtCard);
    }

    @Test
    void testDealToPlayer() {
        Deck deck = new Deck();
        Player player = new Player();
        int initialPlayerHandSize = player.getHand().size();

        deck.dealToPlayer(player);

        assertEquals(initialPlayerHandSize + 1, player.getHand().size());
    }

    @Test
    void testPeekTopCard() {
        Deck deck = new Deck();
        cardgen topCard = deck.peekTopCard();
        int initialSize = deck.getdecksize();

        assertNotNull(topCard);
        assertEquals(initialSize, deck.getdecksize());
    }
}