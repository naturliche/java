package pracjava;

public class Cycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cycle c = new Cycle();
		Unicycle u = new Unicycle();
		Bicycle b = new Bicycle();
		Tricycle t = new Tricycle();
		
		c.ride(u);//子类对象当作父类对象，向上转型
		c.ride(b);
		c.ride(t);
	}
	
	public void ride(Cycle c){
		System.out.println("轮子的数量是:"+c.wheel());
		if(c instanceof Unicycle)  //向下转型，父类变量转换为子类变量
			((Unicycle)c).balance();
		if(c instanceof Bicycle)
			((Bicycle)c).balance();
	}
	
	public int wheel() {
		return 0;//返回车轮数量
	}
}

class Unicycle extends Cycle{
	public int wheel() {
		return 1;  //重写
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