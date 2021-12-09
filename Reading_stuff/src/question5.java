

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class question5 {
    public static void read() {
        //ArrayList<String> enterinfo = new ArrayList<>();
        String filepath = "C:\\School\\java\\Advent_of_Code\\Reading_stuff\\Q5.txt";
        String[] drawn = null;
        ArrayList<Integer> startx = new ArrayList<>();
        ArrayList<Integer> starty = new ArrayList<>();
        ArrayList<Integer> endx = new ArrayList<>();
        ArrayList<Integer> endy = new ArrayList<>();
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
                String s[] = init.split("->");
                //System.out.println(s[0]);
                if (init.equals("")) {
                    //System.out.println("here");
                    continue;
                }

                //System.out.println(s[1]);
                //enterinfo.add(sc.nextLine());
                String split[] = s[0].split(",");
                System.out.println(Integer.parseInt(split[0]));
                startx.add(Integer.parseInt(split[0]));
                if (max_x < Integer.parseInt(split[0])) {
                    max_x = Integer.parseInt(split[0]);
                }
                split[1] = split[1].replaceAll("\\s+","");
                System.out.println(Integer.parseInt(split[1]));
                starty.add(Integer.parseInt(split[1]));
                if (max_y < Integer.parseInt(split[1])) {
                    max_y = Integer.parseInt(split[1]);
                }
                String endsplit[] = s[1].split(",");
                endsplit[0] = endsplit[0].replaceAll("\\s+","");
                endx.add(Integer.parseInt(endsplit[0]));
                System.out.println(Integer.parseInt(endsplit[0]));
                if (max_x < Integer.parseInt(endsplit[0])) {
                    max_x = Integer.parseInt(endsplit[0]);
                }
                endsplit[1] = endsplit[1].replaceAll("\\s+","");
                endy.add(Integer.parseInt(endsplit[1]));
                System.out.println(Integer.parseInt(endsplit[1]));
                if (max_y < Integer.parseInt(endsplit[1])) {
                    max_y = Integer.parseInt(endsplit[1]);
                }


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

        //Integer[] test = new Integer[entered.size()];
        //test = entered.toArray(test);
        //System.out.println(function(drawed_nums, list));
        //System.out.println(count);
        //System.out.println(test[0][1]);

        System.out.println("max: " + max_x);
        System.out.println("max: " + max_y);
        System.out.println(function(startx, starty, endx, endy, max_x, max_y));

        return;
    }

    public static int function(ArrayList<Integer> startx, ArrayList<Integer> starty, ArrayList<Integer> endx, ArrayList<Integer> endy, int max_x, int max_y) {
        int[][] tracker = new int[max_x+1][max_y+1];
        int max = 0;
        int temp = 0;

        for (int i = 0; i < startx.size(); i++) {
            if (startx.get(i).equals(endx.get(i))) {
                int diff = 0;
                if (starty.get(i).equals(endy.get(i)) ) {
                    continue;
                }
                int start = Math.min(starty.get(i), endy.get(i));
                diff = Math.abs(starty.get(i) - endy.get(i));
                for (int j = start; j <= Math.max(starty.get(i), endy.get(i)); j++) {
                    tracker[startx.get(i)][j] += 1;
                    if (tracker[startx.get(i)][j] >= 2) {
                        temp++;
                    }
                }
                System.out.println("diff y: start y " + starty.get(i) + " end y " + endy.get(i) + " diff " + diff);
            } else if (starty.get(i).equals(endy.get(i))) {
                int diff = 0;
                int start = Math.min(startx.get(i), endx.get(i));
                diff = Math.abs(startx.get(i) - endx.get(i));
                for (int j = start; j <= Math.max(startx.get(i), endx.get(i)); j++) {
                    tracker[j][starty.get(i)] += 1;
                    if (tracker[j][starty.get(i)] >= 2) {
                        temp++;
                    }
                }
                System.out.println("diff x " + diff);

            } else {

                int directionx = 0;
                int directiony = 0;
                if (startx.get(i) > endx.get(i)) {
                    directionx = -1;
                } else {
                    directionx = 1;
                }
                if (starty.get(i) > endy.get(i)) {
                    directiony = -1;
                } else {
                    directiony = 1;
                }



                int diff = Math.abs(startx.get(i) - endx.get(i));
                for (int j = 0; j <= diff; j++) {

                    tracker[startx.get(i) + (directionx * j)][starty.get(i) + (directiony * j)] += 1;
                    if (tracker[j][starty.get(i)] >= 2) {
                        temp++;
                    }
                }
                System.out.println("diff dia: start y " + starty.get(i) + " end y " + endy.get(i) + " diff " + diff);
            }
        }
        System.out.println("temp: " + temp);
        //System.out.println(max);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max_y+1; i++) {
            for (int j = 0; j < max_x+1; j++) {
                sb.append(tracker[j][i]);
                if (tracker[j][i] >= 2) {
                    count++;
                    //System.out.println(tracker[j][i]);

                }
            }

            System.out.println(sb);
            sb = new StringBuilder();
        }
        return count;
    }

}

