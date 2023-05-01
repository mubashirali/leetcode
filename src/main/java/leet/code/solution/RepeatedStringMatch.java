package leet.code.solution;

public class RepeatedStringMatch {
	/**
	 * Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b to be a substring of a after repeating it, return -1.
	 * Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public int repeatedStringMatch(String a, String b) {
		int repeat = 1;
		String originalStr = a;

		while (a.length() < b.length()) {
			a += originalStr;
			repeat++;
		}
		for (int i = 0; i < 2; i++) {
			if (a.contains(b)) {
				return repeat;
			}
			a += originalStr;
			repeat++;
		}

		return a.contains(b) ? repeat : -1;
	}
}
