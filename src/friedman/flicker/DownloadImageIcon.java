package friedman.flicker;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class DownloadImageIcon extends Thread {
	FlickerFeedFrame frame;
	private static final String flickerIcon ="https://s.yimg.com/pw/images/goodies/white-large-chiclet.png";
	public DownloadImageIcon(FlickerFeedFrame frame){
		this.frame =frame;
	}
	public void run(){
		try{
		URL imgUrl = new URL(flickerIcon);
		BufferedImage img = ImageIO.read(imgUrl);
		frame.setIconImage(new ImageIcon(img).getImage());
		} catch (MalformedURLException m) {
			m.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
