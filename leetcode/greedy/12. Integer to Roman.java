class Solution {
    public String intToRoman(int num) {
        int[] val={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbol={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<val.length;i++){
            while(num>=val[i]){
                sb.append(symbol[i]);
                num=num-val[i];
            }
        }
        return sb.toString();
    }
}
/* Seven different symbols represent Roman numerals with the following values
Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 
example 1:
Input: num = 3 Output: "III" 
example 2: Input: num = 4 Output: "IV" 
example 3: Input: num = 9 Output: "IX" 
example 4: Input: num = 58 Output: "LVIII" 
example 5: Input: num = 1994 Output: "MCMXCIV" 
time complexity: O(N) 
space complexity: O(1) */