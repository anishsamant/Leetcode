class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int len = nums.size();
        vector<int> ans;
        unordered_map<int,int> numMap;
        for (int i = 0; i < len; i++) {
            if (numMap.find(target-nums[i]) != numMap.end()) {
                ans.push_back(numMap[target-nums[i]]);
                ans.push_back(i);
                break;
            }
            numMap[nums[i]] = i;
        } 
        return ans;
    }
};