import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {
    public static void main(String args[]) {
        //Integer[] test = read();
        //System.out.println(helper(test));

        question7 q7 = new question7();
        q7.read();
        //System.out.println(q4.function(entry));

    }

    public static Integer[] read() {
        //ArrayList<String[]> enterinfo = new ArrayList<String[]>();
        String filepath = "C:\\School\\java\\Reading_stuff\\Demo.txt";
        ArrayList<Integer> entered = new ArrayList<>();
        try {
            //the file to be opened for reading
            //Testing if push works
            FileInputStream fis = new FileInputStream(filepath);
            Scanner sc = new Scanner(fis);    //file to be scanned
            int x = 0;
            int y = 0;
            //returns true if there is another line to read
            while (sc.hasNextLine()) {
                //String s[] = sc.nextLine().split(" ");
                //enterinfo.add(s);
                entered.add(Integer.parseInt(sc.nextLine()));
                //System.out.println(sc.nextLine());      //returns the line that was skipped
            }
            sc.close();     //closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }

        //String s[] = enterinfo.get(0);
        //int a = Integer.parseInt(s[0]);
        Integer[] test = new Integer[entered.size()];
        test = entered.toArray(test);
        return test;
    }
    public static int helper(Integer[] entry) {
        int prev = entry[0] + entry[1] + entry[2];
        int count = 0;
        for (int i = 3; i < entry.length; i++) {
            int val = prev + entry[i] - entry[i-3];
            if (val > prev) {
                count++;
            }
            prev = val;
        }
        return count;
    }
}
