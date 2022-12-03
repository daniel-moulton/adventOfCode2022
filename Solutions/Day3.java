import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 {
    public static void main(String[] args) throws IOException {
        puzzle1();
        // puzzle2();
    }

    public static void puzzle1() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Inputs/rucksacks.txt"));
        String line;
        int mid;
        int sum=0;
        while ((line = reader.readLine()) != null) {
            mid = line.length()/2;
            String[] split = {line.substring(0,mid),line.substring(mid)};
            List<Character> first = split[0].chars().mapToObj(e -> (char)e).collect(Collectors.toList());
            List<Character> second = split[1].chars().mapToObj(e -> (char)e).collect(Collectors.toList());
            first.retainAll(second);
            int asciiVal=(int)first.get(0);
            System.out.println("Ascii value: " + asciiVal);
            if (asciiVal>96) {
                asciiVal-=96;
            }
            else {
                asciiVal-=38;
            }
            sum+=asciiVal;
        }
        System.out.println("Puzzle 1: "+sum);
    }
}
