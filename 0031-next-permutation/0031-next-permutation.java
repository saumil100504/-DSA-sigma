class Solution {

    private void swap(int[]nums , int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int Start, int end){
        while (Start < end){
            swap(nums,Start,end);
            Start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        //step 1 : find the first decreasing elemnt from the right
        for(int i = n-2 ; i>=0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        //  step - 2: find the next greater element to swap with nums[index]
        if(index != -1){
            for(int i = n -1; i>index; i--){
                if(nums[i] > nums[index]){
                    swap(nums,i,index);
                    break;
                }
            }
        }
        // step - 3: reverse the suffix (right part of the array)
        reverse(nums,index + 1, n-1);
      
 
 
    }
}