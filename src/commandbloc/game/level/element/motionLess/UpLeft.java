package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class UpLeft extends Connector {

	public UpLeft() {
		super(new Sprite("Bloc/UpLeftR.png", "Bloc/UpLeftG.png"), Permeability.BLOCKING, 53);
	}
}
