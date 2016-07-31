package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class UpRight extends Connector {

	public UpRight(int x, int y) {
		super(new Sprite("Bloc/UpRightR.png", "Bloc/UpRightG.png"), Permeability.BLOCKING, 50, x, y);
	}
}
