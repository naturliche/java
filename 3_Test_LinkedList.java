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
					stack_char.addLast(s.charAt(i+1));//��ջ��һ���ַ�
					i+=1;//�o��������i���һ���������һ���ַ��ļ��飨��һ��һ���ַ��ǡ�+����-���أ�
				}
				else if(s.charAt(i)=='-')//��ջջ��Ԫ��
					System.out.println("popջ��Ԫ�أ�"+stack_char.removeLast());
				else;
			}	
			while(!stack_char.isEmpty())
				     System.out.print(stack_char.removeLast()+" ");
			System.out.println();
		}
		
		public static void main(String[] args){
			String s=null;
			Scanner sc=new Scanner(System.in);
			System.out.print("����������Ե��ַ�����");
			s=sc.nextLine();
			Test_LinList t=new Test_LinList();
			t.test_string(s);
			sc.close();
		}
}
