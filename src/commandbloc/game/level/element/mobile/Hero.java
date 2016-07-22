package commandbloc.game.level.element.mobile;

import java.awt.Point;

import commandbloc.game.level.element.Sprite;
import commandbloc.game.play.UserOrder;

public class Hero extends Mobile{
	private final Point lastPosition;
	private int life;
	
	public Hero() {
		super(new Sprite("Player/player1.png", "Player/player1.png"));
		this.lastPosition = new Point();
		this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
	}

	private void saveLastPosition() {
		if ((this.lastPosition.getX() != this.getPosition().getX()) || (this.lastPosition.getY() != this.getPosition().getY())) {
			this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
		}
	}

	@Override
	public void moveUp() {
		this.saveLastPosition();
		this.openSensor(this.getX(), this.getY(), UserOrder.UP);
		super.moveUp();
	}

	@Override
	public void moveLeft() {
		this.saveLastPosition();
		this.openSensor(this.getX(), this.getY(), UserOrder.LEFT);
		super.moveLeft();
		this.openSensor(this.getX(), this.getY(), UserOrder.DOWN);

	}

	@Override
	public void moveDown() {
		this.openSensor(this.getX(), this.getY(), UserOrder.DOWN);
		this.saveLastPosition();
		super.moveDown();
	}

	@Override
	public void moveRight() {
		this.saveLastPosition();
		this.openSensor(this.getX(), this.getY(), UserOrder.RIGHT);
		super.moveRight();
		this.openSensor(this.getX(), this.getY(), UserOrder.DOWN);
		
		this.fall(this.getX(), this.getY());
	}

	public void moveBack() {
		this.setX(this.lastPosition.x);
		this.setY(this.lastPosition.y);
	}
	
}
