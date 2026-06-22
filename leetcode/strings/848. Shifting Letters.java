class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] c=s.toCharArray();
        long total=0;
        for(int i=s.length()-1;i>-1;i--){
            total+=shifts[i];
            c[i]=(char)('a'+(c[i]-'a'+total)%26);
        }
        return new String(c);
    }
}
/*848. Shifting Letters
You are given a string s of lowercase English letters and an integer array shifts of the same length
where shifts[i] is the number of times you need to shift the character s[i].
A shift on a letter means moving to the next letter in the alphabet, wrapping around so that 'z' becomes 'a'.
Return the final string after all such shifts to s are applied.

Example 1:
Input: s = "abc", shifts = [3,5,9]  
Output: "rpl"

Example 2:
Input: s = "aaa", shifts = [1,2,3]
Output: "gfd"

Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters.
shifts.length == s.length
0 <= shifts[i] <= 10^9

time complexity: O(n) for traversing the string and applying shifts, so overall O(n)
space complexity: O(n) for storing the answer in char array, so overall O(n)
*/