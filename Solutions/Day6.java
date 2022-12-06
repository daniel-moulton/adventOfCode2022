import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Day6 {
    public static void main(String[] args) throws IOException {
        // puzzle1();
        puzzle2();
    }

    public static void puzzle1() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Inputs/Day6.txt"));
        String line = reader.readLine();
        char[] charFile = line.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        Character[] chars = new Character[4];
        for (int i=0; i<charFile.length; i++) {
            for (int j=i; j<i+4; j++) {
                set.add(charFile[j]);
            }
            if (set.size()==4){
                System.out.println("Found 4");
                System.out.println(set);
                System.out.println("i: "+(i+4));
                break;
            }
            else {
                set.clear();
            }
        }
    }

    public static void puzzle2() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Inputs/Day6.txt"));
        String line = reader.readLine();
        char[] charFile = line.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        for (int i=0; i<charFile.length; i++) {
            for (int j=i; j<i+14; j++) {
                set.add(charFile[j]);
            }
            if (set.size()==14){
                System.out.println("Found 14");
                System.out.println(set);
                System.out.println("i: "+(i+14));
                break;
            }
            else {
                set.clear();
            }
        }
    }
}
