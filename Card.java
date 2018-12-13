public class Card {
  private int suit, value;
  private boolean taken;
  
  public Card(int _Suit, int _Value) {
    suit = _Suit;
    value = _Value;
    taken = false;
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
}