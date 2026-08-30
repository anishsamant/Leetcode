class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String str : strs) {
            int[] keyArray = new int[26];
            for (char c : str.toCharArray()) {
                keyArray[c - 'a']++;
            }
            String key = Arrays.toString(keyArray);
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(str);
        }

        return new ArrayList<>(res.values());
    }
}