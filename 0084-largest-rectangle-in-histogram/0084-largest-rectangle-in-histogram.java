class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> indexStack = new Stack<>(); //stack to store indices
        int maxArea = Integer.MIN_VALUE;

        //ITERATE THROUGH BARS
        for(int i = 0; i<n; i++){
            //pop elements until we find a bar shorter than the current one
            while(!indexStack.isEmpty()&& heights[i] < heights[indexStack.peek()]){
                int topIndex = indexStack.pop();
                int height = heights[topIndex];

                //calculate width for the popped element
                int width = indexStack.isEmpty() ? i : (i-indexStack.peek() - 1);
                int area = height * width;

                //update maximum area 
                maxArea = Math.max(maxArea,area);
            }
            //push current index to the stack
            indexStack.push(i);
        }
        //handle remaining bars in the stack\
        while(!indexStack.isEmpty()){
            int topIndex = indexStack.pop();
            int height = heights[topIndex];

        // calculate width for the remaining elements 
        int width = indexStack.isEmpty() ? n : (n-indexStack.peek() - 1);
        int area = height*width;

        //update maximum area 
        maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}