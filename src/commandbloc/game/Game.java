package commandbloc.game;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import commandbloc.game.level.ILevel;
import commandbloc.game.level.Level;
import commandbloc.game.play.LevelPlay;
import commandbloc.game.view.ILevelFrame;
import commandbloc.game.view.LevelFrame;

public class Game implements Runnable {
	private final ILevel	level;
	private final LevelPlay		levelPlay;
	private ILevelFrame				levelFrame;

	public Game() throws IOException, SQLException {

		/*Scanner sc = new Scanner(System.in);
		System.out.println("Level a ouvrir? ");
		String str = sc.nextLine();*/
		String str = "Niveau_0";
		
		this.level = new Level(str + ".txt");
		this.levelPlay = new LevelPlay(this.level, 0);
		SwingUtilities.invokeLater(this);
	}

	@Override
	public void run() {
		this.levelFrame = new LevelFrame("CommandBloc", this.getLevel(), this.getLevelPlay());
		this.levelPlay.setLevelFrame(this.levelFrame);
	}

	private ILevel getLevel() {
		return this.level;
	}

	private LevelPlay getLevelPlay() {
		return this.levelPlay;
	}
}
