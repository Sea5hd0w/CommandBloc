package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.ISprite;
import commandbloc.game.level.element.Permeability;

public class Actuator extends MotionLessElement {

	public Actuator(ISprite sprite, Permeability permeability, int fileSymbol, int x, int y) {
		super(sprite, permeability, fileSymbol, false, true, false, x, y);
	}

}
