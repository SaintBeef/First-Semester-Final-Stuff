public class Card {
    private int suit, value;
    private boolean taken;
    private String face, fsuit;

    public Card(int _Suit, int _Value) {
        suit = _Suit;
        value = _Value;
        taken = false;
        switch(suit) {
            case 0:
                fsuit = "Hearts";
                break;
            case 1:
                fsuit = "Diamonds";
                break;
            case 2:
                fsuit = "Spades";
                break;
            case 3:
                fsuit = "Clubs";
                break;
        }
        switch(value) {
            case 11:
                face = "Jack";
                break;
            case 12:
                face = "Queen";
                break;
            case 13:
                face = "King";
                break;
            case 14:
                face = "Ace";
                break;
            default:
                face = Integer.toString(value);
                break;
        }
    }

    public boolean takeCard() {
        if (taken == false) {
            taken = true;
            return true;
        }
        else
            return false;
    }

    public void returnCard() {
        taken = false;
    }
    
    public String toString() {
        return face + " of " + fsuit;
    }
}