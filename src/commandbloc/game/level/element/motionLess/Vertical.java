package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class Vertical extends Connector {

	public Vertical(int x, int y) {
		super(new Sprite("Bloc/VerticalR.png", "Bloc/VerticalG.png"), Permeability.BLOCKING, 58, x, y);
	}

}
