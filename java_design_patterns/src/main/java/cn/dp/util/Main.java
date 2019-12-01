package cn.dp.util;

public class Main {
    public static void main(String[] args){

    }

    /**
     * 使用迭代方式实现链表反转
     * @param head
     * @return
     */
    public static Node reverse(Node head){
        if (head == null|| head.next == null){
            return head;
        }
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 使用循环实现链表的反转
     * @param head
     * @return
     */
    public static Node reverseList(Node head){
        if (head== null || head.next==null){
            return head;
        }
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next =pre;
            pre = head;
            head =next;
        }
        return pre;
    }
    public static Node reverserListNode(Node head){
        if (head == null || head.next ==null){
            return head;
        }
        //前一个节点指针
        Node preNode = null;
        //当前节点
        Node curNode = head;
        //下一个节点
        Node nextNode = null;
        while (curNode !=null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode= curNode;
            curNode = nextNode;
        }
        return preNode;
    }
}
