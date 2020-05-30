/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/7/22 1.0          guchaolong          Creation File
 */
package com.guchaolong.algorithm.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 字符串，由字符组成，看成字符数组，每个字符有对应的int值（可以作为数组的索引，该索引处的值为该字符上次出现过的位置，没有出现过则为0
 *
 * 遍历数组，当有重复字符时，计算之间的len,最长的即为结果
 */
public class No3 {
    public static int lengthOfLongestSubstring(String s) {

        if (s == null || (s.length() == 0)) return 0;

        int preP = 0;//
        int max = 0;
        int[] hash = new int[128];

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (hash[c] > preP) {
                preP = hash[c];//上次出现的位置
            }

            int len = i + 1 - preP;
            hash[c] = i + 1;
            if (len > max) {
                max = len;
            }
        }
        return max;
    }


    public static int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);
            if (map.containsKey(c) && (i - map.get(c) > maxLen)) {
                maxLen = i - map.get(c);
            }
            map.put(c, i);
            i += 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }
}