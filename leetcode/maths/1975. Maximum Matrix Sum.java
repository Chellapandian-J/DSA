class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long neg=0,sum=0;
        long min=Integer.MAX_VALUE;
        for(int[] row:matrix){
            for(int val:row){
                if(val<0)neg++;
                long absval=Math.abs(val);
                sum+=absval;
                min=Math.min(min,absval);
            }
        }
        if(neg%2==1)sum-=2*min;
        return sum;
    }
}/*You are given an n x n integer matrix. You can choose any cell and flip the sign of all values in its row and column (i.e., convert all positive values to negative values and all negative values to positive values).
Your goal is to maximize the sum of the matrix's elements after applying the mentioned operation any number of times.
Return the maximum sum of the matrix's elements after applying the operation any number of times.
Example 1:
Input: matrix = [[1,-1],[-1,1]]
Output: 4
Explanation: We can follow the following steps to reach sum equals 4:
- Multiply the 2 elements in the first row by -1.
- Multiply the 2 elements in the first column by -1.

Example 2:
Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
Output: 16
Explanation: We can follow the following step to reach sum equals 16:
- Multiply the 2 last elements in the second row by -1.
time Complexity: O(n^2)
Space Complexity: O(1) */