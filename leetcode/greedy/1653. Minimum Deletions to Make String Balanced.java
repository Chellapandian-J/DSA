class Solution {
    public int minimumDeletions(String s) {
        int bcount=0;
        int deletions=0;
        for(char c:s.toCharArray()){
            if(c=='b'){
                bcount++;
            }
            else{
                deletions=Math.min(deletions+1,bcount);
            }
        }
        return deletions;
    }
}
/*
1653. Minimum Deletions to Make String Balanced
A string s is called balanced if there are no indices i < j such that s[i] = 'b' and s[j]= 'a'.
Given a string s consisting of letters 'a' and 'b' only, return the minimum number of deletions needed to make s balanced.
example 1:
Input: s = "aababbab"
Output: 2
Explanation: You can either:
Delete the underlined characters in "aababbab" (resulting in "aaabbb") or
Delete the underlined characters in "aababbab" (resulting in "aabbbb").
example 2:
Input: s = "bbaaaaabb"
Output: 2
Explanation: You can either:
Delete the underlined characters in "bbaaaaabb" (resulting in "baaaaaab") or
Delete the underlined characters in "bbaaaaabb" (resulting in "bbaaaaaa").
Constraints:
1 <= s.length <= 10^5
s[i] is either 'a' or 'b'.

time complexity: O(n)
space complexity: O(1)
*/ 