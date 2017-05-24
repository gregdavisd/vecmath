/*
 * $RCSfile: Color3f.java,v $
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
 * A three-element color value represented by single precision floating point x,y,z values. The
 * x,y,z values represent the red, green, and blue color values, respectively. Color components
 * should be in the range of [0.0, 1.0].
 * <p>
 * Java 3D assumes that a linear (gamma-corrected) visual is used for all colors.
 *
 */
public class Color3f extends Tuple3f<Color3f> implements java.io.Serializable {

 // Compatible with 1.1
 static final long serialVersionUID = -1861792981817493659L;

 /**
  * Constructs and initializes a Color3f from the three xyz values.
  *
  * @param x the red color value
  * @param y the green color value
  * @param z the blue color value
  */
 public Color3f(float x, float y, float z) {
  super(x, y, z);
 }

 /**
  * Constructs and initializes a Color3f from the array of length 3.
  *
  * @param v the array of length 3 containing xyz in order
  */
 public Color3f(float[] v) {
  super(v);
 }

 /**
  * Constructs and initializes a Color3f from the specified Color3f.
  *
  * @param v1 the Color3f containing the initialization x y z data
  */
 public Color3f(Color3f v1) {
  super(v1);
 }

 /**
  * Constructs and initializes a Color3f from the specified Tuple3f.
  *
  * @param t1 the Tuple3f containing the initialization x y z data
  */
 public Color3f(Tuple3f t1) {
  super(t1);
 }

 /**
  * Construct and initialise from an integer color in the format 0xRRGGBB
  *
  * @param bits
  */
 public Color3f(int bits) {
  set(bits);
 }

 /**
  *
  * @param bits
  * @return
  */
 public Color3f set(int bits) {
  z = (float) (bits & 0xff) / 256.0f;
  y = (float) ((bits >>> 8) & 0xff) / 256.0f;
  x = (float) ((bits >>> 16) & 0xff) / 256.0f;
  return this;
 }

 /**
  * Constructs and initializes a Color3f to (0.0, 0.0, 0.0).
  */
 public Color3f() {
 }

 /**
  * Get the color as an integer (0xffRRGGBB)
  *
  * @return
  */
 public int getRGB() {
  byte red = (byte) Math.min(Math.max(x * 255.0f, 0.0f), 255.0f);
  byte green = (byte) Math.min(Math.max(y * 255.0f, 0.0f), 255.0f);
  byte blue = (byte) Math.min(Math.max(z * 255.0f, 0.0f), 255.0f);
  int bits = (0xff000000) | ((red << 16) & 0x00ff0000) | ((green << 8) & 0x0000ff00) | ((blue) &
    0x000000ff);
  return bits;
 }
}
