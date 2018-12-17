import java.util.*;

public class Player {
    private ArrayList<Card> hand = new ArrayList();
    private String name;
    private int balance;
    
    public Player(String _Name) {
        name = _Name;
        balance = 50;
    }
    
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public void deal(ArrayList<Card> dealt) {
        for (int i = 0; i < dealt.size(); i++)
            hand.add(dealt.get(i));
    }
    
    public void deal(Card dealt) {
        hand.add(dealt);
    }
    
    public void clearHand() {
        hand = new ArrayList();
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void bet(int b) {
        balance -= b;
    }
    
    public void deposit(int d) {
        balance += d;
    }
    
    public int[][] getHandData() {
        int[][] temp = new int[2][hand.size()];
        for (int i = 0; i < hand.size(); i++) {
            int[] temp0 = hand.get(i).getData();
            temp[0][i] = temp0[0];
            temp[1][i] = temp0[1];
        }
        return temp;
    }
}