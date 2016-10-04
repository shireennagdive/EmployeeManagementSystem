import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Web {

	/*To print hello world on the browser
	 * public static void main(String[] args) throws IOException {
		int port=80;
		//URL url = new URL("localhost");
		System.out.println("waitin for connection");
	ServerSocket service = new ServerSocket(80);
	Socket clientInfo=service.accept();
	System.out.println(clientInfo);
	
	InputStream in=clientInfo.getInputStream();
	InputStreamReader bridge = new InputStreamReader(in);
	BufferedReader br = new BufferedReader(bridge);
	
	OutputStream os=clientInfo.getOutputStream();
	PrintWriter pw = new PrintWriter(os);
	String s="a";
	while(s.length()!=0){
		s=br.readLine();
		System.out.println(s);
	}
	
	pw.println("Hello");
	pw.flush();
	pw.close();
	//System.out.println(pw);
	*/
	
	
	}
	