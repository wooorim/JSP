package edu.global.ex.java;

import java.util.HashSet;

//������ ����ϴ°�(���)�� Ŭ������ ������ش�.
public class Lotto {
	
	public HashSet<Integer> getLotto(){ //��ȯ Ÿ���� HashSet<Integer>
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(set.size() < 6) {
			set.add((int)(Math.random() * 45) + 1);
		}
		
		System.out.println(set);
		return set;
		
	}
		


}
