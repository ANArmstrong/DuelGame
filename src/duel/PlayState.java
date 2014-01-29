package duel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

/** An instance is a state in which the main action of the game takes place. */
public class PlayState extends BasicGameState implements GameState {
	/** The ID number corresponding to this state. */
	private int id;
	/** The collision detector for this state. */
	//private CollisionDetector collisionDetector;
	/** A warrior that corresponds to the first player. */
	private Warrior playerOne;

	/** Constructor: Creates a new PlayState with ID number id. */
	public PlayState(int id) {
		this.id= id;
		}

	/** Initialize this play state. */
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		playerOne= new Warrior(50,50);
	}

	/** Render the graphics of this state. */
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		playerOne.draw(g);
	}

	/** Update this state. */
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		Input input= container.getInput();
		playerOne.update(input, delta);
	}

	/** Return the ID number of this state. */
	@Override
	public int getID() {
		return id;
	}

}
