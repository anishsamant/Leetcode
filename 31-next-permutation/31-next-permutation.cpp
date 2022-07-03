class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int len = nums.size(), i;
        if (len <= 1)
            return;
        
        for (i=len-2; i>=0; i--) {
            if (nums[i] < nums[i+1]) {
                break;
            }
        }
        if (i<0) {
            reverse(nums.begin(), nums.end());
        } else {
            int j;
            for (j=len-1; j>i; j--) {
                if (nums[j] > nums[i]) {
                    break;
                }
            }
            swap(nums[i], nums[j]);
            reverse(nums.begin() + (i+1), nums.end());
        }
        
    }
};