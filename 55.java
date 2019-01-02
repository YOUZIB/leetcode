public class Solution {
public boolean canJump(int[] nums) {
		// input error 
		if (nums == null || nums.length < 1)
			return false;
		if (nums.length == 1)
			return true; // done

		int end = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) { // i=0,i-- flase
			if (i + nums[i] >= end) // if (i + nums[i] >= end) end = i; else flase 
				end = i;
		}
		return end == 0 ; // == means equals?   end = i = 0 ,true   
	} 
}



