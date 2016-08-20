package commandbloc.game.level.element.motionLess.components;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.motionLess.Peaks;

public class Peaks2 extends Peaks {

	public Peaks2(int x, int y) {
		super(new Sprite("Bloc/Peaks2.png", "Bloc/Peaks2.png"), Permeability.PENETRABLE, 13, x, y);
	}
	
	@Override
	public void openclose(boolean openclose){}
}
