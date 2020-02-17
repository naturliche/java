package p11_3;
import java.util.LinkedList;
import java.util.Random;

public class Stack<E> {
		private LinkedList<E> store;//封装一个LinkedList对象实例
		
		public Stack(){
			store=new LinkedList<E>();//初始化
		}
		public void push(E e){
			store.addLast(e);//将元素添加在末尾就相当于入栈了
		}
		public E pop(){
			return store.removeLast();//从末尾移除元素就相当于出栈了
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
				System.out.println("第"+(i+1)+"次出栈，出栈元素为："+s_int.pop());
		}
}
