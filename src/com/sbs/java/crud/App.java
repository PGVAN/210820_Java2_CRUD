package com.sbs.java.crud;

//import java.text.SimpleDateFormat;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
//import java.util.Locale;
import java.util.Scanner;


import com.sbs.java.crud.dto.Article;
import com.sbs.java.crud.dto.Member;
import com.sbs.java.crud.util.Util;

public class App {
		
		public void run() {
		
			System.out.println("== 프로그램 시작 ==");
			System.out.printf("명령어 : ");
			Scanner sc = new Scanner(System.in);
			int lastArticleId = 0;
	
			List<Article> articles = new ArrayList<>();
			List<Member> members = new ArrayList<>();
	
			while (true) {
	
				String command = sc.nextLine().trim();
	
				if (command.length() == 0) {
					continue;
				}
				if (command.equals("system exit")) {
					break;
				}
				
				if (command.equals("join")) {
					int id = members.size() + 1;
					int overlap = 0;
					String logInId = null;
					
					while(true) {
						
						System.out.printf("ID : ");
						String inputId = sc.nextLine();

						for ( Member member : members) {
							
							if (member.logInId.equals(inputId)) {
								System.out.println("동일한 아이디가 있습니다. 다시 입력해주세요.");
								overlap = 1;
							}
						}
						if (overlap == 1) {
							overlap = 0;
							continue;
						}
						logInId = inputId;
						break;
					}
					String logInPw = null;
					
					while(true) {
						System.out.printf("PW : ");
						String inputPw = sc.nextLine();
						
						System.out.printf("PW 확인 : ");
						String inputPw2 = sc.nextLine();
						if (inputPw2.equals(inputPw) == false) {
								System.out.println("비밀번호를 다르게 입력했습니다. 다시 입력해주세요.");
								continue;
						}
						logInPw = inputPw;
						break;
					}
					
					System.out.printf("이름 : ");
					String name = sc.nextLine();
					
					Member member = new Member (id, logInId, logInPw, name);
					members.add(member);
					
					System.out.printf("%d번 회원이 생성되었습니다.\n", id);
				} else if (command.equals("write")) {
					
					int id = ++lastArticleId;
					lastArticleId = id;
					System.out.print("제목 : ");
					String title = sc.nextLine().trim();
					System.out.print("내용 : ");
					String body = sc.nextLine();
	
					Article article = new Article(id, title, body);
					articles.add(article);
	
					System.out.printf("%d번째 글이 생성되었습니다.\n", id);
				
				} else if (command.startsWith("list")) {
	
					if (articles.size() == 0) {
						System.out.println(".");
						continue;
					}
					
					String searchKeyword = command.substring("list".length()).trim();
					
					List<Article> forListArticles = articles;
					
					if(searchKeyword.length() > 0) {
						
						forListArticles = new ArrayList<>();
						
						for (Article article : articles) {
							if (article.title.contains(searchKeyword)) {
								forListArticles.add(article);
							}
						}
						
						if(forListArticles.size() == 0) {
							System.out.println("검색결과가 존재하지 않습니다.");
							continue;
						}
						else
							System.out.printf("검색어 : %s\n", searchKeyword);
						
					}
					
					
					System.out.println("작성시간           / 번호 /  제목  /  조회수");
					
					for (int i = forListArticles.size()-1; i>=0; i--) {
						Article article = forListArticles.get(i);
						System.out.printf("%s  /  %d  /  %s  /   %d\n",article.writeDateSimple,article.id, article.title, article.hit);
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
	
	//				boolean found = false;
					Article foundArticle = null;
					
					for (int i = 0; i < articles.size(); i++) {
						Article article = articles.get(i);
						if (article.id==num) {
	//						found=true;
							foundArticle = article;
							break;
						}
					}
					
					if (foundArticle==null) {
						System.out.printf("%d번 게시물은 존재하지 않습니다.\n", num);
						continue;
					}
					
					foundArticle.increaseHit();
					
					System.out.println("번호 : "+foundArticle.id);
					System.out.println("작성일 : "+foundArticle.writeDate);
					System.out.println("조회수 : "+foundArticle.hit);
					System.out.println("제목 : "+foundArticle.title);
					System.out.println("내용 : "+foundArticle.body);
					
	
				} else if (command.startsWith("modify ")){
					
					String[] bits = command.split(" ");
					int num = Integer.parseInt(bits[1]);
					
					Article foundArticle = null;
					
					int foundIndex = -1;
					
					for (int i = 0; i < articles.size(); i++) {
						Article article = articles.get(i);
						if (article.id==num) {
							foundArticle = article;
							break;
						}
					}
					
					if (foundArticle == null) {
						System.out.printf("%d번 게시물은 존재하지 않습니다.\n", num);
						continue;
					}
	
					System.out.print("제목 : ");
					String title = sc.nextLine().trim();
					System.out.print("내용 : ");
					String body = sc.nextLine();
					
					foundArticle.title = title;
					foundArticle.body = body;
					
					System.out.printf("%d번 게시물이 수정되었습니다.", foundArticle.id);
					
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
					System.out.printf("%d번 게시물이 삭제되었습니다.\n",num);
					
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


