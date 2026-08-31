class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();

        // Map<Character, Integer> countP = new HashMap<>();
        // Map<Character, Integer> window = new HashMap<>();
        int[] window = new int[26];
        int[] countP = new int[26];

        for (int i = 0; i < p.length(); i++) {
            // countP.put(p.charAt(i), countP.getOrDefault(p.charAt(i), 0) + 1);
            countP[p.charAt(i) - 'a']++;
        }

        int need = 0;
        for (int i = 0; i < 26; i++) {
            if (countP[i] > 0) need++;
        }

        int l = 0;
        int have = 0;
        // int need = countP.size();
        List<Integer> ans = new ArrayList<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            // window.put(c, window.getOrDefault(c, 0) + 1);
            window[c - 'a']++;

            // if (countP.containsKey(c) && countP.get(c).equals(window.get(c))) {
            //     have++;
            // }
            if (countP[c - 'a'] == window[c - 'a']) { have++; }

            while (have == need) {
                if (r - l + 1 == p.length()) {
                    ans.add(l);
                }

                char lc = s.charAt(l);
                //window.put(lc, window.get(lc) - 1);
                window[lc - 'a']--;
                l++;
                // if (countP.containsKey(lc) && window.get(lc) < countP.get(lc)) {
                //     have--;
                // }
                if (window[lc - 'a'] < countP[lc - 'a']) { have--; }
            }
        }

        return ans;
    }
}