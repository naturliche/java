package pracjava;

public class testData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]label={"��������","�����","+0","-0","Infinity","-Infinity","NaN"};   //��������
		double[]value={10,-10,+0.0,-0.0,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.NaN}; 
		for(int i=0;i<7;i++){
			for(int j=0;j<7;j++){
				if((int)(value[i]/value[j])==1)  //��������ֻҪ��  / ��Ϊ %
					System.out.println(label[i]+" /  "+label[j]+"= ��������"); 
				else if((int)(value[i]/value[j])==-1)
					System.out.println(label[i]+" /  "+label[j]+"= �����");
				else
					System.out.println(label[i]+" / "+label[j]+" = "+value[i]/value[j]);
				}
			System.out.println();
			}
		}
	}

