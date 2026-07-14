class Solution {
    public String removeSpaces(String s) {
        // code here
        return s.replaceAll(" ","");
    }
}

//time complexity: O(n) for traversing the string and removing spaces, so overall O(n)
//space complexity: O(n) for creating a new string with spaces removed, so overall O(n)

/*given a string s, the task is to remove all spaces from the string.
Example 1:
Input: s = "geeks for geeks"
Output: "geeksforgeeks"

Example 2:
Input: s = "Hello World"
Output: "HelloWorld"
*/
