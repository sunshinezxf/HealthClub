package util;

public class IDGenerator {
	private final int LENGTH = 5;

	public String generateSGVIP() {
		return "SG" + generateCode();
	}

	public String generateHMVIP() {
		return "HM" + generateCode();
	}

	private String generateCode() {
		char[] temp = new char[LENGTH];
		for (int i = 0; i < LENGTH; i++) {
			temp[i] = Random.generate();
		}
		return new String(temp);
	}
}
