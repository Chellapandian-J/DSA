class Solution {
    public boolean isPalindrome(String s) {
        String n=s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        System.out.println(n);
        for(int i=0;i<n.length()/2;i++){
            if(n.charAt(i)!=n.charAt(n.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
//time complexity: O(n) for traversing the string and checking for palindrome, so overall O(n)
//space complexity: O(n) for storing the cleaned string, so overall O(n)

//or optimized solution
class Solution {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }
}
//time complexity: O(n) for traversing the string and checking for palindrome, so overall O(n)
//space complexity: O(1) as we are using two pointers and not using any extra space

/*125. Valid Palindrome
Given a string s, determine if it is a palindrome, considering only
alphanumeric characters and ignoring cases.
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters. Since an empty string
is a palindrome, return true.
Constraints:
1 <= s.length <= 2 * 10^5
s consists only of printable ASCII characters.
*/