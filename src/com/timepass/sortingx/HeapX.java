package com.timepass.sortingx;

import java.util.Arrays;

public class HeapX {
	
	public static void sort(Comparable dest[]){
		int N = dest.length;
		
		for(int i=N/2; i>=1; i--){
			sink(dest, i, N);
		}
		
		while(N > 1){
			exch(dest, 1, N--);
			sink(dest, 1, N);
		}
	}	

   private static void sink(Comparable[] dest, int i, int N) {
		while(2*i <= N){
			int j = 2*i;
			if(j < N && less(dest, j, j+1)) j++;
			if(!less(dest, i, j)) break;
			exch(dest, i, j);
			i=j;
		}
		
	}

/***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/
    
   private static boolean less(Comparable[] pq, int i, int j) {
       return pq[i-1].compareTo(pq[j-1]) < 0;
   }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = swap;
    }
    
	public static void main(String[] args) {
		String [] strings = {"g", "s", "a", "b"};
		sort(strings);
		System.out.println(Arrays.toString(strings));
		
		Integer [] integers = {76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38,
				76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38,
				76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38,
				76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38};
		sort(integers);
		System.out.println(Arrays.toString(integers));

	}

}