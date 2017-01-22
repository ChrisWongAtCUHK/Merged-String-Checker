public class StringMerger {
	public static boolean isMerge(String s, String part1, String part2) {
		if (s.length() != part1.length() + part2.length()) {
			return false;
		}

		// char index for part1 and part2
		int i1 = 0;
		int i2 = 0;

		while (i1 + i2 < s.length()) {
			char c = s.charAt(i1 + i2);
			boolean match1 = i1 < part1.length() && part1.charAt(i1) == c;
			boolean match2 = i2 < part2.length() && part2.charAt(i2) == c;

			// check if either part has no characters left
			if (i1 >= part1.length() && !match2 || i2 >= part2.length()
					&& !match1) {
				return false;
			} else if (match1 && match2) {
				// if both part matches, guess both parts be the next
				String nextS = s.substring(i1 + i2 + 1);
				String next1 = part1
						.substring(Math.min(i1 + 1, part1.length()));
				String next2 = part2
						.substring(Math.min(i2 + 1, part2.length()));

				return isMerge(nextS, next1, part2.substring(i2))
						|| isMerge(nextS, part1.substring(i1), next2);
			} else if (match1) {
				i1++;
			} else if (match2) {
				i2++;
			} else {
				return false;
			}
		}

		return true;
	}
}