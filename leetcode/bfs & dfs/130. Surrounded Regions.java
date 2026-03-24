class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            dfs(board,i,0);
            dfs(board,i,n-1);
        }
        for(int i=0;i<n;i++){
            dfs(board,0,i);
            dfs(board,m-1,i);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(char[][] board,int r,int c){
        int m=board.length;
        int n=board[0].length;
        if(r<0||r>=m||c<0||c>=n||board[r][c]!='O') return;
        board[r][c]='T';
        dfs(board,r-1,c);
        dfs(board,r+1,c);
        dfs(board,r,c-1);
        dfs(board,r,c+1);
    }
}
/*
leetcode link: https://leetcode.com/problems/surrounded-regions/
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'. A region is captured by flipping all 'O's into 'X's in that surrounded region.
Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Example 2:
Input: board = [["X"]]
Output: [["X"]]

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
time complexity: O(m*n)
space complexity: O(m*n) in worst case when all cells are 'O'
*/
