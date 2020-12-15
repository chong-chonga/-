package cn.leetcode.list;

/**
 * @author 悠一木碧
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class SumOfTwoNumber {

    /**
     * 声明两个数组, 用于存放链表中的数字, 0索引处的代表个位上的数值, 1索引代表十位上的数值...以此类推
     * 声明一个sum数组, 用于存放两个数值相加所获得的结果, 最大位数为len+1, 因为可能会进1位
     * 然后将sum数组中的数字依次放到链表中, 返回链表的头结点即可
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getListLength(l1);
        int len2 = getListLength(l2);
        int len = Math.max(len1, len2);
        int[] array1 = new int[len];
        int[] array2 = new int[len];
        int[] sum = new int[len + 1];

        put(array1, l1, len1);
        put(array2, l2, len2);

        int x = 0;
        int summary = 0;
        for(int i = 0; i < len; i++){
            summary = array1[i] + array2[i] + x;
            sum[i] = (summary % 10);
            x= summary / 10;
        }
        sum[len] = x;

        ListNode head = null;
        ListNode l = null;
        if(0 == sum[len]){
            for(int i = 0; i < len; i++){
                if(null == head){
                    head = new ListNode(sum[i]);
                    l = head;
                }
                else {
                    l.next = new ListNode(sum[i]);
                    l = l.next;
                }
            }
        }
        else{
            for(int i = 0; i < len + 1; i++){
                if(null == head){
                    head = new ListNode(sum[i]);
                    l = head;
                }
                else {
                    l.next = new ListNode(sum[i]);
                    l = l.next;
                }
            }
        }

        return head;
    }

    /**
     * 获取链表的长度
     * @param listNode
     * @return
     */
    public int getListLength(ListNode listNode){
          int length = 0;
          while(listNode != null){
              length++;
              listNode = listNode.next;
          }
          return length;
    }

    /**
     * 将链表中的数字依次放入数组中
     * @param arr
     * @param listNode
     * @param len
     */
    public void put(int[] arr, ListNode listNode, int len){
          for(int i = 0; i < len; i++){
              arr[i] = listNode.val;
              listNode = listNode.next;
          }
    }


}
