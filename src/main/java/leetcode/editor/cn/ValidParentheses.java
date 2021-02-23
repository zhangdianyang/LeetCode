//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2176 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {

    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isValid(String s) {
            Map<String, String> tmpMap = new HashMap<String, String>();
            tmpMap.put("}", "{");
            tmpMap.put(")", "(");
            tmpMap.put("]", "[");
            tmpMap.put("?", "?");
            char[] chars = s.toCharArray();
            LinkedList<Character> stack = new LinkedList<Character>();
            stack.addLast("?".charAt(0));
            for (char aChar : chars) {
                // 如果是右括号
                if (tmpMap.containsKey(String.valueOf(aChar))) {
                    Character stackLastChar = stack.removeLast();
                    // 比较两个值 如果匹配 则继续 不匹配则返回false
                    String s1 = tmpMap.get(String.valueOf(aChar));
                    if (!String.valueOf(stackLastChar).equals(s1)) {
                        return false;
                    }
                } else {
                    // 入栈
                    stack.addLast(aChar);
                }
            }
            return stack.size() == 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}