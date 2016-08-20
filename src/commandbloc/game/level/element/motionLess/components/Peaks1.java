package commandbloc.game.level.element.motionLess.components;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.motionLess.Peaks;

public class Peaks1 extends Peaks {

	public Peaks1(int x, int y) {
		super(new Sprite("Bloc/Peaks1R.png", "Bloc/Peaks1G.png"), Permeability.BLOCKING, 6, x, y);
	}
}
