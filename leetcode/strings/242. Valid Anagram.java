//simple version t:O(n logn),s:O(n) not suitable for unicode and slow for large input
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }
}
//t:O(n),s:O(1),Fails if characters are outside 'a'–'z' and not suitable for unicode
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int i:freq){
            if(i!=0) return false;
        }
        return true;
    }
}
//slightly tuff but support for all unicode and safe version
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.codePointCount(0, s.length()) != t.codePointCount(0, t.length()))
            return false;
        Map<Integer, Integer> freq = new HashMap<>();
        s.codePoints().forEach(cp -> freq.put(cp,freq.getOrDefault(cp, 0) + 1));
        t.codePoints().forEach(cp -> {
            if (!freq.containsKey(cp)) {
                freq.put(cp, -1);
            } else {
                freq.put(cp,freq.get(cp) - 1);
                if (freq.get(cp) == 0) {
                    freq.remove(cp);
                }
            }
        });
        return freq.isEmpty();
    }
}

/*| Aspect            | Sorting      | Frequency Array | Unicode HashMap |
| ----------------- | ------------ | --------------- | --------------- |
| Time Complexity   | `O(n log n)` | `O(n)`          | `O(n)`          |
| Space Complexity  | `O(n)`       | `O(1)`          | `O(k)`          |
| Unicode Support   | ✅            | ❌               | ✅               |
| Fastest           | ❌            | ✅               | ⚠️              |
| Simplest          | ✅            | ⚠️              | ❌               |
| Interview Optimal | ⚠️           | ✅               | ✅ (follow-up)   |
