package com.practice.hackerrank;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ApacheLogs {

	String uri;
	int statusCode;
	Date date;

}

class Summary implements Comparable<Summary> {

	String uri;
	Date date;
	int successCount;
	int totalCount;

	@Override
	public int compareTo(Summary o) {

		if (this.date.compareTo(o.date) == 0) {
			return this.uri.compareTo(o.uri);
		} else {

			return this.date.compareTo(o.date);
		}

	}

}

public class LogSolution {

	public static String convertDateToString(Date date) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

		String folderName = formatter.format(date);

		return folderName;
	}

	public static Date convertStringToDate(String date) {
		// 27/Sep/2016:05:22:00 +0000
		Date date1 = null;
		// date=date.substring(0, date.length()-9);
		// System.out.println(date);
		try {
			date1 = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss Z").parse(date);

			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(date1);

			gc.set(Calendar.SECOND, 0);
			gc.set(Calendar.MILLISECOND, 0);
			date1 = gc.getTime();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date1;
	}

	public static ApacheLogs logLine(String logLine) {
		ApacheLogs logs = new ApacheLogs();
		String pattern = "^(\\S+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(\\S+)\\s?(\\S+)?\\s?(\\S+)?\" (\\d+|-) (\\d+|-) (\\d+|-) \"*\" *";// \"?([^\"]*)\"?\\s?\"?([^\"]*)?\"?$";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(logLine);

		if (m.find()) {

			logs.date = convertStringToDate(m.group(4));
			String urig = m.group(6);
			logs.uri = urig;
			if (urig.contains("?")) {
				StringTokenizer st = new StringTokenizer(urig, "?");
				List<String> uriL = new ArrayList<>();
				String uri = st.nextToken();
				logs.uri = uri;
			}
			logs.statusCode = Integer.parseInt(m.group(8));

		}

		return logs;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Map<String, Summary> map = new HashMap<>();

		while (sc.hasNext()) {
			String line = sc.nextLine();

			ApacheLogs logs = logLine(line);

			String key = logs.uri + ":" + convertDateToString(logs.date);
			if (map.containsKey(key)) {
				Summary summ = map.get(key);
				if (logs.statusCode < 500 || logs.statusCode >= 600) {
					summ.successCount = summ.successCount + 1;
				}
				summ.totalCount = summ.totalCount + 1;

			} else {

				Summary summ = new Summary();
				summ.date = logs.date;
				if (logs.statusCode < 500 || logs.statusCode >= 600) {
					summ.successCount = 1;
				}
				summ.totalCount = 1;
				summ.uri = logs.uri;

				map.put(key, summ);

			}

		}

		List<Summary> summList = new ArrayList<>(map.values());

		// 2016-09-27T05:22 /1.1/friendships/list.json 75.00

		Collections.sort(summList);

		for (Summary summary : summList) {

			double percentage = (double) (((double) summary.successCount) / ((double) summary.totalCount)) * 100;
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			df.setMinimumFractionDigits(2);

			String result = convertDateToString(summary.date) + " " + summary.uri + " " + df.format(percentage);
			System.out.println(result);
		}

	}

}
