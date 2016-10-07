package years.year2016.months09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketWrapper {
	private Socket socket;
	private InputStream inputStreatem;
	private BufferedReader inputReader;
	private BufferedWriter outputWriter;
	public SocketWrapper(Socket socket) throws IOException{
		this.socket = socket;
		this.inputStreatem = socket.getInputStream();
		this.inputReader  = new BufferedReader(new InputStreamReader(this.inputStreatem,"GBK"));
		this.outputWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"GBK"));
	}
	/**
	 * 读取一行
	 * @return
	 * @throws IOException
	 */
	public String readLine()throws IOException{
		return this.inputReader.readLine();
	}
	/**
	 * 输出一行
	 * @param line
	 * @throws IOException
	 */
	public void writerLine(String line )throws IOException{
		this.outputWriter.write(line);
		this.outputWriter.flush();
	} 
	public void close(){
		try{
			this.socket.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
