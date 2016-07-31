package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class Cross extends Connector {

	public Cross(int x, int y) {
		super(new Sprite("Bloc/CrossR.png", "Bloc/CrossG.png"), Permeability.BLOCKING, 49, x, y);
	}
}
