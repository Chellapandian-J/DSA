class Solution {

    String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if(digits.length() == 0) return result;

        backtrack(digits, 0, "", result);

        return result;
    }

    void backtrack(String digits, int index, String current, List<String> result){

        if(index == digits.length()){
            result.add(current);
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for(char c : letters.toCharArray()){
            backtrack(digits, index + 1, current + c, result);
        }
    }
}