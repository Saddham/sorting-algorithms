package com.timepass.sortingx;

public class Person implements Comparable<Person>{
		private String name;
		private int age;
					
		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			age = age;
		}
		
		@Override
		public int compareTo(Person person) {			
			return name.compareTo(person.getName());
		}
}
