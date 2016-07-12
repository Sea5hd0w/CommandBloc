package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class Horizontal extends Connector {

	public Horizontal() {
		super(new Sprite("Bloc/HorizontalR.png", "Bloc/HorizontalG.png"), Permeability.BLOCKING, 59);
	}
}
