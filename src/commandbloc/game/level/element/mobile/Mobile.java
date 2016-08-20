package commandbloc.game.level.element.mobile;

import java.awt.Point;

import commandbloc.game.level.ILevel;
import commandbloc.game.level.element.Element;
import commandbloc.game.level.element.ISprite;
import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.motionLess.Orientation;
import commandbloc.game.play.IOrderPerformed;
import commandbloc.game.play.UserOrder;
import commandbloc.game.view.LevelFrame;

public class Mobile extends Element implements IMobile {
	private final Point position;
	private final Point lastPosition;

	private boolean life;

	public Mobile(final ISprite sprite) {
		super(sprite, Permeability.BLOCKING);
		this.position = new Point();
		this.lastPosition = new Point();
		this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);

		this.setLife(true);
	}

	@Override
	public int getX() {
		return this.position.x;
	}

	protected void setX(final int x) {
		if ((x >= 0) && (x < this.getLevel().getWidth())) {
			this.position.x = x;
			this.getLevel().setMobileHasChanged();
		}
	}

	@Override
	public int getY() {
		return this.position.y;
	}

	protected void setY(final int y) {
		if ((y >= 0) && (y < this.getLevel().getHeight())) {
			this.position.y = y;
			this.getLevel().setMobileHasChanged();
		}
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	public Point getLastPosition(){
		return this.lastPosition;
	}
	
	private void saveLastPosition() {
		if ((this.lastPosition.getX() != this.getPosition().getX()) || (this.lastPosition.getY() != this.getPosition().getY())) {
			this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
		}
	}
	
	public void setLevel(final ILevel level, final int x, final int y) {
		super.setLevel(level);
		this.setX(x);
		this.setY(y);
		this.saveLastPosition();
	}

	protected boolean isMovePossible(final int x, final int y) {
		if(x < this.getLevel().getWidth()-1 && x >= 0 && y < this.getLevel().getHeight()-1 && y >= 0 ){
			if(this.getLevel().getElements(x, y+1).getClass().getSimpleName().contains("Piston") == true && (y+1) < this.getLevel().getHeight()){
				if(this.getLevel().getElements(x, y+1).getOnOff() == true){
					return false;
				} else{
					return true;
				}
			}else if (this.getLevel().getElements(x, y).getPermeability() != Permeability.BLOCKING){
				return true;
			}
		}
		return false;
	}

	public void moveUp() {
		if (this.isMovePossible(this.getX(), this.getY() - 1)) {
			this.saveLastPosition();
			this.setY(this.getY() - 1);
		}
	}

	public void moveLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY())) {
			this.saveLastPosition();
			this.setX(this.getX() - 1);
		}
	}

	public void moveDown() {
		if (this.isMovePossible(this.getX(), this.getY() + 1)) {
			this.saveLastPosition();
			this.setY(this.getY() + 1);
		}
	}

	public void moveRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY())) {
			this.saveLastPosition();
			this.setX(this.getX() + 1);
		}
	}
	
	protected void openSensor(int x, int y, UserOrder test){
		if(test == UserOrder.DOWN){
			this.openSensorDown(x, y);
		} else if(test == UserOrder.LEFT){
			this.openSensorLeft(x, y);
		} else if(test == UserOrder.RIGHT){
			this.openSensorRight(x, y);
		} else if(test == UserOrder.UP){
			this.openSensorUp(x, y);
		}		
	}
	
	protected void openSensorUp(int x, int y){
		if(y != 0){
			y = y - 1;
		}
		if(this.getLevel().getElements(x, y).getSensor() == true && this.getLevel().getElements(x, y).getOrientation() == Orientation.DOWN){
			if(this.getLevel().getElements(x, y).getOnOff() == true){
				this.getLevel().getElements(x, y).openclose(false);
			} else{
				this.getLevel().getElements(x, y).openclose(true);
			}
		}
	}
	
	protected void openSensorDown(int x, int y){
		if(y < this.getLevel().getHeight()){
			y = y + 1;	
		}
		if(this.getLevel().getElements(x, y).getSensor() == true && this.getLevel().getElements(x, y).getOrientation() == Orientation.UP){
			if(this.getLevel().getElements(x, y).getOnOff() == true){
				this.getLevel().getElements(x, y).openclose(false);
			} else{
				this.getLevel().getElements(x, y).openclose(true);
			}
		}
	}
	
	protected void openSensorRight(int x, int y){
		if(x < this.getLevel().getWidth()){
			x = x + 1;
		}

		if(this.getLevel().getElements(x, y).getSensor() == true && this.getLevel().getElements(x, y).getOrientation() == Orientation.LEFT){
			if(this.getLevel().getElements(x, y).getOnOff() == true){
				this.getLevel().getElements(x, y).openclose(false);
			} else{
				this.getLevel().getElements(x, y).openclose(true);
			}
		}
	}
	
	protected void openSensorLeft(int x, int y){
		if(x != 0){
			x = x - 1;
		}
		if(this.getLevel().getElements(x, y).getSensor() == true && this.getLevel().getElements(x, y).getOrientation() == Orientation.RIGHT){
			if(this.getLevel().getElements(x, y).getOnOff() == true){
				this.getLevel().getElements(x, y).openclose(false);
			} else{
				this.getLevel().getElements(x, y).openclose(true);
			}
		}
	}
	
	public void fall(int x, int y){
		int x1 = x;
		int y1 = y;
		while(this.isMovePossible(x1, y1+1) == true){
			this.moveDown();
			y1 = y1 + 1;
		}
	}
	
	public void death(){
		if(this.life == true){
			this.setLife(false);
			this.openCloseSprite(true);
			LevelFrame.lose();			
		}
	}

	public boolean isLife() {
		return life;
	}

	private void setLife(boolean life) {
		this.life = life;
	}
}
