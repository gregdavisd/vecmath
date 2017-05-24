/*
 * Copyright Gregery Barton
 * All rights reserved
 */
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

import static javax.vecmath.VecMath.different_epsilon;
import static javax.vecmath.VecMath.cos;
import static javax.vecmath.VecMath.sin;

/**
 *
 * @author Gregery Barton
 * @param <T>
 */
public class Matrix2f<T extends Matrix2f> implements java.io.Serializable, Cloneable {

 static final long serialVersionUID = 1L;
 /**
  * The first matrix element in the first row.
  */
 public float m00;
 /**
  * The second matrix element in the first row.
  */
 public float m01;
 /**
  * The first matrix element in the second row.
  */
 public float m10;
 /**
  * The second matrix element in the second row.
  */
 public float m11;

 /**
  *
  */
 public Matrix2f() {
 }

 /**
  * Constructs and initializes a Matrix3f from the specified four values.
  *
  * @param m00
  * @param m01
  * @param m10
  * @param m11
  */
 public Matrix2f(float m00, float m01, float m10, float m11) {
  this.m00 = m00;
  this.m01 = m01;
  this.m10 = m10;
  this.m11 = m11;
 }

 /**
  * Constructs a new matrix with the same values as the Matrix3f parameter.
  *
  * @param m1 the source matrix
  */
 public Matrix2f(Matrix2f m1) {
  m00 = m1.m00;
  m01 = m1.m01;
  m10 = m1.m10;
  m11 = m1.m11;
 }

 /**
  * Get the first matrix element in the first row.
  *
  * @return Returns the m00.
  *
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
  *
  */
 public float getM01() {
  return m01;
 }

 /**
  * Set the second matrix element in the firs
  *
  *
  * @param m01 The m01 to set.
  * @return this for chaining
  *
  */
 public T setM01(float m01) {
  this.m01 = m01;
  return (T) this;
 }

 /**
  * Get first matrix element in the second row.
  *
  * @return Returns the m10.
  *
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
  */
 public T setM11(float m11) {
  this.m11 = m11;
  return (T) this;
 }

 /**
  * Constructs and initializes a Matrix3f from the specified nine-element array. this.m00 =v[0],
  * this.m01=v[1], etc.
  *
  * @param v the array of length 4 containing in order
  */
 public Matrix2f(float[] v) {
  m00 = v[0];
  m01 = v[1];
  m10 = v[2];
  m11 = v[3];
 }

 /**
  * Constructs and initializes a Matrix2f from the specified 2x2 two dimensional array.
  *
  * @param v the array of size [2][2] containing in column order
  */
 public Matrix2f(float[][] v) {
  m00 = v[0][0];
  m01 = v[0][1];
  m10 = v[1][0];
  m11 = v[1][1];
 }

 /**
  * Set the elements of this matrix to the abs value of the corresponding element in m1.
  *
  * @param m1 the matrix to get values
  * @return this for chaining
  */
 public T abs(Matrix2f m1) {
  abs(this, m1);
  return (T) this;
 }

 /**
  * Set each element of this matrix to its abs value
  *
  * @return this for chaining.
  */
 public T abs() {
  abs(this, this);
  return (T) this;
 }

