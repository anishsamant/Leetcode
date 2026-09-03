class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int sbLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sbLen > 0 && sb.charAt(sbLen - 1) == s.charAt(i)) {
                sb.deleteCharAt(sbLen - 1);
                sbLen--;
            } else {
                sb.append(s.charAt(i));
                sbLen++;
            }
        }

        return sb.toString();
    }
}