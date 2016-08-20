package commandbloc.game.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LevelBackgroundPanel extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private Image img0;
	private Image img1;
	private Image img2;

	public LevelBackgroundPanel(){
		    super();
		    this.setOpaque(false);
		    this.setLayout(null);
		    this.x = 0;
		    this.y = 0;
			try {
				System.out.println(this.getHeight() + " " + this.getWidth());
				this.img0 = ImageIO.read(new File("images/Background/Fond0Medium.png"));
				this.img1 = ImageIO.read(new File("images/Background/Fond1Medium.png"));
				this.img2 = ImageIO.read(new File("images/Background/Fond2Medium.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    Thread test = new Thread(this);
		    test.start();
	}

	public void paint(Graphics g){
		int xTest1= x%this.getWidth();
		int xTest2 =(x/2)%this.getWidth();
		
		g.drawImage(scaleImage(this.img0, this.getWidth(), this.getHeight()), 0, 0, this.getWidth(), this.getHeight(), this);
		g.drawImage(scaleImage(this.img1, this.getWidth(), this.getHeight()), xTest2, y, this.getWidth(), this.getHeight(), this);
		g.drawImage(scaleImage(this.img2, this.getWidth(), this.getHeight()), xTest1, y, this.getWidth(), this.getHeight(), this);
		g.drawImage(scaleImage(this.img1, this.getWidth(), this.getHeight()), -this.getWidth() + xTest2, y, this.getWidth(), this.getHeight(), this);
		g.drawImage(scaleImage(this.img2, this.getWidth(), this.getHeight()), -this.getWidth() + xTest1, y, this.getWidth(), this.getHeight(), this);
	}

	public static Image scaleImage(Image source, int  height, int width) {
	    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = (Graphics2D) img.getGraphics();
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.drawImage(source, 0, 0, width, height, null);
	    g.dispose();
	    return img;
	}
	
	
	@Override
	public void run() {
		for(;;){
			this.x = this.x + 1;
			this.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
