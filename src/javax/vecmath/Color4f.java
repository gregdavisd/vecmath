/*
 * $RCSfile: Color4f.java,v $
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
 * A four-element color represented by single precision floating point x, y, z, and w values. The x, y, z, and w values represent
 * the red, blue, green, and alpha color values, respectively. Color and alpha components should be in the range [0.0, 1.0].
 * <p>
 * Java 3D assumes that a linear (gamma-corrected) visual is used for all colors.
 *
 */
public class Color4f extends Tuple4f implements java.io.Serializable {

	public static final Color4f BLACK = new Color4f(0f, 0f, 0f, 1f);
	public static final Color4f WHITE = new Color4f(1f, 1f, 1f, 1f);

	// Compatible with 1.1
	static final long serialVersionUID = 8577680141580006740L;

	/**
	 * Constructs and initializes a Color4f from the specified xyzw coordinates.
	 *
	 * @param x the red color value
	 * @param y the green color value
	 * @param z the blue color value
	 * @param w the alpha value
	 */
	public Color4f(float x, float y, float z, float w) {
		super(x, y, z, w);
	}

	/**
	 * Constructs and initializes a Color4f from the specified xyz coordinates, alpha is set to 1.0.
	 *
	 * @param x the red color value
	 * @param y the green color value
	 * @param z the blue color value
	 */
	public Color4f(float x, float y, float z) {
		super(x, y, z, 1);
	}

	/**
	 * Constructs and initializes a Color4f from the array of length 4.
	 *
	 * @param c the array of length 4 containing r,g,b,a in order
	 */
	public Color4f(float[] c) {
		super(c);
	}

	/**
	 * Constructs and initializes a Color4f from the specified Color4f.
	 *
	 * @param c1 the Color4f containing the initialization r,g,b,a data
	 */
	public Color4f(Color4f c1) {
		super(c1);
	}

	/**
	 * Constructs and initializes a Color4f from the specified Color3f. The alpha is set to 1.0
	 *
	 * @param c1 the Color4f containing the initialization r,g,b,a data
	 */
	public Color4f(Color3f c1) {
		super(c1.x, c1.y, c1.z, 1.0f);
	}

	/**
	 * Construct color from an int. (0xAARRGGBB).
	 *
	 * @param bits
	 */
	public Color4f(int bits) {
		z = (float) (bits & 0xff) / 255.0f;
		y = (float) ((bits >>> 8) & 0xff) / 255.0f;
		x = (float) ((bits >>> 16) & 0xff) / 255.0f;
		w = (float) ((bits >>> 24) & 0xff) / 255.0f;
	}

	/**
	 * Constructs and initializes a Color4f from the specified Tuple4f.
	 *
	 * @param t1 the Tuple4f containing the initialization r,g,b,a data
	 */
	public Color4f(Tuple4f t1) {
		super(t1);
	}

	/**
	 * Constructs and initializes a Color4f to (0.0, 0.0, 0.0, 0.0).
	 */
	public Color4f() {
		super(0, 0, 0, 1);
	}

	public final int getRGB() {
		byte red = (byte) Math.min(Math.max(x * 255.0f, 0.0f), 255.0f);
		byte green = (byte) Math.min(Math.max(y * 255.0f, 0.0f), 255.0f);
		byte blue = (byte) Math.min(Math.max(z * 255.0f, 0.0f), 255.0f);
		byte alpha = (byte) Math.min(Math.max(w * 255.0f, 0.0f), 255.0f);
		int bits = ((alpha << 24) & 0xff000000) | ((red << 16) & 0x00ff0000) | ((green << 8) & 0x0000ff00) | ((blue) & 0xff);
		return bits;
	}
}
