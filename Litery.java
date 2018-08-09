package litery;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Animka
 */
public class Litery {

    /**
     *
     * @param args
     * @throws java.io.FileNotFoundException
     */
    static final int lettersInAlphabeth = 26;

    private static ArrayList<ArrayList<Integer>> toArrayList(int n, char[] array) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < lettersInAlphabeth; i++) {
            result.add(new ArrayList());
        }
        for (int i = n - 1; i >= 0; --i) {
            result.get(Integer.valueOf(array[i]) - 65).add(i);
        }
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        double startTime = System.currentTimeMillis();
        FileOperations fileOp = new FileOperations("lit.in");
        int numberOfLetters = fileOp.getNumberOfLetters();
        char[] jasSurname = fileOp.getJasSurname();
        char[] malgosiaSurname = fileOp.getMalgosiaSurname();

        ArrayList<ArrayList<Integer>> jasSeries = toArrayList(numberOfLetters, jasSurname);
        ArrayList<ArrayList<Integer>> malgosiaSeries = toArrayList(numberOfLetters, malgosiaSurname);
        int[] series = new int[numberOfLetters];
        int jasSeriesLength=jasSeries.size();
        for (int i = 0; i < jasSeriesLength; i++) {
            for (int j = 0; j < malgosiaSeries.get(i).size(); j++) {
                series[jasSeries.get(i).get(j)] = malgosiaSeries.get(i).get(j);
            }
        }
        MergeSort mergeSort=new MergeSort();
        mergeSort.mergeSort(series, 0, numberOfLetters-1);
        fileOp.setResult(mergeSort.getResult());
        fileOp.saveResult("lit.out");
        double timePassed = System.currentTimeMillis() - startTime;
        System.out.println(timePassed / 1000);
    }

}
