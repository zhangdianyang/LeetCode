//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 856 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = solution.maxSlidingWindow(nums, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            return maxSlidingWindowTwo(nums, k);
        }

        // 最大堆
        private int[] maxSlidingWindowOne(int[] nums, int k) {
            if (nums == null || nums.length < 2) {
                return nums;
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
                }
            });
            int n = nums.length;
            int[] result = new int[n - k + 1];
            for (int i = 0; i < k; i++) {
                pq.offer(new int[]{nums[i], i});
            }
            result[0] = pq.peek()[0];
            for (int i = k; i < n; i++) {
                pq.offer(new int[]{nums[i], i});
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                result[i - k + 1] = pq.peek()[0];
            }
            return result;
        }

        // 双向队列
        private int[] maxSlidingWindowTwo(int[] nums, int k) {
            if (nums == null || nums.length < 2) {
                return nums;
            }
            LinkedList<Integer> queue = new LinkedList<>();
            int n = nums.length;
            int[] result = new int[n - k + 1];
            for (int i = 0; i < k; i++) {
                while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                    queue.pollLast();
                }
                queue.offerLast(i);
            }
            result[0] = nums[queue.peekFirst()];
            for (int i = k; i < n; i++) {
                while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                    queue.pollLast();
                }
                queue.offerLast(i);
                while (queue.peekFirst() <= i - k) {
                    queue.pollFirst();
                }
                result[i - k + 1] = nums[queue.peekFirst()];
            }
            return result;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}