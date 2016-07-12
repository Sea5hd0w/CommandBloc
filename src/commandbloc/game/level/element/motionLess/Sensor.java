package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.ISprite;
import commandbloc.game.level.element.Permeability;

public class Sensor extends MotionLessElement{

	public Sensor(ISprite sprite, Permeability permeability, int fileSymbol) {
		super(sprite, permeability, fileSymbol, true, false, false);
	}
}
