/*
 * $RCSfile: Quat4f.java,v $
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
 * $Revision: 1.6 $
 * $Date: 2008/02/28 20:18:50 $
 * $State: Exp $
 */
package javax.vecmath;

/**
 * A 4 element unit quaternion represented by single precision floating point x,y,z,w coordinates. The quaternion is
 * always normalized.
 *
 */
public class Quat4f extends Tuple4f implements java.io.Serializable {

	// Combatible with 1.1
	static final long serialVersionUID = 2675933778405442383L;

	final static float EPS = 0.00001f;
private final static int X = 0;
	private final static int Y = 1;
	private final static int Z = 2;
	private final static int[] NXT = new int[]{Y, Z, X};

	/**
	 * Constructs and initializes a Quat4f from the specified xyzw coordinates.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param z the z coordinate
	 * @param w the w scalar component
	 */
	public Quat4f(float x, float y, float z, float w) {
		float mag;
		mag = (float) (1.0 / Math.sqrt(x * x + y * y + z * z + w * w));
		this.x = x * mag;
		this.y = y * mag;
		this.z = z * mag;
		this.w = w * mag;

	}

	/**
	 * Constructs and initializes a Quat4f from the array of length 4.
	 *
	 * @param q the array of length 4 containing xyzw in order
	 */
	public Quat4f(float[] q) {
		float mag;
		mag = (float) (1.0 / Math.sqrt(q[0] * q[0] + q[1] * q[1] + q[2] * q[2] +
			q[3] * q[3]));
		x = q[0] * mag;
		y = q[1] * mag;
		z = q[2] * mag;
		w = q[3] * mag;

	}

	/**
	 * Constructs and initializes a Quat4f from the specified Quat4f.
	 *
	 * @param q1 the Quat4f containing the initialization x y z w data
	 */
	public Quat4f(Quat4f q1) {
		super(q1);
	}

	/**
	 * Constructs and initializes a Quat4f from the specified Tuple4f.
	 *
	 * @param t1 the Tuple4f containing the initialization x y z w data
	 */
	public Quat4f(Tuple4f t1) {
		float mag;
		mag = (float) (1.0 / Math.sqrt(t1.x * t1.x + t1.y * t1.y + t1.z * t1.z +
			t1.w * t1.w));
		x = t1.x * mag;
		y = t1.y * mag;
		z = t1.z * mag;
		w = t1.w * mag;

	}

	/**
	 * Constructs and initializes a Quat4f to (0.0,0.0,0.0,0.0).
	 */
	public Quat4f() {
		super();
	}

	/**
	 * Sets the value of this quaternion to the conjugate of quaternion q1.
	 *
	 * @param q1 the source vector
	 * @return this for chaining
	 */
	public final Quat4f conjugate(Quat4f q1) {
		this.x = -q1.x;
		this.y = -q1.y;
		this.z = -q1.z;
		this.w = q1.w;return this;
	}

	/**
	 * Sets the value of this quaternion to the conjugate of itself.
	 * @return  this for chaining
	 */
	public final Quat4f conjugate() {
		this.x = -this.x;
		this.y = -this.y;
		this.z = -this.z;return this;
	}

	/**
	 * Sets the value of this quaternion to the quaternion product of quaternions q1 and q2 (this = q1 * q2). Note that
	 * this is safe for aliasing (e.g. this can be q1 or q2).
	 *
	 * @param q1 the first quaternion
	 * @param q2 the second quaternion
	 * @return  this for chaining
	 */
	public final Quat4f mul(Quat4f q1, Quat4f q2) {
		if (this != q1 && this != q2) {
			this.w = q1.w * q2.w - q1.x * q2.x - q1.y * q2.y - q1.z * q2.z;
			this.x = q1.w * q2.x + q2.w * q1.x + q1.y * q2.z - q1.z * q2.y;
			this.y = q1.w * q2.y + q2.w * q1.y - q1.x * q2.z + q1.z * q2.x;
			this.z = q1.w * q2.z + q2.w * q1.z + q1.x * q2.y - q1.y * q2.x;
		} else {
			float tmp_x, tmp_y, temp_w;

			temp_w = q1.w * q2.w - q1.x * q2.x - q1.y * q2.y - q1.z * q2.z;
			tmp_x = q1.w * q2.x + q2.w * q1.x + q1.y * q2.z - q1.z * q2.y;
			tmp_y = q1.w * q2.y + q2.w * q1.y - q1.x * q2.z + q1.z * q2.x;
			this.z = q1.w * q2.z + q2.w * q1.z + q1.x * q2.y - q1.y * q2.x;
			this.w = temp_w;
			this.x = tmp_x;
			this.y = tmp_y;
		}return this;
	}

