package utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class ScreenShotRob {
	
	public static void captureScreenShot() throws AWTException, IOException {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh").format(new Date());
		Robot rob = new Robot();
		Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage img = rob.createScreenCapture(screenSize); 
		 String path=System.getProperty("user.dir")+"\\ScreenShot\\"+ timeStamp +".png";
		 ImageIO.write(img, "png",new File(path)); 
	}
	public static String returnPath() {
		// TODO Auto-generated method stub
		String fileName = new SimpleDateFormat("yyyy.MM.dd.hh").format(new Date());
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\"+fileName+".png";
		return destination;
	}
}
