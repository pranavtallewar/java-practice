import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpellingBee {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // Reading input from STDIN
		
		for (int i = 0; i < n; i++) {
			int no_of_words = Integer.parseInt(br.readLine());
			String[] number_of_words = br.readLine().split(" ");
			String word = br.readLine();
			int counter = 1;
			for (String s : number_of_words) {
				if (word.contains(s)) {
					counter++;
				}
			}
			if(counter == no_of_words) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

	}

}
