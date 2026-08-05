class Solution {
 
 private static void swap(int[] nums , int a, int b){
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
 }

    public void sortColors(int[] nums) {
        // dutch national Flag algorithm
        int low = 0, mid= 0, high = nums.length-1;
      
      //loop through the array
      while(mid <= high){
        if(nums[mid] == 0){
            //move 0 to the beginning
            swap(nums,low,mid);
            low++;
            mid++;
        }else if(nums[mid] == 1){
            //leave 1 in place
            mid ++;
        }else{
            //move 2 to the end
            swap(nums,mid,high);
            high--;
        }
      }

        
    }
}