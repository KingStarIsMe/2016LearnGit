package years.year2016.months11;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

public class ImageUtil {
	/**
	 * 对图片进行剪切，并将剪切图的新突破保存
	 * @param srcPath 原图片路径
	 * @param toPath 写入图片路径
	 * @param x 剪切起始点x坐标
	 * @param y 剪切起始点y坐标
	 * @param width 剪切宽度
	 * @param height 剪切高度
	 * @param readImageFormat 读取图片格式
	 * @param writeIamgeFormat 写入图片格式
	 * @throws IOException 
	 */
	public static void cropImage(String srcPath, String toPath, int x, int y,
			int width, int height, String readImageFormat,
			String writeIamgeFormat) throws IOException {
		FileInputStream fis = null;
		ImageInputStream iis = null;
		try {
			//读取图片文件
			fis = new FileInputStream(srcPath);
			Iterator it = ImageIO.getImageReadersByFormatName(readImageFormat);
			ImageReader reader = (ImageReader) it.next();
			//获取图片流
			iis = ImageIO.createImageInputStream(fis);
			reader.setInput(iis,true);
			ImageReadParam param = reader.getDefaultReadParam();
			//定义一个矩形
			Rectangle rect = new Rectangle(x, y, width, height);
			//提供一个 BufferedImage，将其用作解码像素数据的目标
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0,param);
			ImageIO.write(bi, writeIamgeFormat, new File(toPath));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis!=null){
				fis.close();
			}
			if(iis!=null){
				iis.close();
			}
		}
	}
	/**
	 * 将附加图片合并到底图的右上角
	 * @param negativeImagePath
	 * @param additionImagePath
	 * @param toPath
	 */
	public void mergeBothImageToPrightCornter(String negativeImagePath,
			String additionImagePath, String toPath) {
		InputStream is = null;
		InputStream is2 = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(negativeImagePath);
			is2 = new FileInputStream(additionImagePath);
			BufferedImage image = ImageIO.read(is);
			BufferedImage image2 = ImageIO.read(is2);
			Graphics g = image.getGraphics();
			g.drawImage(image2, image.getWidth()-image2.getWidth(), 0, null);
			os = new FileOutputStream(toPath);
//			jpegimage
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 画单点---画一个填充色的圆
	 * --以指定点坐标为中心画一个小半径的圆圈，并填充其颜色来当作填充点
	 * @param srcImagePath 远图片路径
	 * @param x 点坐标x
	 * @param y 点坐标y
	 * @param width 填充宽度
	 * @param height 填充高度
	 * @param ovalColor 填充颜色
	 * @param imageFormat 写入图片样式
	 * @param toPath 写入路径
	 * @throws IOException 
	 */
	public static void drawPoint(String srcImagePath, int x, int y, int width,
			int height, Color ovalColor, String imageFormat, String toPath) throws IOException {
		FileOutputStream fos = null;
		try {
			//获取原图片
			Image image1 = Toolkit.getDefaultToolkit().getImage(srcImagePath);
//			BufferedImage image = new BufferedImage
				//ImageIO.read(new File(srcImagePath));
			//根据xy点坐标绘制连接线
			BufferedImage image  = toBufferedImage(image1); 
			Graphics2D g2d = image.createGraphics();
			g2d.setColor(ovalColor);
			g2d.fillOval(x, y, width, height);
			fos = new FileOutputStream(toPath);
			ImageIO.write(image, imageFormat, fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fos!=null){
				fos.close();
			}
		}
	}
	/**
	 * 在图片上设置水印
	 * @param srcImagePath 原图片路径
	 * @param alpha 透明度（[0,1]）
	 * @param font  字体（宋体）
	 * @param fontStyle 字体格式
	 * @param fontSize 字体大小
	 * @param color 字体颜色
	 * @param inputWords 输入显示图片上的文字
	 * @param x 显示文字的起始x坐标 
	 * @param y 显示文字的起始y坐标
	 * @param imageFormat 写入图片的格式
	 * @param toPath 写入图片的路径
	 * @throws IOException 
	 */
	public static void alphWords2Image(String srcImagePath, float alpha, String font,
			int fontStyle, int fontSize, Color color, String inputWords, int x,
			int y, String imageFormat, String toPath) throws IOException {
		FileOutputStream fos = null;
		try {
			BufferedImage image = ImageIO.read(new File(srcImagePath));
			//创建java2D对象
			Graphics2D g2d = image.createGraphics();
			//用原图像填充背景
			g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(),null,null);
			//设置透明度
			AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
			g2d.setComposite(ac);
			g2d.setFont(new Font(font,fontStyle,fontSize));
			g2d.setColor(color);
			g2d.drawString(inputWords, x, y);
			g2d.dispose();
			fos = new FileOutputStream(toPath);
			ImageIO.write(image, imageFormat, fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fos!=null){
				fos.close();
			}
		}
		
	}
	/**
	 * 获取BufferedImage对象
	 * @param image
	 * @return
	 */
	public static BufferedImage toBufferedImage(Image image){
		if(image instanceof BufferedImage){
			return (BufferedImage)image;
		}
		image = new ImageIcon(image).getImage();
		BufferedImage bimage = null;
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		int transparency = Transparency.OPAQUE;
		GraphicsDevice gs = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gs.getDefaultConfiguration();
		bimage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null),transparency);
		if(bimage==null){
			int type = BufferedImage.TYPE_INT_RGB;
			bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);			
		}
		Graphics g = bimage.createGraphics();
		g.drawImage(image, 0, 0,null);
		g.dispose();
		return bimage;
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
			int f_x = image_width-diameter*4/5;//文字的起点x坐标
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
