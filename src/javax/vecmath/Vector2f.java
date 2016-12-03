/*
 * $RCSfile: Vector2f.java,v $
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
 * $Date: 2008/02/28 20:18:51 $
 * $State: Exp $
 */
package javax.vecmath;

/**
 * A 2-element vector that is represented by single-precision floating point x,y coordinates.
 *
 */
public class Vector2f extends Tuple2f implements java.io.Serializable {

	// Combatible with 1.1
	static final long serialVersionUID = -2168194326883512320L;

	/**
	 * Constructs and initializes a Vector2f from the specified xy coordinates.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public Vector2f(float x, float y) {
		super(x, y);
	}

	/**
	 * Constructs and initializes a Vector2f from the specified array.
	 *
	 * @param v the array of length 2 containing xy in order
	 */
	public Vector2f(float[] v) {
		super(v);
	}

	/**
	 * Constructs and initializes a Vector2f from the specified Vector2f.
	 *
	 * @param v1 the Vector2f containing the initialization x y data
	 */
	public Vector2f(Vector2f v1) {
		super(v1);
	}

	/**
	 * Constructs and initializes a Vector2f from the specified Tuple2f.
	 *
	 * @param t1 the Tuple2f containing the initialization x y data
	 */
	public Vector2f(Tuple2f t1) {
		super(t1);
	}

	/**
	 * Constructs and initializes a Vector2f to (0,0).
	 */
	public Vector2f() {
		super();
	}


	/**
	 * Returns the angle in radians between this vector and the vector parameter; the return value is constrained to the
	 * range [0,PI].
	 *
	 * @param v1 the other vector
	 * @return the angle in radians in the range [0,PI]
	 */
	public final float angle(Vector2f v1) {
		float vDot = this.dot(v1) / (this.length() * v1.length());
		if (vDot < -1.0) {
			vDot = -1.0f;
		}
		if (vDot > 1.0) {
			vDot = 1.0f;
		}
		return ((float) (Math.acos(vDot)));
	}



}
