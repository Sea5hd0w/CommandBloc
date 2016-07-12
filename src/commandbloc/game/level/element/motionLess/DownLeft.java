package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class DownLeft extends Connector {

	public DownLeft() {
		super(new Sprite("Bloc/DownLeftR.png", "Bloc/DownLeftG.png"), Permeability.BLOCKING, 52);
	}
}
