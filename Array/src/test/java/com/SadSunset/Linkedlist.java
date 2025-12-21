package com.SadSunset;

import com.SadSunset.common.ListNode;
import com.SadSunset.common.MyLinkedList;
import org.junit.jupiter.api.Test;

public class Linkedlist {
    //203. 移除链表元素
    //题意：删除链表中等于给定值 val 的所有节点。
    //示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
    //示例 2： 输入：head = [], val = 1 输出：[]
    //示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
    @Test
    public void Title203(){
        //[1,2,6,3,4,5,6]
        ListNode  head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(6);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(4);
        head.next.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next.next=new ListNode(6);
        int val=6;
        System.out.println(Answer203(head, val));
    }
    public ListNode  Answer203(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }



    //707.设计链表
    //在链表类中实现这些功能：
    //
    //get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    //addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    //addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
    //addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
    //deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
    @Test
    public void Title707(){
        //本题请自行打断点调试
        //创建一个我们设计的链表
        MyLinkedList linkedList = new MyLinkedList();
        //addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
        linkedList.addAtHead(1);
        //addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
        linkedList.addAtTail(3);
        //addAtIndex(index,val)：在链表的中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于
        linkedList.addAtIndex(1,2);
        //deleteAtIndex(index)：删除链表中的第 index 个节点。
        linkedList.deleteAtIndex(1);
        //get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
        System.out.println(linkedList.get(1));
    }
    public void  Answer707(ListNode head, int val) {
        //由于本题是设计链表相关的类型，也可请自行查看com.SadSunset.common.MyLinkedList
   //package com.SadSunset.common;
        //
        //public class MyLinkedList {
        //        class ListNode {
        //            int val;
        //            ListNode next;
        //            ListNode(int val) {
        //                this.val=val;
        //            }
        //        }
        //        //size存储链表元素的个数
        //        private int size;
        //        //注意这里记录的是虚拟头结点
        //        private ListNode head;
        //
        //        //初始化链表
        //        public MyLinkedList() {
        //            this.size = 0;
        //            this.head = new ListNode(0);
        //        }
        //
        //        //获取第index个节点的数值，注意index是从0开始的，第0个节点就是虚拟头结点
        //        public int get(int index) {
        //            //如果index非法，返回-1
        //            if (index < 0 || index >= size) {
        //                return -1;
        //            }
        //            ListNode cur = head;
        //            //第0个节点是虚拟头节点，所以查找第 index+1 个节点
        //            for (int i = 0; i <= index; i++) {
        //                cur = cur.next;
        //            }
        //            return cur.val;
        //        }
        //
        //        public void addAtHead(int val) {
        //            ListNode newNode = new ListNode(val);
        //            newNode.next = head.next;
        //            head.next = newNode;
        //            size++;
        //
        //            // 在链表最前面插入一个节点，等价于在第0个元素前添加
        //            // addAtIndex(0, val);
        //        }
        //
        //
        //        public void addAtTail(int val) {
        //            ListNode newNode = new ListNode(val);
        //            ListNode cur = head;
        //            while (cur.next != null) {
        //                cur = cur.next;
        //            }
        //            cur.next = newNode;
        //            size++;
        //
        //            // 在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
        //            // addAtIndex(size, val);
        //        }
        //
        //        // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
        //        // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
        //        // 如果 index 大于链表的长度，则返回空
        //        public void addAtIndex(int index, int val) {
        //            if (index < 0 || index > size) {
        //                return;
        //            }
        //
        //            //找到要插入节点的前驱
        //            ListNode pre = head;
        //            for (int i = 0; i < index; i++) {
        //                pre = pre.next;
        //            }
        //            ListNode newNode = new ListNode(val);
        //            newNode.next = pre.next;
        //            pre.next = newNode;
        //            size++;
        //        }
        //
        //        public void deleteAtIndex(int index) {
        //            if (index < 0 || index >= size) {
        //                return;
        //            }
        //
        //            //因为有虚拟头节点，所以不用对index=0的情况进行特殊处理
        //            ListNode pre = head;
        //            for (int i = 0; i < index ; i++) {
        //                pre = pre.next;
        //            }
        //            pre.next = pre.next.next;
        //            size--;
        //        }
        //}
    }



