package commandbloc.game.level.element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

public class Picture {
    private static volatile Picture instance = null;
    private String image10;
	private Image image1;
    private String image20;
	private Image image2;
	
	private Picture(final String image1, final String image2) {
		System.out.println("\t\t\t\tSprite cree : [" + image1 + "] : [" + image2 + "]");
		try {
			this.image1 = ImageIO.read(new File("images/" + image1));
			this.image10 = image1;
			this.image2 = ImageIO.read(new File("images/" + image2));
			this.image20 = image2;
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
	
	
    public final static Picture getInstance(final String image1, final String image2) {
        if (Picture.instance == null || (Picture.instance.image10 != image1 && Picture.instance.image20 != image2)) {
           synchronized(Picture.class) {
             if (Picture.instance == null || (Picture.instance.image10 != image1 && Picture.instance.image20 != image2)) {
            	 Picture.instance = new Picture(image1, image2);
             }
           }
        }
        return Picture.instance;
    }
	
    
    public Image getImage(boolean image){
    	if(image == false){
    		return image1;
    	} else {
    		return image2;
    	}
    }
}
