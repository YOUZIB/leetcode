/*
	there is a i,unless we can satisify children from i to g.length
	method:
	arrays.sort the g s  ,make there are  incesing
	while(j < s.length && s[j]<g[i])	j++; result ++ j++, defense the other break method(j<s.length),so add if(j<s.length) 

*/

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i=0,j=0, result=0;// store who be given
       	Arrays.sort(g);
       	Arrays.sort(s);
    	//interate child ,not cookie,because child done faster than cookie done
    	for (i=0;i<g.length;i++)  //interate every child 
    	{
    		// two case jump up the loop. first:j=ss.length , return 0; second:s[j]=g[j], break to if,to the next for
    		while(j < s.length && s[j]<g[i])	j++;
    		if(j<s.length) 
    		{
    			result ++;
    			j++;
    		}
    	}
    	return result;
    }
}