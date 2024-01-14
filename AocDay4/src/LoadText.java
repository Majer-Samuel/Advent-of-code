import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LoadText {

    public static BufferedReader laodText () throws FileNotFoundException {
        return new BufferedReader(new FileReader(".idea/D4.txt"));
    }
}
