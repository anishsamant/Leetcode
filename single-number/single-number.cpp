class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int val = 0;
        int len = nums.size();
        
        for (int i=0 ;i<len; i++) {
            val ^= nums[i];
        }
        
        return val;
    }
};