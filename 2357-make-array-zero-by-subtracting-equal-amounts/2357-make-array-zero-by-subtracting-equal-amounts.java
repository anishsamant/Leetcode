class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        for (int num : nums) {
            if (num != 0) mySet.add(num);
        }

        return mySet.size();
    }
}