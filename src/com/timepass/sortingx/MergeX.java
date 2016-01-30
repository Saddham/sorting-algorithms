package com.timepass.sortingx;

import java.util.Arrays;

public class MergeX {
	private static int CUT_OFF = 10;
	
	public static void sort(Comparable dest[]){
		Comparable[] aux = dest.clone();
		sort(aux, dest, 0, dest.length-1);
	}
	
	private static void sort(Comparable[] src, Comparable[] dest, int lo, int hi) {
		if((hi - lo) <= 0) return;
		
		if(hi <= lo+CUT_OFF){
			insertionSort(dest, lo, hi);
			return;
		}
		
		int mid = (hi+lo)/2;
		sort(dest, src, lo, mid);
		sort(dest, src, mid+1, hi);
		
		if(!less(src[mid+1], src[mid])){
			System.arraycopy(src, lo, dest, lo, hi-lo+1);
			return;
		}
		
		merge(src, dest, lo, mid, hi);
	}

	private static void merge(Comparable[] src, Comparable[] dest, int lo, int mid, int hi) {
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if(i > mid) dest[k] = src[j++];
			else if(j > hi) dest[k] = src[i++];
			else if(less(src[j], src[i])) dest[k] = src[j++];
			else dest[k] = src[i++];
		}
	}

	private static void insertionSort(Comparable[] dest, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			for (int j = i; (j > lo) && less(dest[j], dest[j-1]); j--) {
				exchange(dest, j, j-1);
			}
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
