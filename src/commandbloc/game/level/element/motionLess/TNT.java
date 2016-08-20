package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.mobile.Mobile;

public class TNT extends Actuator implements Runnable {
	private boolean openclose;
	private int time;
	private int action;
	
	public TNT(int x, int y, int time, int action) {
		super(new Sprite("Bloc/TNT1.png", "Bloc/BlocT.png"), Permeability.BLOCKING, 9, x, y);
		this.openclose = false;
		this.time = time;
		this.action = action;
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
			for(int x = this.getX()-action; x <= this.getX()+action; x++){
				for(int y = this.getY()-action; y <= this.getY()+action; y++){
					if(x >= 0 && x < this.getLevel().getWidth() && y >= 0 && y < this.getLevel().getHeight()){
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
}