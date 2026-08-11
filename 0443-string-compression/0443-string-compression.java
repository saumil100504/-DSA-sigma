class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int idx = 0;
        for(int i = 0; i<n; i++){
            char ch = chars[i];
            int count = 0;
            //count how many times the current characters appears
            while(i<n && chars[i]==ch){
                count++;
                i++;
            }
            //store the characters
            chars[idx++] = ch;
              if(count > 1){
              String str = String.valueOf(count);
               for(char digit : str.toCharArray()){
                 chars[idx++] = digit;
          
                }
            }
            i--;
        }
        return idx;
    }

}