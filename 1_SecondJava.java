package pracjava;

public class SecondJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=10;i<100;i++){
			for (int j=10;j<100;j++){
				int target=i*j;
				if (target>999&&target<100000){
					System.out.println(target+"="+i+"*"+j);
					continue;
				}
            }
		}
	}
}