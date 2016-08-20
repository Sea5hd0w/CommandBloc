package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.ISprite;
import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.mobile.Mobile;

public class PressureSensor extends Sensor implements Runnable{
	
	public PressureSensor(ISprite sprite, Permeability permeability, int fileSymbol, int x, int y) {
		super(sprite, permeability, fileSymbol, x, y);
	}
	
	@Override
	public void openclose(boolean openclose){
		super.openclose(openclose);
		Thread thread =  new Thread(this) ;
		thread.start();
	}
	
	@Override
	public void run() {
		while(this.getOnOff() == true){
			for (Mobile s : this.getLevel().getMobiles()) {
				 if(s.getX() != this.getX() || s.getY() != this.getY()-1){
					 super.openclose(false);	 
				 }
			}
		}
	}
}
