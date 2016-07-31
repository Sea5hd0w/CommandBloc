package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class Up extends Connector {

	public Up(int x, int y) {
		super(new Sprite("Bloc/UpR.png", "Bloc/UpG.png"), Permeability.BLOCKING, 54, x, y);
	}
}
