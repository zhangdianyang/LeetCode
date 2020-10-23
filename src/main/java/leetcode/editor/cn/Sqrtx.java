//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 527 👎 0

package leetcode.editor.cn;

public class Sqrtx {

    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int mySqrt(int x) {
            int left = 0;
            int right = x;
            int ans = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if ((long) mid * mid == x) {
                    return mid;
                } else if ((long) mid * mid > x) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    ans = mid;
                    left = mid + 1;
                }
            }
            if (ans * ans > x) {
                ans = ans - 1;
            }
            return ans;
        }

//        public int mySqrt(int x) {
//            int l = 0, r = x, ans = -1;
//            while (l <= r) {
//                int mid = l + (r - l) / 2;
//                if ((long) mid * mid <= x) {
//                    ans = mid;
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            }
//            return ans;
//        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}