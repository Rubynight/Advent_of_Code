import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class question7 {
    public static void read() {
        //ArrayList<String> enterinfo = new ArrayList<>();
        String filepath = "C:\\School\\java\\Advent_of_Code\\Reading_stuff\\Q7.txt";
        ArrayList<Integer> entered = new ArrayList<>();

        try {
            //the file to be opened for reading
            FileInputStream fis = new FileInputStream(filepath);
            Scanner sc = new Scanner(fis);    //file to be scanned



            while (sc.hasNextLine()) {
                String init = sc.nextLine();
                String s[] = init.split(",");
                for (int i = 0; i < s.length; i++) {
                    entered.add(Integer.parseInt(s[i]));
                }

            }
            sc.close();     //closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(function(startx, starty, endx, endy, max_x, max_y));
        System.out.println(function(entered));
        return;
    }
    public static int function(ArrayList<Integer> entry) {
        long total = 0;
        for (int i = 0; i < entry.size(); i++) {
            total += entry.get(i);
        }
        Integer[] check = new Integer[entry.size()];
        check = entry.toArray(check);
        System.out.println("last: " + check[check.length - 1]);
        Arrays.sort(check);
        System.out.println("last: " + check[check.length - 1]);
        System.out.println("how many: " + check.length);
        System.out.println("median: " + check[check.length/2]);
        System.out.println("total: " + total);

        int avg = (int)total/entry.size();
        double plusone = total/(double)entry.size();
        System.out.println(plusone);
        /*if (plusone - avg > 0.5) {
            avg++;
        }*/
        System.out.println("average " + avg);
        int result = 0;
        for (int i = 0; i < entry.size(); i++) {
            int value = Math.abs(entry.get(i) - avg);
            if (value % 2 == 0) {
                //System.out.println("even");
                value = (value + 1) * (value / 2);
            } else {
                //System.out.println("odd");
                int temp = value;
                value = (temp + 1) * (temp / 2);
                value += (temp/2 + 1);
            }
            result += value;
            System.out.println("adding value: " + value);
        }
        return result;
    }
}
