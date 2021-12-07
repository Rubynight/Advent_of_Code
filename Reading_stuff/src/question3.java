import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class question3 {
    public static String[] read() {
        ArrayList<String> enterinfo = new ArrayList<>();
        String filepath = "C:\\School\\java\\Reading_stuff\\Q3.txt";
        //ArrayList<Integer> entered = new ArrayList<>();
        try {
            //the file to be opened for reading
            FileInputStream fis = new FileInputStream(filepath);
            Scanner sc = new Scanner(fis);    //file to be scanned
            int x = 0;
            int y = 0;
            //returns true if there is another line to read
            while (sc.hasNextLine()) {
                //String s[] = sc.nextLine().split(" ");
                enterinfo.add(sc.nextLine());
                //entered.add(Integer.parseInt(s[1]));
                //System.out.println(sc.nextLine());      //returns the line that was skipped
            }
            sc.close();     //closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }

        //String s[] = enterinfo.get(0);
        //int a = Integer.parseInt(s[0]);
        //Integer[] test = new Integer[entered.size()];
        //test = entered.toArray(test);
        String[] test = new String[enterinfo.size()];
        test = enterinfo.toArray(test);
        //System.out.println(test[0][1]);
        return test;
    }

    public static int function(String[] entry) {

        int[] count0 = new int[2];


        StringBuilder finalized = new StringBuilder();
        StringBuilder finalized2 = new StringBuilder();
        boolean[] check = new boolean[entry.length];
        boolean removeone = false;
        String[] temp = entry;
        List<String> list = Arrays.asList(temp);
        int count = entry.length;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (check[j]) {
                    continue;
                }
                if (list.get(j).charAt(i) == '0') {
                    count0[0]++;
                }
                if (list.get(j).charAt(i) == '1') {
                    count0[1]++;
                }
            }

            if (count0[0] > count0[1]) {
                finalized.append('0');
                removeone = true;
            } else {
                finalized.append('1');
                removeone = false;
            }
            /*if (count0[0] > count0[1]) {
                finalized.append('1');
                removeone = false;
            } else {
                finalized.append('0');
                removeone = true;
            }*/

            for (int j = 0; j < list.size(); j++) {
                if (removeone && list.get(j).charAt(i) == '1') {
                    check[j] = true;

                } else if (!removeone && list.get(j).charAt(i) == '0') {
                    check[j] = true;

                }
            }
            for (int j = 0; j < list.size(); j++) {
                if (check[j]) {
                    continue;
                }
                System.out.println(list.get(j));
                count++;
            }

            System.out.println("done");
            count0[0] = 0;
            count0[1] = 0;
        }
        System.out.println("more " + finalized);
        //System.out.println("less " + finalized2);
        return 0;

    }
}
