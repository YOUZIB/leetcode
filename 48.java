class Solution {
    public void rotate(int[][] matrix) {
			for(int layer = 0 ;layer<matrix.length/2 ; ++layer){
				rateteOneLayer(matrix,layer,matrix.length-layer*2);
			}
    }
	
	private void rateteOneLayer ( int[][] matrix, int offset,int size){
		for(int pos = 0;pos<size-1;++pos){
			int temp = matrix[offset][offset+pos];
			matrix[offset][offset+pos]=matrix[offset+size-1-pos][offset];
			matrix[offset+size-1-pos][offset]=matrix[offset+size-1][offset+size-1-pos];
			matrix[offset+size-1][offset+size-1-pos]=matrix[offset+pos][offset+size-1];
			matrix[offset+pos][offset+size-1]=temp;
			}
	}
	
	
}