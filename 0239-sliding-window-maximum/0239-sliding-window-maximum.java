class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int len = nums.length - k + 1;
        int[] ans = new int[len];

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }        

        ans[0] = nums[dq.peekFirst()];

        int l = 1;
        for (int r = k; r < nums.length; r++) {
            if (dq.peekFirst() <= r - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[r] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(r);
            ans[l++] = nums[dq.peekFirst()];
        }

        return ans;
    }
}