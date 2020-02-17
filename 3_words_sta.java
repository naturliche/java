package p11_3;
import java.io.*;
import java.util.*;


public class words_sta {
	private File fd;//�ļ���
	private Map<String,Integer> statistics;
	private int count;//���ļ��г��ֵĴ����ܸ���������ΪƵ�ʼ�����׼��
	private static String[] key_set_str={"abstract","default","null","switch","boolean","do","if","package","nchronzed","break","double","implements","private","this","byte","else","import","protected","throw","throws","case","extends","instanceof","public","transient","catch","false","int","return","true","char","final","interface","short","try","class","finally","long","static","void","float","native","strictfp","volatile","continue","for","new","super","while","assert","enum"};
	private static Set<String> key_set_of_java=new HashSet<String>();
		
	public words_sta(String fileName){//Ĭ�Ϲ��췽����Ҫ����һ���ļ�����Ϊ������
		fd=new File(fileName);
		statistics=new HashMap<String,Integer>();
		count=0;
		for(String s:key_set_str)
			key_set_of_java.add(s);//��java�ؼ��ʼӵ�Set��
	}
		
	public void work() throws FileNotFoundException,IOException{
		String temp=null;
		BufferedReader reader=new BufferedReader(new FileReader(fd));
		while((temp=reader.readLine())!=null){//һ��һ�ж�ȡ
			StringTokenizer st=new StringTokenizer(temp,"{\r\n\t[0123456789]=\"��+��\\��;.}(),<>-! *:");//�ָ���
			while(st.hasMoreTokens()){
				String key=st.nextToken();
				count++;
				if(statistics.get(key)!=null){
					statistics.put(key, statistics.get(key)+1);
				}
				else//map�ﲻ�����������
					statistics.put(key, 1);
			}
		}
		reader.close();
	}
	
	//��Ƶ����	
	public void print_statistics(){
		System.out.println("��Ƶ���������ӡ��\n"+statistics+"\n");
	}
	
		
	public void print_key_of_java(){
		for(Map.Entry<String,Integer> item:statistics.entrySet())//����Map
			if(key_set_of_java.contains(item.getKey()))
				System.out.println("�ؼ��ʡ�"+item.getKey()+"���ĳ���Ƶ��Ϊ��"+((double)item.getValue()/count));
	}
		
	public static void main(String[] args) throws FileNotFoundException,IOException{
		words_sta w=new words_sta("C://Users//natur//eclipse-workspace//p11_3//src//p11_3//TestMap.java");
		w.work();
		w.print_statistics();
		w.print_key_of_java();
	}
}
