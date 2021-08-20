package com.sbs.java.crud;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		
		while(true) {
			
			String command = sc.nextLine().trim(); // 앞쪽 공백 처리
//			System.out.println(command);
			
			if (command.length() == 0) {
				continue;
			}
			
			if (command.equals("system exit")) {
				break;
			}
			
			if (command.equals("write")) {
				lastArticleId++;

				System.out.print("제목 : ");
				String title = sc.nextLine().trim();				
				System.out.print("내용 : ");
				String body = sc.nextLine();
				
				System.out.printf("%d번째 글이 생성되었습니다.", lastArticleId);
			}
			else if (command.equals("list")) {
				System.out.printf("게시물이 %d개 있습니다.", lastArticleId);
			}
			else {
				System.out.printf("%s는 존재하지 않는 명령어입니다.\n", command);
				System.out.println("\n=== 명령어 목록 ===");
				System.out.printf("write : 게시물작성\nlist : 게시물갯수\nsystem exit : 종료");
			}
			
		}
		
		sc.close();

		System.out.println("== 프로그램 끝 ==");
	}
}
