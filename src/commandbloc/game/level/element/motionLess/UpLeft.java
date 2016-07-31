package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class UpLeft extends Connector {

	public UpLeft(int x, int y) {
		super(new Sprite("Bloc/UpLeftR.png", "Bloc/UpLeftG.png"), Permeability.BLOCKING, 53, x, y);
	}
}
