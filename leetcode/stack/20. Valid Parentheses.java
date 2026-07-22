class Solution {
    public boolean isValid(String s) {
        Deque<Character> st=new ArrayDeque<>();
        for(char c:s.toCharArray()){
            if(c=='{'){
                st.push('}');
            }
            else if(c=='['){
                st.push(']');
            }
            else if(c=='('){
                st.push(')');
            }
            else{
                if(st.isEmpty()||c!=st.pop()){
                    return false;
               }
            }
        }
        return st.isEmpty();
    }
}

/*20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

time complexity: O(n) for traversing the string and checking for valid parentheses, so overall O(n)
space complexity: O(n) for storing the stack, so overall O(n)
*/