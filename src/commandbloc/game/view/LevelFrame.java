package commandbloc.game.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import commandbloc.game.level.ILevel;
import commandbloc.game.play.IOrderPerformed;

public class LevelFrame extends JFrame implements KeyListener, ILevelFrame {
	private static final long				serialVersionUID	= 1500600853286674118L;
	private final IOrderPerformed		levelPlay;
	private ILevel level;
	private LevelBackgroundPanel levelBackgroundPanel;
	private LevelMotionLessElementPanel levelMotionLessElementPanel;
	private LevelMotionLessElementComponentPanel levelMotionLessElementComponentPanel;
	
	private Test test;


	public LevelFrame(final String title, final ILevel level, final IOrderPerformed levelPlay) {
		this.levelPlay = levelPlay;
		this.level = level;
		
		this.setTitle(title);
		this.setSize(this.level.getWidth()*25,(this.level.getHeight()*40));
		//this.setSize(500,250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		this.test = new Test(level, this.level.getMobiles() , this.getHeight(), this.getWidth());
		this.add(this.test);
		
		/*
		this.levelBackgroundPanel = new LevelBackgroundPanel();
		this.add(this.levelBackgroundPanel);
		*/
		/*
		this.levelBackgroundPanel = new LevelBackgroundPanel();
		this.add(this.levelBackgroundPanel);
		

		this.levelMotionLessElementPanel = new LevelMotionLessElementPanel(level, this.getHeight(), this.getWidth());
		this.add(this.levelMotionLessElementPanel);
		
		this.levelMotionLessElementComponentPanel = new LevelMotionLessElementComponentPanel(level, this.getHeight(), this.getWidth());
		this.add(this.levelMotionLessElementComponentPanel);
		*/
		
		
		
		this.setResizable(true);
		this.addKeyListener(this);
		this.setVisible(true);
		this.setVisible(true);
	}

	private IOrderPerformed getLevelPlay() {
		return this.levelPlay;
	}

	public void refresh() {
		this.test.repaint();
	}
	
	@SuppressWarnings("static-access")
	public static void win(){
		JOptionPane jop1;
		jop1 = new JOptionPane();
		jop1.showMessageDialog(null, "YOU WIN", "WINNER", JOptionPane.INFORMATION_MESSAGE);
	}	
	
	@SuppressWarnings("static-access")
	public static void lose(){
		JOptionPane jop3;
		jop3 = new JOptionPane();
		jop3.showMessageDialog(null, "YOU ARE DEAD", "DIED", JOptionPane.ERROR_MESSAGE);
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
