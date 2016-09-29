package years.year2016.months09;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Socket客户端程序
 * @author 王星
 *
 */
public class SocketClient {
	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		SocketWrapper socket=null;
		try {
			socket = new SocketWrapper(new Socket("127.0.0.1",6666));//测试git2016年9月29日 14:26:25
			System.out.println("已经连接到服务端，可以开始输入数据进行通讯了");
			String sendMsg = scanner.nextLine();
			socket.writerLine(sendMsg);
			String recivedMsg = socket.readLine();
			while(!"close".equals(recivedMsg)){
				System.out.println("---[服务端返回]---"+recivedMsg);
				socket.writerLine(sendMsg);//发送消息
				recivedMsg = socket.readLine();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(socket!=null){
				socket.close();
			}
		}
	}
}
