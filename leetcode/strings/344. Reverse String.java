class Solution {
    public void reverseString(char[] s) {
        int l=s.length-1;
        for(int i=0;i<s.length/2;i++){
            char temp=s[i];
            s[i]=s[l];
            s[l]=temp;
            l--;
        }
    }
}

//Time Complexity: O(n), where n is the length of the string. This is because we are iterating through half of the string to reverse it.
//Space Complexity: O(1), as we are using a constant amount of space for the temporary variable and the two pointers.

/*given a string s, the task is to reverse the string. The provided solution uses a two-pointer approach to reverse the string in place. The reverseString method takes a character array as input, and uses two pointers to swap characters from the beginning and end of the array until they meet in the middle.
example:
Input: s = ['G', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'G', 'e', 'e', 'k', 's']
Output: ['s', 'k', 'e', 'e', 'G', 'r', 'o', 'f', 's', 'k', 'e', 'e', 'G']
*/
