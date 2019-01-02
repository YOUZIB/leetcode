/**
 come a five , five++
 come a ten, ten-- five++
 come a twienty, if(ten!=) ten-- five--,else five-+3


*/


class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countFive=0; 
	    int countTen=0;  

	    for(int i=0;i<bills.length;i++) {
	    	if(bills[i]==5) {
	    		countFive++;
	    	}else if(bills[i]==10) {
	    		countTen++;
	    		countFive--;
	    	}else if(bills[i]==20) {
	    		if(countTen>0) {
	    			countTen--;
	    			countFive--;
	    		}else {
	    			countFive-=3;
	    		}
	    	}
	    	// point , idont hava five and ten at same time ,false
	    	if(countFive<0||countTen<0) {
	    		return false;
	    	}
	    }
		return true;
    }
}