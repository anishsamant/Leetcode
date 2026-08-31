class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) prefix[i] = prefix[i - 1] + 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (security[i + 1] >= security[i]) suffix[i] = suffix[i + 1] + 1;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (prefix[i] >= time && suffix[i] >= time) ans.add(i);
        }

        return ans;
    }
}