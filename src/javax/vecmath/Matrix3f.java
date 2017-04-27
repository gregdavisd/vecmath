/*
 * $RCSfile: Matrix3f.java,v $
 *
 * Copyright 1996-2008 Sun Microsystems, Inc.  All Rights Reserved.
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
 * $Date: 2008/02/28 20:18:50 $
 * $State: Exp $
 */
package javax.vecmath;

import static javax.vecmath.VecMath.cos;
import static javax.vecmath.VecMath.different_epsilon;
import static javax.vecmath.VecMath.sin;
import static javax.vecmath.VecMath.sqrt;

/**
 * A single precision floating point 3 by 3 matrix. Primarily to support 3D rotations.
 *
 * @param <T>
 */
public class Matrix3f<T extends Matrix3f> implements java.io.Serializable, Cloneable {

	// Compatible with 1.1
	static final long serialVersionUID = 329697160112089834L;

	/**
	 * The first matrix element in the first row.
	 */
	public float m00;

	/**
	 * The second matrix element in the first row.
	 */
	public float m01;

	/**
	 * The third matrix element in the first row.
	 */
	public float m02;

	/**
	 * The first matrix element in the second row.
	 */
	public float m10;

	/**
	 * The second matrix element in the second row.
	 */
	public float m11;

	/**
	 * The third matrix element in the second row.
	 */
	public float m12;

	/**
	 * The first matrix element in the third row.
	 */
	public float m20;

	/**
	 * The second matrix element in the third row.
	 */
	public float m21;

	/**
	 * The third matrix element in the third row.
	 */
	public float m22;

	private static final float EPS = 1.0E-8f;

	/**
	 * Constructs and initializes a Matrix3f from the specified nine values.
	 *
	 * @param m00 the [0][0] element
	 * @param m01 the [0][1] element
	 * @param m02 the [0][2] element
	 * @param m10 the [1][0] element
	 * @param m11 the [1][1] element
	 * @param m12 the [1][2] element
	 * @param m20 the [2][0] element
	 * @param m21 the [2][1] element
	 * @param m22 the [2][2] element
	 */
	public Matrix3f(float m00, float m01, float m02,
		float m10, float m11, float m12,
		float m20, float m21, float m22) {
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;

		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;

		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;

	}

	/**
	 * Constructs and initializes a Matrix3f from the specified nine-element array. this.m00 =v[0], this.m01=v[1], etc.
	 *
	 * @param v the array of length 9 containing in column order
	 */
	public Matrix3f(float[] v) {
		m00 = v[0];
		m01 = v[1];
		m02 = v[2];

		m10 = v[3];
		m11 = v[4];
		m12 = v[5];

		m20 = v[6];
		m21 = v[7];
		m22 = v[8];

	}

	/**
	 * Constructs a new matrix with the same values as the Matrix3f parameter.
	 *
	 * @param m1 the source matrix
	 */
	public Matrix3f(Matrix3f m1) {
		m00 = m1.m00;
		m01 = m1.m01;
		m02 = m1.m02;

		m10 = m1.m10;
		m11 = m1.m11;
		m12 = m1.m12;

		m20 = m1.m20;
		m21 = m1.m21;
		m22 = m1.m22;

	}

	/**
	 * Constructor that copies the 3x3 rotation/scale part of a 4x4 matrix..
	 *
	 * @param m1 the source matrix
	 */
	public Matrix3f(Matrix4f m1) {
		m00 = m1.m00;
		m01 = m1.m01;
		m02 = m1.m02;

		m10 = m1.m10;
		m11 = m1.m11;
		m12 = m1.m12;

		m20 = m1.m20;
		m21 = m1.m21;
		m22 = m1.m22;
	}

	/**
	 * Constructs and initializes a Matrix3f to all zeros.
	 */
	public Matrix3f() {

	}

	/**
	 * Returns a string that contains the values of this Matrix3f.
	 *
	 * @return the String representation
	 */
	@Override
	public String toString() {
		return m00 + ", " + m01 + ", " + m02 + "\n"
			+ m10 + ", " + m11 + ", " + m12 + "\n"
			+ m20 + ", " + m21 + ", " + m22;
	}

	/**
	 * Sets this matrix to identity.
	 *
	 * @return this for chaining
	 */
	public T setIdentity() {
		m00 = 1.0f;
		m01 = 0.0f;
		m02 = 0.0f;

		m10 = 0.0f;
		m11 = 1.0f;
		m12 = 0.0f;

		m20 = 0.0f;
		m21 = 0.0f;
		m22 = 1.0f;
		return (T) this;
	}

	/**
	 * Sets the scale component of the current matrix by factoring out the current scale (by doing an SVD) and multiplying by the new
	 * scale.
	 *
	 * @param scale the new scale amount
	 * @return this for chaining
	 */
	public final T setScale(float scale) {

		Matrix3f rotate = new Matrix3f();
		getScaleRotate(this, new Vector3f(), rotate);

		m00 = rotate.m00 * scale;
		m01 = rotate.m01 * scale;
		m02 = rotate.m02 * scale;

		m10 = rotate.m10 * scale;
		m11 = rotate.m11 * scale;
		m12 = rotate.m12 * scale;

		m20 = rotate.m20 * scale;
		m21 = rotate.m21 * scale;
		m22 = rotate.m22 * scale;
		return (T) this;
	}

	/**
	 * Sets the scale component of the current matrix by factoring out the current scale (by doing an SVD) and multiplying by the new
	 * scale.
	 *
	 * @param x scale component
	 * @param y scale component
	 * @param z scale component
	 * @return this for chaining
	 */
	public final T setScale(float x, float y, float z) {

		Matrix3f rotate = new Matrix3f();
		Tuple3f scale = new Vector3f();
		getScaleRotate(this, scale, rotate);

		m00 = rotate.m00 * x;
		m01 = rotate.m01 * x;
		m02 = rotate.m02 * x;

		m10 = rotate.m10 * y;
		m11 = rotate.m11 * y;
		m12 = rotate.m12 * y;

		m20 = rotate.m20 * z;
		m21 = rotate.m21 * z;
		m22 = rotate.m22 * z;
		return (T) this;
	}

