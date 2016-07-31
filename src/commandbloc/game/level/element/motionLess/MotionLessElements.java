package commandbloc.game.level.element.motionLess;

public abstract class MotionLessElements {
	public static final MotionLessElement	BLOCT									= new BlocT(0,0);
	public static final MotionLessElement	BLOCB									= new BlocB(0,0);
	public static final MotionLessElement	FINISH1									= new Finish1(0,0);


	private static MotionLessElement			motionlessElements[]	= { BLOCT, BLOCB, FINISH1 };

	public static MotionLessElement getFromFileSymbol(final int fileSymbol, int x, int y) {
		for (final MotionLessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getFileSymbol() == fileSymbol) {
				return motionlessElement;
			} else {
				switch(fileSymbol) {
				case 3 :
					return new Lever1(x,y);
				case 4 :
					return new PressureSensor1(x,y);
				case 5 :
					return new ContinuousPressureSensor1(x,y);
				case 6 :
					return new Peaks1(x,y);
				case 7 :
					return new Piston1(x,y);
				case 8 :
					return new Piston2(x,y);
				case 9 :
					return new TNT1(x,y, 0);
				case 49 :
					return new Cross(x,y);
				case 50 :
					return new UpRight(x,y);
				case 51 :
					return new DownRight(x,y);
				case 52 :
					return new DownLeft(x,y);
				case 53 :
					return new UpLeft(x,y);
				case 54 :
					return new Up(x,y);
				case 55 :
					return new Right(x,y);
				case 56 :
					return new Down(x,y);
				case 57 :
					return new Left(x,y);
				case 58 :
					return new Vertical(x,y);
				case 59 :
					return new Horizontal(x,y);
				case 74 :
					return new Wait1(x,y, 5);
				default :
					return BLOCT;
				}
			}
		}
		return null;
	}
}