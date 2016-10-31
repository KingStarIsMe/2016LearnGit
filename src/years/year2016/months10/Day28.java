package years.year2016.months10;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Day28 {
 public static void main(String[]args){
//	String exe = " cmd /c start dir"; 
//	try {
//		Day28.runProcessCode(exe);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	 String url = "http://www.16sucai.com/tupian/gqfj/3.html";
	 String cssQuery = ".vector_listbox";
	 String selQuery ="a[href~=/[0-9]{4}/[0-9]{2}/.*html]";
	 try {
		downLoadURLImg(url, cssQuery, selQuery);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
 /**
  * 下载给定url中的图片
  * @param url
 * @throws IOException 
  */
 public static void downLoadURLImg(String url,String cssQuery,String selQuery) throws IOException{
	 String url_source = "http://www.16sucai.com";
//	 if(url!=null){
//		 url_source = url.substring(0,url.indexOf("/"));
//	 }
	 System.out.println(url_source);
	 //用Jsoup连接站点
	 Document doc = Jsoup.connect(url).get();
	 //选择器，选择class做为容器
	 Elements elementClass = doc.select(cssQuery);
	 //在容器中选择指定的条件对象[测试使用超链接去进行进入相册 a[href~=/[0-9]{4}/[0-9]{2}/.*html]]
	 Elements elements = elementClass.select(selQuery);
	 int size = elements.size();
	 System.out.println(size);
	 for(int i=0;i<size;i++){
		 Element e = elements.get(i);
		 String filePath = WebUtil.getFileDir()+"//"+e.attr("title");
		 WebUtil.makeDir(filePath);
		 String href = e.attr("href");
		 System.out.println(href);
		 Document docInner = Jsoup.connect(url_source+href).get();
		 Elements elementsClass = docInner.select(".endtext");
		 Elements elementsInner = elementsClass.select("img[src^=http://file]");
		 int inn_size= elementsInner.size();
		 System.out.println(inn_size);
		 for(int j=0;j<inn_size;j++){
			 String picUrl = elementsInner.get(j).attr("src");
			 WebUtil.downloadPic(picUrl, picUrl.substring(picUrl.lastIndexOf("/")), filePath);
		 }
		 
	 }
 }
 /**
  * 通过传入的本地计算机命令运行本地方法
  * @param exe
  * @throws IOException
  */
 public static void runProcessCode(String exe) throws IOException{
	 Runtime rt = Runtime.getRuntime();
	 Process p = rt.exec(exe);
	 if(p!=null){
		 p.destroy();
		 p=null;
	 }
 }
}
