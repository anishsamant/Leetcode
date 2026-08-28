class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        // int res = 0;
        // for (int[] boxType: boxTypes) {
        //     if (truckSize == 0) {
        //         break;
        //     }
        //     int numBoxes = Math.min(truckSize, boxType[0]);
        //     res += (boxType[1] * numBoxes);
        //     truckSize -= numBoxes;        
        // }

        // return res;

        int[] boxesForUnits = new int[1001];
        // Arrays.fill(boxesForUnits, 0);
        for (int[] boxType : boxTypes) {
            boxesForUnits[boxType[1]] += boxType[0];
        }
        // 3 -> 1
        // 2 -> 2
        // 1 -> 3

        int res = 0;
        for (int i = 1000; i >= 1; i--) {
            if (boxesForUnits[i] != 0) {
                if (truckSize == 0) break;
                int numBoxes = Math.min(truckSize, boxesForUnits[i]);
                res += (i * numBoxes);
                truckSize -= numBoxes;
            }
        }

        return res;
    }
}