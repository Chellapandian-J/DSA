class Solution {
    public int beautySum(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            int[] freq=new int[26];
            for(int j=i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;
                int min=s.length();
                int max=0;
                for(int f:freq){
                    if(f>0){
                        min=Math.min(min,f);
                        max=Math.max(max,f);
                    }
                }
                sum+=(max-min);
            }
        }
        return sum;
    }
}