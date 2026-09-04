class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> myQueue = new ArrayDeque<>();
        int[] seen = new int[26];

        Map<Character, Integer> lastOccurence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurence.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (seen[curr - 'a'] == 0) {
                while (!myQueue.isEmpty() && curr < myQueue.peekLast() && lastOccurence.get(myQueue.peekLast()) > i) {
                    char top = myQueue.pollLast();
                    seen[top - 'a'] = 0;
                }
                myQueue.offerLast(curr);
                seen[curr - 'a'] = 1;
            }

        }

        StringBuilder sb = new StringBuilder(myQueue.size());
        while (!myQueue.isEmpty()) { sb.append(myQueue.pollFirst()); }
        return sb.toString();
    }
}