class Solution {
    public String removeChars(String s) {
        // code here
        return s.replaceAll("[^A-Za-z]","");
    }
};

//time complexity: O(n) for traversing the string and removing non-alphabet characters, so overall O(n)
//space complexity: O(n) for creating a new string with only alphabet characters, so overall O(n)

/*given a string s, the task is to remove all characters from the string except for alphabets (both uppercase and lowercase).
Example 1:
Input: s = "geeksforgeeks 123"
Output: "geeksforgeeks"

Example 2:
Input: s = "Hello, World!"
Output: "HelloWorld"
*/