package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.mobile.Mobile;

public class Piston1  extends Actuator {

	public Piston1(int x, int y) {
		super(new Sprite("Bloc/Piston1R.png", "Bloc/Piston1G.png"), Permeability.BLOCKING, 7, x, y);
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
