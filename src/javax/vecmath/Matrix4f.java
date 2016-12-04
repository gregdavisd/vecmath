/*
 * $RCSfile: Matrix4f.java,v $
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
 * A single precision floating point 4 by 4 matrix. Primarily to support 3D rotations.
 *
 */
public class Matrix4f implements java.io.Serializable, Cloneable {

	// Compatible with 1.1
	static final long serialVersionUID = -8405036035410109353L;

	/**
	 * The first element of the first row.
	 */
	public float m00;

	/**
	 * The second element of the first row.
	 */
	public float m01;

	/**
	 * The third element of the first row.
	 */
	public float m02;

	/**
	 * The fourth element of the first row.
	 */
	public float m03;

	/**
	 * The first element of the second row.
	 */
	public float m10;

	/**
	 * The second element of the second row.
	 */
	public float m11;

	/**
	 * The third element of the second row.
	 */
	public float m12;

	/**
	 * The fourth element of the second row.
	 */
	public float m13;

	/**
	 * The first element of the third row.
	 */
	public float m20;

	/**
	 * The second element of the third row.
	 */
	public float m21;

	/**
	 * The third element of the third row.
	 */
	public float m22;

	/**
	 * The fourth element of the third row.
	 */
	public float m23;

	/**
	 * The first element of the fourth row.
	 */
	public float m30;

	/**
	 * The second element of the fourth row.
	 */
	public float m31;

	/**
	 * The third element of the fourth row.
	 */
	public float m32;

	/**
	 * The fourth element of the fourth row.
	 */
	public float m33;

	private static final double EPS = 1.0E-12f;

	/**
	 * Constructs and initializes a Matrix4f from the specified 16 values.
	 *
	 * @param m00 the [0][0] element
	 * @param m01 the [0][1] element
	 * @param m02 the [0][2] element
	 * @param m03 the [0][3] element
	 * @param m10 the [1][0] element
	 * @param m11 the [1][1] element
	 * @param m12 the [1][2] element
	 * @param m13 the [1][3] element
	 * @param m20 the [2][0] element
	 * @param m21 the [2][1] element
	 * @param m22 the [2][2] element
	 * @param m23 the [2][3] element
	 * @param m30 the [3][0] element
	 * @param m31 the [3][1] element
	 * @param m32 the [3][2] element
	 * @param m33 the [3][3] element
	 */
	public Matrix4f(float m00, float m01, float m02, float m03,
		float m10, float m11, float m12, float m13,
		float m20, float m21, float m22, float m23,
		float m30, float m31, float m32, float m33) {
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m03 = m03;

		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.m13 = m13;

		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
		this.m23 = m23;

		this.m30 = m30;
		this.m31 = m31;
		this.m32 = m32;
		this.m33 = m33;

	}

	/**
	 * Constructs and initializes a Matrix4f from the specified 16 element array. this.m00 =v[0], this.m01=v[1], etc.
	 *
	 * @param v the array of length 16 containing in order
	 */
	public Matrix4f(float[] v) {
		this.m00 = v[0];
		this.m01 = v[1];
		this.m02 = v[2];
		this.m03 = v[3];

		this.m10 = v[4];
		this.m11 = v[5];
		this.m12 = v[6];
		this.m13 = v[7];

		this.m20 = v[8];
		this.m21 = v[9];
		this.m22 = v[10];
		this.m23 = v[11];

		this.m30 = v[12];
		this.m31 = v[13];
		this.m32 = v[14];
		this.m33 = v[15];

	}

	/**
	 * Constructs a new matrix with the same values as the Matrix4f parameter.
	 *
	 * @param m1 the source matrix
	 */
	public Matrix4f(Matrix4f m1) {
		this.m00 = m1.m00;
		this.m01 = m1.m01;
		this.m02 = m1.m02;
		this.m03 = m1.m03;

		this.m10 = m1.m10;
		this.m11 = m1.m11;
		this.m12 = m1.m12;
		this.m13 = m1.m13;

		this.m20 = m1.m20;
		this.m21 = m1.m21;
		this.m22 = m1.m22;
		this.m23 = m1.m23;

		this.m30 = m1.m30;
		this.m31 = m1.m31;
		this.m32 = m1.m32;
		this.m33 = m1.m33;

	}

	/**
	 * Constructs and initializes a Matrix4f from the rotation matrix, translation, and scale values; the scale is applied
	 * only to the rotational components of the matrix (upper 3x3) and not to the translational components of the matrix.
	 *
	 * @param m1 the rotation matrix representing the rotational components
	 * @param t1 the translational components of the matrix
	 * @param s the scale value applied to the rotational components
	 */
	public Matrix4f(Matrix3f m1, Vector3f t1, float s) {
		this.m00 = m1.m00 * s;
		this.m01 = m1.m01 * s;
		this.m02 = m1.m02 * s;
		this.m03 = t1.x;

		this.m10 = m1.m10 * s;
		this.m11 = m1.m11 * s;
		this.m12 = m1.m12 * s;
		this.m13 = t1.y;

		this.m20 = m1.m20 * s;
		this.m21 = m1.m21 * s;
		this.m22 = m1.m22 * s;
		this.m23 = t1.z;

		this.m30 = 0.0f;
		this.m31 = 0.0f;
		this.m32 = 0.0f;
		this.m33 = 1.0f;

	}

	/**
	 * Constructs and initializes a Matrix4f to all zeros.
	 */
	public Matrix4f() {
		this.m00 = (float) 0.0;
		this.m01 = (float) 0.0;
		this.m02 = (float) 0.0;
		this.m03 = (float) 0.0;

		this.m10 = (float) 0.0;
		this.m11 = (float) 0.0;
		this.m12 = (float) 0.0;
		this.m13 = (float) 0.0;

		this.m20 = (float) 0.0;
		this.m21 = (float) 0.0;
		this.m22 = (float) 0.0;
		this.m23 = (float) 0.0;

		this.m30 = (float) 0.0;
		this.m31 = (float) 0.0;
		this.m32 = (float) 0.0;
		this.m33 = (float) 0.0;

	}

	/**
	 * Returns a string that contains the values of this Matrix4f.
	 *
	 * @return the String representation
	 */
	@Override
	public String toString() {
		return this.m00 + ", " + this.m01 + ", " + this.m02 + ", " + this.m03 + "\n" +
			this.m10 + ", " + this.m11 + ", " + this.m12 + ", " + this.m13 + "\n" +
			this.m20 + ", " + this.m21 + ", " + this.m22 + ", " + this.m23 + "\n" +
			this.m30 + ", " + this.m31 + ", " + this.m32 + ", " + this.m33;
	}

	/**
	 * Sets this Matrix4f to identity.
	 *
	 * @return this for chaining
	 */
	public final Matrix4f setIdentity() {
		this.m00 = (float) 1.0;
		this.m01 = (float) 0.0;
		this.m02 = (float) 0.0;
		this.m03 = (float) 0.0;

		this.m10 = (float) 0.0;
		this.m11 = (float) 1.0;
		this.m12 = (float) 0.0;
		this.m13 = (float) 0.0;

		this.m20 = (float) 0.0;
		this.m21 = (float) 0.0;
		this.m22 = (float) 1.0;
		this.m23 = (float) 0.0;

		this.m30 = (float) 0.0;
		this.m31 = (float) 0.0;
		this.m32 = (float) 0.0;
		this.m33 = (float) 1.0;
		return this;
	}

	/**
	 * Sets the specified element of this matrix4f to the value provided.
	 *
	 * @param row the row number to be modified (zero indexed)
	 * @param column the column number to be modified (zero indexed)
	 * @param value the new value
	 * @return this for chaining
	 */
	public final Matrix4f setElement(int row, int column, float value) {
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
					case 3:
						this.m03 = value;
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
					case 3:
						this.m13 = value;
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
					case 3:
						this.m23 = value;
						break;
					default:
						throw new ArrayIndexOutOfBoundsException();
				}
				break;

			case 3:
				switch (column) {
					case 0:
						this.m30 = value;
						break;
					case 1:
						this.m31 = value;
						break;
					case 2:
						this.m32 = value;
						break;
					case 3:
						this.m33 = value;
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
	 * Retrieves the value at the specified row and column of this matrix.
	 *
	 * @param row the row number to be retrieved (zero indexed)
	 * @param column the column number to be retrieved (zero indexed)
	 * @return the value at the indexed element
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
					case 3:
						return (this.m03);
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
					case 3:
						return (this.m13);
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
					case 3:
						return (this.m23);
					default:
						break;
				}
				break;

