/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution{
	boolean flag = true;
	public ListNode detectCycle(ListNode head){
		ListNode pHead = head;
		if(pHead == null || pHead.next == null)
			return null;
		ListNode pNode = judgeHasChain(pHead);
		if(pNode != null){
			int lengthChain =1;
			ListNode pNodeCopy =pNode.next;
			while(pNodeCopy != pNode)
			{
				lengthChain++;
				pNodeCopy = pNodeCopy.next;
			}
			ListNode fast = pHead;
			ListNode slow = pHead;
			int temp = 0;
			while(temp < lengthChain)
			{
				fast = fast.next;
				temp++;
			}
			while(fast != slow)
			{
				fast = fast.next;
				slow = slow.next;
			}
			return fast;
		}
		return null;
	}
	private ListNode judgeHasChain(ListNode pHead){
		ListNode fast =pHead.next;
		ListNode slow = pHead;
		while(fast != slow)
		{
			if(fast != null && fast.next != null){
				fast =fast.next;
			}else{
				flag = false;
				break;
			}
			if(slow != null && slow.next != null){
				slow =slow.next;
			}else{
				flag =false;
				break;
			}
			if(fast == slow){
				return fast;
			}else{
				fast =fast.next;
			}
		}
		if(flag)
			return fast;
		return null;
	}
}





















/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//extra space 8ms

public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        if(head == null || head.next == null)
        	return null;
        while(head != null)
        {
        	if(map.containsKey(head) == false){
        		map.put(head,1);
        		head = head.next;
        	}else{
        		return head;
        	}
        }
        return null;
    }
}