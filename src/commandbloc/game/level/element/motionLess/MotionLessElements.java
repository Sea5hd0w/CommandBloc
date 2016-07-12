package commandbloc.game.level.element.motionLess;

public abstract class MotionLessElements {
	public static final MotionLessElement	BLOCKT									= new BlocT();
	public static final MotionLessElement	BLOCKB									= new BlocB();
	public static final MotionLessElement	FINISH1									= new Finish1();


	private static MotionLessElement			motionlessElements[]	= { BLOCKT, BLOCKB, FINISH1 };

	public static MotionLessElement getFromFileSymbol(final int fileSymbol) {
		for (final MotionLessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getFileSymbol() == fileSymbol) {
				return motionlessElement;
			} else {
				switch(fileSymbol) {
				case 3 :
					return new Lever1();
				case 4 :
					return new PressureSensor1();
				case 5 :
					return new ContinuousPressureSensor1();
				case 6 :
					return new Peaks1();
				case 7 :
					return new Piston1();
				case 8 :
					return new Piston2();
				case 9 :
					return new TNT1();
				case 49 :
					return new Cross();
				case 50 :
					return new UpRight();
				case 51 :
					return new DownRight();
				case 52 :
					return new DownLeft();
				case 53 :
					return new UpLeft();
				case 54 :
					return new Up();
				case 55 :
					return new Right();
				case 56 :
					return new Down();
				case 57 :
					return new Left();
				case 58 :
					return new Vertical();
				case 59 :
					return new Horizontal();
				}
			}
		}
		return null;
	}
}