class Solution {
/**
     * Container With Most Water
     * * You are given an integer array height of length n.
     * * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     * * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * * Return the maximum amount of water a container can store.
     * * Notice that you may not slant the container.
     * <p>
     * * solution:
     * 0, 1 -> 8, 7 = index r - index l (0 - 8 = 8)
     * max = 8 * min(1,7) = 8
     * find min of l and r ++
     * 1, 8 -> 8, 7 = index r - index l (1 - 8 = 7)
     * max = 7 * min(8,7) = 49
     * find min of l and r --
     * 1, 8 -> 7, 3 = index r - index l (1 - 8 = 7)
     */

    public int maxArea(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r){
            int length = r - l;
            max =Math.max(max,length * Math.min(height[l],height[r]));
            if(height[l] > height[r]){
                r--;
            }else{
                l++;
            }
        }
        return max;
    }
}
