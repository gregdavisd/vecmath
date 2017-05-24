/*
 * $RCSfile: Point2f.java,v $
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
 * $Revision: 1.5 $
 * $Date: 2008/02/28 20:18:50 $
 * $State: Exp $
 */
package javax.vecmath;

/**
 * A 2 element point that is represented by single precision floating point x,y coordinates.
 *
 */
public class Point2f extends Tuple2f<Point2f> implements java.io.Serializable {

 // Compatible with 1.1
 static final long serialVersionUID = -4801347926528714435L;

 /**
  * Constructs and initializes a Point2f from the specified xy coordinates.
  *
  * @param x the x coordinate
  * @param y the y coordinate
  */
 public Point2f(float x, float y) {
  super(x, y);
 }

 /**
  * Constructs and initializes a Point2f from the specified array.
  *
  * @param p the array of length 2 containing xy in order
  */
 public Point2f(float[] p) {
  super(p);
 }

 /**
  * Constructs and initializes a Point2f from the specified Point2f.
  *
  * @param p1 the Point2f containing the initialization x y data
  */
 public Point2f(Point2f p1) {
  super(p1);
 }

 /**
  * Constructs and initializes a Point2f from the specified Tuple2f.
  *
  * @param t1 the Tuple2f containing the initialization x y data
  */
 public Point2f(Tuple2f t1) {
  super(t1);
 }

 /**
  * Constructs and initializes a Point2f to (0,0).
  */
 public Point2f() {
 }

 /**
  * Computes the L-1 (Manhattan) distance between this point and point p1. The L-1 distance is equal
  * to abs(x1-x2) + abs(y1-y2).
  *
  * @param p1 the other point
  * @return L-1 distance
  */
 public float distanceL1(Point2f p1) {
  return (Math.abs(this.x - p1.x) + Math.abs(this.y - p1.y));
 }

 /**
  * Computes the L-infinite distance between this point and point p1. The L-infinite distance is
  * equal to MAX[abs(x1-x2), abs(y1-y2)].
  *
  * @param p1 the other point
  * @return L-infinite distance
  */
 public float distanceLinf(Point2f p1) {
  return (Math.max(Math.abs(this.x - p1.x), Math.abs(this.y - p1.y)));
 }
}