	/**
	 * Sets the specified element of this matrix to the value provided.
	 *
	 * @param row the row number to be modified (zero indexed)
	 * @param column the column number to be modified (zero indexed)
	 * @param value the new value
	 * @return this for chaining
	 */
	public final T setElement(int row, int column, float value) {
		final int i = (row * 3) + column;
		switch (i) {
			case 0:
				m00 = value;
				break;
			case 1:
				m01 = value;
				break;
			case 2:
				m02 = value;
				break;
			case 3:
				m10 = value;
				break;
			case 4:
				m11 = value;
				break;
			case 5:
				m12 = value;
				break;
			case 6:
				m20 = value;
				break;
			case 7:
				m21 = value;
				break;
			case 8:
				m22 = value;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return (T) this;
	}

	/**
	 * Copies the matrix values in the specified row into the vector parameter.
	 *
	 * @param <S>
	 * @param row the matrix row
	 * @param v the vector into which the matrix row values will be copied
	 * @return v for chaining
	 */
	public final <S extends Tuple3f> S getRow(int row, S v) {
		switch (row) {
			case 0:
				v.x = m00;
				v.y = m01;
				v.z = m02;
				break;
			case 1:
				v.x = m10;
				v.y = m11;
				v.z = m12;
				break;
			case 2:
				v.x = m20;
				v.y = m21;
				v.z = m22;
				break;
			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return v;
	}

	/**
	 * Copies the matrix values in the specified row into the array parameter.
	 *
	 * @param row the matrix row
	 * @param v the array into which the matrix row values will be copied
	 * @return v for chaining
	 */
	public final float[] getRow(int row, float v[]) {
		switch (row) {
			case 0:
				v[0] = m00;
				v[1] = m01;
				v[2] = m02;
				break;
			case 1:
				v[0] = m10;
				v[1] = m11;
				v[2] = m12;
				break;
			case 2:
				v[0] = m20;
				v[1] = m21;
				v[2] = m22;
				break;
			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return v;
	}

	/**
	 * Copies the matrix values in the specified column into the vector parameter.
	 *
	 * @param <S>
	 * @param column the matrix column
	 * @param v the vector into which the matrix row values will be copied
	 * @return v for chaining
	 */
	public final <S extends Tuple3f> S getColumn(int column, S v) {
		switch (column) {
			case 0:
				v.x = m00;
				v.y = m10;
				v.z = m20;
				break;
			case 1:
				v.x = m01;
				v.y = m11;
				v.z = m21;
				break;
			case 2:
				v.x = m02;
				v.y = m12;
				v.z = m22;
				break;
			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return v;
	}

	/**
	 * Copies the matrix values in the specified column into the array parameter.
	 *
	 * @param column the matrix column
	 * @param v the array into which the matrix row values will be copied
	 * @return v for chaining
	 */
	public final float[] getColumn(int column, float v[]) {
		switch (column) {
			case 0:
				v[0] = m00;
				v[1] = m10;
				v[2] = m20;
				break;
			case 1:
				v[0] = m01;
				v[1] = m11;
				v[2] = m21;
				break;
			case 2:
				v[0] = m02;
				v[1] = m12;
				v[2] = m22;
				break;
			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return v;
	}

	/**
	 * Retrieves the value at the specified row and column of this matrix.
	 *
	 * @param row the row number to be retrieved (zero indexed)
	 * @param column the column number to be retrieved (zero indexed)
	 * @return the value at the indexed element.
	 */
	public final float getElement(int row, int column) {
		final int i = (row * 3) + column;
		switch (i) {
			case 0:
				return (m00);
			case 1:
				return (m01);
			case 2:
				return (m02);
			case 3:
				return (m10);
			case 4:
				return (m11);
			case 5:
				return (m12);
			case 6:
				return (m20);
			case 7:
				return (m21);
			case 8:
				return (m22);
			default:
				throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * Sets the specified row of this matrix3f to the three values provided.
	 *
	 * @param row the row number to be modified (zero indexed)
	 * @param x the first column element
	 * @param y the second column element
	 * @param z the third column element
	 * @return this for chaining
	 */
	public final T setRow(int row, float x, float y, float z) {
		switch (row) {
			case 0:
				m00 = x;
				m01 = y;
				m02 = z;
				break;

			case 1:
				m10 = x;
				m11 = y;
				m12 = z;
				break;

			case 2:
				m20 = x;
				m21 = y;
				m22 = z;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return (T) this;
	}

	/**
	 * Sets the specified row of this matrix3f to the Vector provided.
	 *
	 * @param row the row number to be modified (zero indexed)
	 * @param v the replacement row
	 * @return this for chaining
	 */
	public final T setRow(int row, Tuple3f v) {
		switch (row) {
			case 0:
				m00 = v.x;
				m01 = v.y;
				m02 = v.z;
				break;

			case 1:
				m10 = v.x;
				m11 = v.y;
				m12 = v.z;
				break;

			case 2:
				m20 = v.x;
				m21 = v.y;
				m22 = v.z;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return (T) this;
	}

	/**
	 * Sets the specified row of this matrix3f to the three values provided.
	 *
	 * @param row the row number to be modified (zero indexed)
	 * @param v the replacement row
	 * @return this for chaining
	 */
	public final T setRow(int row, float v[]) {
		switch (row) {
			case 0:
				m00 = v[0];
				m01 = v[1];
				m02 = v[2];
				break;

			case 1:
				m10 = v[0];
				m11 = v[1];
				m12 = v[2];
				break;

			case 2:
				m20 = v[0];
				m21 = v[1];
				m22 = v[2];
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return (T) this;
	}

	/**
	 * Sets the specified column of this matrix3f to the three values provided.
	 *
	 * @param column the column number to be modified (zero indexed)
	 * @param x the first row element
	 * @param y the second row element
	 * @param z the third row element
	 * @return this for chaining
	 */
	public final T setColumn(int column, float x, float y, float z) {
		switch (column) {
			case 0:
				m00 = x;
				m10 = y;
				m20 = z;
				break;

			case 1:
				m01 = x;
				m11 = y;
				m21 = z;
				break;

			case 2:
				m02 = x;
				m12 = y;
				m22 = z;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return (T) this;
	}

	/**
	 * Sets the specified column of this matrix3f to the vector provided.
	 *
	 * @param column the column number to be modified (zero indexed)
	 * @param v the replacement column
	 * @return this for chaining
	 */
	public final T setColumn(int column, Tuple3f v) {
		switch (column) {
			case 0:
				m00 = v.x;
				m10 = v.y;
				m20 = v.z;
				break;

			case 1:
				m01 = v.x;
				m11 = v.y;
				m21 = v.z;
				break;

			case 2:
				m02 = v.x;
				m12 = v.y;
				m22 = v.z;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return (T) this;
	}

	/**
	 * Sets the specified column of this matrix3f to the three values provided.
	 *
	 * @param column the column number to be modified (zero indexed)
	 * @param v the replacement column
	 * @return this for chaining
	 */
	public final T setColumn(int column, float v[]) {
		switch (column) {
			case 0:
				m00 = v[0];
				m10 = v[1];
				m20 = v[2];
				break;

			case 1:
				m01 = v[0];
				m11 = v[1];
				m21 = v[2];
				break;

			case 2:
				m02 = v[0];
				m12 = v[1];
				m22 = v[2];
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return (T) this;
	}

	/**
	 * Performs an SVD normalization of this matrix to calculate and return the uniform scale factor. If the matrix has non-uniform
	 * scale factors, the largest of the x, y, and z scale factors will be returned. This matrix is not modified.
	 *
	 * @return the scale factor of this matrix
	 */
	public final float getScale() {
		Vector3f scale = new Vector3f();
		getScale(this, scale);
		return scale.max();
	}

	/**
	 * Performs an SVD normalization of this matrix to calculate and return the non-uniform scale factor in a tuple.
	 *
	 *
	 * @param <S>
	 * @param scale tuple to store the non-uniform scale
	 * @return this for chaining
	 */
	public final <S extends Tuple3f> S getScale(S scale) {
		getScale(this, scale);
		return scale;
	}

	/**
	 * Adds a scalar to each component of this matrix.
	 *
	 * @param scalar the scalar adder
	 * @return this for chaining
	 */
	public final T add(float scalar) {
		m00 += scalar;
		m01 += scalar;
		m02 += scalar;
		m10 += scalar;
		m11 += scalar;
		m12 += scalar;
		m20 += scalar;
		m21 += scalar;
		m22 += scalar;
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to the matrix sum of matrices m1 and m2.
	 *
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * @return this for chaining
	 */
	public final T add(Matrix3f m1, Matrix3f m2) {
		m00 = m1.m00 + m2.m00;
		m01 = m1.m01 + m2.m01;
		m02 = m1.m02 + m2.m02;

		m10 = m1.m10 + m2.m10;
		m11 = m1.m11 + m2.m11;
		m12 = m1.m12 + m2.m12;

		m20 = m1.m20 + m2.m20;
		m21 = m1.m21 + m2.m21;
		m22 = m1.m22 + m2.m22;
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to the matrix sum of itself and matrix m1.
	 *
	 * @param m1 the other matrix
	 * @return this for chaining
	 */
	public final T add(Matrix3f m1) {
		m00 += m1.m00;
		m01 += m1.m01;
		m02 += m1.m02;

		m10 += m1.m10;
		m11 += m1.m11;
		m12 += m1.m12;

		m20 += m1.m20;
		m21 += m1.m21;
		m22 += m1.m22;
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to the matrix difference of matrices m1 and m2.
	 *
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * @return this for chaining
	 */
	public final T sub(Matrix3f m1, Matrix3f m2) {
		m00 = m1.m00 - m2.m00;
		m01 = m1.m01 - m2.m01;
		m02 = m1.m02 - m2.m02;

		m10 = m1.m10 - m2.m10;
		m11 = m1.m11 - m2.m11;
		m12 = m1.m12 - m2.m12;

		m20 = m1.m20 - m2.m20;
		m21 = m1.m21 - m2.m21;
		m22 = m1.m22 - m2.m22;
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to the matrix difference of itself and matrix m1 (this = this - m1).
	 *
	 * @param m1 the other matrix
	 * @return this for chaining
	 */
	public final T sub(Matrix3f m1) {
		m00 -= m1.m00;
		m01 -= m1.m01;
		m02 -= m1.m02;

		m10 -= m1.m10;
		m11 -= m1.m11;
		m12 -= m1.m12;

		m20 -= m1.m20;
		m21 -= m1.m21;
		m22 -= m1.m22;
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to its transpose.
	 *
	 * @return this for chaining
	 */
	public final T transpose() {
		float temp;

		temp = m10;
		m10 = m01;
		m01 = temp;

		temp = m20;
		m20 = m02;
		m02 = temp;

		temp = m21;
		m21 = m12;
		m12 = temp;
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to the transpose of the argument matrix.
	 *
	 * @param m1 the matrix to be transposed
	 * @return this for chaining
	 */
	public final T transpose(Matrix3f m1) {
		if (this != m1) {
			m00 = m1.m00;
			m01 = m1.m10;
			m02 = m1.m20;

			m10 = m1.m01;
			m11 = m1.m11;
			m12 = m1.m21;

			m20 = m1.m02;
			m21 = m1.m12;
			m22 = m1.m22;
		} else {
			transpose();
		}
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to the matrix conversion of the (single precision) quaternion argument.
	 *
	 * @param q1 the quaternion to be converted
	 * @return this for chaining
	 */
	public final T set(Quat4f q1) {
		/*
		 * From Watt & Watt Advanced Animation and Rendering Techniques pp. 363
		 *
		 */

		float s, xs, ys, zs, wx, wy, wz, xx, xy, xz, yy, yz, zz;

		s = 2.0f / ((q1.x * q1.x) + (q1.y * q1.y) + (q1.z * q1.z) + (q1.w * q1.w));
		xs = q1.x * s;
		ys = q1.y * s;
		zs = q1.z * s;
		wx = q1.w * xs;
		wy = q1.w * ys;
		wz = q1.w * zs;
		xx = q1.x * xs;
		xy = q1.x * ys;
		xz = q1.x * zs;
		yy = q1.y * ys;
		yz = q1.y * zs;
		zz = q1.z * zs;

		m00 = 1.0f - (yy + zz);
		m01 = xy + wz;
		m02 = xz - wy;

		m10 = xy - wz;
		m11 = 1.0f - (xx + zz);
		m12 = yz + wx;

		m20 = xz + wy;
		m21 = yz - wx;
		m22 = 1.0f - (xx + yy);
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to the matrix conversion of the (single precision) axis and angle argument.
	 *
	 * @param a1 the axis and angle to be converted
	 * @return this for chaining
	 */
	public final T set(AxisAngle4f a1) {
		float mag = sqrt(a1.x * a1.x + a1.y * a1.y + a1.z * a1.z);
		if (mag < EPS) {
			m00 = 1.0f;
			m01 = 0.0f;
			m02 = 0.0f;

			m10 = 0.0f;
			m11 = 1.0f;
			m12 = 0.0f;

			m20 = 0.0f;
			m21 = 0.0f;
			m22 = 1.0f;
		} else {
			mag = 1.0f / mag;
			float ax = a1.x * mag;
			float ay = a1.y * mag;
			float az = a1.z * mag;

			float sinTheta = sin(a1.angle);
			float cosTheta = cos(a1.angle);
			float t = 1.0f - cosTheta;

			float xz = ax * az;
			float xy = ax * ay;
			float yz = ay * az;

			m00 = t * ax * ax + cosTheta;
			m01 = t * xy - sinTheta * az;
			m02 = t * xz + sinTheta * ay;

			m10 = t * xy + sinTheta * az;
			m11 = t * ay * ay + cosTheta;
			m12 = t * yz - sinTheta * ax;

			m20 = t * xz - sinTheta * ay;
			m21 = t * yz + sinTheta * ax;
			m22 = t * az * az + cosTheta;
		}
		return (T) this;
	}

	/**
	 * Sets the values in this Matrix3f equal to the row-major array parameter (ie, the first three elements of the array will be
	 * copied into the first row of this matrix, etc.).
	 *
	 * @param m the single precision array of length 9
	 * @return this for chaining
	 */
	public final T set(float[] m) {
		m00 = m[0];
		m01 = m[1];
		m02 = m[2];

		m10 = m[3];
		m11 = m[4];
		m12 = m[5];

		m20 = m[6];
		m21 = m[7];
		m22 = m[8];
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to the value of the Matrix3f argument.
	 *
	 * @param m1 the source matrix3f
	 * @return this for chaining
	 */
	public final T set(Matrix3f m1) {

		m00 = m1.m00;
		m01 = m1.m01;
		m02 = m1.m02;

		m10 = m1.m10;
		m11 = m1.m11;
		m12 = m1.m12;

		m20 = m1.m20;
		m21 = m1.m21;
		m22 = m1.m22;
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to the value of the Matrix3f argument. Copies the 3x3 part.
	 *
	 * @param m1 the source matrix3f
	 * @return this for chaining
	 */
	public final T set(Matrix4f m1) {

		m00 = m1.m00;
		m01 = m1.m01;
		m02 = m1.m02;

		m10 = m1.m10;
		m11 = m1.m11;
		m12 = m1.m12;

		m20 = m1.m20;
		m21 = m1.m21;
		m22 = m1.m22;
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to the matrix inverse of the passed matrix m1.
	 *
	 * @param m1 the matrix to be inverted
	 * @return this for chaining
	 */
	public final T invert(Matrix3f m1) {
		float c00 = m1.m11 * m1.m22 - m1.m12 * m1.m21;
		float c10 = m1.m12 * m1.m20 - m1.m10 * m1.m22;
		float c20 = m1.m10 * m1.m21 - m1.m11 * m1.m20;
		float det = m1.m00 * c00 + m1.m01 * c10 + m1.m02 * c20;

		if (det != 0.0f) {
			float invDet = (1.0f) / det;
			float n00 = c00 * invDet;
			float n01 = (m1.m02 * m1.m21 - m1.m01 * m1.m22) * invDet;
			float n02 = (m1.m01 * m1.m12 - m1.m02 * m1.m11) * invDet;
			float n10 = c10 * invDet;
			float n11 = (m1.m00 * m1.m22 - m1.m02 * m1.m20) * invDet;
			float n12 = (m1.m02 * m1.m10 - m1.m00 * m1.m12) * invDet;
			float n20 = c20 * invDet;
			float n21 = (m1.m01 * m1.m20 - m1.m00 * m1.m21) * invDet;
			float n22 = (m1.m00 * m1.m11 - m1.m01 * m1.m10) * invDet;

			m00 = n00;
			m01 = n01;
			m02 = n02;
			m10 = n10;
			m11 = n11;
			m12 = n12;
			m20 = n20;
			m21 = n21;
			m22 = n22;
		} else {
			/*
			 * output a zeroed matrix
			 *
			 */
		}

		return (T) this;
	}

	/**
	 * Inverts this matrix in place.
	 *
	 * @return this for chaining
	 */
	public final T invert() {
		invert(this);
		return (T) this;
	}

	/**
	 * Computes the determinant of this matrix.
	 *
	 * @return the determinant of this matrix
	 */
	public final float determinant() {
		float total;
		total = m00 * (m11 * m22 - m12 * m21)
			+ m01 * (m12 * m20 - m10 * m22)
			+ m02 * (m10 * m21 - m11 * m20);
		return total;
	}

	/**
	 * Sets the value of this matrix to a scale matrix with the passed scale amount.
	 *
	 * @param scale the scale factor for the matrix
	 * @return this for chaining
	 */
	public final T set(float scale) {
		m00 = scale;
		m01 = 0.0f;
		m02 = 0.0f;

		m10 = 0.0f;
		m11 = scale;
		m12 = 0.0f;

		m20 = 0.0f;
		m21 = 0.0f;
		m22 = scale;
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to a counter clockwise rotation about the x axis.
	 *
	 * @param angle the angle to rotate about the X axis in radians
	 * @return this for chaining
	 */
	public final T rotX(float angle) {
		float sinAngle, cosAngle;

		sinAngle = sin(angle);
		cosAngle = cos(angle);

		m00 = 1.0f;
		m01 = 0.0f;
		m02 = 0.0f;

		m10 = 0.0f;
		m11 = cosAngle;
		m12 = -sinAngle;

		m20 = 0.0f;
		m21 = sinAngle;
		m22 = cosAngle;
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to a counter clockwise rotation about the y axis.
	 *
	 * @param angle the angle to rotate about the Y axis in radians
	 * @return this for chaining
	 */
	public final T rotY(float angle) {
		float sinAngle, cosAngle;

		sinAngle = sin(angle);
		cosAngle = cos(angle);

		m00 = cosAngle;
		m01 = 0.0f;
		m02 = sinAngle;

		m10 = 0.0f;
		m11 = 1.0f;
		m12 = 0.0f;

		m20 = -sinAngle;
		m21 = 0.0f;
		m22 = cosAngle;
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to a counter clockwise rotation about the z axis.
	 *
	 * @param angle the angle to rotate about the Z axis in radians
	 * @return this for chaining
	 */
	public final T rotZ(float angle) {
		float sinAngle, cosAngle;

		sinAngle = sin(angle);
		cosAngle = cos(angle);

		m00 = cosAngle;
		m01 = -sinAngle;
		m02 = 0.0f;

		m10 = sinAngle;
		m11 = cosAngle;
		m12 = 0.0f;

		m20 = 0.0f;
		m21 = 0.0f;
		m22 = 1.0f;
		return (T) this;
	}

	/**
	 * Multiplies each element of this matrix by a scalar.
	 *
	 * @param scalar the scalar multiplier
	 * @return this for chaining
	 */
	public final T mul(float scalar) {
		m00 *= scalar;
		m01 *= scalar;
		m02 *= scalar;

		m10 *= scalar;
		m11 *= scalar;
		m12 *= scalar;

		m20 *= scalar;
		m21 *= scalar;
		m22 *= scalar;
		return (T) this;
	}

	/**
	 * Multiplies each element of matrix m1 by a scalar and places the result into this. Matrix m1 is not modified.
	 *
	 * @param scalar the scalar multiplier
	 * @param m1 the original matrix
	 * @return this for chaining
	 */
	public final T mul(float scalar, Matrix3f m1) {
		m00 = scalar * m1.m00;
		m01 = scalar * m1.m01;
		m02 = scalar * m1.m02;

		m10 = scalar * m1.m10;
		m11 = scalar * m1.m11;
		m12 = scalar * m1.m12;

		m20 = scalar * m1.m20;
		m21 = scalar * m1.m21;
		m22 = scalar * m1.m22;
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to the result of multiplying itself with matrix m1.
	 *
	 * @param m1 the other matrix
	 * @return this for chaining
	 */
	public final T mul(Matrix3f m1) {

		float n00 = m00 * m1.m00 + m01 * m1.m10 + m02 * m1.m20;
		float n01 = m00 * m1.m01 + m01 * m1.m11 + m02 * m1.m21;
		float n02 = m00 * m1.m02 + m01 * m1.m12 + m02 * m1.m22;

		float n10 = m10 * m1.m00 + m11 * m1.m10 + m12 * m1.m20;
		float n11 = m10 * m1.m01 + m11 * m1.m11 + m12 * m1.m21;
		float n12 = m10 * m1.m02 + m11 * m1.m12 + m12 * m1.m22;

		float n20 = m20 * m1.m00 + m21 * m1.m10 + m22 * m1.m20;
		float n21 = m20 * m1.m01 + m21 * m1.m11 + m22 * m1.m21;
		float n22 = m20 * m1.m02 + m21 * m1.m12 + m22 * m1.m22;

		m00 = n00;
		m01 = n01;
		m02 = n02;
		m10 = n10;
		m11 = n11;
		m12 = n12;
		m20 = n20;
		m21 = n21;
		m22 = n22;
		return (T) this;
	}

	/**
	 * Sets the value of this matrix to the result of multiplying the two argument matrices together.
	 *
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * @return this for chaining
	 */
	public final T mul(Matrix3f m1, Matrix3f m2) {

		float n00 = m1.m00 * m2.m00 + m1.m01 * m2.m10 + m1.m02 * m2.m20;
		float n01 = m1.m00 * m2.m01 + m1.m01 * m2.m11 + m1.m02 * m2.m21;
		float n02 = m1.m00 * m2.m02 + m1.m01 * m2.m12 + m1.m02 * m2.m22;

		float n10 = m1.m10 * m2.m00 + m1.m11 * m2.m10 + m1.m12 * m2.m20;
		float n11 = m1.m10 * m2.m01 + m1.m11 * m2.m11 + m1.m12 * m2.m21;
		float n12 = m1.m10 * m2.m02 + m1.m11 * m2.m12 + m1.m12 * m2.m22;

		float n20 = m1.m20 * m2.m00 + m1.m21 * m2.m10 + m1.m22 * m2.m20;
		float n21 = m1.m20 * m2.m01 + m1.m21 * m2.m11 + m1.m22 * m2.m21;
		float n22 = m1.m20 * m2.m02 + m1.m21 * m2.m12 + m1.m22 * m2.m22;

		m00 = n00;
		m01 = n01;
		m02 = n02;
		m10 = n10;
		m11 = n11;
		m12 = n12;
		m20 = n20;
		m21 = n21;
		m22 = n22;
		return (T) this;
	}

	/**
	 * Multiplies this matrix by matrix m1, does an SVD normalization of the result, and places the result back into this matrix.
	 * this = SVDnorm(this*m1).
	 *
	 * @param m1 the matrix on the right hand side of the multiplication
	 * @return this for chaining
	 */
	public final T mulNormalize(Matrix3f m1) {
		Matrix3f tmp = new Matrix3f();
		tmp.mul(this, m1);
		getScaleRotate(tmp, new Vector3f(), this);
		return (T) this;
	}

	/**
	 * Multiplies matrix m1 by matrix m2, does an SVD normalization of the result, and places the result into this matrix. this =
	 * SVDnorm(m1*m2).
	 *
	 * @param m1 the matrix on the left hand side of the multiplication
	 * @param m2 the matrix on the right hand side of the multiplication
	 * @return this for chaining
	 */
	public final T mulNormalize(Matrix3f m1, Matrix3f m2) {
		Matrix3f tmp = new Matrix3f();
		tmp.mul(m1, m2);
		getScaleRotate(tmp, new Vector3f(), this);
		return (T) this;
	}

	/**
	 * Multiplies the transpose of matrix m1 times the transpose of matrix m2, and places the result into this.
	 *
	 * @param m1 the matrix on the left hand side of the multiplication
	 * @param m2 the matrix on the right hand side of the multiplication
	 * @return this for chaining
	 */
	public final T mulTransposeBoth(Matrix3f m1, Matrix3f m2) {

		float n00 = m1.m00 * m2.m00 + m1.m10 * m2.m01 + m1.m20 * m2.m02;
		float n01 = m1.m00 * m2.m10 + m1.m10 * m2.m11 + m1.m20 * m2.m12;
		float n02 = m1.m00 * m2.m20 + m1.m10 * m2.m21 + m1.m20 * m2.m22;

		float n10 = m1.m01 * m2.m00 + m1.m11 * m2.m01 + m1.m21 * m2.m02;
		float n11 = m1.m01 * m2.m10 + m1.m11 * m2.m11 + m1.m21 * m2.m12;
		float n12 = m1.m01 * m2.m20 + m1.m11 * m2.m21 + m1.m21 * m2.m22;

		float n20 = m1.m02 * m2.m00 + m1.m12 * m2.m01 + m1.m22 * m2.m02;
		float n21 = m1.m02 * m2.m10 + m1.m12 * m2.m11 + m1.m22 * m2.m12;
		float n22 = m1.m02 * m2.m20 + m1.m12 * m2.m21 + m1.m22 * m2.m22;

		m00 = n00;
		m01 = n01;
		m02 = n02;
		m10 = n10;
		m11 = n11;
		m12 = n12;
		m20 = n20;
		m21 = n21;
		m22 = n22;

		return (T) this;
	}

	/**
	 * Multiplies matrix m1 times the transpose of matrix m2, and places the result into this.
	 *
	 * @param m1 the matrix on the left hand side of the multiplication
	 * @param m2 the matrix on the right hand side of the multiplication
	 * @return this for chaining
	 */
	public final T mulTransposeRight(Matrix3f m1, Matrix3f m2) {
		float n00 = m1.m00 * m2.m00 + m1.m01 * m2.m01 + m1.m02 * m2.m02;
		float n01 = m1.m00 * m2.m10 + m1.m01 * m2.m11 + m1.m02 * m2.m12;
		float n02 = m1.m00 * m2.m20 + m1.m01 * m2.m21 + m1.m02 * m2.m22;

		float n10 = m1.m10 * m2.m00 + m1.m11 * m2.m01 + m1.m12 * m2.m02;
		float n11 = m1.m10 * m2.m10 + m1.m11 * m2.m11 + m1.m12 * m2.m12;
		float n12 = m1.m10 * m2.m20 + m1.m11 * m2.m21 + m1.m12 * m2.m22;

		float n20 = m1.m20 * m2.m00 + m1.m21 * m2.m01 + m1.m22 * m2.m02;
		float n21 = m1.m20 * m2.m10 + m1.m21 * m2.m11 + m1.m22 * m2.m12;
		float n22 = m1.m20 * m2.m20 + m1.m21 * m2.m21 + m1.m22 * m2.m22;

		m00 = n00;
		m01 = n01;
		m02 = n02;
		m10 = n10;
		m11 = n11;
		m12 = n12;
		m20 = n20;
		m21 = n21;
		m22 = n22;

		return (T) this;
	}

	/**
	 * Multiplies the transpose of matrix m1 times matrix m2, and places the result into this.
	 *
	 * @param m1 the matrix on the left hand side of the multiplication
	 * @param m2 the matrix on the right hand side of the multiplication
	 * @return this for chaining
	 */
	public final T mulTransposeLeft(Matrix3f m1, Matrix3f m2) {

		float n00 = m1.m00 * m2.m00 + m1.m10 * m2.m10 + m1.m20 * m2.m20;
		float n01 = m1.m00 * m2.m01 + m1.m10 * m2.m11 + m1.m20 * m2.m21;
		float n02 = m1.m00 * m2.m02 + m1.m10 * m2.m12 + m1.m20 * m2.m22;

		float n10 = m1.m01 * m2.m00 + m1.m11 * m2.m10 + m1.m21 * m2.m20;
		float n11 = m1.m01 * m2.m01 + m1.m11 * m2.m11 + m1.m21 * m2.m21;
		float n12 = m1.m01 * m2.m02 + m1.m11 * m2.m12 + m1.m21 * m2.m22;

		float n20 = m1.m02 * m2.m00 + m1.m12 * m2.m10 + m1.m22 * m2.m20;
		float n21 = m1.m02 * m2.m01 + m1.m12 * m2.m11 + m1.m22 * m2.m21;
		float n22 = m1.m02 * m2.m02 + m1.m12 * m2.m12 + m1.m22 * m2.m22;

		m00 = n00;
		m01 = n01;
		m02 = n02;
		m10 = n10;
		m11 = n11;
		m12 = n12;
		m20 = n20;
		m21 = n21;
		m22 = n22;

		return (T) this;
	}

	/**
	 * Performs singular value decomposition normalization of this matrix.
	 *
	 * @return this for chaining
	 */
	public final T normalize() {
		getScaleRotate(this, new Vector3f(), this);
		return (T) this;
	}

	/**
	 * Perform singular value decomposition normalization of matrix m1 and place the normalized values into this.
	 *
	 * @param m1 the matrix values to be normalized
	 * @return this for chaining
	 */
	public final T normalize(Matrix3f m1) {
		getScaleRotate(m1, new Vector3f(), this);
		return (T) this;
	}

	/**
	 * Perform cross product normalization of this matrix.
	 *
	 * @return this for chaining
	 */
	public final T normalizeCP() {
		{
			float mag = 1.0f / sqrt(m00 * m00 + m10 * m10 + m20 * m20);
			m00 = m00 * mag;
			m10 = m10 * mag;
			m20 = m20 * mag;
		}
		{
			float mag = 1.0f / sqrt(m01 * m01 + m11 * m11 + m21 * m21);
			m01 = m01 * mag;
			m11 = m11 * mag;
			m21 = m21 * mag;
		}

		m02 = m10 * m21 - m11 * m20;
		m12 = m01 * m20 - m00 * m21;
		m22 = m00 * m11 - m01 * m10;
		return (T) this;
	}

	/**
	 * Perform cross product normalization of matrix m1 and place the normalized values into this.
	 *
	 * @param m1 Provides the matrix values to be normalized
	 * @return this for chaining
	 */
	public final T normalizeCP(Matrix3f m1) {
		{
			float mag = 1.0f / sqrt(m1.m00 * m1.m00 + m1.m10 * m1.m10
				+ m1.m20 * m1.m20);
			m00 = m1.m00 * mag;
			m10 = m1.m10 * mag;
			m20 = m1.m20 * mag;
		}
		{
			float mag = 1.0f / sqrt(m1.m01 * m1.m01 + m1.m11 * m1.m11 + m1.m21
				* m1.m21);
			m01 = m1.m01 * mag;
			m11 = m1.m11 * mag;
			m21 = m1.m21 * mag;
		}

		m02 = m10 * m21 - m11 * m20;
		m12 = m01 * m20 - m00 * m21;
		m22 = m00 * m11 - m01 * m10;
		return (T) this;
	}

	/**
	 * Returns true if all of the data members of Matrix3f m1 are equal to the corresponding data members in this Matrix3f.
	 *
	 * @param m1 the matrix with which the comparison is made
	 * @return true or false
	 */
	public boolean equals(Matrix3f m1) {
		return (m00 == m1.m00 && m01 == m1.m01 && m02 == m1.m02
			&& m10 == m1.m10 && m11 == m1.m11 && m12 == m1.m12
			&& m20 == m1.m20 && m21 == m1.m21 && m22 == m1.m22);
	}

	/**
	 * Returns true if the Object o1 is of type Matrix3f and all of the data members of o1 are equal to the corresponding data
	 * members in this Matrix3f.
	 *
	 * @param o1 the object with which the comparison is made
	 * @return true or false
	 */
	@Override
	public boolean equals(Object o1) {
		try {

			Matrix3f m2 = (Matrix3f) o1;
			return (m00 == m2.m00 && m01 == m2.m01 && m02 == m2.m02
				&& m10 == m2.m10 && m11 == m2.m11 && m12 == m2.m12
				&& m20 == m2.m20 && m21 == m2.m21 && m22 == m2.m22);
		} catch (ClassCastException ex) {
			return false;
		}
	}

	/**
	 * Returns true if the L-infinite distance between this matrix and matrix m1 is less than or equal to the epsilon parameter,
	 * otherwise returns false. The L-infinite distance is equal to MAX[i=0,1,2 ; j=0,1,2 ; abs(this.m(i,j) - m1.m(i,j)]
	 *
	 * @param m1 the matrix to be compared to this matrix
	 * @param epsilon the threshold value
	 * @return
	 */
	public boolean epsilonEquals(Matrix3f m1, float epsilon) {
		if (different_epsilon(m00, m1.m01, epsilon)) {
			return false;
		}
		if (different_epsilon(m01, m1.m02, epsilon)) {
			return false;
		}
		if (different_epsilon(m02, m1.m00, epsilon)) {
			return false;
		}
		if (different_epsilon(m10, m1.m10, epsilon)) {
			return false;
		}
		if (different_epsilon(m11, m1.m11, epsilon)) {
			return false;
		}
		if (different_epsilon(m12, m1.m12, epsilon)) {
			return false;
		}
		if (different_epsilon(m20, m1.m20, epsilon)) {
			return false;
		}
		if (different_epsilon(m21, m1.m21, epsilon)) {
			return false;
		}
		return !different_epsilon(m22, m1.m22, epsilon);
	}

	/**
	 * Returns a hash code value based on the data values in this object. Two different Matrix3f objects with identical data values
	 * (i.e., Matrix3f.equals returns true) will return the same hash code value. Two objects with different data members may return
	 * the same hash value, although this is not likely.
	 *
	 * @return the integer hash code value
	 */
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 37 * hash + Float.floatToIntBits(m00);
		hash = 37 * hash + Float.floatToIntBits(m01);
		hash = 37 * hash + Float.floatToIntBits(m02);
		hash = 37 * hash + Float.floatToIntBits(m10);
		hash = 37 * hash + Float.floatToIntBits(m11);
		hash = 37 * hash + Float.floatToIntBits(m12);
		hash = 37 * hash + Float.floatToIntBits(m20);
		hash = 37 * hash + Float.floatToIntBits(m21);
		hash = 37 * hash + Float.floatToIntBits(m22);
		return hash;
	}

	/**
	 * Sets this matrix to all zeros.
	 *
	 * @return this for chaining
	 */
	public T setZero() {
		m00 = 0.0f;
		m01 = 0.0f;
		m02 = 0.0f;

		m10 = 0.0f;
		m11 = 0.0f;
		m12 = 0.0f;

		m20 = 0.0f;
		m21 = 0.0f;
		m22 = 0.0f;
		return (T) this;
	}

	/**
	 * Negates the value of this matrix: this = -this.
	 *
	 * @return this for chaining
	 */
	public final T negate() {
		m00 = -m00;
		m01 = -m01;
		m02 = -m02;

		m10 = -m10;
		m11 = -m11;
		m12 = -m12;

		m20 = -m20;
		m21 = -m21;
		m22 = -m22;
		return (T) this;
	}

	/**
	 * Sets the value of this matrix equal to the negation of the Matrix3f parameter.
	 *
	 * @param m1 the source matrix
	 * @return this for chaining
	 */
	public final T negate(Matrix3f m1) {
		m00 = -m1.m00;
		m01 = -m1.m01;
		m02 = -m1.m02;

		m10 = -m1.m10;
		m11 = -m1.m11;
		m12 = -m1.m12;

		m20 = -m1.m20;
		m21 = -m1.m21;
		m22 = -m1.m22;
		return (T) this;
	}

	/**
	 * Multiply this matrix by the tuple t and place the result back into the tuple (t = this*t).
	 *
	 * @param <S>
	 * @param t the tuple to be multiplied by this matrix and then replaced
	 * @return t for chaining
	 */
	public final <S extends Tuple3f> S transform(S t) {
		float x = m00 * t.x + m01 * t.y + m02 * t.z;
		float y = m10 * t.x + m11 * t.y + m12 * t.z;
		float z = m20 * t.x + m21 * t.y + m22 * t.z;
		t.set(x, y, z);
		return t;
	}

	/**
	 * Multiply this matrix by the tuple t1 and and place the result into t2 (t2=this*t1)
	 *
	 * @param <T>
	 * @param t1 the tuple to be multiplied by this matrix
	 * @param t2 the tuple into which the product is placed
	 * @return result t2 for chaining
	 */
	public final <T extends Tuple3f> T transform(Tuple3f t1, Tuple3f t2) {
		float x = m00 * t1.x + m01 * t1.y + m02 * t1.z;
		float y = m10 * t1.x + m11 * t1.y + m12 * t1.z;
		t2.z = m20 * t1.x + m21 * t1.y + m22 * t1.z;
		t2.x = x;
		t2.y = y;
		return (T) t2;
	}

	/**
	 * Decompose the matrix into scale and rotation.
	 *
	 * @param scale the scale components, these are always positive.
	 * @param rotate the normalized rotation matrix
	 */
	public final void getScaleRotate(Tuple3f scale, Matrix3f rotate) {
		getScaleRotate(this, scale, rotate);
	}

	private static Tuple3f getScale(Matrix3f m1, Tuple3f scale) {
		double[] tmp = new double[9];  // scratch matrix
		tmp[0] = m1.m00;
		tmp[1] = m1.m10;
		tmp[2] = m1.m20;

		tmp[3] = m1.m01;
		tmp[4] = m1.m11;
		tmp[5] = m1.m21;

		tmp[6] = m1.m02;
		tmp[7] = m1.m12;
		tmp[8] = m1.m22;

		SingularValueDecomposition svd = new Matrix(tmp, 3).svd();
		double[] singles = svd.getSingularValues();
		scale.x = (float) (singles[0]);
		scale.y = (float) (singles[1]);
		scale.z = (float) (singles[2]);
		return scale;
	}

	static void getScaleRotate(Matrix3f m1, Tuple3f scale, Matrix3f rotate) {
		double[] tmp = new double[9];  // scratch matrix
		tmp[0] = m1.m00;
		tmp[1] = m1.m10;
		tmp[2] = m1.m20;

		tmp[3] = m1.m01;
		tmp[4] = m1.m11;
		tmp[5] = m1.m21;

		tmp[6] = m1.m02;
		tmp[7] = m1.m12;
		tmp[8] = m1.m22;

		SingularValueDecomposition svd = new Matrix(tmp, 3).svd();

		Matrix u = svd.getU();
		Matrix vt = svd.getV().transpose();
		Matrix R = u.times(vt);

		double[] singles = svd.getSingularValues();
		scale.x = (float) (singles[0]);
		scale.y = (float) (singles[1]);
		scale.z = (float) (singles[2]);

		rotate.m00 = (float) R.get(0, 0);
		rotate.m01 = (float) R.get(0, 1);
		rotate.m02 = (float) R.get(0, 2);
		rotate.m10 = (float) R.get(1, 0);
		rotate.m11 = (float) R.get(1, 1);
		rotate.m12 = (float) R.get(1, 2);
		rotate.m20 = (float) R.get(2, 0);
		rotate.m21 = (float) R.get(2, 1);
		rotate.m22 = (float) R.get(2, 2);
	}

	/**
	 * Set the diagonal elements of this matrix to the components of a vector
	 *
	 * @param v the three component values
	 * @return this for chaining
	 */
	public final T setDiagonal(Tuple3f v) {
		m00 = v.x;
		m11 = v.y;
		m22 = v.z;
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
		Matrix3f m1 = null;
		try {
			m1 = (Matrix3f) super.clone();
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new InternalError();
		}
		return m1;
	}

	/**
	 * Get the first matrix element in the first row.
	 *
	 * @return Returns the m00.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM00() {
		return m00;
	}

	/**
	 * Set the first matrix element in the first row.
	 *
	 * @param m00 The m00 to set.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public final T setM00(float m00) {
		this.m00 = m00;
		return (T) this;
	}

	/**
	 * Get the second matrix element in the first row.
	 *
	 * @return Returns the m01.
	 *
	 *
	 * @since vecmath 1.5
	 */
	public final float getM01() {
		return m01;
	}

	/**
	 * Set the second matrix element in the first row.
	 *
	 * @param m01 The m01 to set.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public final T setM01(float m01) {
		this.m01 = m01;
		return (T) this;
	}

	/**
	 * Get the third matrix element in the first row.
	 *
	 * @return Returns the m02.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM02() {
		return m02;
	}

	/**
	 * Set the third matrix element in the first row.
	 *
	 * @param m02 The m02 to set.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public final T setM02(float m02) {
		this.m02 = m02;
		return (T) this;
	}

	/**
	 * Get first matrix element in the second row.
	 *
	 * @return Returns the m10.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM10() {
		return m10;
	}

	/**
	 * Set first matrix element in the second row.
	 *
	 * @param m10 The m10 to set.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public final T setM10(float m10) {
		this.m10 = m10;
		return (T) this;
	}

	/**
	 * Get second matrix element in the second row.
	 *
	 * @return Returns the m11.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM11() {
		return m11;
	}

	/**
	 * Set the second matrix element in the second row.
	 *
	 * @param m11 The m11 to set.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public final T setM11(float m11) {
		this.m11 = m11;
		return (T) this;
	}

	/**
	 * Get the third matrix element in the second row.
	 *
	 * @return Returns the m12.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM12() {
		return m12;
	}

	/**
	 * Set the third matrix element in the second row.
	 *
	 * @param m12 The m12 to set.
	 * @return this for chaining
	 * @since vecmath 1.5
	 */
	public final T setM12(float m12) {
		this.m12 = m12;
		return (T) this;
	}

	/**
	 * Get the first matrix element in the third row.
	 *
	 * @return Returns the m20.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM20() {
		return m20;
	}

	/**
	 * Set the first matrix element in the third row.
	 *
	 * @param m20 The m20 to set.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public final T setM20(float m20) {
		this.m20 = m20;
		return (T) this;
	}

	/**
	 * Get the second matrix element in the third row.
	 *
	 * @return Returns the m21.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM21() {
		return m21;
	}

	/**
	 * Set the second matrix element in the third row.
	 *
	 * @param m21 The m21 to set.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public final T setM21(float m21) {
		this.m21 = m21;
		return (T) this;
	}

	/**
	 * Get the third matrix element in the third row .
	 *
	 * @return Returns the m22.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM22() {
		return m22;
	}

	/**
	 * Set the third matrix element in the third row.
	 *
	 * @param m22 The m22 to set.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public final T setM22(float m22) {
		this.m22 = m22;
		return (T) this;
	}

	/**
	 * Scale the columns of matrix m1 by the components of s and store the result in this matrix
	 *
	 * @param m1 the matrix to scale
	 * @param s scale values
	 * @return this for chaining
	 */
	public final T mul(Matrix3f m1, Tuple3f s) {
		m00 = m1.m00 * s.x;
		m01 = m1.m01 * s.y;
		m02 = m1.m02 * s.z;
		m10 = m1.m10 * s.x;
		m11 = m1.m11 * s.y;
		m12 = m1.m12 * s.z;
		m20 = m1.m20 * s.x;
		m21 = m1.m21 * s.y;
		m22 = m1.m22 * s.z;
		return (T) this;
	}

	/**
	 * Scale the columns of this matrix by the components of s and store the result in this matrix
	 *
	 * @param s scale values
	 * @return this for chaining
	 */
	public final T mul(Tuple3f s) {
		mul(this, s);
		return (T) this;
	}

	/**
	 * Set the elements of this matrix to the abs value of the corresponding element in m1.
	 *
	 * @param m1 the matrix to get values
	 * @return this for chaining
	 */
	public final T abs(Matrix3f m1) {
		m00 = Math.abs(m1.m00);
		m01 = Math.abs(m1.m01);
		m02 = Math.abs(m1.m02);
		m10 = Math.abs(m1.m10);
		m11 = Math.abs(m1.m11);
		m12 = Math.abs(m1.m12);
		m20 = Math.abs(m1.m20);
		m21 = Math.abs(m1.m21);
		m22 = Math.abs(m1.m22);
		return (T) this;
	}

	/**
	 * Set each element of this matrix to its abs value
	 *
	 * @return this for chaining.
	 */
	public final T abs() {
		abs(this);
		return (T) this;
	}

}
