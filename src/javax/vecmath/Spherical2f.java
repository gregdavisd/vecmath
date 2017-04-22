/*
 * Copyright Gregery Barton
 * All rights reserved
 */
package javax.vecmath;

/**
 * A spherical coordinate specified with 2 numbers. x=heading, and y=incline. The length is omitted and assumed be 1.
 *
 * @author Gregery Barton
 */
public class Spherical2f extends Tuple2f {

	static final long serialVersionUID = 1L;
	private static final float TWO_PI = 2.0f * (float) Math.PI;

	/**
	 * Construct a Polar2f object
	 *
	 * @param heading the heading in radians
	 * @param incline the incline in radians
	 */
	public Spherical2f(float heading, float incline) {
		super(heading, incline);
	}

	/**
	 * Construct a Spherical2f object from an array
	 *
	 * @param t heading (x) is t[0], incline (y) is t[1]
	 */
	public Spherical2f(float[] t) {
		super(t);
	}

	/**
	 * Construct a Spherical2f by copying the angles
	 *
	 * @param t1 x,y to copy from
	 */
	public Spherical2f(Tuple2f t1) {
		super(t1);
	}

	/**
	 * Constructs a Spherical2f with heading=0, incline=0
	 */
	public Spherical2f() {
	}

	/**
	 * Convert this normalized spherical coordinate into a vector with length and store the result in t1. Uses a y-up coordinate
	 * system.
	 *
	 * @param length the length to give the new vector
	 * @param t1 the tuple3f where the results are stored.
	 * @return
	 */
	public final Tuple3f yup_get(float length, Tuple3f t1) {
		float cx = (float) Math.cos(x);
		float sx = (float) Math.sin(x);
		float cy = (float) Math.cos(y);
		float sy = (float) Math.sin(y);
		t1.x = length * cy * cx;
		t1.y = length * sy;
		t1.z = length * -sx * cy;
		return t1;
	}

	/**
	 * Set this Spherical2f with the angles calculated by the direction from the arigin to t1. Uses a y-up coordinate system.
	 *
	 * @param t1 x,y,z of the reference point
	 * @return
	 */
	public final Spherical2f yup_set(Tuple3f t1) {
		float length = new Vector3f(t1).length();
		x = (float) Math.atan2(-t1.z, t1.x);
		y = (float) Math.asin(t1.y / length);
		return this;
	}

	/**
	 * Calculates a rotation matrix that will transform a point to the direction of this spherical coordinate and stores the result
	 * in m1
	 *
	 * @param m1 matrix to store the rotation in
	 * @return m1 for chaining
	 */
	public final Matrix3f yup_get(Matrix3f m1) {
		return m1.rotY(x).mul(new Matrix3f().rotZ(y));
	}

	/**
	 * Changes both x and y angles to be between -pi and pi
	 *
	 * @return this for chaining
	 */
	public final Spherical2f bound() {
		x = x % TWO_PI;
		y = y % TWO_PI;
		return this;
	}

}
