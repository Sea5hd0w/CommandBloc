package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.ISprite;
import commandbloc.game.level.element.Permeability;

public class ContinuousPressureSensor extends Sensor{
	
		public ContinuousPressureSensor(ISprite sprite, Permeability permeability, int fileSymbol, int x, int y) {
			super(sprite, permeability, fileSymbol, x, y);
		}
	}


