class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,0,i,j)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][]board,String word,int check,int i,int j){
        if(check==word.length()) return true;
        if(i<0||i>=board.length||j<0||j>=board[0].length) return false;
        if(board[i][j]!=word.charAt(check)) return false;
        char temp=board[i][j];
        board[i][j]='#';
        boolean found=
                dfs(board,word,check+1,i+1,j)||
                dfs(board,word,check+1,i-1,j)||
                dfs(board,word,check+1,i,j+1)||
                dfs(board,word,check+1,i,j-1);
        board[i][j]=temp;
        return found;
    }
}