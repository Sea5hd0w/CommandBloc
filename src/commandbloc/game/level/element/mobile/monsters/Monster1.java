package commandbloc.game.level.element.mobile.monsters;

import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.mobile.Monster;
import commandbloc.game.play.UserOrder;

public class Monster1 extends Monster implements Runnable{

	public Monster1() {
		super(new Sprite("Monster_PNJ/Monster1A.png", "Monster_PNJ/Monster1D.png"));
		Thread threadMonster1 =  new Thread(this) ;
		threadMonster1.start();

	}

	@Override
	public void run() {
		for(;;){
			try {

				Thread.sleep(350);
				if((this.getLastPosition().x == this.getPosition().x) && (this.getLastPosition().y == this.getPosition().y)){
					System.out.println(this.getPosition() + " + " + this.getLastPosition());

					if(this.isMovePossible(this.getX()+1, this.getY()) == true){
						this.moveRight();
					} else {
						this.moveLeft();
					}
				} else {
					if(this.getLastPosition().x+1 == this.getPosition().x && this.isMovePossible(this.getX()+1, this.getY()) == true){
						this.moveRight();
					} else if (this.getLastPosition().x-1 == this.getPosition().x && this.isMovePossible(this.getX()-1, this.getY()) == true){
						this.moveLeft();
					} else if(this.getLastPosition().x+1 == this.getPosition().x && this.isMovePossible(this.getX()+1, this.getY()) == false){
						this.moveLeft();
					} else if(this.getLastPosition().x-1 == this.getPosition().x && this.isMovePossible(this.getX()-1, this.getY()) == false){
						this.moveRight();
					}
				}
				
				if(this.getX() == this.getLevel().getHero().getPosition().x && this.getY() == this.getLevel().getHero().getPosition().y){
					this.getLevel().getHero().death();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
}
