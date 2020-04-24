package com.fulmicotone.strings.similarity.utils;

import java.util.ArrayList;
import java.util.List;

public class Combination {


  
    /* arr[]  ---> Input Array 
    data[] ---> Temporary array to store current combination 
    start & end ---> Staring and Ending indexes in arr[] 
    index  ---> Current index in data[] 
    r ---> Size of a combination to be printed */
    static List<List<String>> combinationUtil(String[] arr, String[] data, int start,
                                              int end, int index, int r, List<List<String>> accumulator)
    { 
        // Current combination is ready to be printed, print it 
        if (index == r) 
        {
            List<String> l= new ArrayList<>();
            for (int j=0; j<r; j++) 
                l.add(data[j]+"");
            accumulator.add(l);
            return accumulator;
        } 
  
        // replace index with all possible elements. The condition 
        // "end-i+1 >= r-index" makes sure that including one element 
        // at index will make a combination with remaining elements 
        // at remaining positions 
        for (int i=start; i<=end && end-i+1 >= r-index; i++) 
        { 
            data[index] = arr[i]; 
            combinationUtil(arr, data, i+1, end, index+1, r,accumulator);
        }

        return accumulator;
    } 
  
    // The main function that prints all combinations of size r 
    // in arr[] of size n. This function mainly uses combinationUtil() 
 public static   List<List<String>> get(String arr[], int n, int r)
    {
        List<List<String>> accumulator=new ArrayList<>();
        // A temporary array to store all combination one by one 
        String data[]=new String[r];

        // Print all combination using temprary array 'data[]' 
        combinationUtil(arr, data, 0, n-1, 0, r,accumulator);

        return accumulator;

    }
    /* This code is contributed by Devesh Agrawal */

} 
  

