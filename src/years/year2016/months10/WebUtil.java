package years.year2016.months10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebUtil {
	
	private static final String fileDir = "D://down";
	public static String getFileDir(){
		return fileDir;
	}
	/**
	 * 创建文件目录
	 * @param dir
	 */
	public static void makeDir(String dir){
		File f = new File(dir);
		if(!f.exists()){
			f.mkdirs();
		}
	}
	/**
	 * 下载图片
	 * @param src 下载路径
	 * @param filename 图片名称
	 * @param dir 存放图片路径
	 */
	public static void downloadPic(String src,String filename,String dir){
		URL url = null;
		try{
			url = new URL(src);
		}catch(MalformedURLException e){
			e.printStackTrace();
		}
		URLConnection uri = null;
		InputStream is = null;
		try {
			uri = url.openConnection();
			is = uri.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(is !=null){
			OutputStream os =null;
			try {
				//写入数据流
				os = new FileOutputStream(new File(dir,filename));
				//下载图片
				byte[]buf = new byte[1024];
				int l=0;
					while((l=is.read(buf))!=-1){
						os.write(buf,0,l);
					}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(os!=null){
					try {
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		
		
	}
}