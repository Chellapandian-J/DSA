class Solution {
    public int longestBalanced(String s) {
        int maxlen=0;
        for(int i=0;i<s.length();i++){
            int[] freq=new int[26];
            int distinct=0,maxfreq=0;
            for(int j=i;j<s.length();j++){
                int idx=s.charAt(j)-'a';
                if(freq[idx]==0)distinct++;
                freq[idx]++;
                maxfreq=Math.max(freq[idx],maxfreq);
                if(distinct*maxfreq==j-i+1){
                    maxlen=Math.max(maxlen,j-i+1);
                }
            }
        }
        return maxlen;
    }
}
/*
3713. Longest Balanced Substring I
A string is called balanced if all characters that appear in the string appear the same number of times.
example 1:
Input: s = "ababa"
Output: 4
Explanation: The longest balanced substring is "baba", which has a length of 4.
example 2:
Input: s = "abcde"
Output: 1
Explanation: The longest balanced substring is "a", "b", "c", "d", or "e", which has a length of 1.
Constraints:
1 <= s.length <= 100
s consists of lowercase English letters.

space O(26) for frequency array
time O(n^2) for two nested loops
*/