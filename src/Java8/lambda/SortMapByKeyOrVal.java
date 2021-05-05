package Java8.lambda;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class SortMapByKeyOrVal {

	public static void main(String[] args) {
		Map<Integer, String> map = new LinkedHashMap<>();
		map.put(7, "Test");
		map.put(5, "Pranav");
		map.put(3, "Miten");
		map.put(2, "Jay");
		map.put(6, "Pooja");
		map.put(1, "Chandrakant");
		map.forEach((k, v) -> System.out.println("Key:" + k + " Val:" + v));
		System.out.println("-----------SORTING--------------");
		Map<Integer, String> sortedMapByKey = map.entrySet().stream().sorted(Entry.comparingByKey())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println("-----------DISPLAY MAP SORTED BY KEY--------------");
		sortedMapByKey.forEach((k, v) -> System.out.println("Key:" + k + " Val:" + v));

		Map<Integer, String> sortedMapByVal = sortedMapByKey.entrySet().stream().sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println("-----------DISPLAY MAP SORTED BY KEY--------------");
		sortedMapByVal.forEach((k, v) -> System.out.println("Key:" + k + " Val:" + v));

		Name name0 = Name.builder().firstName("Pranav").lastName("Tallewar").age(32).build();
		Name name1 = Name.builder().firstName("Pooja").lastName("Tallewar").age(26).build();
		Name name2 = Name.builder().firstName("Miten").lastName("Tallewar").age(27).build();
		Name name3 = Name.builder().firstName("Shobha").lastName("Tallewar").age(53).build();
		Name name4 = Name.builder().firstName("Chandrakant").lastName("Tallewar").age(58).build();
		System.out.println("-----------SORT MAP BY CUSTOM OBJ KEY--------------");
		Map<Name, Integer> nameMap = new LinkedHashMap<>();
		nameMap.put(name0, 55);
		nameMap.put(name1, 1);
		nameMap.put(name2, 2);
		nameMap.put(name3, 3);
		nameMap.put(name4, 4);
		nameMap.forEach((k, v) -> System.out.println("Key:" + k + " Val:" + v));
		System.out.println("-----------SORT MAP BY CUSTOM OBJ KEY--- AFTER SORT--------------");
		LinkedHashMap<Name, Integer> sortedMap = nameMap.entrySet().stream()
				.sorted(Map.Entry.<Name, Integer>comparingByKey((n1, n2) -> n1.getAge().compareTo(n2.getAge())))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		sortedMap.forEach((k, v) -> System.out.println("Key:" + k + " Val:" + v));

		System.out.println("-----------SORT MAP BY CUSTOM OBJ KEY--- AFTER SORT--------------");
		LinkedHashMap<Name, Integer> reverseSortedMap = nameMap.entrySet().stream()
				.sorted(Map.Entry.<Name, Integer>comparingByKey((n1, n2) -> n1.getAge().compareTo(n2.getAge()))
						.reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		reverseSortedMap.forEach((k, v) -> System.out.println("Key:" + k + " Val:" + v));

	}

}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Name {
	private String firstName;
	private String lastName;
	private Integer age;

}
