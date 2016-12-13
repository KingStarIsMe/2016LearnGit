package years.year2016.months11.scoket;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServer {
	public static void main(String[]args) throws IOException{
		ServerSocket serSocket = new ServerSocket(8888);
		System.out.println("端口已经打开为8888，开始准备接收数据；");
		SocketWrapper socket = null;
		try{
			socket = new SocketWrapper(serSocket.accept());
			String line = socket.readLine();
			while(!"bye".equals(line)){
				System.out.println("客户端传递的数据："+line);
				socket.writeLine("服务端接收的数据："+line);
				line = socket.readLine();
			}
			socket.close();
		}catch(Exception e){
			
		}finally{
			if(socket!=null){
				socket.close();
			}
		}
	}
	
}
