package joe.prob1;

import java.util.HashMap;
import java.util.Map;

public class PossibleTransform {

	public static void main(String[] args) {

		String s1 = "Codesignal";
		String s2 = "CodeSignal";
		if (canTransform(s1, s2)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		s1 = "CCodeSignal";
		s2 = "CodeSignal";
		if (canTransform(s1, s2)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		s1 = "CdoeSignal";
		s2 = "CodeSignal";
		if (canTransform(s1, s2)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		s1 = "CodeSignal";
		s2 = "CodeSignal";
		if (canTransform(s1, s2)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		s1 = "CodeFights";
		s2 = "CodeSignal";
		if (canTransform(s1, s2)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		s1 = "CODE";
		s2 = "EDOC";
		if (canTransform(s1, s2)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	private static boolean canTransform(String s1, String s2) {

		if (s1.equals(s2) || Math.abs(s1.length() - s2.length()) > 1) {
			return false;
		}
		Map<Character, Integer> s1CharCountMap = new HashMap<Character, Integer>();
		Map<Character, Integer> s2CharCountMap = new HashMap<Character, Integer>();

		char[] charArray1 = s1.toCharArray();
		for (char c : charArray1) {
			Integer count = s1CharCountMap.getOrDefault(c, 0);
			s1CharCountMap.put(c, count + 1);
		}

		char[] charArray2 = s2.toCharArray();
		for (char c : charArray2) {
			Integer count = s2CharCountMap.getOrDefault(c, 0);
			s2CharCountMap.put(c, count + 1);
		}

		int diffCount = 0;
		if (s1CharCountMap.size() > s2CharCountMap.size()) {
			for (Map.Entry<Character, Integer> set : s1CharCountMap.entrySet()) {
				if (Math.abs(s2CharCountMap.getOrDefault(set.getKey(), 0) - set.getValue()) > 0)
					diffCount++;

				if (diffCount > 1) {
					return false;
				}
			}
		} else {
			for (Map.Entry<Character, Integer> set : s2CharCountMap.entrySet()) {
				if (Math.abs(s1CharCountMap.getOrDefault(set.getKey(), 0) - set.getValue()) > 0)
					diffCount++;

				if (diffCount > 1) {
					return false;
				}
			}
		}

		diffCount = 0;
		for (int i = s1.length() - 1, j = s2.length() - 1; i >= 0 && j >= 0;) {
			while (i >= 0 && j >= 0 && s1.charAt(i) != s2.charAt(j)) {
				if (i > j)
					i--;
				else
					j--;
				diffCount++;
			}
			if (diffCount > 2) {
				return false;
			}

			if (i >= 0 && j >= 0) {
				i--;
				j--;
			}
		}
		return true;
	}
}