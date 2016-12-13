package years.year2016.months11.scoket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketWrapper {
	private Socket socket;
	private InputStream inputStream;
	private BufferedReader inputReader;
	private BufferedWriter outputWriter;
	public SocketWrapper(Socket socket) throws IOException{
		this.socket=socket;
		this.inputStream = socket.getInputStream();
		this.inputReader = new BufferedReader(new InputStreamReader(this.inputStream,"GBK"));
		this.outputWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream(),"GBK"));
	}
	public String readLine() throws IOException{
		return this.inputReader.readLine();
	}
	public void writeLine(String line) throws IOException{
		this.outputWriter.write(line+"/n");
		this.outputWriter.flush();
	}
	public void close(){
		try{
			this.socket.close();
		}catch(Exception e){
			
		}
	}
}
