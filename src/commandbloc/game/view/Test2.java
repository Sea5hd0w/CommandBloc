package commandbloc.game.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import commandbloc.game.level.ILevel;

public class Test2 extends JPanel {
	public Test2() {
        super();
		this.setOpaque(false);
        this.setLayout(null);
	}
	
	@Override
	public void paintComponent(Graphics g){
		this.setBackground(new Color(0,0,0,0));
	    int x2[] = {50, 60, 80, 90, 90, 80, 60, 50};
	    int y2[] = {60, 50, 50, 60, 80, 90, 90, 80};
	    g.fillPolygon(x2, y2, 8);
	}
}