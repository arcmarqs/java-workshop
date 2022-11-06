// Inspired by the example from the book "Think Java"

// enums are a special type of class that defines a group of constants.
enum Suit{
        SPADES,
        CLUBS,
        HEARTS,
        DIAMONDS
}

// this class represents a playable card, with a suit and a rank, which is the number of the card.
class Card {
    /* 
        The card ranks are encoded as follows: 
        Ace -> 1
        2..10 -> 2..10
        Jack -> 11
        Queen -> 12
        King -> 13
    */    
    
    // Static Final means this is a constant array that is shared by all objects of this type.

    public static final String[] RANKS = {null,"Ace","2","3","4","5","6","7","8","9", "10", "Jack", "Queen","King"};
    int cardrank;
    Suit suit; 

    // card constuctor
    public Card(int cardrank, Suit suit) {
        this.cardrank = cardrank;
        this.suit = suit;
    }

    public int getRank() {
        return this.cardrank;
    }

    public Suit getSuit() { 
        return this.suit;
    }

    // private methods can't be called by other classes.
    private String decodeCard() {
        return RANKS[this.cardrank];  // by accessing the RANKS array with cardrank as index you get the string corresponding to what card it is
    }
    
    public String printCard() {
        return decodeCard() + " of " + this.suit.toString();
    }
}


class Deck {
    Card[] cards;

    public Deck() {
        this.cards= new Card[52]; // creating an array of Card objects.
        int i = 0;
        for(Suit s : Suit.values()) {
            for(int rank = 1; rank<= 13; rank++){
                cards[i] = new Card(rank,s);  // filling the array with every card
                i++;
            }
        }
    }

    public void print() {
        for(int i = 0; i < this.cards.length; i++) {
            this.cards[i].printCard();              // this is how you would print all cards, but im not using it at the moment
        }
     }
}