package com.sbs.java.crud;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;

		List<Article> articles = new ArrayList<>();

		while (true) {

			String command = sc.nextLine().trim(); // ���� ���� ó��
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
					System.out.println(".");
					continue;
				}
				
				System.out.println("작성시간           /    번호  /  제목");
				
				for (int i = articles.size()-1; i>=0; i--) {
					Article article = articles.get(i);
					System.out.printf("%s  /  %d  /  %s\n",article.writeDateSimple,article.id, article.title);
				}

			} else if (command.startsWith("detail ")){
					
				String[] bits = command.split(" ");
				int num = Integer.parseInt(bits[1]);
				/*
				Article article = articles.get(num-1);
				
				if ( article.id != 0 && article.id == num) {
					System.out.println("번호 : "+article.id);
					System.out.println("제목 : "+article.title);
					System.out.println("내용 : "+article.body);
				}
				else {
					System.out.printf("%d번 게시물은 존재하지 않습니다.", num);
				}
				*/ //변수 존재여부 관련으로 좀 봐야할듯.

				boolean found = false;
				Article foundArticle = null;
				
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id==num) {
						found=true;
						foundArticle = article;
						break;
					}
				}
				
				if (foundArticle==null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", num);
					continue;
				}
				
				System.out.println("번호 : "+foundArticle.id);
				System.out.println("작성일 : "+foundArticle.writeDate);
				System.out.println("제목 : "+foundArticle.title);
				System.out.println("내용 : "+foundArticle.body);

			} else if (command.startsWith("delete ")){
					
				String[] bits = command.split(" ");
				int num = Integer.parseInt(bits[1]);
				
				int foundIndex = -1; // 그냥 id로 지우면 자료구조특성상 지우고 쓰는 과정에서 꼬인다. 인덱스넘버 찾기
				
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id==num) {
						foundIndex = i; // id인 num이 아닌 찾아낸 index값으로 반영.
						break;
					}
				}
				
				if (foundIndex == -1) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", num);
					continue;
				}
					
				articles.remove(foundIndex);
				System.out.printf("%d번 게시물이 삭제되었습니다.",num);
	
			} else {
				System.out.printf("%s는 존재하지 않는 명령어입니다.\n", command);
				System.out.println("\n=== 명령어 목록 ===");
				System.out.printf("write : 게시물 작성\nlist : 목록\ndetail 숫자 : 게시물보기\nsystem exit : 종료\n\n");
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
	
	Date date = new Date();
	SimpleDateFormat nowDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.KOREA);
	SimpleDateFormat simpleDate = new SimpleDateFormat("yy/MM/dd HH:mm", Locale.KOREA);
	String writeDate;
	String writeDateSimple;
	
	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.writeDate = nowDate.format(date);
		this.writeDateSimple = simpleDate.format(date);
	}
}