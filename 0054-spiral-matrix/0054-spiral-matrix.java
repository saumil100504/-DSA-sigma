class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrder = new ArrayList<>();

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;
         
         while(startRow <= endRow  && startCol <= endCol){
            //top
            for(int j = startCol; j<=endCol; j++){
            spiralOrder.add(matrix[startRow][j]);
            }
            //Right
            for(int i = startRow+1; i<=endRow; i++){
                spiralOrder.add(matrix[i][endCol]);
            }
            //bottom
            for(int j=endCol-1; j>=startCol; j--){
                if(startRow == endRow){
                    break;
                }
                spiralOrder.add(matrix[endRow][j]);
            }
            //left
            for(int i = endRow-1; i>=startRow+1; i--){
                if(startCol == endCol){
                    break;
                }
                spiralOrder.add(matrix[i][startCol]);
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;



            
         }
         return spiralOrder;
    }
    
}