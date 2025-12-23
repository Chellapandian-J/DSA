class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] maps=new int[256];
        int[] mapt=new int[256];
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            char b=t.charAt(i);
            if(maps[a]!=0&&maps[a]!=b) return false;
            if(mapt[b]!=0&&mapt[b]!=a) return false;
            maps[a]=b;
            mapt[b]=a;
        }
        return true;
    }
}