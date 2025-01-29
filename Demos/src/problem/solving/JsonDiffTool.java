package problem.solving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonDiffTool {
	
	public static List<String> getJSONDiff(List<String> jsonData)
	{
		String json1 = jsonData.get(0);
		String json2 = jsonData.get(1);
		List<String> diffJson = new ArrayList<String>();
		
		String[] arr1 = json1.substring(1,json1.length()-1).split(",");
        String[] arr2 = json2.substring(1,json1.length()-1).split(",");
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        
        for (String s1 : arr1) {
            String[] arr11 = s1.split(":");
            map1.put(arr11[0], arr11[1]);
        }

        for (String s2 : arr2) {
            String[] arr22 = s2.split(":");
            map2.put(arr22[0], arr22[1]);
        }
        
        for(String key : map1.keySet())
        {
        	if(!map1.get(key).equals(map2.get(key)))
        	{
        		diffJson.add(key.substring(1, key.length()-1));
        	}
        }
		
		Collections.sort(diffJson);
		
		return diffJson;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			List<String> jsonDiff = getJSONDiff(List.of("{\"hacker\":\"ranked\",\"input\":\"output\"}",
					"{\"hacker\":\"ranked\",\"input\":\"output\"}"));
			jsonDiff.forEach(System.out::println);
	}

}
