package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.mobile.Mobile;

public class Piston2 extends Actuator {

	public Piston2(int x, int y) {
		super(new Sprite("Bloc/Piston2R.png", "Bloc/Piston2G.png"), Permeability.BLOCKING, 8, x, y);
	}
	
	@Override
	public void openclose(boolean openclose){
		super.openclose(openclose);
		for (Mobile s : this.getLevel().getMobiles()) {
			 if(s.getX() == this.getX() && s.getY() == this.getY()-1){
				 s.moveUp();
			 }
		}
	}
}