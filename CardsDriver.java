import java.util.*;

public class CardsDriver {
    static Deck vdeck;
    static String first;
    static Scanner sb = new Scanner(System.in);

    public static void main(String[] args) {
        first = "1) Make a new deck*Do this first*";
        dispatch();
    }

    public static void dispatch() {
        int input = -1;
        System.out.println("\n----------------------------------\n" + first + "\n2) Shuffle the deck\n3) Deal the rest of the deck\n4) Deal a certain amount of cards\n5) Shows the cards left\n6) Quit\n----------------------------------");
        while(vdeck == null) {
            input = sb.nextInt();
            if(input == 1) {
                vdeck = new Deck();
                first = "1) Remake the deck";
                dispatch();
            }
            System.out.println("\nYou need to make the new desk first!");
        }
        input = sb.nextInt();
        switch(input) {
            case 1:
                vdeck = new Deck();
                break;
            case 2:
                vdeck.shuffle();
                break;
            case 3:
                System.out.println(vdeck.dealEntireDeck());
                break;
            case 4:
                System.out.print("How many cards you want to deal: ");
                input = sb.nextInt();
                System.out.println(vdeck.dealCards(input));
                break;
            case 5:
                System.out.println("You have " + vdeck.countCards() + " cards left");
                break;
            case 6:
                System.exit(0);
                break;
        }
        dispatch();
    }
}