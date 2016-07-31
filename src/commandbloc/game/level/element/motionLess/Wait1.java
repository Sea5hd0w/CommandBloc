package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.view.LevelFrame;

public class Wait1 extends Sensor implements Runnable {
	private boolean openclose;
	private int time;
	
	public Wait1(int x, int y, int time) {
		super(new Sprite("Bloc/Wait1R.png", "Bloc/Wait1G.png"), Permeability.BLOCKING, 74, x, y);
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
		System.out.println("J'ouvre/Je ferme");
		this.setOnOff(openclose);
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.openCloseSprite(openclose);
		this.getLevel().setMobileHasChanged();
		this.openCloseLinkedObject(openclose);
	}
}