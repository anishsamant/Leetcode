class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> myMap;
        int start = 0, len = s.length(), result = 0;
        for (int end=0; end<len; end++) {
            if (myMap.find(s[end]) != myMap.end()) {
                start = max(start, myMap[s[end]] + 1);
            } 
            myMap[s[end]] = end;
            result = max(result, end - start + 1);
        }
        
        return result;
    }
};