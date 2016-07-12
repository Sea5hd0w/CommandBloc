package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class UpRight extends Connector {

	public UpRight() {
		super(new Sprite("Bloc/UpRightR.png", "Bloc/UpRightG.png"), Permeability.BLOCKING, 50);
	}
}
