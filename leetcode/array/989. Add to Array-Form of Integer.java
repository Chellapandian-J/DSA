import java.math.BigInteger;
import java.util.*;
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        BigInteger sum=BigInteger.ZERO;
        for(int i:num){
            sum=sum.multiply(BigInteger.TEN).add(BigInteger.valueOf(i));
        }
        sum=sum.add(BigInteger.valueOf(k));
        String s=sum.toString();
        ArrayList<Integer> li=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            li.add((int)(s.charAt(i)-'0'));
        }
        return li;
    }
}
//Time Complexity: O(n), where n is the length of the input array num. We are iterating through the array once to calculate the sum and then converting the sum to a string and iterating through it to create the result list.
//Space Complexity: O(n), where n is the number of digits in the sum. We are using a BigInteger to store the sum, which can have up to n digits, and an ArrayList to store the final result.    

//optimized solution
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> li=new LinkedList<>();
        int i=num.length-1;
        while(i>=0 || k>0){
            if(i>=0){
                k+=num[i--];
            }
            li.addFirst(k%10);
            k/=10;
        }
        return li;
    }
}
//Time Complexity: O(n), where n is the length of the input array num. We are iterating through the array once to calculate the sum and then converting the sum to a string and iterating through it to create the result list.
//Space Complexity: O(n), where n is the number of digits in the sum. We are using a LinkedList to store the final result, which can have up to n digits.

/*989. Add to Array-Form of Integer
The array-form of an integer num is an array representing its digits in left to right order.
For example, if num = [1, 2, 0, 0], then the integer is 1200.
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
*/