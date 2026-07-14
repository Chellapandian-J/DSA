class Solution {
    public static String reverseString(String s) {
        // code here
        return new StringBuilder(s).reverse().toString();
    }
}

//Time Complexity: O(n), where n is the length of the string. This is because we are iterating through the string once to reverse it.
//Space Complexity: O(n), where n is the length of the string. This is because we are creating a new StringBuilder object to store the reversed string.

/*given a string s, the task is to reverse the string. The provided solution uses the StringBuilder class in Java, which has a built-in method to reverse the string. The reverseString method takes a string as input, creates a StringBuilder object with that string, reverses it using the reverse() method, and then converts it back to a string using toString().
example:
Input: s = "GeeksforGeeks"
Output: "skeeGrofskeeG"
*/