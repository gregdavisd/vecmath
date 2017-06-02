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

import static javax.vecmath.VecMath.different_epsilon;
import static javax.vecmath.VecMath.cos;
import static javax.vecmath.VecMath.sin;

/**
 * A single precision floating point 4 by 4 matrix. Primarily to support 3D rotations.
 *
 * @param <T>
 */
public class Matrix4f<T extends Matrix4f> implements java.io.Serializable  {

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
  * Constructs and initializes a Matrix4f from the specified 16 element array. this.m00 =v[0],
  * this.m01=v[1], etc.
  *
  * @param v the array of length 16 containing in order
  */
 public Matrix4f(float[] v) {
  m00 = v[0];
  m01 = v[1];
  m02 = v[2];
  m03 = v[3];
  m10 = v[4];
  m11 = v[5];
  m12 = v[6];
  m13 = v[7];
  m20 = v[8];
  m21 = v[9];
  m22 = v[10];
  m23 = v[11];
  m30 = v[12];
  m31 = v[13];
  m32 = v[14];
  m33 = v[15];
 }

 /**
  * Constructs and initializes a Matrix4f from the specified 4x4 two dimensional array.
  *
  * @param v the array of size [4][4] containing in column order
  */
 public Matrix4f(float[][] v) {
  m00 = v[0][0];
  m01 = v[0][1];
  m02 = v[0][2];
  m03 = v[0][3];
  m10 = v[1][0];
  m11 = v[1][1];
  m12 = v[1][2];
  m13 = v[1][3];
  m20 = v[2][0];
  m21 = v[2][1];
  m22 = v[2][2];
  m23 = v[2][3];
  m30 = v[3][0];
  m31 = v[3][1];
  m32 = v[3][2];
  m33 = v[3][3];
 }

 /**
  * Constructs a new matrix with the same values as the Matrix4f parameter.
  *
  * @param m1 the source matrix
  */
 public Matrix4f(Matrix4f m1) {
  m00 = m1.m00;
  m01 = m1.m01;
  m02 = m1.m02;
  m03 = m1.m03;
  m10 = m1.m10;
  m11 = m1.m11;
  m12 = m1.m12;
  m13 = m1.m13;
  m20 = m1.m20;
  m21 = m1.m21;
  m22 = m1.m22;
  m23 = m1.m23;
  m30 = m1.m30;
  m31 = m1.m31;
  m32 = m1.m32;
  m33 = m1.m33;
 }

 /**
  * Constructs and initializes a Matrix4f from the rotation matrix, translation, and scale values;
  * the scale is applied only to the rotational components of the matrix (upper 3x3) and not to the
  * translational components of the matrix.
  *
  * @param m1 the rotation matrix representing the rotational components
  * @param t1 the translational components of the matrix
  * @param s the scale value applied to the rotational components
  */
 public Matrix4f(Matrix3f m1, Tuple3f t1, float s) {
  m00 = m1.m00 * s;
  m01 = m1.m01 * s;
  m02 = m1.m02 * s;
  m03 = t1.x;
  m10 = m1.m10 * s;
  m11 = m1.m11 * s;
  m12 = m1.m12 * s;
  m13 = t1.y;
  m20 = m1.m20 * s;
  m21 = m1.m21 * s;
  m22 = m1.m22 * s;
  m23 = t1.z;
  m30 = 0.0f;
  m31 = 0.0f;
  m32 = 0.0f;
  m33 = 1.0f;
 }

 /**
  * Constructs and initializes a Matrix4f from the rotation matrix, translation values;
  *
  * @param m1 the rotation matrix representing the rotational components
  * @param t1 the translational components of the matrix
  */
 public Matrix4f(Matrix3f m1, Tuple3f t1) {
  m00 = m1.m00;
  m01 = m1.m01;
  m02 = m1.m02;
  m03 = t1.x;
  m10 = m1.m10;
  m11 = m1.m11;
  m12 = m1.m12;
  m13 = t1.y;
  m20 = m1.m20;
  m21 = m1.m21;
  m22 = m1.m22;
  m23 = t1.z;
  m30 = 0.0f;
  m31 = 0.0f;
  m32 = 0.0f;
  m33 = 1.0f;
 }

 /**
  * Constructs and initializes a Matrix4f from the rotation matrix.
  *
  * @param m1 the rotation matrix representing the rotational components
  */
 public Matrix4f(Matrix3f m1) {
  m00 = m1.m00;
  m01 = m1.m01;
  m02 = m1.m02;
  m03 = 0;
  m10 = m1.m10;
  m11 = m1.m11;
  m12 = m1.m12;
  m13 = 0;
  m20 = m1.m20;
  m21 = m1.m21;
  m22 = m1.m22;
  m23 = 0;
  m30 = 0.0f;
  m31 = 0.0f;
  m32 = 0.0f;
  m33 = 1.0f;
 }

 /**
  * Constructs and initializes a Matrix4f to all zeros.
  */
 public Matrix4f() {
 }

 /**
  * Returns a string that contains the values of this Matrix4f.
  *
  * @return the String representation
  */
 @Override
 public String toString() {
  return m00 + ", " + m01 + ", " + m02 + ", " + m03 + "\n" +
   m10 + ", " + m11 + ", " + m12 + ", " + m13 + "\n" +
   m20 + ", " + m21 + ", " + m22 + ", " + m23 + "\n" +
   m30 + ", " + m31 + ", " + m32 + ", " + m33;
 }

 /**
  * Sets this Matrix4f to identity.
  *
  * @return this for chaining
  */
 public T setIdentity() {
  m00 = 1.0f;
  m01 = 0.0f;
  m02 = 0.0f;
  m03 = 0.0f;
  m10 = 0.0f;
  m11 = 1.0f;
  m12 = 0.0f;
  m13 = 0.0f;
  m20 = 0.0f;
  m21 = 0.0f;
  m22 = 1.0f;
  m23 = 0.0f;
  m30 = 0.0f;
  m31 = 0.0f;
  m32 = 0.0f;
  m33 = 1.0f;
  return (T) this;
 }

