package p11_24;
import java.lang.Thread;
import java.util.Random;
import java.io.*;

public class TestLogger{
	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		LogWrite[] t = new LogWrite[13];//线程数为13
		
		for(int i = 0;i<10;i++) {
			t[i] = new LogWrite();//数组逐位创建
		}
		for(int i = 0;i<10;i++) {
			t[i].start();  //逐位运行
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
	private static FileOutputStream out;  //字符流写入
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
			out.write(str.getBytes());  //逐比特读入
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
	
	//单例设计模式----懒汉
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


class LogWrite extends Thread{  //通过继承Thread类的方法创建线程
	private boolean quit = false;
	private static int idcnt = 1;
	private final int threadid = idcnt++;  //线程id
	
	public void run() {
		while(!quit) {
			Logger logger = Logger.getInstance();
			Random r = new Random();//随机数
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
