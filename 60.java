/*
	binary : lb= 1, rb = x, mid= lb + (rb - lb)/2, mid*mid == x return x ; mid*mid > x  rb=mid-1;mid*mid < x  lb=mid +1; 
			lb*lb >x , low -1 
	25ms
*/

class Solution {
    public int mySqrt(int x) {
 		long lb =1 ;
 		long rb = x;
 		while(lb<rb)
 		{
 			long mid = lb + (rb-lb)/2;
 			if(mid*mid == x) 
 				return (int)mid;
 			else if(mid*mid > x)
 				rb = mid -1 ;
 			else 
 				lb = mid +1;
 		}       
 		if(lb*lb>x)
 			return (int)(lb-1);
 		return (int)lb;
    }
}

/*
	Newton's method:
	23ms
*/

class Solution {
    public int mySqrt(int x) {
    
    	double err =  1e-15;
    	double t = x;
    	while(Math.abs(t-x/t)>err*t)
    		t = (x/t +t)/2.0;
    	return (int)t;
    }
 }