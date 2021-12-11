import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class kopokopoTx
{
    static String line = "";
    static String splitBy = ",";
    static String file = "test_data/transaction_data_1.csv";
    static String file1 = "test_data/transaction_data_2.csv";
    static String file2 = "test_data/transaction_data_3.csv";
    int n = 1;
    public static void main(String[] args) throws IOException
    {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            ArrayList<String> company = new ArrayList<String>();
            // read items from csv file and store them in a list
            List<List<String>> company = new ArrayList<>();
            String companyId = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(splitBy);
                company.add(Arrays.asList(values));
            }
//    convert list to string array
            String[] array = company.stream()
                            .map(String::valueOf)
                        .toArray(String[]::new);

            int size = array.length;
// sort customer array in ascending order
            for(int i = 0; i<size-1; i++) {
                for (int j = i+1; j<array.length; j++) {
                    if(array[i].compareTo(array[j])>0) {
                        String temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
            Map<String,Integer> repeatationMap= new HashMap<String,Integer>();
//            String[] myArray = new String[size];
            ArrayList<String> myArray = new ArrayList<String>();
            int count = 0;
            for(int k = 0; k<size-1; k++) {
                myArray.add(array[k]);
                for (String str : myArray) {
                    if (repeatationMap.containsKey(str)) {
                        repeatationMap.put(str, repeatationMap.get(str) + 1);
                    } else {
                        repeatationMap.put(str, 1);
                    }
                }


                for (int repatCount : repeatationMap.values()) {
                    if (repatCount > 1) {
                        count++;
                    }
                }
            }
            HashMap<String,Integer> hashmap = new HashMap<String,Integer>();

            //use for loop to pull the elements of array to hashmap's key
            for (int j = 0; j < array.length; j++) {
                hashmap.put(array[j], j);
            }
            // use hashmap.keySet() for printing all keys of hashmap using it's keySet() method
//            System.out.println(hashmap.keySet());
//            System.out.println("Number of Strings repeated : " + count);
//            System.out.println(Arrays.toString(array));

            // print out the values in ascending order and nomber of times repeated
            for (int i = 0; i < size; i += 1) {

                String element = array[i];
                for (int j = 0; j < size; j += 1) {
                    if (array[j].equals(element)) {
                        count += 1;
                    }
                }
                System.out.println(array[i] + " " + count);
            }

        }
    }
}
        