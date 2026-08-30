class Solution {

    private int getMin(List<Integer> endTimes) {
        int min = endTimes.get(0);
        for (int i = 0; i < endTimes.size(); i++) {
            min = Math.min(min, endTimes.get(i));
        }

        return min;
    }

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<Integer> endTimes = new ArrayList<>();
        for (int[] interval : intervals) {
            if (endTimes.size() > 0) {
                int min = getMin(endTimes);
                if (min <= interval[0]) {
                    endTimes.remove(Integer.valueOf(min));
                }
            }
           
            endTimes.add(interval[1]);
        }

        return endTimes.size();
    }
}