package commandbloc;

import java.io.IOException;
import java.sql.SQLException;

import commandbloc.game.Game;
import commandbloc.game.level.Level;

public class mainGame {

	public static void main(String[] args) throws IOException {
		try {
			Game game = new Game();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
