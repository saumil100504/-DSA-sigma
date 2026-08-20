class Solution {
    public String minWindow(String s, String t) {

        int[] target = new int[256];

        // Store frequency of characters required from t
        for (char ch : t.toCharArray()) {
            target[ch]++;
        }

        int n = s.length();

        int i = 0;
        int j = 0;

        int count = 0;
        int required = t.length();

        int start = 0;
        int minLen = Integer.MAX_VALUE;

        // Sliding Window
        while (j < n) {

            // Add s[j] into the window
            if (target[s.charAt(j)] > 0) {
                count++;
            }

            target[s.charAt(j)]--;

            // Window is valid
            while (count == required) {

                // Check if current window is smaller
                if (minLen > j - i + 1) {
                    minLen = j - i + 1;
                    start = i;
                }

                // Remove s[i] from the window
                target[s.charAt(i)]++;

                if (target[s.charAt(i)] > 0) {
                    count--;
                }

                i++;
            }

            // Expand window
            j++;
        }

        // Return minimum window
        return (minLen == Integer.MAX_VALUE)
                ? ""
                : s.substring(start, start + minLen);
    }
}