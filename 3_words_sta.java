package p11_3;
import java.io.*;
import java.util.*;


public class words_sta {
	private File fd;//文件类
	private Map<String,Integer> statistics;
	private int count;//对文件中出现的词语总个数计数，为频率计算做准备
	private static String[] key_set_str={"abstract","default","null","switch","boolean","do","if","package","nchronzed","break","double","implements","private","this","byte","else","import","protected","throw","throws","case","extends","instanceof","public","transient","catch","false","int","return","true","char","final","interface","short","try","class","finally","long","static","void","float","native","strictfp","volatile","continue","for","new","super","while","assert","enum"};
	private static Set<String> key_set_of_java=new HashSet<String>();
		
	public words_sta(String fileName){//默认构造方法是要传入一个文件名作为参数的
		fd=new File(fileName);
		statistics=new HashMap<String,Integer>();
		count=0;
		for(String s:key_set_str)
			key_set_of_java.add(s);//把java关键词加到Set里
	}
		
	public void work() throws FileNotFoundException,IOException{
		String temp=null;
		BufferedReader reader=new BufferedReader(new FileReader(fd));
		while((temp=reader.readLine())!=null){//一行一行读取
			StringTokenizer st=new StringTokenizer(temp,"{\r\n\t[0123456789]=\"，+：\\；;.}(),<>-! *:");//分隔符
			while(st.hasMoreTokens()){
				String key=st.nextToken();
				count++;
				if(statistics.get(key)!=null){
					statistics.put(key, statistics.get(key)+1);
				}
				else//map里不存在这个词语
					statistics.put(key, 1);
			}
		}
		reader.close();
	}
	
	//词频分析	
	public void print_statistics(){
		System.out.println("词频分析结果打印：\n"+statistics+"\n");
	}
	
		
	public void print_key_of_java(){
		for(Map.Entry<String,Integer> item:statistics.entrySet())//遍历Map
			if(key_set_of_java.contains(item.getKey()))
				System.out.println("关键词“"+item.getKey()+"”的出现频率为："+((double)item.getValue()/count));
	}
		
	public static void main(String[] args) throws FileNotFoundException,IOException{
		words_sta w=new words_sta("C://Users//natur//eclipse-workspace//p11_3//src//p11_3//TestMap.java");
		w.work();
		w.print_statistics();
		w.print_key_of_java();
	}
}
