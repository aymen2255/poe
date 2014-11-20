package fr.treeptik.tp.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

	private static Date time;

	public static void main(String[] args) throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse("09/11/2011");
		Date now = new Date();
		System.out.println(dateFormat.format(date));
		System.out.println(dateFormat.format(now));
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 35);
		System.out.println("*****************");
		Date newDate = calendar.getTime();
		System.out.println(dateFormat.format(newDate));
		
		int compareTo = date.compareTo(now);
		System.out.println(compareTo);
	}

}
