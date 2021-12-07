import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class question4 {
    public static void read() {
        //ArrayList<String> enterinfo = new ArrayList<>();
        String filepath = "C:\\School\\java\\Reading_stuff\\Q4.txt";
        String[] drawn = null;
        ArrayList<Integer> entered = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        //int count = 0;
        try {
            //the file to be opened for reading
            FileInputStream fis = new FileInputStream(filepath);
            Scanner sc = new Scanner(fis);    //file to be scanned
            int x = 0;
            int y = 0;
            drawn = sc.nextLine().split(",");
            //System.out.println(drawn[2]);
            //returns true if there is another line to read
            int count = 0;
            while (sc.hasNextLine()) {
                String init = sc.nextLine();
                if (init.equals("")) {
                    //System.out.println("here");
                    continue;
                }
                String s[] = init.split(" ");
                //System.out.println(s[1]);
                //enterinfo.add(sc.nextLine());
                count++;
                for (int i = 0; i < s.length; i++) {
                    if (s[i].equals("")) {
                        continue;
                    }
                    entered.add(Integer.parseInt(s[i]));
                    //System.out.println(s[i]);
                }
                if (count == 5) {
                    list.add(entered);
                    count = 0;
                    entered = new ArrayList<>();
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
        int[] drawed_nums = new int[drawn.length];
        for (int i = 0; i < drawn.length; i++) {
            drawed_nums[i] = Integer.parseInt(drawn[i]);
        }
        Integer[] test = new Integer[entered.size()];
        test = entered.toArray(test);
        System.out.println(function(drawed_nums, list));
        //System.out.println(count);
        //System.out.println(test[0][1]);

        return;
    }

    static class Node {
        int tablenum, index;

        Node(int i, int j) {
            this.tablenum = i;
            this.index = j;
        }
    }

    static class ColorRow {
        int tablenum;
        boolean check;
        int row_col;

        ColorRow(int i, boolean j, int k) {
            this.tablenum = i;
            this.check = j;
            this.row_col = k;
        }
    }

    public static int function(int[] drawn, ArrayList<ArrayList<Integer>> entry) {
        boolean[][][] check = new boolean[entry.size()][5][5];
        HashMap<Integer, List<Node>> hashMap = new HashMap<>();
        for (int i = 0; i < entry.size(); i++) {
            for (int j = 0; j < entry.get(i).size(); j++) {
                List<Node> list = new ArrayList<>();
                if (hashMap.containsKey(entry.get(i).get(j))) {
                    list = hashMap.get(entry.get(i).get(j));
                }
                Node node = new Node(i, j);
                list.add(node);
                hashMap.put(entry.get(i).get(j), list);
            }
        }
        int count = 0;
        int total = 0;
        List<Integer> done = new LinkedList<>();
        for (int i = 0; i < drawn.length; i++) {
            if (hashMap.containsKey(drawn[i])) {
                List<Node> list = hashMap.get(drawn[i]);
                for (int j = 0; j < list.size(); j++) {
                    int calc_x = list.get(j).index / 5;
                    int calc_y = list.get(j).index % 5;
                    check[list.get(j).tablenum][calc_x][calc_y] = true;
                }
            }

            count++;
            boolean donecheck = true;
            if (count >= 5) {
                while (donecheck) {
                    ColorRow result = helperchq(check, done);
                    donecheck = false;
                    if (result != null && !done.contains(result.tablenum)) {
                        int spacing = 0;
                        StringBuilder sb_array = new StringBuilder();
                        for (int j = 0; j < entry.get(result.tablenum).size(); j++) {
                            sb_array.append(entry.get(result.tablenum).get(j) + " ");
                            spacing++;
                            if (spacing == 5) {
                                System.out.println(sb_array);
                                sb_array = new StringBuilder();
                                spacing = 0;
                            }
                        }

                        int sum = 0;
                        for (int j = 0; j < 5; j++) {
                            StringBuilder sb = new StringBuilder();
                            for (int k = 0; k < 5; k++) {
                                if (check[result.tablenum][j][k]) {
                                    sb.append("x ");
                                } else {
                                    sb.append("o ");
                                    sum += entry.get(result.tablenum).get(j * 5 + k);
                                }
                            }
                            System.out.println(sb);
                            sb = new StringBuilder();
                        }
                        System.out.println(sum);
                        System.out.println(drawn[i]);
                        System.out.println(sum * drawn[i]);
                        done.add(result.tablenum);
                        donecheck = true;
                        //System.out.println(result.tablenum);
                        //System.out.println(entry.get(result.tablenum));
                        //return -1;
                    }

                }
            }
        }
        return 0;
    }

    public static ColorRow helperchq(boolean[][][] entry, List<Integer> visited) {
        for (int i = 0; i < entry.length; i++) {
            for (int j = 0; j < entry[i].length; j++) {
                for (int k = 0; k < entry[i].length; k++) {
                    if (!entry[i][j][k]) {
                        break;
                    }
                    if (k == entry[i].length - 1 && !visited.contains(i)) {
                        ColorRow result = new ColorRow(i, false, j);
                        return result;
                    }
                }
            }
            for (int j = 0; j < entry[i].length; j++) {
                for (int k = 0; k < entry[i].length; k++) {
                    if (!entry[i][k][j]) {
                        break;
                    }
                    if (k == entry[i].length - 1 && !visited.contains(i)) {
                        ColorRow result = new ColorRow(i, true, j);
                        return result;
                    }
                }
            }
        }
        return null;
    }
}
