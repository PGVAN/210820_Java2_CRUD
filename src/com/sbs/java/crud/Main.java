package com.sbs.java.crud;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== ���α׷� ���� ==");
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("printf : ");
		String title = sc.nextLine(); //sc.next�� �Ѵܾ, nextLine�� ���� ��.���̿��ؼ� next�������°͵� �����.
		System.out.println(title);
		System.out.printf("printf : ");
		title = sc.nextLine().trim(); // ���� ���� ó��
		System.out.println(title);
		sc.close();
		
		System.out.println("== ���α׷� �� ==");
	}
}
