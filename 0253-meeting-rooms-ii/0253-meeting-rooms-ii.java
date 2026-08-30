class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (endTimes.size() > 0 && endTimes.peek() <= interval[0]) {
                endTimes.poll();
            }
           
            endTimes.offer(interval[1]);
        }

        return endTimes.size();
    }
}