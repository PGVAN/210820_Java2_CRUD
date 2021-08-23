package com.sbs.java.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;

		List<Article> articles = new ArrayList<>();

		while (true) {

			String command = sc.nextLine().trim(); // 앞쪽 공백 처리
//			System.out.println(command);

			if (command.length() == 0) {
				continue;
			}

			if (command.equals("system exit")) {
				break;
			}

			if (command.equals("write")) {
				int id = ++lastArticleId;
				lastArticleId = id;
				System.out.print("제목 : ");
				String title = sc.nextLine().trim();
				System.out.print("내용 : ");
				String body = sc.nextLine();

				Article article = new Article(id, title, body);
				articles.add(article);

				System.out.printf("%d번째 글이 생성되었습니다.\n", id);
			} else if (command.equals("list")) {

				if (articles.size() == 0) {
					System.out.println("게시물이 없습니다.");
					continue;
				}
				
				System.out.println("번호  /  제목");
				
				for (int i = articles.size()-1; i>=0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d  /  %s\n",article.id, article.title);
				}

			} else {
				System.out.printf("%s는 존재하지 않는 명령어입니다.\n", command);
				System.out.println("\n=== 명령어 목록 ===");
				System.out.printf("write : 게시물작성\nlist : 게시물갯수\nsystem exit : 종료\n\n");
			}

		}

		sc.close();

		System.out.println("== 프로그램 끝 ==");
	}
}

class Article {

	int id;
	String title;
	String body;

	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}