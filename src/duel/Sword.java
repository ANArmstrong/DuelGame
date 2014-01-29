package duel;

import org.newdawn.slick.geom.Line;

@SuppressWarnings("serial")
public class Sword extends Line {
	public static final int length= 70;
	private double angle;
	private Warrior owner;
	
	/** Constructor: Create a new sword with starting point at
	 * (x1,y1) and ending point at (x2, y2). */
	public Sword(Warrior owner) {
		super(owner.getX(), owner.getY(), owner.getX() + length, owner.getY());
		this.owner= owner;
		angle= 0;
	}

	/** Return the current angle of the sword. */
	public double getAngle() {
		return angle;
	}
	
	/** Set the angle of the sword. */
	public void setAngle(double a) {
		angle= a;
	}
	
	/** Set the start and end points of the line that represents this sword
	 * using the current sword angle and the body's position. */
	public void update() {
		this.set(owner.getX(), owner.getY(), owner.getX() + length*(float)Math.cos(angle),
				owner.getY() + length*(float)Math.sin(angle));
	}
}
