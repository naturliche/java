package p11_24;
import java.io.*;

public class OutputAddFive {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream in = new FileInputStream("A:\\test\\plain.txt");
		FileOutputStream out = new FileOutputStream("A:\\test\\cipher.txt");
		
		int c;
		int s=0;
		while((c=in.read())!=-1) {
			if(((char)c)!='\r') {
				s=c+5;
				out.write(s);
			}
			else
				out.write((char)c);
		}
		in.close();
		out.close();
	}
}
