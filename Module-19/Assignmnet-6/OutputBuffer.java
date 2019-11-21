/**
 * @author Madhuri
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class OutputBuffer {
    public static void main(String[] args) throws IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter size: ");
        int size = Integer.parseInt(reader.readLine());
        String[] keys = new String[size];
        int[] values = new int[size];
        BST<String, Integer> bst = new BST<String, Integer>();
        System.out.println("enter key-value pair: ");
        for(int i = 0; i < size; i++) {
            keys[i] = (String)reader.readLine();
            values[i] = Integer.parseInt(reader.readLine());
            for(int j = 0; j < size; j++) {
                bst.put(keys[i], values[i]);
            }
        }
        System.out.println("the binary serach tree elements are within minimum and maximum range: " + bst.isOrdered());
    }
}