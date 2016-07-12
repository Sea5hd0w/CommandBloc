package commandbloc.game.play;

import java.io.IOException;
import java.sql.SQLException;

import commandbloc.game.level.ILevel;
import commandbloc.game.level.element.mobile.Hero;
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
		this.level.addMobile(new Hero(), 1, 4);
	}

	public void play() throws InterruptedException
	{
		
		for(;;)
		{
			System.out.println("Boucle play() en marche");
			/*for(MonsterMobile m : this.level.getMobiles()){
				m.getAnimate(m);
			}
			this.level.destructCollected();*/
		}
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
			//this.getLevel().getHero().moveUp();
			this.getLevel().getElements(3, 5).openclose(true);
			this.levelFrame.refresh();
			break;
		case RIGHT:
			System.out.println("Hero : RIGHT");
			this.getLevel().getElements(11, 4).openclose(true);
			this.levelFrame.refresh();
			//this.getLevel().getHero().moveRight();
			break;
		case DOWN:
			System.out.println("Hero : DOWN");
			this.getLevel().getElements(9, 4).openclose(true);
			this.levelFrame.refresh();
			//this.getLevel().getHero().moveDown();
			break;
		case LEFT:
			System.out.println("Hero : LEFT");
			//this.getLevel().getHero().moveLeft();
			break;
		case NOP:
			System.out.println("Hero : NOP");
		default:
			break;
		}
	}
}
