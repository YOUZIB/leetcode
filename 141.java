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
	public boolean hasCycle(ListNode head){
		if(head == null || head.next == null)
			return false;
		/*
		why fast = head.next ; slow = head?
		case 1:fast =head , slow = head.
			return true,because they are already equals
		case 2:fast =head , slow = head.next
			return true, fast.next = head.next.next; slow.next = head.next.next;
		*/
		ListNode fast = head.next;
		ListNode slow = head;
		while(slow != null && fast != null){
			if(fast == slow)
				return true;//return ture; error:cannot find symbol
			if(slow.next != null)
				slow = slow.next;//slow = head.next
			else
				return false;
			if(fast.next != null)
				fast = fast.next.next;//fast = head.next.next.next
			else
				return false;
		}
		return false;
	}
}
