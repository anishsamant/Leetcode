class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // index, value
        PriorityQueue<int[]> myQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < k; i++) {
            myQueue.offer(new int[]{i, nums[i]});
        }

        int len = nums.length - k + 1;
        int[] ans = new int[len];
        ans[0] = myQueue.peek()[1];

        int l = 1;
        for (int i = k; i < nums.length; i++) {
            while (!myQueue.isEmpty() && myQueue.peek()[0] <= i - k) {
                myQueue.poll();
            }

            myQueue.offer(new int[]{i, nums[i]});
            ans[l++] = myQueue.peek()[1];
        }

        return ans;
    }
}