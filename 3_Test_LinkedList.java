package p11_3;
import java.util.LinkedList;
import java.util.Scanner;

public class Test_LinList {
		private LinkedList<Character> stack_char;
		
		public Test_LinList(){
			stack_char=new LinkedList<Character>();
		}
		public void test_string(String s){
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)=='+'){
					stack_char.addLast(s.charAt(i+1));//入栈下一个字符
					i+=1;//給计数变量i多加一，避免对下一个字符的检验（万一下一个字符是‘+’或‘-’呢？
				}
				else if(s.charAt(i)=='-')//出栈栈顶元素
					System.out.println("pop栈顶元素："+stack_char.removeLast());
				else;
			}	
			while(!stack_char.isEmpty())
				     System.out.print(stack_char.removeLast()+" ");
			System.out.println();
		}
		
		public static void main(String[] args){
			String s=null;
			Scanner sc=new Scanner(System.in);
			System.out.print("请输入待测试的字符串：");
			s=sc.nextLine();
			Test_LinList t=new Test_LinList();
			t.test_string(s);
			sc.close();
		}
}
