class Solution {

    static void checkString(String s) {
        int v = 0;
        int c = 0;

        // code here
        for(char ch:s.toCharArray()){
            if("aeiou".contains(String.valueOf(ch))) v++;
            else c++;
        }
        if(v>c) System.out.println("Yes");
        else if(c>v) System.out.println("No");
        else System.out.println("Same");
    }
}
//or
class Solution {

    static void checkString(String s) {
        int v = 0;
        int c = 0;

        // code here
        for(char ch:s.toCharArray()){
            if("aeiou".indexOf(ch)!=-1) v++;
            else c++;
        }
        if(v>c) System.out.println("Yes");
        else if(c>v) System.out.println("No");
        else System.out.println("Same");
    }
}
//optimal solution
class Solution {

    static void checkString(String s) {
        int v = 0;
        int c = 0;

        // code here
        for(char ch:s.toCharArray()){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') v++;
            else c++;
        }
        if(v>c) System.out.println("Yes");
        else if(c>v) System.out.println("No");
        else System.out.println("Same");
    }
}
/*You are given a string s consisting of lowercase English letters. You need to check whether the number of vowels in the string is greater than, less than, or equal to the number of consonants.
Example 1:
Input: s = "geeksforgeeks"
Output: Yes

Example 2:
Input: s = "hello"
Output: No

*/