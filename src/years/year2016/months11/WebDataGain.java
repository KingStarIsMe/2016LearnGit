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
//		String url = "http://www.biqugezw.com/3_3096/";
//		String bookname = "一念永恒";
//		w.downNovel_Biqugezw(url,bookname);
//		String url="http://www.d8qu.com/html/89/89152/", bookName="火影之骨魔天下";
//		w.downNovel_D8qu(url, bookName);
		String url="http://www.qb5200.com/xiaoshuo/9/9535/index.html", bookName="陈二狗的妖孽人生2";
		w.downNovel_Quanben(url, bookName);
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
		 int initnum=407;
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
	/**
	 * 第八区小说下载功能
	 * @param url
	 * @param bookName
	 */
	public void downNovel_D8qu(String url,String bookName) {
		//用Jsoup连接站点
		Document doc=null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//选择器，选择class做为容器
		Elements elementList = doc.select(".chapter");
		String query ="a[href~=.*html]";
		Elements elements = elementList.select(query);
		int size = elements.size();
		System.out.println(size);
		String fileName = "";
		int num = 0;
		int initnum=74;
		for(int i=initnum;i<size;i++){
			Element e = elements.get(i);
			String href = e.attr("href");
			String  tempurl = url+href;
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
			Elements elementsClass = docInner.select("#cont");
			Elements elementsH = elementsClass.select("h1");  
			String sectionkname = elementsH.text();  
			System.out.println(sectionkname);
			Elements elementsContent = docInner.select("#clickeye_content");
			String content = elementsContent.text();
			System.out.println(content);
			String dir = WebUtil.getFileDir()+"//book//"+bookName+"//";
			if(content==null||"".equals(content)){
				//数据为图片获取图片连接下载图片
				String src = "";
				String filename=sectionkname;
				
				Elements elementsImg = docInner.select(".imagecontent");
				src = elementsImg.attr("src");
				System.out.println(src);
				int l=src.length();
				int index=src.lastIndexOf(".");
				filename+=src.substring(index, l);
				System.out.println(filename);
				WebUtil.downloadPic(src, filename, dir);
				continue;
			}
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
				WebUtil.downloadText(sectionkname+"    "+content, bookName+"--"+fileName+".txt", dir);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	/**
	 * 全本小说网
	 * @param url
	 * @param bookName
	 */
	public void downNovel_Quanben(String url,String bookName) {
		//用Jsoup连接站点
		Document doc=null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String url2 = url.substring(0, url.lastIndexOf("/")+1);
		System.out.println(url2);
		//选择器，选择class做为容器
		String query ="a[href~=.*html]";
		Elements elements = doc.select(query);
//		Elements elements = elementList.select(query);
		int size = elements.size();
		System.out.println(size);
		String fileName = "";
		int num = 0;
		int initnum=3;
		for(int i=initnum;i<size;i++){
			Element e = elements.get(i);
			String href = e.attr("href");
			String  tempurl = url2+href;
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
			Elements elementsContent = docInner.select("#content");
			Elements elementsH = docInner.select("#title");  
			String sectionkname = elementsH.text();  
			System.out.println(sectionkname);
//			Elements elementsContent = docInner.select("#clickeye_content");
			String content = elementsContent.text();
			System.out.println(content);
			String dir = WebUtil.getFileDir()+"//book//"+bookName+"//";
			if(content==null||"".equals(content)){
				//数据为图片获取图片连接下载图片
				String src = "";
				String filename=sectionkname;
				
				Elements elementsImg = docInner.select(".imagecontent");
				src = elementsImg.attr("src");
				System.out.println(src);
				int l=src.length();
				int index=src.lastIndexOf(".");
				filename+=src.substring(index, l);
				System.out.println(filename);
				WebUtil.downloadPic(src, filename, dir);
				continue;
			}
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
				WebUtil.downloadText(sectionkname+"    "+content, bookName+"--"+fileName+".txt", dir);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
