package commandbloc.game.level.element.mobile;

import java.awt.Point;

import commandbloc.game.level.element.Sprite;
import commandbloc.game.play.UserOrder;
import commandbloc.game.view.LevelFrame;

public class Hero extends Mobile{	
	public Hero() {
		super(new Sprite("Player/player1A.png", "Player/player1D.png"));
	}

	@Override
	public void moveUp() {
		if(this.isLife() == true){
			super.moveUp();
			this.openSensor(this.getX(), this.getY(), UserOrder.UP);
		}
	}

	@Override
	public void moveLeft() {
		if(this.isLife() == true){
			if(this.isMovePossible(this.getX() - 1, this.getY()) == true){
				this.openSensor(this.getX(), this.getY(), UserOrder.LEFT);
				super.moveLeft();
				this.openSensor(this.getX(), this.getY(), UserOrder.DOWN);
				if(this.getLevel().getElements(this.getX(), this.getY()+1).getOnOff() == false && (this.getLevel().getElements(this.getX(), this.getY()+1).getClass().getSimpleName().contains("Peaks") == true ||this.getLevel().getElements(this.getX(), this.getY()).getClass().getSimpleName().contains("Peaks") == true)){
					this.death();
				}
			} else {
				this.openSensor(this.getX(), this.getY(), UserOrder.LEFT);
			}
			this.fall(this.getX(), this.getY());	
		}
	}

	@Override
	public void moveDown() {
		if(this.isLife() == true){
			super.moveDown();
			if(this.getLevel().getElements(this.getX(), this.getY()+1).getOnOff() == false && this.getLevel().getElements(this.getX(), this.getY()+1).getClass().getSimpleName().contains("Peaks") == true){
				this.death();
			}
			this.openSensor(this.getX(), this.getY(), UserOrder.DOWN);
		}
	}

	@Override
	public void moveRight() {
		if(this.isLife() == true){
			if(this.isMovePossible(this.getX() + 1, this.getY()) == true){
				this.openSensor(this.getX(), this.getY(), UserOrder.RIGHT);
				super.moveRight();
				this.openSensor(this.getX(), this.getY(), UserOrder.DOWN);
				if(this.getLevel().getElements(this.getX(), this.getY()+1).getOnOff() == false && this.getLevel().getElements(this.getX(), this.getY()+1).getClass().getSimpleName().contains("Peaks") == true){
					this.death();
				}
			} else {
				this.openSensor(this.getX(), this.getY(), UserOrder.RIGHT);
			}
			this.fall(this.getX(), this.getY());			
		}
	}

	public void moveBack() {
		this.setX(this.getLastPosition().x);
		this.setY(this.getLastPosition().y);
	}
}
