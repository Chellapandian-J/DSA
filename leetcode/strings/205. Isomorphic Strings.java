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
//using hashmap but above(array)method is safe
class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Integer> mapt = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            Integer st = maps.put(a, i + 1);
            Integer ts = mapt.put(b, i + 1);

            if (!Objects.equals(st, ts)) return false;
        }
        return true;
    }
}
