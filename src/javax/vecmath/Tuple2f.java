/*
 * $RCSfile: Tuple2f.java,v $
 *
 * Copyright 1997-2008 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 *
 * $Revision: 1.8 $
 * $Date: 2008/02/28 20:18:51 $
 * $State: Exp $
 */
package javax.vecmath;

import static javax.vecmath.VecMath.acos;
import static javax.vecmath.VecMath.different_epsilon;
import static javax.vecmath.VecMath.sqrt;

/**
 * A generic 2-element tuple that is represented by single-precision floating point x,y coordinates.
 *
 * @param <T>
 */
public abstract class Tuple2f<T extends Tuple2f> implements java.io.Serializable, Cloneable {

	static final long serialVersionUID = 9011180388985266884L;

	/**
	 * The x coordinate.
	 */
	public float x;

	/**
	 * The y coordinate.
	 */
	public float y;

	/**
	 * Constructs and initializes a Tuple2f from the specified xy coordinates.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public Tuple2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructs and initializes a Tuple2f from the specified array.
	 *
	 * @param t the array of length 2 containing xy in order
	 */
	public Tuple2f(float[] t) {
		x = t[0];
		y = t[1];
	}

	/**
	 * Constructs and initializes a Tuple2f from the specified Tuple2f.
	 *
	 * @param t1 the Tuple2f containing the initialization x y data
	 */
	public Tuple2f(Tuple2f t1) {
		x = t1.x;
		y = t1.y;
	}

	/**
	 * Constructs and initializes a Tuple2f to (0,0).
	 */
	public Tuple2f() {

	}

	/**
	 * Sets the value of this tuple to the specified xy coordinates.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return this for chaining
	 */
	public  T set(float x, float y) {
		this.x = x;
		this.y = y;
		return (T) this;
	}

	/**
	 * Sets the value of this tuple from the 2 values specified in the array.
	 *
	 * @param t the array of length 2 containing xy in order
	 * @return this for chaining
	 */
	public  T set(float[] t) {
		x = t[0];
		y = t[1];
		return (T) this;
	}

