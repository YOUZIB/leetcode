/*
15. 3Sum (Medium)
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note: The solution set must not contain duplicate triplets.
For example, given array S = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		 
		if (nums.length< 3) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			// if nums[i] == nums[i - 1](when i>0),nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0 mean,these three nums not achieve 0,just like last num i 
			if (i > 0 && nums[i] == nums[i - 1] || nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0) {
				continue; //break this loop.do  i++
			}
			if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
				break; // too big, no way to minus
			}
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					// Arrays.asList change array to a list 
					res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
					while (j < k && nums[k] == nums[k + 1]) { // if equals, undo
						k--;
					}
					while (j < k && nums[j] == nums[j - 1]) { //if equals, undo
						j++;
					}
				} else if (sum > 0) {//bigger , k--
					k--;
				}
				else {
					j++;//samller j++
				}
			}
		}
		return res;
	}
}