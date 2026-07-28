class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<int[]> myList = new ArrayList<>();

        for (int i = 0; i < speed.length; i++) {
            myList.add(new int[]{speed[i], efficiency[i]});
        }

        myList.sort((a,b) -> b[1] - a[1]);

        PriorityQueue<Integer> myQueue = new PriorityQueue<>();
        long speedSum = 0;
        long maxPerf = 0;

        for (int[] eng : myList) {
            int spd = eng[0], eff = eng[1];
            speedSum += spd;

            myQueue.offer(spd);
            if (myQueue.size() > k) {
                speedSum -= myQueue.poll();
            }

            maxPerf = Math.max(maxPerf, speedSum * eff);
        }

        return (int) (maxPerf % 1_000_000_007);
    }
}