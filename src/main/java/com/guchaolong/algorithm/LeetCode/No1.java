/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/6/3 1.0          guchaolong          Creation File
 */
package com.guchaolong.algorithm.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/6/3 23:34
 */
public class No1 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */



    /**
     * 思路：遍历数组，当前值num[i], 需要找到的另一个值为target-num[i]
     * 使用map存储每次遍历到的值num[i]，i
     * 利用map.containsKey(),如果包含了，就说明两个数都找到了，如果不包含，就放到map里，继续往下
     * 打印数组 Arrays.toString()
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int dec = target - nums[i];
            if (map.containsKey(dec)) {
                return new int[]{map.get(dec), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}