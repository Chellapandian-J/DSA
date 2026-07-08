class Solution {
    public int clumsy(int n) {
        Stack<Integer> st=new Stack<>();
        st.push(n);
        int op=0;
        for(int i=n-1;i>=1;i--){
            if(op==0){
                st.push(st.pop()*i);
            }
            else if(op==1){
                st.push(st.pop()/i);
            }
            else if(op==2){
                st.push(i);
            }
            else{
                st.push(-i);
            }
            op=(op+1)%4;
        }
        int ans=0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}
/*time complexity: O(n) for traversing the numbers from n to 1 and performing the operations, so overall O(n)
space complexity: O(n) for using a stack to store intermediate results, so overall O(n)
*/
//optimal solution with O(1) space complexity
class Solution {
    public int clumsy(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 6;
        if(n==4) return 7;
        if(n%4==0) return n+1;
        if(n%4<=2) return n+2;
        return n-1;
    }
}

/*The clumsy factorial of a positive integer n is defined as the result of applying a fixed sequence of operations to the integers from n down to 1 in a specific order: multiplication (*), division (/), addition (+), and subtraction (-). The operations are applied in a repeating cycle, starting with multiplication. Specifically, the sequence of operations is as follows:
- Start with the integer n.
- Multiply by (n - 1).
- Divide by (n - 2).
- Add (n - 3).
- Subtract (n - 4).
- Repeat the above steps for the next integers in decreasing order until you reach 1.
Return the clumsy factorial of n.

Example 1:
Input: n = 4
Output: 7
Explanation: 7 = 4 * 3 / 2 + 1

Example 2:
Input: n = 10
Output: 12
Constraints:
1 <= n <= 1000
*/