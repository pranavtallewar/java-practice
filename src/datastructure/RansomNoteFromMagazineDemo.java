package datastructure;

import java.util.Hashtable;
import java.util.Map;

public class RansomNoteFromMagazineDemo {

	public static void main(String[] args) {

		String magazine = "apgo clm w lxkvg mwz elo bg elo lxkvg elo apgo apgo w elo bg";
		String note = "elo lxkvg bg mwz clm w";
		checkMagazine(magazine.split(" "), note.split(" "));
	}

	static void checkMagazine(String[] magazine, String[] note) {
		String canMakeNote = "Yes";
		Hashtable<String, Integer> magazineWordMap = createHashtable(magazine);
		Hashtable<String, Integer> noteMap = createHashtable(note);
		for (Map.Entry<String, Integer> entry : noteMap.entrySet()) {
			String key = entry.getKey();
			if (magazineWordMap.containsKey(key)) {
				if (!(magazineWordMap.get(key) >= entry.getValue())) {
					canMakeNote = "No";
				}
			} else
				canMakeNote = "No";
		}
		System.out.println(canMakeNote);
	}

	static Hashtable<String, Integer> createHashtable(String[] object) {
		Hashtable<String, Integer> map = new Hashtable<>();
		int count = 1;
		for (String word : object) {
			if (map.containsKey(word))
				map.put(word, map.get(word) + 1);
			else
				map.put(word, count);
		}
		return map;
	}

}
