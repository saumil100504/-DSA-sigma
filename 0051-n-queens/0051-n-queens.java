class Solution {
    public boolean isSafe(char board [][] , int row , int col){
        //vertical yup 
        for(int i = row - 1 ; i>= 0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //diagonal left up
         for(int i = row-1, j = col-1; i>=0 && j>=0; i--,j--) {
            if(board[i][j] == 'Q'){
                return false;
            }
        } 
        //diagonal right up
        for(int i= row-1, j = col+1; i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;

    }

    public void nQueens(char board[][], int row, List<List<String>> ans){
        //base case 
        if(row == board.length){
            List<String> currentBoard = new ArrayList<>();
            for(int i = 0; i<board.length; i++){
                currentBoard.add(new String(board[i]));
            }
            ans.add(currentBoard);
            return;
        }

        //column loop 
        for(int j = 0; j<board.length; j++){
            if(isSafe(board,row,j)){
                //place queen
                board[row][j] = 'Q';
                //function call
                nQueens(board,row+1,ans);

                //backtracking step 
                board[row][j] = '.';
            }
        }
    }
       
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ans = new ArrayList<>();
        char board[][] = new char[n][n];

        //initialize
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';
            }
        }
        nQueens(board,0,ans);
        
        return ans;
    }
}