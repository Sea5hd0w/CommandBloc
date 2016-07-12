package commandbloc.game.view;

import java.awt.event.KeyEvent;

import commandbloc.game.play.UserOrder;

public abstract class LevelView {
	
	public static UserOrder keyCodeToUserOrder(final int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			return UserOrder.UP;
		case KeyEvent.VK_RIGHT:
			return UserOrder.RIGHT;
		case KeyEvent.VK_DOWN:
			return UserOrder.DOWN;
		case KeyEvent.VK_LEFT:
			return UserOrder.LEFT;
		default:
			return UserOrder.NOP;
		}
	}
}
