class Solution {
    public int maxCoins(int[] nums) {
        int[] fullNums = new int[nums.length+2];//defensive coding
        fullNums[0] = 1;
        fullNums[nums.length+1] = 1;
        for(int i = 1;i<=nums.length;++i)   //int i= 1 ,so the nums.length donnot need minus 1
        fullNums[i]=nums[i-1];   //fullNums[0]=1,fullNums[1]=nums[0],fullNums[4]=nums[3]

        int[][] store=new int[fullNums.length][fullNums.length];
        
        //initialize it , except for arrpering some bugs, because we know the nums all bigger than one ,so initialize it for -1
        for(int i = 1;i<fullNums.length;++i){
        	for(int j =1 ; j<fullNums.length;++j){
        	store[i][j] = -1;
        	}
        }

        return getStore(1,fullNums.length-2,store,fullNums);

    }

    private int getStore(int begin,int end,int[][] store ,int[] fullNums){
    	if(begin>end) return 0; //over
    	if(store[begin][end]!= -1) return store[begin][end];      //have been calculated

    	for(int position=begin; position<=end; ++position){
    		int leftCoin = getStore(begin,position-1,store,fullNums);            //max(left) begin=begin end=position-1
    		int midCoin = fullNums[begin-1]*fullNums[position]*fullNums[end+1];
    		int rightCoin = getStore(position+1,end,store,fullNums);        //max(right);	begin=position+1 end =end
    		int coin = leftCoin + midCoin + rightCoin;
    		if(coin > store[begin][end]) store[begin][end]=coin; //max methods
    	}
    	return store[begin][end];
    }
}