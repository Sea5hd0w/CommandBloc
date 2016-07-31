package commandbloc.game.level.element.motionLess;

import java.util.ArrayList;

import commandbloc.game.level.element.Element;
import commandbloc.game.level.element.ISprite;
import commandbloc.game.level.element.Permeability;

public abstract class MotionLessElement extends Element{
	private int x;
	private int y;
	private final int fileSymbol;
	private boolean onoff;
	public ArrayList<MotionLessElement> linksobject;
	private boolean sensor;
	private boolean actuator;
	private boolean connector;
	private Orientation orientation;
	
	public MotionLessElement(final ISprite sprite, final Permeability permeability, final int fileSymbol, boolean sensor, boolean actuator, boolean connector, int x, int y) {
		super(sprite, permeability);
		this.linksobject = new ArrayList<MotionLessElement>();
		this.fileSymbol = fileSymbol;
		this.onoff = false;
		this.sensor = sensor;
		this.actuator = actuator;
		this.connector = connector;
		this.setOrientation(Orientation.UP);
		this.setX(x);
		this.setY(y);
	}

	public int getFileSymbol() {
		return this.fileSymbol;
	}
	
	public boolean getOnOff(){
		return this.onoff;
	}
	
	protected void setOnOff(boolean onoff){
		this.onoff = onoff;
	}
	
	public boolean getSensor(){
		return this.sensor;
	}
	
	public boolean getActuator(){
		return this.actuator;
	}
	
	public boolean getConnector(){
		return this.connector;
	}
	
	protected void setSensor(boolean sensor){
		this.sensor = sensor;
	}
	
	protected void setActuator(boolean actuator){
		this.actuator = actuator;
	}
	
	protected void setConnector(boolean connector){
		this.connector = connector;
	}
	
	public void addLinkedObject(MotionLessElement motionlesselement){
		this.linksobject.add(motionlesselement);
	}
	
	public void connectConnector(int x, int y){
		if(this.fileSymbol == 49){
			if(y-1 >= 0){
				this.addLinkedObject(x, y-1);
			}
			if(y+1 <= this.getLevel().getHeight()-1){
				this.addLinkedObject(x, y+1);
			}
			if(x-1 >= 0){
				this.addLinkedObject(x-1, y);
			}
			if(x+1 <= this.getLevel().getWidth()-1){
				this.addLinkedObject(x+1, y);
			}
		} else if(this.fileSymbol == 50){
			if(y-1 >= 0){
				this.addLinkedObject(x, y-1);
			}
			if(x+1 <= this.getLevel().getWidth()-1){
				this.addLinkedObject(x+1, y);
			}
		} else if(this.fileSymbol == 51){
			if(y+1 <= this.getLevel().getHeight()-1){
				this.addLinkedObject(x, y+1);
			}
			if(x+1 <= this.getLevel().getWidth()-1){
				this.addLinkedObject(x+1, y);
			}
		} else if(this.fileSymbol == 52){
			if(y+1 <= this.getLevel().getHeight()-1){
				this.addLinkedObject(x, y+1);
			}
			if(x-1 >= 0){
				this.addLinkedObject(x-1, y);
			}
		} else if(this.fileSymbol == 53){
			if(y-1 >= 0){
				this.addLinkedObject(x, y-1);
			}
			if(x-1 >= 0){
				this.addLinkedObject(x-1, y);
			}
		} else if(this.fileSymbol == 54){
			if(y-1 >= 0){
				this.addLinkedObject(x, y-1);
			}
			if(x-1 >= 0){
				this.addLinkedObject(x-1, y);
			}
			if(x+1 <= this.getLevel().getWidth()-1){
				this.addLinkedObject(x+1, y);
			}
		} else if(this.fileSymbol == 55){
			if(x+1 <= this.getLevel().getWidth()-1){
				this.addLinkedObject(x+1, y);
			}
			if(y-1 >= 0){
				this.addLinkedObject(x, y-1);
			}
			if(y+1 <= this.getLevel().getHeight()-1){
				this.addLinkedObject(x, y+1);
			}
		} else if(this.fileSymbol == 56){
			if(y+1 <= this.getLevel().getHeight()-1){
				this.addLinkedObject(x, y+1);
			}
			if(x-1 >= 0){
				this.addLinkedObject(x-1, y);
			}
			if(x+1 <= this.getLevel().getWidth()-1){
				this.addLinkedObject(x+1, y);
			}
		} else if(this.fileSymbol == 57){
			if(x-1 >= 0){
				this.addLinkedObject(x-1, y);
			}
			if(y-1 >= 0){
				this.addLinkedObject(x, y-1);
			}
			if(y+1 <= this.getLevel().getHeight()-1){
				this.addLinkedObject(x, y+1);
			}
		} else if(this.fileSymbol == 58){
			if(y-1 >= 0){
				this.addLinkedObject(x, y-1);
			}
			if(y+1 <= this.getLevel().getHeight()-1){
				this.addLinkedObject(x, y+1);
			}
		} else if(this.fileSymbol == 59){
			if(x-1 >= 0){
				this.addLinkedObject(x-1, y);
			}
			if(x+1 <= this.getLevel().getWidth()-1){
				this.addLinkedObject(x+1, y);
			}
		}
	}

	public void connectSensor(int x, int y){
		if(this.getLevel().getElements(x+1, y).getConnector() == true || this.getLevel().getElements(x+1, y).getActuator() == true){
			this.addLinkedObject(x+1, y);
		}
		if(this.getLevel().getElements(x-1, y).getConnector() == true || this.getLevel().getElements(x-1, y).getActuator() == true){
			this.addLinkedObject(x-1, y);
		}
		if(this.getLevel().getElements(x, y-1).getConnector() == true || this.getLevel().getElements(x, y-1).getActuator() == true){
			this.addLinkedObject(x, y-1);
		}
		if(this.getLevel().getElements(x, y+1).getConnector() == true || this.getLevel().getElements(x, y+1).getActuator() == true){
			this.addLinkedObject(x, y+1);
		}
	}
	
	public void addLinkedObject(int x, int y){
		this.addLinkedObject(this.getLevel().getElements(x, y));
	}
	
	public void openCloseLinkedObject(boolean openclose){
		for (MotionLessElement s : this.linksobject) {
			if(s.getOnOff() != openclose){
				s.openclose(openclose);
			}
		}
	}

	public void openclose(boolean openclose, int x, int y){
		this.getLevel().getElements(x, y).openclose(openclose);
	}

	public void openclose(boolean openclose){
		System.out.println("J'ouvre/Je ferme");
		this.setOnOff(openclose);
		this.openCloseSprite(openclose);
		this.getLevel().setMobileHasChanged();
		this.openCloseLinkedObject(openclose);
	}

	public Orientation getOrientation() {
		return orientation;
	}

	protected void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}