    //206.反转链表
    //题意：反转一个单链表。
    //示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
    @Test
    public void Title206(){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        System.out.println(Answer206(head));
    }
    public ListNode  Answer206(ListNode head) {
        ListNode prev = null;   // 1. 初始化前驱节点为 null（反转后原头节点会指向 null）
        ListNode cur = head;    // 2. 当前节点从 head 开始
        ListNode temp = null;   // 3. 临时变量，用于保存下一个节点（防止断链）

        while (cur != null) {   // 4. 遍历链表，直到当前节点为空（即走完所有节点）
            temp = cur.next;    // 5. 保存 cur 的下一个节点（因为下一步要改 cur.next）
            cur.next = prev;    // 6. 反转：让当前节点指向前一个节点（prev）
            prev = cur;         // 7. prev 向前移动一步，变为当前节点
            cur = temp;         // 8. cur 向前移动一步，变为原来的下一个节点
        }
        return prev;            // 9. 循环结束后，prev 指向原链表的最后一个节点，即新链表的头
    }


    //24. 两两交换链表中的节点
    //给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    //你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    @Test
    public void Title24(){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        System.out.println(Answer24(head));
    }
    public ListNode  Answer24(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        //循环条件：后面至少有两个节点才能交换
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;// 第 1 个节点
            ListNode node2 = cur.next.next;// 第 2 个节点
            //交换两个节点
            cur.next = node2; // 步骤 1
            node1.next = node2.next;// 步骤 2
            node2.next = node1;// 步骤 3
            cur = cur.next.next;
        }
        return dummy.next;
    }

    @Test
    //19.删除链表的倒数第N个节点
    //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    //进阶：你能尝试使用一趟扫描实现吗？
    public void Title19(){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        System.out.println(Answer19(head, 2));
    }
    public ListNode  Answer19(ListNode head,int n) {
        ListNode dummyHead =new ListNode(0,head);
        ListNode fastNode=dummyHead,slowNode=dummyHead;
        for (int i = 0; i <n ; i++) {
           fastNode= fastNode.next;
        }
      while(fastNode.next!=null){
          fastNode= fastNode.next;
          slowNode=slowNode.next;
      }
        if (slowNode.next != null) {
            slowNode.next = slowNode.next.next;
        }
      return dummyHead.next;
    }



    //面试题 02.07. 链表相交
    //给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
    // 如果两个链表没有交点，返回 null 。
    //题目数据 保证 整个链式结构中不存在环。
    //注意，函数返回结果后，链表必须 保持其原始结构 。
    //简单来说，就是求两个链表交点节点的指针。 要注意，交点不是数值相等，而是指针相等。
    @Test
    public void Title面试题0207(){
        //listB=[4,1,8,4,5], listB = [5,0,1,8,4,5]
        ListNode listA = new ListNode(4);
        listA.next=new ListNode(1);
        listA.next.next=new ListNode(8);
        listA.next.next.next=new ListNode(4);
        listA.next.next.next.next=new ListNode(5);
        ListNode listB = new ListNode(5);
        listB.next=new ListNode(0);
        listB.next.next=new ListNode(1);
        listB.next.next.next=listA.next.next;
        listB.next.next.next.next=new ListNode(4);
        listB.next.next.next.next.next=new ListNode(5);
        System.out.println(Answer面试题0207(listA, listB));
    }
    public ListNode  Answer面试题0207(ListNode headA,ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {

            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }



    //#142.环形链表II
    //题意： 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    //为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
    //说明：不允许修改给定的链表。
    @Test
    public void Title142(){
        //listB=[4,1,8,4,5], listB = [5,0,1,8,4,5]
        ListNode listA = new ListNode(4);
        listA.next=new ListNode(1);
        listA.next.next=new ListNode(8);
        listA.next.next.next=new ListNode(4);
        listA.next.next.next.next=listA.next.next;
        ListNode listB =Answer142(listA);
        System.out.println("--------------------------");
    }

    public ListNode  Answer142(ListNode head) {
        if (head == null || head.next == null|| head.next.next == null) {
            return null; // 无环
        }
        ListNode fastNode=head.next.next;
        ListNode slowNode=head.next;
        while (fastNode != null && fastNode.next != null && fastNode != slowNode) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        if (fastNode == null || fastNode.next == null) {
            return null; // 无环
        }
//在头结点处定一个指针index1，定义一个指针index2
        ListNode index1=head;
        ListNode index2=fastNode;
        while(index1!=index2 && index2 != null && index1!= null){
            index1=index1.next;
            index2=index2.next;
        }
        return index1;
    }




}
