import java.util.*;

public class Box {
    int l, w, h, vol, surfa;
    
    public Box(int _L, int _W, int _H) {
        l = _L;
        w = _W;
        h = _H;
        vol = l*h*w;
        surfa = (2*l*w)+(2*l*h)+(2*w*h);
    }
    
    public int getVolume() {
        return vol;
    }
    
    public int getSA() {
        return surfa;
    }
    
    public String toString() {
        return "\tLength: " + l + "\n\tHeight: " + h + "\n\tWidth: " + w + "\n\tSurface Area: " + surfa + "\n\tVolume: " + vol;
    }
}