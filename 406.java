/*
	Sort all arrays by h from big to small. If h is the same, then k is from small to large.
	result two-dimensional array:[[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
	a[1] in each one-dimensional array a (0,1,1,0,2,4) in the sorted array  
	as the index in the result queue.

*/


class Solution {
    public int[][] reconstructQueue(int[][] people) {
    	/*
    		comparator put the small one in the front and the big one in the back.
			return -1: left < right, sort:left right(no swawp)
			return 0: left = right, sort:left right (no swawp)
			return 1: left >right, sort:right left(swawp)

    	*/
    	//Sort by height in descending order. If the height is the same, sort in ascending order of K value.
 		Arrays.sort(people,new Comparator<int[]>(){
 			//comparator     -1 : o1 < o2     0 : o1 == o2      +1 : o1 > o2
			@Override
			public int compare(int[] o1, int[] o2) {
					if ( o1[0] != o2[0])
						return -o1[0]+o2[0];
					else
						return o1[1]-o2[1];
			}
		});

 		//output answer
		List<int[]> res = new LinkedList<>();

		for (int[] a  : people ) {
			res.add(a[1],a);
		}
		return res.toArray(new int[people.length][2]);
	}
}