	/**
	 * Sets the value of this tuple from the 2 values specified in the array.
	 *
	 * @param t the array of length 2 containing xy in order
	 * @return this for chaining
	 */
	public  T set(double[] t) {
		x = (float) t[0];
		y = (float) t[1];
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the value of the Tuple2f argument.
	 *
	 * @param t1 the tuple to be copied
	 * @return this for chaining
	 */
	public  T set(Tuple2f t1) {
		x = t1.x;
		y = t1.y;
		return (T) this;
	}

	/**
	 * Copies the value of the elements of this tuple into the array t.
	 *
	 * @param t the array that will contain the values of the vector
	 * @return t for chaining
	 */
	public float[] get(float[] t) {
		t[0] = x;
		t[1] = y;
		return t;
	}

	/**
	 * Gets the value of this tuple and copies the values into t.
	 *
	 * @param t the Tuple2f object into which the values of this object are copied
	 * @return t for chaining
	 */
	public  T get(T t) {
		t.x = x;
		t.y = y;
		return t;
	}

	/**
	 * Get an element of this tuple by index
	 *
	 * @param i 0 for x, 1 for y
	 * @return
	 */
	public float getElement(int i) {
		switch (i) {
			case 0:
				return x;
			case 1:
				return y;
			default:
				throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Sets the value of this tuple to the vector sum of tuples t1 and t2.
	 *
	 * @param t1 the first tuple
	 * @param t2 the second tuple
	 * @return this for chaining
	 */
	public  T add(Tuple2f t1, Tuple2f t2) {

		x = t1.x + t2.x;
		y = t1.y + t2.y;

		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the vector sum of itself and tuple t1.
	 *
	 * @param t1 the other tuple
	 * @return this for chaining
	 */
	public  T add(Tuple2f t1) {
		x += t1.x;
		y += t1.y;
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the vector sum of itself and (dx,dy).
	 *
	 * @param dx
	 * @param dy
	 * @return this for chaining
	 */
	public  T add(float dx, float dy) {
		x += dx;
		y += dy;
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the vector difference of tuple t1 and t2 (this = t1 - t2).
	 *
	 * @param t1 the first tuple
	 * @param t2 the second tuple
	 * @return this for chaining
	 */
	public  T sub(Tuple2f t1, Tuple2f t2) {
		x = t1.x - t2.x;
		y = t1.y - t2.y;
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the vector difference of itself and tuple t1 (this = this - t1).
	 *
	 * @param t1 the other tuple
	 * @return this for chaining
	 */
	public  T sub(Tuple2f t1) {
		x -= t1.x;
		y -= t1.y;
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the negation of tuple t1.
	 *
	 * @param t1 the source tuple
	 * @return this for chaining
	 */
	public  T negate(Tuple2f t1) {
		x = -t1.x;
		y = -t1.y;
		return (T) this;
	}

	/**
	 * Negates the value of this vector in place.
	 *
	 * @return this for chaining
	 */
	public  T negate() {
		x = -x;
		y = -y;
		return (T) this;
	}

	/**
	 * Multiply each component of t1 with t2 and store the result in this tuple
	 *
	 * @param t1 the source tuple
	 * @return this for chaining
	 */
	public  T mul(Tuple2f t1) {

		x *= t1.x;
		y *= t1.y;

		return (T) this;
	}

	/**
	 * Multiply each component of t1 with t2 and store the result in this tuple
	 *
	 * @param t1 left operand
	 * @param t2 right operand
	 * @return this for chaining
	 */
	public  T mul(Tuple2f t1, Tuple2f t2) {

		x = t1.x * t2.x;
		y = t1.y * t2.y;

		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the scalar multiplication of itself.
	 *
	 * @param s the scalar value
	 * @return this for chaining
	 */
	public  T scale(float s) {

		x *= s;
		y *= s;

		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the scalar multiplication of tuple t1 and then adds tuple t2 (this = s*t1 + t2).
	 *
	 * @param s the scalar value
	 * @param t1 the tuple to be multipled
	 * @param t2 the tuple to be added
	 * @return this for chaining
	 */
	public  T scaleAdd(float s, Tuple2f t1, Tuple2f t2) {

		x = s * t1.x + t2.x;
		y = s * t1.y + t2.y;

		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the scalar multiplication of itself and then adds tuple t1 (this = s*this + t1).
	 *
	 * @param s the scalar value
	 * @param t1 the tuple to be added
	 * @return this for chaining
	 */
	public  T scaleAdd(float s, Tuple2f t1) {

		x = s * x + t1.x;
		x = s * x + t1.x;
		y = s * y + t1.y;

		return (T) this;
	}

	/**
	 * Returns true if all of the data members of Tuple2f t1 are equal to the corresponding data members in this Tuple2f.
	 *
	 * @param t1 the vector with which the comparison is made
	 * @return true or false
	 */
	public boolean equals(Tuple2f t1) {
		return (x == t1.x && y == t1.y);
	}

	/**
	 * Returns true if the Object t1 is of type Tuple2f and all of the data members of t1 are equal to the corresponding data members
	 * in this Tuple2f.
	 *
	 * @param t1 the object with which the comparison is made
	 * @return true or false
	 */
	@Override
	public boolean equals(Object t1) {
		try {
			Tuple2f t2 = (Tuple2f) t1;
			return (x == t2.x && y == t2.y);
		} catch (NullPointerException | ClassCastException e2) {
			return false;
		}

	}

	/**
	 * Returns true if the L-infinite distance between this tuple and tuple t1 is less than or equal to the epsilon parameter,
	 * otherwise returns false. The L-infinite distance is equal to MAX[abs(x1-x2), abs(y1-y2)].
	 *
	 * @param t1 the tuple to be compared to this tuple
	 * @param epsilon the threshold value
	 * @return true or false
	 */
	public boolean epsilonEquals(Tuple2f t1, float epsilon) {
		if (different_epsilon(x, t1.x, epsilon)) {
			return false;
		}
		return !different_epsilon(y, t1.y, epsilon);
	}

	/**
	 * Returns a string that contains the values of this Tuple2f. The form is (x,y).
	 *
	 * @return the String representation
	 */
	@Override
	public String toString() {
		return ("(" + x + ", " + y + ")");
	}

	/**
	 * Clamps the tuple parameter to the range [low, high] and places the values into this tuple.
	 *
	 * @param min the lowest value in the tuple after clamping
	 * @param max the highest value in the tuple after clamping
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public  T clamp(float min, float max, Tuple2f t) {
		x = Math.min(max, Math.max(min, t.x));
		y = Math.min(max, Math.max(min, t.y));
		return (T) this;
	}

	/**
	 * Clamps the minimum value of the tuple parameter to the min parameter and places the values into this tuple.
	 *
	 * @param min the lowest value in the tuple after clamping
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public  T clampMin(float min, Tuple2f t) {
		x = Math.max(min, t.x);
		y = Math.max(min, t.y);
		return (T) this;
	}

	/**
	 * Clamps the maximum value of the tuple parameter to the max parameter and places the values into this tuple.
	 *
	 * @param max the highest value in the tuple after clamping
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public  T clampMax(float max, Tuple2f t) {
		x = Math.min(max, t.x);
		y = Math.min(max, t.y);
		return (T) this;
	}

	/**
	 * Sets each component of the tuple parameter to its absolute value and places the modified values into this tuple.
	 *
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public  T absolute(Tuple2f t) {
		x = Math.abs(t.x);
		y = Math.abs(t.y);
		return (T) this;
	}

	/**
	 * Clamps this tuple to the range [low, high].
	 *
	 * @param min the lowest value in this tuple after clamping
	 * @param max the highest value in this tuple after clamping
	 * @return this for chaining
	 */
	public  T clamp(float min, float max) {
		x = Math.min(max, Math.min(max, x));
		y = Math.min(max, Math.min(max, y));
		return (T) this;
	}

	/**
	 * Clamps the minimum value of this tuple to the min parameter.
	 *
	 * @param min the lowest value in this tuple after clamping
	 * @return this for chaining
	 */
	public  T clampMin(float min) {
		x = Math.max(min, x);
		y = Math.max(min, y);
		return (T) this;
	}

	/**
	 * Clamps the maximum value of this tuple to the max parameter.
	 *
	 * @param max the highest value in the tuple after clamping
	 * @return this for chaining
	 */
	public  T clampMax(float max) {
		x = Math.min(max, x);
		y = Math.min(max, y);
		return (T) this;
	}

	/**
	 * Sets each component of this tuple to its absolute value.
	 *
	 * @return this for chaining
	 */
	public  T absolute() {
		x = Math.abs(x);
		y = Math.abs(y);
		return (T) this;
	}

	/**
	 * Linearly interpolates between tuples t1 and t2 and places the result into this tuple: this = (1-alpha)*t1 + alpha*t2.
	 *
	 * @param t1 the first tuple
	 * @param t2 the second tuple
	 * @param alpha the alpha interpolation parameter
	 * @return this for chaining
	 */
	public  T mix(Tuple2f t1, Tuple2f t2, float alpha) {

		x = (1 - alpha) * t1.x + alpha * t2.x;
		y = (1 - alpha) * t1.y + alpha * t2.y;

		return (T) this;
	}

	/**
	 * Linearly interpolates between tuples this and t1 and places the result into this tuple: this = (1-alpha)*this + alpha*t1.
	 *
	 * @param t1 the first tuple
	 * @param alpha the alpha interpolation parameter
	 * @return this for chaining
	 */
	public  T mix(Tuple2f t1, float alpha) {

		x = (1 - alpha) * x + alpha * t1.x;
		y = (1 - alpha) * y + alpha * t1.y;

		return (T) this;
	}

	/**
	 * Creates a new object of the same class as this object.
	 *
	 * @return a clone of this instance.
	 * @exception OutOfMemoryError if there is not enough memory.
	 * @see java.lang.Cloneable
	 * @since vecmath 1.3
	 */
	@Override
	public Object clone() {
		// Since there are no arrays we can just use Object.clone()
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new InternalError();
		}
	}

	/**
	 * Get the <i>x</i> coordinate.
	 *
	 * @return the <i>x</i> coordinate.
	 *
	 * @since vecmath 1.5
	 */
	public float getX() {
		return x;
	}

	/**
	 * Set the <i>x</i> coordinate.
	 *
	 * @param x value to <i>x</i> coordinate.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public  T setX(float x) {
		this.x = x;
		return (T) this;
	}

	/**
	 * Get the <i>y</i> coordinate.
	 *
	 * @return the <i>y</i> coordinate.
	 *
	 * @since vecmath 1.5
	 */
	public float getY() {
		return y;
	}

	/**
	 * Set the <i>y</i> coordinate.
	 *
	 * @param y value to <i>y</i> coordinate.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public  T setY(float y) {
		this.y = y;
		return (T) this;
	}

	/**
	 * Set both x and y of this vector to zero
	 *
	 * @return this for chaining
	 */
	public  T setZero() {
		x = 0.0f;
		y = 0.0f;
		return (T) this;
	}

	/**
	 * Set each element to the minimum of this or another tuple
	 *
	 * @param t1
	 * @return this for chaining
	 */
	public  T setMin(Tuple2f t1) {
		x = Math.min(x, t1.x);
		y = Math.min(y, t1.y);
		return (T) this;
	}

	/**
	 * Set each element to the minimum of of two tuples
	 *
	 * @param t1
	 * @param t2
	 * @return this for chaining
	 */
	public  T setMin(Tuple2f t1, Tuple2f t2) {
		x = Math.min(t2.x, t1.x);
		y = Math.min(t2.y, t1.y);
		return (T) this;
	}

	/**
	 * Set each element to the maximum of this or another tuple
	 *
	 * @param t1
	 * @return this for chaining
	 */
	public  T setMax(Tuple2f t1) {
		x = Math.max(x, t1.x);
		y = Math.max(y, t1.y);
		return (T) this;
	}

	/**
	 * Set each element to the maximum of of two tuples
	 *
	 * @param t1
	 * @param t2
	 * @return this for chaining
	 */
	public  T setMax(Tuple2f t1, Tuple2f t2) {
		x = Math.max(t2.x, t1.x);
		y = Math.max(t2.y, t1.y);
		return (T) this;
	}

	/**
	 * Computes the dot product of the this vector and vector v1.
	 *
	 * @param v1 the other vector
	 * @return 
	 */
	public float dot(Tuple2f v1) {

		return x * v1.x + y * v1.y;

	}

	/**
	 * Returns the length of this vector.
	 *
	 * @return the length of this vector
	 */
	public float length() {

		return sqrt(lengthSquared());

	}

	/**
	 * Returns the squared length of this vector.
	 *
	 * @return the squared length of this vector
	 */
	public float lengthSquared() {
		return (x * x + y * y);
	}

	/**
	 * Normalizes this vector in place.
	 *
	 * @return
	 */
	public  T normalize() {

		float norm;
		norm = (1.0f / length());
		if (Float.isInfinite(norm)) {
			return (T) this;
		}
		scale(norm);

		return (T) this;
	}

	/**
	 * Sets the value of this vector to the normalization of vector v1.
	 *
	 * @param v1 the un-normalized vector
	 * @return this for chaining
	 */
	public  T normalize(Vector2f v1) {
		set(v1);
		normalize();
		return (T) this;
	}

	/**
	 * Rotate the vector 90 degrees clockwise, scale and store in this vector
	 *
	 * @param s the amount to scale by
	 * @return
	 */
	public  T setLeftPerpendicular(float s) {
		set(s * y, s * -x);
		return (T) this;
	}

	/**
	 * Rotate the vector 90 degrees counter-clockwise, scale and store in this vector
	 *
	 * @param s the amount to scale by
	 * @return
	 */
	public  T setRightPerpendicular(float s) {
		set(s * -y, s * x);
		return (T) this;
	}

	/**
	 * Calculate the cross product of this vector and another. In two dimensions the cross product is the same as the determinant.
	 *
	 * @param v1
	 * @return
	 */
	public float cross(Tuple2f v1) {
		return x * v1.y - y * v1.x;
	}

	/**
	 * Returns a hash code value based on the data values in this object. Two different Tuple2f objects with identical data values
	 * (i.e., Tuple2f.equals returns true) will return the same hash code value. Two objects with different data members may return
	 * the same hash value, although this is not likely.
	 *
	 * @return the integer hash code value
	 */
	@Override
	public int hashCode() {
		int hash = 5;
		hash = 97 * hash + Float.floatToIntBits(x);
		hash = 97 * hash + Float.floatToIntBits(y);
		return hash;
	}

	/**
	 * Calculate the distance squared between this tuple and the argument
	 *
	 * @param t1
	 * @return
	 */
	public float distanceSquared(Tuple2f t1) {

		float dx = t1.x - x;
		float dy = t1.y - y;
		return (dx * dx + dy * dy);

	}

	/**
	 * Calculate the distance between this tuple and the argument
	 *
	 * @param t1
	 * @return
	 */
	public float distance(Tuple2f t1) {

		return sqrt(distanceSquared(t1));

	}

	/**
	 * Clamp the components of tuple t to between min and max, store the result in this tuple.
	 *
	 * @param min tuple with the minimum component values
	 * @param max tuplie with the maximum component values
	 * @param t the initial values
	 * @return this for chaining
	 */
	public  T clamp(Tuple2f min, Tuple2f max, Tuple2f t) {
		x = Math.min(max.x, Math.max(min.x, t.x));
		y = Math.min(max.y, Math.max(min.y, t.y));
		return (T) this;
	}

	/**
	 * Promote this single precision tuple to a double precision single row matrix
	 *
	 * @return
	 */
	public Matrix promote() {
		return new Matrix(new double[][]{{x, y}});
	}

	/**
	 * Returns the angle in radians between this vector and the vector parameter; the return value is constrained to the range
	 * [0,PI].
	 *
	 * @param v1 the other vector
	 * @return the angle in radians in the range [0,PI]
	 */
	public float angle(Tuple2f v1) {

		float vDot = dot(v1) / (length() * v1.length());
		if (vDot < -1.0f) {
			vDot = -1.0f;
		}
		if (vDot > 1.0f) {
			vDot = 1.0f;
		}
		return acos(vDot);

	}

	/**
	 * Set an element of this tuple
	 *
	 * @param i 0 for x, 1 for y
	 * @param value the new value
	 * @return this for chaining
	 */
	public  T setElement(int i, float value) {
		switch (i) {
			case 0:
				x = value;
				break;
			case 1:
				y = value;
				break;
			default:
				throw new IndexOutOfBoundsException();
		}
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the inverse of itself. Equal to 1/(t dot t)
	 *
	 * @return this for chaining
	 */
	public final  T inverse() {
		float norm;

		norm = 1.0f / lengthSquared();
		scale(norm);
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the inverse of q1. Equal to 1/(t dot t)
	 *
	 * @param q1 the quaternion to be inverted
	 * @return this for chaining
	 */
	public final  T inverse(Tuple2f q1) {
		set(q1);
		inverse();
		return (T) this;
	}

	/**
	 * Multiplies tuple t1 by the inverse of tuple t2 and places the value into this quaternion. The value of both argument
	 * quaternions is preservered (this = t1 * t2^-1).
	 *
	 * @param t1 the first quaternion
	 * @param t2 the second quaternion
	 * @return this for chaining
	 */
	public final  T mulInverse(Tuple2f t1, Tuple2f t2) {
		Vector2f temp = new Vector2f(t2);
		temp.inverse();
		mul(t1, temp);
		return (T) this;
	}

	/**
	 * Multiplies this tuple by the inverse of tuple t1 and places the value into this tuple. The value of the argument tuple is
	 * preserved (this = this * q^-1).
	 *
	 * @param t1 the other quaternion
	 * @return this for chaining
	 */
	public final  T mulInverse(Tuple2f t1) {
		Vector2f temp = new Vector2f(t1);
		temp.inverse();
		mul(temp);
		return (T) this;
	}

}
