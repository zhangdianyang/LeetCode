//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 818 👎 0

package leetcode.editor.cn;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = solution.swapPairs(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        // 新容器  变量交换  递归
        public ListNode swapPairs(ListNode head) {
            return swapTwo(head);
        }

        // 变量交换
        private ListNode swapOne(ListNode head) {
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode a = pre;
            ListNode b = pre;
            ListNode t = pre;
            while (b.next != null && b.next.next != null) {
                a = a.next;
                b = b.next.next;
                // 交换
                a.next = b.next;
                b.next = a;
                t.next = b;
                // 位移
                t = a;
                b = a;
            }
            return pre.next;
        }

        // 递归
        private ListNode swapTwo(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode tmp = head.next;
            head.next = swapTwo(tmp.next);
            tmp.next = head;
            return tmp;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}