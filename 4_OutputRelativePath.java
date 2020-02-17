package p11_24;
import java.io. *;
import java.util.Scanner;

public class OutputRelativePath {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("请输入路径：");
		Scanner out1 = new Scanner(System.in);
		String path = out1.next();
		//String path = "C:\\Users\\natur\\eclipse-workspace";
		//String str = ".java" ;
		System.out.println("请输入文件扩展名：");
		Scanner out2 = new Scanner(System.in);
		String str = out2.next();
		matchFS(path,str);
	}
	
	public static void matchFS(String path,String str) throws IOException{
		//递归搜索该目录及其各级子目录
		File test = new File(path);
		File[] subFiles = test.listFiles(); //获取路径下的所有的文件或文件夹对象
		 if(null != subFiles) {
			 for(File subFile:subFiles) {
				 if(subFile.isDirectory()) //当前路径是一个目录
					 matchFS(subFile.getAbsolutePath(),str);//递归查找目录
				 else if(subFile.isFile() && subFile.getName().endsWith(str))
					 System.out.println(subFile.getName());
			 }
		 }
	}
}
