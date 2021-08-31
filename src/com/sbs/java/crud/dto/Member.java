package com.sbs.java.crud.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Member extends dto {


		public String logInId;
		public String logInPw;
		public String name;
		
		Date date = new Date();
		public SimpleDateFormat nowDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.KOREA);
		public SimpleDateFormat simpleDate = new SimpleDateFormat("yy/MM/dd HH:mm", Locale.KOREA);
		public String regDate;
		
		public Member(int id, String logInId, String logInPw, String name) {
			this.id = id;
			this.regDate = regDate;
			this.logInId = logInId;
			this.logInPw = logInPw;
			this.regDate = nowDate.format(date);
		}
		
	}