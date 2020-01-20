package cn.xiongyu.nowcoder.offer;

import org.junit.jupiter.api.Test;

/**
 * ClassName: RepeatListNode
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-19 下午3:23
 * Author: xiongyu
 */
public class RepeatListNode {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode pre = new ListNode(pHead.val - 1);
        pre.next = pHead;
        ListNode head = pre;
        ListNode curr = pHead;
        boolean flag = true;
        while (curr != null && curr.next != null) {
//            System.out.println(curr.val);
            if (curr.val == curr.next.val) {
                flag = false;
            } else {
                if (flag) {
                    head.next = curr;
                    head = curr;
                } else {
                    flag = true;
                }
            }
            curr = curr.next;
        }
        if (flag) {
            head.next = curr;
        } else {
            head.next = null;
        }
        return pre.next;
    }
    @Test
    public void test01() {
        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(2);
        pHead.next.next = new ListNode(3);
        pHead.next.next.next = new ListNode(3);
        pHead.next.next.next.next = new ListNode(4);
        pHead.next.next.next.next.next = new ListNode(4);
        pHead.next.next.next.next.next.next = new ListNode(5);
        deleteDuplication(pHead);
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
