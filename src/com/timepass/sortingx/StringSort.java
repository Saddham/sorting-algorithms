package com.timepass.sortingx;

public class StringSort {
	public static void threeWaySort(StringBuilder str){
		int pos=0;
		
		for (int i = pos; i < str.length(); i++) {
			if(isLower(str.charAt(i))){
				swap(str, pos++, i);
			}
		}
		
		for (int i = pos; i < str.length(); i++) {
			if(isSpace(str.charAt(i))){
				swap(str, pos++, i);
			}
		}
				
		
		for (int i = pos; i < str.length(); i++) {
			if(isUpper(str.charAt(i))){
				swap(str, pos++, i);
			}
		}
	}
	
	private static boolean isSpace(char ch){
		return 32==ch;
	}
	
	private static boolean isUpper(char ch){
		return ch>=65 && ch<=90;
	}
	
	private static boolean isLower(char ch){
		return ch>=97 && ch<=122;
	}
	
	private static void swap(StringBuilder sb, int x, int y){
		char y_char = sb.charAt(y);
		sb.setCharAt(y, sb.charAt(x));
		sb.setCharAt(x, y_char);
	}

	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("a cBd LkmY");
		threeWaySort(str);
		System.out.println(str);

	}

}
