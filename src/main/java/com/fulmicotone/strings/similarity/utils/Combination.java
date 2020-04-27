package com.fulmicotone.strings.similarity.utils;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    static List<List<String>> combinationUtil(String[] arr, String[] data, int start,
                                              int end, int index, int r, List<List<String>> accumulator)
    {
        if (index == r) 
        {
            List<String> l= new ArrayList<>();
            for (int j=0; j<r; j++) 
                l.add(data[j]+"");
            accumulator.add(l);
            return accumulator;
        } 

        for (int i=start; i<=end && end-i+1 >= r-index; i++) 
        { 
            data[index] = arr[i]; 
            combinationUtil(arr, data, i+1, end, index+1, r,accumulator);
        }

        return accumulator;
    } 
  

 public static   List<List<String>> get(String arr[], int n, int r)
    {
        List<List<String>> accumulator=new ArrayList<>();

        String data[]=new String[r];

        combinationUtil(arr, data, 0, n-1, 0, r,accumulator);

        return accumulator;

    }
    /* This code is contributed by Devesh Agrawal */

} 
  

