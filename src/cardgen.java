public class cardgen {
    private  String Ranks;
    private String suit;
    private static int numofcards=0;

    public cardgen(String aRanks, String asuit){
        this.Ranks=aRanks;
        this.suit=asuit;
        numofcards++;
    }

    public void setrank(String newrank){
        this.Ranks=newrank;
    }

    public void setsuit(String newsuit){
        this.suit=newsuit;
    }

    public String getRanks(){
        return this.Ranks;
    }

    public String getSuit(){
        return this.suit;
    }

    public int getValue() {
        if (Ranks.equals("Jack") || Ranks.equals("Queen") || Ranks.equals("King")) {
            return 10;
        } else if (Ranks.equals("Ace")) {
            return 1;
        } else {
            return Integer.parseInt(Ranks);
        }
    }



    public static int getnumofcards(){
        return numofcards;
    }

    public String toString(){
        return this.Ranks+" of "+this.suit;
    }

        }
