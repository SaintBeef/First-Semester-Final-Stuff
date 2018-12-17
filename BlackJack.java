import java.util.*;
import javax.swing.*;
import java.awt.*;

public class BlackJack extends JFrame {
    static Player[] hands = new Player[2];
    static Deck deck = new Deck();
    static String[] playerNames = new String[2];
    static Scanner sb = new Scanner(System.in);
    static int pot;
    static boolean[] isOut = {false, false};

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        System.out.print("Enter the first player's name: ");
        playerNames[0] = sb.next();
        System.out.print("\nEnter the second player's name: ");
        playerNames[1] = sb.next();
        hands[0] = new Player(playerNames[0]); hands[1] = new Player(playerNames[1]);
        game();
    }

    public static void game() {
        pot = 0;
        isOut[0] = false; isOut[1] = false;
        hands[0].clearHand(); hands[1].clearHand();
        betting();
        System.out.println("Current pot: $" + pot + "\nPress enter to begin dealing cards");
        try { System.in.read();
        } catch (Exception e) {}
        mainGame();
        game();
    }

    public static void betting() {
        for (int i = 0; i < hands.length; i++) {
            System.out.print(playerNames[i] + ": " + hands[i].getBalance() + "\nWhat do you want to bet? ");
            int input = sb.nextInt();
            legit:
            while (true) {
                if (input < 1) {
                    System.out.print("Bet cannot be less than 1!\nEnter your bet again: ");
                    input = sb.nextInt();
                }
                if (hands[i].getBalance() <= input) {
                    System.out.print("Bet bigger than balance!\nEnter your bet again: ");
                    input = sb.nextInt();
                }
                else {
                    hands[i].bet(input);
                    pot += input;
                    break legit;
                }
            }
        }
    }

    public static void mainGame() {
        int[] count = {0, 0};
        deck = new Deck(); deck.shuffle();
        while (isOut[0] == false && isOut[1] == false) {
            for (int i = 0; i < hands.length; i++) {
                if (isOut[i] == false) {
                    System.out.print("\n------------------------\n" + playerNames[0] + ": " + count[0] + "\t" + playerNames[1] + ": " + count[1] + "\nPot: $" + pot + "\n------------------------\n1) Be dealt another card\n2) Stop being dealt\n------------------------\nEnter your choice: ");
                    lop:
                    while (true) {
                        int input = sb.nextInt();
                        switch(input) {
                            case 1:
                            hands[i].deal(deck.deal());
                            System.out.println(playerNames[i] + " has been dealt a " + hands[i].getHand().get(hands[i].getHand().size()-1).toString());
                            break lop;
                            case 2:
                            isOut[i] = true;
                            break lop;
                            default:
                            System.out.print("Input not recognized!\nEnter again: ");
                            break;
                        }
                    }
                    count[i] = 0;
                    for (int j = 0; j < hands[i].getHand().size(); j++) {
                        int[] temp = hands[i].getHand().get(j).getData();
                        temp[1] = (temp[1] > 10) ? 10 : temp[1];
                        count[i] += temp[1];
                    }
                    if (count[i] > 21) {
                        System.out.println("\nYou've busted out!");
                        isOut[i] = true;
                    }
                }
            }
        }
        if (count[0] > 21) {
            if (count[1] > 21) {
                System.out.println("\nBoth players busted out!\nRedealing cards");
                mainGame();
            }
            System.out.println(playerNames[0] + " won the round and wins $" + pot + "!");
            hands[0].deposit(pot);
        }
        else if (count[1] > 21) {
            System.out.println(playerNames[1] + " won the round and wins $" + pot + "!");
            hands[1].deposit(pot);
        }
        else if (count[0] == count[1]) {
            System.out.println("Tie, Splitting pot");
            if (pot % 2 == 1) {
                hands[0].deposit((pot-1)/2);
                hands[1].deposit((pot-1)/2);
            }
            else {
                hands[0].deposit(pot/2);
                hands[1].deposit(pot/2);
            }
        }
        else if (count[0] > count[1]) {
            System.out.println(playerNames[0] + " won the round and wins $" + pot + "!");
            hands[0].deposit(pot);
        }
        else if (count[1] > count[0]) {
            System.out.println(playerNames[1] + " won the round and wins $" + pot + "!");
            hands[1].deposit(pot);
        }
        game();
    }
}