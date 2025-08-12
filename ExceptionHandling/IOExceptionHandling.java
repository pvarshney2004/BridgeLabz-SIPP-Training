package ExceptionHandling;

import java.io.*;

public class IOExceptionHandling {

	public static void main(String[] args) throws Exception {
		String fileName = "data.txt"; // File to read

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			System.out.println("Reading file contents:");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("File not found");
		}

	}
}
