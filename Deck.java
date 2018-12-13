import java.util.*;

public class Deck {
    private ArrayList<Card> doc = new ArrayList();
    private int cardsleft;

    public Deck() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 4; j++)
                doc.add(new Card(j, i+2));
        }
        cardsleft = 52;
        shuffle();
    }

    public void shuffle() {
        boolean[] reg = new boolean[52];
        int pos = 0;
        Card temp;
        for (int i = 0; i < cardsleft; i++) {
            pos = (int)Math.random()*(52-i)+(1+i);
            while (reg[pos] == true)
                pos = (int)Math.random()*52+1;
            temp = doc.get(pos);
            doc.set(pos, doc.get(i));
            doc.set(i, temp);
        }
    }

    public String dealEntireDeck() {
        String out = "";
        for (int i = 0; i < cardsleft; i++)
            out = out + "\n" + doc.get(i).toString();
        cardsleft = 0;
        return out;
    }
}