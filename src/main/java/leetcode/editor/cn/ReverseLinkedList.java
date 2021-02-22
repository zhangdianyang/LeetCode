//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1514 👎 0

package leetcode.editor.cn;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = solution.reverseList(node1);
        System.out.println(node.val);
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
        public ListNode reverseList(ListNode head) {
            return reverseTwo(head);
        }

        // 递归
        private ListNode reverseOne(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode cur = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return cur;
        }

        // 变量交换
        private ListNode reverseTwo(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode tmp = cur.next;
                // 翻转
                cur.next = pre;
                // 位移
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
        
    }
    //leetcode submit region end(Prohibit modification and deletion)

}