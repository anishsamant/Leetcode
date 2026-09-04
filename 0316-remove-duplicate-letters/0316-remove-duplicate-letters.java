class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> myQueue = new ArrayDeque<>();
        int[] seen = new int[26];

        Map<Character, Integer> lastOccurence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurence.put(s.charAt(i), i);
        }

        StringBuilder sb = new StringBuilder();
        int sbLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (seen[curr - 'a'] == 0) {
                while (sbLen > 0 && curr < sb.charAt(sbLen - 1) && lastOccurence.get(sb.charAt(sbLen - 1)) > i) {
                    char prev = sb.charAt(sbLen - 1);
                    sb.deleteCharAt(sbLen - 1);
                    sbLen--;
                    seen[prev - 'a'] = 0;
                }
                sb.append(curr);
                seen[curr - 'a'] = 1;
                sbLen++;
            }

        }

        return sb.toString();
    }
}