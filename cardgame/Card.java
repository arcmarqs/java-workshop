// Inspired by the example from the book "Think Java"

enum Suit{
        SPADES,
        CLUBS,
        HEARTS,
        DIAMONDS
}

class Card {
    /* 
        The cards are encoded as follows: 
        Ace -> 1
        2..10 -> 2..10
        Jack -> 11
        Queen -> 12
        King -> 13
    */    
    public static final String[] RANKS = {null,"Ace","2","3","4","5","6","7","8","9", "10", "Jack", "Queen","King"};
    int cardrank;
    Suit suit; 

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

    private String decodeCard() {
        return RANKS[this.cardrank];
    }
    
    public String printCard() {
        return decodeCard() + " of " + this.suit.toString();
    }
}


class Deck {
    Card[] cards;

    public Deck() {
        this.cards= new Card[52];
        int i = 0;
        for(Suit s : Suit.values()) {
            for(int rank = 1; rank<= 13; rank++){
                cards[i] = new Card(rank,s);
                i++;
            }
        }
    }

    public void print() {
        for(int i = 0; i < this.cards.length; i++) {
            this.cards[i].printCard();
        }
     }
}