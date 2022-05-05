
/**
 * Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:
 * <p>
 * Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
 * Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
 * <p>
 * In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.
 * <p>
 * For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
 * <p>
 * You can insert the characters '(' and ')' at any position of the string to balance it if needed.
 * <p>
 * Return the minimum number of insertions needed to make s balanced.
 */
class MinimumInsertionsToBalanceAParenthesesString{
   
    /**
     * Time Limit Exceeded
     * https://youtu.be/5OMkd0iikJ0
     * @param s
     * @return
     */
    public static int minInsertions(String s) {
        Set<Integer> index = new HashSet<>();
        int order = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(') {
                int count = 2;
                for (int j = i + 1; count > 0 && j < s.length(); j++) {
                    if (chars[j] == ')' && index.add(j)) {
                        if (j < s.length() - 1 && chars[j + 1] == ')') {
                            count = 0;
                            index.add(j + 1);
                            break;
                        }
                        count--;
                    } else if (count == 1 && chars[j] == '(') {
                        break;
                    }
                }
                order += count;
            } else if (chars[i] == ')' && index.add(i)) {
                if (i < s.length() - 1 && chars[i + 1] == ')') {
                    index.add(i + 1);
                    order++;
                } else {
                    order += 2;
                }
            }
        }
        return order;
    }
}
