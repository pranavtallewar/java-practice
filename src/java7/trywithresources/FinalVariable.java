package java7.trywithresources;

import java.io.FileOutputStream;

public class FinalVariable {

	public static void main(String[] args) {
		try (FileOutputStream fileStream = new FileOutputStream("javatpoint.txt");) {
			String greeting = "Welcome to file generated by try-with-resources";
			byte b[] = greeting.getBytes();
			fileStream.write(b);
			System.out.println("File written");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
