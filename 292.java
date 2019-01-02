/*
	subsequence:a new string which is formed from the original string by deleting some(can be none)of the characters
	
*/
class Solution {
    public boolean isSubsequence(String s, String t) {	//t is too long, so we try to make the algrithm just relatied to s
    	// make two pointer ,k point to s,i point to t
       	int i=0,j=0 ;
       	//i don't know how to size the string,so i decide to transfer it to character array
        //It returns a newly allocated character array, whose length is the length of this string and whose contents are initialized to contain the character sequence represented by this string.
        char[] ss=s.toCharArray(); 
        char[] tt=t.toCharArray();
    	

    	// for(i=0;i<tt.length && j<tt.length;i++), equals while(i<ss.length && j<tt.length) 
    	while(i<ss.length && j<tt.length){ //i<s not i<t,t is too long  i refer it before
    		if(ss[i]==tt[j]){ 
    			i++;
    		}
    		j++;
    	}
    	return i == ss.length; //error: == boolean , = int 
    }
}