			case 3:
				switch (column) {
					case 0:
						return (this.m30);
					case 1:
						return (this.m31);
					case 2:
						return (this.m32);
					case 3:
						return (this.m33);
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
	 * Copies the matrix values in the specified row into the vector parameter.
	 *
	 * @param row the matrix row
	 * @param v the vector into which the matrix row values will be copied
	 */
	public final void getRow(int row, Vector4f v) {
		switch (row) {
			case 0:
				v.x = m00;
				v.y = m01;
				v.z = m02;
				v.w = m03;
				break;
			case 1:
				v.x = m10;
				v.y = m11;
				v.z = m12;
				v.w = m13;
				break;
			case 2:
				v.x = m20;
				v.y = m21;
				v.z = m22;
				v.w = m23;
				break;
			case 3:
				v.x = m30;
				v.y = m31;
				v.z = m32;
				v.w = m33;
				break;
			default:
				throw new ArrayIndexOutOfBoundsException();
		}

	}

	/**
	 * Copies the matrix values in the specified row into the array parameter.
	 *
	 * @param row the matrix row
	 * @param v the array into which the matrix row values will be copied
	 */
	public final void getRow(int row, float v[]) {
		switch (row) {
			case 0:
				v[0] = m00;
				v[1] = m01;
				v[2] = m02;
				v[3] = m03;
				break;
			case 1:
				v[0] = m10;
				v[1] = m11;
				v[2] = m12;
				v[3] = m13;
				break;
			case 2:
				v[0] = m20;
				v[1] = m21;
				v[2] = m22;
				v[3] = m23;
				break;
			case 3:
				v[0] = m30;
				v[1] = m31;
				v[2] = m32;
				v[3] = m33;
				break;
			default:
				throw new ArrayIndexOutOfBoundsException();
		}

	}

	/**
	 * Copies the matrix values in the specified column into the vector parameter.
	 *
	 * @param column the matrix column
	 * @param v the vector into which the matrix row values will be copied
	 */
	public final void getColumn(int column, Vector4f v) {
		switch (column) {
			case 0:
				v.x = m00;
				v.y = m10;
				v.z = m20;
				v.w = m30;
				break;
			case 1:
				v.x = m01;
				v.y = m11;
				v.z = m21;
				v.w = m31;
				break;
			case 2:
				v.x = m02;
				v.y = m12;
				v.z = m22;
				v.w = m32;
				break;
			case 3:
				v.x = m03;
				v.y = m13;
				v.z = m23;
				v.w = m33;
				break;
			default:
				throw new ArrayIndexOutOfBoundsException();
		}

	}

	/**
	 * Copies the matrix values in the specified column into the array parameter.
	 *
	 * @param column the matrix column
	 * @param v the array into which the matrix row values will be copied
	 */
	public final void getColumn(int column, float v[]) {
		switch (column) {
			case 0:
				v[0] = m00;
				v[1] = m10;
				v[2] = m20;
				v[3] = m30;
				break;
			case 1:
				v[0] = m01;
				v[1] = m11;
				v[2] = m21;
				v[3] = m31;
				break;
			case 2:
				v[0] = m02;
				v[1] = m12;
				v[2] = m22;
				v[3] = m32;
				break;
			case 3:
				v[0] = m03;
				v[1] = m13;
				v[2] = m23;
				v[3] = m33;
				break;
			default:
				throw new ArrayIndexOutOfBoundsException();
		}

	}

	/**
	 * Sets the scale component of the current matrix by factoring out the current scale (by doing an SVD) from the
	 * rotational component and multiplying by the new scale.
	 *
	 * @param scale the new scale amount
	 * @return this for chaining
	 */
	public final Matrix4f setScale(float scale) {

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
	 * Copy the 3x3 components
	 *
	 * @param m1 matrix into which the rotational component is placed
	 */
	public final void get(Matrix3f m1) {
		getScaleRotate(this, new Vector3f(), m1);
	}

	/**
	 * Performs an SVD normalization of this matrix to calculate the rotation as a 3x3 matrix, the translation, and the
	 * scale. None of the matrix values are modified.
	 *
	 * @param m1 the normalized matrix representing the rotation
	 * @param t1 the translation component
	 * @return the scale component of this transform
	 */
	public final float get(Matrix3f m1, Vector3f t1) {
		Vector3f scale = new Vector3f();
		getScaleRotate(scale, m1);
		t1.x = m03;
		t1.y = m13;
		t1.z = m23;
		return scale.max3();
	}

	/**
	 * Performs an SVD normalization of this matrix in order to acquire the normalized rotational component; the values are
	 * placed into the Quat4f parameter.
	 *
	 * @param q1 quaternion into which the rotation component is placed
	 */
	public final void get(Quat4f q1) {
		q1.set(new Matrix3f(this).normalize());
	}

	/**
	 * Retrieves the translational components of this matrix.
	 *
	 * @param trans the vector that will receive the translational component
	 * @return trans for chaining
	 */
	public final Vector3f get(Vector3f trans) {
		trans.x = m03;
		trans.y = m13;
		trans.z = m23;
		return trans;
	}

	/**
	 * Gets the upper 3x3 values of this matrix and places them into the matrix m1.
	 *
	 * @param m1 the matrix that will hold the values
	 * @return m1 for chaining
	 */
	public final Matrix3f getRotationScale(Matrix3f m1) {
		m1.m00 = m00;
		m1.m01 = m01;
		m1.m02 = m02;
		m1.m10 = m10;
		m1.m11 = m11;
		m1.m12 = m12;
		m1.m20 = m20;
		m1.m21 = m21;
		m1.m22 = m22;
		return m1;
	}

	/**
	 * Performs an SVD normalization of this matrix to calculate and return the uniform scale factor. If the matrix has
	 * non-uniform scale factors, the largest of the x, y, and z scale factors will be returned. This matrix is not
	 * modified.
	 *
	 * @return the scale factor of this matrix
	 */
	public final float getScale() {
		return new Matrix3f(this).getScale();
	}

	/**
	 * Decompose the 3x3 portion of this matrix and return the scale components
	 *
	 * @param scale x,y,z scale components
	 * @return scale for chaining.
	 */
	public final Vector3f getScale(Vector3f scale) {
		new Matrix3f(this).getScale(scale);
		return scale;
	}

	private static void getScale(Matrix4f m1, Vector3f scale) {
		new Matrix3f(m1).getScale(scale);
	}

	/**
	 * Replaces the upper 3x3 matrix values of this matrix with the values in the matrix m1.
	 *
	 * @param m1 the matrix that will be the new upper 3x3
	 * @return this for chaining
	 */
	public final Matrix4f setRotationScale(Matrix3f m1) {
		m00 = m1.m00;
		m01 = m1.m01;
		m02 = m1.m02;
		m10 = m1.m10;
		m11 = m1.m11;
		m12 = m1.m12;
		m20 = m1.m20;
		m21 = m1.m21;
		m22 = m1.m22;
		return this;
	}

	/**
	 * Sets the specified row of this matrix4f to the four values provided.
	 *
	 * @param row the row number to be modified (zero indexed)
	 * @param x the first column element
	 * @param y the second column element
	 * @param z the third column element
	 * @param w the fourth column element
	 * @return this for chaining
	 */
	public final Matrix4f setRow(int row, float x, float y, float z, float w) {
		switch (row) {
			case 0:
				this.m00 = x;
				this.m01 = y;
				this.m02 = z;
				this.m03 = w;
				break;

			case 1:
				this.m10 = x;
				this.m11 = y;
				this.m12 = z;
				this.m13 = w;
				break;

			case 2:
				this.m20 = x;
				this.m21 = y;
				this.m22 = z;
				this.m23 = w;
				break;

			case 3:
				this.m30 = x;
				this.m31 = y;
				this.m32 = z;
				this.m33 = w;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;
	}

	/**
	 * Sets the specified row of this matrix4f to the Vector provided.
	 *
	 * @param row the row number to be modified (zero indexed)
	 * @param v the replacement row
	 * @return this for chaining
	 */
	public final Matrix4f setRow(int row, Vector4f v) {
		switch (row) {
			case 0:
				this.m00 = v.x;
				this.m01 = v.y;
				this.m02 = v.z;
				this.m03 = v.w;
				break;

			case 1:
				this.m10 = v.x;
				this.m11 = v.y;
				this.m12 = v.z;
				this.m13 = v.w;
				break;

			case 2:
				this.m20 = v.x;
				this.m21 = v.y;
				this.m22 = v.z;
				this.m23 = v.w;
				break;

			case 3:
				this.m30 = v.x;
				this.m31 = v.y;
				this.m32 = v.z;
				this.m33 = v.w;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;
	}

	/**
	 * Sets the specified row of this matrix4f to the four values provided in the passed array.
	 *
	 * @param row the row number to be modified (zero indexed)
	 * @param v the replacement row
	 * @return this for chaining
	 */
	public final Matrix4f setRow(int row, float v[]) {
		switch (row) {
			case 0:
				this.m00 = v[0];
				this.m01 = v[1];
				this.m02 = v[2];
				this.m03 = v[3];
				break;

			case 1:
				this.m10 = v[0];
				this.m11 = v[1];
				this.m12 = v[2];
				this.m13 = v[3];
				break;

			case 2:
				this.m20 = v[0];
				this.m21 = v[1];
				this.m22 = v[2];
				this.m23 = v[3];
				break;

			case 3:
				this.m30 = v[0];
				this.m31 = v[1];
				this.m32 = v[2];
				this.m33 = v[3];
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;

	}

	/**
	 * Sets the specified column of this matrix4f to the four values provided.
	 *
	 * @param column the column number to be modified (zero indexed)
	 * @param x the first row element
	 * @param y the second row element
	 * @param z the third row element
	 * @param w the fourth row element
	 * @return this for chaining
	 */
	public final Matrix4f setColumn(int column, float x, float y, float z, float w) {
		switch (column) {
			case 0:
				this.m00 = x;
				this.m10 = y;
				this.m20 = z;
				this.m30 = w;
				break;

			case 1:
				this.m01 = x;
				this.m11 = y;
				this.m21 = z;
				this.m31 = w;
				break;

			case 2:
				this.m02 = x;
				this.m12 = y;
				this.m22 = z;
				this.m32 = w;
				break;

			case 3:
				this.m03 = x;
				this.m13 = y;
				this.m23 = z;
				this.m33 = w;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;

	}

	/**
	 * Sets the specified column of this matrix4f to the vector provided.
	 *
	 * @param column the column number to be modified (zero indexed)
	 * @param v the replacement column
	 * @return this for chaining
	 */
	public final Matrix4f setColumn(int column, Vector4f v) {
		switch (column) {
			case 0:
				this.m00 = v.x;
				this.m10 = v.y;
				this.m20 = v.z;
				this.m30 = v.w;
				break;

			case 1:
				this.m01 = v.x;
				this.m11 = v.y;
				this.m21 = v.z;
				this.m31 = v.w;
				break;

			case 2:
				this.m02 = v.x;
				this.m12 = v.y;
				this.m22 = v.z;
				this.m32 = v.w;
				break;

			case 3:
				this.m03 = v.x;
				this.m13 = v.y;
				this.m23 = v.z;
				this.m33 = v.w;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;

	}

	/**
	 * Sets the specified column of this matrix4f to the four values provided.
	 *
	 * @param column the column number to be modified (zero indexed)
	 * @param v the replacement column
	 * @return this for chaining
	 */
	public final Matrix4f setColumn(int column, float v[]) {
		switch (column) {
			case 0:
				this.m00 = v[0];
				this.m10 = v[1];
				this.m20 = v[2];
				this.m30 = v[3];
				break;

			case 1:
				this.m01 = v[0];
				this.m11 = v[1];
				this.m21 = v[2];
				this.m31 = v[3];
				break;

			case 2:
				this.m02 = v[0];
				this.m12 = v[1];
				this.m22 = v[2];
				this.m32 = v[3];
				break;

			case 3:
				this.m03 = v[0];
				this.m13 = v[1];
				this.m23 = v[2];
				this.m33 = v[3];
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;

	}

	/**
	 * Adds a scalar to each component of this matrix.
	 *
	 * @param scalar the scalar adder
	 * @return this for chaining
	 */
	public final Matrix4f add(float scalar) {
		m00 += scalar;
		m01 += scalar;
		m02 += scalar;
		m03 += scalar;
		m10 += scalar;
		m11 += scalar;
		m12 += scalar;
		m13 += scalar;
		m20 += scalar;
		m21 += scalar;
		m22 += scalar;
		m23 += scalar;
		m30 += scalar;
		m31 += scalar;
		m32 += scalar;
		m33 += scalar;
		return this;

	}

	/**
	 * Adds a scalar to each component of the matrix m1 and places the result into this. Matrix m1 is not modified.
	 *
	 * @param scalar the scalar adder
	 * @param m1 the original matrix values
	 * @return this for chaining
	 */
	public final Matrix4f add(float scalar, Matrix4f m1) {
		this.m00 = m1.m00 + scalar;
		this.m01 = m1.m01 + scalar;
		this.m02 = m1.m02 + scalar;
		this.m03 = m1.m03 + scalar;
		this.m10 = m1.m10 + scalar;
		this.m11 = m1.m11 + scalar;
		this.m12 = m1.m12 + scalar;
		this.m13 = m1.m13 + scalar;
		this.m20 = m1.m20 + scalar;
		this.m21 = m1.m21 + scalar;
		this.m22 = m1.m22 + scalar;
		this.m23 = m1.m23 + scalar;
		this.m30 = m1.m30 + scalar;
		this.m31 = m1.m31 + scalar;
		this.m32 = m1.m32 + scalar;
		this.m33 = m1.m33 + scalar;
		return this;

	}

	/**
	 * Sets the value of this matrix to the matrix sum of matrices m1 and m2.
	 *
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * @return this for chaining
	 */
	public final Matrix4f add(Matrix4f m1, Matrix4f m2) {
		this.m00 = m1.m00 + m2.m00;
		this.m01 = m1.m01 + m2.m01;
		this.m02 = m1.m02 + m2.m02;
		this.m03 = m1.m03 + m2.m03;

		this.m10 = m1.m10 + m2.m10;
		this.m11 = m1.m11 + m2.m11;
		this.m12 = m1.m12 + m2.m12;
		this.m13 = m1.m13 + m2.m13;

		this.m20 = m1.m20 + m2.m20;
		this.m21 = m1.m21 + m2.m21;
		this.m22 = m1.m22 + m2.m22;
		this.m23 = m1.m23 + m2.m23;

		this.m30 = m1.m30 + m2.m30;
		this.m31 = m1.m31 + m2.m31;
		this.m32 = m1.m32 + m2.m32;
		this.m33 = m1.m33 + m2.m33;
		return this;

	}

	/**
	 * Sets the value of this matrix to the sum of itself and matrix m1.
	 *
	 * @param m1 the other matrix
	 * @return this for chaining
	 */
	public final Matrix4f add(Matrix4f m1) {
		this.m00 += m1.m00;
		this.m01 += m1.m01;
		this.m02 += m1.m02;
		this.m03 += m1.m03;

		this.m10 += m1.m10;
		this.m11 += m1.m11;
		this.m12 += m1.m12;
		this.m13 += m1.m13;

		this.m20 += m1.m20;
		this.m21 += m1.m21;
		this.m22 += m1.m22;
		this.m23 += m1.m23;

		this.m30 += m1.m30;
		this.m31 += m1.m31;
		this.m32 += m1.m32;
		this.m33 += m1.m33;
		return this;

	}

	/**
	 * Performs an element-by-element subtraction of matrix m2 from matrix m1 and places the result into matrix this (this
	 * = m2 - m1).
	 *
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * @return this for chaining
	 */
	public final Matrix4f sub(Matrix4f m1, Matrix4f m2) {
		this.m00 = m1.m00 - m2.m00;
		this.m01 = m1.m01 - m2.m01;
		this.m02 = m1.m02 - m2.m02;
		this.m03 = m1.m03 - m2.m03;

		this.m10 = m1.m10 - m2.m10;
		this.m11 = m1.m11 - m2.m11;
		this.m12 = m1.m12 - m2.m12;
		this.m13 = m1.m13 - m2.m13;

		this.m20 = m1.m20 - m2.m20;
		this.m21 = m1.m21 - m2.m21;
		this.m22 = m1.m22 - m2.m22;
		this.m23 = m1.m23 - m2.m23;

		this.m30 = m1.m30 - m2.m30;
		this.m31 = m1.m31 - m2.m31;
		this.m32 = m1.m32 - m2.m32;
		this.m33 = m1.m33 - m2.m33;
		return this;

	}

	/**
	 * Sets this matrix to the matrix difference of itself and matrix m1 (this = this - m1).
	 *
	 * @param m1 the other matrix
	 * @return this for chaining
	 */
	public final Matrix4f sub(Matrix4f m1) {
		this.m00 -= m1.m00;
		this.m01 -= m1.m01;
		this.m02 -= m1.m02;
		this.m03 -= m1.m03;

		this.m10 -= m1.m10;
		this.m11 -= m1.m11;
		this.m12 -= m1.m12;
		this.m13 -= m1.m13;

		this.m20 -= m1.m20;
		this.m21 -= m1.m21;
		this.m22 -= m1.m22;
		this.m23 -= m1.m23;

		this.m30 -= m1.m30;
		this.m31 -= m1.m31;
		this.m32 -= m1.m32;
		this.m33 -= m1.m33;
		return this;

	}

	/**
	 * Sets the value of this matrix to its transpose in place.
	 *
	 * @return this for chaining
	 */
	public final Matrix4f transpose() {
		float temp;

		temp = this.m10;
		this.m10 = this.m01;
		this.m01 = temp;

		temp = this.m20;
		this.m20 = this.m02;
		this.m02 = temp;

		temp = this.m30;
		this.m30 = this.m03;
		this.m03 = temp;

		temp = this.m21;
		this.m21 = this.m12;
		this.m12 = temp;

		temp = this.m31;
		this.m31 = this.m13;
		this.m13 = temp;

		temp = this.m32;
		this.m32 = this.m23;
		this.m23 = temp;
		return this;

	}

	/**
	 * Sets the value of this matrix to the transpose of the argument matrix.
	 *
	 * @param m1 the matrix to be transposed
	 * @return this for chaining
	 */
	public final Matrix4f transpose(Matrix4f m1) {
		if (this != m1) {
			this.m00 = m1.m00;
			this.m01 = m1.m10;
			this.m02 = m1.m20;
			this.m03 = m1.m30;

			this.m10 = m1.m01;
			this.m11 = m1.m11;
			this.m12 = m1.m21;
			this.m13 = m1.m31;

			this.m20 = m1.m02;
			this.m21 = m1.m12;
			this.m22 = m1.m22;
			this.m23 = m1.m32;

			this.m30 = m1.m03;
			this.m31 = m1.m13;
			this.m32 = m1.m23;
			this.m33 = m1.m33;
		} else {
			this.transpose();
		}
		return this;

	}

	/**
	 * Sets the value of this matrix to the matrix conversion of the single precision quaternion argument.
	 *
	 * @param q1 the quaternion to be converted
	 * @return this for chaining
	 */
	public final Matrix4f set(Quat4f q1) {
		set(new Matrix3f().set(q1));
		return this;
	}

	/**
	 * Sets the value of this matrix to the matrix conversion of the (single precision) axis and angle argument.
	 *
	 * @param a1 the axis and angle to be converted
	 * @return this for chaining
	 */
	public final Matrix4f set(AxisAngle4f a1) {
		set(new Matrix3f().set(a1));
		return this;
	}

	/**
	 * Sets the value of this matrix from the rotation expressed by the quaternion q1, the translation t1, and the scale s.
	 *
	 * @param q1 the rotation expressed as a quaternion
	 * @param t1 the translation
	 * @param s the scale value
	 * @return this for chaining
	 */
	public final Matrix4f set(Quat4f q1, Vector3f t1, float s) {
		Matrix3f rotate = new Matrix3f();
		rotate.set(q1);

		this.m00 = rotate.m00 * s;
		this.m01 = rotate.m01 * s;
		this.m02 = rotate.m02 * s;
		this.m10 = rotate.m10 * s;
		this.m11 = rotate.m11 * s;
		this.m12 = rotate.m12 * s;
		this.m20 = rotate.m20 * s;
		this.m21 = rotate.m21 * s;
		this.m22 = rotate.m22 * s;

		this.m03 = t1.x;
		this.m13 = t1.y;
		this.m23 = t1.z;

		this.m30 = (float) 0.0;
		this.m31 = (float) 0.0;
		this.m32 = (float) 0.0;
		this.m33 = (float) 1.0;
		return this;

	}

	/**
	 * Sets the value of this matrix to a copy of the passed matrix m1.
	 *
	 * @param m1 the matrix to be copied
	 * @return this for chaining
	 */
	public final Matrix4f set(Matrix4f m1) {
		this.m00 = m1.m00;
		this.m01 = m1.m01;
		this.m02 = m1.m02;
		this.m03 = m1.m03;

		this.m10 = m1.m10;
		this.m11 = m1.m11;
		this.m12 = m1.m12;
		this.m13 = m1.m13;

		this.m20 = m1.m20;
		this.m21 = m1.m21;
		this.m22 = m1.m22;
		this.m23 = m1.m23;

		this.m30 = m1.m30;
		this.m31 = m1.m31;
		this.m32 = m1.m32;
		this.m33 = m1.m33;
		return this;

	}

	/**
	 * Sets the value of this matrix to the matrix inverse of the passed (user declared) matrix m1.
	 *
	 * @param m1 the matrix to be inverted
	 * @return this for chaining
	 */
	public final Matrix4f invert(Matrix4f m1) {
		invertGeneral(new Matrix4f(m1).invert());
		return this;
	}

	/**
	 * Inverts this matrix in place.
	 *
	 * @return this for chaining
	 */
	public final Matrix4f invert() {
		invertGeneral(this);
		return this;

	}

	/**
	 * General invert routine. Inverts m1 and places the result in "this". Note that this routine handles both the "this"
	 * version and the non-"this" version.
	 *
	 *
	 */
	private static void invertGeneral(Matrix4f m1) {
		float a0 = m1.m00 * m1.m11 - m1.m01 * m1.m10;
		float a1 = m1.m00 * m1.m12 - m1.m02 * m1.m10;
		float a2 = m1.m00 * m1.m13 - m1.m03 * m1.m10;
		float a3 = m1.m01 * m1.m12 - m1.m02 * m1.m11;
		float a4 = m1.m01 * m1.m13 - m1.m03 * m1.m11;
		float a5 = m1.m02 * m1.m13 - m1.m03 * m1.m12;
		float b0 = m1.m20 * m1.m31 - m1.m21 * m1.m30;
		float b1 = m1.m20 * m1.m32 - m1.m22 * m1.m30;
		float b2 = m1.m20 * m1.m33 - m1.m23 * m1.m30;
		float b3 = m1.m21 * m1.m32 - m1.m22 * m1.m31;
		float b4 = m1.m21 * m1.m33 - m1.m23 * m1.m31;
		float b5 = m1.m22 * m1.m33 - m1.m23 * m1.m32;
		float det = a0 * b5 - a1 * b4 + a2 * b3 + a3 * b2 - a4 * b1 + a5 * b0;

		Matrix4f inverse = new Matrix4f();
		if (det != 0) {
			float invDet = (1.0f) / det;
			inverse.m00 = (+m1.m11 * b5 - m1.m12 * b4 + m1.m13 * b3) * invDet;
			inverse.m01 = (-m1.m01 * b5 + m1.m02 * b4 - m1.m03 * b3) * invDet;
			inverse.m02 = (+m1.m31 * a5 - m1.m32 * a4 + m1.m33 * a3) * invDet;
			inverse.m03 = (-m1.m21 * a5 + m1.m22 * a4 - m1.m23 * a3) * invDet;
			inverse.m10 = (-m1.m10 * b5 + m1.m12 * b2 - m1.m13 * b1) * invDet;
			inverse.m11 = (+m1.m00 * b5 - m1.m02 * b2 + m1.m03 * b1) * invDet;
			inverse.m12 = (-m1.m30 * a5 + m1.m32 * a2 - m1.m33 * a1) * invDet;
			inverse.m13 = (+m1.m20 * a5 - m1.m22 * a2 + m1.m23 * a1) * invDet;
			inverse.m20 = (+m1.m10 * b4 - m1.m11 * b2 + m1.m13 * b0) * invDet;
			inverse.m21 = (-m1.m00 * b4 + m1.m01 * b2 - m1.m03 * b0) * invDet;
			inverse.m22 = (+m1.m30 * a4 - m1.m31 * a2 + m1.m33 * a0) * invDet;
			inverse.m23 = (-m1.m20 * a4 + m1.m21 * a2 - m1.m23 * a0) * invDet;
			inverse.m30 = (-m1.m10 * b3 + m1.m11 * b1 - m1.m12 * b0) * invDet;
			inverse.m31 = (+m1.m00 * b3 - m1.m01 * b1 + m1.m02 * b0) * invDet;
			inverse.m32 = (-m1.m30 * a3 + m1.m31 * a1 - m1.m32 * a0) * invDet;
			inverse.m33 = (+m1.m20 * a3 - m1.m21 * a1 + m1.m22 * a0) * invDet;
		} else {
			/*
			 * will output a zeroed matrix
			 *
			 */
		}
		m1.set(inverse);
	}

	/**
	 * Computes the determinate of this matrix.
	 *
	 * @return the determinate of the matrix
	 */
	public final float determinant() {
		float det;

		// cofactor exapainsion along first row 
		det = m00 * (m11 * m22 * m33 + m12 * m23 * m31 + m13 * m21 * m32 -
			m13 * m22 * m31 - m11 * m23 * m32 - m12 * m21 * m33);
		det -= m01 * (m10 * m22 * m33 + m12 * m23 * m30 + m13 * m20 * m32 -
			m13 * m22 * m30 - m10 * m23 * m32 - m12 * m20 * m33);
		det += m02 * (m10 * m21 * m33 + m11 * m23 * m30 + m13 * m20 * m31 -
			m13 * m21 * m30 - m10 * m23 * m31 - m11 * m20 * m33);
		det -= m03 * (m10 * m21 * m32 + m11 * m22 * m30 + m12 * m20 * m31 -
			m12 * m21 * m30 - m10 * m22 * m31 - m11 * m20 * m32);

		return (det);
	}

	/**
	 * Sets the rotational component (upper 3x3) of this matrix to the matrix values in the single precision Matrix3f
	 * argument; the other elements of this matrix are initialized as if this were an identity matrix (i.e., affine matrix
	 * with no translational component).
	 *
	 * @param m1 the single-precision 3x3 matrix
	 * @return this for chaining
	 */
	public final Matrix4f set(Matrix3f m1) {
		m00 = m1.m00;
		m01 = m1.m01;
		m02 = m1.m02;
		m03 = 0.0f;
		m10 = m1.m10;
		m11 = m1.m11;
		m12 = m1.m12;
		m13 = 0.0f;
		m20 = m1.m20;
		m21 = m1.m21;
		m22 = m1.m22;
		m23 = 0.0f;
		m30 = 0.0f;
		m31 = 0.0f;
		m32 = 0.0f;
		m33 = 1.0f;
		return this;
	}

	/**
	 * Sets the value of this matrix to a scale matrix with the the passed scale amount.
	 *
	 * @param scale the scale factor for the matrix
	 * @return this for chaining
	 */
	public final Matrix4f set(float scale) {
		this.m00 = scale;
		this.m01 = (float) 0.0;
		this.m02 = (float) 0.0;
		this.m03 = (float) 0.0;

		this.m10 = (float) 0.0;
		this.m11 = scale;
		this.m12 = (float) 0.0;
		this.m13 = (float) 0.0;

		this.m20 = (float) 0.0;
		this.m21 = (float) 0.0;
		this.m22 = scale;
		this.m23 = (float) 0.0;

		this.m30 = (float) 0.0;
		this.m31 = (float) 0.0;
		this.m32 = (float) 0.0;
		this.m33 = (float) 1.0;
		return this;

	}

	/**
	 * Sets the values in this Matrix4f equal to the row-major array parameter (ie, the first four elements of the array
	 * will be copied into the first row of this matrix, etc.).
	 *
	 * @param m the single precision array of length 16
	 * @return this for chaining
	 */
	public final Matrix4f set(float[] m) {
		m00 = m[0];
		m01 = m[1];
		m02 = m[2];
		m03 = m[3];
		m10 = m[4];
		m11 = m[5];
		m12 = m[6];
		m13 = m[7];
		m20 = m[8];
		m21 = m[9];
		m22 = m[10];
		m23 = m[11];
		m30 = m[12];
		m31 = m[13];
		m32 = m[14];
		m33 = m[15];
		return this;

	}

	/**
	 * Sets the value of this matrix to a translate matrix with the passed translation value.
	 *
	 * @param v1 the translation amount
	 * @return this for chaining
	 */
	public final Matrix4f set(Vector3f v1) {
		this.m00 = (float) 1.0;
		this.m01 = (float) 0.0;
		this.m02 = (float) 0.0;
		this.m03 = v1.x;

		this.m10 = (float) 0.0;
		this.m11 = (float) 1.0;
		this.m12 = (float) 0.0;
		this.m13 = v1.y;

		this.m20 = (float) 0.0;
		this.m21 = (float) 0.0;
		this.m22 = (float) 1.0;
		this.m23 = v1.z;

		this.m30 = (float) 0.0;
		this.m31 = (float) 0.0;
		this.m32 = (float) 0.0;
		this.m33 = (float) 1.0;
		return this;

	}

	/**
	 * Sets the value of this transform to a scale and translation matrix; the scale is not applied to the translation and
	 * all of the matrix values are modified.
	 *
	 * @param scale the scale factor for the matrix
	 * @param t1 the translation amount
	 * @return this for chaining
	 */
	public final Matrix4f set(float scale, Vector3f t1) {
		this.m00 = scale;
		this.m01 = (float) 0.0;
		this.m02 = (float) 0.0;
		this.m03 = t1.x;

		this.m10 = (float) 0.0;
		this.m11 = scale;
		this.m12 = (float) 0.0;
		this.m13 = t1.y;

		this.m20 = (float) 0.0;
		this.m21 = (float) 0.0;
		this.m22 = scale;
		this.m23 = t1.z;

		this.m30 = (float) 0.0;
		this.m31 = (float) 0.0;
		this.m32 = (float) 0.0;
		this.m33 = (float) 1.0;
		return this;

	}

	/**
	 * Sets the value of this transform to a scale and translation matrix; the translation is scaled by the scale factor
	 * and all of the matrix values are modified.
	 *
	 * @param t1 the translation amount
	 * @param scale the scale factor for the matrix
	 * @return this for chaining
	 */
	public final Matrix4f set(Vector3f t1, float scale) {
		this.m00 = scale;
		this.m01 = (float) 0.0;
		this.m02 = (float) 0.0;
		this.m03 = scale * t1.x;

		this.m10 = (float) 0.0;
		this.m11 = scale;
		this.m12 = (float) 0.0;
		this.m13 = scale * t1.y;

		this.m20 = (float) 0.0;
		this.m21 = (float) 0.0;
		this.m22 = scale;
		this.m23 = scale * t1.z;

		this.m30 = (float) 0.0;
		this.m31 = (float) 0.0;
		this.m32 = (float) 0.0;
		this.m33 = (float) 1.0;
		return this;

	}

	/**
	 * Sets the value of this matrix from the rotation expressed by the rotation matrix m1, the translation t1, and the
	 * scale factor. The translation is not modified by the scale.
	 *
	 * @param m1 the rotation component
	 * @param t1 the translation component
	 * @param scale the scale component
	 * @return this for chaining
	 */
	public final Matrix4f set(Matrix3f m1, Vector3f t1, float scale) {
		this.m00 = m1.m00 * scale;
		this.m01 = m1.m01 * scale;
		this.m02 = m1.m02 * scale;
		this.m03 = t1.x;

		this.m10 = m1.m10 * scale;
		this.m11 = m1.m11 * scale;
		this.m12 = m1.m12 * scale;
		this.m13 = t1.y;

		this.m20 = m1.m20 * scale;
		this.m21 = m1.m21 * scale;
		this.m22 = m1.m22 * scale;
		this.m23 = t1.z;

		this.m30 = 0.0f;
		this.m31 = 0.0f;
		this.m32 = 0.0f;
		this.m33 = 1.0f;
		return this;

	}

	/**
	 * Modifies the translational components of this matrix to the values of the Vector3f argument; the other values of
	 * this matrix are not modified.
	 *
	 * @param trans the translational component
	 * @return this for chaining
	 */
	public final Matrix4f setTranslation(Tuple3f trans) {
		m03 = trans.x;
		m13 = trans.y;
		m23 = trans.z;
		return this;

	}
	
	/**
	 * Modifies the translational components of this matrix to the values of the x,y,z arguments; the other values of
	 * this matrix are not modified.
	 *
	 * @param x
	 * @param y
	 * @param z
	 * @return this for chaining
	 */
	public final Matrix4f setTranslation(float x, float y, float z) {
		m03 = x;
		m13 = y;
		m23 = z;
		return this;

	}

	/**
	 * Sets the value of this matrix to a counter clockwise rotation about the x axis.
	 *
	 * @param angle the angle to rotate about the X axis in radians
	 * @return this for chaining
	 */
	public final Matrix4f rotX(float angle) {
		float sinAngle, cosAngle;

		sinAngle = (float) Math.sin(angle);
		cosAngle = (float) Math.cos(angle);

		this.m00 = (float) 1.0;
		this.m01 = (float) 0.0;
		this.m02 = (float) 0.0;
		this.m03 = (float) 0.0;

		this.m10 = (float) 0.0;
		this.m11 = cosAngle;
		this.m12 = -sinAngle;
		this.m13 = (float) 0.0;

		this.m20 = (float) 0.0;
		this.m21 = sinAngle;
		this.m22 = cosAngle;
		this.m23 = (float) 0.0;

		this.m30 = (float) 0.0;
		this.m31 = (float) 0.0;
		this.m32 = (float) 0.0;
		this.m33 = (float) 1.0;
		return this;

	}

	/**
	 * Sets the value of this matrix to a counter clockwise rotation about the y axis.
	 *
	 * @param angle the angle to rotate about the Y axis in radians
	 * @return this for chaining
	 */
	public final Matrix4f rotY(float angle) {
		float sinAngle, cosAngle;

		sinAngle = (float) Math.sin(angle);
		cosAngle = (float) Math.cos(angle);

		this.m00 = cosAngle;
		this.m01 = (float) 0.0;
		this.m02 = sinAngle;
		this.m03 = (float) 0.0;

		this.m10 = (float) 0.0;
		this.m11 = (float) 1.0;
		this.m12 = (float) 0.0;
		this.m13 = (float) 0.0;

		this.m20 = -sinAngle;
		this.m21 = (float) 0.0;
		this.m22 = cosAngle;
		this.m23 = (float) 0.0;

		this.m30 = (float) 0.0;
		this.m31 = (float) 0.0;
		this.m32 = (float) 0.0;
		this.m33 = (float) 1.0;
		return this;

	}

	/**
	 * Sets the value of this matrix to a counter clockwise rotation about the z axis.
	 *
	 * @param angle the angle to rotate about the Z axis in radians
	 * @return this for chaining
	 */
	public final Matrix4f rotZ(float angle) {
		float sinAngle, cosAngle;

		sinAngle = (float) Math.sin(angle);
		cosAngle = (float) Math.cos(angle);

		this.m00 = cosAngle;
		this.m01 = -sinAngle;
		this.m02 = (float) 0.0;
		this.m03 = (float) 0.0;

		this.m10 = sinAngle;
		this.m11 = cosAngle;
		this.m12 = (float) 0.0;
		this.m13 = (float) 0.0;

		this.m20 = (float) 0.0;
		this.m21 = (float) 0.0;
		this.m22 = (float) 1.0;
		this.m23 = (float) 0.0;

		this.m30 = (float) 0.0;
		this.m31 = (float) 0.0;
		this.m32 = (float) 0.0;
		this.m33 = (float) 1.0;
		return this;

	}

	/**
	 * Multiplies each element of this matrix by a scalar.
	 *
	 * @param scalar the scalar multiplier.
	 * @return this for chaining
	 */
	public final Matrix4f mul(float scalar) {
		m00 *= scalar;
		m01 *= scalar;
		m02 *= scalar;
		m03 *= scalar;
		m10 *= scalar;
		m11 *= scalar;
		m12 *= scalar;
		m13 *= scalar;
		m20 *= scalar;
		m21 *= scalar;
		m22 *= scalar;
		m23 *= scalar;
		m30 *= scalar;
		m31 *= scalar;
		m32 *= scalar;
		m33 *= scalar;
		return this;

	}

	/**
	 * Multiplies each element of matrix m1 by a scalar and places the result into this. Matrix m1 is not modified.
	 *
	 * @param scalar the scalar multiplier.
	 * @param m1 the original matrix.
	 * @return this for chaining
	 */
	public final Matrix4f mul(float scalar, Matrix4f m1) {
		this.m00 = m1.m00 * scalar;
		this.m01 = m1.m01 * scalar;
		this.m02 = m1.m02 * scalar;
		this.m03 = m1.m03 * scalar;
		this.m10 = m1.m10 * scalar;
		this.m11 = m1.m11 * scalar;
		this.m12 = m1.m12 * scalar;
		this.m13 = m1.m13 * scalar;
		this.m20 = m1.m20 * scalar;
		this.m21 = m1.m21 * scalar;
		this.m22 = m1.m22 * scalar;
		this.m23 = m1.m23 * scalar;
		this.m30 = m1.m30 * scalar;
		this.m31 = m1.m31 * scalar;
		this.m32 = m1.m32 * scalar;
		this.m33 = m1.m33 * scalar;
		return this;

	}

	/**
	 * Sets the value of this matrix to the result of multiplying itself with matrix m1.
	 *
	 * @param m1 the other matrix
	 * @return this for chaining
	 */
	public final Matrix4f mul(Matrix4f m1) {
		float n00, n01, n02, n03,
			n10, n11, n12, n13,
			n20, n21, n22, n23,
			n30, n31, n32, n33;  // vars for temp result matrix

		n00 = this.m00 * m1.m00 + this.m01 * m1.m10 +
			this.m02 * m1.m20 + this.m03 * m1.m30;
		n01 = this.m00 * m1.m01 + this.m01 * m1.m11 +
			this.m02 * m1.m21 + this.m03 * m1.m31;
		n02 = this.m00 * m1.m02 + this.m01 * m1.m12 +
			this.m02 * m1.m22 + this.m03 * m1.m32;
		n03 = this.m00 * m1.m03 + this.m01 * m1.m13 +
			this.m02 * m1.m23 + this.m03 * m1.m33;

		n10 = this.m10 * m1.m00 + this.m11 * m1.m10 +
			this.m12 * m1.m20 + this.m13 * m1.m30;
		n11 = this.m10 * m1.m01 + this.m11 * m1.m11 +
			this.m12 * m1.m21 + this.m13 * m1.m31;
		n12 = this.m10 * m1.m02 + this.m11 * m1.m12 +
			this.m12 * m1.m22 + this.m13 * m1.m32;
		n13 = this.m10 * m1.m03 + this.m11 * m1.m13 +
			this.m12 * m1.m23 + this.m13 * m1.m33;

		n20 = this.m20 * m1.m00 + this.m21 * m1.m10 +
			this.m22 * m1.m20 + this.m23 * m1.m30;
		n21 = this.m20 * m1.m01 + this.m21 * m1.m11 +
			this.m22 * m1.m21 + this.m23 * m1.m31;
		n22 = this.m20 * m1.m02 + this.m21 * m1.m12 +
			this.m22 * m1.m22 + this.m23 * m1.m32;
		n23 = this.m20 * m1.m03 + this.m21 * m1.m13 +
			this.m22 * m1.m23 + this.m23 * m1.m33;

		n30 = this.m30 * m1.m00 + this.m31 * m1.m10 +
			this.m32 * m1.m20 + this.m33 * m1.m30;
		n31 = this.m30 * m1.m01 + this.m31 * m1.m11 +
			this.m32 * m1.m21 + this.m33 * m1.m31;
		n32 = this.m30 * m1.m02 + this.m31 * m1.m12 +
			this.m32 * m1.m22 + this.m33 * m1.m32;
		n33 = this.m30 * m1.m03 + this.m31 * m1.m13 +
			this.m32 * m1.m23 + this.m33 * m1.m33;

		this.m00 = n00;
		this.m01 = n01;
		this.m02 = n02;
		this.m03 = n03;
		this.m10 = n10;
		this.m11 = n11;
		this.m12 = n12;
		this.m13 = n13;
		this.m20 = n20;
		this.m21 = n21;
		this.m22 = n22;
		this.m23 = n23;
		this.m30 = n30;
		this.m31 = n31;
		this.m32 = n32;
		this.m33 = n33;
		return this;

	}

	/**
	 * Sets the value of this matrix to the result of multiplying the two argument matrices together.
	 *
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * @return this for chaining
	 */
	public final Matrix4f mul(Matrix4f m1, Matrix4f m2) {
		if (this != m1 && this != m2) {

			this.m00 = m1.m00 * m2.m00 + m1.m01 * m2.m10 +
				m1.m02 * m2.m20 + m1.m03 * m2.m30;
			this.m01 = m1.m00 * m2.m01 + m1.m01 * m2.m11 +
				m1.m02 * m2.m21 + m1.m03 * m2.m31;
			this.m02 = m1.m00 * m2.m02 + m1.m01 * m2.m12 +
				m1.m02 * m2.m22 + m1.m03 * m2.m32;
			this.m03 = m1.m00 * m2.m03 + m1.m01 * m2.m13 +
				m1.m02 * m2.m23 + m1.m03 * m2.m33;

			this.m10 = m1.m10 * m2.m00 + m1.m11 * m2.m10 +
				m1.m12 * m2.m20 + m1.m13 * m2.m30;
			this.m11 = m1.m10 * m2.m01 + m1.m11 * m2.m11 +
				m1.m12 * m2.m21 + m1.m13 * m2.m31;
			this.m12 = m1.m10 * m2.m02 + m1.m11 * m2.m12 +
				m1.m12 * m2.m22 + m1.m13 * m2.m32;
			this.m13 = m1.m10 * m2.m03 + m1.m11 * m2.m13 +
				m1.m12 * m2.m23 + m1.m13 * m2.m33;

			this.m20 = m1.m20 * m2.m00 + m1.m21 * m2.m10 +
				m1.m22 * m2.m20 + m1.m23 * m2.m30;
			this.m21 = m1.m20 * m2.m01 + m1.m21 * m2.m11 +
				m1.m22 * m2.m21 + m1.m23 * m2.m31;
			this.m22 = m1.m20 * m2.m02 + m1.m21 * m2.m12 +
				m1.m22 * m2.m22 + m1.m23 * m2.m32;
			this.m23 = m1.m20 * m2.m03 + m1.m21 * m2.m13 +
				m1.m22 * m2.m23 + m1.m23 * m2.m33;

			this.m30 = m1.m30 * m2.m00 + m1.m31 * m2.m10 +
				m1.m32 * m2.m20 + m1.m33 * m2.m30;
			this.m31 = m1.m30 * m2.m01 + m1.m31 * m2.m11 +
				m1.m32 * m2.m21 + m1.m33 * m2.m31;
			this.m32 = m1.m30 * m2.m02 + m1.m31 * m2.m12 +
				m1.m32 * m2.m22 + m1.m33 * m2.m32;
			this.m33 = m1.m30 * m2.m03 + m1.m31 * m2.m13 +
				m1.m32 * m2.m23 + m1.m33 * m2.m33;
		} else {
			float n00, n01, n02, n03,
				n10, n11, n12, n13,
				n20, n21, n22, n23,
				n30, n31, n32, n33;  // vars for temp result matrix
			n00 = m1.m00 * m2.m00 + m1.m01 * m2.m10 + m1.m02 * m2.m20 + m1.m03 * m2.m30;
			n01 = m1.m00 * m2.m01 + m1.m01 * m2.m11 + m1.m02 * m2.m21 + m1.m03 * m2.m31;
			n02 = m1.m00 * m2.m02 + m1.m01 * m2.m12 + m1.m02 * m2.m22 + m1.m03 * m2.m32;
			n03 = m1.m00 * m2.m03 + m1.m01 * m2.m13 + m1.m02 * m2.m23 + m1.m03 * m2.m33;

			n10 = m1.m10 * m2.m00 + m1.m11 * m2.m10 + m1.m12 * m2.m20 + m1.m13 * m2.m30;
			n11 = m1.m10 * m2.m01 + m1.m11 * m2.m11 + m1.m12 * m2.m21 + m1.m13 * m2.m31;
			n12 = m1.m10 * m2.m02 + m1.m11 * m2.m12 + m1.m12 * m2.m22 + m1.m13 * m2.m32;
			n13 = m1.m10 * m2.m03 + m1.m11 * m2.m13 + m1.m12 * m2.m23 + m1.m13 * m2.m33;

			n20 = m1.m20 * m2.m00 + m1.m21 * m2.m10 + m1.m22 * m2.m20 + m1.m23 * m2.m30;
			n21 = m1.m20 * m2.m01 + m1.m21 * m2.m11 + m1.m22 * m2.m21 + m1.m23 * m2.m31;
			n22 = m1.m20 * m2.m02 + m1.m21 * m2.m12 + m1.m22 * m2.m22 + m1.m23 * m2.m32;
			n23 = m1.m20 * m2.m03 + m1.m21 * m2.m13 + m1.m22 * m2.m23 + m1.m23 * m2.m33;

			n30 = m1.m30 * m2.m00 + m1.m31 * m2.m10 + m1.m32 * m2.m20 + m1.m33 * m2.m30;
			n31 = m1.m30 * m2.m01 + m1.m31 * m2.m11 + m1.m32 * m2.m21 + m1.m33 * m2.m31;
			n32 = m1.m30 * m2.m02 + m1.m31 * m2.m12 + m1.m32 * m2.m22 + m1.m33 * m2.m32;
			n33 = m1.m30 * m2.m03 + m1.m31 * m2.m13 + m1.m32 * m2.m23 + m1.m33 * m2.m33;

			this.m00 = n00;
			this.m01 = n01;
			this.m02 = n02;
			this.m03 = n03;
			this.m10 = n10;
			this.m11 = n11;
			this.m12 = n12;
			this.m13 = n13;
			this.m20 = n20;
			this.m21 = n21;
			this.m22 = n22;
			this.m23 = n23;
			this.m30 = n30;
			this.m31 = n31;
			this.m32 = n32;
			this.m33 = n33;
		}
		return this;

	}

	/**
	 * Multiplies the transpose of matrix m1 times the transpose of matrix m2, and places the result into this.
	 *
	 * @param m1 the matrix on the left hand side of the multiplication
	 * @param m2 the matrix on the right hand side of the multiplication
	 * @return this for chaining
	 */
	public final Matrix4f mulTransposeBoth(Matrix4f m1, Matrix4f m2) {
		if (this != m1 && this != m2) {
			this.m00 = m1.m00 * m2.m00 + m1.m10 * m2.m01 + m1.m20 * m2.m02 + m1.m30 *
				m2.m03;
			this.m01 = m1.m00 * m2.m10 + m1.m10 * m2.m11 + m1.m20 * m2.m12 + m1.m30 *
				m2.m13;
			this.m02 = m1.m00 * m2.m20 + m1.m10 * m2.m21 + m1.m20 * m2.m22 + m1.m30 *
				m2.m23;
			this.m03 = m1.m00 * m2.m30 + m1.m10 * m2.m31 + m1.m20 * m2.m32 + m1.m30 *
				m2.m33;

			this.m10 = m1.m01 * m2.m00 + m1.m11 * m2.m01 + m1.m21 * m2.m02 + m1.m31 *
				m2.m03;
			this.m11 = m1.m01 * m2.m10 + m1.m11 * m2.m11 + m1.m21 * m2.m12 + m1.m31 *
				m2.m13;
			this.m12 = m1.m01 * m2.m20 + m1.m11 * m2.m21 + m1.m21 * m2.m22 + m1.m31 *
				m2.m23;
			this.m13 = m1.m01 * m2.m30 + m1.m11 * m2.m31 + m1.m21 * m2.m32 + m1.m31 *
				m2.m33;

			this.m20 = m1.m02 * m2.m00 + m1.m12 * m2.m01 + m1.m22 * m2.m02 + m1.m32 *
				m2.m03;
			this.m21 = m1.m02 * m2.m10 + m1.m12 * m2.m11 + m1.m22 * m2.m12 + m1.m32 *
				m2.m13;
			this.m22 = m1.m02 * m2.m20 + m1.m12 * m2.m21 + m1.m22 * m2.m22 + m1.m32 *
				m2.m23;
			this.m23 = m1.m02 * m2.m30 + m1.m12 * m2.m31 + m1.m22 * m2.m32 + m1.m32 *
				m2.m33;

			this.m30 = m1.m03 * m2.m00 + m1.m13 * m2.m01 + m1.m23 * m2.m02 + m1.m33 *
				m2.m03;
			this.m31 = m1.m03 * m2.m10 + m1.m13 * m2.m11 + m1.m23 * m2.m12 + m1.m33 *
				m2.m13;
			this.m32 = m1.m03 * m2.m20 + m1.m13 * m2.m21 + m1.m23 * m2.m22 + m1.m33 *
				m2.m23;
			this.m33 = m1.m03 * m2.m30 + m1.m13 * m2.m31 + m1.m23 * m2.m32 + m1.m33 *
				m2.m33;
		} else {
			float n00, n01, n02, n03,
				n10, n11, n12, n13,
				n20, n21, n22, n23, // vars for temp result matrix
				n30, n31, n32, n33;

			n00 = m1.m00 * m2.m00 + m1.m10 * m2.m01 + m1.m20 * m2.m02 + m1.m30 * m2.m03;
			n01 = m1.m00 * m2.m10 + m1.m10 * m2.m11 + m1.m20 * m2.m12 + m1.m30 * m2.m13;
			n02 = m1.m00 * m2.m20 + m1.m10 * m2.m21 + m1.m20 * m2.m22 + m1.m30 * m2.m23;
			n03 = m1.m00 * m2.m30 + m1.m10 * m2.m31 + m1.m20 * m2.m32 + m1.m30 * m2.m33;

			n10 = m1.m01 * m2.m00 + m1.m11 * m2.m01 + m1.m21 * m2.m02 + m1.m31 * m2.m03;
			n11 = m1.m01 * m2.m10 + m1.m11 * m2.m11 + m1.m21 * m2.m12 + m1.m31 * m2.m13;
			n12 = m1.m01 * m2.m20 + m1.m11 * m2.m21 + m1.m21 * m2.m22 + m1.m31 * m2.m23;
			n13 = m1.m01 * m2.m30 + m1.m11 * m2.m31 + m1.m21 * m2.m32 + m1.m31 * m2.m33;

			n20 = m1.m02 * m2.m00 + m1.m12 * m2.m01 + m1.m22 * m2.m02 + m1.m32 * m2.m03;
			n21 = m1.m02 * m2.m10 + m1.m12 * m2.m11 + m1.m22 * m2.m12 + m1.m32 * m2.m13;
			n22 = m1.m02 * m2.m20 + m1.m12 * m2.m21 + m1.m22 * m2.m22 + m1.m32 * m2.m23;
			n23 = m1.m02 * m2.m30 + m1.m12 * m2.m31 + m1.m22 * m2.m32 + m1.m32 * m2.m33;

			n30 = m1.m03 * m2.m00 + m1.m13 * m2.m01 + m1.m23 * m2.m02 + m1.m33 * m2.m03;
			n31 = m1.m03 * m2.m10 + m1.m13 * m2.m11 + m1.m23 * m2.m12 + m1.m33 * m2.m13;
			n32 = m1.m03 * m2.m20 + m1.m13 * m2.m21 + m1.m23 * m2.m22 + m1.m33 * m2.m23;
			n33 = m1.m03 * m2.m30 + m1.m13 * m2.m31 + m1.m23 * m2.m32 + m1.m33 * m2.m33;

			this.m00 = n00;
			this.m01 = n01;
			this.m02 = n02;
			this.m03 = n03;
			this.m10 = n10;
			this.m11 = n11;
			this.m12 = n12;
			this.m13 = n13;
			this.m20 = n20;
			this.m21 = n21;
			this.m22 = n22;
			this.m23 = n23;
			this.m30 = n30;
			this.m31 = n31;
			this.m32 = n32;
			this.m33 = n33;
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
	public final Matrix4f mulTransposeRight(Matrix4f m1, Matrix4f m2) {
		if (this != m1 && this != m2) {
			this.m00 = m1.m00 * m2.m00 + m1.m01 * m2.m01 + m1.m02 * m2.m02 + m1.m03 *
				m2.m03;
			this.m01 = m1.m00 * m2.m10 + m1.m01 * m2.m11 + m1.m02 * m2.m12 + m1.m03 *
				m2.m13;
			this.m02 = m1.m00 * m2.m20 + m1.m01 * m2.m21 + m1.m02 * m2.m22 + m1.m03 *
				m2.m23;
			this.m03 = m1.m00 * m2.m30 + m1.m01 * m2.m31 + m1.m02 * m2.m32 + m1.m03 *
				m2.m33;

			this.m10 = m1.m10 * m2.m00 + m1.m11 * m2.m01 + m1.m12 * m2.m02 + m1.m13 *
				m2.m03;
			this.m11 = m1.m10 * m2.m10 + m1.m11 * m2.m11 + m1.m12 * m2.m12 + m1.m13 *
				m2.m13;
			this.m12 = m1.m10 * m2.m20 + m1.m11 * m2.m21 + m1.m12 * m2.m22 + m1.m13 *
				m2.m23;
			this.m13 = m1.m10 * m2.m30 + m1.m11 * m2.m31 + m1.m12 * m2.m32 + m1.m13 *
				m2.m33;

			this.m20 = m1.m20 * m2.m00 + m1.m21 * m2.m01 + m1.m22 * m2.m02 + m1.m23 *
				m2.m03;
			this.m21 = m1.m20 * m2.m10 + m1.m21 * m2.m11 + m1.m22 * m2.m12 + m1.m23 *
				m2.m13;
			this.m22 = m1.m20 * m2.m20 + m1.m21 * m2.m21 + m1.m22 * m2.m22 + m1.m23 *
				m2.m23;
			this.m23 = m1.m20 * m2.m30 + m1.m21 * m2.m31 + m1.m22 * m2.m32 + m1.m23 *
				m2.m33;

			this.m30 = m1.m30 * m2.m00 + m1.m31 * m2.m01 + m1.m32 * m2.m02 + m1.m33 *
				m2.m03;
			this.m31 = m1.m30 * m2.m10 + m1.m31 * m2.m11 + m1.m32 * m2.m12 + m1.m33 *
				m2.m13;
			this.m32 = m1.m30 * m2.m20 + m1.m31 * m2.m21 + m1.m32 * m2.m22 + m1.m33 *
				m2.m23;
			this.m33 = m1.m30 * m2.m30 + m1.m31 * m2.m31 + m1.m32 * m2.m32 + m1.m33 *
				m2.m33;
		} else {
			float n00, n01, n02, n03,
				n10, n11, n12, n13,
				n20, n21, n22, n23, // vars for temp result matrix
				n30, n31, n32, n33;

			n00 = m1.m00 * m2.m00 + m1.m01 * m2.m01 + m1.m02 * m2.m02 + m1.m03 * m2.m03;
			n01 = m1.m00 * m2.m10 + m1.m01 * m2.m11 + m1.m02 * m2.m12 + m1.m03 * m2.m13;
			n02 = m1.m00 * m2.m20 + m1.m01 * m2.m21 + m1.m02 * m2.m22 + m1.m03 * m2.m23;
			n03 = m1.m00 * m2.m30 + m1.m01 * m2.m31 + m1.m02 * m2.m32 + m1.m03 * m2.m33;

			n10 = m1.m10 * m2.m00 + m1.m11 * m2.m01 + m1.m12 * m2.m02 + m1.m13 * m2.m03;
			n11 = m1.m10 * m2.m10 + m1.m11 * m2.m11 + m1.m12 * m2.m12 + m1.m13 * m2.m13;
			n12 = m1.m10 * m2.m20 + m1.m11 * m2.m21 + m1.m12 * m2.m22 + m1.m13 * m2.m23;
			n13 = m1.m10 * m2.m30 + m1.m11 * m2.m31 + m1.m12 * m2.m32 + m1.m13 * m2.m33;

			n20 = m1.m20 * m2.m00 + m1.m21 * m2.m01 + m1.m22 * m2.m02 + m1.m23 * m2.m03;
			n21 = m1.m20 * m2.m10 + m1.m21 * m2.m11 + m1.m22 * m2.m12 + m1.m23 * m2.m13;
			n22 = m1.m20 * m2.m20 + m1.m21 * m2.m21 + m1.m22 * m2.m22 + m1.m23 * m2.m23;
			n23 = m1.m20 * m2.m30 + m1.m21 * m2.m31 + m1.m22 * m2.m32 + m1.m23 * m2.m33;

			n30 = m1.m30 * m2.m00 + m1.m31 * m2.m01 + m1.m32 * m2.m02 + m1.m33 * m2.m03;
			n31 = m1.m30 * m2.m10 + m1.m31 * m2.m11 + m1.m32 * m2.m12 + m1.m33 * m2.m13;
			n32 = m1.m30 * m2.m20 + m1.m31 * m2.m21 + m1.m32 * m2.m22 + m1.m33 * m2.m23;
			n33 = m1.m30 * m2.m30 + m1.m31 * m2.m31 + m1.m32 * m2.m32 + m1.m33 * m2.m33;

			this.m00 = n00;
			this.m01 = n01;
			this.m02 = n02;
			this.m03 = n03;
			this.m10 = n10;
			this.m11 = n11;
			this.m12 = n12;
			this.m13 = n13;
			this.m20 = n20;
			this.m21 = n21;
			this.m22 = n22;
			this.m23 = n23;
			this.m30 = n30;
			this.m31 = n31;
			this.m32 = n32;
			this.m33 = n33;
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
	public final Matrix4f mulTransposeLeft(Matrix4f m1, Matrix4f m2) {
		if (this != m1 && this != m2) {
			this.m00 = m1.m00 * m2.m00 + m1.m10 * m2.m10 + m1.m20 * m2.m20 + m1.m30 *
				m2.m30;
			this.m01 = m1.m00 * m2.m01 + m1.m10 * m2.m11 + m1.m20 * m2.m21 + m1.m30 *
				m2.m31;
			this.m02 = m1.m00 * m2.m02 + m1.m10 * m2.m12 + m1.m20 * m2.m22 + m1.m30 *
				m2.m32;
			this.m03 = m1.m00 * m2.m03 + m1.m10 * m2.m13 + m1.m20 * m2.m23 + m1.m30 *
				m2.m33;

			this.m10 = m1.m01 * m2.m00 + m1.m11 * m2.m10 + m1.m21 * m2.m20 + m1.m31 *
				m2.m30;
			this.m11 = m1.m01 * m2.m01 + m1.m11 * m2.m11 + m1.m21 * m2.m21 + m1.m31 *
				m2.m31;
			this.m12 = m1.m01 * m2.m02 + m1.m11 * m2.m12 + m1.m21 * m2.m22 + m1.m31 *
				m2.m32;
			this.m13 = m1.m01 * m2.m03 + m1.m11 * m2.m13 + m1.m21 * m2.m23 + m1.m31 *
				m2.m33;

			this.m20 = m1.m02 * m2.m00 + m1.m12 * m2.m10 + m1.m22 * m2.m20 + m1.m32 *
				m2.m30;
			this.m21 = m1.m02 * m2.m01 + m1.m12 * m2.m11 + m1.m22 * m2.m21 + m1.m32 *
				m2.m31;
			this.m22 = m1.m02 * m2.m02 + m1.m12 * m2.m12 + m1.m22 * m2.m22 + m1.m32 *
				m2.m32;
			this.m23 = m1.m02 * m2.m03 + m1.m12 * m2.m13 + m1.m22 * m2.m23 + m1.m32 *
				m2.m33;

			this.m30 = m1.m03 * m2.m00 + m1.m13 * m2.m10 + m1.m23 * m2.m20 + m1.m33 *
				m2.m30;
			this.m31 = m1.m03 * m2.m01 + m1.m13 * m2.m11 + m1.m23 * m2.m21 + m1.m33 *
				m2.m31;
			this.m32 = m1.m03 * m2.m02 + m1.m13 * m2.m12 + m1.m23 * m2.m22 + m1.m33 *
				m2.m32;
			this.m33 = m1.m03 * m2.m03 + m1.m13 * m2.m13 + m1.m23 * m2.m23 + m1.m33 *
				m2.m33;
		} else {
			float n00, n01, n02, n03,
				n10, n11, n12, n13,
				n20, n21, n22, n23, // vars for temp result matrix
				n30, n31, n32, n33;

			n00 = m1.m00 * m2.m00 + m1.m10 * m2.m10 + m1.m20 * m2.m20 + m1.m30 * m2.m30;
			n01 = m1.m00 * m2.m01 + m1.m10 * m2.m11 + m1.m20 * m2.m21 + m1.m30 * m2.m31;
			n02 = m1.m00 * m2.m02 + m1.m10 * m2.m12 + m1.m20 * m2.m22 + m1.m30 * m2.m32;
			n03 = m1.m00 * m2.m03 + m1.m10 * m2.m13 + m1.m20 * m2.m23 + m1.m30 * m2.m33;

			n10 = m1.m01 * m2.m00 + m1.m11 * m2.m10 + m1.m21 * m2.m20 + m1.m31 * m2.m30;
			n11 = m1.m01 * m2.m01 + m1.m11 * m2.m11 + m1.m21 * m2.m21 + m1.m31 * m2.m31;
			n12 = m1.m01 * m2.m02 + m1.m11 * m2.m12 + m1.m21 * m2.m22 + m1.m31 * m2.m32;
			n13 = m1.m01 * m2.m03 + m1.m11 * m2.m13 + m1.m21 * m2.m23 + m1.m31 * m2.m33;

			n20 = m1.m02 * m2.m00 + m1.m12 * m2.m10 + m1.m22 * m2.m20 + m1.m32 * m2.m30;
			n21 = m1.m02 * m2.m01 + m1.m12 * m2.m11 + m1.m22 * m2.m21 + m1.m32 * m2.m31;
			n22 = m1.m02 * m2.m02 + m1.m12 * m2.m12 + m1.m22 * m2.m22 + m1.m32 * m2.m32;
			n23 = m1.m02 * m2.m03 + m1.m12 * m2.m13 + m1.m22 * m2.m23 + m1.m32 * m2.m33;

			n30 = m1.m03 * m2.m00 + m1.m13 * m2.m10 + m1.m23 * m2.m20 + m1.m33 * m2.m30;
			n31 = m1.m03 * m2.m01 + m1.m13 * m2.m11 + m1.m23 * m2.m21 + m1.m33 * m2.m31;
			n32 = m1.m03 * m2.m02 + m1.m13 * m2.m12 + m1.m23 * m2.m22 + m1.m33 * m2.m32;
			n33 = m1.m03 * m2.m03 + m1.m13 * m2.m13 + m1.m23 * m2.m23 + m1.m33 * m2.m33;

			this.m00 = n00;
			this.m01 = n01;
			this.m02 = n02;
			this.m03 = n03;
			this.m10 = n10;
			this.m11 = n11;
			this.m12 = n12;
			this.m13 = n13;
			this.m20 = n20;
			this.m21 = n21;
			this.m22 = n22;
			this.m23 = n23;
			this.m30 = n30;
			this.m31 = n31;
			this.m32 = n32;
			this.m33 = n33;
		}
		return this;

	}

	/**
	 * Returns true if all of the data members of Matrix4f m1 are equal to the corresponding data members in this Matrix4f.
	 *
	 * @param m1 the matrix with which the comparison is made.
	 * @return true or false
	 */
	public boolean equals(Matrix4f m1) {
		try {
			return (this.m00 == m1.m00 && this.m01 == m1.m01 && this.m02 == m1.m02 &&
				this.m03 == m1.m03 && this.m10 == m1.m10 && this.m11 == m1.m11 &&
				this.m12 == m1.m12 && this.m13 == m1.m13 && this.m20 == m1.m20 &&
				this.m21 == m1.m21 && this.m22 == m1.m22 && this.m23 == m1.m23 &&
				this.m30 == m1.m30 && this.m31 == m1.m31 && this.m32 == m1.m32 &&
				this.m33 == m1.m33);
		} catch (NullPointerException e2) {
			return false;
		}

	}

	/**
	 * Returns true if the Object t1 is of type Matrix4f and all of the data members of t1 are equal to the corresponding
	 * data members in this Matrix4f.
	 *
	 * @param t1 the matrix with which the comparison is made.
	 * @return true or false
	 */
	@Override
	public boolean equals(Object t1) {
		try {
			Matrix4f m2 = (Matrix4f) t1;
			return (this.m00 == m2.m00 && this.m01 == m2.m01 && this.m02 == m2.m02 &&
				this.m03 == m2.m03 && this.m10 == m2.m10 && this.m11 == m2.m11 &&
				this.m12 == m2.m12 && this.m13 == m2.m13 && this.m20 == m2.m20 &&
				this.m21 == m2.m21 && this.m22 == m2.m22 && this.m23 == m2.m23 &&
				this.m30 == m2.m30 && this.m31 == m2.m31 && this.m32 == m2.m32 &&
				this.m33 == m2.m33);
		} catch (ClassCastException | NullPointerException e1) {
			return false;
		}
	}

	/**
	 * Returns true if the L-infinite distance between this matrix and matrix m1 is less than or equal to the epsilon
	 * parameter, otherwise returns false. The L-infinite distance is equal to MAX[i=0,1,2,3 ; j=0,1,2,3 ; abs(this.m(i,j)
	 * - m1.m(i,j)]
	 *
	 * @param m1 the matrix to be compared to this matrix
	 * @param epsilon the threshold value
	 * @return true or false
	 */
	public boolean epsilonEquals(Matrix4f m1, float epsilon) {

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
		if (Math.abs(this.m03 - m1.m03) > epsilon) {
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
		if (Math.abs(this.m13 - m1.m13) > epsilon) {
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
		if (Math.abs(this.m23 - m1.m23) > epsilon) {
			status = false;
		}

		if (Math.abs(this.m30 - m1.m30) > epsilon) {
			status = false;
		}
		if (Math.abs(this.m31 - m1.m31) > epsilon) {
			status = false;
		}
		if (Math.abs(this.m32 - m1.m32) > epsilon) {
			status = false;
		}
		if (Math.abs(this.m33 - m1.m33) > epsilon) {
			status = false;
		}

		return (status);

	}


	/**
	 * Transform the vector vec using this Matrix4f and place the result into vecOut.
	 *
	 * @param vec the single precision vector to be transformed
	 * @param vecOut the vector into which the transformed values are placed
	 * @return vecOut for chaining
	 */
	public final Tuple4f transform(Tuple4f vec, Tuple4f vecOut) {
		float x, y, z;
		x = m00 * vec.x + m01 * vec.y +
			m02 * vec.z + m03 * vec.w;
		y = m10 * vec.x + m11 * vec.y +
			m12 * vec.z + m13 * vec.w;
		z = m20 * vec.x + m21 * vec.y +
			m22 * vec.z + m23 * vec.w;
		vecOut.w = m30 * vec.x + m31 * vec.y +
			m32 * vec.z + m33 * vec.w;
		vecOut.x = x;
		vecOut.y = y;
		vecOut.z = z;
		return vecOut;
	}

	/**
	 * Transform the vector vec using this Transform and place the result back into vec.
	 *
	 * @param vec the single precision vector to be transformed
	 * @return vec for chaining
	 */
	public final Tuple4f transform(Tuple4f vec) {
		float x, y, z;

		x = m00 * vec.x + m01 * vec.y +
			m02 * vec.z + m03 * vec.w;
		y = m10 * vec.x + m11 * vec.y +
			m12 * vec.z + m13 * vec.w;
		z = m20 * vec.x + m21 * vec.y +
			m22 * vec.z + m23 * vec.w;
		vec.w = m30 * vec.x + m31 * vec.y +
			m32 * vec.z + m33 * vec.w;
		vec.x = x;
		vec.y = y;
		vec.z = z;
		return vec;
	}

	/**
	 * Transforms the point parameter with this Matrix4f and places the result into pointOut. The fourth element of the
	 * point input paramter is assumed to be one.
	 *
	 * @param point the input point to be transformed.
	 * @param pointOut the transformed point
	 * @return pointOut for chaining
	 */
	public final Point3f transform(Point3f point, Point3f pointOut) {
		float x, y;
		x = m00 * point.x + m01 * point.y + m02 * point.z + m03;
		y = m10 * point.x + m11 * point.y + m12 * point.z + m13;
		pointOut.z = m20 * point.x + m21 * point.y + m22 * point.z + m23;
		pointOut.x = x;
		pointOut.y = y;
		return pointOut;
	}

	/**
	 * Transforms the point parameter with this Matrix4f and places the result back into point. The fourth element of the
	 * point input paramter is assumed to be one.
	 *
	 * @param point the input point to be transformed.
	 * @return point for chaining
	 */
	public final Point3f transform(Point3f point) {
		float x, y;
		x = m00 * point.x + m01 * point.y + m02 * point.z + m03;
		y = m10 * point.x + m11 * point.y + m12 * point.z + m13;
		point.z = m20 * point.x + m21 * point.y + m22 * point.z + m23;
		point.x = x;
		point.y = y;
		return point;
	}

	/**
	 * Transforms the normal parameter by this Matrix4f and places the value into normalOut. The fourth element of the
	 * normal is assumed to be zero.
	 *
	 * @param normal the input normal to be transformed.
	 * @param normalOut the transformed normal
	 * @return normalOut for chaining
	 */
	public final Vector3f transform(Vector3f normal, Vector3f normalOut) {
		float x, y;
		x = m00 * normal.x + m01 * normal.y + m02 * normal.z;
		y = m10 * normal.x + m11 * normal.y + m12 * normal.z;
		normalOut.z = m20 * normal.x + m21 * normal.y + m22 * normal.z;
		normalOut.x = x;
		normalOut.y = y;
		return normalOut;
	}

	/**
	 * Transforms the normal parameter by this transform and places the value back into normal. The fourth element of the
	 * normal is assumed to be zero.
	 *
	 * @param normal the input normal to be transformed.
	 * @return normal for chaining
	 */
	public final Vector3f transform(Vector3f normal) {
		float x, y;

		x = m00 * normal.x + m01 * normal.y + m02 * normal.z;
		y = m10 * normal.x + m11 * normal.y + m12 * normal.z;
		normal.z = m20 * normal.x + m21 * normal.y + m22 * normal.z;
		normal.x = x;
		normal.y = y;
		return normal;
	}

	/**
	 * Sets the rotational component (upper 3x3) of this matrix to the matrix values in the single precision Matrix3f
	 * argument; the other elements of this matrix are unchanged; a singular value decomposition is performed on this
	 * object's upper 3x3 matrix to factor out the scale, then this object's upper 3x3 matrix components are replaced by
	 * the passed rotation components, and then the scale is reapplied to the rotational components.
	 *
	 * @param m1 single precision 3x3 matrix
	 * @return this for chaining
	 */
	public final Matrix4f setRotation(Matrix3f m1) {
		Vector3f scale = new Vector3f();
		getScale(this, scale);

		m00 = (m1.m00 * scale.x);
		m01 = (m1.m01 * scale.y);
		m02 = (m1.m02 * scale.z);

		m10 = (m1.m10 * scale.x);
		m11 = (m1.m11 * scale.y);
		m12 = (m1.m12 * scale.z);

		m20 = (m1.m20 * scale.x);
		m21 = (m1.m21 * scale.y);
		m22 = (m1.m22 * scale.z);
		return this;

	}

	/**
	 * Sets the rotational component (upper 3x3) of this matrix to the matrix equivalent values of the quaternion argument;
	 * the other elements of this matrix are unchanged; a singular value decomposition is performed on this object's upper
	 * 3x3 matrix to factor out the scale, then this object's upper 3x3 matrix components are replaced by the matrix
	 * equivalent of the quaternion, and then the scale is reapplied to the rotational components.
	 *
	 * @param q1 the quaternion that specifies the rotation
	 * @return this for chaining
	 */
	public final Matrix4f setRotation(Quat4f q1) {
		Matrix3f m1 = new Matrix3f();
		m1.set(q1);

		Vector3f scale = new Vector3f();
		getScale(this, scale);

		m00 = (m1.m00 * scale.x);
		m01 = (m1.m01 * scale.y);
		m02 = (m1.m02 * scale.z);

		m10 = (m1.m10 * scale.x);
		m11 = (m1.m11 * scale.y);
		m12 = (m1.m12 * scale.z);

		m20 = (m1.m20 * scale.x);
		m21 = (m1.m21 * scale.y);
		m22 = (m1.m22 * scale.z);
		return this;

	}

	/**
	 * Sets the rotational component (upper 3x3) of this matrix to the matrix equivalent values of the axis-angle argument;
	 * the other elements of this matrix are unchanged; a singular value decomposition is performed on this object's upper
	 * 3x3 matrix to factor out the scale, then this object's upper 3x3 matrix components are replaced by the matrix
	 * equivalent of the axis-angle, and then the scale is reapplied to the rotational components.
	 *
	 * @param a1 the axis-angle to be converted (x, y, z, angle)
	 * @return this for chaining
	 */
	public final Matrix4f setRotation(AxisAngle4f a1) {
		Matrix3f m1 = new Matrix3f();
		m1.set(a1);

		Vector3f scale = new Vector3f();
		getScale(this, scale);

		m00 = (m1.m00 * scale.x);
		m01 = (m1.m01 * scale.y);
		m02 = (m1.m02 * scale.z);

		m10 = (m1.m10 * scale.x);
		m11 = (m1.m11 * scale.y);
		m12 = (m1.m12 * scale.z);

		m20 = (m1.m20 * scale.x);
		m21 = (m1.m21 * scale.y);
		m22 = (m1.m22 * scale.z);
		return this;

	}

	/**
	 * Sets this matrix to all zeros.
	 *
	 * @return this for chaining
	 */
	public final Matrix4f setZero() {
		m00 = 0.0f;
		m01 = 0.0f;
		m02 = 0.0f;
		m03 = 0.0f;
		m10 = 0.0f;
		m11 = 0.0f;
		m12 = 0.0f;
		m13 = 0.0f;
		m20 = 0.0f;
		m21 = 0.0f;
		m22 = 0.0f;
		m23 = 0.0f;
		m30 = 0.0f;
		m31 = 0.0f;
		m32 = 0.0f;
		m33 = 0.0f;
		return this;

	}

	/**
	 * Negates the value of this matrix: this = -this.
	 *
	 * @return this for chaining
	 */
	public final Matrix4f negate() {
		m00 = -m00;
		m01 = -m01;
		m02 = -m02;
		m03 = -m03;
		m10 = -m10;
		m11 = -m11;
		m12 = -m12;
		m13 = -m13;
		m20 = -m20;
		m21 = -m21;
		m22 = -m22;
		m23 = -m23;
		m30 = -m30;
		m31 = -m31;
		m32 = -m32;
		m33 = -m33;
		return this;

	}

	/**
	 * Sets the value of this matrix equal to the negation of of the Matrix4f parameter.
	 *
	 * @param m1 the source matrix
	 * @return this for chaining
	 */
	public final Matrix4f negate(Matrix4f m1) {
		this.m00 = -m1.m00;
		this.m01 = -m1.m01;
		this.m02 = -m1.m02;
		this.m03 = -m1.m03;
		this.m10 = -m1.m10;
		this.m11 = -m1.m11;
		this.m12 = -m1.m12;
		this.m13 = -m1.m13;
		this.m20 = -m1.m20;
		this.m21 = -m1.m21;
		this.m22 = -m1.m22;
		this.m23 = -m1.m23;
		this.m30 = -m1.m30;
		this.m31 = -m1.m31;
		this.m32 = -m1.m32;
		this.m33 = -m1.m33;
		return this;

	}

	/**
	 * Decompose the 3x3 part of the matrix into scale and rotation.
	 *
	 * @param scale 3 components of scale
	 * @param rotate normalized rotation matrix.
	 */
	public final void getScaleRotate(Tuple3f scale, Matrix3f rotate) {
		getScaleRotate(this, scale, rotate);
	}

	private static void getScaleRotate(Matrix4f m1, Tuple3f scale, Matrix3f rotate) {
		new Matrix3f(m1).getScaleRotate(scale, rotate);
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
		Matrix4f m1 = null;
		try {
			m1 = (Matrix4f) super.clone();
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
	public final Matrix4f setM00(float m00) {
		this.m00 = m00;
		return this;
	}

	/**
	 * Get the second matrix element in the first row.
	 *
	 * @return Returns the m01.
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
	public final Matrix4f setM01(float m01) {
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
	public final Matrix4f setM02(float m02) {
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
	public final Matrix4f setM10(float m10) {
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
	public final Matrix4f setM11(float m11) {
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
	 *
	 * @since vecmath 1.5
	 */
	public final Matrix4f setM12(float m12) {
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
	public final Matrix4f setM20(float m20) {
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
	public final Matrix4f setM21(float m21) {
		this.m21 = m21;
		return this;
	}

	/**
	 * Get the third matrix element in the third row.
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
	public final Matrix4f setM22(float m22) {
		this.m22 = m22;
		return this;
	}

	/**
	 * Get the fourth element of the first row.
	 *
	 * @return Returns the m03.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM03() {
		return m03;
	}

	/**
	 * Set the fourth element of the first row.
	 *
	 * @param m03 The m03 to set.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public final Matrix4f setM03(float m03) {
		this.m03 = m03;
		return this;
	}

	/**
	 * Get the fourth element of the second row.
	 *
	 * @return Returns the m13.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM13() {
		return m13;
	}

	/**
	 * Set the fourth element of the second row.
	 *
	 * @param m13 The m13 to set.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public final Matrix4f setM13(float m13) {
		this.m13 = m13;
		return this;
	}

	/**
	 * Get the fourth element of the third row.
	 *
	 * @return Returns the m23.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM23() {
		return m23;
	}

	/**
	 * Set the fourth element of the third row.
	 *
	 * @param m23 The m23 to set.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public final Matrix4f setM23(float m23) {
		this.m23 = m23;
		return this;
	}

	/**
	 * Get the first element of the fourth row.
	 *
	 * @return Returns the m30.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM30() {
		return m30;
	}

	/**
	 * Set the first element of the fourth row.
	 *
	 * @param m30 The m30 to set.
	 * @return this for chaining
	 *
	 *
	 * @since vecmath 1.5
	 */
	public final Matrix4f setM30(float m30) {
		this.m30 = m30;
		return this;
	}

	/**
	 * Get the second element of the fourth row.
	 *
	 * @return Returns the m31.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM31() {
		return m31;
	}

	/**
	 * Set the second element of the fourth row.
	 *
	 * @param m31 The m31 to set.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public final Matrix4f setM31(float m31) {
		this.m31 = m31;
		return this;
	}

	/**
	 * Get the third element of the fourth row.
	 *
	 * @return Returns the m32.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM32() {
		return m32;
	}

	/**
	 * Set the third element of the fourth row.
	 *
	 * @param m32 The m32 to set.
	 * @return this for chaining
	 *
	 *
	 * @since vecmath 1.5
	 */
	public final Matrix4f setM32(float m32) {
		this.m32 = m32;
		return this;
	}

	/**
	 * Get the fourth element of the fourth row.
	 *
	 * @return Returns the m33.
	 *
	 * @since vecmath 1.5
	 */
	public final float getM33() {
		return m33;
	}

	/**
	 * Set the fourth element of the fourth row.
	 *
	 * @param m33 The m33 to set.
	 * @return this for chaining
	 *
	 * @since vecmath 1.5
	 */
	public final Matrix4f setM33(float m33) {
		this.m33 = m33;
		return this;
	}

	/**
	 * Calculate a lookat matrix. This is the same as gluLookat()
	 *
	 * @param eye an array of 3 components for the eye position.
	 * @param center an array of 3 components for the center position.
	 * @param up an array of 3 components for the up direction.
	 * @return this for chaining
	 */
	public Matrix4f setLookAt(Vector3f eye, Vector3f center, Vector3f up) {

		Vector3f f = new Vector3f();
		f.sub(center, eye);
		f.normalize();

		Vector3f up_n = new Vector3f();
		up_n.normalize(up);

		Vector3f s = new Vector3f();
		s.cross(f, up_n);

		Vector3f s_n = new Vector3f();
		s_n.normalize(s);

		Vector3f u = new Vector3f();
		u.cross(s_n, f);

		m00 = s.x;
		m01 = s.y;
		m02 = s.z;
		m03 = 0;
		m10 = u.x;
		m11 = u.y;
		m12 = u.z;
		m13 = 0;
		m20 = -f.x;
		m21 = -f.y;
		m22 = -f.z;
		m23 = 0;
		m30 = 0;
		m31 = 0;
		m32 = 0;
		m33 = 1;

		Vector3f e = new Vector3f(eye);
		e.scale(-1);
		Matrix4f t = new Matrix4f();
		t.setIdentity();
		t.setTranslation(e);
		mul(t);
		return this;

	}

	
	/**
	 * Returns a hash code value based on the data values in this object. Two different Matrix4f objects with identical
	 * data values (i.e., Matrix4f.equals returns true) will return the same hash code value. Two objects with different
	 * data members may return the same hash value, although this is not likely.
	 *
	 * @return the integer hash code value
	 */
@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Float.floatToIntBits(this.m00);
		hash = 67 * hash + Float.floatToIntBits(this.m01);
		hash = 67 * hash + Float.floatToIntBits(this.m02);
		hash = 67 * hash + Float.floatToIntBits(this.m03);
		hash = 67 * hash + Float.floatToIntBits(this.m10);
		hash = 67 * hash + Float.floatToIntBits(this.m11);
		hash = 67 * hash + Float.floatToIntBits(this.m12);
		hash = 67 * hash + Float.floatToIntBits(this.m13);
		hash = 67 * hash + Float.floatToIntBits(this.m20);
		hash = 67 * hash + Float.floatToIntBits(this.m21);
		hash = 67 * hash + Float.floatToIntBits(this.m22);
		hash = 67 * hash + Float.floatToIntBits(this.m23);
		hash = 67 * hash + Float.floatToIntBits(this.m30);
		hash = 67 * hash + Float.floatToIntBits(this.m31);
		hash = 67 * hash + Float.floatToIntBits(this.m32);
		hash = 67 * hash + Float.floatToIntBits(this.m33);
		return hash;
	}

}
