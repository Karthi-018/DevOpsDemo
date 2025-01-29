package problem.solving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaultyServerDetection {
	
	public static int countFaults(int n, String[] logsData) {
		
		List<String> logs = Arrays.stream(logsData).toList();
		
		Map<String, Integer> errorCount = new HashMap<>();
        int replacements = 0;
        
        for (String log : logs) {
            String[] parts = log.split(" ");
            String server_id = parts[0];
            String status = parts[1];
            
            if (status.equals("error")) { 
                errorCount.put(server_id, errorCount.getOrDefault(server_id, 0) + 1);
                if (errorCount.get(server_id) == 3) {
                    replacements++;
                    errorCount.put(server_id, 0);
                }
            } else {
                errorCount.put(server_id, 0);
            }
        }
        
        return replacements;

		
	}
	
	public static void main(String[] args) {
		System.out.println(countFaults(3,new String[] {"s2 error", "s3 error", "s2 error", "s2 error", "s3 error", "s3 error"}));
	}

}
