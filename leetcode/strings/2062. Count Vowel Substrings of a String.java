class Solution {
    public int countVowelSubstrings(String word) {
        int c=0;
        for(int i=0;i<word.length();i++){
            boolean[] seen=new boolean[5];
            for(int j=i;j<word.length();j++){
                char ch=word.charAt(j);
                if(!isvowel(ch)) break;
                if(ch=='a') seen[0]=true;
                else if(ch=='e') seen[1]=true;
                else if(ch=='i') seen[2]=true;
                else if(ch=='o') seen[3]=true;
                else seen[4]=true;
                if(seen[0] && seen[1] && seen[2] && seen[3] && seen[4]) c++;
            }
        }
        return c;
    }
    private boolean isvowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
//time complexity: O(n^2)
//space complexity: O(1)