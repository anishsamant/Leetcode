class Solution {
    public String reorganizeString(String s) {
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        int maxCount = 0, maxLetter = 0;
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] > maxCount) {
                maxCount = charCounts[i];
                maxLetter = i;
            }
        }

        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }

        char[] ans = new char[s.length()];
        int index = 0;
        while (charCounts[maxLetter] > 0) {
            ans[index] = (char) (maxLetter + 'a');
            index += 2;
            charCounts[maxLetter]--;
        }

        for (int i = 0; i < 26; i++) {
            while (charCounts[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index += 2;
                charCounts[i]--;
            }
        }
        
        return String.valueOf(ans);
    }
}