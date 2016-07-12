package commandbloc.game.level.element;

import java.awt.Image;

import commandbloc.game.level.ILevel;

public abstract class Element {
	private ISprite				sprite;
	private Permeability	permeability;
	private ILevel	level;

	public Element(final ISprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	public ISprite getSprite() {
		return this.sprite;
	}

	protected void setSprite(final ISprite sprite) {
		this.sprite = sprite;
	}

	public Permeability getPermeability() {
		return this.permeability;
	}

	private void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	protected ILevel getLevel() {
		return this.level;
	}

	public void setLevel(final ILevel level) {
		this.level = level;
	}

	public Image getImage() {
		return this.getSprite().getSprite();
	}
	
	protected void openCloseSprite(boolean openclose){
		this.getSprite().changeSprite(openclose);
	}
}
