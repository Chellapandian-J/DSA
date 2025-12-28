class Solution {
    public int maxDepth(String s) {
        char[] chars=s.toCharArray();
        int count =0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(chars[i]=='('){
                count++;
                ans=Math.max(ans,count);
            }
            else if(chars[i]==')'){
                count--;
            }
        }
        return ans;
    }
}