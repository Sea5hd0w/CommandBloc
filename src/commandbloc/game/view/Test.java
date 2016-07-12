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

public class Test extends JLayeredPane {
	private static final long serialVersionUID = 1L;
	private ILevel level;
	private int x;
	private int y;
	private int xElement;
	private int yElement;
	
	public Test(ILevel level, int x, int y) {
		this.level = level;
		this.x=x;
		this.y=y;
		this.xElement = this.level.getHeight();
		this.yElement = this.level.getWidth();
	}

	public void paint(Graphics g){
		Test2 test = new Test2(level, this.getHeight(), this.getWidth());
		test.paintMotionLess(g);
		//test.paintMotion(g);
	}
}