class Solution {

    public boolean searchInRow(int[][] matrix, int target, int row) { 
        //O(logn)
        int n = matrix[0].length;
        int st = 0;
        int  end = n-1;

        while(st <= end){
            int mid = st + (end-st)/2;
            if(target == matrix[row][mid]){
              return true;
            } else if(target > matrix[row][mid]){
                st = mid +  1;
            } else {
                end = mid -1;
            }
        }

        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        //O(logm)
        //Bs on tot rows
        int m = matrix.length;
        int n = matrix[0].length;

        int startRow = 0 , endRow = m-1;
        while(startRow <= endRow){
            int midRow = startRow + (endRow - startRow)/2;

            if(target >= matrix[midRow][0]  && target<= matrix[midRow][n-1]){
                //found the row => BS on this row if the above loops satisfy
                return searchInRow(matrix,target,midRow);
            }else if(target >= matrix[midRow][n-1]){
                //down => right
                startRow = midRow + 1;
            }else{
                //up => left
                endRow = midRow -1;
            }
        }
        return false;
        
    }
}