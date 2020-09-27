package Taezhnik;

import java.util.ArrayList;

public class Combinations {
    private static int[] generComb(int[] arr, int m, int n) {
        if (arr == null) {
            arr = new int[m];
            for (int i = 0; i < m; i++)
                arr[i] = i + 1;
            return arr;
        }
        for (int i = m - 1; i >= 0; i--)
            if (arr[i] < n - m + i + 1) {
                arr[i]++;
                for (int j = i; j < m - 1; j++)
                    arr[j + 1] = arr[j] + 1;
                return arr;
            }
        return null;
    }

    public static ArrayList<int[]> getComb(int m, int n) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        int[] arr = null;

        while ((arr = generComb(arr, m, n)) != null) {
            int[] array_return = new int[m];

            for (int i = 0; i < m; i++) {
                array_return[i] = arr[i];
            }
            arrayList.add(array_return);
        }

        /*System.out.println();
        for(int i=0; i<arrayList.size(); i++){
            System.out.println(Arrays.toString(arrayList.get(i)));
        }*/
        return arrayList;
    }

    // ArrayList<String>
    /*public static void createAllPermutations(ArrayList<String> array_idx) {
        ArrayList<String> all_permutations = new ArrayList<>();

        int len_array = array_idx.size();
        int count_permutation = 0;
        for (int i = 0; i < len_array; i++) {

            ArrayList<int[]> array_idx_permutations = getComb(i + 1, len_array);
            count_permutation = array_idx_permutations.size();
            //for (int f = 0; f < array_idx_permutations.size(); f++) {
            //   System.out.println(Arrays.toString(array_idx_permutations.get(f)));
            //}

            //System.out.println(count_permutation);
            for (int j = 0; j < count_permutation; j++) {
                String permutation = "";
                for (int k = 0; k != i+1; k++) {
                    permutation += array_idx.get(array_idx_permutations.get(j)[k]-1);
                }
                //System.out.println(permutation);
                all_permutations.add(permutation);
            }
        }

        //for (int f = 0; f < all_permutations.size(); f++) {
        //   System.out.println(all_permutations.get(f));
        //}

        //return all_permutations;
    }
    */

    public static ArrayList<ArrayList<String>> createAllPermutations(ArrayList<String>... arrays_idx) {
        ArrayList<ArrayList<String>> return_permutations = new ArrayList<>();
        for (int a = 0; a < arrays_idx.length; a++) {
            ArrayList<String> array_idx = arrays_idx[a];
            ArrayList<String> all_permutations = new ArrayList<>();

            int len_array = array_idx.size();
            int count_permutation = 0;
            for (int i = 0; i < len_array; i++) {

                ArrayList<int[]> array_idx_permutations = getComb(i + 1, len_array);
                count_permutation = array_idx_permutations.size();

                for (int j = 0; j < count_permutation; j++) {
                    String permutation = "";
                    for (int k = 0; k != i + 1; k++) {
                        permutation += array_idx.get(array_idx_permutations.get(j)[k] - 1);
                    }

                    all_permutations.add(permutation);
                }
            }
            return_permutations.add(all_permutations);
        }
        /*for (int f = 0; f < return_permutations.size(); f++) {
            for (int k = 0; k < return_permutations.get(f).size(); k++) {
                System.out.println(return_permutations.get(f).get(k));
            }
        }*/

        return return_permutations;
    }
}






/*for (int f = 0; f < array_idx_permutations.size(); f++) {
   System.out.println(Arrays.toString(array_idx_permutations.get(f)));
}*/

/*for (int f = 0; f < all_permutations.size(); f++) {
               System.out.println(all_permutations.get(f));
            }
            return_permutations.add(all_permutations);*/