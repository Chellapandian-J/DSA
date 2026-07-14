class Solution {
    public int sumOfAP(int n, int a, int d) {
        // code here
        int ans=a;
        for(int i=1;i<n;i++){
            ans+=a+(i*d);
        }
        return ans;
    }
}
//time complexity: O(n) for traversing the numbers from 1 to n and calculating the sum, so overall O(n)
//space complexity: O(1) for using a constant amount of space, so overall O(1)

//or

class Solution {
    public int sumOfAP(int n, int a, int d) {
        // code here
        return (n*(2*a+(n-1)*d))/2;
    }
}
//time complexity: O(1) for directly calculating the sum using the formula, so overall O(1)
//space complexity: O(1) for using a constant amount of space, so overall O(1)

/*given three integers n, a, and d, the task is to find the sum of the first n terms of an arithmetic progression (AP) series where a is the first term and d is the common difference.
Example 1:
Input: n = 5, a = 2, d = 1
Output: 15
Explanation: The first 5 terms of the AP series are 2, 3, 4, 5, 6. The sum of these terms is 2 + 3 + 4 + 5 + 6 = 15.

Example 2:
Input: n = 4, a = 3, d = 2
Output: 30
Explanation: The first 4 terms of the AP series are 3, 5, 7, 9. The sum of these terms is 3 + 5 + 7 + 9 = 24.

*/