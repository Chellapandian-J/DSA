class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        long num = 0;
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            if (sign == 1 && num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && -num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }
        return (int)(sign * num);
    }
}
/* given a string, convert it to a 32-bit signed integer (similar to C/C++'s atoi function).
example 1:
Input: s = "42"
Output: 42
example 2:
Input: s = "   -42" 
Output: -42
example 3:
Input: s = "4193 with words"
Output: 4193
Constraints:
0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', and '-'.

time complexity: O(n)
space complexity: O(1)
*/