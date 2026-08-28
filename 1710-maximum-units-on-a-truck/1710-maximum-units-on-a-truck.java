class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int res = 0;
        for (int[] boxType: boxTypes) {
            if (truckSize == 0) {
                break;
            }
            int numBoxes = Math.min(truckSize, boxType[0]);
            res += (boxType[1] * numBoxes);
            truckSize -= numBoxes;        
        }

        return res;
    }
}