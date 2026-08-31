class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if((j==0||i==0||i==r-1||j==c-1)&&board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++)
            {
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }

    }
    public void dfs(char[][] board,int r,int c){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length||board[r][c]=='X'||board[r][c]=='#'){
            return;
        }
        board[r][c]='#';
        dfs(board,r-1,c);
        dfs(board,r+1,c);
        dfs(board,r,c-1);
        dfs(board,r,c+1);
    }
}