class Solution {
    public int maxArea(int[] height) {
    int maxWater = 0;
    int lp = 0 ; 
    int n =  height.length;
    int rp = n - 1;

    while (lp < rp){
        int width = rp - lp;
        int minHeight = Math.min(height[lp], height[rp]);
        maxWater = Math.max(maxWater, width * minHeight);
        
        if(height[lp] < height[rp]){
            lp ++;
            } else {
                rp --;
            }
        
    }

    return maxWater;
    
    
    }

}