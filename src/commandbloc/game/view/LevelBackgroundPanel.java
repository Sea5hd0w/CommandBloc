package commandbloc.game.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LevelBackgroundPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public LevelBackgroundPanel(){
		    super();
		    this.setOpaque(false);
		    this.setLayout(null);
	}

	public void paint(Graphics g){
		try {
			Image img0 = ImageIO.read(new File("images/Background/Fond0Medium.png"));
			Image img1 = ImageIO.read(new File("images/Background/Fond1Medium.png"));
			Image img2 = ImageIO.read(new File("images/Background/Fond2Medium.png"));
			g.drawImage(img0, 0, 0, this.getWidth(), this.getHeight(), this);
			g.drawImage(img1, 0, 0, this.getWidth(), this.getHeight(), this);
			g.drawImage(img2, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
}
