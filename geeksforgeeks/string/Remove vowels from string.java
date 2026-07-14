class Solution {
    String removeVowels(String s) {
        // code here
        return s.replaceAll("[aeiouAEIOU]","");
    }
}

//time complexity: O(n) for traversing the string and removing vowels, so overall O(n)
//space complexity: O(n) for creating a new string with vowels removed, so overall O(n)

//or

class Solution {
    String removeVowels(String s) {
        // code here
        char[] ch=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(char c:ch){
            if(!isvowel(c)) sb.append(c);
        }
        return new String(sb);
    }
    private boolean isvowel(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
    }
}

//time complexity: O(n) for traversing the string and checking each character, so overall O(n)
//space complexity: O(n) for creating a new string with vowels removed, so overall O(n)

/*given a string s, the task is to remove all vowels (both uppercase and lowercase) from the string.

Example 1:
Input: s = "geeksforgeeks"
Output: "gksfrgks"

Example 2:
Input: s = "Hello, World!"
Output: "Hll, Wrld!"
*/
