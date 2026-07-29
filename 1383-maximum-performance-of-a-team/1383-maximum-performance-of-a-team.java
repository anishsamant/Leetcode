class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<int[]> myList = new ArrayList<>();
        for (int i = 0; i < speed.length; i++) {
            myList.add(new int[]{speed[i], efficiency[i]});
        }

        myList.sort((a,b) -> b[1] - a[1]);

        long speedSum = 0;
        long maxPerf = 0;
        PriorityQueue<Integer> speeds = new PriorityQueue<>();
        for (int i = 0; i < myList.size(); i++) {
            int spd = myList.get(i)[0];
            int eff = myList.get(i)[1];
            speedSum += spd;
            speeds.offer(spd);

            if (speeds.size() > k) {
                speedSum -= speeds.poll();
            }

            maxPerf = Math.max(maxPerf, speedSum * eff);
        }

        return (int) (maxPerf % 1_000_000_007);
    }
}