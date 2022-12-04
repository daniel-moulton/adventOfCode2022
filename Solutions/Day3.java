import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 {
    public static void main(String[] args) throws IOException {
        // puzzle1();
        puzzle2();
    }

    public static void puzzle1() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Inputs/Day3.txt"));
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

    public static void puzzle2() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Inputs/Day3.txt"));
        String line;
        int mid;
        int sum=0;
        List<List<Character>> threeElves = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            List<Character> elf = line.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
            threeElves.add(elf);
            if (threeElves.size()==3){
                List<Character> first = threeElves.get(0);
                List<Character> second = threeElves.get(1);
                List<Character> third = threeElves.get(2);
                first.retainAll(second);
                first.retainAll(third);
                int asciiVal=(int)first.get(0);
                System.out.println("Ascii value: " + asciiVal);
                if (asciiVal>96) {
                    asciiVal-=96;
                }
                else {
                    asciiVal-=38;
                }
                sum+=asciiVal;
                threeElves.clear();
            }
        }
        System.out.println("Puzzle 2: "+sum);
    }
}
