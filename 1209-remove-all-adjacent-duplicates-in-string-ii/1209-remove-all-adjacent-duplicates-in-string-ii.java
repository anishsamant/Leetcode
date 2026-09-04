class Solution {
    public String removeDuplicates(String s, int k) {
        // deeedbbcccbdaa
        Stack<Integer> counts = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int sbLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sbLen == 0 || s.charAt(i) != sb.charAt(sbLen - 1)) {
                counts.push(1);
                sb.append(s.charAt(i));
                sbLen++;
            } else {
                int count = counts.pop() + 1;
                if (count == k) {
                    sb.delete(sbLen - (k - 1), i + 1);
                    sbLen -= (k - 1);
                } else {
                    counts.push(count);
                    sb.append(s.charAt(i));
                    sbLen++;
                }
            }
        }

        return sb.toString();
    }
}