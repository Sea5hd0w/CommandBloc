package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class DownRight extends Connector {

	public DownRight(int x, int y) {
		super(new Sprite("Bloc/DownRight.png", "Bloc/DownRight.png"), Permeability.BLOCKING, 51, x , y);
	}
}
