package years.year2016.months11;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import years.year2016.months10.WebUtil;

public class WebDataGain {
	public static void main(String[]args){
		WebDataGain w = new WebDataGain();
		String url = "http://www.biqugezw.com/3_3096/";
		String bookname = "一念永恒";
		w.downNovel_Biqugezw(url,bookname);
	}
	/**
	 * 下载笔趣阁小说功能
	 * @param url
	 * @throws IOException
	 */
	public void downNovel_Biqugezw(String url,String bookName) {
		String url_root = "http://www.biqugezw.com";
		//用Jsoup连接站点
		 Document doc=null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//选择器，选择class做为容器
		 Elements elementList = doc.select("#list");
		 String query ="a[href~=/[0-9]{1}_[0-9]{4}/.*html]";
		 Elements elements = elementList.select(query);
		 int size = elements.size();
		 System.out.println(size);
		 String fileName = "";
		 int num = 0;
		 int initnum=371;
		 for(int i=initnum;i<size;i++){
			 Element e = elements.get(i);
			 String href = e.attr("href");
			 String  tempurl = url_root+href;
			 System.out.println(tempurl);
			 
			 Document docInner=null;
			try {
				docInner = Jsoup.connect(tempurl).get();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println(fileName);
				System.out.println(i);
			}
			 Elements elementsClass = docInner.select(".bookname ");
			 Elements elementsH = elementsClass.select("h1");  
			 String sectionkname = elementsH.text();  
			 System.out.println(sectionkname);
			 Elements elementsContent = docInner.select("#content");
			 String content = elementsContent.text();
			 System.out.println(content);
			 num=i%20;
			 if(num==0&&i==0){
				 fileName="1-20章";
			 }else if(num==0&&i!=0){
				 fileName=i+"-"+(i+20)+"章节";
			 }else if(i==initnum){
				 int temp=initnum-num;
				 fileName = temp+"-"+(temp+20)+"章节";
			 }
			 try {
				WebUtil.downloadText(sectionkname+"    "+content, bookName+"--"+fileName+".txt", WebUtil.getFileDir()+"//book//"+bookName+"//");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 }
		 
	}
}
