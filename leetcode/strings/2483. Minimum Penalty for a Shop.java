class Solution {
    public int bestClosingTime(String customers) {
        int score=0,penalty=0,besthour=0;
        for(int i=0;i<customers.length();i++){
            if(customers.charAt(i)=='Y') score++;
            else score--;
            if(score>penalty){
                penalty=score;
                besthour=i+1;
            }
        }
        return besthour;
    }
}