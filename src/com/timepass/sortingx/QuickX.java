package com.timepass.sortingx;

import java.util.Arrays;

public class QuickX {
	private static int CUT_OFF = 10;
	
	public static void sort(Comparable dest[]){
		sort(dest, 0, dest.length-1);
	}
	
	
    private static void sort(Comparable[] dest, int lo, int hi) {
    	int N = hi-lo+1;
    	if(N <=CUT_OFF){
    		insertionSort(dest, lo, hi);
    		return;
    	} 
    	
    	if(N<=40){
    		int median = median3(dest, lo, lo+N/2, hi);
    		exch(dest, lo, median);
    	} else{
    		int median, ninther, median1, median2, median3, mid, eps;
    		eps = 8;
    		mid = lo+N/2;
    		median1 = median3(dest, lo, lo+eps, lo+eps+eps);
    		median2 = median3(dest, mid, mid+eps, mid+eps+eps);
    		median3 = median3(dest, hi, hi-eps, hi-eps-eps);
    		ninther = median3(dest, median1, median2, median3);
    		exch(dest, lo, ninther);
    	}
		
    	int i=lo, j=hi+1;
    	int p=lo, q=hi+1;
    	Comparable v = dest[lo];
    	
    	while(true){
    		while(less(dest[++i], v)){
    			if(i==hi) break;
    		}
    		
    		while(less(v, dest[--j])){
    			if(j==lo) break;
    		}
    		
    		if((i==j) && eq(v, dest[i])){
    			exch(dest, ++p, i);
    		}
    		
    		if(i>=j) break;
    		
    		exch(dest, i, j);
    		if(eq(v, dest[i])){
    			exch(dest, ++p, i);
    		}
    		if(eq(v, dest[j])){
    			exch(dest, --q, j);
    		}    		
    	}
    	
    	i=j+1;
    	for(int k=lo; k<=p; k++) exch(dest, k, j--);
    	for(int k=hi; k>=q; k--) exch(dest, k, i++);
    	
    	sort(dest, lo, j);
    	sort(dest, i, hi);
	}


	// sort from a[lo] to a[hi] using insertion sort
    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }


    // return the index of the median element among a[i], a[j], and a[k]
    private static int median3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
               (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
               (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }

   /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // does v == w ?
    private static boolean eq(Comparable v, Comparable w) {
        return (v.compareTo(w) == 0);
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
	public static void main(String[] args) {
		String [] strings = "a cBd LkmY".split("");
		sort(strings);
		System.out.println(Arrays.toString(strings));
		
		Integer [] integers = {76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38,
				76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38,
				76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38,
				76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38, 76, 96, 38};
		sort(integers);
		System.out.println(Arrays.toString(integers));
		
		Person [] persons = {new Person("sid", 2), new Person("fsdf", 3), new Person("gfgd", 87), new Person("tyty", 34),
							 new Person("sid", 3), new Person("hfh", 3), new Person("gfhngt", 3), new Person("mfdfm", 3),
							 new Person("lkjd", 3), new Person("pfdfi", 3), new Person("sada", 3), new Person("sid", 10)};
		
		for (Person person : persons) {
			System.out.println("Name: "+ person.getName()+" "+"Age: "+person.getAge());
		}

		sort(persons);
		
		for (Person person : persons) {
			System.out.println("Name: "+ person.getName()+" "+"Age: "+person.getAge());
		}
	}

}
