package com.timepass.sortingx;

import java.util.Arrays;

public class InsertionX {

	public static void sort(Comparable [] dest){
		
		if(dest.length <= 1) return;
		
		int N = dest.length;
		
		for(int i=N-1; i>0; i--){
			if(less(dest[i], dest[i-1])){
				exchange(dest, i, i-1);
			}
		}
		
		for(int i=2; i<N; i++){
			Comparable v = dest[i];
			int j = i;
			while(less(dest[j], dest[j-1])){
				exchange(dest, j, j-1);
				j--;
			}
			
			dest[j] = v;						
		}
	}
	
	private static void exchange(Comparable[] dest, int i, int j) {
		Comparable temp = dest[i];
		dest[i] = dest[j];
		dest[j] = temp;		
	}

	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	public static void main(String[] args) {		
		String [] strings = {"g", "s", "a", "b"};
		sort(strings);
		System.out.println(Arrays.toString(strings));
		
		Integer [] integers = {76, 57, 657, 87, 8, 97, 877, 46, 867, 543, 76, 87, 654, 7, 
				65, 875, 56, 6, 54};
		sort(integers);
		System.out.println(Arrays.toString(integers));
	}

}
