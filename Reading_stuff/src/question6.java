import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class question6 {
    public static void read() {
        //ArrayList<String> enterinfo = new ArrayList<>();
        String filepath = "C:\\School\\java\\Advent_of_Code\\Reading_stuff\\Q6.txt";
        String[] drawn = null;
        ArrayList<Integer> entered = new ArrayList<>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int max_x = 0;
        int max_y = 0;
        //int count = 0;
        try {
            //the file to be opened for reading
            FileInputStream fis = new FileInputStream(filepath);
            Scanner sc = new Scanner(fis);    //file to be scanned
            int x = 0;
            int y = 0;
            //drawn = sc.nextLine().split("->");
            //System.out.println(drawn[2]);
            //returns true if there is another line to read
            int count = 0;
            while (sc.hasNextLine()) {
                String init = sc.nextLine();
                String s[] = init.split(",");
                //System.out.println(s[0]);
                for (int i = 0; i < s.length; i++) {
                    entered.add(Integer.parseInt(s[i]));
                }

                //entered.add(Integer.parseInt(s[1]));
                //System.out.println(sc.nextLine());      //returns the line that was skipped
            }
            sc.close();     //closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(function(startx, starty, endx, endy, max_x, max_y));
        System.out.println(function(entered, 256));
        return;
    }
    public static long function(ArrayList<Integer> entry, int days) {
        StringBuilder sb = new StringBuilder();
        long[] tracker = new long[9];
        int over = 0;
        for (int i = 0; i < entry.size(); i++) {
            tracker[entry.get(i)]++;
        }
        for (int i = 0; i < days; i++) {
            long prev = tracker[8];
            for (int j = 7; j > 0; j--) {
                long temp = tracker[j];
                tracker[j] = prev;
                prev = temp;
            }
            tracker[8] = tracker[0];
            tracker[6] += tracker[0];
            tracker[0] = prev;
        }
        System.out.println(Integer.MAX_VALUE);
        long count = 0;
        for (int i = 0; i < tracker.length; i++) {
            count += tracker[i];
            System.out.println(tracker[i]);
        }
        return count;
        //Part 1
        /*
        for (int j = 0; j < days; j++) {
            int count = 0;
            for (int i = 0; i < entry.size(); i++) {
                if (entry.get(i) == 0) {
                    //do something
                    count++;
                    entry.set(i, 6);
                } else {
                    entry.set(i, entry.get(i) - 1);
                }

            }
            for (int i = 0; i < count; i++) {
                entry.add(8);
            }

            System.out.println("day " + (j+1) + ": " + entry.size());
        }*/

        //return entry.size();
    }
}
