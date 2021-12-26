class Solution {
public:
    string multiply(string num1, string num2) {
        int len1 = num1.size();
        int len2 = num2.size();
        
        if (num1 == "0" || num2 == "0")
            return "0";
        
        vector<int> num(num1.size() + num2.size(), 0);
        
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                num[i + j + 1] += (num1[i] - '0') * (num2[j] - '0');
                num[i + j] += num[i + j + 1]/10;
                num[i + j + 1] %= 10;
            }
        }
        
        string result = "";
        
        int i = 0;
        while (num[i] == 0)
            i++;
        
        for (; i < num.size(); i++)
            result += (num[i] + '0');
        
        return result;
    }
    
};