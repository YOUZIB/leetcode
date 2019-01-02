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
	binary: search the columns fitst , get the target row
			then search the row
	7ms	

*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
        	return false ;
        int start = 0 ;
        int end = matrix.length -1 ;
        int midRow =(start + end )/2; // if you donnot do it , error: cannot find symbol in line 55
        while ( start <= end )
        {
        	midRow = start + (end - start)/2;// donnot int again , error: variable midRow is already defined in method searchMatrix(int[][],int)
        	if(target == matrix[midRow][0])
        		return true;
        	else if (target < matrix[midRow][0])
        		end = midRow -1;
        	else 
        		start =midRow +1;
        }
        for(int i = 0 ; i<= midRow ; i++)
        {
        	int lb = 0;
        	int rb = matrix[0].length -1;
        	while (lb<=rb)
        	{
        		int mid = lb + ( rb - lb )/2;
        		if(matrix[i][mid]==target)
        			return true;
        		else if (matrix[i][mid] < target)
        			lb = mid +1;
        		else 
        			rb = mid -1;
        	}
        }
        return false ; // no find
    }
}