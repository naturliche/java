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
		NewRectangle_ext temp1 = new NewRectangle_ext(2,3,1,1);  //����1
		NewRectangle_ext temp2 = new NewRectangle_ext(3,3,1,1);  //����2
		System.out.println(temp1.bPointIn(p2));    //�жϵ�2�Ƿ��ھ���1�д���
		System.out.println(temp2.isInclude(temp1));  //�жϾ���2���Ƿ��������1
		System.out.println(temp2.isOverlapping(temp1));  //�жϾ���2�;���1�Ƿ����غϲ���
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
		if(choose == 1)  //���½Ƕ���
			p = new Point(this.p.xget(),this.p.yget());
		else if(choose == 2) //���½Ƕ���
			p = new Point((this.p.xget()+this.height),this.p.yget());
		else if(choose == 3) //���ϽǶ���
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
	
	//Ĭ�Ϲ��췽��
	public Point() {
		x = 0;
		y = 0;
	}
	
	//���������췽��
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//����
	public double xget(){
		return this.x;
	}
	
	//����
	public double yget(){
		return this.y;
	}
	
	//����뺯��
	public double distance(Point p) {
		return Math.sqrt(Math.pow(Math.abs(this.x-p.xget()),2)+Math.pow(Math.abs(Math.abs(this.y-p.yget())), 2));
	}
}
