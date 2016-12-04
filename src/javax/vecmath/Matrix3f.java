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

/**
 * A single precision floating point 3 by 3 matrix. Primarily to support 3D rotations.
 *
 */
public class Matrix3f implements java.io.Serializable, Cloneable {

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
		this.m00 = v[0];
		this.m01 = v[1];
		this.m02 = v[2];

		this.m10 = v[3];
		this.m11 = v[4];
		this.m12 = v[5];

		this.m20 = v[6];
		this.m21 = v[7];
		this.m22 = v[8];

	}

	/**
	 * Constructs a new matrix with the same values as the Matrix3f parameter.
	 *
	 * @param m1 the source matrix
	 */
	public Matrix3f(Matrix3f m1) {
		this.m00 = m1.m00;
		this.m01 = m1.m01;
		this.m02 = m1.m02;

		this.m10 = m1.m10;
		this.m11 = m1.m11;
		this.m12 = m1.m12;

		this.m20 = m1.m20;
		this.m21 = m1.m21;
		this.m22 = m1.m22;

	}

	/**
	 * Constructor that copies the 3x3 rotation/scale part of a 4x4 matrix..
	 *
	 * @param m1 the source matrix
	 */
	public Matrix3f(Matrix4f m1) {
		this.m00 = m1.m00;
		this.m01 = m1.m01;
		this.m02 = m1.m02;

		this.m10 = m1.m10;
		this.m11 = m1.m11;
		this.m12 = m1.m12;

		this.m20 = m1.m20;
		this.m21 = m1.m21;
		this.m22 = m1.m22;
	}

	/**
	 * Constructs and initializes a Matrix3f to all zeros.
	 */
	public Matrix3f() {
		this.m00 = 0.0f;
		this.m01 = 0.0f;
		this.m02 = 0.0f;

		this.m10 = 0.0f;
		this.m11 = 0.0f;
		this.m12 = 0.0f;

		this.m20 = 0.0f;
		this.m21 = 0.0f;
		this.m22 = 0.0f;

	}

	/**
	 * Returns a string that contains the values of this Matrix3f.
	 *
	 * @return the String representation
	 */
	@Override
	public String toString() {
		return this.m00 + ", " + this.m01 + ", " + this.m02 + "\n" +
			this.m10 + ", " + this.m11 + ", " + this.m12 + "\n" +
			this.m20 + ", " + this.m21 + ", " + this.m22;
	}

	/**
	 * Sets this matrix to identity.
	 *
	 * @return this for chaining
	 */
	public final Matrix3f setIdentity() {
		this.m00 = (float) 1.0;
		this.m01 = (float) 0.0;
		this.m02 = (float) 0.0;

		this.m10 = (float) 0.0;
		this.m11 = (float) 1.0;
		this.m12 = (float) 0.0;

		this.m20 = (float) 0.0;
		this.m21 = (float) 0.0;
		this.m22 = (float) 1.0;
		return this;
	}

	/**
	 * Sets the scale component of the current matrix by factoring out the current scale (by doing an SVD) and multiplying
	 * by the new scale.
	 *
	 * @param scale the new scale amount
	 * @return this for chaining
	 */
	public final Matrix3f setScale(float scale) {

		Matrix3f rotate = new Matrix3f();
		getScaleRotate(this, new Vector3f(), rotate);

		this.m00 = rotate.m00 * scale;
		this.m01 = rotate.m01 * scale;
		this.m02 = rotate.m02 * scale;

		this.m10 = rotate.m10 * scale;
		this.m11 = rotate.m11 * scale;
		this.m12 = rotate.m12 * scale;

		this.m20 = rotate.m20 * scale;
		this.m21 = rotate.m21 * scale;
		this.m22 = rotate.m22 * scale;
		return this;
	}

	/**
	 * Sets the scale component of the current matrix by factoring out the current scale (by doing an SVD) and multiplying
	 * by the new scale.
	 *
	 * @param x scale component
	 * @param y scale component
	 * @param z scale component
	 * @return this for chaining
	 */
	public final Matrix3f setScale(float x, float y, float z) {

		Matrix3f rotate = new Matrix3f();
		Tuple3f scale = new Vector3f();
		getScaleRotate(this, scale, rotate);

		this.m00 = rotate.m00 * x;
		this.m01 = rotate.m01 * x;
		this.m02 = rotate.m02 * x;

		this.m10 = rotate.m10 * y;
		this.m11 = rotate.m11 * y;
		this.m12 = rotate.m12 * y;

		this.m20 = rotate.m20 * z;
		this.m21 = rotate.m21 * z;
		this.m22 = rotate.m22 * z;
		return this;
	}

	/**
	 * Sets the specified element of this matrix to the value provided.
	 *
	 * @param row the row number to be modified (zero indexed)
	 * @param column the column number to be modified (zero indexed)
	 * @param value the new value
	 * @return this for chaining
	 */
	public final Matrix3f setElement(int row, int column, float value) {
		switch (row) {
			case 0:
				switch (column) {
					case 0:
						this.m00 = value;
						break;
					case 1:
						this.m01 = value;
						break;
					case 2:
						this.m02 = value;
						break;
					default:
						throw new ArrayIndexOutOfBoundsException();
				}
				break;

			case 1:
				switch (column) {
					case 0:
						this.m10 = value;
						break;
					case 1:
						this.m11 = value;
						break;
					case 2:
						this.m12 = value;
						break;
					default:
						throw new ArrayIndexOutOfBoundsException();
				}
				break;

			case 2:
				switch (column) {
					case 0:
						this.m20 = value;
						break;
					case 1:
						this.m21 = value;
						break;
					case 2:
						this.m22 = value;
						break;
					default:

						throw new ArrayIndexOutOfBoundsException();
				}
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;
	}

	/**
	 * Copies the matrix values in the specified row into the vector parameter.
	 *
	 * @param row the matrix row
	 * @param v the vector into which the matrix row values will be copied
	 * @return v for chaining
	 */
	public final Tuple3f getRow(int row, Tuple3f v) {
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
	 * @param column the matrix column
	 * @param v the vector into which the matrix row values will be copied
	 * @return v for chaining
	 */
	public final Tuple3f getColumn(int column, Tuple3f v) {
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
		switch (row) {
			case 0:
				switch (column) {
					case 0:
						return (this.m00);
					case 1:
						return (this.m01);
					case 2:
						return (this.m02);
					default:
						break;
				}
				break;
			case 1:
				switch (column) {
					case 0:
						return (this.m10);
					case 1:
						return (this.m11);
					case 2:
						return (this.m12);
					default:
						break;
				}
				break;

			case 2:
				switch (column) {
					case 0:
						return (this.m20);
					case 1:
						return (this.m21);
					case 2:
						return (this.m22);
					default:
						break;
				}
				break;

			default:
				break;
		}
		throw new ArrayIndexOutOfBoundsException();
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
	public final Matrix3f setRow(int row, float x, float y, float z) {
		switch (row) {
			case 0:
				this.m00 = x;
				this.m01 = y;
				this.m02 = z;
				break;

			case 1:
				this.m10 = x;
				this.m11 = y;
				this.m12 = z;
				break;

			case 2:
				this.m20 = x;
				this.m21 = y;
				this.m22 = z;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;
	}

	/**
	 * Sets the specified row of this matrix3f to the Vector provided.
	 *
	 * @param row the row number to be modified (zero indexed)
	 * @param v the replacement row
	 * @return this for chaining
	 */
	public final Matrix3f setRow(int row, Tuple3f v) {
		switch (row) {
			case 0:
				this.m00 = v.x;
				this.m01 = v.y;
				this.m02 = v.z;
				break;

			case 1:
				this.m10 = v.x;
				this.m11 = v.y;
				this.m12 = v.z;
				break;

			case 2:
				this.m20 = v.x;
				this.m21 = v.y;
				this.m22 = v.z;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;
	}

	/**
	 * Sets the specified row of this matrix3f to the three values provided.
	 *
	 * @param row the row number to be modified (zero indexed)
	 * @param v the replacement row
	 * @return this for chaining
	 */
	public final Matrix3f setRow(int row, float v[]) {
		switch (row) {
			case 0:
				this.m00 = v[0];
				this.m01 = v[1];
				this.m02 = v[2];
				break;

			case 1:
				this.m10 = v[0];
				this.m11 = v[1];
				this.m12 = v[2];
				break;

			case 2:
				this.m20 = v[0];
				this.m21 = v[1];
				this.m22 = v[2];
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;
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
	public final Matrix3f setColumn(int column, float x, float y, float z) {
		switch (column) {
			case 0:
				this.m00 = x;
				this.m10 = y;
				this.m20 = z;
				break;

			case 1:
				this.m01 = x;
				this.m11 = y;
				this.m21 = z;
				break;

			case 2:
				this.m02 = x;
				this.m12 = y;
				this.m22 = z;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;
	}

	/**
	 * Sets the specified column of this matrix3f to the vector provided.
	 *
	 * @param column the column number to be modified (zero indexed)
	 * @param v the replacement column
	 * @return this for chaining
	 */
	public final Matrix3f setColumn(int column, Tuple3f v) {
		switch (column) {
			case 0:
				this.m00 = v.x;
				this.m10 = v.y;
				this.m20 = v.z;
				break;

			case 1:
				this.m01 = v.x;
				this.m11 = v.y;
				this.m21 = v.z;
				break;

			case 2:
				this.m02 = v.x;
				this.m12 = v.y;
				this.m22 = v.z;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;
	}

	/**
	 * Sets the specified column of this matrix3f to the three values provided.
	 *
	 * @param column the column number to be modified (zero indexed)
	 * @param v the replacement column
	 * @return this for chaining
	 */
	public final Matrix3f setColumn(int column, float v[]) {
		switch (column) {
			case 0:
				this.m00 = v[0];
				this.m10 = v[1];
				this.m20 = v[2];
				break;

			case 1:
				this.m01 = v[0];
				this.m11 = v[1];
				this.m21 = v[2];
				break;

			case 2:
				this.m02 = v[0];
				this.m12 = v[1];
				this.m22 = v[2];
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;
	}

	/**
	 * Performs an SVD normalization of this matrix to calculate and return the uniform scale factor. If the matrix has
	 * non-uniform scale factors, the largest of the x, y, and z scale factors will be returned. This matrix is not
	 * modified.
	 *
	 * @return the scale factor of this matrix
	 */
	public final float getScale() {
		Vector3f scale = new Vector3f();
		getScale(this, scale);
		return scale.max3();
	}

	/**
	 *
	 * @param scale
	 * @return this for chaining
	 */
	public final Tuple3f getScale(Tuple3f scale) {
		getScale(this, scale);
		return scale;
	}

	/**
	 * Adds a scalar to each component of this matrix.
	 *
	 * @param scalar the scalar adder
	 * @return this for chaining
	 */
	public final Matrix3f add(float scalar) {
		m00 += scalar;
		m01 += scalar;
		m02 += scalar;
		m10 += scalar;
		m11 += scalar;
		m12 += scalar;
		m20 += scalar;
		m21 += scalar;
		m22 += scalar;
		return this;
	}

	/**
	 * Adds a scalar to each component of the matrix m1 and places the result into this. Matrix m1 is not modified.
	 *
	 * @param scalar the scalar adder.
	 * @param m1 the original matrix values
	 * @return this for chaining
	 */
	public final Matrix3f add(float scalar, Matrix3f m1) {
		this.m00 = m1.m00 + scalar;
		this.m01 = m1.m01 + scalar;
		this.m02 = m1.m02 + scalar;
		this.m10 = m1.m10 + scalar;
		this.m11 = m1.m11 + scalar;
		this.m12 = m1.m12 + scalar;
		this.m20 = m1.m20 + scalar;
		this.m21 = m1.m21 + scalar;
		this.m22 = m1.m22 + scalar;
		return this;
	}

	/**
	 * Sets the value of this matrix to the matrix sum of matrices m1 and m2.
	 *
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * @return this for chaining
	 */
	public final Matrix3f add(Matrix3f m1, Matrix3f m2) {
		this.m00 = m1.m00 + m2.m00;
		this.m01 = m1.m01 + m2.m01;
		this.m02 = m1.m02 + m2.m02;

		this.m10 = m1.m10 + m2.m10;
		this.m11 = m1.m11 + m2.m11;
		this.m12 = m1.m12 + m2.m12;

		this.m20 = m1.m20 + m2.m20;
		this.m21 = m1.m21 + m2.m21;
		this.m22 = m1.m22 + m2.m22;
		return this;
	}

	/**
	 * Sets the value of this matrix to the matrix sum of itself and matrix m1.
	 *
	 * @param m1 the other matrix
	 * @return this for chaining
	 */
	public final Matrix3f add(Matrix3f m1) {
		this.m00 += m1.m00;
		this.m01 += m1.m01;
		this.m02 += m1.m02;

		this.m10 += m1.m10;
		this.m11 += m1.m11;
		this.m12 += m1.m12;

		this.m20 += m1.m20;
		this.m21 += m1.m21;
		this.m22 += m1.m22;
		return this;
	}

	/**
	 * Sets the value of this matrix to the matrix difference of matrices m1 and m2.
	 *
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * @return this for chaining
	 */
	public final Matrix3f sub(Matrix3f m1, Matrix3f m2) {
		this.m00 = m1.m00 - m2.m00;
		this.m01 = m1.m01 - m2.m01;
		this.m02 = m1.m02 - m2.m02;

		this.m10 = m1.m10 - m2.m10;
		this.m11 = m1.m11 - m2.m11;
		this.m12 = m1.m12 - m2.m12;

		this.m20 = m1.m20 - m2.m20;
		this.m21 = m1.m21 - m2.m21;
		this.m22 = m1.m22 - m2.m22;
		return this;
	}

	/**
	 * Sets the value of this matrix to the matrix difference of itself and matrix m1 (this = this - m1).
	 *
	 * @param m1 the other matrix
	 * @return this for chaining
	 */
	public final Matrix3f sub(Matrix3f m1) {
		this.m00 -= m1.m00;
		this.m01 -= m1.m01;
		this.m02 -= m1.m02;

		this.m10 -= m1.m10;
		this.m11 -= m1.m11;
		this.m12 -= m1.m12;

		this.m20 -= m1.m20;
		this.m21 -= m1.m21;
		this.m22 -= m1.m22;
		return this;
	}

	/**
	 * Sets the value of this matrix to its transpose.
	 *
	 * @return this for chaining
	 */
	public final Matrix3f transpose() {
		float temp;

		temp = this.m10;
		this.m10 = this.m01;
		this.m01 = temp;

		temp = this.m20;
		this.m20 = this.m02;
		this.m02 = temp;

		temp = this.m21;
		this.m21 = this.m12;
		this.m12 = temp;
		return this;
	}

	/**
	 * Sets the value of this matrix to the transpose of the argument matrix.
	 *
	 * @param m1 the matrix to be transposed
	 * @return this for chaining
	 */
	public final Matrix3f transpose(Matrix3f m1) {
		if (this != m1) {
			this.m00 = m1.m00;
			this.m01 = m1.m10;
			this.m02 = m1.m20;

			this.m10 = m1.m01;
			this.m11 = m1.m11;
			this.m12 = m1.m21;

			this.m20 = m1.m02;
			this.m21 = m1.m12;
			this.m22 = m1.m22;
		} else {
			this.transpose();
		}
		return this;
	}

	/**
	 * Sets the value of this matrix to the matrix conversion of the (single precision) quaternion argument.
	 *
	 * @param q1 the quaternion to be converted
	 * @return this for chaining
	 */
	public final Matrix3f set(Quat4f q1) {
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

		this.m00 = 1.0f - (yy + zz);
		this.m01 = xy + wz;
		this.m02 = xz - wy;

		this.m10 = xy - wz;
		this.m11 = 1.0f - (xx + zz);
		this.m12 = yz + wx;

		this.m20 = xz + wy;
		this.m21 = yz - wx;
		this.m22 = 1.0f - (xx + yy);
		return this;
	}

	/**
	 * Sets the value of this matrix to the matrix conversion of the (single precision) axis and angle argument.
	 *
	 * @param a1 the axis and angle to be converted
	 * @return this for chaining
	 */
	public final Matrix3f set(AxisAngle4f a1) {
		float mag = (float) Math.sqrt(a1.x * a1.x + a1.y * a1.y + a1.z * a1.z);
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
			float ax = a1.x * (float) mag;
			float ay = a1.y * (float) mag;
			float az = a1.z * (float) mag;

			float sinTheta = (float) Math.sin((float) a1.angle);
			float cosTheta = (float) Math.cos((float) a1.angle);
			float t = (float) 1.0 - cosTheta;

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
		return this;
	}

	/**
	 * Sets the values in this Matrix3f equal to the row-major array parameter (ie, the first three elements of the array
	 * will be copied into the first row of this matrix, etc.).
	 *
	 * @param m the single precision array of length 9
	 * @return this for chaining
	 */
	public final Matrix3f set(float[] m) {
		m00 = m[0];
		m01 = m[1];
		m02 = m[2];

		m10 = m[3];
		m11 = m[4];
		m12 = m[5];

		m20 = m[6];
		m21 = m[7];
		m22 = m[8];
		return this;
	}

	/**
	 * Sets the value of this matrix to the value of the Matrix3f argument.
	 *
	 * @param m1 the source matrix3f
	 * @return this for chaining
	 */
	public final Matrix3f set(Matrix3f m1) {

		this.m00 = m1.m00;
		this.m01 = m1.m01;
		this.m02 = m1.m02;

		this.m10 = m1.m10;
		this.m11 = m1.m11;
		this.m12 = m1.m12;

		this.m20 = m1.m20;
		this.m21 = m1.m21;
		this.m22 = m1.m22;
		return this;
	}

	/**
	 * Sets the value of this matrix to the value of the Matrix3f argument. Copies the 3x3 part.
	 *
	 * @param m1 the source matrix3f
	 * @return this for chaining
	 */
	public final Matrix3f set(Matrix4f m1) {

		this.m00 = m1.m00;
		this.m01 = m1.m01;
		this.m02 = m1.m02;

		this.m10 = m1.m10;
		this.m11 = m1.m11;
		this.m12 = m1.m12;

		this.m20 = m1.m20;
		this.m21 = m1.m21;
		this.m22 = m1.m22;
		return this;
	}

	/**
	 * Sets the value of this matrix to the matrix inverse of the passed matrix m1.
	 *
	 * @param m1 the matrix to be inverted
	 * @return this for chaining
	 */
	public final Matrix3f invert(Matrix3f m1) {
		this.set(m1);
		invertGeneral(this);
		return this;
	}

	/**
	 * Inverts this matrix in place.
	 *
	 * @return this for chaining
	 */
	public final Matrix3f invert() {
		invertGeneral(this);
		return this;
	}

	/**
	 * General invert routine. Inverts m1 and places the result in "this". Note that this routine handles both the "this"
	 * version and the non-"this" version.
	 *
	 * Also note that since this routine is slow anyway, we won't worry about allocating a little bit of garbage.
	 */
	private void invertGeneral(Matrix3f m1) {
		float c00 = m1.m11 * m1.m22 - m1.m12 * m1.m21;
		float c10 = m1.m12 * m1.m20 - m1.m10 * m1.m22;
		float c20 = m1.m10 * m1.m21 - m1.m11 * m1.m20;
		float det = m1.m00 * c00 + m1.m01 * c10 + m1.m02 * c20;
		Matrix3f inverse = new Matrix3f();
		if (det != 0.0f) {
			float invDet = (1.0f) / det;
			inverse.m00 = c00 * invDet;
			inverse.m01 = (m1.m02 * m1.m21 - m1.m01 * m1.m22) * invDet;
			inverse.m02 = (m1.m01 * m1.m12 - m1.m02 * m1.m11) * invDet;
			inverse.m10 = c10 * invDet;
			inverse.m11 = (m1.m00 * m1.m22 - m1.m02 * m1.m20) * invDet;
			inverse.m12 = (m1.m02 * m1.m10 - m1.m00 * m1.m12) * invDet;
			inverse.m20 = c20 * invDet;
			inverse.m21 = (m1.m01 * m1.m20 - m1.m00 * m1.m21) * invDet;
			inverse.m22 = (m1.m00 * m1.m11 - m1.m01 * m1.m10) * invDet;
		} else {
			/*
			 * output a zeroed matrix
			 *
			 */
		}
		m1.set(inverse);
	}

	/**
	 * Computes the determinant of this matrix.
	 *
	 * @return the determinant of this matrix
	 */
	public final float determinant() {
		float total;
		total = this.m00 * (this.m11 * this.m22 - this.m12 * this.m21) +
			this.m01 * (this.m12 * this.m20 - this.m10 * this.m22) +
			this.m02 * (this.m10 * this.m21 - this.m11 * this.m20);
		return total;
	}

	/**
	 * Sets the value of this matrix to a scale matrix with the passed scale amount.
	 *
	 * @param scale the scale factor for the matrix
	 * @return this for chaining
	 */
	public final Matrix3f set(float scale) {
		this.m00 = scale;
		this.m01 = (float) 0.0;
		this.m02 = (float) 0.0;

		this.m10 = (float) 0.0;
		this.m11 = scale;
		this.m12 = (float) 0.0;

		this.m20 = (float) 0.0;
		this.m21 = (float) 0.0;
		this.m22 = scale;
		return this;
	}

	/**
	 * Sets the value of this matrix to a counter clockwise rotation about the x axis.
	 *
	 * @param angle the angle to rotate about the X axis in radians
	 * @return this for chaining
	 */
	public final Matrix3f rotX(float angle) {
		float sinAngle, cosAngle;

		sinAngle = (float) Math.sin((float) angle);
		cosAngle = (float) Math.cos((float) angle);

		this.m00 = (float) 1.0;
		this.m01 = (float) 0.0;
		this.m02 = (float) 0.0;

		this.m10 = (float) 0.0;
		this.m11 = cosAngle;
		this.m12 = -sinAngle;

		this.m20 = (float) 0.0;
		this.m21 = sinAngle;
		this.m22 = cosAngle;
		return this;
	}

	/**
	 * Sets the value of this matrix to a counter clockwise rotation about the y axis.
	 *
	 * @param angle the angle to rotate about the Y axis in radians
	 * @return this for chaining
	 */
	public final Matrix3f rotY(float angle) {
		float sinAngle, cosAngle;

		sinAngle = (float) Math.sin((float) angle);
		cosAngle = (float) Math.cos((float) angle);

		this.m00 = cosAngle;
		this.m01 = (float) 0.0;
		this.m02 = sinAngle;

		this.m10 = (float) 0.0;
		this.m11 = (float) 1.0;
		this.m12 = (float) 0.0;

		this.m20 = -sinAngle;
		this.m21 = (float) 0.0;
		this.m22 = cosAngle;
		return this;
	}

	/**
	 * Sets the value of this matrix to a counter clockwise rotation about the z axis.
	 *
	 * @param angle the angle to rotate about the Z axis in radians
	 * @return this for chaining
	 */
	public final Matrix3f rotZ(float angle) {
		float sinAngle, cosAngle;

		sinAngle = (float) Math.sin(angle);
		cosAngle = (float) Math.cos(angle);

		this.m00 = cosAngle;
		this.m01 = -sinAngle;
		this.m02 = (float) 0.0;

		this.m10 = sinAngle;
		this.m11 = cosAngle;
		this.m12 = (float) 0.0;

		this.m20 = (float) 0.0;
		this.m21 = (float) 0.0;
		this.m22 = (float) 1.0;
		return this;
	}

	/**
	 * Multiplies each element of this matrix by a scalar.
	 *
	 * @param scalar the scalar multiplier
	 * @return this for chaining
	 */
	public final Matrix3f mul(float scalar) {
		m00 *= scalar;
		m01 *= scalar;
		m02 *= scalar;

		m10 *= scalar;
		m11 *= scalar;
		m12 *= scalar;

		m20 *= scalar;
		m21 *= scalar;
		m22 *= scalar;
		return this;
	}

	/**
	 * Multiplies each element of matrix m1 by a scalar and places the result into this. Matrix m1 is not modified.
	 *
	 * @param scalar the scalar multiplier
	 * @param m1 the original matrix
	 * @return this for chaining
	 */
	public final Matrix3f mul(float scalar, Matrix3f m1) {
		this.m00 = scalar * m1.m00;
		this.m01 = scalar * m1.m01;
		this.m02 = scalar * m1.m02;

		this.m10 = scalar * m1.m10;
		this.m11 = scalar * m1.m11;
		this.m12 = scalar * m1.m12;

		this.m20 = scalar * m1.m20;
		this.m21 = scalar * m1.m21;
		this.m22 = scalar * m1.m22;
		return this;
	}

	/**
	 * Sets the value of this matrix to the result of multiplying itself with matrix m1.
	 *
	 * @param m1 the other matrix
	 * @return this for chaining
	 */
	public final Matrix3f mul(Matrix3f m1) {
		float n00, n01, n02,
			n10, n11, n12,
			n20, n21, n22;

		n00 = this.m00 * m1.m00 + this.m01 * m1.m10 + this.m02 * m1.m20;
		n01 = this.m00 * m1.m01 + this.m01 * m1.m11 + this.m02 * m1.m21;
		n02 = this.m00 * m1.m02 + this.m01 * m1.m12 + this.m02 * m1.m22;

		n10 = this.m10 * m1.m00 + this.m11 * m1.m10 + this.m12 * m1.m20;
		n11 = this.m10 * m1.m01 + this.m11 * m1.m11 + this.m12 * m1.m21;
		n12 = this.m10 * m1.m02 + this.m11 * m1.m12 + this.m12 * m1.m22;

		n20 = this.m20 * m1.m00 + this.m21 * m1.m10 + this.m22 * m1.m20;
		n21 = this.m20 * m1.m01 + this.m21 * m1.m11 + this.m22 * m1.m21;
		n22 = this.m20 * m1.m02 + this.m21 * m1.m12 + this.m22 * m1.m22;

		this.m00 = n00;
		this.m01 = n01;
		this.m02 = n02;
		this.m10 = n10;
		this.m11 = n11;
		this.m12 = n12;
		this.m20 = n20;
		this.m21 = n21;
		this.m22 = n22;
		return this;
	}

	/**
	 * Sets the value of this matrix to the result of multiplying the two argument matrices together.
	 *
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * @return this for chaining
	 */
	public final Matrix3f mul(Matrix3f m1, Matrix3f m2) {
		if (this != m1 && this != m2) {
			set(m1)
				.mul(m2);
		} else {
			set(new Matrix3f(m1)
				.mul(m2));
		}
		return this;
	}

	/**
	 * Multiplies this matrix by matrix m1, does an SVD normalization of the result, and places the result back into this
	 * matrix. this = SVDnorm(this*m1).
	 *
	 * @param m1 the matrix on the right hand side of the multiplication
	 * @return this for chaining
	 */
	public final Matrix3f mulNormalize(Matrix3f m1) {
		Matrix3f tmp = new Matrix3f();
		tmp.mul(this, m1);
		getScaleRotate(tmp, new Vector3f(), this);
		return this;
	}

	/**
	 * Multiplies matrix m1 by matrix m2, does an SVD normalization of the result, and places the result into this matrix.
	 * this = SVDnorm(m1*m2).
	 *
	 * @param m1 the matrix on the left hand side of the multiplication
	 * @param m2 the matrix on the right hand side of the multiplication
	 * @return this for chaining
	 */
	public final Matrix3f mulNormalize(Matrix3f m1, Matrix3f m2) {
		Matrix3f tmp = new Matrix3f();
		tmp.mul(m1, m2);
		getScaleRotate(tmp, new Vector3f(), this);
		return this;
	}

	/**
	 * Multiplies the transpose of matrix m1 times the transpose of matrix m2, and places the result into this.
	 *
	 * @param m1 the matrix on the left hand side of the multiplication
	 * @param m2 the matrix on the right hand side of the multiplication
	 * @return this for chaining
	 */
	public final Matrix3f mulTransposeBoth(Matrix3f m1, Matrix3f m2) {
		if (this != m1 && this != m2) {
			this.m00 = m1.m00 * m2.m00 + m1.m10 * m2.m01 + m1.m20 * m2.m02;
			this.m01 = m1.m00 * m2.m10 + m1.m10 * m2.m11 + m1.m20 * m2.m12;
			this.m02 = m1.m00 * m2.m20 + m1.m10 * m2.m21 + m1.m20 * m2.m22;

			this.m10 = m1.m01 * m2.m00 + m1.m11 * m2.m01 + m1.m21 * m2.m02;
			this.m11 = m1.m01 * m2.m10 + m1.m11 * m2.m11 + m1.m21 * m2.m12;
			this.m12 = m1.m01 * m2.m20 + m1.m11 * m2.m21 + m1.m21 * m2.m22;

			this.m20 = m1.m02 * m2.m00 + m1.m12 * m2.m01 + m1.m22 * m2.m02;
			this.m21 = m1.m02 * m2.m10 + m1.m12 * m2.m11 + m1.m22 * m2.m12;
			this.m22 = m1.m02 * m2.m20 + m1.m12 * m2.m21 + m1.m22 * m2.m22;
		} else {
			float n00, n01, n02,
				n10, n11, n12,
				n20, n21, n22;  // vars for temp result matrix 

			n00 = m1.m00 * m2.m00 + m1.m10 * m2.m01 + m1.m20 * m2.m02;
			n01 = m1.m00 * m2.m10 + m1.m10 * m2.m11 + m1.m20 * m2.m12;
			n02 = m1.m00 * m2.m20 + m1.m10 * m2.m21 + m1.m20 * m2.m22;

			n10 = m1.m01 * m2.m00 + m1.m11 * m2.m01 + m1.m21 * m2.m02;
			n11 = m1.m01 * m2.m10 + m1.m11 * m2.m11 + m1.m21 * m2.m12;
			n12 = m1.m01 * m2.m20 + m1.m11 * m2.m21 + m1.m21 * m2.m22;

			n20 = m1.m02 * m2.m00 + m1.m12 * m2.m01 + m1.m22 * m2.m02;
			n21 = m1.m02 * m2.m10 + m1.m12 * m2.m11 + m1.m22 * m2.m12;
			n22 = m1.m02 * m2.m20 + m1.m12 * m2.m21 + m1.m22 * m2.m22;

			this.m00 = n00;
			this.m01 = n01;
			this.m02 = n02;
			this.m10 = n10;
			this.m11 = n11;
			this.m12 = n12;
			this.m20 = n20;
			this.m21 = n21;
			this.m22 = n22;
		}
		return this;
	}

	/**
	 * Multiplies matrix m1 times the transpose of matrix m2, and places the result into this.
	 *
	 * @param m1 the matrix on the left hand side of the multiplication
	 * @param m2 the matrix on the right hand side of the multiplication
	 * @return this for chaining
	 */
	public final Matrix3f mulTransposeRight(Matrix3f m1, Matrix3f m2) {
		if (this != m1 && this != m2) {
			this.m00 = m1.m00 * m2.m00 + m1.m01 * m2.m01 + m1.m02 * m2.m02;
			this.m01 = m1.m00 * m2.m10 + m1.m01 * m2.m11 + m1.m02 * m2.m12;
			this.m02 = m1.m00 * m2.m20 + m1.m01 * m2.m21 + m1.m02 * m2.m22;

			this.m10 = m1.m10 * m2.m00 + m1.m11 * m2.m01 + m1.m12 * m2.m02;
			this.m11 = m1.m10 * m2.m10 + m1.m11 * m2.m11 + m1.m12 * m2.m12;
			this.m12 = m1.m10 * m2.m20 + m1.m11 * m2.m21 + m1.m12 * m2.m22;

			this.m20 = m1.m20 * m2.m00 + m1.m21 * m2.m01 + m1.m22 * m2.m02;
			this.m21 = m1.m20 * m2.m10 + m1.m21 * m2.m11 + m1.m22 * m2.m12;
			this.m22 = m1.m20 * m2.m20 + m1.m21 * m2.m21 + m1.m22 * m2.m22;
		} else {
			float n00, n01, n02,
				n10, n11, n12,
				n20, n21, n22;  // vars for temp result matrix 

			n00 = m1.m00 * m2.m00 + m1.m01 * m2.m01 + m1.m02 * m2.m02;
			n01 = m1.m00 * m2.m10 + m1.m01 * m2.m11 + m1.m02 * m2.m12;
			n02 = m1.m00 * m2.m20 + m1.m01 * m2.m21 + m1.m02 * m2.m22;

			n10 = m1.m10 * m2.m00 + m1.m11 * m2.m01 + m1.m12 * m2.m02;
			n11 = m1.m10 * m2.m10 + m1.m11 * m2.m11 + m1.m12 * m2.m12;
			n12 = m1.m10 * m2.m20 + m1.m11 * m2.m21 + m1.m12 * m2.m22;

			n20 = m1.m20 * m2.m00 + m1.m21 * m2.m01 + m1.m22 * m2.m02;
			n21 = m1.m20 * m2.m10 + m1.m21 * m2.m11 + m1.m22 * m2.m12;
			n22 = m1.m20 * m2.m20 + m1.m21 * m2.m21 + m1.m22 * m2.m22;

			this.m00 = n00;
			this.m01 = n01;
			this.m02 = n02;
			this.m10 = n10;
			this.m11 = n11;
			this.m12 = n12;
			this.m20 = n20;
			this.m21 = n21;
			this.m22 = n22;
		}
		return this;
	}

	/**
	 * Multiplies the transpose of matrix m1 times matrix m2, and places the result into this.
	 *
	 * @param m1 the matrix on the left hand side of the multiplication
	 * @param m2 the matrix on the right hand side of the multiplication
	 * @return this for chaining
	 */
	public final Matrix3f mulTransposeLeft(Matrix3f m1, Matrix3f m2) {
		if (this != m1 && this != m2) {
			this.m00 = m1.m00 * m2.m00 + m1.m10 * m2.m10 + m1.m20 * m2.m20;
			this.m01 = m1.m00 * m2.m01 + m1.m10 * m2.m11 + m1.m20 * m2.m21;
			this.m02 = m1.m00 * m2.m02 + m1.m10 * m2.m12 + m1.m20 * m2.m22;

			this.m10 = m1.m01 * m2.m00 + m1.m11 * m2.m10 + m1.m21 * m2.m20;
			this.m11 = m1.m01 * m2.m01 + m1.m11 * m2.m11 + m1.m21 * m2.m21;
			this.m12 = m1.m01 * m2.m02 + m1.m11 * m2.m12 + m1.m21 * m2.m22;

			this.m20 = m1.m02 * m2.m00 + m1.m12 * m2.m10 + m1.m22 * m2.m20;
			this.m21 = m1.m02 * m2.m01 + m1.m12 * m2.m11 + m1.m22 * m2.m21;
			this.m22 = m1.m02 * m2.m02 + m1.m12 * m2.m12 + m1.m22 * m2.m22;
		} else {
			float n00, n01, n02,
				n10, n11, n12,
				n20, n21, n22;  // vars for temp result matrix 

			n00 = m1.m00 * m2.m00 + m1.m10 * m2.m10 + m1.m20 * m2.m20;
			n01 = m1.m00 * m2.m01 + m1.m10 * m2.m11 + m1.m20 * m2.m21;
			n02 = m1.m00 * m2.m02 + m1.m10 * m2.m12 + m1.m20 * m2.m22;

			n10 = m1.m01 * m2.m00 + m1.m11 * m2.m10 + m1.m21 * m2.m20;
			n11 = m1.m01 * m2.m01 + m1.m11 * m2.m11 + m1.m21 * m2.m21;
			n12 = m1.m01 * m2.m02 + m1.m11 * m2.m12 + m1.m21 * m2.m22;

			n20 = m1.m02 * m2.m00 + m1.m12 * m2.m10 + m1.m22 * m2.m20;
			n21 = m1.m02 * m2.m01 + m1.m12 * m2.m11 + m1.m22 * m2.m21;
			n22 = m1.m02 * m2.m02 + m1.m12 * m2.m12 + m1.m22 * m2.m22;

			this.m00 = n00;
			this.m01 = n01;
			this.m02 = n02;
			this.m10 = n10;
			this.m11 = n11;
			this.m12 = n12;
			this.m20 = n20;
			this.m21 = n21;
			this.m22 = n22;
		}
		return this;
	}

	/**
	 * Performs singular value decomposition normalization of this matrix.
	 *
	 * @return this for chaining
	 */
	public final Matrix3f normalize() {
		getScaleRotate(this, new Vector3f(), this);
		return this;
	}

	/**
	 * Perform singular value decomposition normalization of matrix m1 and place the normalized values into this.
	 *
	 * @param m1 the matrix values to be normalized
	 * @return this for chaining
	 */
	public final Matrix3f normalize(Matrix3f m1) {
		getScaleRotate(m1, new Vector3f(), this);
		return this;
	}

	/**
	 * Perform cross product normalization of this matrix.
	 *
	 * @return this for chaining
	 */
	public final Matrix3f normalizeCP() {

		float mag = 1.0f / (float) Math.sqrt(m00 * m00 + m10 * m10 + m20 * m20);
		m00 = m00 * mag;
		m10 = m10 * mag;
		m20 = m20 * mag;

		mag = 1.0f / (float) Math.sqrt(m01 * m01 + m11 * m11 + m21 * m21);
		m01 = m01 * mag;
		m11 = m11 * mag;
		m21 = m21 * mag;

		m02 = m10 * m21 - m11 * m20;
		m12 = m01 * m20 - m00 * m21;
		m22 = m00 * m11 - m01 * m10;
		return this;
	}

	/**
	 * Perform cross product normalization of matrix m1 and place the normalized values into this.
	 *
	 * @param m1 Provides the matrix values to be normalized
	 * @return this for chaining
	 */
	public final Matrix3f normalizeCP(Matrix3f m1) {
		float mag = 1.0f / (float) Math.sqrt(m1.m00 * m1.m00 + m1.m10 * m1.m10 +
			m1.m20 * m1.m20);
		m00 = m1.m00 * mag;
		m10 = m1.m10 * mag;
		m20 = m1.m20 * mag;

		mag = 1.0f / (float) Math.sqrt(m1.m01 * m1.m01 + m1.m11 * m1.m11 + m1.m21 *
			m1.m21);
		m01 = m1.m01 * mag;
		m11 = m1.m11 * mag;
		m21 = m1.m21 * mag;

		m02 = m10 * m21 - m11 * m20;
		m12 = m01 * m20 - m00 * m21;
		m22 = m00 * m11 - m01 * m10;
		return this;
	}

	/**
	 * Returns true if all of the data members of Matrix3f m1 are equal to the corresponding data members in this Matrix3f.
	 *
	 * @param m1 the matrix with which the comparison is made
	 * @return true or false
	 */
	public boolean equals(Matrix3f m1) {
		try {

			return (this.m00 == m1.m00 && this.m01 == m1.m01 && this.m02 == m1.m02 &&
				this.m10 == m1.m10 && this.m11 == m1.m11 && this.m12 == m1.m12 &&
				this.m20 == m1.m20 && this.m21 == m1.m21 && this.m22 == m1.m22);
		} catch (NullPointerException e2) {
			return false;
		}

	}

	/**
	 * Returns true if the Object o1 is of type Matrix3f and all of the data members of o1 are equal to the corresponding
	 * data members in this Matrix3f.
	 *
	 * @param o1 the object with which the comparison is made
	 * @return true or false
	 */
	@Override
	public boolean equals(Object o1) {
		try {

			Matrix3f m2 = (Matrix3f) o1;
			return (this.m00 == m2.m00 && this.m01 == m2.m01 && this.m02 == m2.m02 &&
				this.m10 == m2.m10 && this.m11 == m2.m11 && this.m12 == m2.m12 &&
				this.m20 == m2.m20 && this.m21 == m2.m21 && this.m22 == m2.m22);
		} catch (ClassCastException | NullPointerException e1) {
			return false;
		}
	}

	/**
	 * Returns true if the L-infinite distance between this matrix and matrix m1 is less than or equal to the epsilon
	 * parameter, otherwise returns false. The L-infinite distance is equal to MAX[i=0,1,2 ; j=0,1,2 ; abs(this.m(i,j) -
	 * m1.m(i,j)]
	 *
	 * @param m1 the matrix to be compared to this matrix
	 * @param epsilon the threshold value
	 * @return
	 */
	public boolean epsilonEquals(Matrix3f m1, float epsilon) {
		boolean status = true;

		if (Math.abs(this.m00 - m1.m00) > epsilon) {
			status = false;
		}
		if (Math.abs(this.m01 - m1.m01) > epsilon) {
			status = false;
		}
		if (Math.abs(this.m02 - m1.m02) > epsilon) {
			status = false;
		}

		if (Math.abs(this.m10 - m1.m10) > epsilon) {
			status = false;
		}
		if (Math.abs(this.m11 - m1.m11) > epsilon) {
			status = false;
		}
		if (Math.abs(this.m12 - m1.m12) > epsilon) {
			status = false;
		}

		if (Math.abs(this.m20 - m1.m20) > epsilon) {
			status = false;
		}
		if (Math.abs(this.m21 - m1.m21) > epsilon) {
			status = false;
		}
		if (Math.abs(this.m22 - m1.m22) > epsilon) {
			status = false;
		}

		return (status);

	}

	/**
	 * Returns a hash code value based on the data values in this object. Two different Matrix3f objects with identical
	 * data values (i.e., Matrix3f.equals returns true) will return the same hash code value. Two objects with different
	 * data members may return the same hash value, although this is not likely.
	 *
	 * @return the integer hash code value
	 */
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 37 * hash + Float.floatToIntBits(this.m00);
		hash = 37 * hash + Float.floatToIntBits(this.m01);
		hash = 37 * hash + Float.floatToIntBits(this.m02);
		hash = 37 * hash + Float.floatToIntBits(this.m10);
		hash = 37 * hash + Float.floatToIntBits(this.m11);
		hash = 37 * hash + Float.floatToIntBits(this.m12);
		hash = 37 * hash + Float.floatToIntBits(this.m20);
		hash = 37 * hash + Float.floatToIntBits(this.m21);
		hash = 37 * hash + Float.floatToIntBits(this.m22);
		return hash;
	}

	/**
	 * Sets this matrix to all zeros.
	 *
	 * @return this for chaining
	 */
	public final Matrix3f setZero() {
		m00 = 0.0f;
		m01 = 0.0f;
		m02 = 0.0f;

		m10 = 0.0f;
		m11 = 0.0f;
		m12 = 0.0f;

		m20 = 0.0f;
		m21 = 0.0f;
		m22 = 0.0f;
		return this;
	}

	/**
	 * Negates the value of this matrix: this = -this.
	 *
	 * @return this for chaining
	 */
	public final Matrix3f negate() {
		this.m00 = -this.m00;
		this.m01 = -this.m01;
		this.m02 = -this.m02;

		this.m10 = -this.m10;
		this.m11 = -this.m11;
		this.m12 = -this.m12;

		this.m20 = -this.m20;
		this.m21 = -this.m21;
		this.m22 = -this.m22;
		return this;
	}

	/**
	 * Sets the value of this matrix equal to the negation of the Matrix3f parameter.
	 *
	 * @param m1 the source matrix
	 * @return this for chaining
	 */
	public final Matrix3f negate(Matrix3f m1) {
		this.m00 = -m1.m00;
		this.m01 = -m1.m01;
		this.m02 = -m1.m02;

		this.m10 = -m1.m10;
		this.m11 = -m1.m11;
		this.m12 = -m1.m12;

		this.m20 = -m1.m20;
		this.m21 = -m1.m21;
		this.m22 = -m1.m22;
		return this;
	}

	/**
	 * Multiply this matrix by the tuple t and place the result back into the tuple (t = this*t).
	 *
	 * @param t the tuple to be multiplied by this matrix and then replaced
	 * @return t for chaining
	 */
	public final Tuple3f transform(Tuple3f t) {
		float x, y, z;
		x = m00 * t.x + m01 * t.y + m02 * t.z;
		y = m10 * t.x + m11 * t.y + m12 * t.z;
		z = m20 * t.x + m21 * t.y + m22 * t.z;
		t.set(x, y, z);
		return t;
	}

	/**
	 * Multiply this matrix by the tuple t and and place the result into the tuple "result" (result = this*t).
	 *
	 * @param t the tuple to be multiplied by this matrix
	 * @param result the tuple into which the product is placed
	 * @return result for chaining
	 */
	public final Tuple3f transform(Tuple3f t, Tuple3f result) {
		float x, y, z;
		x = m00 * t.x + m01 * t.y + m02 * t.z;
		y = m10 * t.x + m11 * t.y + m12 * t.z;
		result.z = m20 * t.x + m21 * t.y + m22 * t.z;
		result.x = x;
		result.y = y;
		return result;
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

	private static void getScale(Matrix3f m1, Tuple3f scale) {
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

//		double det =
//			(uvt.get(0, 0) * uvt.get(1, 1) * uvt.get(2, 2)) +
//			(uvt.get(0, 1) * uvt.get(1, 2) * uvt.get(2, 0)) +
//			(uvt.get(0, 2) * uvt.get(1, 0) * uvt.get(2, 1)) -
//			(uvt.get(0, 2) * uvt.get(1, 1) * uvt.get(2, 0)) -
//			(uvt.get(0, 1) * uvt.get(1, 0) * uvt.get(2, 2)) -
//			(uvt.get(0, 0) * uvt.get(1, 2) * uvt.get(2, 1));
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
	public final Matrix3f setDiagonal(Tuple3f v) {
		m00 = v.x;
		m11 = v.y;
		m22 = v.z;
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
	public final Matrix3f setM00(float m00) {
		this.m00 = m00;
		return this;
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
	public final Matrix3f setM01(float m01) {
		this.m01 = m01;
		return this;
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
	public final Matrix3f setM02(float m02) {
		this.m02 = m02;
		return this;
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
	public final Matrix3f setM10(float m10) {
		this.m10 = m10;
		return this;
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
	public final Matrix3f setM11(float m11) {
		this.m11 = m11;
		return this;
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
	public final Matrix3f setM12(float m12) {
		this.m12 = m12;
		return this;
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
	public final Matrix3f setM20(float m20) {
		this.m20 = m20;
		return this;
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
	public final Matrix3f setM21(float m21) {
		this.m21 = m21;
		return this;
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
	public final Matrix3f setM22(float m22) {
		this.m22 = m22;
		return this;
	}

	/**
	 * Scale the columns of matrix m1 by the components of s and store the result in this matrix
	 *
	 * @param m1 the matrix to scale
	 * @param s scale values
	 * @return this for chaining
	 */
	public final Matrix3f mul(Matrix3f m1, Tuple3f s) {
		scale(this, m1, s);
		return this;
	}

	/**
	 * Scale the columns of this matrix by the components of s and store the result in this matrix
	 *
	 * @param m1 the matrix to scale
	 * @param s scale values
	 * @return this for chaining
	 */
	public final Matrix3f mul(Tuple3f s) {
		scale(this, this, s);
		return this;
	}

	private static void scale(Matrix3f dest, Matrix3f mat, Tuple3f s) {
		dest.m00 = mat.m00 * s.x;
		dest.m01 = mat.m01 * s.y;
		dest.m02 = mat.m02 * s.z;
		dest.m10 = mat.m10 * s.x;
		dest.m11 = mat.m11 * s.y;
		dest.m12 = mat.m12 * s.z;
		dest.m20 = mat.m20 * s.x;
		dest.m21 = mat.m21 * s.y;
		dest.m22 = mat.m22 * s.z;
	}

	/**
	 * Set the elements of this matrix to the abs value of the corresponding element in m1.
	 *
	 * @param m1 the matrix to get values
	 * @return this for chaining
	 */
	public final Matrix3f abs(Matrix3f m1) {
		abs(this, m1);
		return this;
	}

	/**
	 * Set each element of this matrix to its abs value
	 *
	 * @return this for chaining.
	 */
	public final Matrix3f abs() {
		abs(this, this);
		return this;
	}

	private static void abs(Matrix3f dest, Matrix3f mat) {
		dest.m00 = Math.abs(mat.m00);
		dest.m01 = Math.abs(mat.m01);
		dest.m02 = Math.abs(mat.m02);
		dest.m10 = Math.abs(mat.m10);
		dest.m11 = Math.abs(mat.m11);
		dest.m12 = Math.abs(mat.m12);
		dest.m20 = Math.abs(mat.m20);
		dest.m21 = Math.abs(mat.m21);
		dest.m22 = Math.abs(mat.m22);
	}

	/**
	 * Diagonalizes this matrix by the Jacobi method. rot stores the rotation from the coordinate system in which the
	 * matrix is diagonal to the original coordinate system, i.e., old_this = rot * new_this * rot^T. The iteration stops
	 * when all off-diagonal elements are less than the threshold multiplied by the sum of the abs values of the diagonal,
	 * or when maxSteps have been executed. Note that this matrix is assumed to be symmetric.
	 */
	// JAVA NOTE: diagonalize method from 2.71
//	public final Matrix3f diagonalize(Matrix3f rot, float threshold, int maxSteps) {
//		Vector3f row = new Vector3f();
//
//		rot.setIdentity();
//		for (int step = maxSteps; step > 0; step--) {
//			// find off-diagonal element [p][q] with largest magnitude
//			int p = 0;
//			int q = 1;
//			int r = 2;
//			float max = Math.abs(m01);
//			float v = Math.abs(m02);
//			if (v > max) {
//				q = 2;
//				r = 1;
//				max = v;
//			}
//			v = Math.abs(m12);
//			if (v > max) {
//				p = 1;
//				q = 2;
//				r = 0;
//				max = v;
//			}
//
//			float t = threshold * (Math.abs(m00) + Math.abs(m11) + Math.abs(m22));
//			if (max <= t) {
//				if (max <= EPS * t) {
//					return this;
//				}
//				step = 1;
//			}
//
//			// compute Jacobi rotation J which leads to a zero for element [p][q]
//			float mpq = getElement(p, q);
//			float theta = (getElement(q, q) - getElement(p, p)) / (2 * mpq);
//			float theta2 = theta * theta;
//			float cos;
//			float sin;
//			if ((theta2 * theta2) < (10f / EPS)) {
//				t = (theta >= 0f) ? 1f / (theta + (float) Math.sqrt(1f + theta2)) :
//					 1f / (theta - (float) Math.sqrt(1f + theta2));
//				cos = 1f / (float) Math.sqrt(1f + t * t);
//				sin = cos * t;
//			} else {
//				// approximation for large theta-value, i.e., a nearly diagonal matrix
//				t = 1 / (theta * (2 + 0.5f / theta2));
//				cos = 1 - 0.5f * t * t;
//				sin = cos * t;
//			}
//
//			// apply rotation to matrix (this = J^T * this * J)
//			setElement(p, q, 0f);
//			setElement(q, p, 0f);
//			setElement(p, p, getElement(p, p) - t * mpq);
//			setElement(q, q, getElement(q, q) + t * mpq);
//			float mrp = getElement(r, p);
//			float mrq = getElement(r, q);
//			setElement(r, p, cos * mrp - sin * mrq);
//			setElement(p, r, cos * mrp - sin * mrq);
//			setElement(r, q, cos * mrq + sin * mrp);
//			setElement(q, r, cos * mrq + sin * mrp);
//
//			// apply rotation to rot (rot = rot * J)
//			for (int i = 0; i < 3; i++) {
//				rot.getRow(i, row);
//
//				mrp = row.get(p);
//				mrq = row.get(q);
//				row.set(p, cos * mrp - sin * mrq);
//				row.set(q, cos * mrq + sin * mrp);
//				rot.setRow(i, row);
//			}
//		}
//		return this;
//	}
}