 private static void abs(Matrix2f dest, Matrix2f mat) {
  dest.m00 = Math.abs(mat.m00);
  dest.m01 = Math.abs(mat.m01);
  dest.m10 = Math.abs(mat.m10);
  dest.m11 = Math.abs(mat.m11);
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
  m10 += scalar;
  m11 += scalar;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the matrix sum of matrices m1 and m2.
  *
  * @param m1 the first matrix
  * @param m2 the second matrix
  * @return this for chaining
  */
 public T add(Matrix2f m1, Matrix2f m2) {
  m00 = m1.m00 + m2.m00;
  m01 = m1.m01 + m2.m01;
  m10 = m1.m10 + m2.m10;
  m11 = m1.m11 + m2.m11;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the matrix sum of itself and matrix m1.
  *
  * @param m1 the other matrix
  * @return this for chaining
  */
 public T add(Matrix2f m1) {
  m00 += m1.m00;
  m01 += m1.m01;
  m10 += m1.m10;
  m11 += m1.m11;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the matrix difference of matrices m1 and m2.
  *
  * @param m1 the first matrix
  * @param m2 the second matrix
  * @return this for chaining
  */
 public T sub(Matrix2f m1, Matrix2f m2) {
  m00 = m1.m00 - m2.m00;
  m01 = m1.m01 - m2.m01;
  m10 = m1.m10 - m2.m10;
  m11 = m1.m11 - m2.m11;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the matrix difference of itself and matrix m1 (this = this -
  * m1).
  *
  * @param m1 the other matrix
  * @return this for chaining
  */
 public T sub(Matrix2f m1) {
  m00 -= m1.m00;
  m01 -= m1.m01;
  m10 -= m1.m10;
  m11 -= m1.m11;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to its transpose.
  *
  * @return this for chaining
  */
 public T transpose() {
  float temp;
  temp = m10;
  m10 = m01;
  m01 = temp;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the transpose of the argument matrix.
  *
  * @param m1 the matrix to be transposed
  * @return this for chaining
  */
 public T transpose(Matrix2f m1) {
  set(m1);
  transpose();
  return (T) this;
 }

 /**
  * Sets the values in this Matrix3f equal to the row-major array parameter (ie, the first three
  * elements of the array will be copied into the first row of this matrix, etc.).
  *
  * @param m the single precision array of length 9
  * @return this for chaining
  */
 public T set(float[] m) {
  m00 = m[0];
  m01 = m[1];
  m10 = m[2];
  m11 = m[3];
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the value of the Matrix3f argument.
  *
  * @param m1 the source matrix3f
  * @return this for chaining
  */
 public T set(Matrix2f m1) {
  m00 = m1.m00;
  m01 = m1.m01;
  m10 = m1.m10;
  m11 = m1.m11;
  return (T) this;
 }

 /**
  * Computes the determinant of this matrix.
  *
  * @return the determinant of this matrix
  */
 public float determinant() {
  return m00 * m11 - m01 * m10;
 }

 /**
  * Sets the value of this matrix to the matrix inverse of the passed matrix m1.
  *
  * @param m1 the matrix to be inverted
  * @return this for chaining
  */
 public T invert(Matrix2f m1) {
  Matrix2f.this.set(m1);
  invertGeneral(this);
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

 private static void invertGeneral(Matrix2f m1) {
  float invdet = 1.0f / m1.determinant();
  float a = m1.m00;
  float b = m1.m01;
  float c = m1.m10;
  float d = m1.m11;
  m1.m00 = d * invdet;
  m1.m01 = -b * invdet;
  m1.m10 = -c * invdet;
  m1.m11 = a * invdet;
 }

 /**
  * Sets the value of this matrix to a scale matrix with the passed scale amount.
  *
  * @param scale the scale factor for the matrix
  * @return this for chaining
  */
 public T set(float scale) {
  m00 = scale;
  m01 = 0.0f;
  m10 = 0.0f;
  m11 = scale;
  return (T) this;
 }

 /**
  * Multiplies each element of this matrix by a scalar.
  *
  * @param scalar the scalar multiplier
  * @return this for chaining
  */
 public T mul(float scalar) {
  m00 *= scalar;
  m01 *= scalar;
  m10 *= scalar;
  m11 *= scalar;
  return (T) this;
 }

 /**
  * Multiplies each element of matrix m1 by a scalar and places the result into this. Matrix m1 is
  * not modified.
  *
  * @param scalar the scalar multiplier
  * @param m1 the original matrix
  * @return this for chaining
  */
 public T mul(float scalar, Matrix2f m1) {
  m00 = scalar * m1.m00;
  m01 = scalar * m1.m01;
  m10 = scalar * m1.m10;
  m11 = scalar * m1.m11;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the result of multiplying itself with matrix m1.
  *
  * @param m1 the other matrix
  * @return this for chaining
  */
 public T mul(Matrix2f m1) {
  float n00 = m00 * m1.m00 + m01 * m1.m10;
  float n01 = m00 * m1.m10 + m01 * m1.m11;
  float n10 = m10 * m1.m00 + m11 * m1.m10;
  float n11 = m10 * m1.m10 + m11 * m1.m11;
  m00 = n00;
  m01 = n01;
  m10 = n10;
  m11 = n11;
  return (T) this;
 }

 /**
  * Sets the value of this matrix to the result of multiplying the two argument matrices together.
  *
  * @param m1 the first matrix
  * @param m2 the second matrix
  * @return this for chaining
  */
 public T mul(Matrix2f m1, Matrix2f m2) {
  float n00 = m1.m00 * m2.m00 + m1.m01 * m2.m10;
  float n01 = m1.m00 * m2.m10 + m1.m01 * m2.m11;
  float n10 = m1.m10 * m2.m00 + m1.m11 * m2.m10;
  float n11 = m1.m10 * m2.m10 + m1.m11 * m2.m11;
  m00 = n00;
  m01 = n01;
  m10 = n10;
  m11 = n11;
  return (T) this;
 }

 /**
  * Multiplies this matrix by matrix m1, does an SVD normalization of the result, and places the
  * result back into this matrix. this = SVDnorm(this*m1).
  *
  * @param m1 the matrix on the right hand side of the multiplication
  * @return this for chaining
  */
 public T mulNormalize(Matrix2f m1) {
  Matrix2f tmp = new Matrix2f();
  tmp.mul(this, m1);
  getScaleRotate(tmp, new Vector2f(), this);
  return (T) this;
 }

 /**
  * Multiplies matrix m1 by matrix m2, does an SVD normalization of the result, and places the
  * result into this matrix. this = SVDnorm(m1*m2).
  *
  * @param m1 the matrix on the left hand side of the multiplication
  * @param m2 the matrix on the right hand side of the multiplication
  * @return this for chaining
  */
 public T mulNormalize(Matrix2f m1, Matrix2f m2) {
  Matrix2f tmp = new Matrix2f();
  tmp.mul(m1, m2);
  getScaleRotate(tmp, new Vector2f(), this);
  return (T) this;
 }

 /**
  * Scale the columns of matrix m1 by the components of s and store the result in this matrix
  *
  * @param m1 the matrix to scale
  * @param s scale values
  * @return this for chaining
  */
 public T mul(Matrix2f m1, Tuple2f s) {
  scale(this, m1, s);
  return (T) this;
 }

 /**
  * Scale the columns of this matrix by the components of s and store the result in this matrix
  *
  * @param s scale values
  * @return this for chaining
  */
 public T mul(Tuple2f s) {
  scale(this, this, s);
  return (T) this;
 }

 static void getScaleRotate(Matrix2f m1, Tuple2f scale, Matrix2f rotate) {
  double[] tmp = new double[4];  // scratch matrix
  tmp[0] = m1.m00;
  tmp[1] = m1.m10;
  tmp[2] = m1.m01;
  tmp[3] = m1.m11;
  SingularValueDecomposition svd = new Matrix(tmp, 2).svd();
  Matrix u = svd.getU();
  Matrix vt = svd.getV().transpose();
  Matrix R = u.times(vt);
  double[] singles = svd.getSingularValues();
  scale.x = (float) singles[0];
  scale.y = (float) singles[1];
  rotate.m00 = (float) R.get(0, 0);
  rotate.m01 = (float) R.get(0, 1);
  rotate.m10 = (float) R.get(1, 0);
  rotate.m11 = (float) R.get(1, 1);
 }

 private static void scale(Matrix2f dest, Matrix2f mat, Tuple2f s) {
  dest.m00 = mat.m00 * s.x;
  dest.m01 = mat.m01 * s.y;
  dest.m10 = mat.m10 * s.x;
  dest.m11 = mat.m11 * s.y;
 }

 /**
  * Negates the value of this matrix: this = -this.
  *
  * @return this for chaining
  */
 public T negate() {
  m00 = -m00;
  m01 = -m01;
  m10 = -m10;
  m11 = -m11;
  return (T) this;
 }

 /**
  * Sets the value of this matrix equal to the negation of the Matrix3f parameter.
  *
  * @param m1 the source matrix
  * @return this for chaining
  */
 public T negate(Matrix2f m1) {
  m00 = -m1.m00;
  m01 = -m1.m01;
  m10 = -m1.m10;
  m11 = -m1.m11;
  return (T) this;
 }

 /**
  * Multiply this matrix by the tuple t and place the result back into the tuple (t = this*t).
  *
  * @param <S>
  * @param t the tuple to be multiplied by this matrix and then replaced
  * @return t for chaining
  */
 public <S extends Tuple2f> S transform(S t) {
  float x, y;
  x = m00 * t.x + m01 * t.y;
  y = m10 * t.x + m11 * t.y;
  t.set(x, y);
  return (S) t;
 }

 /**
  * Multiply this matrix by the tuple t and and place the result into the tuple "result" (result =
  * this*t).
  *
  * @param <S>
  * @param t the tuple to be multiplied by this matrix
  * @param result the tuple into which the product is placed
  * @return result for chaining
  */
 public <S extends Tuple2f> S transform(Tuple2f t, S result) {
  float x = m00 * t.x + m01 * t.y;
  float y = m10 * t.x + m11 * t.y;
  result.set(x, y);
  return (S) result;
 }

 /**
  * Sets this matrix to all zeros.
  *
  * @return this for chaining
  */
 public T setZero() {
  m00 = 0.0f;
  m01 = 0.0f;
  m10 = 0.0f;
  m11 = 0.0f;
  return (T) this;
 }

 /**
  * Sets this matrix to identity.
  *
  * @return this for chaining
  */
 public T setIdentity() {
  m00 = 1.0f;
  m01 = 0.0f;
  m10 = 0.0f;
  m11 = 1.0f;
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
 public T setElement(int row, int column, float value) {
  switch (row) {
   case 0:
    switch (column) {
     case 0:
      m00 = value;
      break;
     case 1:
      m01 = value;
      break;
     default:
      throw new ArrayIndexOutOfBoundsException();
    }
    break;
   case 1:
    switch (column) {
     case 0:
      m10 = value;
      break;
     case 1:
      m11 = value;
      break;
     default:
      throw new ArrayIndexOutOfBoundsException();
    }
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
  * @return the value at the indexed element.
  */
 public float getElement(int row, int column) {
  int i = (row * 2) + column;
  switch (i) {
   case 0:
    return (m00);
   case 1:
    return (m01);
   case 2:
    return (m10);
   case 3:
    return (m11);
   default:
    throw new ArrayIndexOutOfBoundsException();
  }
 }

 /**
  * Sets the value of this matrix to a counter clockwise rotation.
  *
  * @param angle the angle to rotate by in radians
  * @return this for chaining
  */
 public T rot(float angle) {
  float sinAngle = sin(angle);
  float cosAngle = cos(angle);
  m00 = cosAngle;
  m01 = -sinAngle;
  m10 = sinAngle;
  m11 = cosAngle;
  return (T) this;
 }

 /**
  * Sets the specified column of this matrix to the values provided.
  *
  * @param column the column number to be modified (zero indexed)
  * @param x the first row element
  * @param y the second row element
  * @return this for chaining
  */
 public T setColumn(int column, float x, float y) {
  switch (column) {
   case 0:
    m00 = x;
    m10 = y;
    break;
   case 1:
    m01 = x;
    m11 = y;
    break;
   default:
    throw new ArrayIndexOutOfBoundsException();
  }
  return (T) this;
 }

 /**
  * Returns a string that contains the values of this Matrix3f.
  *
  * @return the String representation
  */
 @Override
 public String toString() {
  return m00 + ", " + m01 + "\n"
   + m10 + ", " + m11 + "\n";
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
  Matrix2f m1 = null;
  try {
   m1 = (Matrix2f) super.clone();
  } catch (CloneNotSupportedException e) {
   // this shouldn't happen, since we are Cloneable
   throw new InternalError();
  }
  return m1;
 }

 /**
  * Returns true if all of the data members of Matrix3f m1 are equal to the corresponding data
  * members in this Matrix3f.
  *
  * @param m1 the matrix with which the comparison is made
  * @return true or false
  */
 public boolean equals(Matrix2f m1) {
  return (m00 == m1.m00 && m01 == m1.m01
   && m10 == m1.m10 && m11 == m1.m11);
 }

 /**
  * Returns true if the L-infinite distance between this matrix and matrix m1 is less than or equal
  * to the epsilon parameter, otherwise returns false. The L-infinite distance is equal to
  * MAX[i=0,1,2 ; j=0,1,2 ; abs(this.m(i,j) - m1.m(i,j)]
  *
  * @param m1 the matrix to be compared to this matrix
  * @param epsilon the threshold value
  * @return
  */
 public boolean epsilonEquals(Matrix3f m1, float epsilon) {
  if (different_epsilon(m00, m1.m00, epsilon)) {
   return false;
  }
  if (different_epsilon(m01, m1.m01, epsilon)) {
   return false;
  }
  if (different_epsilon(m10, m1.m10, epsilon)) {
   return false;
  }
  return !different_epsilon(m11, m1.m11, epsilon);
 }
}
