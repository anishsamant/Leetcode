class Solution {
public:
    int returnDays(vector<int> d) {
        int monthDays[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int days = 0;
        days = d[0]*365;
        days += d[2];
        
        for (int i=0; i<d[1]-1; i++) {
            days += monthDays[i];
        }
        
        int years = d[0];
        if (d[1] <= 2) {
            years--;
        }
        days += years/4 - years/100 + years/400;
        return days;
    }
    
    int daysBetweenDates(string date1, string date2) {
        string s1;
        stringstream ss1(date1);
        vector<int> d1;
        vector<int> d2;
        while(getline(ss1,s1,'-')) {
            d1.push_back(stoi(s1));
        }
        
        string s2;
        stringstream ss2(date2);
        while(getline(ss2,s2,'-')) {
            d2.push_back(stoi(s2));
        }
        
        return abs(returnDays(d1) - returnDays(d2));

    }
};