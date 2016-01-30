package com.timepass.sortingx;

public class Recursion {
	static long segment;
	static long sunstrike;
	static long torado;
	
	
	//AVG
	public static int avg(int [] a, int lo, int hi){
		if(lo==hi)
			return a[lo];
		
		int left = avg(a, lo, (lo+hi)/2);
		int right = avg(a, (lo+hi)/2+1, hi);
		
		return (left+right)/2;
	}
	//AVG
	
	public static int [] findSolution(int n){
		int [] sol = new int[2*n];
		explore(sol, n);
		
		return sol;
	}
	
	private static boolean explore(int[] sol, int gap) {
		if(gap == 0){
			return true;
		}
		
		for(int i=sol.length-1; i-gap>0; i--){
			if(sol[i]==0 && sol[i-gap-1]==0){
				sol[i] = gap;
				sol[i-gap-1] = gap;
				if(explore(sol, gap-1)){ 
					return true;
				} else{
					sol[i] = 0;
					sol[i-gap-1] = 0;
				}
			} 
		}
		
		return false;
	}

	public static int solve(int [][] a, int n){
		return noOfDishes(a, 7, 6);
	}
	
	private static int noOfDishes(int [][] a, int dishes, int people){
		
		int req=0;		
		int [] dis = new int[people];
		int j;
		for(j=dishes-1; j>=0;j--){			
			for(int i=0; i<people;i++){
				if(((a[i][j]!=0) && (a[i][j]^dis[i]) > 0)){
					req++;
					dis[i]=1;
				}			
			}
			if(req==people){
				break;
			}
		}				
		
		if(dishes>1){			
			return Math.min((req<people)?Integer.MAX_VALUE:dishes-j, noOfDishes(a, dishes-1, people));
		} else{
			return (req<people)?Integer.MAX_VALUE:dishes-j;
		}
	}
	
	public static void main(String[] args) {		
		/*
 		int [] a = {6,6,6};
		System.out.println(avg(a, 0, a.length-1));
		for (int i : findSolution(3)) {
			System.out.print(i+" ");
		}
	 	*/	
		int [][] b ={{1, 0, 0, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 0, 0},
		{0, 0, 1, 0, 0, 0, 0},
		{0, 0, 0, 1, 0, 0, 0},
		{0, 0, 0, 0, 1, 0, 0},
		{0, 0, 0, 0, 0, 1, 1}};
		
		System.out.println(solve(b, 6));
		
		sunstrike = 2;
		torado = 3;
		segment = 3;
		long [] a = {1, 3, 5, 7, 10}; 
		System.out.println("gdfgfd "+solveDOTA2(a));
	
	}
	
	public static long solveDOTA2(long [] a){
		return solveDOTA2(a, 1, sunstrike, 1, 1);
	}
	
	public static long solveDOTA2(long [] a, int i, long result, long curseg, long curele){
		
		if(i==a.length)
			return result;
		if(curseg==0 && curele==0){
			curseg = 1;
			curele = 1;
		} else{
			curseg = curseg+a[i]-a[i-1];
			curele = curele+1;
		}
		
		if(curseg<=segment){
			if(sunstrike*curele>=torado){
				return solveDOTA2(a, i+1, result-sunstrike*(curele-1)+torado, 0, 0);
			} else{
				return solveDOTA2(a, i+1, result+sunstrike, curseg, curele);
			}
		}
		
		return solveDOTA2(a, i+1, result+sunstrike, 0, 0);
	}
}
