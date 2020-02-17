package p11_3;
import java.util.LinkedList;
import java.util.Random;

public class Stack<E> {
		private LinkedList<E> store;//��װһ��LinkedList����ʵ��
		
		public Stack(){
			store=new LinkedList<E>();//��ʼ��
		}
		public void push(E e){
			store.addLast(e);//��Ԫ�������ĩβ���൱����ջ��
		}
		public E pop(){
			return store.removeLast();//��ĩβ�Ƴ�Ԫ�ؾ��൱�ڳ�ջ��
		}
		public E peek(){
			return store.getLast();
		}
		public boolean isEmpty(){
			return store.isEmpty();
		}
		public int size(){
			return store.size();
		}
		
		public static void main(String[] args){
			Stack<Integer> s_int=new Stack<Integer>();
			Random rand=new Random(34);
			for(int i=0;i<20;i++){
				s_int.push(rand.nextInt(40));
				System.out.print(s_int.peek()+" ");
			}
			System.out.print("\n");
			for(int i=0;i<20;i++)
				System.out.println("��"+(i+1)+"�γ�ջ����ջԪ��Ϊ��"+s_int.pop());
		}
}
