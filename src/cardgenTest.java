import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class cardgenTest {
    @Test
    public void testConstructorAndAccessors() {
        // Test constructor and accessor methods
        cardgen card = new cardgen("Ace", "Hearts");

        assertEquals("Ace", card.getRanks());
        assertEquals("Hearts", card.getSuit());
    }

    @Test
    public void testSetRank() {
        // Test setRank method
        cardgen card = new cardgen("2", "Diamonds");

        card.setrank("King");
        assertEquals("King", card.getRanks());
    }

    @Test
    public void testSetSuit() {
        // Test setSuit method
        cardgen card = new cardgen("10", "Spades");

        card.setsuit("Clubs");
        assertEquals("Clubs", card.getSuit());
    }

    @Test
    public void testToString() {
        // Test toString method
        cardgen card = new cardgen("Queen", "Clubs");
        assertEquals("Queen of Clubs", card.toString());
    }

    @Test
    public void testGetNumOfCards() {
        // Test getNumOfCards method
        int initialNumOfCards = cardgen.getnumofcards();
        cardgen card = new cardgen("7", "Hearts");
        cardgen card2 = new cardgen("2", "Hearts");

        assertEquals(initialNumOfCards + 2, cardgen.getnumofcards());
    }


}