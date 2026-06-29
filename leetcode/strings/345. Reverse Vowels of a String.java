class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(isvowel(ch)){
                sb.append(ch);
            }
        }int j=sb.length()-1;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!isvowel(ch)) ans.append(ch);
            else{
                ans.append(sb.charAt(j));
                j--;
            }
        }
        return ans.toString();
    }
    private boolean isvowel(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
    }
}
//time complexity: O(n)
//space complexity: O(n)

//or
class Solution {
    public String reverseVowels(String s) {
        char[] ch=s.toCharArray();
        int left=0,right=s.length()-1;
        while(left<right){
            while(left<right && !isvowel(ch[left])) left++;
            while(left<right && !isvowel(ch[right])) right--;
            char temp=ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;
            right--;
        }
        return String.valueOf(ch);
    }
    private boolean isvowel(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
    }
}