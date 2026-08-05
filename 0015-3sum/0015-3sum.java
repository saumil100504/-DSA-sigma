class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      int n = nums.length;
      Arrays.sort(nums);  // step : 1 sort the array
      for(int i = 0; i<n-2; i++){
        //step - 2 skip duplicates for the firstr element
        if(i>0 && nums[i] == nums[i -1]) continue;
        int target = -nums[i];
        int left = i+1 , right = n-1;
        //step : 3 : two pointer approach
        while(left < right){
            int sum = nums[left] + nums[right];

            if(sum == target){
                result.add(Arrays.asList(nums[i], nums[left],nums[right]));

                //step -4 : skip duplicate values
                while(left<right && nums[left] == nums[left + 1]) left++;
                while(left<right && nums[right] == nums[right - 1])right --;

                left++;
                right--;
            }else if (sum<target){
                left++;
            }else{
                right--;
            }
        }
      }
      return result;
    }
}