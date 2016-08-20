package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.ISprite;
import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.mobile.Mobile;

public class Piston extends Actuator {
	public Piston(ISprite sprite, Permeability permeability, int fileSymbol, int x, int y) {
		super(sprite, permeability, fileSymbol, x, y);
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
