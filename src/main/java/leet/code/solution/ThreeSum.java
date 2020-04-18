package leet.code.solution;

import java.util.*;

public class ThreeSum {

//    public static List<List<Integer>> threeSum(int[] num) {
//        Arrays.sort(num);
//        List<List<Integer>> res = new LinkedList<>();
//        for (int i = 0; i < num.length-2; i++) {
//            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
//                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
//                while (lo < hi) {
//                    if (num[lo] + num[hi] == sum) {
//                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
//                        while (lo < hi && num[lo] == num[lo+1]) lo++;
//                        while (lo < hi && num[hi] == num[hi-1]) hi--;
//                        lo++; hi--;
//                    } else if (num[lo] + num[hi] < sum) lo++;
//                    else hi--;
//                }
//            }
//        }
//        return res;
//    }
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<Integer> temp = new ArrayList<>();
//        List<List<Integer>> result = new ArrayList<>();
//
//        for (int i = 2; i < nums.length; i++) {
//            temp.add(nums[i]);
//        }
//
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                Integer key = (nums[i] + nums[j]) * -1;
//                if (temp.contains(key) && nums[i] != nums[j]) {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(nums[i]);
//                    list.add(nums[j]);
//                    list.add(key);
//
//                    temp.remove(key);
//                    result.add(list);
//
//                }
//            }
//        }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//    }
}
