package years.year2016.months09;

import java.io.IOException;
import java.net.ServerSocket;
/**
 * 服务端Socket程序
 * @author 王星
 *
 */
public class ScoketServer {
	public static void main(String []args){
		SocketWrapper socket = null;
		try {
			ServerSocket setSocket = new ServerSocket(6666);
			System.out.println("开启6666端口准备接收数据");
			socket = new SocketWrapper(setSocket.accept());
			String line = socket.readLine();
			while(!"bye".equals(line)){
				System.out.println("客户端传来数据："+line);
				socket.writerLine("服务端接收到客户端的数据："+line);
				line = socket.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(socket !=null){
				socket.close();
			}
		}
	}
}
