package commandbloc.game.level.element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite implements ISprite {
	private Image image;
	private Image image1;
	private Image image2;
	
	public Sprite(final String image1, final String image2) {
		try {
			this.image = ImageIO.read(new File("images/" + image1));
			this.image1 = ImageIO.read(new File("images/" + image1));
			this.image2 = ImageIO.read(new File("images/" + image2));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
	
	public Sprite() {
		this("blocT.png", "blocT.png");
	}

	@Override
	public Image getSprite() {
		return this.image;
	}
	
	@Override
	public void changeSprite(boolean openclose){
		System.out.println("Je change de sprite");
		if(openclose == true){
			this.image = this.image2;
		} else if(openclose == false){
			this.image = this.image1;
		}
	}
}