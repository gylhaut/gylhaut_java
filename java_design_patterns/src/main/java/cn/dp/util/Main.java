package cn.dp.util;

public class Main {
    public static void main(String[] args){
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node h = head;
        while (head!= null){
            System.out.println(head.value);
            head = head.next;
        }

        System.out.println("****************************************");
        // 打印反转前的链表
        h =reverseList(h);
        while (h != null){
            System.out.println(h.value);
            h = h.next;
        }
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
