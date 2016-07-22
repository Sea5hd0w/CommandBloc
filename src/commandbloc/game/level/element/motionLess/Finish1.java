package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.view.LevelFrame;

public class Finish1 extends Sensor {

	public Finish1() {
		super(new Sprite("Bloc/Finish1R.png", "Bloc/Finish1G.png"), Permeability.BLOCKING, 2);
	}
	
	@Override
	public void openclose(boolean openclose){
		super.openclose(openclose);
		LevelFrame.win();
	}

}
