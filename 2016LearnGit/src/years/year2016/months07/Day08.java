package years.year2016.months07;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Day08 {
	public static void main(String args[]){
		String path = "H:\\工作文档\\发布系统\\2016\\07\\08";
		path="H:\\";
		System.out.println("文件路径统计数据开始-----");
		Day08 d = new Day08();
		File file = new File(path);
		Map<String,Long> map = d.showFileInformation(file);
		long data_total = map.get("data_total");
		long data_size = map.get("data_size");
		System.out.println("文件路径："+path+" 其下属文件数量："+data_total+" 文件大小："+(data_size/1024/1024/1024)+"G（"+data_size +" 字节）");
		System.out.println("文件路径统计数据结束-----");
	}
	/**
	 * 统计文件下文件大小，文件数量
	 * @param file
	 * @return
	 */
	
	public Map<String,Long> showFileInformation(File file){
		Map<String,Long> dataMap=new HashMap<String, Long>();
		long data_size = 0;
		long data_total = 0;
		if(file.exists()){
			if(file.isFile()){
				System.out.print("文件名称："+file.getName()+" 文件大小："+file.length());
				data_size=file.length();
				data_total++;
			}else{
				File[] files = file.listFiles();
				if(files!=null){
					for(int i=0,l=files.length;i<l;i++){
						if(files[i].isFile()){
							data_size+=files[i].length();
							data_total++;
						}else{
							Map<String,Long> tempdata = showFileInformation(files[i]);
							data_size+=tempdata.get("data_size");
							data_total+=tempdata.get("data_total");
						}
					}
				}
			}
		}
		dataMap.put("data_size",data_size);
		dataMap.put("data_total",data_total);
		if(data_size>=(1024*1024*1024)){
			System.out.println("文件路径为：");
			System.out.println(" 文件名称为："+file.getPath()+" 文件大小为："+data_size+" 字节"+(data_size/1024/1024/1024)+"G");
		}
		return dataMap;
	}
}
