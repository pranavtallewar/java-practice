import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateMapOfMap {

	public static void main(String[] args) {
		Map<String, Map<String, String>> map = new HashMap<>();
		Map<String,String> seqValMap = new HashMap<>();
		seqValMap.put("1", "101");
		seqValMap.put("2", "102");
		seqValMap.put("3", "103");
		seqValMap.put("4", "104");
		seqValMap.put("5", "105");
		seqValMap.put("6", "106");
		map.put("2698", seqValMap);
		seqValMap = null;
		seqValMap = new HashMap<>();
		seqValMap.put("1", "201");
		seqValMap.put("2", "202");
		seqValMap.put("3", "203");
		seqValMap.put("4", "204");
		seqValMap.put("5", "205");
		seqValMap.put("6", "206");
		seqValMap.put("7", "207");
		map.put("2840", seqValMap);
		seqValMap = null;
		seqValMap = new HashMap<>();
		seqValMap.put("1", "201");
		map.put("0020", seqValMap);
		ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(map);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
	}

}
