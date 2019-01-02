/*
	 sort the  first elemtnt of the every arrays,[1,3],[2,6],[8,10]: 1 2 8
	 there are a two-dimensional array : int [] [] ={{1,2,3,},{2,3,4,5,6},{8,9,10}}
	 compare the nums.end and next [A,B]
	 if nums.end > next.start && nums.end < next.end , combinate them,[nums.start,next.end]
	 else if nums.end <A , No comblination
	 else nums.end > next.end ,  [next.end ,nums.last]  
	30ms
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
     
    	Collections.sort(intervals, new Comparator<Interval>(){
    	    @Override
        	public int compare (Interval o1,Interval o2){
	        	if (o1.start > o2.start)
	        		return 1;
	        	else if (o1.start<o2.start)
	        		return -1;
	        	else 
	        		return 0;
		    }
	    });


    	int i = 0 ;
    	while(i < intervals.size()  )
    	{
    		if(i != intervals.size()-1)
    		{
    			if(intervals.get(i).end >= intervals.get(i+1).start &&  intervals.get(i).end <= intervals.get(i+1).end)
    			{
    				int tempStart = intervals.get(i).start;
    				int tempEnd = intervals.get(i+1).end;
    				intervals.remove(i);
    				intervals.get(i).start = tempStart;
    				intervals.get(i).end = tempEnd;

    			}else if (intervals.get(i).end < intervals.get(i+1).start){
    				i++;
    			}else if (intervals.get(i).end >intervals.get(i+1).end){
    				intervals.remove(i+1);
    			}
    		}else {
    			i++;
    		}
    	}
    	return intervals;	
}
   
}