	/**
	 * Sets the value of this quaternion to the quaternion product of itself and q1 (this = this * q1).
	 *
	 * @param q1 the other quaternion
	 * @return  this for chaining
	 */
	public final Quat4f mul(Quat4f q1) {
		float tmp_x, temp_y, temp_w;

		temp_w = this.w * q1.w - this.x * q1.x - this.y * q1.y - this.z * q1.z;
		tmp_x = this.w * q1.x + q1.w * this.x + this.y * q1.z - this.z * q1.y;
		temp_y = this.w * q1.y + q1.w * this.y - this.x * q1.z + this.z * q1.x;
		this.z = this.w * q1.z + q1.w * this.z + this.x * q1.y - this.y * q1.x;
		this.w = temp_w;
		this.x = tmp_x;
		this.y = temp_y;return this;
	}

	/**
	 * Compute the dot product with another quaternion.
	 *
	 * @param q1
	 * @return the dot product
	 */
	public final float dot(Quat4f q1) {
		return (this.x * q1.x) + (this.y * q1.y) + (this.z * q1.z) + (this.w * q1.w);
	}

	/**
	 * Multiplies quaternion q1 by the inverse of quaternion q2 and places the value into this quaternion. The value of
	 * both argument quaternions is preservered (this = q1 * q2^-1).
	 *
	 * @param q1 the first quaternion
	 * @param q2 the second quaternion
	 * @return  this for chaining
	 */
	public final Quat4f mulInverse(Quat4f q1, Quat4f q2) {
		Quat4f tempQuat = new Quat4f(q2);

		tempQuat.inverse();
		this.mul(q1, tempQuat);return this;
	}

	/**
	 * Multiplies this quaternion by the inverse of quaternion q1 and places the value into this quaternion. The value of
	 * the argument quaternion is preserved (this = this * q^-1).
	 *
	 * @param q1 the other quaternion
	 * @return  this for chaining
	 */
	public final Quat4f mulInverse(Quat4f q1) {
		Quat4f tempQuat = new Quat4f(q1);

		tempQuat.inverse();
		this.mul(tempQuat);return this;
	}

	/**
	 * Sets the value of this quaternion to quaternion inverse of quaternion q1.
	 *
	 * @param q1 the quaternion to be inverted
	 * @return  this for chaining
	 */
	public final Quat4f inverse(Quat4f q1) {
		float norm;

		norm = 1.0f / (q1.w * q1.w + q1.x * q1.x + q1.y * q1.y + q1.z * q1.z);
		this.w = norm * q1.w;
		this.x = -norm * q1.x;
		this.y = -norm * q1.y;
		this.z = -norm * q1.z;return this;
	}

	/**
	 * Sets the value of this quaternion to the quaternion inverse of itself.
	 * @return  this for chaining
	 */
	public final Quat4f inverse() {
		float norm;

		norm = 1.0f / (this.w * this.w + this.x * this.x + this.y * this.y + this.z *
			this.z);
		this.w *= norm;
		this.x *= -norm;
		this.y *= -norm;
		this.z *= -norm;return this;
	}

