package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.mobile.Mobile;

public class TNT1 extends Actuator implements Runnable {
	private boolean openclose;
	private int time;
	
	public TNT1(int x, int y, int time) {
		super(new Sprite("Bloc/TNT1.png", "Bloc/BlocT.png"), Permeability.BLOCKING, 9, x, y);
		this.openclose = false;
		this.time = time;
	}
	
	@Override
	public void openclose(boolean openclose){
		this.openclose = true;
		Thread thread =  new Thread(this) ;
		thread.start();
		this.getLevel().setMobileHasChanged();
	}
	
	@Override
	public void run() {
		System.out.println("J'ouvre/Je ferme");
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(this.openclose == true){
			super.openclose(openclose);
			for(int x = this.getX()-1; x <= this.getX()+1; x++){
				for(int y = this.getY()-1; y <= this.getY()+1; y++){
					this.getLevel().addElement(MotionLessElements.BLOCT, x, y);
					for (Mobile s : this.getLevel().getMobiles()) {
						 if(s.getX() == x && s.getY() == y){
							 s.death();
						 }
					}
				}
			}
		}
	}
}