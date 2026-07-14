import java.util.*;
class Solution {
    public int sumOfGP(int n, int a, int r) {
        // code here
        int ans=a;
        for(int i=1;i<n;i++){
            ans+= (int)(a*Math.pow(r,i));
        }
        return ans;
    }
}
//time complexity: O(n) for traversing the numbers from 1 to n and calculating the sum, so overall O(n)
//space complexity: O(1) for using a constant amount of space, so overall O(1)

//or
class Solution {
    public int sumOfGP(int n, int a, int r) {
        // code here
        return (int)(a*(Math.pow(r,n)-1)/(r-1));
    }
}
//time complexity: O(1) for directly calculating the sum using the formula, so overall O(1)
//space complexity: O(1) for using a constant amount of space, so overall O(1)

/*given three integers n, a, and r, the task is to find the sum of the first n terms of a geometric progression (GP) series where a is the first term and r is the common ratio.
Example 1:
Input: n = 5, a = 2, r = 3
Output: 242
Explanation: The first 5 terms of the GP series are 2, 6, 18, 54, 162. The sum of these terms is 2 + 6 + 18 + 54 + 162 = 242.

Example 2:
Input: n = 4, a = 3, r = 2
Output: 45
Explanation: The first 4 terms of the GP series are 3, 6, 12, 24. The sum of these terms is 3 + 6 + 12 + 24 = 45.

*/
