package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.ISprite;
import commandbloc.game.level.element.Permeability;

public class Connector extends MotionLessElement{

	public Connector(ISprite sprite, Permeability permeability, int fileSymbol, int x, int y) {
		super(sprite, permeability, fileSymbol, false, false, true, x, y);
	}
}
