class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        return (s+s).contains(goal);
    }
}

//to do manually
class Solution {
    public boolean rotateString(String s, String goal) {
        char[] a=s.toCharArray();
        char[] b=goal.toCharArray();
        List<Character> lista=new ArrayList<>();
        List<Character> listb=new ArrayList<>();
        for(char c:a){
            lista.add(c);
        }
        for(char c:b){
            listb.add(c);
        }
        for(int i=0;i<s.length();i++){
            if(lista.equals(listb)) return true;
            Collections.rotate(lista,-1);
        }
        return false;
    }
}