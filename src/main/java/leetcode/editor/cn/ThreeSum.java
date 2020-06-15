//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> totalList = new ArrayList<List<Integer>>();
            for (int i = 0; i < nums.length; i++) {
                List<Integer> numListTemp = new ArrayList<Integer>();
                twoSum(numListTemp, nums, -nums[i], i);
                if (numListTemp.size() == 0) {
                    continue;
                }
                totalList.add(numListTemp);
            }
            return totalList;
        }

        private void twoSum(List<Integer> numList, int[] nums, int target, int index) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (i == index) {
                    continue;
                }
                if (map.containsKey(target - nums[i])) {

                }
                map.put(nums[i], i);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}