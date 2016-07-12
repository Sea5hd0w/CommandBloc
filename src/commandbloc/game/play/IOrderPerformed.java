package commandbloc.game.play;

import java.io.IOException;

public interface IOrderPerformed {
	public void orderPerform(UserOrder userOrder) throws IOException;
}
