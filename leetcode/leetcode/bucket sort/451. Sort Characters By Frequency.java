//t:O(n)
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> freq=new HashMap<>();
        for(char c:s.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        List<Character>[] bucket=new ArrayList[s.length()+1];
        for(char c:freq.keySet()){
            int i=freq.get(c);
            if(bucket[i]==null) bucket[i]=new ArrayList<>();
            bucket[i].add(c);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=s.length();i>0;i--){
            if(bucket[i]!=null){
                for(char a:bucket[i]){
                    for(int j=0;j<i;j++){
                        sb.append(a);
                    }
                }
            }
        }
        return sb.toString();
    }
}
//another method using sorting is in string folder