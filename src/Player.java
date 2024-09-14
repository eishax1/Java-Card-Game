import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {
    public static ArrayList<cardgen> hand = new ArrayList<>();

    public Player() {
        hand = new ArrayList<>();
    }

    public void addToHand(cardgen card) {
        hand.add(card);
    }

    public ArrayList<cardgen> getHand() {
        return hand;
    }


    public cardgen playCard(int index) {
        try {
            return hand.remove(index);
        } catch (IndexOutOfBoundsException e) {
            // Index is out of bounds
            return null;
        }
    }

    public boolean canMake11(cardgen top) {
        for (cardgen card : hand) {
            if (card.getValue() + top.getValue() == 11) {
                return true;
            }
        }
        return false;
    }

    public boolean canPlaySameSuit(cardgen topCard) {
        for (cardgen card : hand) {
            if (card.getSuit().equals(topCard.getSuit())) {
                return true;
            }
        }
        return false;
    }

  /*  public boolean playSameSuit(Deck deck, Scanner scanner) {
        System.out.println("Do you want to play a card of the same suit? (yes/no): ");
        String choice = scanner.next().toLowerCase();

        if (choice.equals("yes")) {
            cardgen playedCard = null;

            System.out.println("Select a card to play from the same suit:");
            for (int i = 0; i < hand.size(); i++) {
                cardgen card = hand.get(i);

            }

            int selection = getNumericInput(scanner, hand.size());

            if (selection >= 0 && selection < hand.size() && hand.get(selection).getSuit().equals(deck.peekTopCard().getSuit())) {
                playedCard = hand.get(selection);
            }

            if (playedCard != null) {
                hand.remove(playedCard);
                hand.add(deck.dealCard());
                return true;
            }
        }
        return false;
    }*/
  public boolean playSameSuit(Deck deck, Scanner scanner) {
      System.out.println("Do you want to play a card of the same suit? (yes/no): ");
      String choice = scanner.next().toLowerCase();

      if (choice.equals("yes")) {
          cardgen playedCard = null;

          System.out.println("Select a card to play from the same suit (A-E): ");
          for (int i = 0; i < hand.size(); i++) {
              System.out.println((char) ('A' + i) + ": " + hand.get(i));
          }

          char letter = Make11.getLetterInput(scanner);
          int index = letter - 'A';

          if (index >= 0 && index < hand.size() && hand.get(index).getSuit().equals(deck.peekTopCard().getSuit())) {
              playedCard = hand.get(index);
          }

          if (playedCard != null) {
              hand.remove(playedCard);
              hand.add(deck.dealCard());
              return true;
          }
      }

      return false;
  }

    private int getNumericInput(Scanner scanner, int max) {
        while (true) {
            System.out.println("Enter your selection (0-" + (max - 1) + "): ");
            if (scanner.hasNextInt()) {
                int selection = scanner.nextInt();
                if (selection >= 0 && selection < max) {
                    return selection;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }
    }

    public boolean hasPictureCards() {
        List<String> pictureRanks = Arrays.asList("Jack", "Queen", "King");

        for (cardgen card : hand) {
            if (pictureRanks.contains(card.getRanks())) {
                return true;
            }
        }

        return false;
    }
    public void remove_card(cardgen card) {
        hand.remove(card);
    }

    public void playPictureCards(Deck deck) {
        ArrayList<cardgen> pictureCards = new ArrayList<>();

        for (cardgen card : hand) {
            if (card.getRanks().equals("Jack") || card.getRanks().equals("Queen") || card.getRanks().equals("King")) {
                pictureCards.add(card);
            }
        }

        hand.removeAll(pictureCards);
        for (int i = 0; i < pictureCards.size(); i++) {
            hand.add(deck.dealCard());
        }


    }


}