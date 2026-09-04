class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> myQueue = new ArrayDeque<>();
        Set<Character> seen = new HashSet<>();

        Map<Character, Integer> lastOccurence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurence.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (!seen.contains(curr)) {
                while (!myQueue.isEmpty() && curr < myQueue.peekLast() && lastOccurence.get(myQueue.peekLast()) > i) {
                    seen.remove(myQueue.pollLast());
                }
                myQueue.offerLast(curr);
                seen.add(curr);
            }

        }

        StringBuilder sb = new StringBuilder(myQueue.size());
        while (!myQueue.isEmpty()) { sb.append(myQueue.pollFirst()); }
        return sb.toString();
    }
}