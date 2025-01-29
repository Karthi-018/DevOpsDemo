package problem.solving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrefixSums {
	
    public static long getMaxBeauty(List<Integer> list) {
    	
    	Collections.sort(list);
    	
    	int listSize = list.size();
    	
    	List<Integer> optList = new ArrayList<Integer>(listSize);
    	
    	for(int i= 0;i<listSize;i++)
    		optList.add(0);
    	
    	for(int i =0;i<listSize/2;i++)
    	{
    		optList.set((2*i)+1, list.get(i));
    	}
    	
    	for(int i =listSize/2;i<listSize;i++)
    	{
    		optList.set((i - (listSize / 2)) * 2, list.get(i));
    	}
    	
    	long val = 0;
        long m = 1;
        long cur = 0;
        
        for (int i : optList) {
            cur += i;
            val += cur * m;
            m *= -1;
        }

    	
    	return val;

    	
    }
    
    public static void main(String[] args) {
		System.out.println(getMaxBeauty(new ArrayList<Integer>(List.of(6, 5, 1, 5, 2))));
	}

}
