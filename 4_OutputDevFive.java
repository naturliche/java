package p11_24;
import java.io.*;

public class OutputDevFive {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream in = new FileInputStream("A:\\test\\cipher.txt");
		FileOutputStream out = new FileOutputStream("A:\\test\\decrypt.txt");
		
		int c;
		int s=0;
		while((c=in.read())!=-1) {
				if(((char)c)!='\r') {
					s=c-5;
					out.write(s);
				}
				else
					out.write((char)c);
		}
		in.close();
		out.close();
	}
}
