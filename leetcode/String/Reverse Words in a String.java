//it use o(n) time complexity and o(n) space.
class Solution {
    public String reverseWords(String s) {
        String removed=s.strip();
        String n[]=removed.split("\\s+");
        List<String> l=Arrays.asList(n);
        Collections.reverse(l);
        return String.join(" ",n);
    }
}
//it use o(n) time complexity and o(1) space.
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        int i=s.length()-1;
        while(i>=0){
            while(i>=0 && s.charAt(i)==' '){
                i--;
            }
            if(i<0) break;
            int j=i;
            while(j>=0 && s.charAt(j)!=' '){
                j--;
            }
            if(sb.length()>0) sb.append(" ");
            sb.append(s.substring(j+1,i+1));
            i=j-1;
        }

        return sb.toString();
    }
}