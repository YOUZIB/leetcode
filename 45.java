public class Solution {
    public int jump(int[] nums) {
    	/**
    	 * the strategy is measuring every step length,and try to go most long
    	 */
        if(nums.length <= 1){//when nums.length=1 done 
            return 0;
        }
        int index,max = 0;
        int step = 0,i= 0;
        while(i < nums.length){
        	//if i can arrive the end, run to nums.length-1 to the end 
            if(i + nums[i] >= nums.length - 1){
            	step++;
            	break;
            }
            max = 0;//initialize it every time 
            index = i+1;//record index everytime, at least one

            // core ! searching the max step can run ,j=i+1,j++  j-1<=nums[i],search next step, else step++ 
            for(int j = i+1; j-i <= nums[i];j++){
                if(max < nums[j] + j-i){ //done 
                    max = nums[j] + j-i;//record max 
                    index = j;//record max index 
                }// or j++
            }
            i = index;// run the max can run
            step++;
        }
        return step;
    }
}