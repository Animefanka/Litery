/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litery;

import java.util.Arrays;

/**
 *
 * @author Animka
 */
public class MergeSort {
        private long result=0;
    
     public  void mergeSort(int[] series, int start, int end) {
        if (start == end) {
            return;
        }
        int half = (start + end) / 2;
        mergeSort(series, start, half);
        mergeSort(series, half + 1, end);
        merge(series, start, half, end);
    }
     
     private void merge(int[] series, int start, int half, int end) {
        int k1 = half - start + 1, k2 = end - half;
        int[]temp=new int[series.length];
        int[] series1 = Arrays.copyOfRange(series, start, half + 1);
        int[] series2 = Arrays.copyOfRange(series, half + 1, end + 1);
        int i1 = 0, i2 = 0;
        while (i1 < k1 || i2 < k2) {
            if (i1 >= k1) {
                temp[i1 + i2] = series2[i2++];
            } else if (i2 >= k2) {
                result += i2;
                temp[i1 + i2] = series1[i1++];
            } else if (series1[i1] < series2[i2]) {
                result += i2;
                temp[i1 + i2] = series1[i1++];
            } else {
                temp[i1 + i2] = series2[i2++];
            }
        }
        for(int i=start;i<=end;i++){
        series[i]=temp[i-start];}
    }
     
     public long getResult(){
     return result;}
}
