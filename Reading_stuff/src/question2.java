import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class question2 {
    public static String[][] read() {
        ArrayList<String[]> enterinfo = new ArrayList<String[]>();
        String filepath = "C:\\School\\java\\Reading_stuff\\Q2.txt";
        //ArrayList<Integer> entered = new ArrayList<>();
        try {
            //the file to be opened for reading
            FileInputStream fis = new FileInputStream(filepath);
            Scanner sc = new Scanner(fis);    //file to be scanned
            int x = 0;
            int y = 0;
            //returns true if there is another line to read
            while (sc.hasNextLine()) {
                String s[] = sc.nextLine().split(" ");
                enterinfo.add(s);
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
        String[][] test = new String[enterinfo.size()][2];
        test = enterinfo.toArray(test);
        //System.out.println(test[0][1]);
        return test;
    }

    public static int function(String[][] entry) {
        int forward = 0;
        int depth = 0;
        int aim = 0;
        for (int i = 0; i < entry.length; i++) {
            if (entry[i][0].equals("forward") ) {
                forward += Integer.parseInt(entry[i][1]);
                depth += (aim *  Integer.parseInt(entry[i][1]));
            } else if (entry[i][0].equals("down")) {
                //depth += Integer.parseInt(entry[i][1]);
                aim += Integer.parseInt(entry[i][1]);
            } else if (entry[i][0].equals("up")) {
                //depth -= Integer.parseInt(entry[i][1]);
                aim -= Integer.parseInt(entry[i][1]);
            } else {
                System.out.println("Can't read this shit");
            }
        }

        return forward * depth;
    }
}
