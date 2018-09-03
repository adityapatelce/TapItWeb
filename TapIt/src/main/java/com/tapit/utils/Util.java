package com.tapit.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

public class Util {

	public static String getStrValue(Map<String, Object> map, String key, String defaultValue) {
		if (map == null || !map.containsKey(key))
			return defaultValue;

		return (String) map.get(key);
	}

	public static String getStrValue(Map<String, Object> map, String key) {
		return getStrValue(map, key, "");
	}

	public static int getIntValue(Map<String, Object> map, String key, int defaultValue) {
		if (map == null || !map.containsKey(key))
			return defaultValue;

		return (Integer) map.get(key);
	}

	public static int getIntValue(Map<String, Object> map, String key) {
		return getIntValue(map, key, 0);
	}

	public static long getLongValue(Map<String, Object> map, String key, long defaultValue) {
		if (map == null || !map.containsKey(key))
			return defaultValue;

		return (Long) map.get(key);
	}

	public static long getLongValue(Map<String, Object> map, String key) {
		return getLongValue(map, key, 0L);
	}

	public static Date getUTCNow() {
		try {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
			
			SimpleDateFormat dateDestination = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			return dateDestination.parse(dateFormat.format(date));
		} catch (ParseException e) {
			return null;
		}

	}
}
