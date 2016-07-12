package commandbloc.game.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;

import commandbloc.game.level.ILevel;

public class Test2 extends JLayeredPane {
	private static final long serialVersionUID = 1L;
	private ILevel level;
	private int x;
	private int y;
	private int xElement;
	private int yElement;
	
	
	public Test2(ILevel level, int x, int y) {
		this.level = level;
		this.x=x;
		this.y=y;
		this.xElement = this.level.getHeight();
		this.yElement = this.level.getWidth();
	}

	public void paintMotion(Graphics g){
		for(int v = 0; v< this.xElement ;v++){
			for(int w = 0; w< this.yElement ;w++){
				if(this.level.getElements(w, v).getActuator() == false || this.level.getElements(w, v).getSensor() == false || this.level.getElements(w, v).getConnector() == false){
					Image img0 = this.level.getElements(w, v).getSprite().getSprite();
					img0 = scaleImage(img0, x, y, xElement, yElement);
					g.drawImage(img0, (w-1) * (y/yElement), (v-1) * (x/xElement), this);
				}
			}
		}
	}
	
	public void paintMotionLess(Graphics g){
		for(int v = 0; v< this.xElement ;v++){
			for(int w = 0; w< this.yElement ;w++){
				if(this.level.getElements(w, v).getActuator() == true || this.level.getElements(w, v).getSensor() == true || this.level.getElements(w, v).getConnector() == true){
					Image img0 = this.level.getElements(w, v).getSprite().getSprite();
					img0 = scaleImage(img0, x, y, xElement, yElement);
					g.drawImage(img0, (w-1) * (y/yElement), (v-1) * (x/xElement), this);
				}
			}
		}
	}
	
	public static Image scaleImage(Image source, int x, int y, int xElement, int yElement) {
		int  height = (x / xElement)*3;
		int width = (y / yElement)*3;
	    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = (Graphics2D) img.getGraphics();
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.drawImage(source, 0, 0, width, height, null);
	    g.dispose();
	    return img;
	}
}