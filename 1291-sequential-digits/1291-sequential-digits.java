class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String sample = "123456789";
        int n = 9;
        List<Integer> ans = new ArrayList<>();
        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();

        for (int len = lowLength; len <= highLength; len++) {
            for (int i = 0; i <= n - len; i++) {
                int num = Integer.parseInt(sample.substring(i, i + len));
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }
}