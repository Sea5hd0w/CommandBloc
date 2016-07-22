package commandbloc.game.level.element.mobile;

import java.awt.Point;

import commandbloc.game.level.ILevel;
import commandbloc.game.level.element.Element;
import commandbloc.game.level.element.ISprite;
import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.motionLess.Orientation;
import commandbloc.game.play.IOrderPerformed;
import commandbloc.game.play.UserOrder;

public class Mobile extends Element implements IMobile {
	private final Point position;

	public Mobile(final ISprite sprite) {
		super(sprite, Permeability.BLOCKING);
		this.position = new Point();
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

	public void setLevel(final ILevel level, final int x, final int y) {
		super.setLevel(level);
		this.setX(x);
		this.setY(y);
	}

	private boolean isMovePossible(final int x, final int y) {
		return (this.getLevel().getElements(x, y).getPermeability() != Permeability.BLOCKING);
	}

	public void moveUp() {
		if (this.isMovePossible(this.getX(), this.getY() - 1)) {
			this.setY(this.getY() - 1);
		}
	}

	public void moveLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY())) {
			this.setX(this.getX() - 1);
		}
	}

	public void moveDown() {
		if (this.isMovePossible(this.getX(), this.getY() + 1)) {
			this.setY(this.getY() + 1);
		}
	}

	public void moveRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY())) {
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
		y = y - 1;
		if(this.getLevel().getElements(x, y).getSensor() == true && this.getLevel().getElements(x, y).getOrientation() == Orientation.DOWN){
			if(this.getLevel().getElements(x, y).getOnOff() == true){
				this.getLevel().getElements(x, y).openclose(false);
			} else{
				this.getLevel().getElements(x, y).openclose(true);
			}
		}
	}
	
	protected void openSensorDown(int x, int y){
		y = y + 1;
		
		if(this.getLevel().getElements(x, y).getSensor() == true && this.getLevel().getElements(x, y).getOrientation() == Orientation.UP){
			if(this.getLevel().getElements(x, y).getOnOff() == true){
				this.getLevel().getElements(x, y).openclose(false);
			} else{
				this.getLevel().getElements(x, y).openclose(true);
			}
		}
	}
	
	protected void openSensorRight(int x, int y){
		x = x + 1;
		if(this.getLevel().getElements(x, y).getSensor() == true && this.getLevel().getElements(x, y).getOrientation() == Orientation.LEFT){
			if(this.getLevel().getElements(x, y).getOnOff() == true){
				this.getLevel().getElements(x, y).openclose(false);
			} else{
				this.getLevel().getElements(x, y).openclose(true);
			}
		}
	}
	
	protected void openSensorLeft(int x, int y){
		x = x - 1;
		if(this.getLevel().getElements(x, y).getSensor() == true && this.getLevel().getElements(x, y).getOrientation() == Orientation.RIGHT){
			if(this.getLevel().getElements(x, y).getOnOff() == true){
				this.getLevel().getElements(x, y).openclose(false);
			} else{
				this.getLevel().getElements(x, y).openclose(true);
			}
		}
	}
	
	public void fall(int x, int y){

	}
}
