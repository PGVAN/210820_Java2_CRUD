package com.sbs.java.crud;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("printf : ");
		String title = sc.nextLine(); //sc.next는 한단어만, nextLine은 한줄 다.역이용해서 next여럿쓰는것도 재밌음.
		System.out.println(title);
		System.out.printf("printf : ");
		title = sc.nextLine().trim(); // 앞쪽 공백 처리
		System.out.println(title);
		sc.close();
		
		System.out.println("== 프로그램 끝 ==");
	}
}
