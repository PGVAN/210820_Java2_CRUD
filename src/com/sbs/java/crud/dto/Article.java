package com.sbs.java.crud.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Article {

	public int id;
	public String title;
	public String body;
	public int hit;
	
	public Date date = new Date();
	public SimpleDateFormat nowDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.KOREA);
	public SimpleDateFormat simpleDate = new SimpleDateFormat("yy/MM/dd HH:mm", Locale.KOREA);
	public String writeDate;
	public String writeDateSimple;
	
	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.writeDate = nowDate.format(date);
		this.writeDateSimple = simpleDate.format(date);
	}
	
	public void increaseHit() {
		hit++;
	}
}