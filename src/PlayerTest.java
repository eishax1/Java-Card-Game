import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testAddToHand() {
        Player player = new Player();
        cardgen card = new cardgen("Ace", "Spade");
        player.addToHand(card);
        assertEquals(1, player.getHand().size());
        assertTrue(player.getHand().contains(card));
    }

    @Test
    void testPlayCard() {
        Player player = new Player();
        cardgen card = new cardgen("3", "Diamonds");
        player.addToHand(card);
        cardgen playedCard = player.playCard(0);
        assertEquals(0, player.getHand().size());
        assertEquals(card, playedCard);

        // Test playCard with invalid index
        assertNull(player.playCard(1));
    }

    @Test
    void testCanMake11() {
        Player player = new Player();
        cardgen card1 = new cardgen("2", "Spades");
        cardgen top = new cardgen("9" , "Diamonds");
        player.addToHand(card1);
        player.addToHand(top);
        assertTrue(player.canMake11(card1));

        // Check that the hand has been updated
        assertEquals(2, player.getHand().size());
        assertEquals("2 of Spades", player.getHand().get(0).toString());
        assertEquals("9 of Diamonds", player.getHand().get(1).toString());
    }

    @Test
    void testCanPlaySameSuit() {
        Player player = new Player();
        cardgen card1 = new cardgen("2", "Spades");
        cardgen card2 = new cardgen("3", "Spades");
        player.addToHand(card1);
        player.addToHand(card2);
        assertTrue(player.canPlaySameSuit(card1));

    }

    @Test
    void testPlaySameSuit() {
        Player player = new Player();
        Deck deck = new Deck();
        Scanner scanner = new Scanner("yes\n0\n");

        player.addToHand(new cardgen("2", "Clubs" ));
        player.addToHand(new cardgen("2", "Clubs"));

        assertTrue(player.playSameSuit(deck, scanner));



        scanner.close();
    }
}