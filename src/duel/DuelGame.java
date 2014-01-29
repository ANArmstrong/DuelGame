package duel;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class DuelGame extends StateBasedGame {
	
	/** The name of this game. */
	private static String gameName= "Duel";
	/** The ID number of the menu state. */
	private static int menu= 0;
	/** The ID number of the play state. */
	private static int play= 1;

	/** Game of Duel. */
	public DuelGame(String gn) {
		super(gn);
		this.addState(new MenuState(menu));
		this.addState(new PlayState(play));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AppGameContainer appGC= new AppGameContainer(new DuelGame(gameName));
			appGC.setDisplayMode(700, 500, false);
			appGC.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.enterState(menu);
	}

}
