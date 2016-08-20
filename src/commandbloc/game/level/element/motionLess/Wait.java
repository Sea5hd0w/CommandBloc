package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.ISprite;
import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class Wait extends Sensor implements Runnable {
	private boolean openclose;
	private int time;
	
	public Wait(ISprite sprite, int x, int y, int time) {
		super(sprite , Permeability.BLOCKING, 74, x, y);
		this.time = time;
	}

	@Override
	public void openclose(boolean openclose){

		this.openclose = openclose;


			Thread thread =  new Thread(this) ;
			thread.start();

		this.getLevel().setMobileHasChanged();
	}

	@Override
	public void run() {
		try {
			if(openclose == true){
				Thread.sleep(time * 1000);
			} else{
				Thread.sleep(time/2 * 1000);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.openclose(openclose);
	}
}