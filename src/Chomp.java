import java.util.ArrayList;
import java.util.Arrays;

class Chomp {

    ArrayList<Integer[]> specialList = new ArrayList<Integer[]>();
    ArrayList<Integer[]> list = new ArrayList<Integer[]>();
    ArrayList<Integer[]> subList = new ArrayList<Integer[]>();

    public static void main(String[] args) {
        Chomp ex = new Chomp();
    }

    public Chomp() {

        //makes the lists that equal a loss
        specialList.add(new Integer[]{1, 0, 0});

        //makes the main list from 100 to 333
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= j; k++) {
                    list.add(new Integer[]{i, j, k});
                }
            }
        }

        //makes the legal, possible sublists of the main list
        //checks which list makes a special list and adds it to the sublist, which is the winning list
        for (int i = 0; i < list.size(); i++) {
            for (int m = 0; m <= list.get(i)[0]; m++) {
                for (int j = 0; j <= m && j <= list.get(i)[1]; j++) {
                    for (int k = 0; k <= j && k <= list.get(i)[2]; k++) {
                        if ((m < list.get(i)[0]
                                || j < list.get(i)[1]
                                || k < list.get(i)[2])
                                && (m == list.get(i)[0]
                                || j == k
                                || j == m)
                                && (m >= list.get(i)[0] - (list.get(i)[0] - 1))) {
                            if (((m < list.get(i)[0] && j == 0 && k == 0)
                                    || (m < list.get(i)[0]
                                    && k != list.get(i)[2])
                                    || (m <= list.get(i)[0]
                                    && k < list.get(i)[2]
                                    && j < list.get(i)[1]
                                    && m > 1))
                                    && ((list.get(i)[1] != 0
                                    || list.get(i)[2] != 0))) {
                            } else {
                                subList.add(new Integer[]{m, j, k});
                                subList.add(new Integer[]{i, i, i});
                                for (int f = 0; f < specialList.size(); f++) {
                                    if (m == specialList.get(f)[0]
                                            && j == specialList.get(f)[1]
                                            && k == specialList.get(f)[2]
                                            && specialList.contains(list.get(i)) == false) {
                                        specialList.add(list.get(i));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            //System.out.println(Arrays.toString(list.get(i)));
        }

        for (int i = 0; i < subList.size(); i++) {
            //System.out.println(Arrays.toString(subList.get(i)));
        }

        for (int i = 0; i < specialList.size(); i++) {
            //System.out.println(Arrays.toString(specialList.get(i)));
        }
    }

}