	/**
	 * Sets the value of this quaternion to the normalized value of quaternion q1.
	 *
	 * @param q1 the quaternion to be normalized.
	 * @return  this for chaining
	 */
	public final Quat4f normalize(Quat4f q1) {
		float norm;

		norm = (q1.x * q1.x + q1.y * q1.y + q1.z * q1.z + q1.w * q1.w);

		if (norm > 0.0f) {
			norm = 1.0f / (float) Math.sqrt(norm);
			this.x = norm * q1.x;
			this.y = norm * q1.y;
			this.z = norm * q1.z;
			this.w = norm * q1.w;
		} else {
			this.x = (float) 0.0;
			this.y = (float) 0.0;
			this.z = (float) 0.0;
			this.w = (float) 0.0;
		}return this;
	}

	/**
	 * Normalizes the value of this quaternion in place.
	 * @return  this for chaining
	 */
	public final Quat4f normalize() {
		float norm;

		norm = (this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);

		if (norm > 0.0f) {
			norm = 1.0f / (float) Math.sqrt(norm);
			this.x *= norm;
			this.y *= norm;
			this.z *= norm;
			this.w *= norm;
		} else {
			this.x = (float) 0.0;
			this.y = (float) 0.0;
			this.z = (float) 0.0;
			this.w = (float) 0.0;
		}
		return this;
	}

	
	/**
	 * Sets the value of this quaternion to the rotational component of the passed matrix.
	 *
	 * @param m1 the Matrix4f
	 * @return this for chaining
	 */
	public final Quat4f set(Matrix4f m1) {
		/*
		 * From Watt & Watt Advanced Animation and Rendering Techniques pp. 363-364
		 *
		 */
		float tr, s;
		int i, j, k;

		tr = m1.m00 + m1.m11 + m1.m22;
		if (tr > 0.0f) {
			s = (float) Math.sqrt(tr + 1.0f);
			this.w = s * 0.5f;
			s = 0.5f / s;
			this.x = (m1.m12 - m1.m21) * s;
			this.y = (m1.m20 - m1.m02) * s;
			this.z = (m1.m01 - m1.m10) * s;
		} else {
			i = X;
			if (m1.m11 > m1.m00) {
				i = Y;
			}
			if (m1.m22 > m1.getElement(i, i)) {
				i = Z;
			}
			j = NXT[i];
			k = NXT[j];
			s = (float) Math.sqrt(m1.getElement(i, i) - (m1.getElement(j, j) + m1.getElement(k, k)) + 1.0f);
			this.setElement(i, s * 0.5f);
			s = 0.5f / s;
			this.w = (m1.getElement(j, k) - m1.getElement(k, j)) * s;
			this.setElement(j, (m1.getElement(i, j) + m1.getElement(j, i)) * s);
			this.setElement(k, (m1.getElement(i, k) + m1.getElement(k, i)) * s);
		}return this;
	}

	/**
	 *
	 * @param i
	 * @param f
	 * @return this for chaining
	 */
	public final Quat4f setElement(int i, float f) {
		switch (i) {
			case 0:
				x = f;
				break;
			case 1:
				y = f;
				break;
			case 2:
				z = f;
				break;
			case 3:
				w = f;
				break;
			default:
				throw new IndexOutOfBoundsException();
		}return this;
	}

