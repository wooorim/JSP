package edu.global.ex.java;

import java.util.HashSet;

//여러번 사용하는것(기능)은 클래스로 만들어준다.
public class Lotto {
	
	public HashSet<Integer> getLotto(){ //반환 타입을 HashSet<Integer>
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(set.size() < 6) {
			set.add((int)(Math.random() * 45) + 1);
		}
		
		System.out.println(set);
		return set;
		
	}
		


}
