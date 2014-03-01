package util;

public class IDGenerator {
	private final static int LENGTH = 5;

	public static String generateSGVIP() {
		return "SG" + generateCode();
	}

	public static String generateHMVIP() {
		return "HM" + generateCode();
	}

	private static String generateCode() {
		char[] temp = new char[LENGTH];
		for (int i = 0; i < LENGTH; i++) {
			temp[i] = Random.generate();
		}
		return new String(temp);
	}
}
