package leet.code.solution;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }

        for (int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);

            if (wordDict.contains(word)) {
                final boolean result = wordBreak(s.substring(i), wordDict);
                if (result) {
                    return result;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("catsandog", asList("cats", "dog", "sand", "and", "cat")));
    }
}
