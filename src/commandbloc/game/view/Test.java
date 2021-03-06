	package commandbloc.game.view;

	import java.awt.Color;
import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.Image;
	import java.awt.RenderingHints;
	import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import commandbloc.game.level.ILevel;
import commandbloc.game.level.element.mobile.Mobile;

	public class Test extends JPanel {
		private static final long serialVersionUID = 1L;
		private ILevel level;
		private int x;
		private int y;
		private int xElement;
		private int yElement;
		
		public Test(ILevel level, ArrayList<Mobile>	mobiles, int x, int y) {
	        super();
			this.setOpaque(false);
	        this.setLayout(null);
			this.level = level;
			this.x=x;
			this.y=y;
			this.xElement = this.level.getHeight();
			this.yElement = this.level.getWidth();
		}

		public void paint(Graphics g){
			setBackground(new Color(10,10,10,10));
			for(int v = 0; v< this.xElement ;v++){
				for(int w = 0; w< this.yElement ;w++){
					Image img0 = this.level.getElements(w, v).getSprite().getSprite();
					img0 = scaleImage(img0, x, y, xElement, yElement);
					g.drawImage(img0, (w-1) * (y/yElement), (v-1) * (x/xElement), this);
						
					for(Mobile m : this.level.getMobiles()){
						if(m.getX() == w &&	m.getY() == v){
							Image img1 = m.getImage();
							img1 = scaleImage(img1, x, y, xElement, yElement);
							g.drawImage(img1, (w-1) * (y/yElement), (v-1) * (x/xElement), this);
							System.out.println("Coordonnées du Mobile (" + m.getClass().getSimpleName() + ") : [" + v + "]:[" + w + "]");
						}
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