package pracjava;

public class Cycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cycle c = new Cycle();
		Unicycle u = new Unicycle();
		Bicycle b = new Bicycle();
		Tricycle t = new Tricycle();
		
		c.ride(u);//��������������������ת��
		c.ride(b);
		c.ride(t);
	}
	
	public void ride(Cycle c){
		System.out.println("���ӵ�������:"+c.wheel());
		if(c instanceof Unicycle)  //����ת�ͣ��������ת��Ϊ�������
			((Unicycle)c).balance();
		if(c instanceof Bicycle)
			((Bicycle)c).balance();
	}
	
	public int wheel() {
		return 0;//���س�������
	}
}

class Unicycle extends Cycle{
	public int wheel() {
		return 1;  //��д
	}
	
	public void balance() {
		System.out.println("balance");
	}
}

class Bicycle extends Cycle{
	public int wheel() {
		return 2;
	}
	
	public void balance() {
		System.out.println("no balance");
	}
}

class Tricycle extends Cycle{
	public int wheel() {
		return 3;
	}
	
}