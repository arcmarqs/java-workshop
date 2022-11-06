import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Game logic class
class Game {
    String playerName; 
    Deck deck;
    /* this boolean array has 52 elements, one for each card, you switch the played[cardIndex] to true to signalize that that card can't be used again.
        It would also be possible to use a linked list to store the played indexes, but it would take longer to search, its better to use an array when we know the size of the data.
    */
    boolean[] played; 
    // keeping count of the score, contrary to traditional blackjack, in lackbjack the score of each card is equal to the card's rank (see the Card class for more information).
    int score = 0; 


    public Game(String player) {
        this.playerName = player;
        this.deck = new Deck();
        this.score = 0;
        this.played = new boolean[52];
    }

    // generate a new random index from 0 to 51 repeatedly until you get the index of an unplayed card.
    private Card getRandomCard() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(deck.cards.length-1);

        while(this.played[randomIndex]) {
            randomIndex = rand.nextInt(deck.cards.length);
        } 

        // flip the card index to signalize that it has been played
        this.played[randomIndex] = true;
        return deck.cards[randomIndex];
    }

    private int calculateScore(Card card) {
        return this.score += card.getRank();
    }

    //ask for a new round
    private boolean newRound() {
        Scanner scan = new Scanner(System.in);
            System.out.println("Do you want another Card?(answer y for yes or n for no, default is no)");
            switch(scan.nextLine()) {
                case "y" : return true;
                case "n" : return false;
                default : return false;
            }
    }

    private void clearGame() {
        this.score = 0;
        Arrays.fill(this.played,false);
    }

    public void play() {
        System.out.println("Welcome to lackbjack, " + playerName + "!");

        while(true) {
            Card card = this.getRandomCard();
            System.out.println("You have drawn a " + card.printCard() + ".");
            System.out.println("Your current score is " + this.calculateScore(card));

            if(this.score > 21) {
                System.out.println("You lost with " + this.score + " points.");
                this.clearGame();
                return;
            } else if (this.score == 21) { 
                System.out.println("Congratulations, you won!");
                this.clearGame();
                return;
            }

            if(!this.newRound() ){
                System.out.println("You finished with " + this.score + " points.");
                this.clearGame();
                return;
            }
        }

    }
}

public class MyGame {
   private final static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please enter your name: ");
        String name = scan.nextLine();
        Game game = new Game(name);

        while(true) {
            game.play();
            System.out.println("Do you want to play again?");
            switch(scan.nextLine()) {
                case "y" : continue;
                case "n" : return;
                default : return;
            }
        }
    }
}