class Solution {
    public int[][] merge(int[][] intervals) {
        //sort intervals acc to string 
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        // create a answer list
        List<int[]> ans = new ArrayList<>();
        // traverse all intervals 
        for(int i = 0; i<intervals.length;i++){
        //if answer is empty or current interval does not overlap
        //with the last inetrval is answer
        if(ans.isEmpty() || intervals[i][0] > ans.get(ans.size()-1)[1]){
            //add current interval
            ans.add(new int[]{
                intervals[i][0],
                intervals[i][1]
            });
        }else {
            //current interval overlaps with last interval
            //update the ending point
             ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1],intervals[i][1]);
        }   
        }
        return ans.toArray(new int[ans.size()][]);
    }
}