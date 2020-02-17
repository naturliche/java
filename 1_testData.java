package pracjava;

public class testData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]label={"有穷正数","有穷负数","+0","-0","Infinity","-Infinity","NaN"};   //定义数组
		double[]value={10,-10,+0.0,-0.0,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.NaN}; 
		for(int i=0;i<7;i++){
			for(int j=0;j<7;j++){
				if((int)(value[i]/value[j])==1)  //求余运算只要把  / 换为 %
					System.out.println(label[i]+" /  "+label[j]+"= 有穷正数"); 
				else if((int)(value[i]/value[j])==-1)
					System.out.println(label[i]+" /  "+label[j]+"= 有穷负数");
				else
					System.out.println(label[i]+" / "+label[j]+" = "+value[i]/value[j]);
				}
			System.out.println();
			}
		}
	}

