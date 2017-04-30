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

import static javax.vecmath.VecMath.PI;
import static javax.vecmath.VecMath.acos;
import static javax.vecmath.VecMath.cos;
import static javax.vecmath.VecMath.sin;
import static javax.vecmath.VecMath.sqrt;

/**
 * A 4 element unit quaternion represented by single precision floating point x,y,z,w coordinates. The quaternion is always
 * normalized.
 *
 */
public class Quat4f<T extends Quat4f> extends Tuple4f<T> implements java.io.Serializable {

	// Combatible with 1.1
	static final long serialVersionUID = 2675933778405442383L;

	final static float EPS = 0.0001f;
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
		super(x, y, z, w);
		normalize();
	}

	/**
	 * Constructs and initializes a Quat4f from the array of length 4.
	 *
	 * @param q the array of length 4 containing xyzw in order
	 */
	public Quat4f(float[] q) {
		super(q);
		normalize();
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
	 * Constructs and initializes a Quat4f to (0.0,0.0,0.0,0.0).
	 */
	public Quat4f() {

	}

	/**
	 * Sets the value of this quaternion to the conjugate of quaternion q1.
	 *
	 * @param <T>
	 * @param q1 the source vector
	 * @return this for chaining
	 */
	public T conjugate(Quat4f q1) {
		set(-q1.x, -q1.y, -q1.z, q1.w);
		return (T) this;
	}

	/**
	 * Sets the value of this quaternion to the conjugate of itself.
	 *
	 * @param <T>
	 * @return this for chaining
	 */
	public T conjugate() {
		set(-x, -y, -z, w);
		return (T) this;
	}

	/**
	 * Sets the value of this quaternion to the quaternion product of quaternions q1 and q2 (this = q1 * q2). Note that this is safe
	 * for aliasing (e.g. this can be q1 or q2).
	 *
	 * @param <T>
	 * @param q1 the first quaternion
	 * @param q2 the second quaternion
	 * @return this for chaining
	 */
	public T mul(Quat4f q1, Quat4f q2) {
		float nw = q1.w * q2.w - q1.x * q2.x - q1.y * q2.y - q1.z * q2.z;
		float nx = q1.w * q2.x + q2.w * q1.x + q1.y * q2.z - q1.z * q2.y;
		float ny = q1.w * q2.y + q2.w * q1.y - q1.x * q2.z + q1.z * q2.x;
		z = q1.w * q2.z + q2.w * q1.z + q1.x * q2.y - q1.y * q2.x;
		w = nw;
		x = nx;
		y = ny;
		return (T) this;
	}

	/**
	 * Sets the value of this quaternion to the quaternion product of itself and q1 (this = this * q1).
	 *
	 * @param <T>
	 * @param q1 the other quaternion
	 * @return this for chaining
	 */
	public T mul(Quat4f q1) {

		float nw = w * q1.w - x * q1.x - y * q1.y - z * q1.z;
		float nx = w * q1.x + q1.w * x + y * q1.z - z * q1.y;
		float ny = w * q1.y + q1.w * y - x * q1.z + z * q1.x;
		z = w * q1.z + q1.w * z + x * q1.y - y * q1.x;
		w = nw;
		x = nx;
		y = ny;
		return (T) this;
	}

	/**
	 * Sets the value of this quaternion to the rotational component of the passed matrix.
	 *
	 * @param <T>
	 * @param m1 the Matrix4f
	 * @return this for chaining
	 */
	public T set(Matrix4f m1) {
		set(new Matrix3f(m1));
		return (T) this;
	}

	/**
	 * Sets the value of this quaternion to the rotational component of the passed matrix.
	 *
	 * @param <T>
	 * @param m1 the Matrix3f
	 * @return this for chaining
	 */
	public T set(Matrix3f m1) {
		/*
		 * From Watt & Watt Advanced Animation and Rendering Techniques pp. 363-364
		 *
		 */
		float tr, s;
		int i, j, k;

		tr = m1.m00 + m1.m11 + m1.m22;
		if (tr > 0.0f) {
			s = sqrt(tr + 1.0f);
			this.w = s * 0.5f;
			s = 0.5f / s;
			x = (m1.m21 - m1.m12) * s;
			y = (m1.m02 - m1.m20) * s;
			z = (m1.m10 - m1.m01) * s;
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
			s = sqrt(m1.getElement(i, i) - (m1.getElement(j, j) + m1.getElement(k, k)) + 1.0f);
			setElement(i, s * 0.5f);
			s = 0.5f / s;
			w = (m1.getElement(k, j) - m1.getElement(j, k)) * s;
			setElement(j, (m1.getElement(j, i) + m1.getElement(i, j)) * s);
			setElement(k, (m1.getElement(k, i) + m1.getElement(i, k)) * s);
		}
		return (T) this;
	}

	/**
	 * Sets the value of this quaternion to the equivalent rotation of the AxisAngle argument.
	 *
	 * @param <T>
	 * @param a the AxisAngle to be emulated
	 * @return this for chaining
	 */
	public T set(AxisAngle4f a) {
		float mag, amag;
		// Quat = cos(theta/2) + sin(theta/2)(roation_axis) 
		amag = sqrt(a.x * a.x + a.y * a.y + a.z * a.z);

		amag = 1.0f / amag;
		mag = amag*sin(a.angle / 2.0f);
		w = cos(a.angle / 2.0f);
		x = a.x * mag;
		y = a.y *  mag;
		z = a.z * mag;

		return (T) this;
	}

	/**
	 * Performs a great circle interpolation between this quaternion and the quaternion parameter and places the result into this
	 * quaternion.
	 *
	 * @param <T>
	 * @param q1 the other quaternion
	 * @param alpha the alpha interpolation parameter
	 * @return this for chaining
	 */
	public T slerp(Quat4f q1, float alpha) {
		slerp(this, q1, alpha);
		return (T) this;
	}

	/**
	 * Performs a great circle interpolation between quaternion q1 and quaternion q2 and places the result into this quaternion.
	 *
	 * @param <T>
	 * @param q1 the first quaternion
	 * @param q2 the second quaternion
	 * @param alpha the alpha interpolation parameter
	 * @return this for chaining
	 */
	public T slerp(Quat4f q1, Quat4f q2, float alpha) {
		/*
		 * From Watt & Watt Advanced Animation and Rendering Techniques pp. 363-364
		 *
		 */

		float omega, cosom, sinom, sclp, sclq;
		int i;

		cosom = q1.dot(q2);

		if ((1.0f + cosom) > EPS) {
			if ((1.0f - cosom) > EPS) {
				omega = acos(cosom);
				sinom = sin(omega);
				sclp = sin((1.0f - alpha) * omega) / sinom;
				sclq = sin(alpha * omega) / sinom;
			} else {
				sclp = 1.0f - alpha;
				sclq = alpha;
			}
			x = (sclp * q1.x) + (sclq * q2.x);
			y = (sclp * q1.y) + (sclq * q2.y);
			z = (sclp * q1.z) + (sclq * q2.z);
			w = (sclp * q1.w) + (sclq * q2.w);

		} else {
			sclp = sin(1.0f - alpha) * (PI / 2.0f);
			sclq = sin(alpha * (PI / 2.0f));
			float nx = -q1.y;
			float ny = q1.x;
			float nz = -q1.w;
			w = q1.z;
			x = (sclp * q1.x) + (sclq * nx);
			y = (sclp * q1.y) + (sclq * ny);
			z = (sclp * q1.z) + (sclq * nz);

		}
		return (T) this;
	}

}
