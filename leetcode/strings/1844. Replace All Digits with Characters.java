class Solution {
    public String replaceDigits(String s) {
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int a=s.charAt(i)-'0';
                char ch=((char)(s.charAt(i-1)+a));
                ans.append(ch);
            }
            else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
//time complexity: O(n) for traversing the string and replacing digits, so overall O(n)
//space complexity: O(n) for storing the answer in StringBuilder, so overall O(n)

//optimized solution
class Solution {
    public String replaceDigits(String s) {
        char[] ans=s.toCharArray();
        for(int i=1;i<s.length();i+=2){
            int a=ans[i]-'0';
            ans[i]=(char)(ans[i-1]+a);
        }
        return new String(ans);
    }
}
//time complexity: O(n) for traversing the string and replacing digits, so overall O(n)
//space complexity: O(n) for storing the answer in char array, so overall O(n

/*1844. Replace All Digits with Characters
You are given a 0-indexed string s that has lowercase English letters in its even indices and digits in its odd indices.
You should replace each digit in s with a character that corresponds to the digit's value in the alphabet.
example, replace the digit 0 with 'a', the digit 1 with 'b', the digit 2 with 'c', and so on. More formally, replace the digit d with the character that is d places after the character at the previous even index.
Return the resulting string after replacing all the digits.

Example 1:
Input: s = "a1c1e1"
Output: "abcdef"

Example 2:
Input: s = "a1b2c3d4e"
Output: "abbdcdef"

Constraints:
1 <= s.length <= 100
s consists of lowercase English letters and digits.
*/
