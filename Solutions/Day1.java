import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Day1
 */
public class Day1 {

    public static void main(String[] args) throws IOException {
        puzzle1();
        puzzle2();
    }

    public static void puzzle1() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Inputs/Calories.txt"));
        String line;
        int elfCalories=0;
        int biggest=-1;
        while ((line=reader.readLine()) != null){
            if (line.isEmpty()) {
                if (elfCalories>biggest) {
                    biggest=elfCalories;
                }
                elfCalories=0;
            }
            else {
                elfCalories+=Integer.parseInt(line);
            }
        }
        System.out.println(biggest);
    }

    public static void puzzle2() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Inputs/Calories.txt"));
        String line;
        int elfCalories=0;
        int[] biggest = new int[3];
        while ((line=reader.readLine()) != null){
            if (line.isEmpty()) {
                for (int i=0; i<biggest.length; i++) {
                    if (elfCalories>biggest[i]) {
                        for (int j=biggest.length-1; j>i; j--) {
                            biggest[j]=biggest[j-1];
                        }
                        biggest[i]=elfCalories;
                        break;
                    }
                }
                elfCalories=0;
            }
            else {
                elfCalories+=Integer.parseInt(line);
            }
        }
        int value=0;
        for ( int num : biggest) {
            value+=num;
        }
        System.out.println(value);
    }
}