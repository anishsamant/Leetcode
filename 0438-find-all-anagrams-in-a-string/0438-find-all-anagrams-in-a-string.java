class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();

        Map<Character, Integer> countP = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            countP.put(p.charAt(i), countP.getOrDefault(p.charAt(i), 0) + 1);
        }

        int l = 0;
        int have = 0, need = countP.size();
        List<Integer> ans = new ArrayList<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countP.containsKey(c) && countP.get(c).equals(window.get(c))) {
                have++;
            }

            while (have == need) {
                if (r - l + 1 == p.length()) {
                    ans.add(l);
                }

                char lc = s.charAt(l);
                window.put(lc, window.get(lc) - 1);
                l++;
                if (countP.containsKey(lc) && window.get(lc) < countP.get(lc)) {
                    have--;
                }
            }
        }

        return ans;
    }
}