	/**
	 *
	 * @param i
	 * @return the element value
	 */
	public final float getElement(int i) {
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
	 * Sets the value of this quaternion to the rotational component of the passed matrix.
	 *
	 * @param m1 the Matrix3f
	 * @return this for chaining
	 */
	public final Quat4f set(Matrix3f m1) {
				/*
		 * From Watt & Watt Advanced Animation and Rendering Techniques pp. 363-364
		 *
		 */
		float tr, s;
		int i, j, k;

		tr = m1.m00 + m1.m11 + m1.m22;
		if (tr > 0.0f) {
			s = (float) Math.sqrt(tr + 1.0f);
			this.w = s * 0.5f;
			s = 0.5f / s;
			this.x = (m1.m12 - m1.m21) * s;
			this.y = (m1.m20 - m1.m02) * s;
			this.z = (m1.m01 - m1.m10) * s;
		} else {
			i = X;
			if (m1.m11 > m1.m00) {
				i = Y;
			}
			if (m1.m22 > m1.getElement(i, i)) {
				i = Z;
			}
			j = NXT[i];
			k = NXT[j];
			s = (float) Math.sqrt(m1.getElement(i, i) - (m1.getElement(j, j) + m1.getElement(k, k)) + 1.0f);
			this.setElement(i, s * 0.5f);
			s = 0.5f / s;
			this.w = (m1.getElement(j, k) - m1.getElement(k, j)) * s;
			this.setElement(j, (m1.getElement(i, j) + m1.getElement(j, i)) * s);
			this.setElement(k, (m1.getElement(i, k) + m1.getElement(k, i)) * s);
		}
return this;
	}

	/**
	 * Sets the value of this quaternion to the equivalent rotation of the AxisAngle argument.
	 *
	 * @param a the AxisAngle to be emulated
	 * @return  this for chaining
	 */
	public final Quat4f set(AxisAngle4f a) {
		float mag, amag;
		// Quat = cos(theta/2) + sin(theta/2)(roation_axis) 
		amag = (float) Math.sqrt(a.x * a.x + a.y * a.y + a.z * a.z);
		if (amag < EPS) {
			w = 0.0f;
			x = 0.0f;
			y = 0.0f;
			z = 0.0f;
		} else {
			amag = 1.0f / amag;
			mag = (float) Math.sin(a.angle / 2.0);
			w = (float) Math.cos(a.angle / 2.0);
			x = a.x * amag * mag;
			y = a.y * amag * mag;
			z = a.z * amag * mag;
		}return this;
	}

	/**
	 * Performs a great circle interpolation between this quaternion and the quaternion parameter and places the result
	 * into this quaternion.
	 *
	 * @param q1 the other quaternion
	 * @param alpha the alpha interpolation parameter
	 * @return  this for chaining
	 */
	public final Quat4f interpolate(Quat4f q1, float alpha) {
		Quat4f q = new Quat4f(this);
		interpolate(q, q1, alpha);return this;
	}

	/**
	 * Performs a great circle interpolation between quaternion q1 and quaternion q2 and places the result into this
	 * quaternion.
	 *
	 * @param q1 the first quaternion
	 * @param q2 the second quaternion
	 * @param alpha the alpha interpolation parameter
	 * @return  this for chaining
	 */
	public final Quat4f interpolate(Quat4f q1, Quat4f q2, float alpha) {
		/*
		 * From Watt & Watt Advanced Animation and Rendering Techniques pp. 363-364
		 *
		 */

		float omega, cosom, sinom, sclp, sclq;
		int i;

		cosom = q1.dot(q2);

		if ((1.0f + cosom) > EPS) {
			if ((1.0f - cosom) > EPS) {
				omega = (float) Math.acos(cosom);
				sinom = (float) Math.sin(omega);
				sclp = (float) Math.sin((1.0f - alpha) * omega) / sinom;
				sclq = (float) Math.sin(alpha * omega) / sinom;
			} else {
				sclp = 1.0f - alpha;
				sclq = alpha;
			}
			for (i = 0; i < 4; ++i) {
				this.setElement(i, (sclp * q1.getElement(i)) + (sclq * q2.getElement(i)));
			}

		} else {
			this.x = -q1.y;
			this.y = q1.x;
			this.z = -q1.w;
			this.w = q1.z;
			sclp = (float) Math.sin(1.0f - alpha) * ((float) Math.PI / 2.0f);
			sclq = (float) Math.sin(alpha * ((float) Math.PI / 2.0f));
			for (i = 0; i < 3; ++i) {
				this.setElement(i, (sclp * q1.getElement(i)) + (sclq * this.getElement(i)));
			}
		}return this;
	}

}
