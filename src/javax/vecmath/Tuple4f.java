/*
 * $RCSfile: Tuple4f.java,v $
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
 * A 4-element tuple represented by single-precision floating point x,y,z,w coordinates.
 *
 * @param <T>
 */
public abstract class Tuple4f<T extends Tuple4f> implements java.io.Serializable, Cloneable {

	static final long serialVersionUID = 7068460319248845763L;

	/**
	 * The x coordinate.
	 */
	public float x;

	/**
	 * The y coordinate.
	 */
	public float y;

	/**
	 * The z coordinate.
	 */
	public float z;

	/**
	 * The w coordinate.
	 */
	public float w;

	/**
	 * Constructs and initializes a Tuple4f from the specified xyzw coordinates.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param z the z coordinate
	 * @param w the w coordinate
	 */
	public Tuple4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	/**
	 * Constructs and initializes a Tuple4f from the float array of length 4.
	 *
	 * @param t the array of length 4 containing xyzw in order
	 */
	public Tuple4f(float[] t) {
		x = t[0];
		y = t[1];
		z = t[2];
		w = t[3];
	}

	/**
	 * Constructs and initializes a Tuple4f from the double array of length 4.
	 *
	 * @param t the array of length 4 containing xyzw in order
	 */
	public Tuple4f(double[] t) {
		x = (float) t[0];
		y = (float) t[1];
		z = (float) t[2];
		w = (float) t[3];
	}

	/**
	 * Constructs and initializes a Tuple4f from the specified Tuple4f.
	 *
	 * @param t1 the Tuple4f containing the initialization x y z w data
	 */
	public Tuple4f(Tuple4f t1) {
		x = t1.x;
		y = t1.y;
		z = t1.z;
		w = t1.w;
	}

	/**
	 * Constructs and initializes a Tuple4f from the specified Tuple3f and w argument..
	 *
	 * @param t1 the Tuple4f containing the initialization x y z w data
	 * @param w w component
	 *
	 */
	public Tuple4f(Tuple3f t1, float w) {
		x = t1.x;
		y = t1.y;
		z = t1.z;
		this.w = w;
	}

	/**
	 * Constructs and initializes a Tuple4f to (0,0,0,0).
	 */
	public Tuple4f() {

	}

