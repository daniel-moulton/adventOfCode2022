import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4 {
    public static void main(String[] args) throws IOException {
        puzzle1();
        puzzle2();
    }

    public static void puzzle1() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Inputs/Day4.txt"));
        String line;
        int count = 0;
        while ((line = reader.readLine()) != null) {
            String[] splitted = line.split(",");
            String[] split1 = splitted[0].split("-");
            String[] split2 = splitted[1].split("-");
            int[] intSplit1 = new int[2];
            int[] intSplit2 = new int[2];
            for (int i = 0; i < split1.length; i++) {
                intSplit1[i] = Integer.parseInt(split1[i]);
                intSplit2[i] = Integer.parseInt(split2[i]);
            }
            if ((intSplit1[0] >= intSplit2[0]) && (intSplit1[1] <= intSplit2[1])) {
                count++;
            } else if ((intSplit2[0] >= intSplit1[0]) && (intSplit2[1] <= intSplit1[1])) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void puzzle2() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Inputs/Day4.txt"));
        String line;
        int count = 0;
        while ((line = reader.readLine()) != null) {
            String[] splitted = line.split(",");
            String[] split1 = splitted[0].split("-");
            String[] split2 = splitted[1].split("-");
            int[] intSplit1 = new int[2];
            int[] intSplit2 = new int[2];
            for (int i = 0; i < split1.length; i++) {
                intSplit1[i] = Integer.parseInt(split1[i]);
                intSplit2[i] = Integer.parseInt(split2[i]);
            }
            if ((intSplit1[0] >= intSplit2[0]) && (intSplit1[1] <= intSplit2[1])) {
                count++;
            } else if ((intSplit2[0] >= intSplit1[0]) && (intSplit2[1] <= intSplit1[1])) {
                count++;
            } else {
                for (int i = 0; i < 2; i++) {
                    if ((intSplit1[i] >= intSplit2[0]) && (intSplit1[i] <= intSplit2[1])) {
                        count++;
                        System.out.println(line);
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
