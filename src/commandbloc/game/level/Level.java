package commandbloc.game.level;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;

import commandbloc.game.level.element.Element;
import commandbloc.game.level.element.mobile.Hero;
import commandbloc.game.level.element.mobile.Mobile;
import commandbloc.game.level.element.motionLess.ContinuousPressureSensor1;
import commandbloc.game.level.element.motionLess.Lever1;
import commandbloc.game.level.element.motionLess.MotionLessElement;
import commandbloc.game.level.element.motionLess.MotionLessElements;
import commandbloc.game.level.element.motionLess.Peaks1;
import commandbloc.game.level.element.motionLess.Piston1;
import commandbloc.game.level.element.motionLess.Piston2;
import commandbloc.game.level.element.motionLess.PressureSensor1;
import commandbloc.game.level.element.motionLess.TNT1;

public class Level extends Observable implements ILevel {
	public MotionLessElement				elements[][];
	public final ArrayList<Mobile>	mobiles;
	private int											width;
	private int											height;
	private Hero										hero;

	private Level() {
		this.mobiles = new ArrayList<Mobile>();
	}

	public Level(final String fileName) throws IOException {
		this();
		this.loadFile(fileName);
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public MotionLessElement getElements(final int x, final int y) {
		if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())) {
			return null;
		}
		return this.elements[x][y];
	}

	@Override
	public Hero getHero() {
		return this.hero;
	}

	private void addElement(final MotionLessElement element, final int x, final int y) {
		this.elements[x][y] = element;
		if (element != null) {
			element.setLevel(this);
		}
		this.setChanged();
	}

	@Override
	public void addMobile(final Mobile mobile, final int x, final int y) {
		this.mobiles.add(mobile);
		mobile.setLevel(this, x, y);
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void addMobile(final Hero hero, final int x, final int y) {
		this.setHero(hero);
		this.addMobile((Mobile) hero, x, y);
	}

	private void loadFile(final String fileName) throws IOException {
		final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String line;
		int numLine = 0;
		line = buffer.readLine();
		this.width = Integer.parseInt(line);
		line = buffer.readLine();
		this.height = Integer.parseInt(line);
		this.elements = new MotionLessElement[this.getWidth()][this.getHeight()];
		while ((line = buffer.readLine()) != null) {
			for (int x = 0; x < line.toCharArray().length; x++) {
					this.addElement(MotionLessElements.getFromFileSymbol((int)line.toCharArray()[x]-48), x, numLine);
					System.out.println(this.getElements(x,numLine) + "\t\t élément créer en [" + x + "]:[" + numLine + "]");
			}
			numLine++;
		}
		buffer.close();
		this.setChanged();
		this.connectObject();
	}

	private void setHero(final Hero hero) {
		this.hero = hero;
		this.setChanged();
	}

	@Override
	public void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void notifyObservers() {
		super.notifyObservers();
	}

	@Override
	public Element[][] getElements() {
		return this.elements;
	}

	@Override
	public ArrayList<Mobile> getMobiles() {
		return this.mobiles;
	}

	public void connectObject(){
		for(int y = 0; y < this.height ; y++){
			for(int x =0; x < this.width ; x++){
				if(this.getElements(x, y).getConnector() == true){
					this.getElements(x, y).connectConnector(x, y);
				} else if(this.getElements(x, y).getSensor() == true){
					System.out.println(this.getElements(x, y).getClass().getSimpleName() + " : " + x + " || " + y );
					this.getElements(x, y).connectSensor(x, y);
				}
			}
		}
	}
}