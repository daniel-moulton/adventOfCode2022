import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day2 {
    public static void main(String[] args) throws IOException {
        puzzle1();
        puzzle2();
    }

    public static void puzzle1() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Inputs/rps.txt"));
        String line;
        int score = 0;
        String[] splitted;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            } else {
                splitted = line.trim().split(" ");
                splitted[1] = replaced(splitted[1]);
                if (splitted[1].equals("A")) {
                    score += 1;
                } else if (splitted[1].equals("B")) {
                    score += 2;
                } else {
                    score += 3;
                }
                if (splitted[0].equals(splitted[1])) {
                    score += 3;
                } else if ((splitted[1].equals("A") && splitted[0].equals("C"))
                        || (splitted[1].equals("B") && splitted[0].equals("A"))
                        || splitted[1].equals("C") && splitted[0].equals("B")) {
                    score += 6;
                }
            }
        }
        System.out.println(score);
    }

    public static String replaced(String input) {
        switch (input) {
            case "X":
                return "A";
            case "Y":
                return "B";
            case "Z":
                return "C";
            default:
                return "D";
        }
    }

    public static void puzzle2() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Inputs/rps.txt"));
        String line;
        int score = 0;
        String[] splitted;
        int winLoseDraw=-2; // 1=win, -1=lose, 0=draw
        String reply;

        HashMap<String, String> win = new HashMap<String, String>();
        HashMap<String, String> lose = new HashMap<String, String>();
        HashMap<String, Integer> points = new HashMap<String, Integer>();

        win.put("A", "B");
        win.put("B", "C");
        win.put("C", "A");
        lose.put("A", "C");
        lose.put("B", "A");
        lose.put("C", "B");
        points.put("A",1);
        points.put("B",2);
        points.put("C",3);

        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            } else {
                splitted = line.trim().split(" ");
                switch (splitted[1]) {
                    case "X":
                        score += 0;
                        winLoseDraw=-1;
                        break;
                    case "Y":
                        score += 3;
                        winLoseDraw=0;
                        break;
                    case "Z":
                        score += 6;
                        winLoseDraw=1;
                        break;
                    default:
                        splitted[1] = "D";
                        break;
                }
                if (winLoseDraw==1) {
                    reply=win.get(splitted[0]);
                }
                else if (winLoseDraw==-1){
                    reply=lose.get(splitted[0]);
                }
                else {
                    reply=splitted[0];
                }
                score+=points.get(reply);
            }
        }
        System.out.println(score);
    }
}
