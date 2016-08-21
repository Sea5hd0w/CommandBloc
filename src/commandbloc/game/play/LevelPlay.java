package commandbloc.game.play;

import java.io.IOException;
import java.sql.SQLException;

import commandbloc.game.level.ILevel;
import commandbloc.game.level.element.mobile.Hero;
import commandbloc.game.level.element.mobile.monsters.Monster1;
import commandbloc.game.view.ILevelFrame;

public class LevelPlay implements IOrderPerformed {
	private final ILevel level;
	private ILevelFrame	levelFrame;
	//private int	playMode;
	//private DAOLevel daoLevel;

	public LevelPlay(ILevel level, int lvl) throws SQLException{
		//DBConnection dbConnection = new DBConnection();
		//Connection connection = dbConnection.getConnection();
		//this.daoLevel = new DAOLevel(connection);
		this.level = level;
		//this.daoLevel.findMobile(lvl, 1);
		//this.level.addMobile(new Hero(0), this.daoLevel.getX()-1 , this.daoLevel.getY()-1);
		this.level.addMobile(new Hero(), 1, 1);
		this.level.addMobile(new Monster1(), 23, 3);
		//this.level.addMobile(new Monster1(), 22, 3);
		System.out.println("//////////////////////////////////////////ICI\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
	}

	public ILevel getLevel() {
		return this.level;
	}

	private ILevelFrame getLevelFrame() {
		return this.levelFrame;
	}
	
	public void setLevelFrame(final ILevelFrame levelFrame) {
		this.levelFrame = levelFrame;
	}
/*
	private int getPlayMode() {
		return this.playMode;
	}

	private void setPlayMode(final int playMode) {
		this.playMode = playMode;
		this.getLevelFrame().setViewMode(playMode);
	}
*/
	@Override
	public void orderPerform(final UserOrder userOrder) throws IOException {
		switch (userOrder) {
		case UP:
			System.out.println("Hero : UP");
			this.getLevel().getHero().moveUp();
			this.levelFrame.refresh();
			break;
		case RIGHT:
			System.out.println("Hero : RIGHT");
			this.getLevel().getHero().moveRight();
			this.levelFrame.refresh();
			break;
		case DOWN:
			System.out.println("Hero : DOWN");
			this.getLevel().getHero().moveDown();
			this.levelFrame.refresh();
			break;
		case LEFT:
			System.out.println("Hero : LEFT");
			this.getLevel().getHero().moveLeft();
			this.levelFrame.refresh();
			break;
		case NOP:
			System.out.println("Hero : NOP");
		default:
			break;
		}
	}
}
