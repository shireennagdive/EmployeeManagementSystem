import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assignment5 {
	public static void main(String args[]) throws FileNotFoundException, IOException {

		String filename = "D:/Users/training/Desktop/tp.txt";
		File file = new File(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FileWriter outputStream = new FileWriter(file);
		PrintWriter pw = new PrintWriter(outputStream);
		int flag = 1;
		Character character;
		String s,star="*";
		// try(FileOutputStream fOut = new FileOutputStream(file)){
		while (flag == 1) {
			// System.out.println("Enter a character : ");
			s = br.readLine();
		/*	this is better here
		 * char c=(char)new InputStreamReader(System.in).read();
		 * */
			// c=scan.next().charAt(0);
			for (int i = 0; i < s.length(); i++) {
				if (Character.isDigit(s.charAt(i))) {
					// outputStream.write('*');
					pw.print(star);
				} else if (Character.isUpperCase(s.charAt(i))) {
					// outputStream.write(Character.toUpperCase(s.charAt(i)));
					pw.print(String.valueOf(Character.toLowerCase(s.charAt(i))));
				} else if (Character.isLowerCase(s.charAt(i))) {
					// outputStream.write(s.charAt(i));
					pw.print(String.valueOf(s.charAt(i)));
				} else {
					System.out.println("go out due to " + s.charAt(i));
					flag = 0;
				}
			}
		}
		System.out.println("Thankyou");
		outputStream.close();
		br.close();
		pw.close();
	}

}
