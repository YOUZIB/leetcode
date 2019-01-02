/*
	force : traverse the matrix,new a array,sort it, get the num k
	17 ms
*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
    	if(matrix.length == 0 || matrix[0].length == 0)
    		return  -1;
    	int rows = matrix.length;
    	int cols = matrix[0].length;
    	int number = rows * cols;
    	int [] list = new int [number];
    	int count = 0;
    	for(int i = 0;i<rows;i++)
    	{
    		for(int j = 0 ; j<cols;j++)
    		{
    			list[count] = matrix[i][j];
    			count++;
    		}
    	}
        Array.sort(list);
        return list [k-1];
    }
}

/*
	Binary : upper left corner is the min , bottom right corner is the max; new mid = (max-min)/2 +min count++
			 if the k<count right border=mid ,
			 		k>count left border =mid +1;
			 		k=count;return mid;
			 return lb;
	1 ms
*/


class Solution{
	public int kthSmallest(int[][] matrix ,int k){
		int n = matrix.length;
		int lb = matrix[0][0], rb = matrix[n-1][n-1];

		while(lb +1 < rb){
			int mid = (rb - lb)/2 + lb;
			int num = count(matrix,mid);
			if(num >=k){
				rb =mid;
			}else{
				lb = mid;
			}
		}
		if(count(matrix,rb) <= k-1) return rb;
		return lb;
	}

	public int count(int[][] matrix ,int target){
		int n = matrix.length;
		int i = n-1, j=0;// the bottom left corner 
		int res = 0;
		while(i>=0 && j<n){
			if(matrix[i][j] <target){ //if the bottom left corner is less than target,then the all numbers in the row so as
				res += i+1;// index +1 = number of elements.
				j++ ;// row ++;
			}else{
				i--;
			}
		}
		return res;
	}


}


