// Testing
package duel;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Circle;

public class Warrior {
	private static final float radius = 20;
	private static final float maxSwingSpeed = (float) .005;
	private Circle body;
	private Sword sword;
	private float xPos;
	private float yPos;
	
	/** Constructor: Create a new Warrior with body center at (x,y). */
	public Warrior(float x, float y){
		body = new Circle(x, y, radius);
		sword = new Sword(this);
		xPos = x;
		yPos = y;
		
	}
	
	/** Update the warrior for the new frame. */
	public void update(Input input, int delta){
		move(input, delta);
		updateSword(input, delta);
	}
	
	/** Update the sword for this warrior for the new frame. */
	private void updateSword(Input input, int delta) {
		float stickInputX= input.getAxisValue(0, 2);
		float stickInputY= input.getAxisValue(0, 3);
		if (Math.abs(stickInputX) + Math.abs(stickInputY) > 0) {
			double inputAngle= Math.atan2(stickInputY, stickInputX);
			double relAngle= relativeAngle(inputAngle, sword.getAngle());
			System.out.println("\ninputAngle: " + inputAngle + "\nswordAngle: " + sword.getAngle() + "\n");
			if (Math.abs(relAngle)/delta < maxSwingSpeed) {
				sword.setAngle(inputAngle);
			} else if (relAngle > 0) {
				sword.setAngle(sword.getAngle() + maxSwingSpeed*delta);
			} else {
				sword.setAngle(sword.getAngle() - maxSwingSpeed*delta);
			}
		}
		sword.update();
	}
	
	/** calculate the relative angle between the input angle and the current 
	 * sword angle. The relative must be less than pi radians and is positive
	 * if the input angle is clockwise ahead of the current sword angle.
	 * (On the screen positive angles are clockwise instead of counterclockwise
	 * since the positive y-axis is downward.)
	 * @param inputAngle
	 * @param angle
	 * @return
	 */
	private double relativeAngle(double inputAngle, double angle) {
		double deltaTheta= inputAngle - angle;
		if (Math.abs(deltaTheta) <= Math.PI) {
			return deltaTheta;
		} else if (deltaTheta > Math.PI) {
			return deltaTheta - 2*Math.PI;
		} else {
			return deltaTheta + 2*Math.PI;
		}
	}
	
	/** Update the warrior's body's position according to the controller
	 * input.
	 * @param input
	 * @param delta
	 */
	private void move(Input input, int delta) {
		xPos += 0.35f * input.getAxisValue(0, 0) * delta;
		yPos += 0.35f * input.getAxisValue(0, 1) * delta;
		body.setX(xPos);
		body.setY(yPos);		
	}
	
	/** Draw the warrior's body and sword to the screen. */
	public void draw(Graphics g){
		g.fill(body);
		g.draw(sword);
	}
	
	/** Return the x-position of the center of the warrior's body. */
	public float getX() {
		return body.getCenterX();
	}
	
	/** Return the y-position of the center of the warrior's body. */
	public float getY() {
		return body.getCenterY();
	}

}
