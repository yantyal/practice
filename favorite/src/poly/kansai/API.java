package poly.kansai;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class API {
	public static void main(String[] args) throws Exception{
//		String str = "こんにちはJava";
//		char[] data1 = str.toCharArray();
//		byte[] data2 = str.getBytes("utf-8");
//		byte[] data3 = str.getBytes();
//		for(char ele : data1) {
//			System.out.print(ele + " ");
//		}
//		for(byte val : data3) {
//			System.out.print(val);
//		}
		
		final String FORMAT = "%-9s %-13s 所持金%,6d";
		String s1 = String.format(FORMAT, "minato","hero",280);
		String s3 = String.format(FORMAT, "asaka","witch",32000);
		System.out.println(s1);
		System.out.println(s3);
		System.out.printf(FORMAT,"sugawara","sage",41000);
		
SimpleDateFormat f = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
		
		Date d = f.parse("2020/09/22 01:23:45");
		System.out.println(d);
		
		Date now = new Date();
		String s = f.format(now);
		System.out.println("現在は" + s + "です");
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 100; i++) {
			sb.append(i+1).append(",");
		}
		String str = sb.toString();
		String[] a = str.split(",");
		System.out.println(str);
		for(int i = 0; i < 100; i++) {
		System.out.println(a[i]);
		}
		
		Date now2 = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(now2);
		int day = c.get(Calendar.DAY_OF_MONTH);
		day += 100;
		c.set(Calendar.DAY_OF_MONTH, day);
		Date future = c.getTime();
		SimpleDateFormat f2 = new SimpleDateFormat("西暦yyyy年MM月dd日 HH時mm分ss秒");
		String s2 = f2.format(future);
		System.out.println(s2);
		
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("西暦yyyy年MM月dd日");
		LocalDate l1 = LocalDate.now();
		LocalDate l2 = l1.plusDays(100);
		String str2 = l2.format(fmt);
		System.out.println(str2);
		
	}

}
