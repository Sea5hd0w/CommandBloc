package commandbloc.game.level.element.motionLess;

import java.awt.Color;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class BlocB extends MotionLessElement {

	public BlocB(int x, int y) {
		super(new Sprite("Bloc/BlocB.png", "Bloc/BlocB.png"), Permeability.BLOCKING, 1, false, false, false, x ,y);
	}

}
