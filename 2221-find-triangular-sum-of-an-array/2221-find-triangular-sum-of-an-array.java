class Solution {
    public int triangularSum(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] newNums = new int[nums.length];
        for (int i = nums.length - 1; i >= 1; i--) {
            newNums = new int[i];
            for (int j = 0; j < nums.length - 1; j++) {
                newNums[j] = (nums[j] + nums[j + 1]) % 10;
            }
            nums = Arrays.copyOf(newNums, newNums.length);
        } 
        

        return newNums[0];
    }
}