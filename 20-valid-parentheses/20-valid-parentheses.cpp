class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        int len = s.length();
        for (int i=0; i<len; i++) {
            if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
                st.push(s[i]);
                continue;
            }
            if (st.empty())
                return false;
            
            switch(s[i]) {
                case ')': if (st.top() == '[' || st.top() == '{') return false; break;
                    
                case ']': if (st.top() == '{' || st.top() == '(') return false; break;

                case '}': if (st.top() == '[' || st.top() == '(') return false; break;       
            }
            st.pop();
        }
        
        return st.empty();
    }
};