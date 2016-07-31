package commandbloc.game.level;

import java.util.ArrayList;
import java.util.Observer;

import commandbloc.game.level.element.Element;
import commandbloc.game.level.element.mobile.Hero;
import commandbloc.game.level.element.mobile.Mobile;
import commandbloc.game.level.element.motionLess.MotionLessElement;

public interface ILevel {
	
	public int getWidth();

	public int getHeight();

	public MotionLessElement getElements(int x, int y);

	public Hero getHero();

	public void addMobile(Mobile mobile, int x, int y);

	public void addMobile(Hero hero, int x, int y);

	public void setMobileHasChanged();

	public Element[][] getElements();

	public ArrayList<Mobile> getMobiles();

	public void addObserver(Observer o);
	
	public void addElement(final MotionLessElement element, final int x, final int y);
}
