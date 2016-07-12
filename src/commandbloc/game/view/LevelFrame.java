package commandbloc.game.view;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import commandbloc.game.level.ILevel;
import commandbloc.game.play.IOrderPerformed;

public class LevelFrame extends JFrame implements KeyListener, ILevelFrame {
	private static final long				serialVersionUID	= 1500600853286674118L;
	private final IOrderPerformed		levelPlay;
	private LevelPanel levelPanel;
	

	public LevelFrame(final String title, final ILevel level, final IOrderPerformed levelPlay) {
		this.setTitle(title);
		this.setSize(2000,1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.levelPlay = levelPlay;

		//this.levelPanel = new LevelPanel(level, this.getHeight(), this.getWidth());
		//this.setContentPane(levelPanel);


		Test test = new Test(level, this.getHeight(), this.getWidth());
		this.setContentPane(test);
		
		this.setResizable(true);
		this.addKeyListener(this);
		this.setVisible(true);
	}

	private IOrderPerformed getLevelPlay() {
		return this.levelPlay;
	}

	public void refresh() {
		this.levelPanel.repaint();
	}

	@Override
	public void repaint() {
		
	}
	
	@Override
	public void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getLevelPlay().orderPerform(LevelView.keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void keyReleased(final KeyEvent arg0) {
	}

	@Override
	public void keyTyped(final KeyEvent arg0) {
	}

}
