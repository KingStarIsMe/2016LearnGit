package years.year2016.months11;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

public class Day28 {
	public static void main(String[]args){
		System.out.println("---start---");
		Date start = new Date();
		String srcImagePath = "D:\\图片整理\\test\\t1.jpg";
		String toPath="D:\\图片整理\\test\\t1_2.jpg";
		try {
			drawImageToTopRight(srcImagePath, toPath, 9);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Date end = new Date();
		System.out.println("---end---运行时间："+(end.getTime()-start.getTime()));
	}
	/**
	 * 在图片右上方画一个直径为图片高度四分之一的圆，并在圆的中央写上数字或者其他把内容
	 * @param srcImagePath
	 * @param toPath
	 * @param content
	 * @throws IOException 
	 */
	public static void drawImageToTopRight(String srcImagePath, String toPath,
			int num) throws IOException {
		if(num>9){
			System.out.println("比较笨只会1到9");
			return;
		}
		String content = num+"";
		
		FileOutputStream fos = null;
		try {
			//获取原图片
			BufferedImage image = ImageIO.read(new File(srcImagePath));
			Graphics2D g2d = image.createGraphics();
			g2d.setColor(Color.RED);//红色圆
			int diameter = image.getHeight()/4;//圆的直径
			int fontSize = diameter;//字体大小
			int image_width = image.getWidth();
			int x = image_width-diameter;//圆圈的起始点x坐标
			int y = 0;//圆圈的起始点x坐标
			int f_x = image_width-diameter/2-diameter/4;//文字的起点x坐标
			int f_y = diameter*5/6;//文字的起点y坐标
			g2d.fillOval(x, y, diameter, diameter);//画圆圈
			g2d.setFont(new Font("宋体",Font.PLAIN,fontSize));//设置文字样式
			g2d.setColor(Color.WHITE);//设置文字颜色
			g2d.drawString(content, f_x, f_y);//写字
			fos = new FileOutputStream(toPath);//输出文件
			ImageIO.write(image, "jpg", fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fos != null){
				fos.close();
			}
		}
	}
}
