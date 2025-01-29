package problem.solving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ThreadTaskScheduling {
	
	public static List<Integer> getTotalExecutionTime(int n, String[] logsData) {
		
		List<String> logs = Arrays.stream(logsData).toList();
		
		 int[] executionTime = new int[n];
	        Stack<int[]> stack = new Stack<>();

	        for (String log : logs) {
	            String[] parts = log.split(":");
	            int functionId = Integer.parseInt(parts[0]);
	            String type = parts[1];
	            int timestamp = Integer.parseInt(parts[2]);

	            if (type.equals("start")) {
	                stack.push(new int[]{functionId, timestamp});
	            } else {
	                int[] startLog = stack.pop();
	                int startTime = startLog[1];
	                int execTime = timestamp - startTime + 1;

	                executionTime[functionId] += execTime;

	                if (!stack.isEmpty()) {
	                    executionTime[stack.peek()[0]] -= execTime;
	                } 
	            }
	        }
	        
	        List<Integer> result = new ArrayList<>();
	        for (int time : executionTime) {
	            result.add(time);
	        }
	        return result;

	}
	
	public static void main(String[] args) {
		getTotalExecutionTime(3,new String[]{"0:start:0","1:start:3","1:end:6","2:start:8","2:end:10","0:end:12"}).forEach(System.out::print);;
	}

}
