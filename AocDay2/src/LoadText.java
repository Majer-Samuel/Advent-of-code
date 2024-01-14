import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Pattern;

public class LoadText {

    public static BufferedReader laodText () throws FileNotFoundException {
        return new BufferedReader(new FileReader(".idea/D2"));
    }

    public static Pattern Pattern (){
        Pattern pattern = Pattern.compile("(\\d+) (\\w+)");
        return pattern;
    }
}