 /**
  * Sets the specified element of this matrix4f to the value provided.
  *
  * @param row the row number to be modified (zero indexed)
  * @param column the column number to be modified (zero indexed)
  * @param value the new value
  * @return this for chaining
  */
 public T setElement(int row, int column, float value) {
  final int i = (row * 4) + column;
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
    m03 = value;
    break;
   case 4:
    m10 = value;
    break;
   case 5:
    m11 = value;
    break;
   case 6:
    m12 = value;
    break;
   case 7:
    m13 = value;
    break;
   case 8:
    m20 = value;
    break;
   case 9:
    m21 = value;
    break;
   case 10:
    m22 = value;
    break;
   case 11:
    m23 = value;
    break;
   case 12:
    m30 = value;
    break;
   case 13:
    m31 = value;
    break;
   case 14:
    m32 = value;
    break;
   case 15:
    m33 = value;
    break;
   default:
    throw new ArrayIndexOutOfBoundsException();
  }
  return (T) this;
 }

 /**
  * Retrieves the value at the specified row and column of this matrix.
  *
  * @param row the row number to be retrieved (zero indexed)
  * @param column the column number to be retrieved (zero indexed)
  * @return the value at the indexed element
  */
 public float getElement(int row, int column) {
  final int i = (row * 4) + column;
  switch (i) {
   case 0:
    return (m00);
   case 1:
    return (m01);
   case 2:
    return (m02);
   case 3:
    return (m03);
   case 4:
    return (m10);
   case 5:
    return (m11);
   case 6:
    return (m12);
   case 7:
    return (m13);
   case 8:
    return (m20);
   case 9:
    return (m21);
   case 10:
    return (m22);
   case 11:
    return (m23);
   case 12:
    return (m30);
   case 13:
    return (m31);
   case 14:
    return (m32);
   case 15:
    return (m33);
   default:
    throw new ArrayIndexOutOfBoundsException();
  }
 }

 /**
  * Copies the matrix values in the specified row into the vector parameter.
  *
  * @param <S>
  * @param row the matrix row
  * @param v the vector into which the matrix row values will be copied
  * @return
  */
 public <S extends Tuple4f> S getRow(int row, S v) {
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
  return v;
 }

 /**
  * Copies the matrix values in the specified row into the array parameter.
  *
  * @param row the matrix row
  * @param v the array into which the matrix row values will be copied
  * @return
  */
 public float[] getRow(int row, float v[]) {
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
  return v;
 }

 /**
  * Copies the matrix values in the specified column into the vector parameter.
  *
  * @param <S>
  * @param column the matrix column
  * @param v the vector into which the matrix row values will be copied
  * @return
  */
 public <S extends Tuple4f> S getColumn(int column, S v) {
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
  return v;
 }

 /**
  * Copies the matrix values in the specified column into the array parameter.
  *
  * @param column the matrix column
  * @param v the array into which the matrix row values will be copied
  * @return
  */
 public float[] getColumn(int column, float v[]) {
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
  return v;
 }

 /**
  * Sets the scale component of the current matrix by factoring out the current scale (by doing an
  * SVD) from the rotational component and multiplying by the new scale.
  *
  * @param scale the new scale amount
  * @return this for chaining
  */
 public T setScale(float scale) {
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
  * Copy the 3x3 components
  *
  * @param <T>
  * @param m1 matrix into which the rotational component is placed
  * @return
  */
 public <T extends Matrix3f> T get(Matrix3f m1) {
  getScaleRotate(this, new Vector3f(), m1);
  return (T) m1;
 }

 /**
  * Copy this matrix into an array with row major element ordering.
  *
  * @param m1 The array to store the matrix elements
  * @return m1
  */
 public float[] getRowMajor(float[] m1) {
  m1[0] = m00;
  m1[1] = m01;
  m1[2] = m02;
  m1[3] = m03;
  m1[4] = m10;
  m1[5] = m11;
  m1[6] = m12;
  m1[7] = m13;
  m1[8] = m20;
  m1[9] = m21;
  m1[10] = m22;
  m1[11] = m23;
  m1[12] = m30;
  m1[13] = m31;
  m1[14] = m32;
  m1[15] = m33;
  return m1;
 }

 /**
  * Copy this matrix into an array with column major element ordering.
  *
  * @param m1 The array to store the matrix elements
  * @return m1
  */
 public float[] getColumnMajor(float[] m1) {
  m1[0] = m00;
  m1[1] = m10;
  m1[2] = m20;
  m1[3] = m30;
  m1[4] = m01;
  m1[5] = m11;
  m1[6] = m21;
  m1[7] = m31;
  m1[8] = m02;
  m1[9] = m12;
  m1[10] = m22;
  m1[11] = m32;
  m1[12] = m03;
  m1[13] = m13;
  m1[14] = m23;
  m1[15] = m33;
  return m1;
 }

 /**
  * Performs an SVD normalization of this matrix to calculate the rotation as a 3x3 matrix, the
  * translation, and the scale. None of the matrix values are modified.
  *
  * @param m1 the normalized matrix representing the rotation
  * @param t1 the translation component
  * @return the scale component of this transform
  */
 public float get(Matrix3f m1, Tuple3f t1) {
  Vector3f scale = new Vector3f();
  getScaleRotate(scale, m1);
  t1.x = m03;
  t1.y = m13;
  t1.z = m23;
  return scale.max();
 }

 /**
  * Performs an SVD normalization of this matrix in order to acquire the normalized rotational
  * component; the values are placed into the Quat4f parameter.
  *
  * @param <T>
  * @param q1 quaternion into which the rotation component is placed
  * @return
  */
 public <T extends Quat4f> T get(Quat4f q1) {
  q1.set(new Matrix3f(this).normalize());
  return (T) q1;
 }

 /**
  * Retrieves the translational components of this matrix.
  *
  * @param <S>
  * @param trans the vector that will receive the translational component
  * @return trans for chaining
  */
 public <S extends Tuple3f> S get(S trans) {
  trans.x = m03;
  trans.y = m13;
  trans.z = m23;
  return trans;
 }

 /**
  * Gets the upper 3x3 values of this matrix and places them into the matrix m1.
  *
  * @param <T>
  * @param m1 the matrix that will hold the values
  * @return m1 for chaining
  */
 public <T extends Matrix3f> T getRotationScale(Matrix3f m1) {
  m1.m00 = m00;
  m1.m01 = m01;
  m1.m02 = m02;
  m1.m10 = m10;
  m1.m11 = m11;
  m1.m12 = m12;
  m1.m20 = m20;
  m1.m21 = m21;
  m1.m22 = m22;
  return (T) m1;
 }

 /**
  * Performs an SVD normalization of this matrix to calculate and return the uniform scale factor.
  * If the matrix has non-uniform scale factors, the largest of the x, y, and z scale factors will
  * be returned. This matrix is not modified.
  *
  * @return the scale factor of this matrix
  */
 public float getScale() {
  return new Matrix3f(this).getScale();
 }

 /**
  * Decompose the 3x3 portion of this matrix and return the scale components
  *
  * @param <S>
  * @param scale x,y,z scale components
  * @return scale for chaining.
  */
 public <S extends Tuple3f> S getScale(S scale) {
  new Matrix3f(this).getScale(scale);
  return scale;
 }

 private static void getScale(Matrix4f m1, Tuple3f scale) {
  new Matrix3f(m1).getScale(scale);
 }

 /**
  * Replaces the upper 3x3 matrix values of this matrix with the values in the matrix m1.
  *
  * @param m1 the matrix that will be the new upper 3x3
  * @return this for chaining
  */
 public T setRotationScale(Matrix3f m1) {
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
  * Sets the specified row of this matrix4f to the four values provided.
  *
  * @param row the row number to be modified (zero indexed)
  * @param x the first column element
  * @param y the second column element
  * @param z the third column element
  * @param w the fourth column element
  * @return this for chaining
  */
 public T setRow(int row, float x, float y, float z, float w) {
  switch (row) {
   case 0:
    m00 = x;
    m01 = y;
    m02 = z;
    m03 = w;
    break;
   case 1:
    m10 = x;
    m11 = y;
    m12 = z;
    m13 = w;
    break;
   case 2:
    m20 = x;
    m21 = y;
    m22 = z;
    m23 = w;
    break;
   case 3:
    m30 = x;
    m31 = y;
    m32 = z;
    m33 = w;
    break;
   default:
    throw new ArrayIndexOutOfBoundsException();
  }
  return (T) this;
 }

 /**
  * Sets the specified row of this matrix4f to the Vector provided.
  *
  * @param row the row number to be modified (zero indexed)
  * @param v the replacement row
  * @return this for chaining
  */
 public T setRow(int row, Tuple4f v) {
  switch (row) {
   case 0:
    m00 = v.x;
    m01 = v.y;
    m02 = v.z;
    m03 = v.w;
    break;
   case 1:
    m10 = v.x;
    m11 = v.y;
    m12 = v.z;
    m13 = v.w;
    break;
   case 2:
    m20 = v.x;
    m21 = v.y;
    m22 = v.z;
    m23 = v.w;
    break;
   case 3:
    m30 = v.x;
    m31 = v.y;
    m32 = v.z;
    m33 = v.w;
    break;
   default:
    throw new ArrayIndexOutOfBoundsException();
  }
  return (T) this;
 }

 /**
  * Sets the specified row of this matrix4f to the four values provided in the passed array.
  *
  * @param row the row number to be modified (zero indexed)
  * @param v the replacement row
  * @return this for chaining
  */
 public T setRow(int row, float v[]) {
  switch (row) {
   case 0:
    m00 = v[0];
    m01 = v[1];
    m02 = v[2];
    m03 = v[3];
    break;
   case 1:
    m10 = v[0];
    m11 = v[1];
    m12 = v[2];
    m13 = v[3];
    break;
   case 2:
    m20 = v[0];
    m21 = v[1];
    m22 = v[2];
    m23 = v[3];
    break;
   case 3:
    m30 = v[0];
    m31 = v[1];
    m32 = v[2];
    m33 = v[3];
    break;
   default:
    throw new ArrayIndexOutOfBoundsException();
  }
  return (T) this;
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
 public T setColumn(int column, float x, float y, float z, float w) {
  switch (column) {
   case 0:
    m00 = x;
    m10 = y;
    m20 = z;
    m30 = w;
    break;
   case 1:
    m01 = x;
    m11 = y;
    m21 = z;
    m31 = w;
    break;
   case 2:
    m02 = x;
    m12 = y;
    m22 = z;
    m32 = w;
    break;
   case 3:
    m03 = x;
    m13 = y;
    m23 = z;
    m33 = w;
    break;
   default:
    throw new ArrayIndexOutOfBoundsException();
  }
  return (T) this;
 }

 /**
  * Sets the specified column of this matrix4f to the vector provided.
  *
  * @param column the column number to be modified (zero indexed)
  * @param v the replacement column
  * @return this for chaining
  */
 public T setColumn(int column, Tuple4f v) {
  switch (column) {
   case 0:
    m00 = v.x;
    m10 = v.y;
    m20 = v.z;
    m30 = v.w;
    break;
   case 1:
    m01 = v.x;
    m11 = v.y;
    m21 = v.z;
    m31 = v.w;
    break;
   case 2:
    m02 = v.x;
    m12 = v.y;
    m22 = v.z;
    m32 = v.w;
    break;
   case 3:
    m03 = v.x;
    m13 = v.y;
    m23 = v.z;
    m33 = v.w;
    break;
   default:
    throw new ArrayIndexOutOfBoundsException();
  }
  return (T) this;
 }

 /**
  * Sets the specified column of this matrix4f to the four values provided.
  *
  * @param column the column number to be modified (zero indexed)
  * @param v the replacement column
  * @return this for chaining
  */
 public T setColumn(int column, float v[]) {
  switch (column) {
   case 0:
    m00 = v[0];
    m10 = v[1];
    m20 = v[2];
    m30 = v[3];
    break;
   case 1:
    m01 = v[0];
    m11 = v[1];
    m21 = v[2];
    m31 = v[3];
    break;
   case 2:
    m02 = v[0];
    m12 = v[1];
    m22 = v[2];
    m32 = v[3];
    break;
   case 3:
    m03 = v[0];
    m13 = v[1];
    m23 = v[2];
    m33 = v[3];
    break;
   default:
    throw new ArrayIndexOutOfBoundsException();
  }
  return (T) this;
 }

 /**
  * Adds a scalar to each component of this matrix.
  *
  * @param scalar the scalar adder
  * @return this for chaining
  */
 public T add(float scalar) {
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
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the matrix sum of matrices m1 and m2.
  *
  * @param m1 the first matrix
  * @param m2 the second matrix
  * @return this for chaining
  */
 public T add(Matrix4f m1, Matrix4f m2) {
  m00 = m1.m00 + m2.m00;
  m01 = m1.m01 + m2.m01;
  m02 = m1.m02 + m2.m02;
  m03 = m1.m03 + m2.m03;
  m10 = m1.m10 + m2.m10;
  m11 = m1.m11 + m2.m11;
  m12 = m1.m12 + m2.m12;
  m13 = m1.m13 + m2.m13;
  m20 = m1.m20 + m2.m20;
  m21 = m1.m21 + m2.m21;
  m22 = m1.m22 + m2.m22;
  m23 = m1.m23 + m2.m23;
  m30 = m1.m30 + m2.m30;
  m31 = m1.m31 + m2.m31;
  m32 = m1.m32 + m2.m32;
  m33 = m1.m33 + m2.m33;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the sum of itself and matrix m1.
  *
  * @param m1 the other matrix
  * @return this for chaining
  */
 public T add(Matrix4f m1) {
  m00 += m1.m00;
  m01 += m1.m01;
  m02 += m1.m02;
  m03 += m1.m03;
  m10 += m1.m10;
  m11 += m1.m11;
  m12 += m1.m12;
  m13 += m1.m13;
  m20 += m1.m20;
  m21 += m1.m21;
  m22 += m1.m22;
  m23 += m1.m23;
  m30 += m1.m30;
  m31 += m1.m31;
  m32 += m1.m32;
  m33 += m1.m33;
  return (T) this;
 }

 /**
  * Performs an element-by-element subtraction of matrix m2 from matrix m1 and places the result
  * into matrix this (this = m2 - m1).
  *
  * @param m1 the first matrix
  * @param m2 the second matrix
  * @return this for chaining
  */
 public T sub(Matrix4f m1, Matrix4f m2) {
  m00 = m1.m00 - m2.m00;
  m01 = m1.m01 - m2.m01;
  m02 = m1.m02 - m2.m02;
  m03 = m1.m03 - m2.m03;
  m10 = m1.m10 - m2.m10;
  m11 = m1.m11 - m2.m11;
  m12 = m1.m12 - m2.m12;
  m13 = m1.m13 - m2.m13;
  m20 = m1.m20 - m2.m20;
  m21 = m1.m21 - m2.m21;
  m22 = m1.m22 - m2.m22;
  m23 = m1.m23 - m2.m23;
  m30 = m1.m30 - m2.m30;
  m31 = m1.m31 - m2.m31;
  m32 = m1.m32 - m2.m32;
  m33 = m1.m33 - m2.m33;
  return (T) this;
 }

 /**
  * Sets this matrix to the matrix difference of itself and matrix m1 (this = this - m1).
  *
  * @param m1 the other matrix
  * @return this for chaining
  */
 public T sub(Matrix4f m1) {
  m00 -= m1.m00;
  m01 -= m1.m01;
  m02 -= m1.m02;
  m03 -= m1.m03;
  m10 -= m1.m10;
  m11 -= m1.m11;
  m12 -= m1.m12;
  m13 -= m1.m13;
  m20 -= m1.m20;
  m21 -= m1.m21;
  m22 -= m1.m22;
  m23 -= m1.m23;
  m30 -= m1.m30;
  m31 -= m1.m31;
  m32 -= m1.m32;
  m33 -= m1.m33;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to its transpose in place.
  *
  * @return this for chaining
  */
 public T transpose() {
  float temp;
  temp = m10;
  m10 = m01;
  m01 = temp;
  temp = m20;
  m20 = m02;
  m02 = temp;
  temp = m30;
  m30 = m03;
  m03 = temp;
  temp = m21;
  m21 = m12;
  m12 = temp;
  temp = m31;
  m31 = m13;
  m13 = temp;
  temp = m32;
  m32 = m23;
  m23 = temp;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the transpose of the argument matrix.
  *
  * @param m1 the matrix to be transposed
  * @return this for chaining
  */
 public T transpose(Matrix4f m1) {
  set(m1);
  transpose();
  return (T) this;
 }

 /**
  * Sets the upper 3x3 values of this matrix to the matrix conversion of the single precision
  * quaternion argument and the translational components to the value of the tuple t1
  *
  * @param q1 the quaternion to be converted
  * @param t1 the translation values for the result
  * @return this for chaining
  */
 public T set(Quat4f q1, Tuple3f t1) {
  set3x3(new Matrix3f().set(q1)).setTranslation(t1).setM33(1.0f);
  return (T) this;
 }

 /**
  * Sets the upper 3x3 values of this matrix to the matrix conversion of the single precision
  * quaternion argument, the other values (4th column and row) are set to their identity values.
  *
  * @param q1 the quaternion to be converted
  * @return this for chaining
  */
 public T set(Quat4f q1) {
  set(new Matrix3f().set(q1));
  return (T) this;
 }

 /**
  * Sets the upper 3x3 values of this matrix to the matrix conversion of the single precision
  * quaternion argument, the other values (4th column and row) are not changed
  *
  * @param q1 the quaternion to be converted
  * @return this for chaining
  */
 public T set3x3(Quat4f q1) {
  set3x3(new Matrix3f().set(q1));
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the matrix conversion of the (single precision) axis and angle
  * argument.
  *
  * @param a1 the axis and angle to be converted
  * @return this for chaining
  */
 public T set(AxisAngle4f a1) {
  set(new Matrix3f().set(a1));
  return (T) this;
 }

 /**
  * Sets the value of this matrix from the rotation expressed by the quaternion q1, the translation
  * t1, and the scale s.
  *
  * @param q1 the rotation expressed as a quaternion
  * @param t1 the translation
  * @param s the scale value
  * @return this for chaining
  */
 public T set(Quat4f q1, Tuple3f t1, float s) {
  Matrix3f rotate = new Matrix3f();
  rotate.set(q1);
  m00 = rotate.m00 * s;
  m01 = rotate.m01 * s;
  m02 = rotate.m02 * s;
  m10 = rotate.m10 * s;
  m11 = rotate.m11 * s;
  m12 = rotate.m12 * s;
  m20 = rotate.m20 * s;
  m21 = rotate.m21 * s;
  m22 = rotate.m22 * s;
  m03 = t1.x;
  m13 = t1.y;
  m23 = t1.z;
  m30 = 0.0f;
  m31 = 0.0f;
  m32 = 0.0f;
  m33 = 1.0f;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to a copy of the passed matrix m1.
  *
  * @param m1 the matrix to be copied
  * @return this for chaining
  */
 public T set(Matrix4f m1) {
  m00 = m1.m00;
  m01 = m1.m01;
  m02 = m1.m02;
  m03 = m1.m03;
  m10 = m1.m10;
  m11 = m1.m11;
  m12 = m1.m12;
  m13 = m1.m13;
  m20 = m1.m20;
  m21 = m1.m21;
  m22 = m1.m22;
  m23 = m1.m23;
  m30 = m1.m30;
  m31 = m1.m31;
  m32 = m1.m32;
  m33 = m1.m33;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the matrix inverse of the passed (user declared) matrix m1.
  *
  * @param m1 the matrix to be inverted
  * @return this for chaining
  */
 public T invert(Matrix4f m1) {
  invertGeneral(new Matrix4f(m1).invert());
  return (T) this;
 }

 /**
  * Inverts this matrix in place.
  *
  * @return this for chaining
  */
 public T invert() {
  invertGeneral(this);
  return (T) this;
 }

 /**
  * General invert routine. Inverts m1 and places the result in "this". Note that this routine
  * handles both the "this" version and the non-"this" version.
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
  m1.set(inverse);
 }

 /**
  * Computes the determinate of this matrix.
  *
  * @return the determinate of the matrix
  */
 public float determinant() {
  float det;
  // cofactor exapansion along first row 
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
  * Sets the rotational component (upper 3x3) of this matrix to the matrix values in the single
  * precision Matrix3f argument; the other elements of this matrix are initialized as if this were
  * an identity matrix (i.e., affine matrix with no translational component).
  *
  * @param m1 the single-precision 3x3 matrix
  * @return this for chaining
  */
 public T set(Matrix3f m1) {
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
  return (T) this;
 }

 /**
  * Sets the rotational component (upper 3x3) of this matrix to the matrix values in the single
  * precision Matrix3f argument; the other elements are not changed.
  *
  *
  * @param m1 the single-precision 3x3 matrix
  * @return this for chaining
  */
 public T set3x3(Matrix3f m1) {
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
  * Sets the value of this matrix to a scale matrix with the the passed scale amount.
  *
  * @param scale the scale factor for the matrix
  * @return this for chaining
  */
 public T set(float scale) {
  m00 = scale;
  m01 = 0.0f;
  m02 = 0.0f;
  m03 = 0.0f;
  m10 = 0.0f;
  m11 = scale;
  m12 = 0.0f;
  m13 = 0.0f;
  m20 = 0.0f;
  m21 = 0.0f;
  m22 = scale;
  m23 = 0.0f;
  m30 = 0.0f;
  m31 = 0.0f;
  m32 = 0.0f;
  m33 = 1.0f;
  return (T) this;
 }

 /**
  * Sets the values in this Matrix4f equal to the row-major array parameter (ie, the first four
  * elements of the array will be copied into the first row of this matrix, etc.).
  *
  * @param m the single precision array of length 16
  * @return this for chaining
  */
 public T set(float[] m) {
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
  return (T) this;
 }

 /**
  * Sets the value of this matrix to a translate matrix with the passed translation value.
  *
  * @param v1 the translation amount
  * @return this for chaining
  */
 public T set(Tuple3f v1) {
  m00 = 1.0f;
  m01 = 0.0f;
  m02 = 0.0f;
  m03 = v1.x;
  m10 = 0.0f;
  m11 = 1.0f;
  m12 = 0.0f;
  m13 = v1.y;
  m20 = 0.0f;
  m21 = 0.0f;
  m22 = 1.0f;
  m23 = v1.z;
  m30 = 0.0f;
  m31 = 0.0f;
  m32 = 0.0f;
  m33 = 1.0f;
  return (T) this;
 }

 /**
  * Sets the value of this transform to a scale and translation matrix; the scale is not applied to
  * the translation and all of the matrix values are modified.
  *
  * @param scale the scale factor for the matrix
  * @param t1 the translation amount
  * @return this for chaining
  */
 public T set(float scale, Tuple3f t1) {
  m00 = scale;
  m01 = 0.0f;
  m02 = 0.0f;
  m03 = t1.x;
  m10 = 0.0f;
  m11 = scale;
  m12 = 0.0f;
  m13 = t1.y;
  m20 = 0.0f;
  m21 = 0.0f;
  m22 = scale;
  m23 = t1.z;
  m30 = 0.0f;
  m31 = 0.0f;
  m32 = 0.0f;
  m33 = 1.0f;
  return (T) this;
 }

 /**
  * Sets the value of this transform to a scale and translation matrix; the translation is scaled by
  * the scale factor and all of the matrix values are modified.
  *
  * @param t1 the translation amount
  * @param scale the scale factor for the matrix
  * @return this for chaining
  */
 public T set(Tuple3f t1, float scale) {
  m00 = scale;
  m01 = 0.0f;
  m02 = 0.0f;
  m03 = scale * t1.x;
  m10 = 0.0f;
  m11 = scale;
  m12 = 0.0f;
  m13 = scale * t1.y;
  m20 = 0.0f;
  m21 = 0.0f;
  m22 = scale;
  m23 = scale * t1.z;
  m30 = 0.0f;
  m31 = 0.0f;
  m32 = 0.0f;
  m33 = 1.0f;
  return (T) this;
 }

 /**
  * Sets the value of this matrix from the rotation expressed by the rotation matrix m1, the
  * translation t1, and the scale factor. The translation is not modified by the scale.
  *
  * @param m1 the rotation component
  * @param t1 the translation component
  * @param scale the scale component
  * @return this for chaining
  */
 public T set(Matrix3f m1, Tuple3f t1, float scale) {
  m00 = m1.m00 * scale;
  m01 = m1.m01 * scale;
  m02 = m1.m02 * scale;
  m03 = t1.x;
  m10 = m1.m10 * scale;
  m11 = m1.m11 * scale;
  m12 = m1.m12 * scale;
  m13 = t1.y;
  m20 = m1.m20 * scale;
  m21 = m1.m21 * scale;
  m22 = m1.m22 * scale;
  m23 = t1.z;
  m30 = 0.0f;
  m31 = 0.0f;
  m32 = 0.0f;
  m33 = 1.0f;
  return (T) this;
 }

 /**
  * Modifies the translational components of this matrix to the values of the Tuple3f argument; the
  * other values of this matrix are not modified.
  *
  * @param trans the translational component
  * @return this for chaining
  */
 public T setTranslation(Tuple3f trans) {
  m03 = trans.x;
  m13 = trans.y;
  m23 = trans.z;
  return (T) this;
 }

 /**
  * Modifies the translational components of this matrix to the values of the x,y,z arguments; the
  * other values of this matrix are not modified.
  *
  * @param x
  * @param y
  * @param z
  * @return this for chaining
  */
 public T setTranslation(float x, float y, float z) {
  m03 = x;
  m13 = y;
  m23 = z;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to a counter clockwise rotation about the x axis.
  *
  * @param angle the angle to rotate about the X axis in radians
  * @return this for chaining
  */
 public T rotX(float angle) {
  float sinAngle, cosAngle;
  sinAngle = sin(angle);
  cosAngle = cos(angle);
  m00 = 1.0f;
  m01 = 0.0f;
  m02 = 0.0f;
  m03 = 0.0f;
  m10 = 0.0f;
  m11 = cosAngle;
  m12 = -sinAngle;
  m13 = 0.0f;
  m20 = 0.0f;
  m21 = sinAngle;
  m22 = cosAngle;
  m23 = 0.0f;
  m30 = 0.0f;
  m31 = 0.0f;
  m32 = 0.0f;
  m33 = 1.0f;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to a counter clockwise rotation about the y axis.
  *
  * @param angle the angle to rotate about the Y axis in radians
  * @return this for chaining
  */
 public T rotY(float angle) {
  float sinAngle, cosAngle;
  sinAngle = sin(angle);
  cosAngle = cos(angle);
  m00 = cosAngle;
  m01 = 0.0f;
  m02 = sinAngle;
  m03 = 0.0f;
  m10 = 0.0f;
  m11 = 1.0f;
  m12 = 0.0f;
  m13 = 0.0f;
  m20 = -sinAngle;
  m21 = 0.0f;
  m22 = cosAngle;
  m23 = 0.0f;
  m30 = 0.0f;
  m31 = 0.0f;
  m32 = 0.0f;
  m33 = 1.0f;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to a counter clockwise rotation about the z axis.
  *
  * @param angle the angle to rotate about the Z axis in radians
  * @return this for chaining
  */
 public T rotZ(float angle) {
  float sinAngle, cosAngle;
  sinAngle = sin(angle);
  cosAngle = cos(angle);
  m00 = cosAngle;
  m01 = -sinAngle;
  m02 = 0.0f;
  m03 = 0.0f;
  m10 = sinAngle;
  m11 = cosAngle;
  m12 = 0.0f;
  m13 = 0.0f;
  m20 = 0.0f;
  m21 = 0.0f;
  m22 = 1.0f;
  m23 = 0.0f;
  m30 = 0.0f;
  m31 = 0.0f;
  m32 = 0.0f;
  m33 = 1.0f;
  return (T) this;
 }

 /**
  * Multiplies each element of this matrix by a scalar.
  *
  * @param scalar the scalar multiplier.
  * @return this for chaining
  */
 public T mul(float scalar) {
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
  return (T) this;
 }

 /**
  * Multiplies each element of matrix m1 by a scalar and places the result into this. Matrix m1 is
  * not modified.
  *
  * @param scalar the scalar multiplier.
  * @param m1 the original matrix.
  * @return this for chaining
  */
 public T mul(float scalar, Matrix4f m1) {
  m00 = m1.m00 * scalar;
  m01 = m1.m01 * scalar;
  m02 = m1.m02 * scalar;
  m03 = m1.m03 * scalar;
  m10 = m1.m10 * scalar;
  m11 = m1.m11 * scalar;
  m12 = m1.m12 * scalar;
  m13 = m1.m13 * scalar;
  m20 = m1.m20 * scalar;
  m21 = m1.m21 * scalar;
  m22 = m1.m22 * scalar;
  m23 = m1.m23 * scalar;
  m30 = m1.m30 * scalar;
  m31 = m1.m31 * scalar;
  m32 = m1.m32 * scalar;
  m33 = m1.m33 * scalar;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the result of multiplying itself with matrix m1.
  *
  * @param m1 the other matrix
  * @return this for chaining
  */
 public T mul(Matrix4f m1) {
  float n00 = m00 * m1.m00 + m01 * m1.m10 +
   m02 * m1.m20 + m03 * m1.m30;
  float n01 = m00 * m1.m01 + m01 * m1.m11 +
   m02 * m1.m21 + m03 * m1.m31;
  float n02 = m00 * m1.m02 + m01 * m1.m12 +
   m02 * m1.m22 + m03 * m1.m32;
  float n03 = m00 * m1.m03 + m01 * m1.m13 +
   m02 * m1.m23 + m03 * m1.m33;
  float n10 = m10 * m1.m00 + m11 * m1.m10 +
   m12 * m1.m20 + m13 * m1.m30;
  float n11 = m10 * m1.m01 + m11 * m1.m11 +
   m12 * m1.m21 + m13 * m1.m31;
  float n12 = m10 * m1.m02 + m11 * m1.m12 +
   m12 * m1.m22 + m13 * m1.m32;
  float n13 = m10 * m1.m03 + m11 * m1.m13 +
   m12 * m1.m23 + m13 * m1.m33;
  float n20 = m20 * m1.m00 + m21 * m1.m10 +
   m22 * m1.m20 + m23 * m1.m30;
  float n21 = m20 * m1.m01 + m21 * m1.m11 +
   m22 * m1.m21 + m23 * m1.m31;
  float n22 = m20 * m1.m02 + m21 * m1.m12 +
   m22 * m1.m22 + m23 * m1.m32;
  float n23 = m20 * m1.m03 + m21 * m1.m13 +
   m22 * m1.m23 + m23 * m1.m33;
  float n30 = m30 * m1.m00 + m31 * m1.m10 +
   m32 * m1.m20 + m33 * m1.m30;
  float n31 = m30 * m1.m01 + m31 * m1.m11 +
   m32 * m1.m21 + m33 * m1.m31;
  float n32 = m30 * m1.m02 + m31 * m1.m12 +
   m32 * m1.m22 + m33 * m1.m32;
  float n33 = m30 * m1.m03 + m31 * m1.m13 +
   m32 * m1.m23 + m33 * m1.m33;
  m00 = n00;
  m01 = n01;
  m02 = n02;
  m03 = n03;
  m10 = n10;
  m11 = n11;
  m12 = n12;
  m13 = n13;
  m20 = n20;
  m21 = n21;
  m22 = n22;
  m23 = n23;
  m30 = n30;
  m31 = n31;
  m32 = n32;
  m33 = n33;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the result of multiplying the two argument matrices together.
  *
  * @param m1 the first matrix
  * @param m2 the second matrix
  * @return this for chaining
  */
 public T mul(Matrix4f m1, Matrix4f m2) {
  float n00 = m1.m00 * m2.m00 + m1.m01 * m2.m10 + m1.m02 * m2.m20 + m1.m03 * m2.m30;
  float n01 = m1.m00 * m2.m01 + m1.m01 * m2.m11 + m1.m02 * m2.m21 + m1.m03 * m2.m31;
  float n02 = m1.m00 * m2.m02 + m1.m01 * m2.m12 + m1.m02 * m2.m22 + m1.m03 * m2.m32;
  float n03 = m1.m00 * m2.m03 + m1.m01 * m2.m13 + m1.m02 * m2.m23 + m1.m03 * m2.m33;
  float n10 = m1.m10 * m2.m00 + m1.m11 * m2.m10 + m1.m12 * m2.m20 + m1.m13 * m2.m30;
  float n11 = m1.m10 * m2.m01 + m1.m11 * m2.m11 + m1.m12 * m2.m21 + m1.m13 * m2.m31;
  float n12 = m1.m10 * m2.m02 + m1.m11 * m2.m12 + m1.m12 * m2.m22 + m1.m13 * m2.m32;
  float n13 = m1.m10 * m2.m03 + m1.m11 * m2.m13 + m1.m12 * m2.m23 + m1.m13 * m2.m33;
  float n20 = m1.m20 * m2.m00 + m1.m21 * m2.m10 + m1.m22 * m2.m20 + m1.m23 * m2.m30;
  float n21 = m1.m20 * m2.m01 + m1.m21 * m2.m11 + m1.m22 * m2.m21 + m1.m23 * m2.m31;
  float n22 = m1.m20 * m2.m02 + m1.m21 * m2.m12 + m1.m22 * m2.m22 + m1.m23 * m2.m32;
  float n23 = m1.m20 * m2.m03 + m1.m21 * m2.m13 + m1.m22 * m2.m23 + m1.m23 * m2.m33;
  float n30 = m1.m30 * m2.m00 + m1.m31 * m2.m10 + m1.m32 * m2.m20 + m1.m33 * m2.m30;
  float n31 = m1.m30 * m2.m01 + m1.m31 * m2.m11 + m1.m32 * m2.m21 + m1.m33 * m2.m31;
  float n32 = m1.m30 * m2.m02 + m1.m31 * m2.m12 + m1.m32 * m2.m22 + m1.m33 * m2.m32;
  float n33 = m1.m30 * m2.m03 + m1.m31 * m2.m13 + m1.m32 * m2.m23 + m1.m33 * m2.m33;
  m00 = n00;
  m01 = n01;
  m02 = n02;
  m03 = n03;
  m10 = n10;
  m11 = n11;
  m12 = n12;
  m13 = n13;
  m20 = n20;
  m21 = n21;
  m22 = n22;
  m23 = n23;
  m30 = n30;
  m31 = n31;
  m32 = n32;
  m33 = n33;
  return (T) this;
 }

 /**
  * Multiplies the transpose of matrix m1 times the transpose of matrix m2, and places the result
  * into this.
  *
  * @param m1 the matrix on the left hand side of the multiplication
  * @param m2 the matrix on the right hand side of the multiplication
  * @return this for chaining
  */
 public T mulTransposeBoth(Matrix4f m1, Matrix4f m2) {
  float n00 = m1.m00 * m2.m00 + m1.m10 * m2.m01 + m1.m20 * m2.m02 + m1.m30 * m2.m03;
  float n01 = m1.m00 * m2.m10 + m1.m10 * m2.m11 + m1.m20 * m2.m12 + m1.m30 * m2.m13;
  float n02 = m1.m00 * m2.m20 + m1.m10 * m2.m21 + m1.m20 * m2.m22 + m1.m30 * m2.m23;
  float n03 = m1.m00 * m2.m30 + m1.m10 * m2.m31 + m1.m20 * m2.m32 + m1.m30 * m2.m33;
  float n10 = m1.m01 * m2.m00 + m1.m11 * m2.m01 + m1.m21 * m2.m02 + m1.m31 * m2.m03;
  float n11 = m1.m01 * m2.m10 + m1.m11 * m2.m11 + m1.m21 * m2.m12 + m1.m31 * m2.m13;
  float n12 = m1.m01 * m2.m20 + m1.m11 * m2.m21 + m1.m21 * m2.m22 + m1.m31 * m2.m23;
  float n13 = m1.m01 * m2.m30 + m1.m11 * m2.m31 + m1.m21 * m2.m32 + m1.m31 * m2.m33;
  float n20 = m1.m02 * m2.m00 + m1.m12 * m2.m01 + m1.m22 * m2.m02 + m1.m32 * m2.m03;
  float n21 = m1.m02 * m2.m10 + m1.m12 * m2.m11 + m1.m22 * m2.m12 + m1.m32 * m2.m13;
  float n22 = m1.m02 * m2.m20 + m1.m12 * m2.m21 + m1.m22 * m2.m22 + m1.m32 * m2.m23;
  float n23 = m1.m02 * m2.m30 + m1.m12 * m2.m31 + m1.m22 * m2.m32 + m1.m32 * m2.m33;
  float n30 = m1.m03 * m2.m00 + m1.m13 * m2.m01 + m1.m23 * m2.m02 + m1.m33 * m2.m03;
  float n31 = m1.m03 * m2.m10 + m1.m13 * m2.m11 + m1.m23 * m2.m12 + m1.m33 * m2.m13;
  float n32 = m1.m03 * m2.m20 + m1.m13 * m2.m21 + m1.m23 * m2.m22 + m1.m33 * m2.m23;
  float n33 = m1.m03 * m2.m30 + m1.m13 * m2.m31 + m1.m23 * m2.m32 + m1.m33 * m2.m33;
  m00 = n00;
  m01 = n01;
  m02 = n02;
  m03 = n03;
  m10 = n10;
  m11 = n11;
  m12 = n12;
  m13 = n13;
  m20 = n20;
  m21 = n21;
  m22 = n22;
  m23 = n23;
  m30 = n30;
  m31 = n31;
  m32 = n32;
  m33 = n33;
  return (T) this;
 }

 /**
  * Multiplies matrix m1 times the transpose of matrix m2, and places the result into this.
  *
  * @param m1 the matrix on the left hand side of the multiplication
  * @param m2 the matrix on the right hand side of the multiplication
  * @return this for chaining
  */
 public T mulTransposeRight(Matrix4f m1, Matrix4f m2) {
  float n00 = m1.m00 * m2.m00 + m1.m01 * m2.m01 + m1.m02 * m2.m02 + m1.m03 * m2.m03;
  float n01 = m1.m00 * m2.m10 + m1.m01 * m2.m11 + m1.m02 * m2.m12 + m1.m03 * m2.m13;
  float n02 = m1.m00 * m2.m20 + m1.m01 * m2.m21 + m1.m02 * m2.m22 + m1.m03 * m2.m23;
  float n03 = m1.m00 * m2.m30 + m1.m01 * m2.m31 + m1.m02 * m2.m32 + m1.m03 * m2.m33;
  float n10 = m1.m10 * m2.m00 + m1.m11 * m2.m01 + m1.m12 * m2.m02 + m1.m13 * m2.m03;
  float n11 = m1.m10 * m2.m10 + m1.m11 * m2.m11 + m1.m12 * m2.m12 + m1.m13 * m2.m13;
  float n12 = m1.m10 * m2.m20 + m1.m11 * m2.m21 + m1.m12 * m2.m22 + m1.m13 * m2.m23;
  float n13 = m1.m10 * m2.m30 + m1.m11 * m2.m31 + m1.m12 * m2.m32 + m1.m13 * m2.m33;
  float n20 = m1.m20 * m2.m00 + m1.m21 * m2.m01 + m1.m22 * m2.m02 + m1.m23 * m2.m03;
  float n21 = m1.m20 * m2.m10 + m1.m21 * m2.m11 + m1.m22 * m2.m12 + m1.m23 * m2.m13;
  float n22 = m1.m20 * m2.m20 + m1.m21 * m2.m21 + m1.m22 * m2.m22 + m1.m23 * m2.m23;
  float n23 = m1.m20 * m2.m30 + m1.m21 * m2.m31 + m1.m22 * m2.m32 + m1.m23 * m2.m33;
  float n30 = m1.m30 * m2.m00 + m1.m31 * m2.m01 + m1.m32 * m2.m02 + m1.m33 * m2.m03;
  float n31 = m1.m30 * m2.m10 + m1.m31 * m2.m11 + m1.m32 * m2.m12 + m1.m33 * m2.m13;
  float n32 = m1.m30 * m2.m20 + m1.m31 * m2.m21 + m1.m32 * m2.m22 + m1.m33 * m2.m23;
  float n33 = m1.m30 * m2.m30 + m1.m31 * m2.m31 + m1.m32 * m2.m32 + m1.m33 * m2.m33;
  m00 = n00;
  m01 = n01;
  m02 = n02;
  m03 = n03;
  m10 = n10;
  m11 = n11;
  m12 = n12;
  m13 = n13;
  m20 = n20;
  m21 = n21;
  m22 = n22;
  m23 = n23;
  m30 = n30;
  m31 = n31;
  m32 = n32;
  m33 = n33;
  return (T) this;
 }

 /**
  * Multiplies the transpose of matrix m1 times matrix m2, and places the result into this.
  *
  * @param m1 the matrix on the left hand side of the multiplication
  * @param m2 the matrix on the right hand side of the multiplication
  * @return this for chaining
  */
 public T mulTransposeLeft(Matrix4f m1, Matrix4f m2) {
  float n00 = m1.m00 * m2.m00 + m1.m10 * m2.m10 + m1.m20 * m2.m20 + m1.m30 * m2.m30;
  float n01 = m1.m00 * m2.m01 + m1.m10 * m2.m11 + m1.m20 * m2.m21 + m1.m30 * m2.m31;
  float n02 = m1.m00 * m2.m02 + m1.m10 * m2.m12 + m1.m20 * m2.m22 + m1.m30 * m2.m32;
  float n03 = m1.m00 * m2.m03 + m1.m10 * m2.m13 + m1.m20 * m2.m23 + m1.m30 * m2.m33;
  float n10 = m1.m01 * m2.m00 + m1.m11 * m2.m10 + m1.m21 * m2.m20 + m1.m31 * m2.m30;
  float n11 = m1.m01 * m2.m01 + m1.m11 * m2.m11 + m1.m21 * m2.m21 + m1.m31 * m2.m31;
  float n12 = m1.m01 * m2.m02 + m1.m11 * m2.m12 + m1.m21 * m2.m22 + m1.m31 * m2.m32;
  float n13 = m1.m01 * m2.m03 + m1.m11 * m2.m13 + m1.m21 * m2.m23 + m1.m31 * m2.m33;
  float n20 = m1.m02 * m2.m00 + m1.m12 * m2.m10 + m1.m22 * m2.m20 + m1.m32 * m2.m30;
  float n21 = m1.m02 * m2.m01 + m1.m12 * m2.m11 + m1.m22 * m2.m21 + m1.m32 * m2.m31;
  float n22 = m1.m02 * m2.m02 + m1.m12 * m2.m12 + m1.m22 * m2.m22 + m1.m32 * m2.m32;
  float n23 = m1.m02 * m2.m03 + m1.m12 * m2.m13 + m1.m22 * m2.m23 + m1.m32 * m2.m33;
  float n30 = m1.m03 * m2.m00 + m1.m13 * m2.m10 + m1.m23 * m2.m20 + m1.m33 * m2.m30;
  float n31 = m1.m03 * m2.m01 + m1.m13 * m2.m11 + m1.m23 * m2.m21 + m1.m33 * m2.m31;
  float n32 = m1.m03 * m2.m02 + m1.m13 * m2.m12 + m1.m23 * m2.m22 + m1.m33 * m2.m32;
  float n33 = m1.m03 * m2.m03 + m1.m13 * m2.m13 + m1.m23 * m2.m23 + m1.m33 * m2.m33;
  m00 = n00;
  m01 = n01;
  m02 = n02;
  m03 = n03;
  m10 = n10;
  m11 = n11;
  m12 = n12;
  m13 = n13;
  m20 = n20;
  m21 = n21;
  m22 = n22;
  m23 = n23;
  m30 = n30;
  m31 = n31;
  m32 = n32;
  m33 = n33;
  return (T) this;
 }

 /**
  * Returns true if all of the data members of Matrix4f m1 are equal to the corresponding data
  * members in this Matrix4f.
  *
  * @param m1 the matrix with which the comparison is made.
  * @return true or false
  */
 public boolean equals(Matrix4f m1) {
  return (m00 == m1.m00 && m01 == m1.m01 && m02 == m1.m02 &&
   m03 == m1.m03 && m10 == m1.m10 && m11 == m1.m11 &&
   m12 == m1.m12 && m13 == m1.m13 && m20 == m1.m20 &&
   m21 == m1.m21 && m22 == m1.m22 && m23 == m1.m23 &&
   m30 == m1.m30 && m31 == m1.m31 && m32 == m1.m32 &&
   m33 == m1.m33);
 }

 /**
  * Returns true if the Object t1 is of type Matrix4f and all of the data members of t1 are equal to
  * the corresponding data members in this Matrix4f.
  *
  * @param t1 the matrix with which the comparison is made.
  * @return true or false
  */
 @Override
 public boolean equals(Object t1) {
  try {
   Matrix4f m2 = (Matrix4f) t1;
   return (m00 == m2.m00 && m01 == m2.m01 && m02 == m2.m02 &&
    m03 == m2.m03 && m10 == m2.m10 && m11 == m2.m11 &&
    m12 == m2.m12 && m13 == m2.m13 && m20 == m2.m20 &&
    m21 == m2.m21 && m22 == m2.m22 && m23 == m2.m23 &&
    m30 == m2.m30 && m31 == m2.m31 && m32 == m2.m32 &&
    m33 == m2.m33);
  } catch (ClassCastException | NullPointerException e1) {
   return false;
  }
 }

 /**
  * Returns true if the L-infinite distance between this matrix and matrix m1 is less than or equal
  * to the epsilon parameter, otherwise returns false. The L-infinite distance is equal to
  * MAX[i=0,1,2,3 ; j=0,1,2,3 ; abs(this.m(i,j) - m1.m(i,j)]
  *
  * @param m1 the matrix to be compared to this matrix
  * @param epsilon the threshold value
  * @return true or false
  */
 public boolean epsilonEquals(Matrix4f m1, float epsilon) {
  if (different_epsilon(m00, m1.m00, epsilon)) {
   return false;
  }
  if (different_epsilon(m01, m1.m01, epsilon)) {
   return false;
  }
  if (different_epsilon(m02, m1.m02, epsilon)) {
   return false;
  }
  if (different_epsilon(m03, m1.m03, epsilon)) {
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
  if (different_epsilon(m13, m1.m13, epsilon)) {
   return false;
  }
  if (different_epsilon(m20, m1.m20, epsilon)) {
   return false;
  }
  if (different_epsilon(m21, m1.m21, epsilon)) {
   return false;
  }
  if (different_epsilon(m22, m1.m22, epsilon)) {
   return false;
  }
  if (different_epsilon(m23, m1.m23, epsilon)) {
   return false;
  }
  if (different_epsilon(m30, m1.m30, epsilon)) {
   return false;
  }
  if (different_epsilon(m31, m1.m31, epsilon)) {
   return false;
  }
  if (different_epsilon(m32, m1.m32, epsilon)) {
   return false;
  }
  return !different_epsilon(m33, m1.m33, epsilon);
 }

 /**
  * Transform the vector vec using this Matrix4f and place the result into vecOut.
  *
  * @param <S>
  * @param vec the single precision vector to be transformed
  * @param vecOut the vector into which the transformed values are placed
  * @return vecOut for chaining
  */
 public <S extends Tuple4f> S transform(Tuple4f vec, S vecOut) {
  float x = m00 * vec.x + m01 * vec.y +
   m02 * vec.z + m03 * vec.w;
  float y = m10 * vec.x + m11 * vec.y +
   m12 * vec.z + m13 * vec.w;
  float z = m20 * vec.x + m21 * vec.y +
   m22 * vec.z + m23 * vec.w;
  vecOut.w = m30 * vec.x + m31 * vec.y +
   m32 * vec.z + m33 * vec.w;
  vecOut.x = x;
  vecOut.y = y;
  vecOut.z = z;
  return vecOut;
 }

 /**
  * Transform the 4 component tuple t1 using this Transform and place the result back into t1.
  *
  * @param <S>
  * @param t1 the single precision vector to be transformed
  * @return vec for chaining
  */
 public <S extends Tuple4f> S transform(S t1) {
  float x = m00 * t1.x + m01 * t1.y +
   m02 * t1.z + m03 * t1.w;
  float y = m10 * t1.x + m11 * t1.y +
   m12 * t1.z + m13 * t1.w;
  float z = m20 * t1.x + m21 * t1.y +
   m22 * t1.z + m23 * t1.w;
  t1.w = m30 * t1.x + m31 * t1.y +
   m32 * t1.z + m33 * t1.w;
  t1.x = x;
  t1.y = y;
  t1.z = z;
  return t1;
 }

 /**
  * Transforms the t1 using this matrix and place the result into t2.
  *
  * @param <S>
  * @param t1 the input point to be transformed.
  * @param t2 the transformed point
  * @return t2 for chaining
  */
 public <S extends Tuple3f> S transform(Tuple3f t1, S t2) {
  float x = m00 * t1.x + m01 * t1.y + m02 * t1.z + m03;
  float y = m10 * t1.x + m11 * t1.y + m12 * t1.z + m13;
  t2.z = m20 * t1.x + m21 * t1.y + m22 * t1.z + m23;
  t2.x = x;
  t2.y = y;
  return t2;
 }

 /**
  * Transforms the 3 component tuple t1 using the matrix and store the result back into t1.
  *
  * @param <S>
  * @param t1 the input point to be transformed.
  * @return t1 for chaining
  */
 public <S extends Tuple3f> S transform(S t1) {
  float x = m00 * t1.x + m01 * t1.y + m02 * t1.z + m03;
  float y = m10 * t1.x + m11 * t1.y + m12 * t1.z + m13;
  t1.z = m20 * t1.x + m21 * t1.y + m22 * t1.z + m23;
  t1.x = x;
  t1.y = y;
  return t1;
 }

 /**
  * Transforms the tuple t1 using only the rotational components (upper 3x3) and store the result
  * back into t1.
  *
  * @param <S> the tuple to transform
  * @param t1 the input point to be transformed.
  * @return point for chaining
  */
 public <S extends Tuple3f> S transform3x3(S t1) {
  float x = m00 * t1.x + m01 * t1.y + m02 * t1.z;
  float y = m10 * t1.x + m11 * t1.y + m12 * t1.z;
  t1.z = m20 * t1.x + m21 * t1.y + m22 * t1.z;
  t1.x = x;
  t1.y = y;
  return t1;
 }

 /**
  * Transforms the t1 using using only the rotational components (upper 3x3) and place the result
  * into t2.
  *
  * @param <S>
  * @param t1 the input point to be transformed.
  * @param t2 the transformed point
  * @return t2 for chaining
  */
 public <S extends Tuple3f> S transform3x3(Tuple3f t1, S t2) {
  float x = m00 * t1.x + m01 * t1.y + m02 * t1.z;
  float y = m10 * t1.x + m11 * t1.y + m12 * t1.z;
  t2.z = m20 * t1.x + m21 * t1.y + m22 * t1.z;
  t2.x = x;
  t2.y = y;
  return t2;
 }

 /**
  * Sets the rotational component (upper 3x3) of this matrix to the matrix values in the single
  * precision Matrix3f argument; the other elements of this matrix are unchanged; a singular value
  * decomposition is performed on this object's upper 3x3 matrix to factor out the scale, then this
  * object's upper 3x3 matrix components are replaced by the passed rotation components, and then
  * the scale is reapplied to the rotational components.
  *
  * @param m1 single precision 3x3 matrix
  * @return this for chaining
  */
 public T setRotation(Matrix3f m1) {
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
  return (T) this;
 }

 /**
  * Sets the rotational component (upper 3x3) of this matrix to the matrix equivalent values of the
  * quaternion argument; the other elements of this matrix are unchanged; a singular value
  * decomposition is performed on this object's upper 3x3 matrix to factor out the scale, then this
  * object's upper 3x3 matrix components are replaced by the matrix equivalent of the quaternion,
  * and then the scale is reapplied to the rotational components.
  *
  * @param q1 the quaternion that specifies the rotation
  * @return this for chaining
  */
 public T setRotation(Quat4f q1) {
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
  return (T) this;
 }

 /**
  * Sets the rotational component (upper 3x3) of this matrix to the matrix equivalent values of the
  * axis-angle argument; the other elements of this matrix are unchanged; a singular value
  * decomposition is performed on this object's upper 3x3 matrix to factor out the scale, then this
  * object's upper 3x3 matrix components are replaced by the matrix equivalent of the axis-angle,
  * and then the scale is reapplied to the rotational components.
  *
  * @param a1 the axis-angle to be converted (x, y, z, angle)
  * @return this for chaining
  */
 public T setRotation(AxisAngle4f a1) {
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
  return (T) this;
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
  return (T) this;
 }

 /**
  * Negates the value of this matrix: this = -this.
  *
  * @return this for chaining
  */
 public T negate() {
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
  return (T) this;
 }

 /**
  * Sets the value of this matrix equal to the negation of of the Matrix4f parameter.
  *
  * @param m1 the source matrix
  * @return this for chaining
  */
 public T negate(Matrix4f m1) {
  m00 = -m1.m00;
  m01 = -m1.m01;
  m02 = -m1.m02;
  m03 = -m1.m03;
  m10 = -m1.m10;
  m11 = -m1.m11;
  m12 = -m1.m12;
  m13 = -m1.m13;
  m20 = -m1.m20;
  m21 = -m1.m21;
  m22 = -m1.m22;
  m23 = -m1.m23;
  m30 = -m1.m30;
  m31 = -m1.m31;
  m32 = -m1.m32;
  m33 = -m1.m33;
  return (T) this;
 }

 /**
  * Decompose the 3x3 part of the matrix into scale and rotation.
  *
  * @param scale 3 components of scale
  * @param rotate normalized rotation matrix.
  */
 public void getScaleRotate(Tuple3f scale, Matrix3f rotate) {
  getScaleRotate(this, scale, rotate);
 }

 private static void getScaleRotate(Matrix4f m1, Tuple3f scale, Matrix3f rotate) {
  new Matrix3f(m1).getScaleRotate(scale, rotate);
 }

 
 /**
  * Get the first matrix element in the first row.
  *
  * @return Returns the m00.
  *
  * @since vecmath 1.5
  */
 public float getM00() {
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
 public T setM00(float m00) {
  this.m00 = m00;
  return (T) this;
 }

 /**
  * Get the second matrix element in the first row.
  *
  * @return Returns the m01.
  *
  * @since vecmath 1.5
  */
 public float getM01() {
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
 public T setM01(float m01) {
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
 public float getM02() {
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
 public T setM02(float m02) {
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
 public float getM10() {
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
 public T setM10(float m10) {
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
 public float getM11() {
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
 public T setM11(float m11) {
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
 public float getM12() {
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
 public T setM12(float m12) {
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
 public float getM20() {
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
 public T setM20(float m20) {
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
 public float getM21() {
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
 public T setM21(float m21) {
  this.m21 = m21;
  return (T) this;
 }

 /**
  * Get the third matrix element in the third row.
  *
  * @return Returns the m22.
  *
  * @since vecmath 1.5
  */
 public float getM22() {
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
 public T setM22(float m22) {
  this.m22 = m22;
  return (T) this;
 }

 /**
  * Get the fourth element of the first row.
  *
  * @return Returns the m03.
  *
  * @since vecmath 1.5
  */
 public float getM03() {
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
 public T setM03(float m03) {
  this.m03 = m03;
  return (T) this;
 }

 /**
  * Get the fourth element of the second row.
  *
  * @return Returns the m13.
  *
  * @since vecmath 1.5
  */
 public float getM13() {
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
 public T setM13(float m13) {
  this.m13 = m13;
  return (T) this;
 }

 /**
  * Get the fourth element of the third row.
  *
  * @return Returns the m23.
  *
  * @since vecmath 1.5
  */
 public float getM23() {
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
 public T setM23(float m23) {
  this.m23 = m23;
  return (T) this;
 }

 /**
  * Get the first element of the fourth row.
  *
  * @return Returns the m30.
  *
  * @since vecmath 1.5
  */
 public float getM30() {
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
 public T setM30(float m30) {
  this.m30 = m30;
  return (T) this;
 }

 /**
  * Get the second element of the fourth row.
  *
  * @return Returns the m31.
  *
  * @since vecmath 1.5
  */
 public float getM31() {
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
 public T setM31(float m31) {
  this.m31 = m31;
  return (T) this;
 }

 /**
  * Get the third element of the fourth row.
  *
  * @return Returns the m32.
  *
  * @since vecmath 1.5
  */
 public float getM32() {
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
 public T setM32(float m32) {
  this.m32 = m32;
  return (T) this;
 }

 /**
  * Get the fourth element of the fourth row.
  *
  * @return Returns the m33.
  *
  * @since vecmath 1.5
  */
 public float getM33() {
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
 public T setM33(float m33) {
  this.m33 = m33;
  return (T) this;
 }

 /**
  * Calculate a lookat matrix. This is the same as gluLookat()
  *
  * @param eye an array of 3 components for the eye position.
  * @param center an array of 3 components for the center position.
  * @param up an array of 3 components for the up direction.
  * @return this for chaining
  */
 public T setLookAt(Tuple3f eye, Tuple3f center, Tuple3f up) {
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
  return (T) this;
 }

 /**
  * Returns a hash code value based on the data values in this object. Two different Matrix4f
  * objects with identical data values (i.e., Matrix4f.equals returns true) will return the same
  * hash code value. Two objects with different data members may return the same hash value,
  * although this is not likely.
  *
  * @return the integer hash code value
  */
 @Override
 public int hashCode() {
  int hash = 7;
  hash = 67 * hash + Float.floatToIntBits(m00);
  hash = 67 * hash + Float.floatToIntBits(m01);
  hash = 67 * hash + Float.floatToIntBits(m02);
  hash = 67 * hash + Float.floatToIntBits(m03);
  hash = 67 * hash + Float.floatToIntBits(m10);
  hash = 67 * hash + Float.floatToIntBits(m11);
  hash = 67 * hash + Float.floatToIntBits(m12);
  hash = 67 * hash + Float.floatToIntBits(m13);
  hash = 67 * hash + Float.floatToIntBits(m20);
  hash = 67 * hash + Float.floatToIntBits(m21);
  hash = 67 * hash + Float.floatToIntBits(m22);
  hash = 67 * hash + Float.floatToIntBits(m23);
  hash = 67 * hash + Float.floatToIntBits(m30);
  hash = 67 * hash + Float.floatToIntBits(m31);
  hash = 67 * hash + Float.floatToIntBits(m32);
  hash = 67 * hash + Float.floatToIntBits(m33);
  return hash;
 }

 /**
  * Transforms the tuple t1 using only the transpose of the rotational components (upper 3x3) and
  * store the result back into t1.
  *
  * @param <S> the tuple to transform
  * @param t1 the input point to be transformed.
  * @return point for chaining
  */
 public <S extends Tuple3f> S transposeTransform3x3(S t1) {
  float x = m00 * t1.x + m10 * t1.y + m20 * t1.z;
  float y = m01 * t1.x + m11 * t1.y + m21 * t1.z;
  t1.z = m02 * t1.x + m12 * t1.y + m22 * t1.z;
  t1.x = x;
  t1.y = y;
  return t1;
 }

 /**
  * Transforms the t1 using using only the transpose rotational components (upper 3x3) and place the
  * result into t2.
  *
  * @param <S>
  * @param t1 the input point to be transformed.
  * @param t2 the transformed point
  * @return t2 for chaining
  */
 public <S extends Tuple3f> S transposeTransform3x3(Tuple3f t1, S t2) {
  float x = m00 * t1.x + m10 * t1.y + m20 * t1.z;
  float y = m01 * t1.x + m11 * t1.y + m21 * t1.z;
  t2.z = m02 * t1.x + m12 * t1.y + m22 * t1.z;
  t2.x = x;
  t2.y = y;
  return t2;
 }
}
