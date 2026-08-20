class Solution {

    boolean isPalin(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        return s.equals(sb.toString());
    }

    void getAllParts(String s, List<String> partitions, List<List<String>> ans) {

        // base case
        if (s.length() == 0) {
            ans.add(new ArrayList<>(partitions));
            return;
        }

        for (int i = 0; i < s.length(); i++) {

            String part = s.substring(0, i + 1);

            if (isPalin(part)) {

                partitions.add(part);

                getAllParts(s.substring(i + 1), partitions, ans);

                partitions.remove(partitions.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        getAllParts(s, path, ans);

        return ans;
    }
}