/*given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
The words in paragraph are case-insensitive and the answer should be returned in lowercase.
Example 1:
Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit
", banned = ["hit"]
Output: "ball"
explanation: "hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. Note that words in the paragraph are not case sensitive, that punctuation is ignored (even if adjacent to words), and that "hit" isn't the answer even though it occurs more because it is banned.
Example 2:
Input: paragraph = "a.", banned = []
Output: "a"

*/
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer> map=new HashMap<>();
        String str=paragraph.replaceAll("[^a-zA-Z0-9]"," ");
        for(String s:str.split("\\s+")){
            String a=s.toLowerCase();
            boolean bool=true;
            for(String b:banned){
                if(a.equals(b)){
                    bool=false;
                }
            }
            if(bool){
            map.put(a,map.getOrDefault(a,0)+1);
            }
        }
        int max=Integer.MIN_VALUE;
        String ans="";
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
                ans=entry.getKey();
            }
        }
        return ans;
    }
}
/*
time complexity: O(N * M) where N is the number of words in the paragraph and
M is the number of banned words. We iterate through each word in the paragraph and check if it is in the banned list, which takes O(M) time for each word. Therefore, the overall time complexity is O(N * M).
space complexity: O(N) for the HashMap to store the frequency of each non-banned
*/

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set=new HashSet<>(Arrays.asList(banned));
        HashMap<String,Integer> map=new HashMap<>();
        String str=paragraph.replaceAll("[^a-zA-Z]"," ");
        String ans="";
        int max=0;
        for(String s:str.split("\\s+")){
            String word=s.toLowerCase();
            if(word.isEmpty()||set.contains(word)) continue;
            int count=map.getOrDefault(word,0)+1;
            map.put(word,count);
            if(count>max){
                max=count;
                ans=word;
            }
        }
        return ans;
    }
}
/*
time complexity: O(N) where N is the number of words in the paragraph. We iterate
through each word in the paragraph once, and the operations of checking if a word is banned and updating the frequency count in the HashMap are both O(1) on average. Therefore, the overall time complexity is O(N).
space complexity: O(N) for the HashMap to store the frequency of each non-banned word and O(M) for the HashSet to store the banned words, where M is the number of banned words. Therefore, the overall space complexity is O(N + M).
*/