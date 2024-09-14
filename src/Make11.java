import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Make11 {
        private Deck deck;
        private Player player;
        private int score;
        private ArrayList<Round_info> roundDetailsList; //to store the replay
        private HighScore highScoreTable;
        private int currentRound = 1;
        private boolean gameInProgress=true;
        private ArrayList<cardgen> hand = new ArrayList<>();

        public Make11() {
                deck = new Deck();
                player = new Player();
                score = 0;
                roundDetailsList = new ArrayList<>();
                highScoreTable = new HighScore();
        }

        public void displayWelcomeMessage(){
                System.out.println("------------------------");
                System.out.println("---WELCOME TO MAKE 11---");
                System.out.println("------------------------");

        }


        private void displayComputerDealtCard() {
                System.out.println("-----------ROUND " + currentRound + "-------------");
                System.out.println("Computer deals: " + deck.peekTopCard());
        }
        public void playGame() {
                dealInitialHand();
                //display welcome message
                displayWelcomeMessage();
                // Show high scores
                highScoreTable.displayHighScores();
                Scanner scanner = new Scanner(System.in);

                while (gameInProgress && deck.getdecksize()!=0) {

                        //deck.dealToPlayer(player);
                        Round_info roundDetails = new Round_info();
                        roundDetailsList.add(roundDetails);
                        roundDetails.setPlayerHand(new ArrayList<>(player.getHand()));
                        displayComputerDealtCard();

                        System.out.println("Player's Hand: " + player.getHand());
                        roundDetails.setTopCard(deck.peekTopCard());
                        if (player.canMake11(deck.peekTopCard())) {
                                playRound(scanner, roundDetails);
                                displayFinalScore();
                        } else if (player.canPlaySameSuit(deck.peekTopCard())) {
                                // Check if the user wants to play the same suit
                                if (player.playSameSuit(deck, scanner)) {
                                        System.out.println("Matching Suits... continue.");
                                        roundDetails.setOutcome("Matching suits... Game continues");
                                        displayFinalScore();
                                } else {
                                        System.out.println("You chose not to play the same suit. Game over.");
                                        roundDetails.setOutcome("Player chose not to play the same suit. Game over.");
                                        gameInProgress = false;
                                }
                        } else {
                                System.out.println("Game over. Unable to Make 11 or play same suit.");
                                roundDetails.setOutcome("Game over. Unable to Make 11 or play same suit.");
                                displayFinalScore();
                                gameInProgress = false;
                        }
                        currentRound++;
                }


                displayFinalScore();
                offerReplay(scanner);
                checkForHighScore(scanner);
        }

        private void dealInitialHand() {
                for (int i = 0; i < 5; i++) {
                        deck.dealToPlayer(player);
                }

        }

       private void playRound(Scanner scanner, Round_info roundDetails) {
                System.out.println("Enter the index of the card to play (0-4): ");
                int index = getPlayerInput(scanner);

                cardgen selectedCard = player.playCard(index);
                if (selectedCard != null && (selectedCard.getValue() + deck.peekTopCard().getValue()) == 11) {
                        System.out.println("You made 11, Point scored!");
                        score++;
                        player.remove_card(selectedCard);
                        player.addToHand(deck.dealCard()); // Replace player's card with a new one
                        playPictureCards(scanner);
                        roundDetails.setOutcome("You made 11! Point scored.");
                } else {
                        System.out.println("Incorrect move. Game over.");
                        roundDetails.setOutcome("Incorrect move. Game over.");
                        // Set the flag to false to end the game
                        gameInProgress = false;
                }
        }


            public static char getLetterInput (Scanner scanner)
            {//method is made static as it is also used in the player class
                    while (true) {
                            String input = scanner.next().toUpperCase();
                            if (input.length() == 1 && input.charAt(0) >= 'A' && input.charAt(0) <= 'E') {
                                    return input.charAt(0);
                            } else {
                                    System.out.println("Invalid input. Please enter a valid letter (A-E): ");
                            }
                    }
            }
            private void playPictureCards (Scanner scanner){
                    if (player.hasPictureCards()) {
                            System.out.println("Do you want to play picture cards? (yes/no): ");
                            String choice = scanner.next().toLowerCase();

                            if (choice.equals("yes")) {
                                    player.playPictureCards(deck);
                                    System.out.println("Picture cards played. Cards replaced.");
                            }
                    }
            }

            private int getPlayerInput (Scanner scanner){
                    while (!scanner.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // Consume the invalid input
                    }
                    return scanner.nextInt();
            }

            private void displayFinalScore () {
                    System.out.println("\nTotal Score is " + score);
            }

            private void offerReplay (Scanner scanner){
                    System.out.println("Do you want to view a replay? (yes/no): ");
                    String choice = scanner.next().toLowerCase();

                    if (choice.equals("yes")) {
                            for (Round_info roundDetails : roundDetailsList) {
                                    System.out.println("\n-- Round Details --");
                                    System.out.println("Player's Hand: " + roundDetails.getPlayerHand());
                                    System.out.println("Top Card: " + roundDetails.getTopCard());
                                    System.out.println("Outcome: " + roundDetails.getOutcome());
                            }
                    }
            }

            private void checkForHighScore (Scanner scanner){
                    if (score > highScoreTable.getLowestScore()) {
                            System.out.println("Congratulations! You achieved a high score!");
                            System.out.println("Enter your name: ");
                            String playerName = scanner.next();
                            highScoreTable.updateHighScores(playerName, score);
                    }
                    highScoreTable.displayHighScores();
            }

            public static void main (String[]args) {
                    Make11 game = new Make11();
                    game.playGame();
            }
}

