package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.ISprite;
import commandbloc.game.level.element.Permeability;

public class Actuator extends MotionLessElement {

	public Actuator(ISprite sprite, Permeability permeability, int fileSymbol) {
		super(sprite, permeability, fileSymbol, false, true, false);
	}

}
