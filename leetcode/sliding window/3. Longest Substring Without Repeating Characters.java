class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int left = 0;
        int ans = 0;

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            freq[ch]++;

            while(freq[ch] > 1){
                freq[s.charAt(left)]--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
/*Given a string s, find the length of the longest substring without duplicate characters.

 example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
example 2: 
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

time complexity: O(n)
space complexity: O(1) since the frequency array has a fixed size of 256 for ASCII characters.*/