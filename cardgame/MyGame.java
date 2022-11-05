import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Game {
    String playerName;
    Deck deck;
    boolean[] played;
    int score = 0;


    public Game(String player) {
        this.playerName = player;
        this.deck = new Deck();
        this.score = 0;
        this.played = new boolean[52];
    }

    private Card getRandomCard() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(deck.cards.length-1);

        while(this.played[randomIndex]) {
            randomIndex = rand.nextInt(deck.cards.length);
        } 

        this.played[randomIndex] = true;
        return deck.cards[randomIndex];
    }

    private int calculateScore(Card card) {
        return this.score += card.getRank();
    }

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
