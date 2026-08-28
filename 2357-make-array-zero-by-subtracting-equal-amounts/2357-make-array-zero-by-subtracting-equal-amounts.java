class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int sub = 0;
        for (int num : nums) {
            if (num - sub != 0) {
                sub += (num - sub);
                res++;
            }
        }

        // 0,1,3,5,5
        // sub - 0, 1, 3, 5
        // res - 0, 1, 2, 3

        return res;
    }
}