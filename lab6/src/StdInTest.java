import java.util.Scanner;

public class StdInTest {
    public static void main(String[] args) {
        Scanner lineScanner = new Scanner(System.in);
        while (lineScanner.hasNextLine()) {
            String line = lineScanner.nextLine();
            if (line.isEmpty()) {
                break;
            } else {
                Scanner strScnner = new Scanner(line);
                while (strScnner.hasNextLine()) {
                    System.out.println(strScnner.next());
                }
                strScnner.close();
            }
        }
        lineScanner.close();
    }
}
