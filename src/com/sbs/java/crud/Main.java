package com.sbs.java.crud;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== ���α׷� ���� ==");
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		
		while(true) {
			
			String command = sc.nextLine().trim(); // ���� ���� ó��
//			System.out.println(command);
			
			if (command.length() == 0) {
				continue;
			}
			
			if (command.equals("system exit")) {
				break;
			}
			
			if (command.equals("write")) {
				lastArticleId++;

				System.out.print("���� : ");
				String title = sc.nextLine().trim();				
				System.out.print("���� : ");
				String body = sc.nextLine();
				
				System.out.printf("%d��° ���� �����Ǿ����ϴ�.", lastArticleId);
			}
			else if (command.equals("list")) {
				System.out.printf("�Խù��� %d�� �ֽ��ϴ�.", lastArticleId);
			}
			else {
				System.out.printf("%s�� �������� �ʴ� ��ɾ��Դϴ�.\n", command);
				System.out.println("\n=== ��ɾ� ��� ===");
				System.out.printf("write : �Խù��ۼ�\nlist : �Խù�����\nsystem exit : ����");
			}
			
		}
		
		sc.close();

		System.out.println("== ���α׷� �� ==");
	}
}
