package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class BlocT extends MotionLessElement {

	public BlocT() {
		super(new Sprite("Bloc/BlocT.png", "Bloc/BlocT.png"), Permeability.BLOCKING, 0, false, false, false);
	}

}
