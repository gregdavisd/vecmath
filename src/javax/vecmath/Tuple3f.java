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
 
import static javax.vecmath.VecMath.acos;
import static javax.vecmath.VecMath.different_epsilon;
import static javax.vecmath.VecMath.sqrt;

/**
 * A generic 3-element tuple that is represented by single precision-floating point x,y,z coordinates.
 *
 * @param <T>
 */
public abstract class Tuple3f<T extends Tuple3f> implements java.io.Serializable, Cloneable {

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
		this.x=x;
		this.y=y;
		this.z=z;
	}

	/**
	 * Constructs and initializes a Tuple3f from the array of length 3.
	 *
	 * @param t the array of length 3 containing xyz in order
	 */
	public Tuple3f(float[] t) {
		x=t[0];
		y=t[1];
		z=t[2];
	}

	/**
	 * Constructs and initializes a Tuple3f from the array of length 3.
	 *
	 * @param t the array of length 3 containing xyz in order
	 */
	public Tuple3f(double[] t) {
	 x=(float)t[0];
	y=(float)t[1];
	z=(float)t[2];
	}

	/**
	 * Constructs and initializes a Tuple3f from the specified Tuple3f.
	 *
	 * @param t1 the Tuple3f containing the initialization x y z data
	 */
	public Tuple3f(Tuple3f t1) {
		x=t1.x;
		y=t1.y;
		z=t1.z;
	}

	/**
	 * Constructs and initializes a Tuple3f to (0,0,0).
	 */
	public Tuple3f() {

	}

	/**
	 * Returns a string that contains the values of this Tuple3f. The form is (x,y,z).
	 *
	 * @return the String representation
	 */
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}

	/**
	 * Sets the value of this tuple to the specified xyz coordinates.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param z the z coordinate
	 * @return this for chaining
	 */
	public  T set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the xyz coordinates specified in the array of length 3.
	 *
	 * @param t the array of length 3 containing xyz in order
	 * @return this for chaining
	 */
	public  T set(float[] t) {
		x = t[0];
		y = t[1];
		z = t[2];
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the xyz coordinates specified in the array of length 3.
	 *
	 * @param t the array of length 3 containing xyz in order
	 * @return this for chaining
	 */
	public  T set(double[] t) {
		x = (float) t[0];
		y = (float) t[1];
		z = (float) t[2];
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the value of tuple t1.
	 *
	 * @param t1 the tuple to be copied
	 * @return this for chaining
	 */
	public  T set(Tuple3f t1) {
		x = t1.x;
		y = t1.y;
		z = t1.z;
		return (T) this;
	}

	/**
	 * Gets the value of this tuple and copies the values into t.
	 *
	 * @param t the array of length 3 into which the values are copied
	 * @return t for chaining
	 */
	public float[] get(float[] t) {
		t[0] = x;
		t[1] = y;
		t[2] = z;
		return t;
	}

	/**
	 * Gets the value of this tuple and copies the values into t.
	 *
	 * @param t the Tuple3f object into which the values of this object are copied
	 * @return t for chaining
	 */
	public  T get(T t) {
		t.x = x;
		t.y = y;
		t.z = z;
		return t;
	}

	/**
	 * Sets the value of this tuple to the vector sum of tuples t1 and t2.
	 *
	 * @param t1 the first tuple
	 * @param t2 the second tuple
	 * @return this for chaining
	 */
	public  T add(Tuple3f t1, Tuple3f t2) {
		x = t1.x + t2.x;
		y = t1.y + t2.y;
		z = t1.z + t2.z;
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the vector sum of itself and tuple t1.
	 *
	 * @param t1 the other tuple
	 * @return this for chaining
	 */
	public  T add(Tuple3f t1) {
		x += t1.x;
		y += t1.y;
		z += t1.z;
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the vector difference of tuples t1 and t2 (this = t1 - t2).
	 *
	 * @param t1 the first tuple
	 * @param t2 the second tuple
	 * @return this for chaining
	 */
	public  T sub(Tuple3f t1, Tuple3f t2) {
		x = t1.x - t2.x;
		y = t1.y - t2.y;
		z = t1.z - t2.z;
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the vector difference of itself and tuple t1 (this = this - t1) .
	 *
	 * @param t1 the other tuple
	 * @return this for chaining
	 */
	public  T sub(Tuple3f t1) {
		x -= t1.x;
		y -= t1.y;
		z -= t1.z;
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the negation of tuple t1.
	 *
	 * @param t1 the source tuple
	 * @return this for chaining
	 */
	public  T negate(Tuple3f t1) {
		x = -t1.x;
		y = -t1.y;
		z = -t1.z;
		return (T) this;
	}

	/**
	 * Negates the value of this tuple in place.
	 *
	 * @return this for chaining
	 */
	public  T negate() {
		x = -x;
		y = -y;
		z = -z;
		return (T) this;
	}

	/**
	 * Sets the value of this vector to the scalar multiplication of tuple t1.
	 *
	 * @param s the scalar value
	 * @param t1 the source tuple
	 * @return this for chaining
	 */
	public  T scale(float s, Tuple3f t1) {
 
			x = s * t1.x;
			y = s * t1.y;
			z = s * t1.z;
	 
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the scalar multiplication of the scale factor with this.
	 *
	 * @param s the scalar value
	 * @return this for chaining
	 */
	public  T scale(float s) {
		x *= s;
		y *= s;
		z *= s;
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the scalar multiplication of tuple t1 and then adds tuple t2 (this = s*t1 + t2).
	 *
	 * @param s the scalar value
	 * @param t1 the tuple to be scaled and added
	 * @param t2 the tuple to be added without a scale
	 * @return this for chaining
	 */
	public  T scaleAdd(float s, Tuple3f t1, Tuple3f t2) {
	 
			x = s * t1.x + t2.x;
			y = s * t1.y + t2.y;
			z = s * t1.z + t2.z;
	 
		return (T) this;
	}

	/**
	 * Sets the value of this tuple to the scalar multiplication of itself and then adds tuple t1 (this = s*this + t1).
	 *
	 * @param s the scalar value
	 * @param t1 the tuple to be added
	 * @return this for chaining
	 */
	public  T scaleAdd(float s, Tuple3f t1) {
 
			x = s * x + t1.x;
			y = s * y + t1.y;
			z = s * z + t1.z;
 
		return (T) this;
	}

	/**
	 * Returns true if the Object t1 is of type Tuple3f and all of the data members of t1 are equal to the corresponding data members
	 * in this Tuple3f.
	 *
	 * @param t1 the vector with which the comparison is made
	 * @return true or false
	 */
	public boolean equals(Tuple3f t1) {
		return (x == t1.x && y == t1.y && z == t1.z);
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
			return (x == t2.x && y == t2.y && z == t2.z);
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
		if (different_epsilon(x, t1.x, epsilon)) {
			return false;
		}
		if (different_epsilon(y, t1.y, epsilon)) {
			return false;
		}
		return !different_epsilon(x, t1.z, epsilon);
	}

	/**
	 * Clamps the tuple parameter to the range [low, high] and places the values into this tuple.
	 *
	 * @param min the lowest value in the tuple after clamping
	 * @param max the highest value in the tuple after clamping
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public  T clamp(float min, float max, Tuple3f t) {
		x = Math.min(max, Math.max(min, t.x));
		y = Math.min(max, Math.max(min, t.y));
		z = Math.min(max, Math.max(min, t.z));
		return (T) this;
	}

	/**
	 * Clamps the minimum value of the tuple parameter to the min parameter and places the values into this tuple.
	 *
	 * @param min the lowest value in the tuple after clamping
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public  T clampMin(float min, Tuple3f t) {
		x = Math.max(min, t.x);
		y = Math.max(min, t.y);
		z = Math.max(min, t.z);
		return (T) this;
	}

	/**
	 * Clamps the maximum value of the tuple parameter to the max parameter and places the values into this tuple.
	 *
	 * @param max the highest value in the tuple after clamping
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public  T clampMax(float max, Tuple3f t) {
		x = Math.min(max, t.x);
		y = Math.min(max, t.y);
		z = Math.min(max, t.z);
		return (T) this;
	}

	/**
	 * Sets each component of the tuple parameter to its abs value and places the modified values into this tuple.
	 *
	 * @param t the source tuple, which will not be modified
	 * @return this for chaining
	 */
	public  T abs(Tuple3f t) {
		x = Math.abs(t.x);
		y = Math.abs(t.y);
		z = Math.abs(t.z);
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
		z = Math.min(max, Math.min(max, z));
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
		z = Math.max(min, z);
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
	public  T clamp(Tuple3f min, Tuple3f max, Tuple3f t) {
		x = Math.min(max.x, Math.max(min.x, t.x));
		y = Math.min(max.y, Math.max(min.y, t.y));
		z = Math.min(max.z, Math.max(min.z, t.z));
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
		z = Math.min(max, z);
		return (T) this;
	}

	/**
	 * Sets each component of this tuple to its abs value.
	 *
	 * @return this for chaining
	 */
	public  T abs() {
		x = Math.abs(x);
		y = Math.abs(y);
		z = Math.abs(z);
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
	 * @return the  <i>x</i> coordinate.
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
	 * Get the <i>z</i> coordinate.
	 *
	 * @return the <i>z</i> coordinate
	 *
	 * @since vecmath 1.5
	 */
	public float getZ() {
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
	public  T setZ(float z) {
		this.z = z;
		return (T) this;
	}

	/**
	 * Multiply each component of t1 with t2 and store the result in this tuple
	 *
	 * @param t1 left operand
	 * @param t2 right operand
	 * @return this for chaining
	 */
	public  T mul(Tuple3f t1, Tuple3f t2) {
 
			x = t1.x * t2.x;
			y = t1.y * t2.y;
			z = t1.z * t2.z;
 
		return (T) this;
	}

	/**
	 * Multiply each component of t1 with this and store the result in this tuple
	 *
	 * @param t1 left operand
	 * @return this for chaining
	 */
	public  T mul(Tuple3f t1) {
 
			x *= t1.x;
			y *= t1.y;
			z *= t1.z;
 
		return (T) this;
	}

	/**
	 * Divide each component of t1 by t2 and store the result in this tuple
	 *
	 * @param t1 left operand
	 * @param t2 right operand
	 * @return this for chaining
	 */
	public  T div(Tuple3f t1, Tuple3f t2) {
		x = t1.x / t2.x;
		y = t1.y / t2.y;
		z = t1.z / t2.z;
		return (T) this;
	}

	/**
	 * Divide each component of this tuple by t1 and store the result in this tuple
	 *
	 * @param t1 left operand
	 * @return this for chaining
	 */
	public  T div(Tuple3f t1) {
 
			x /= t1.x;
			y /= t1.y;
			z /= t1.z;
 
		return (T) this;
	}

	/**
	 * Get an element of this tuple by index
	 *
	 * @param i 0 for x, 1 for y, 2 for z
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
	public  T setElement(int i, float value) {
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
		return (T) this;
	}

	/**
	 * Set each element to the minimum of this or another tuple
	 *
	 * @param t1
	 * @return this for chaining
	 */
	public  T setMin(Tuple3f t1) {
		x = Math.min(x, t1.x);
		y = Math.min(y, t1.y);
		z = Math.min(z, t1.z);
		return (T) this;
	}

	/**
	 * Set each element to the minimum of of two tuples
	 *
	 * @param t1
	 * @param t2
	 * @return this for chaining
	 */
	public  T setMin(Tuple3f t1, Tuple3f t2) {
		x = Math.min(t1.x, t2.x);
		y = Math.min(t1.y, t2.y);
		z = Math.min(t1.z, t2.z);
		return (T) this;
	}

	/**
	 * Set each element to the maximum of this or another tuple
	 *
	 * @param t1
	 * @return this for chaining
	 */
	public  T setMax(Tuple3f t1) {
		x = Math.max(x, t1.x);
		y = Math.max(y, t1.y);
		z = Math.max(z, t1.z);
		return (T) this;
	}

	/**
	 * Set each element to the maximum of of two tuples
	 *
	 * @param t1
	 * @param t2
	 * @return this for chaining
	 */
	public  T setMax(Tuple3f t1, Tuple3f t2) {
		x = Math.max(t1.x, t2.x);
		y = Math.max(t1.y, t2.y);
		z = Math.max(t1.z, t2.z);
		return (T) this;
	}

	/**
	 * Set x,y,z of this vector to zero
	 *
	 * @return this for chaining
	 */
	public  T setZero() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
		return (T) this;
	}

	/**
	 * Sets this vector to be the vector cross product of vectors v1 and v2.
	 *
	 * @param v1 the first vector
	 * @param v2 the second vector
	 * @return
	 */
	public  T cross(Tuple3f v1, Tuple3f v2) {
 
			float tmp_x;
			float tmp_y;
			tmp_x = v1.y * v2.z - v1.z * v2.y;
			tmp_y = v2.x * v1.z - v2.z * v1.x;
			z = v1.x * v2.y - v1.y * v2.x;
			x = tmp_x;
			y = tmp_y;
 
		return (T) this;
	}

	/**
	 * Computes the cross product of this vector and v2 and stores the result in this
	 *
	 * @param v2 the second vector
	 * @return
	 */
	public  T cross(Tuple3f v2) {
		cross(this, v2);
		return (T) this;
	}

	/**
	 * Computes the dot product of this vector and vector v1.
	 *
	 * @param v1 the other vector
	 * @return the dot product of this vector and v1
	 */
	public float dot(Tuple3f v1) {
 
			return x * v1.x + y * v1.y + z * v1.z;
 
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
	 * Calculate the distance squared between this tuple and the argument
	 *
	 * @param t1
	 * @return
	 */
	public float distanceSquared(Tuple3f t1) {
 
			float dx = t1.x - x;
			float dy = t1.y - y;
			float dz = t1.z - z;
			return (dx * dx + dy * dy + dz * dz);
 
	}

	/**
	 * Calculate the distance between this tuple and the argument
	 *
	 * @param t1
	 * @return
	 */
	public float distance(Tuple3f t1) {
 
			return sqrt(distanceSquared(t1));
	 
	}

	/**
	 * Returns the squared length of this vector.
	 *
	 * @return the squared length of this vector
	 */
	public float lengthSquared() {
 
			return (x * x + y * y + z * z);
 
	}

	/**
	 * Get the minimum value among the three components (x,y,z)
	 *
	 * @return maximum value
	 */
	public float min() {
		return Math.min(Math.min(x, y), z);
	}

	/**
	 * Return the axis index of the component with the lowest value
	 *
	 * @return axis index
	 */
	public int minAxis() {
		if (x <= Math.min(y, z)) {
			return 0;
		} else if (y <= Math.min(x, z)) {
			return 1;
		} else {
			return 2;
		}
	}

	/**
	 * Get the maximum value among the first three components (x,y,z)
	 *
	 * @return maximum value
	 */
	public float max() {
		return Math.max(Math.max(x, y), z);
	}

	/**
	 * Return the axis index of the component with the highest value
	 *
	 * @return axis index
	 */
	public int maxAxis() {
		if (x >= Math.max(y, z)) {
			return 0;
		} else if (y >= Math.max(x, z)) {
			return 1;
		} else {
			return 2;
		}
	}

	/**
	 * Normalizes this vector in place.
	 *
	 * @return this for chaining
	 */
	public  T normalize() {
 
			float norm;
			norm = (1.0F / length());
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
	public  T normalize(Tuple3f v1) {
	 
			set(v1);
			normalize();
 
		return (T) this;
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
		hash = 29 * hash + Float.floatToIntBits(x);
		hash = 29 * hash + Float.floatToIntBits(y);
		hash = 29 * hash + Float.floatToIntBits(z);
		return hash;
	}

	/**
	 * Linear interpolate between two tuples and store the result in this tuple.
	 *
	 * @param t1
	 * @param t2
	 * @param t weight from t1 (0.0) to t2 (1.0)
	 * @return this for chaining
	 */
	public  T mix(Tuple3f t1, Tuple3f t2, float t) {
 
			x = t1.x * (1.0f - t) + t2.x * t;
			y = t1.y * (1.0f - t) + t2.y * t;
			z = t1.z * (1.0f - t) + t2.z * t;
 
		return (T) this;
	}

	/**
	 * Linear interpolate between this tuple and t1 then store the result in this.
	 *
	 * @param t1
	 * @param t weight from t1 (0.0) to t2 (1.0)
	 * @return this for chaining
	 */
	public  T mix(Tuple3f t1, float t) {
 
			x = x * (1.0f - t) + t1.x * t;
			y = y * (1.0f - t) + t1.y * t;
			z = z * (1.0f - t) + t1.z * t;
 
		return (T) this;
	}

	/**
	 * Promote this single precision tuple to a double precision single row matrix
	 *
	 * @return
	 */
	public Matrix promote() {
		return new Matrix(new double[][]{{x, y, z}});
	}

	/**
	 * Returns the angle in radians between this vector and the vector parameter; the return value is constrained to the range
	 * [0,PI].
	 *
	 * @param v1 the other vector
	 * @return the angle in radians in the range [0,PI]
	 */
	public float angle(Tuple3f v1) {
 
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
	public final   T inverse(Tuple3f q1) {
		set(q1);
		inverse();
		return (T)this;
	}

	/**
	 * Multiplies tuple t1 by the inverse of tuple t2 and places the value into this quaternion. The value of both argument
	 * quaternions is preservered (this = t1 * t2^-1).
	 *
	 * @param t1 the first quaternion
	 * @param t2 the second quaternion
	 * @return this for chaining
	 */
	public final  T mulInverse(Tuple3f t1, Tuple3f t2) {
		Vector3f temp = new Vector3f(t2);
		temp.inverse();
		mul(t1, temp);
		return (T) this;
	}

		/**
	 * Multiplies this tuple by the inverse of tuple t1 and places the value into this tuple. The value of the
	 * argument tuple is preserved (this = this * q^-1).
	 *
	 * @param t1 the other quaternion
	 * @return this for chaining
	 */
	public final   T  mulInverse(Tuple3f t1) {
		Vector3f temp = new Vector3f(t1);
		temp.inverse();
		mul(temp);
		return (T)this;
	}

}
