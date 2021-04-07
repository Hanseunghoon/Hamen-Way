package application;

import java.util.ArrayList;

public class Session {
	private static String sessionId = "abc1";
	private static String sessionNickName;
	private static String category;

	public static String getCategory() {
		return category;
	}

	public static void setCategory(String category) {
		Session.category = category;
	}

	public static String getSessionId() {
		return sessionId;
	}

	public static void setSessionId(String sessionId) {
		Session.sessionId = sessionId;
	}

	public static String getSessionNickName() {
		return sessionNickName;
	}

	public static void setSessionNickName(String sessionNickName) {
		Session.sessionNickName = sessionNickName;
	}

}