	/**
	 * Sets the value of this tuple to the specified xyzw coordinates.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param z the z coordinate
	 * @param w the w coordinate
	 * @return this for chaining
	 */
	public T set(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the specified coordinates in the array of length 4.
	 *
	 * @param t the array of length 4 containing xyzw in order
	 * @return this for chaining
	 */
	public T set(float[] t) {
		x = t[0];
		y = t[1];
		z = t[2];
		w = t[3];
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the specified coordinates in the array of length 4. Truncates double to single precision
	 *
	 * @param t the array of length 4 containing xyzw in order
	 * @return this for chaining
	 */
	public T set(double[] t) {
		x = (float) t[0];
		y = (float) t[1];
		z = (float) t[2];
		w = (float) t[3];
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the value of tuple t1.
	 *
	 * @param t1 the tuple to be copied
	 * @return this for chaining
	 */
	public T set(Tuple4f t1) {
		x = t1.x;
		y = t1.y;
		z = t1.z;
		w = t1.w;
		return (T) this;
	}

	/**
	 * Set x,y,z of this vector to zero
	 *
	 * @return this for chaining
	 */
	public T setZero() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
		w = 0.0f;
		return (T) this;
	}

	/**
	 * Sets the x,y,z components of this vector to the corresponding components of tuple t1, and w to the argument.
	 *
	 * @param t1 the tuple to be copied
	 * @param w w component to copy
	 * @return this for chaining
	 *
	 * @since vecmath 1.2
	 */
	public T set(Tuple3f t1, float w) {
		this.x = t1.x;
		this.y = t1.y;
		this.z = t1.z;
		this.w = w;
		return (T) this;
	}
	/**
	 * Sets the x,y,z components of this vector to the corresponding components of tuple t1,  w is left unchanged.
	 *
	 * @param t1 the tuple to be copied
	 * @param w w component to copy
	 * @return this for chaining
	 *
	 * @since vecmath 1.2
	 */
	public T set(Tuple3f t1 ) {
		this.x = t1.x;
		this.y = t1.y;
		this.z = t1.z;
		return (T) this;
	}
	/**
	 * Copies the values of this tuple into the array t.
	 *
	 * @param t the array
	 * @return t for chaining
	 */
	public float[] get(float[] t) {
		t[0] = x;
		t[1] = y;
		t[2] = z;
		t[3] = w;
		return t;
	}

	/**
	 * Copies the values of this tuple into the tuple t.
	 *
	 * @param t the target tuple
	 * @return t for chaining
	 */
	public T get(T t) {
		t.x = x;
		t.y = y;
		t.z = z;
		t.w = w;
		return (T) t;
	}

	/**
	 * Get an element of this tuple by index
	 *
	 * @param i 0 for x, 1 for y, 2 for z, 3 for 2
	 * @return
	 */
	public float getElement(int i) {
		switch (i) {
			case 0:
				return x;
			case 1:
				return y;
			case 2:
				return z;
			case 3:
				return w;
			default:
				throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Sets the value of this tuple to the sum of tuples t1 and t2.
	 *
	 * @param t1 the first tuple
	 * @param t2 the second tuple
	 * @return this for chaining
	 */
	public T add(Tuple4f t1, Tuple4f t2) {

		x = t1.x + t2.x;
		y = t1.y + t2.y;
		z = t1.z + t2.z;
		w = t1.w + t2.w;

		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the sum of itself and t1.
	 *
	 * @param t1 the other tuple
	 * @return this for chaining
	 */
	public T add(Tuple4f t1) {

		x += t1.x;
		y += t1.y;
		z += t1.z;
		w += t1.w;

		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the difference of tuples t1 and t2 (this = t1 - t2).
	 *
	 * @param t1 the first tuple
	 * @param t2 the second tuple
	 * @return this for chaining
	 */
	public T sub(Tuple4f t1, Tuple4f t2) {

		x = t1.x - t2.x;
		y = t1.y - t2.y;
		z = t1.z - t2.z;
		w = t1.w - t2.w;

		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the difference of itself and t1 (this = this - t1).
	 *
	 * @param t1 the other tuple
	 * @return this for chaining
	 */
	public T sub(Tuple4f t1) {

		x -= t1.x;
		y -= t1.y;
		z -= t1.z;
		w -= t1.w;

		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the negation of tuple t1.
	 *
	 * @param t1 the source tuple
	 * @return this for chaining
	 */
	public T negate(Tuple4f t1) {
		x = -t1.x;
		y = -t1.y;
		z = -t1.z;
		w = -t1.w;
		return (T) this;
	}

	/**
	 * Negates the value of this tuple in place.
	 *
	 * @return this for chaining
	 */
	public T negate() {
		x = -x;
		y = -y;
		z = -z;
		w = -w;
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the scalar multiplication of the scale factor with this.
	 *
	 * @param s the scalar value
	 * @return this for chaining
	 */
	public T scale(float s) {

		x *= s;
		y *= s;
		z *= s;
		w *= s;

		return (T) this;
	}

	/**
	 * Multiply each component of t1 with t2 and store the result in this tuple
	 *
	 * @param t1 left operand
	 * @param t2 right operand
	 * @return this for chaining
	 */
	public T mul(Tuple4f t1, Tuple4f t2) {

		x = t1.x * t2.x;
		y = t1.y * t2.y;
		z = t1.z * t2.z;
		w = t1.w * t2.w;

		return (T) this;
	}

	/**
	 * Multiply each component of t1 with this and store the result in this tuple
	 *
	 * @param t1 left operand
	 * @return this for chaining
	 */
	public T mul(Tuple4f t1) {

		x *= t1.x;
		y *= t1.y;
		z *= t1.z;
		w *= t1.w;

		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the scalar multiplication of tuple t1 plus tuple t2 (this = s*t1 + t2).
	 *
	 * @param s the scalar value
	 * @param t1 the tuple to be multipled
	 * @param t2 the tuple to be added
	 * @return this for chaining
	 */
	public T scaleAdd(float s, Tuple4f t1, Tuple4f t2) {

		float _x = t2.x + s * t1.x;
		float _y = t2.y + s * t1.y;
		float _z = t2.z + s * t1.z;
		float _w = t2.w + s * t1.w;
		set(_x, _y, _z, _w);

		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the scalar multiplication of itself and then adds tuple t1 (this = s*this + t1).
	 *
	 * @param s the scalar value
	 * @param t1 the tuple to be added
	 * @return this for chaining
	 */
	public T scaleAdd(float s, Tuple4f t1) {

		float _x = s * x + t1.x;
		float _y = s * y + t1.y;
		float _z = s * z + t1.z;
		float _w = s * w + t1.w;
		set(_x, _y, _z, _w);

		return (T) this;
	}

	/**
	 * Returns a string that contains the values of this Tuple4f. The form is (x,y,z,w).
	 *
	 * @return the String representation
	 */
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ", " + w + ")";
	}

	/**
	 * Returns true if all of the data members of Tuple4f t1 are equal to the corresponding data members in this Tuple4f.
	 *
	 * @param t1 the vector with which the comparison is made
	 * @return true or false
	 */
	public boolean equals(Tuple4f t1) {
		return (x == t1.x && y == t1.y && z == t1.z
			&& w == t1.w);
	}

	/**
	 * Returns true if the Object t1 is of type Tuple4f and all of the data members of t1 are equal to the corresponding data members
	 * in this Tuple4f.
	 *
	 * @param t1 the object with which the comparison is made
	 * @return true or false
	 */
	@Override
	public boolean equals(Object t1) {
		try {
			Tuple4f t2 = (Tuple4f) t1;
			return (x == t2.x && y == t2.y
				&& z == t2.z && w == t2.w);
		} catch (NullPointerException | ClassCastException e2) {
			return false;
		}
	}

	/**
	 * Returns true if the L-infinite distance between this tuple and tuple t1 is less than or equal to the epsilon parameter,
	 * otherwise returns false. The L-infinite distance is equal to MAX[abs(x1-x2), abs(y1-y2), abs(z1-z2), abs(w1-w2)].
	 *
	 * @param t1 the tuple to be compared to this tuple
	 * @param epsilon the threshold value
	 * @return true or false
	 */
	public boolean epsilonEquals(Tuple4f t1, float epsilon) {
		if (different_epsilon(x, t1.x, epsilon)) {
			return false;
		}
		if (different_epsilon(y, t1.y, epsilon)) {
			return false;
		}
		if (different_epsilon(z, t1.z, epsilon)) {
			return false;
		}
		return !different_epsilon(w, t1.w, epsilon);
	}

	/**
	 * Clamps the tuple parameter to the range [low, high] and places the result into this tuple.
	 *
	 * @param min the lowest value in the tuple after clamping
	 * @param max the highest value in the tuple after clamping
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public T clamp(float min, float max, Tuple4f t) {
		x = Math.min(max, Math.max(min, t.x));
		y = Math.min(max, Math.max(min, t.y));
		z = Math.min(max, Math.max(min, t.z));
		w = Math.min(max, Math.max(min, t.w));
		return (T) this;
	}

	/**
	 * Clamp the components of tuple t to between min and max, store the result in this tuple.
	 *
	 * @param min tuple with the minimum component values
	 * @param max tuplie with the maximum component values
	 * @param t
	 * @return this for chaining
	 */
	public T clamp(Tuple4f min, Tuple4f max, Tuple4f t) {
		x = Math.min(max.x, Math.max(min.x, t.x));
		y = Math.min(max.y, Math.max(min.y, t.y));
		z = Math.min(max.z, Math.max(min.z, t.z));
		w = Math.min(max.w, Math.max(min.w, t.w));
		return (T) this;
	}

	/**
	 * Clamps the minimum value of the tuple parameter to the min parameter and places the values into this tuple.
	 *
	 * @param min the lowest value in the tuple after clamping
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public T clampMin(float min, Tuple4f t) {
		x = Math.max(min, t.x);
		y = Math.max(min, t.y);
		z = Math.max(min, t.z);
		w = Math.max(min, t.w);
		return (T) this;
	}

	/**
	 * Clamps the maximum value of the tuple parameter to the max parameter and places the values into this tuple.
	 *
	 * @param max the highest value in the tuple after clamping
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public T clampMax(float max, Tuple4f t) {
		x = Math.min(max, t.x);
		y = Math.min(max, t.y);
		z = Math.min(max, t.z);
		w = Math.min(max, t.w);
		return (T) this;
	}

	/**
	 * Sets each component of the tuple parameter to its abs value and places the modified values into this tuple.
	 *
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public T abs(Tuple4f t) {
		x = Math.abs(t.x);
		y = Math.abs(t.y);
		z = Math.abs(t.z);
		w = Math.abs(t.w);
		return (T) this;
	}

	/**
	 * Sets each component of this tuple to its absolute value.
	 *
	 * @return this for chaining
	 */
	public T absolute() {
		abs();
		return (T) this;
	}

	/**
	 * Sets each component of the tuple parameter to its absolute value and places the modified values into this tuple.
	 *
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public T absolute(Tuple4f t) {
		abs();
		return (T) this;

	}

	/**
	 * Clamps this tuple to the range [low, high].
	 *
	 * @param min the lowest value in this tuple after clamping
	 * @param max the highest value in this tuple after clamping
	 * @return this for chaining
	 */
	public T clamp(float min, float max) {
		x = Math.min(max, Math.min(max, x));
		y = Math.min(max, Math.min(max, y));
		z = Math.min(max, Math.min(max, z));
		w = Math.min(max, Math.min(max, w));
		return (T) this;
	}

	/**
	 * Clamps the minimum value of this tuple to the min parameter.
	 *
	 * @param min the lowest value in this tuple after clamping
	 * @return this for chaining
	 */
	public T clampMin(float min) {
		x = Math.max(min, x);
		y = Math.max(min, y);
		z = Math.max(min, z);
		w = Math.max(min, w);
		return (T) this;
	}

	/**
	 * Clamps the maximum value of this tuple to the max parameter.
	 *
	 * @param max the highest value in the tuple after clamping
	 * @return this for chaining
	 */
	public T clampMax(float max) {
		x = Math.min(max, x);
		y = Math.min(max, y);
		z = Math.min(max, z);
		w = Math.min(max, w);
		return (T) this;
	}

	/**
	 * Sets each component of this tuple to its abs value.
	 *
	 * @return this for chaining
	 */
	public T abs() {
		x = Math.abs(x);
		y = Math.abs(y);
		z = Math.abs(z);
		w = Math.abs(w);
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
	public T setX(float x) {
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
	public T setY(float y) {
		this.y = y;
		return (T) this;
	}

	/**
	 * Get the <i>z</i> coordinate.
	 *
	 * @return the <i>z</i> coordinate.
	 *
	 * @since vecmath 1.5
	 */
	public float getZ() {
		return z;
	}

	/**
	 * Set the <i>z</i> coordinate.
	 *
	 * @param z value to <i>z</i> coordinate.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public T setZ(float z) {
		this.z = z;
		return (T) this;
	}

	/**
	 * Get the <i>w</i> coordinate.
	 *
	 * @return the <i>w</i> coordinate.
	 *
	 * @since vecmath 1.5
	 */
	public float getW() {
		return w;
	}

	/**
	 * Set the <i>w</i> coordinate.
	 *
	 * @param w value to <i>w</i> coordinate.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public T setW(float w) {
		this.w = w;
		return (T) this;
	}

	/**
	 * Linear interpolate between two tuples and store the result in this tuple.
	 *
	 * @param t1
	 * @param t2
	 * @param t weight from t1 (0.0) to t2 (1.0)
	 * @return this for chaining
	 */
	public T mix(Tuple4f t1, Tuple4f t2, float t) {

		x = t1.x * (1.0f - t) + t2.x * t;
		y = t1.y * (1.0f - t) + t2.y * t;
		z = t1.z * (1.0f - t) + t2.z * t;
		w = t1.w * (1.0f - t) + t2.w * t;

		return (T) this;
	}

	/**
	 * Linear interpolate between two tuples and store the result in this tuple.
	 *
	 * @param t1
	 * @param t weight from t1 (0.0) to t2 (1.0)
	 * @return this for chaining
	 */
	public T mix(Tuple4f t1, float t) {

		x = x * (1.0f - t) + t1.x * t;
		y = y * (1.0f - t) + t1.y * t;
		z = z * (1.0f - t) + t1.z * t;
		w = w * (1.0f - t) + t1.w * t;

		return (T) this;
	}

	/**
	 * Returns a hash code value based on the data values in this object. Two different Tuple4f objects with identical data values
	 * (i.e., Tuple4f.equals returns true) will return the same hash code value. Two objects with different data members may return
	 * the same hash value, although this is not likely.
	 *
	 * @return the integer hash code value
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 13 * hash + Float.floatToIntBits(x);
		hash = 13 * hash + Float.floatToIntBits(y);
		hash = 13 * hash + Float.floatToIntBits(z);
		hash = 13 * hash + Float.floatToIntBits(w);
		return hash;
	}

	/**
	 * Get the maximum value among the first three components (x,y,z)
	 *
	 * @return maximum value
	 */
	public float max3() {
		return Math.max(Math.max(x, y), z);
	}

	/**
	 * Get the maximum value among the components (x,y,z,w)
	 *
	 * @return maximum value
	 */
	public float max() {
		return Math.max(Math.max(Math.max(x, y), z), w);
	}

	/**
	 * Return the axis index of one of the first three components (x,y,z) that has the highest value
	 *
	 * @return axis index
	 */
	public int maxAxis3() {
		if (x >= Math.max(y, z)) {
			return 0;
		} else if (y >= Math.max(x, z)) {
			return 1;
		} else {
			return 2;
		}
	}

	/**
	 * Return the axis index of the component that has the highest value
	 *
	 * @return axis index
	 */
	public int maxAxis() {
		if (x >= Math.max(y, z)) {
			return 0;
		} else if (y >= Math.max(x, z)) {
			return 1;
		} else if (z >= Math.max(x, y)) {
			return 2;
		} else {
			return 3;
		}
	}

	/**
	 * returns the dot product of this vector and v1
	 *
	 * @param v1 the other vector
	 * @return the dot product of this vector and v1
	 */
	public float dot(Tuple4f v1) {

		return (x * v1.x + y * v1.y + z * v1.z + w * v1.w);

	}

	/**
	 * Sets the value of this vector to the normalization of vector v1.
	 *
	 * @param v1 the un-normalized vector
	 * @return this for chaining
	 */
	public T normalize(Tuple4f v1) {

		set(v1);
		normalize();

		return (T) this;
	}

	/**
	 * Normalizes this vector in place.
	 *
	 * @return this for chaining
	 */
	public T normalize() {

		float norm = (1.0f / length());
		if (Float.isInfinite(norm)) {
			return (T) this;
		}
		scale(norm);

		return (T) this;
	}

	/**
	 * Returns the length of this vector.
	 *
	 * @return the length of this vector as a float
	 */
	public float length() {

		return sqrt(lengthSquared());

	}

	/**
	 * Returns the squared length of this vector
	 *
	 * @return the squared length of this vector as a float
	 */
	public float lengthSquared() {

		return (x * x + y * y
			+ z * z + w * w);

	}

	/**
	 * Promote this single precision tuple to a double precision single row matrix
	 *
	 * @return
	 */
	public Matrix promote() {
		return new Matrix(new double[][]{{x, y, z, w}});
	}

	/**
	 * Returns the (4-space) angle in radians between this vector and the vector parameter; the return value is constrained to the
	 * range [0,PI].
	 *
	 * @param v1 the other vector
	 * @return the angle in radians in the range [0,PI]
	 */
	public float angle(Tuple4f v1) {

		float vDot = dot(v1) / (length() * v1.length());
		if (vDot < -1.0f) {
			vDot = -1.0f;
		}
		if (vDot > 1.0f) {
			vDot = 1.0f;
		}
		return (acos(vDot));

	}

	/**
	 * Computes the distance between this point and point p1.
	 *
	 * @param p1 the other point
	 * @return the distance between the two points
	 */
	public float distance(Tuple4f p1) {

		return sqrt(distanceSquared(p1));

	}

	/**
	 * Computes the square of the distance between this point and point p1.
	 *
	 * @param p1 the other point
	 * @return the square of distance between these two points as a float
	 */
	public float distanceSquared(Tuple4f p1) {
		float dx = x - p1.x;
		float dy = y - p1.y;
		float dz = z - p1.z;
		float dw = w - p1.w;
		return dx * dx + dy * dy + dz * dz + dw * dw;
	}

	/**
	 * Set an element of this tuple
	 *
	 * @param i 0 for x, 1 for y, 2 for z
	 * @param value the new value
	 * @return this for chaining
	 */
	public T setElement(int i, float value) {
		switch (i) {
			case 0:
				x = value;
				break;
			case 1:
				y = value;
				break;
			case 2:
				z = value;
				break;
			case 3:
				w = value;
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
	public final T inverse() {
		float norm;

		norm = 1.0f / lengthSquared();
		scale(norm);
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the inverse of q1. Equal to 1/(t dot t)
	 *
	 * @param q1 the tuple to be inverted
	 * @return this for chaining
	 */
	public final T inverse(Tuple4f q1) {
		set(q1);
		inverse();
		return (T) this;
	}

	/**
	 * Multiplies tuple t1 by the inverse of tuple t2 and places the value into this tuple. The value of both argument
	 * tuple is preserved (this = t1 * t2^-1).
	 *
	 * @param t1 the first tuple
	 * @param t2 the second tuple
	 * @return this for chaining
	 */
	public final T mulInverse(Tuple4f t1, Tuple4f t2) {
		Vector4f temp = new Vector4f(t2);
		temp.inverse();
		mul(t1, temp);
		return (T) this;
	}

	/**
	 * Multiplies this tuple by the inverse of tuple t1 and places the value into this tuple. The value of the argument tuple is
	 * preserved (this = this * q^-1).
	 *
	 * @param t1 the other tuple
	 * @return this for chaining
	 */
	public final T mulInverse(Tuple4f t1) {
		Vector4f temp = new Vector4f(t1);
		temp.inverse();
		mul(temp);
		return (T) this;
	}

	/**
	 * Linear interpolate between two tuples and store the result in this tuple.
	 *
	 * @param t1
	 * @param t2
	 * @param t weight from t1 (0.0) to t2 (1.0)
	 * @return this for chaining
	 */
	public T interpolate(Tuple4f t1, Tuple4f t2, float t) {
		mix(t1, t2, t);
		return (T) this;
	}

	/**
	 * Linear interpolate between two tuples and store the result in this tuple.
	 *
	 * @param t1
	 * @param t weight from t1 (0.0) to t2 (1.0)
	 * @return this for chaining
	 */
	public T interpolate(Tuple4f t1, float t) {
		mix(t1, t);
		return (T) this;
	}

}
