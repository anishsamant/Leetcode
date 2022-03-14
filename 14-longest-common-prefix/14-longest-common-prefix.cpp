class Solution {
public:
    string commonPrefix(string s1, string s2) {
        string res = "";
        int n1 = s1.length(), n2=s2.length();
        for (int i=0, j=0; i<n1 && j<n2; i++, j++) {
            if(s1[i] == s2[j]) {
                res += s1[i];
            } else {
                break;
            }
        }
        return res;
    }
    
    string longestCommonPrefix(vector<string>& strs) {
        string prefix = strs[0];
        
        int len = strs.size();
        for (int i=1; i<len; i++) {
            prefix = commonPrefix(strs[i], prefix);
        }
        
        return prefix;     
    }
};