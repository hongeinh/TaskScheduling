import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        NSGAImproved nsga = new NSGAImproved();
        nsga.execute();
    }
}
