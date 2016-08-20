package commandbloc.game.level.element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite implements ISprite {
	private Picture Image;
	private boolean picture;
	
	public Sprite(final String image1, final String image2) {
		this.Image = Picture.getInstance(image1, image2);
	}
	
	public Sprite() {
		this("blocT.png", "blocT.png");
	}

	@Override
	public Image getSprite() {
		return this.Image.getImage(this.picture);
	}
	
	@Override
	public void changeSprite(boolean openclose){
		System.out.println("Je change de sprite");
		this.picture = openclose;
	}
}