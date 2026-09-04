class Solution {
    public int compress(char[] chars) {
        int j = 0;
        int i = 0;
        while (i < chars.length) {
            int groupLen = 1;
            while (i + groupLen < chars.length && chars[i + groupLen] == chars[i]) {
                groupLen++;
            }

            chars[j++] = chars[i];
            if (groupLen > 1) {
                char[] groupLenArr = Integer.toString(groupLen).toCharArray();
                for (char c : groupLenArr) {
                    chars[j++] = c;
                }
            }  

            i += groupLen;
        }

        return j;
    }
}