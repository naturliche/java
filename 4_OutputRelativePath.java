package p11_24;
import java.io. *;
import java.util.Scanner;

public class OutputRelativePath {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("������·����");
		Scanner out1 = new Scanner(System.in);
		String path = out1.next();
		//String path = "C:\\Users\\natur\\eclipse-workspace";
		//String str = ".java" ;
		System.out.println("�������ļ���չ����");
		Scanner out2 = new Scanner(System.in);
		String str = out2.next();
		matchFS(path,str);
	}
	
	public static void matchFS(String path,String str) throws IOException{
		//�ݹ�������Ŀ¼���������Ŀ¼
		File test = new File(path);
		File[] subFiles = test.listFiles(); //��ȡ·���µ����е��ļ����ļ��ж���
		 if(null != subFiles) {
			 for(File subFile:subFiles) {
				 if(subFile.isDirectory()) //��ǰ·����һ��Ŀ¼
					 matchFS(subFile.getAbsolutePath(),str);//�ݹ����Ŀ¼
				 else if(subFile.isFile() && subFile.getName().endsWith(str))
					 System.out.println(subFile.getName());
			 }
		 }
	}
}
