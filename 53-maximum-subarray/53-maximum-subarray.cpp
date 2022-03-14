class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res = nums[0];
        int curMax = nums[0];
        int len = nums.size();
        for (int i=1; i<len; i++) {
            curMax = max(nums[i], nums[i] + curMax);
            res = max(res, curMax);
        }
        return res;
            
    }
};