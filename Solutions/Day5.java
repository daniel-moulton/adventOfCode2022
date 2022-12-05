import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day5 {
    public static void main(String[] args) throws IOException {
        // puzzle1();
        puzzle2();
    }

    public static void puzzle1() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Inputs/Day5.txt"));
        String line;
        int count = 0;
        int numStacks = 0;
        List<String> list = new ArrayList<>();
        List<Stack<Character>> stackList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            if (line.contains(" 1  ")) {
                System.out.println(line);
                System.out.println("STOP");
                System.out.println(count);
                numStacks = (line.length() + 1) / 4;
                reader.readLine();
                break;
            }
            list.add(line);
        }
        for (int i = 0; i < numStacks; i++) {
            System.out.println("Stack Number: " + (i + 1));
            stackList.add(new Stack<>());
            for (int j = list.size() - 1; j >= 0; j--) {
                if (list.get(j).charAt((i * 4) + 1) != ' ') {
                    stackList.get(i).push(list.get(j).charAt((i * 4) + 1));
                }
            }
        }
        // for (Stack<Character> stack : stackList) {
        // System.out.println(stack);
        // }
        while ((line = reader.readLine()) != null) {
            String[] splitted = line.split("\\s+");
            int numToMove = Integer.parseInt(splitted[1]);
            int fromStack = Integer.parseInt(splitted[3]);
            int toStack = Integer.parseInt(splitted[5]);
            for (int i=numToMove; i>0; i--) {
                stackList.get(toStack-1).push(stackList.get(fromStack-1).pop());
            }
        }
        for (Stack<Character> stack : stackList) {
            System.out.println("Stack: " + stack);
            System.out.println(stack.peek());
        }

    }

    public static void puzzle2() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Inputs/Day5.txt"));
        String line;
        int count = 0;
        int numStacks = 0;
        List<String> list = new ArrayList<>();
        List<Stack<Character>> stackList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            if (line.contains(" 1  ")) {
                System.out.println(line);
                System.out.println("STOP");
                System.out.println(count);
                numStacks = (line.length() + 1) / 4;
                reader.readLine();
                break;
            }
            list.add(line);
        }
        for (int i = 0; i < numStacks; i++) {
            System.out.println("Stack Number: " + (i + 1));
            stackList.add(new Stack<>());
            for (int j = list.size() - 1; j >= 0; j--) {
                if (list.get(j).charAt((i * 4) + 1) != ' ') {
                    stackList.get(i).push(list.get(j).charAt((i * 4) + 1));
                }
            }
        }
        // for (Stack<Character> stack : stackList) {
        // System.out.println(stack);
        // }
        while ((line = reader.readLine()) != null) {
            String[] splitted = line.split("\\s+");
            int numToMove = Integer.parseInt(splitted[1]);
            int fromStack = Integer.parseInt(splitted[3]);
            int toStack = Integer.parseInt(splitted[5]);
            // for (int i=numToMove; i>0; i--) {
            //     stackList.get(toStack-1).push(stackList.get(fromStack-1).pop());
            // }
            if (numToMove==1){
                stackList.get(toStack-1).push(stackList.get(fromStack-1).pop());
            }
            else {
                List<Character> temp = new ArrayList<>(numToMove);
                for (int i=0; i<numToMove; i++){
                    temp.add(stackList.get(fromStack-1).pop());
                }
                for (int i=numToMove-1; i>=0; i--){
                    stackList.get(toStack-1).push(temp.get(i));
                }
            }
        }
        for (Stack<Character> stack : stackList) {
            System.out.println("Stack: " + stack);
            System.out.println(stack.peek());
        }

    }
}
