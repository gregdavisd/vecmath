/*
 * $RCSfile: Vector4f.java,v $
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
 * $Date: 2008/02/28 20:18:51 $
 * $State: Exp $
 */
package javax.vecmath;

/**
 * A 4-element vector represented by single-precision floating point x,y,z,w coordinates.
 *
 */
public class Vector4f extends Tuple4f<Vector4f> implements java.io.Serializable {

 // Compatible with 1.1
 static final long serialVersionUID = 8749319902347760659L;

 /**
  * Constructs and initializes a Vector4f from the specified xyzw coordinates.
  *
  * @param x the x coordinate
  * @param y the y coordinate
  * @param z the z coordinate
  * @param w the w coordinate
  */
 public Vector4f(float x, float y, float z, float w) {
  super(x, y, z, w);
 }

 /**
  * Constructs and initializes a Vector4f from the array of length 4.
  *
  * @param v the array of length 4 containing xyzw in order
  */
 public Vector4f(float[] v) {
  super(v);
 }

 /**
  * Constructs and initializes a Vector4f from the specified Vector4f.
  *
  * @param v1 the Vector4f containing the initialization x y z w data
  */
 public Vector4f(Vector4f v1) {
  super(v1);
 }

 /**
  * Constructs and initializes a Vector4f from the specified Tuple4f.
  *
  * @param t1 the Tuple4f containing the initialization x y z w data
  */
 public Vector4f(Tuple4f t1) {
  super(t1);
 }

 /**
  * Constructs and initializes a Vector4f from the specified Tuple3f. The x,y,z components of this
  * vector are set to the corresponding components of tuple t1. The w component of this vector is
  * set to 0.
  *
  * @param t1 the tuple to be copied
  *
  * @since vecmath 1.2
  */
 public Vector4f(Tuple3f t1) {
  super(t1.x, t1.y, t1.z, 0.0f);
 }

 /**
  * Constructs and initializes a Vector4f to (0,0,0,0).
  */
 public Vector4f() {
  super();
 }
}
