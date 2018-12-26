package com.bec.socratesrpt.core.common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args){
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		System.out.println(Test.tsToSec8601(currentTime.toString()));
	}
	
	public static Integer tsToSec8601(String timestamp){
		if(timestamp == null) return null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dt = sdf.parse(timestamp);
			long epoch = dt.getTime();
			return (int)(epoch/1000);
		} catch(ParseException e) {
			return null;
		}
	}
	
}
