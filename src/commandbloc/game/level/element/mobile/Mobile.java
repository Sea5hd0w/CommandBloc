package commandbloc.game.level.element.mobile;

import java.awt.Point;

import commandbloc.game.level.ILevel;
import commandbloc.game.level.element.Element;
import commandbloc.game.level.element.ISprite;
import commandbloc.game.level.element.Permeability;

public class Mobile extends Element implements IMobile {
	private final Point position;

	public Mobile(final ISprite sprite) {
		super(sprite, Permeability.BLOCKING);
		this.position = new Point();
	}

	@Override
	public int getX() {
		return this.position.x;
	}

	protected void setX(final int x) {
		if ((x >= 0) && (x < this.getLevel().getWidth())) {
			this.position.x = x;
			this.getLevel().setMobileHasChanged();
		}
	}

	@Override
	public int getY() {
		return this.position.y;
	}

	protected void setY(final int y) {
		if ((y >= 0) && (y < this.getLevel().getHeight())) {
			this.position.y = y;
			this.getLevel().setMobileHasChanged();
		}
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	public void setNettleWorld(final ILevel level, final int x, final int y) {
		super.setLevel(level);
		this.setX(x);
		this.setY(y);
	}

	private boolean isMovePossible(final int x, final int y) {
		return (this.getLevel().getElements(x, y).getPermeability() != Permeability.BLOCKING);
	}

	public void moveUp() {
		if (this.isMovePossible(this.getX(), this.getY() - 1)) {
			this.setY(this.getY() - 1);
		}
	}

	public void moveLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY())) {
			this.setX(this.getX() - 1);
		}
	}

	public void moveDown() {
		if (this.isMovePossible(this.getX(), this.getY() + 1)) {
			this.setY(this.getY() + 1);
		}
	}

	public void moveRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY())) {
			this.setX(this.getX() + 1);
		}
	}
}
