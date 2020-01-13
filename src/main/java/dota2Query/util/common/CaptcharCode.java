package dota2Query.util.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

public class CaptcharCode{
	private static char randomChar() {
		String string = "QWERTYUIOPLKJHGMNBVCXZASDF9731462580qwertypoiulkjhasdfgzxcvbnm";
		Random random = new Random();
		return string.charAt(random.nextInt(string.length()));
	}
	public static String drawImage(HttpServletResponse response) {
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		
		for (int i  = 0;i < 4;i++) {
			builder.append(randomChar());
		}
		
		String code = builder.toString();
		
		int width = 120;
		int height = 50;
		
		BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		
		Graphics2D graphics2d = bImage.createGraphics();
		
		Font font = new Font("宋体", Font.PLAIN,30);
		Color color = new Color(0,255,255);
		graphics2d.setFont(font);
		graphics2d.setColor(color);
		graphics2d.setBackground(new Color(0,0,0));
		
		graphics2d.clearRect(0, 0, width, height);
		FontRenderContext context = graphics2d.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(code, context);
		
		double x=(width-bounds.getWidth())/2;
		double y=(height-bounds.getHeight())/2;
		double acsent=bounds.getY();
		double baseY=y-acsent;
		
		for (int n = 0; n< 8;n++) {
			int xs = random.nextInt(width);
			int ys = random.nextInt(height);
			int xe = xs + random.nextInt(width/2);
			int ye = ys+ random.nextInt(height/2);
			
			int red = random.nextInt(255);
            int green = random.nextInt(255);
            int blue = random.nextInt(255);
            graphics2d.setColor(new Color(red,green,blue));
            graphics2d.drawLine(xs, ys, xe, ye);
		}
		
		float yawpRate = 0.05f;// 噪声率
		int area = (int) (yawpRate * width * height);
		for (int i = 0; i < area; i++) {
		         int xf = random.nextInt(width);
		         int yf = random.nextInt(height);
		          int rgb =new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)).getRGB();
		          bImage.setRGB(xf, yf, rgb);
		     }
		
		shear(graphics2d, width, height, new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
		//graphics2d.drawString(code,(int) x, (int)baseY);
		char[] chars = code.toCharArray();
	  for(int i = 0; i < code.length(); i++){
		       AffineTransform affine = new AffineTransform();
		       affine.setToRotation(Math.PI / 4 * random.nextDouble() * (random.nextBoolean() ? 1 : -1), (width / code.length()) * i +( height)/2, height/2);
		       graphics2d.setTransform(affine);
		       graphics2d.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
		       graphics2d.drawChars(chars, i, 1, ((width-10) / code.length()) * i + 5, height/2 + ( height)/2 - 10);
	}
		graphics2d.dispose();
		
			
		try {
			ImageIO.write(bImage,"jpg",response.getOutputStream());
            //刷新响应流
            response.flushBuffer();

		}catch (Exception e) {
			// TODO: handle exception
		}
		return code;
		
	}
	private static void shear(Graphics2D g, int w1, int h1, Color color) {
		        shearX(g, w1, h1, color);
		        shearY(g, w1, h1, color);
		     }
		      
		     private static void shearX(Graphics2D g, int w1, int h1, Color color) {
		    	 Random random = new Random();
		         int period = random.nextInt(2);
		  
		         boolean borderGap = true;
		         int frames = 1;
		         int phase = random.nextInt(2);
		  
		         for (int i = 0; i < h1; i++) {
		             double d = (double) (period >> 1)
		                     * Math.sin((double) i / (double) period
		                             + (6.2831853071795862D * (double) phase)
		                             / (double) frames);
		             g.copyArea(0, i, w1, 1, (int) d, 0);
		             if (borderGap) {
		                 g.setColor(color);
		                 g.drawLine((int) d, i, 0, i);
		                 g.drawLine((int) d + w1, i, w1, i);
		             }
		         }
		  
		     }
		  
		     private static void shearY(Graphics2D g, int w1, int h1, Color color) {
		    	 Random random = new Random();
		         int period = random.nextInt(40) + 10; // 50;
		  
		         boolean borderGap = true;
		         int frames = 20;
		         int phase = 7;
		         for (int i = 0; i < w1; i++) {
		             double d = (double) (period >> 1)
		                     * Math.sin((double) i / (double) period
		                             + (6.2831853071795862D * (double) phase)
		                             / (double) frames);
		             g.copyArea(i, 0, 1, h1, 0, (int) d);
		             if (borderGap) {
		                 g.setColor(color);
		                 g.drawLine(i, (int) d, i, 0);
		                 g.drawLine(i, (int) d + h1, i, h1);
		             }
		  
		         }
		     }
}