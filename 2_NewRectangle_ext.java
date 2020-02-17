package pracjava;

public class NewRectangle_ext {
	private double width;
	private double height;
	Point p;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point();
		Point p2 = new Point(3,4);
		System.out.println("distance:"+p2.distance(p1));
		NewRectangle_ext temp1 = new NewRectangle_ext(2,3,1,1);  //矩形1
		NewRectangle_ext temp2 = new NewRectangle_ext(3,3,1,1);  //矩形2
		System.out.println(temp1.bPointIn(p2));    //判断点2是否在矩形1中存在
		System.out.println(temp2.isInclude(temp1));  //判断矩形2中是否包含矩形1
		System.out.println(temp2.isOverlapping(temp1));  //判断矩形2和矩形1是否有重合部分
	}
	
	public NewRectangle_ext() {
		this.width = 0;
		this.height = 0;
	}
	
	public NewRectangle_ext(double w,double h,double x,double y){
		this.width = w;
		this.height = h;
		p = new Point(x,y);
	}
	
	public boolean bPointIn(Point p){
		if(p.xget() >= (this.p.xget() + this.height)) {
			return false;
		}
		else if(p.xget() <= this.p.xget()) {
			return false;
		}
		
		else if(p.yget()<=this.p.yget()||(p.yget()>=(this.p.yget() + this.width))){
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public Point getPoint(int choose) {
		Point p;
		if(choose == 1)  //左下角顶点
			p = new Point(this.p.xget(),this.p.yget());
		else if(choose == 2) //右下角顶点
			p = new Point((this.p.xget()+this.height),this.p.yget());
		else if(choose == 3) //右上角顶点
			p = new Point((this.p.xget()+this.height),(this.p.yget()+this.width));
		else
			p = new Point(this.p.xget(),(this.p.yget()+this.width));
		return p;
			
		}
	
	public boolean isInclude(NewRectangle_ext temp) {
		if(this.bPointIn(temp.getPoint(1))&&bPointIn(temp.getPoint(3)))
			return true;
		else
			return false;
	}
	
	public boolean isOverlapping(NewRectangle_ext temp) {
		for(int i=1;i<5;i++)
			if(this.bPointIn(temp.getPoint(i)))
				return true;
		return false;
	}
}

class Point{
	private double x;
	private double y;
	
	//默认构造方法
	public Point() {
		x = 0;
		y = 0;
	}
	
	//带参数构造方法
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//函数
	public double xget(){
		return this.x;
	}
	
	//函数
	public double yget(){
		return this.y;
	}
	
	//求距离函数
	public double distance(Point p) {
		return Math.sqrt(Math.pow(Math.abs(this.x-p.xget()),2)+Math.pow(Math.abs(Math.abs(this.y-p.yget())), 2));
	}
}
