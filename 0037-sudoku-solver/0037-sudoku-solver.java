class Solution {
    public void solveSudoku(char[][] board) {
        sudokuSolver(board,0,0);
    }
    public boolean isSafe(char[][] board, int row, int col,char digit){
        //column
        for(int i=0; i<9;i++){
            if(board[i][col] == digit){
                return false;
            }
        }
        //row
        for(int j = 0; j<9; j++){
            if(board[row][j] == digit){
                return false;
            }
        }
        //grid
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;
        //3x3 grid - inner grid
        for(int i=sr;i<sr+3;i++){
            for(int j = sc; j<sc+3; j++){
                if(board[i][j] == digit){
                    return false;
                }
            }
        }
        return true;


    }

    public boolean sudokuSolver(char[][] board, int row, int col){
        //base case 
        if(row == 9){
            return true;
        }
        //recursion
        int nextRow = row;
        int nextCol = col + 1;

        if(col + 1 == 9){
            nextRow = row + 1;
            nextCol = 0;
        }
        //if cell is already filled
        if(board[row][col] != '.'){
            return sudokuSolver(board,nextRow,nextCol);
        }
        //try digits 1 to 9
        for(char digit = '1'; digit<='9';digit++){
            if(isSafe(board,row,col,digit)){
                //place digit 
                board[row][col] = digit;

                //recursive call
                if(sudokuSolver(board,nextRow,nextCol)){
                    return true;
                }
                //backtracking
                board[row][col] = '.';
            }
        }
        return false;
    }

}