package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class Down extends Connector {

	public Down(int x, int y) {
		super(new Sprite("Bloc/DownR.png", "Bloc/DownG.png"), Permeability.BLOCKING, 56, x, y);
	}

}
