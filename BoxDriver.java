import java.util.*;

public class BoxDriver {
    public static void main(String[] args) {
        ArrayList<Box> breg = new ArrayList();
        Scanner sb = new Scanner(System.in);
        int l, w, h;
        int biggest = 0;
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter the parameters for Box " + (i+1));
            System.out.print("\tEnter the length: ");
            l = sb.nextInt();
            System.out.print("\tEnter the width: ");
            w = sb.nextInt();
            System.out.print("\tEnter the height: ");
            h = sb.nextInt();
            breg.add(new Box(l, w, h));
        }
        for (int i = 0; i < breg.size(); i++) {
            System.out.println("Box " + (i+1) + ":\n" + breg.get(i).toString());
            if (breg.get(biggest).getVolume() < breg.get(i).getVolume())
                biggest = i;
        }
        System.out.println("Box " + (biggest+1) + " can hold more stuff.");
    }
}