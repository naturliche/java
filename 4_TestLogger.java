package p11_24;
import java.lang.Thread;
import java.util.Random;
import java.io.*;

public class TestLogger{
	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		LogWrite[] t = new LogWrite[13];//�߳���Ϊ13
		
		for(int i = 0;i<10;i++) {
			t[i] = new LogWrite();//������λ����
		}
		for(int i = 0;i<10;i++) {
			t[i].start();  //��λ����
		}
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		for(int i =0;i<10;i++) {
			t[i].stopRunning();
		}
		
		logger.terminate();
	}
}

class Logger{
	private static FileOutputStream out;  //�ַ���д��
	private static File file;
	
	private Logger() {
		file = new File("A:\\test\\log.txt");
		
		try {
			out = new FileOutputStream("A:\\test\\log.txt");
		}
		catch(Exception e) {}
	}
	
	public void LogWrite(String str) {
		try {
			out.write(str.getBytes());  //����ض���
		}
		catch(Exception e) {
		}
	}
	
	
	public void terminate() {
		try {
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//�������ģʽ----����
	private static Logger logger = null;
	public static Logger getInstance() {
		if(logger == null) {
			synchronized(Logger.class) {
				if(logger == null) {
					logger = new Logger();
				}
			}
		}
		return logger;
	}		
}


class LogWrite extends Thread{  //ͨ���̳�Thread��ķ��������߳�
	private boolean quit = false;
	private static int idcnt = 1;
	private final int threadid = idcnt++;  //�߳�id
	
	public void run() {
		while(!quit) {
			Logger logger = Logger.getInstance();
			Random r = new Random();//�����
			String str = "thread".concat(String.valueOf(threadid)).concat("\n");
			
			try {
				Thread.sleep(r.nextInt(1000));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			synchronized(logger) {
				logger.LogWrite(str);
			}
			
		}
	}
	public void stopRunning()
	{			
		quit = true;
	}
}
