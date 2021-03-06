class Solution {
public:
    
    double getMedian(vector<int> a, int n, vector<int> b, int m) {
        int median;
        int min_index = 0, max_index = n, i, j;
        while (min_index <= max_index) {
            i = (min_index + max_index)/2;
            j = ((n + m + 1)/2) - i;
            
            if (j < 0) {
                max_index = i - 1;
                continue;
            }
            
            if (i < n && j > 0 && a[i] < b[j-1])
                min_index = i + 1;
            
            else if (i > 0 && j < m && b[j] < a[i-1])
                max_index = i - 1;
            
            else {
                if (i==0)
                    median = b[j-1];
                
                else if (j==0)
                    median = a[i-1];
                
                else
                    median = max(a[i-1], b[j-1]);
                
                break;
            }
        }
        
        if ((n+m) % 2 == 1) {
            return (double)median;
        }
        
        if (i==n)
            return (median + b[j])/2.0;
        
        if (j==m)
            return (median + a[i])/2.0;
        
        return (median + min(a[i], b[j]))/2.0;
    }
    
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if (nums1.size() < nums2.size())
            return getMedian(nums1, nums1.size(), nums2, nums2.size());
        
        return getMedian(nums2, nums2.size(), nums1, nums1.size());
    }
};