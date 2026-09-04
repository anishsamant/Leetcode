class Solution {
    public String removeDuplicates(String s, int k) {
        // deeedbbcccbdaa
        Stack<Integer> counts = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        // int sbLen = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.push(1);
                // sb.append(s.charAt(i));
                // sbLen++;
            } else {
                int count = counts.pop() + 1;
                if (count == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                    //sbLen -= (k - 1);
                } else {
                    counts.push(count);
                    // sb.append(s.charAt(i));
                    // sbLen++;
                }
            }
        }

        return sb.toString();
    }
}