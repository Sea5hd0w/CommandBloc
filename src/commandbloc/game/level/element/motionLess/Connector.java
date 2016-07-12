package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.ISprite;
import commandbloc.game.level.element.Permeability;

public class Connector extends MotionLessElement{

	public Connector(ISprite sprite, Permeability permeability, int fileSymbol) {
		super(sprite, permeability, fileSymbol, false, false, true);
	}
}
