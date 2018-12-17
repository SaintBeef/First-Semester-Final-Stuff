import java.util.*;

public class Deck {
    private ArrayList<Card> doc = new ArrayList();
    private int cardsleft;

    public Deck() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++)
                doc.add(new Card(j, i+2));
        }
        cardsleft = 52;
    }

    public void shuffle() {
        for (int j = 0; j < 3; j++) {
            ArrayList<Card> temp = new ArrayList();
            for (int i = 0; i < cardsleft; i++) {
                int r = (int)(Math.random()*(cardsleft-(1+i)));
                Card temp0 = doc.get(r);
                doc.remove(r);
                temp.add(temp0);
            }
            doc = temp;
        }
    }

    public String dealEntireDeck() {
        String out = "";
        if (cardsleft == 0)
            return "There are no cards left!";
        for (int i = cardsleft-1; 0 <= i; i--) {
            Card temp = doc.get(i);
            out = out + "\n" + temp.toString();
            cardsleft--;
        }
        return out;
    }

    public int countCards() {
        return cardsleft;
    }

    public String dealCards(int n) {
        String out = "";
        if (cardsleft < n)
            return "That's more than the cards left in the deck!";
        for (int i = n; 0 < i; i--) {
            Card temp = doc.get(cardsleft-1);
            out = out + "\n" + temp.toString();
            cardsleft--;
        }
        return out;
    }
    
    public Card deal() {
        Card temp = doc.get(cardsleft-1);
        cardsleft--;
        return temp;
    }
}