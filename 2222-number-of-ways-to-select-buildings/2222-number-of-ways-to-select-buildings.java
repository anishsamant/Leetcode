class Solution {
    public long numberOfWays(String s) {
        // 101
        // 010
        long res = 0;
        int[] cnt = new int[2];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - '0']++;
        }

        long currZeros = 0, currOnes = 0;
        if (s.charAt(0) == '0') currZeros++;
        else currOnes++;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                res += (currOnes * (cnt[1] - currOnes));
                currZeros++;
            } else {
                res += (currZeros * (cnt[0] - currZeros));
                currOnes++;
            }
        }

        return res;
    }
}