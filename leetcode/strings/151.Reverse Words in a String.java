//it use o(n) time complexity and o(n) space.
class Solution {
    public String reverseWords(String s) {
        String removed=s.strip();
        String n[]=removed.split("\\s+");
        List<String> l=Arrays.asList(n);
        Collections.reverse(l);
        return String.join(" ",n);
    }
}
//it use o(n) time complexity and o(1) space.
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        int i=s.length()-1;
        while(i>=0){
            while(i>=0 && s.charAt(i)==' '){
                i--;
            }
            if(i<0) break;
            int j=i;
            while(j>=0 && s.charAt(j)!=' '){
                j--;
            }
            if(sb.length()>0) sb.append(" ");
            sb.append(s.substring(j+1,i+1));
            i=j-1;
        }

        return sb.toString();
    }
}
/*Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:
Input: s = "  hello world  "
Output: "world hello"
example 3:
Input: s = "a good   example"
Output: "example good a"
Constraints:
1 <= s.length <= 10^4
s consists of English letters (upper-case and lower-case), digits, and spaces ' '.
time complexity: O(n) for traversing the string and reversing the words, so overall O(n)
space complexity: O(n) for storing the words in a list, so overall O(n)
*/