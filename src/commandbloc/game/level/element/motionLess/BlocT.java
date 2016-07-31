package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class BlocT extends MotionLessElement {

	public BlocT(int x, int y) {
		super(new Sprite("Bloc/BlocT.png", "Bloc/BlocT.png"), Permeability.PENETRABLE, 0, false, false, false, x, y);
	}

}
