package duel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

/** An instance is the state with the main menu for the game. */
public class MenuState extends BasicGameState implements GameState {
	/** The ID number corresponding to this state. */
	private int id;

	public MenuState(int id) {
		this.id= id;
	}

	/** Initialize the menu state. */
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
	}

	/** Render the graphics of the menu state. */
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawString("Press spacebar \n   to play", 280, 100);
	}

	/** Update the menu state. */
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		Input input= container.getInput();
		if (input.isKeyDown(Input.KEY_SPACE)) {
			game.enterState(1);
		}
	}

	/** Return the ID number that represents the menu state. */
	@Override
	public int getID() {
		return id;
	}

}

