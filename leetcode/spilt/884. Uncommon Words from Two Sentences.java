class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> ans=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(String s:(s1+" "+s2).split(" ")){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                ans.add(entry.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }
}
/*
given two sentences s1 and s2, return a list of all the uncommon words. 
A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
Example 1:
Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]
Example 2:
Input: s1 = "apple apple", s2 = "banana"
Output: ["banana"]

time complexity: O(N) where N is the total number of words in both sentences. We iterate through all the words in both sentences once to count their frequencies, and then iterate through the map entries to find the uncommon words.
space complexity: O(N) for the HashMap to store the frequency of each word, and O(U) for the list of uncommon words, where U is the number of uncommon words.
*/