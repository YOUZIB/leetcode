class Solution{
	public int minPathSum(int[] grid){
		int rows = grid.length;
		int cols = 0;
		if(rows !=0)
			cols = grid[0].length;
		int [][] equation = new int [rows][cols];
		for(int i = 0 ;i<rows;i++)
		{
			for(int j = 0 ; j<cols;j++)
			{
				if(i == 0 && j==0)
				{
				equation[i][j]=grid[0][0];
				}else if(i==0)
				{
					equation[i][j]=equation[i][j-1]+grid[i][j];
				}else if(j==0)
				{
					equation[i][j]=equation[i-1][j]+grid[i][j];
				}else
				{
					if(equation[i][j-1]+grid[i][j]<equation[i-1][j]+grid[i][j])
					equation[i][j]=equation[i][j-1]+grid[i][j];
					else
					equation[i][j]=equation[i-1][j]+grid[i][j];
				}
				
			}
		}
		return equation[rows-1][cols-1];
	}
}