/*
 * $RCSfile: Tuple3f.java,v $
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

/**
 * A generic 3-element tuple that is represented by single precision-floating point x,y,z coordinates.
 *
 */
public abstract class Tuple3f implements java.io.Serializable, Cloneable {

	static final long serialVersionUID = 5019834619484343712L;

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
	 * Constructs and initializes a Tuple3f from the specified xyz coordinates.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param z the z coordinate
	 */
	public Tuple3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Constructs and initializes a Tuple3f from the array of length 3.
	 *
	 * @param t the array of length 3 containing xyz in order
	 */
	public Tuple3f(float[] t) {
		this.x = t[0];
		this.y = t[1];
		this.z = t[2];
	}

	/**
	 * Constructs and initializes a Tuple3f from the specified Tuple3f.
	 *
	 * @param t1 the Tuple3f containing the initialization x y z data
	 */
	public Tuple3f(Tuple3f t1) {
		this.x = t1.x;
		this.y = t1.y;
		this.z = t1.z;
	}

	/**
	 * Constructs and initializes a Tuple3f to (0,0,0).
	 */
	public Tuple3f() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
	}

	/**
	 * Returns a string that contains the values of this Tuple3f. The form is (x,y,z).
	 *
	 * @return the String representation
	 */
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ", " + this.z + ")";
	}

	/**
	 * Sets the value of this tuple to the specified xyz coordinates.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param z the z coordinate
	 * @return this for chaining
	 */
	public final Tuple3f set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	/**
	 * Sets the value of this tuple to the xyz coordinates specified in the array of length 3.
	 *
	 * @param t the array of length 3 containing xyz in order
	 * @return this for chaining
	 */
	public final Tuple3f set(float[] t) {
		this.x = t[0];
		this.y = t[1];
		this.z = t[2];
		return this;
	}

	/**
	 * Sets the value of this tuple to the value of tuple t1.
	 *
	 * @param t1 the tuple to be copied
	 * @return this for chaining
	 */
	public final Tuple3f set(Tuple3f t1) {
		this.x = t1.x;
		this.y = t1.y;
		this.z = t1.z;
		return this;
	}

	/**
	 * Gets the value of this tuple and copies the values into t.
	 *
	 * @param t the array of length 3 into which the values are copied
	 * @return t for chaining
	 */
	public final float[] get(float[] t) {
		t[0] = this.x;
		t[1] = this.y;
		t[2] = this.z;
		return t;
	}

	/**
	 * Gets the value of this tuple and copies the values into t.
	 *
	 * @param t the Tuple3f object into which the values of this object are copied
	 * @return t for chaining
	 */
	public final Tuple3f get(Tuple3f t) {
		t.x = this.x;
		t.y = this.y;
		t.z = this.z;
		return t;
	}

	/**
	 * Sets the value of this tuple to the vector sum of tuples t1 and t2.
	 *
	 * @param t1 the first tuple
	 * @param t2 the second tuple
	 * @return this for chaining
	 */
	public final Tuple3f add(Tuple3f t1, Tuple3f t2) {
		this.x = t1.x + t2.x;
		this.y = t1.y + t2.y;
		this.z = t1.z + t2.z;
		return this;
	}

	/**
	 * Sets the value of this tuple to the vector sum of itself and tuple t1.
	 *
	 * @param t1 the other tuple
	 * @return this for chaining
	 */
	public final Tuple3f add(Tuple3f t1) {
		this.x += t1.x;
		this.y += t1.y;
		this.z += t1.z;
		return this;
	}

	/**
	 * Sets the value of this tuple to the vector difference of tuples t1 and t2 (this = t1 - t2).
	 *
	 * @param t1 the first tuple
	 * @param t2 the second tuple
	 * @return this for chaining
	 */
	public final Tuple3f sub(Tuple3f t1, Tuple3f t2) {
		this.x = t1.x - t2.x;
		this.y = t1.y - t2.y;
		this.z = t1.z - t2.z;
		return this;
	}

	/**
	 * Sets the value of this tuple to the vector difference of itself and tuple t1 (this = this - t1) .
	 *
	 * @param t1 the other tuple
	 * @return this for chaining
	 */
	public final Tuple3f sub(Tuple3f t1) {
		this.x -= t1.x;
		this.y -= t1.y;
		this.z -= t1.z;
		return this;
	}

	/**
	 * Sets the value of this tuple to the negation of tuple t1.
	 *
	 * @param t1 the source tuple
	 * @return this for chaining
	 */
	public final Tuple3f negate(Tuple3f t1) {
		this.x = -t1.x;
		this.y = -t1.y;
		this.z = -t1.z;
		return this;
	}

	/**
	 * Negates the value of this tuple in place.
	 *
	 * @return this for chaining
	 */
	public final Tuple3f negate() {
		this.x = -this.x;
		this.y = -this.y;
		this.z = -this.z;
		return this;
	}

	/**
	 * Sets the value of this vector to the scalar multiplication of tuple t1.
	 *
	 * @param s the scalar value
	 * @param t1 the source tuple
	 * @return this for chaining
	 */
	public final Tuple3f scale(float s, Tuple3f t1) {
		this.x = s * t1.x;
		this.y = s * t1.y;
		this.z = s * t1.z;
		return this;
	}

	/**
	 * Scales each component of this tuple by the corresponding components of t1 and stores the result in this tuple.
	 *
	 * @param t1 the source tuple
	 * @return this for chaining
	 */
	public final Tuple3f scale(Tuple3f t1) {
		this.x *= t1.x;
		this.y *= t1.y;
		this.z *= t1.z;
		return this;
	}

	/**
	 * Sets the value of this tuple to the scalar multiplication of the scale factor with this.
	 *
	 * @param s the scalar value
	 * @return this for chaining
	 */
	public final Tuple3f scale(float s) {
		this.x *= s;
		this.y *= s;
		this.z *= s;
		return this;
	}

	/**
	 * Sets the value of this tuple to the scalar multiplication of tuple t1 and then adds tuple t2 (this = s*t1 + t2).
	 *
	 * @param s the scalar value
	 * @param t1 the tuple to be scaled and added
	 * @param t2 the tuple to be added without a scale
	 * @return this for chaining
	 */
	public final Tuple3f scaleAdd(float s, Tuple3f t1, Tuple3f t2) {
		this.x = s * t1.x + t2.x;
		this.y = s * t1.y + t2.y;
		this.z = s * t1.z + t2.z;
		return this;
	}

	/**
	 * Sets the value of this tuple to the scalar multiplication of itself and then adds tuple t1 (this = s*this + t1).
	 *
	 * @param s the scalar value
	 * @param t1 the tuple to be added
	 * @return this for chaining
	 */
	public final Tuple3f scaleAdd(float s, Tuple3f t1) {
		this.x = s * this.x + t1.x;
		this.y = s * this.y + t1.y;
		this.z = s * this.z + t1.z;
		return this;
	}

	/**
	 * Returns true if the Object t1 is of type Tuple3f and all of the data members of t1 are equal to the corresponding data members
	 * in this Tuple3f.
	 *
	 * @param t1 the vector with which the comparison is made
	 * @return true or false
	 */
	public boolean equals(Tuple3f t1) {
		try {
			return (this.x == t1.x && this.y == t1.y && this.z == t1.z);
		} catch (NullPointerException e2) {
			return false;
		}
	}

	/**
	 * Returns true if the Object t1 is of type Tuple3f and all of the data members of t1 are equal to the corresponding data members
	 * in this Tuple3f.
	 *
	 * @param t1 the Object with which the comparison is made
	 * @return true or false
	 */
	@Override
	public boolean equals(Object t1) {
		try {
			Tuple3f t2 = (Tuple3f) t1;
			return (this.x == t2.x && this.y == t2.y && this.z == t2.z);
		} catch (NullPointerException | ClassCastException e2) {
			return false;
		}
	}

	/**
	 * Returns true if the L-infinite distance between this tuple and tuple t1 is less than or equal to the epsilon parameter,
	 * otherwise returns false. The L-infinite distance is equal to MAX[abs(x1-x2), abs(y1-y2), abs(z1-z2)].
	 *
	 * @param t1 the tuple to be compared to this tuple
	 * @param epsilon the threshold value
	 * @return true or false
	 */
	public boolean epsilonEquals(Tuple3f t1, float epsilon) {
		float diff;

		diff = x - t1.x;
		if (Float.isNaN(diff)) {
			return false;
		}
		if ((diff < 0 ? -diff : diff) > epsilon) {
			return false;
		}

		diff = y - t1.y;
		if (Float.isNaN(diff)) {
			return false;
		}
		if ((diff < 0 ? -diff : diff) > epsilon) {
			return false;
		}

		diff = z - t1.z;
		if (Float.isNaN(diff)) {
			return false;
		}
		return (diff < 0 ? -diff : diff) <= epsilon;

	}

	/**
	 * Clamps the tuple parameter to the range [low, high] and places the values into this tuple.
	 *
	 * @param min the lowest value in the tuple after clamping
	 * @param max the highest value in the tuple after clamping
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public final Tuple3f clamp(float min, float max, Tuple3f t) {
		if (t.x > max) {
			x = max;
		} else if (t.x < min) {
			x = min;
		} else {
			x = t.x;
		}

		if (t.y > max) {
			y = max;
		} else if (t.y < min) {
			y = min;
		} else {
			y = t.y;
		}

		if (t.z > max) {
			z = max;
		} else if (t.z < min) {
			z = min;
		} else {
			z = t.z;
		}
		return this;
	}

	/**
	 * Clamps the minimum value of the tuple parameter to the min parameter and places the values into this tuple.
	 *
	 * @param min the lowest value in the tuple after clamping
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public final Tuple3f clampMin(float min, Tuple3f t) {
		if (t.x < min) {
			x = min;
		} else {
			x = t.x;
		}

		if (t.y < min) {
			y = min;
		} else {
			y = t.y;
		}

		if (t.z < min) {
			z = min;
		} else {
			z = t.z;
		}
		return this;
	}

	/**
	 * Clamps the maximum value of the tuple parameter to the max parameter and places the values into this tuple.
	 *
	 * @param max the highest value in the tuple after clamping
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public final Tuple3f clampMax(float max, Tuple3f t) {
		if (t.x > max) {
			x = max;
		} else {
			x = t.x;
		}

		if (t.y > max) {
			y = max;
		} else {
			y = t.y;
		}

		if (t.z > max) {
			z = max;
		} else {
			z = t.z;
		}
		return this;
	}

	/**
	 * Sets each component of the tuple parameter to its abs value and places the modified values into this tuple.
	 *
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public final Tuple3f abs(Tuple3f t) {
		x = Math.abs(t.x);
		y = Math.abs(t.y);
		z = Math.abs(t.z);
		return this;
	}

	/**
	 * Clamps this tuple to the range [low, high].
	 *
	 * @param min the lowest value in this tuple after clamping
	 * @param max the highest value in this tuple after clamping
	 * @return this for chaining
	 */
	public final Tuple3f clamp(float min, float max) {
		if (x > max) {
			x = max;
		} else if (x < min) {
			x = min;
		}

		if (y > max) {
			y = max;
		} else if (y < min) {
			y = min;
		}

		if (z > max) {
			z = max;
		} else if (z < min) {
			z = min;
		}
		return this;
	}

	/**
	 * Clamps the minimum value of this tuple to the min parameter.
	 *
	 * @param min the lowest value in this tuple after clamping
	 * @return this for chaining
	 */
	public final Tuple3f clampMin(float min) {
		if (x < min) {
			x = min;
		}
		if (y < min) {
			y = min;
		}
		if (z < min) {
			z = min;
		}
		return this;
	}

	/**
	 * Clamp the components of tuple t to between min and max, store the result in this tuple.
	 *
	 * @param min tuple with the minimum component values
	 * @param max tuplie with the maximum component values
	 * @param t
	 * @return this for chaining
	 */
	public final Tuple3f clamp(Tuple3f min, Tuple3f max, Tuple3f t) {
		x = Math.min(Math.max(t.x, min.x), max.x);
		y = Math.min(Math.max(t.y, min.y), max.y);
		z = Math.min(Math.max(t.z, min.z), max.z);
		return this;
	}

	/**
	 * Clamps the maximum value of this tuple to the max parameter.
	 *
	 * @param max the highest value in the tuple after clamping
	 * @return this for chaining
	 */
	public final Tuple3f clampMax(float max) {
		if (x > max) {
			x = max;
		}
		if (y > max) {
			y = max;
		}
		if (z > max) {
			z = max;
		}
		return this;
	}

	/**
	 * Sets each component of this tuple to its abs value.
	 *
	 * @return this for chaining
	 */
	public final Tuple3f abs() {
		x = Math.abs(x);
		y = Math.abs(y);
		z = Math.abs(z);
		return this;
	}

	/**
	 * Linearly interpolates between tuples t1 and t2 and places the result into this tuple: this = (1-alpha)*t1 + alpha*t2.
	 *
	 * @param t1 the first tuple
	 * @param t2 the second tuple
	 * @param alpha the alpha interpolation parameter
	 * @return this for chaining
	 */
	public final Tuple3f interpolate(Tuple3f t1, Tuple3f t2, float alpha) {
		this.x = (1 - alpha) * t1.x + alpha * t2.x;
		this.y = (1 - alpha) * t1.y + alpha * t2.y;
		this.z = (1 - alpha) * t1.z + alpha * t2.z;
		return this;
	}

	/**
	 * Linearly interpolates between this tuple and tuple t1 and places the result into this tuple: this = (1-alpha)*this + alpha*t1.
	 *
	 * @param t1 the first tuple
	 * @param alpha the alpha interpolation parameter
	 * @return this for chaining
	 */
	public final Tuple3f interpolate(Tuple3f t1, float alpha) {
		this.x = (1 - alpha) * this.x + alpha * t1.x;
		this.y = (1 - alpha) * this.y + alpha * t1.y;
		this.z = (1 - alpha) * this.z + alpha * t1.z;
		return this;
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
	 * @return the  <i>x</i> coordinate.
	 *
	 * @since vecmath 1.5
	 */
	public final float getX() {
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
	public final Tuple3f setX(float x) {
		this.x = x;
		return this;
	}

	/**
	 * Get the <i>y</i> coordinate.
	 *
	 * @return the <i>y</i> coordinate.
	 *
	 * @since vecmath 1.5
	 */
	public final float getY() {
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
	public final Tuple3f setY(float y) {
		this.y = y;
		return this;
	}

	/**
	 * Get the <i>z</i> coordinate.
	 *
	 * @return the <i>z</i> coordinate
	 *
	 * @since vecmath 1.5
	 */
	public final float getZ() {
		return z;
	}

	/**
	 * Set the <i>Z</i> coordinate.
	 *
	 * @param z value to <i>z</i> coordinate.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public final Tuple3f setZ(float z) {
		this.z = z;
		return this;
	}

	/**
	 * Multiply each component of t1 with t2 and store the result in this tuple
	 *
	 * @param t1 left operand
	 * @param t2 right operand
	 * @return this for chaining
	 */
	public final Tuple3f mul(Tuple3f t1, Tuple3f t2) {
		x = t1.x * t2.x;
		y = t1.y * t2.y;
		z = t1.z * t2.z;
		return this;
	}

	/**
	 * Divide each component of t1 by t2 and store the result in this tuple
	 *
	 * @param t1 left operand
	 * @param t2 right operand
	 * @return this for chaining
	 */
	public final Tuple3f div(Tuple3f t1, Tuple3f t2) {
		x = t1.x / t2.x;
		y = t1.y / t2.y;
		z = t1.z / t2.z;
		return this;
	}

	/**
	 * Get an element of this tuple by index
	 *
	 * @param i 0 for x, 1 for y, 2 for z
	 * @return
	 */
	public final float get(int i) {
		switch (i) {
			case 0:
				return x;
			case 1:
				return y;
			case 2:
				return z;
			default:
				throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Set an element of this tuple
	 *
	 * @param i 0 for x, 1 for y, 2 for z
	 * @param value the new value
	 * @return this for chaining
	 */
	public final Tuple3f set(int i, float value) {
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
			default:
				throw new IndexOutOfBoundsException();
		}
		return this;
	}

	/**
	 * Set each element to the minimum of this or another tuple
	 *
	 * @param t1
	 * @return this for chaining
	 */
	public final Tuple3f setMin(Tuple3f t1) {
		x = Math.min(x, t1.x);
		y = Math.min(y, t1.y);
		z = Math.min(z, t1.z);
		return this;
	}

	/**
	 * Set each element to the minimum of of two tuples
	 *
	 * @param t1
	 * @param t2
	 * @return this for chaining
	 */
	public final Tuple3f setMin(Tuple3f t1, Tuple3f t2) {
		x = Math.min(t2.x, t1.x);
		y = Math.min(t2.y, t1.y);
		z = Math.min(t2.z, t1.z);
		return this;
	}

	/**
	 * Set each element to the maximum of this or another tuple
	 *
	 * @param t1
	 * @return this for chaining
	 */
	public final Tuple3f setMax(Tuple3f t1) {
		x = Math.max(x, t1.x);
		y = Math.max(y, t1.y);
		z = Math.max(z, t1.z);
		return this;
	}

	/**
	 * Set each element to the maximum of of two tuples
	 *
	 * @param t1
	 * @param t2
	 * @return this for chaining
	 */
	public final Tuple3f setMax(Tuple3f t1, Tuple3f t2) {
		x = Math.max(t2.x, t1.x);
		y = Math.max(t2.y, t1.y);
		z = Math.max(t2.z, t1.z);
		return this;
	}

	/**
	 * Set x,y,z of this vector to zero
	 *
	 * @return this for chaining
	 */
	public final Tuple3f setZero() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
		return this;
	}

	/**
	 * Sets this vector to be the vector cross product of vectors v1 and v2.
	 *
	 * @param v1 the first vector
	 * @param v2 the second vector
	 * @return
	 */
	public final Tuple3f cross(Tuple3f v1, Tuple3f v2) {
		float tmp_x;
		float tmp_y;
		tmp_x = v1.y * v2.z - v1.z * v2.y;
		tmp_y = v2.x * v1.z - v2.z * v1.x;
		this.z = v1.x * v2.y - v1.y * v2.x;
		this.x = tmp_x;
		this.y = tmp_y;
		return this;
	}

	/**
	 * Computes the dot product of this vector and vector v1.
	 *
	 * @param v1 the other vector
	 * @return the dot product of this vector and v1
	 */
	public final float dot(Tuple3f v1) {
		return this.x * v1.x + this.y * v1.y + this.z * v1.z;
	}

	/**
	 * Returns the length of this vector.
	 *
	 * @return the length of this vector
	 */
	public final float length() {
		return (float) Math.sqrt(lengthSquared());
	}

	/**
	 * Calculate the distance squared between this tuple and the argument
	 *
	 * @param t1
	 * @return
	 */
	public final float distanceSquared(Tuple3f t1) {
		double dx = (double) t1.x - (double) x;
		double dy = (double) t1.y - (double) y;
		double dz = (double) t1.z - (double) z;
		return (float) (dx * dx + dy * dy + dz * dz);
	}

	/**
	 * Calculate the distance between this tuple and the argument
	 *
	 * @param t1
	 * @return
	 */
	public final float distance(Tuple3f t1) {
		return (float) Math.sqrt(distanceSquared(t1));
	}

	/**
	 * Returns the squared length of this vector.
	 *
	 * @return the squared length of this vector
	 */
	public final float lengthSquared() {
		return (float) ((double) x * (double) x + (double) y * (double) y + (double) z * (double) z);
	}

	public float max3() {
		if (x > y) {
			if (x > z) {
				return x;
			} else {
				return y;
			}
		} else if (y > z) {
			return y;
		} else {
			return z;
		}
	}

	/**
	 * Normalizes this vector in place.
	 *
	 * @return this for chaining
	 */
	public final Tuple3f normalize() {
		float norm;
		norm = (1.0F / length());
		if (Float.isInfinite(norm)) {
			return this;
		}
		this.x *= norm;
		this.y *= norm;
		this.z *= norm;
		return this;
	}

	/**
	 * Sets the value of this vector to the normalization of vector v1.
	 *
	 * @param v1 the un-normalized vector
	 * @return this for chaining
	 */
	public final Tuple3f normalize(Tuple3f v1) {
		set(v1);
		normalize();
		return this;
	}

	/**
	 * Returns a hash code value based on the data values in this object. Two different Tuple3f objects with identical data values
	 * (i.e., Tuple3f.equals returns true) will return the same hash code value. Two objects with different data members may return
	 * the same hash value, although this is not likely.
	 *
	 * @return the integer hash code value
	 */
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 29 * hash + Float.floatToIntBits(this.x);
		hash = 29 * hash + Float.floatToIntBits(this.y);
		hash = 29 * hash + Float.floatToIntBits(this.z);
		return hash;
	}
}
