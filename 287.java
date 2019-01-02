/*
	hashmap: NO because O(1) extra space
	sort:NO modify the array (assume the array is read only).
	Binary : YES this is the tag
	solution:take the middle of this array,(n+1)/2,traverse the array find how many integer less than or equal to (n+1)/2,
			 if the count bigger than (n+1)/2,the duplicate must have apperanced (1,(n+1)/2), deflate the right border to (n+1)/2,
			 else the left border is (n+1)/2,
			 now the array is (1,(n+1)/2) , or ( (1 + (n+1)/2),length)
			 repeat it until the left border = right border ,the number is answer.
*/


class Solution {
    public int findDuplicate(int[] nums) {
 		       int lb=1; // lb = left border
 		       int rb=nums.length;//rb= right border

 		       while(lb<rb){
 		       		int mid = 1+(rb-lb)/2;
 		       		int count = 0;
 		       		for (int i = 0;i<nums.length;i++ ) 
 		       		{
 		       			if(nums[i] <= mid)
 		       				count++;
 		       		}
 		       		if (count >mid)
 		       			rb = mid;
 		       		else lb = mid +1;
 		       }
 		       return lb;
    }
}