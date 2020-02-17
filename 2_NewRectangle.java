package pracjava;

public class NewRectangle {
	private double width; //私有变量，仅在该类中使用
	private double height;

	/*默认构造方法
	public NewRectangle{
		
	}
	*/
	
	//带参数构造方法
	public NewRectangle(double x, double y){
		width = x;
		height = y;
	}
	
	public double getArea() {
		return width*height;
	}
	
	
	public double getPerimeter() {
		return 2 * (width+height);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewRectangle rect = new NewRectangle(3,4);
		System.out.println(rect.width+";"+rect.height);
		System.out.println("Area of Rectangle:"+ rect.getArea());
		System.out.println("Area of Rectangle:"+ rect.getPerimeter());
	}

}
