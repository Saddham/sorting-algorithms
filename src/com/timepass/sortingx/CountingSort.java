package com.timepass.sortingx;

import java.util.Arrays;

public class CountingSort {
	private int max;
	
	public CountingSort(int max){
		this.max = max;
	}
	
	//Runs in linear time
	public void sort(int a[]){
		int [] b = a.clone();
		int [] count = new int[max];
		
		for (int i = 0; i < b.length; i++) {
			++count[b[i]];
		}
		
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i-1];
		}
		
		for (int i = 0; i < b.length; i++) {
			a[count[b[i]]-1] = b[i];
			--count[b[i]];
		}
		
	}
	
	public static void main(String[] args) {		
		int a [] = {65, 76, 97, 25, 0, 5, 8, 65, 97, 0, 8};
		CountingSort countingSort = new CountingSort(100);
		countingSort.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
