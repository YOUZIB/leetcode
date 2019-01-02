/*
	compare every row's upper right corner and target .
	if target bigger than it ,next row 
	else column--
	5ms
	
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length == 0 )
    		return false;
    		// upper right corner
    	int rowIndex = 0 ;
    	int columnIndex = matrix[0].length -1;
    	while(rowIndex < matrix.length && columnIndex >=0) // break condition
    	{
    		if(target == matrix[rowIndex][columnIndex])
    			return true;
    		else if (target >matrix[rowIndex][columnIndex])
    			rowIndex++;
    		else
    			columnIndex--;
    	}    
    	return false;
    }
}


/*
    binary:
    target < middle  right = mid -1
    else left = mid =1
    n = length.length=4
    row = nums/4
    column = muns%4
    8ms
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            
        int n = matrix[0].length;
        int lb = 0;
        int rb = matrix.length*matrix[0].length -1;
        while(lb <= rb)
            return false;
        {
            int mid = lb + (rb-lb)/2;
            if(target == matrix[mid/n][mid%n])
                return true;
            else if ( target < matrix[mid/n][mid%n])
                rb = mid -1;
            else 
                lb = mid +1;
        }
        return false ;
    }
}