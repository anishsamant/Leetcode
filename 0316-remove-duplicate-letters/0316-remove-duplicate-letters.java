class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> myStack = new Stack<>();
        Set<Character> seen = new HashSet<>();

        Map<Character, Integer> lastOccurence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurence.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (!seen.contains(curr)) {
                while (!myStack.isEmpty() && curr < myStack.peek() && lastOccurence.get(myStack.peek()) > i) {
                    seen.remove(myStack.pop());
                }
                myStack.add(curr);
                seen.add(curr);
            }

        }

        StringBuilder sb = new StringBuilder(myStack.size());
        for (Character c : myStack) { sb.append(c.charValue()); }
        return sb.toString();
    }
}