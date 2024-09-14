import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class HighScore {
    private  ArrayList<ScoreEntry> highScores;


    public HighScore() {
        highScores = new ArrayList<>();
        highScores.add(new ScoreEntry("Jenny", 2));
        highScores.add(new ScoreEntry("Chris", 1));
        highScores.add(new ScoreEntry("Harry", 3));
    }

    public void displayHighScores() {
        if (highScores.isEmpty()) {
            System.out.println("High score table is empty.");
        } else {
            System.out.println("\n-- High Score Table --");
            for (ScoreEntry entry : highScores) {
                System.out.println(entry);

            }
        }
    }



    public void updateHighScores(String playerName, int score) {
        ScoreEntry newEntry = new ScoreEntry(playerName, score);

        if (highScores.size() < 5) {
            highScores.add(newEntry);
        } else {
            // Sort highScores in ascending order based on score
            Collections.sort(highScores);

            if (score > highScores.get(4).getScore()) {
                // Replace the lowest score entry
                highScores.set(4, newEntry);
            }
        }

        // Sort highScores in descending order based on score
        Collections.sort(highScores, Comparator.reverseOrder());
    }
    public int getLowestScore() {
        if (!highScores.isEmpty() && highScores.size() >= 5) {
            return highScores.get(4).getScore();
        }
        return 0;
    }
}