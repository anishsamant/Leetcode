class Solution {
public:
    string addBinary(string a, string b) {
        int len1 = a.size();
        int len2 = b.size();
        
        
        if (a.size() < b.size()) {
            int i = len1;
            while (i < len2) {
                a = '0' + a;
                i++;
            }
        } else {
            int i = len2;
            while (i < len1) {
                b = '0' + b;
                i++;
            }
        }
        
        int len = max(len1, len2);
        string res = "";
        int carry = 0;
        for (int i = len - 1; i >= 0; i--) {
            int resInt = (a[i] - '0' ^ b[i] - '0') ^ carry;
            res = to_string(resInt) + res;
            carry = (((a[i] - '0') & (b[i] - '0')) | ((a[i] - '0') & carry) | ((b[i] - '0') & carry));
        }
        
        res = to_string(carry) + res;
        int i = 0;
        
        while (res[i] == '0' && i < len)
            i++;
        
        return res.substr(i);
    }
};