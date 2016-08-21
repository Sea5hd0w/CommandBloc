package commandbloc.game.level.element.mobile;

import commandbloc.game.level.element.ISprite;

public class Monster  extends Mobile  implements Runnable{

	public Monster(ISprite sprite) {
		super(sprite);
		Thread threadMonster1 =  new Thread(this) ;
		threadMonster1.start();
	}
	
	@Override
	public void run() {
		
	}
}
