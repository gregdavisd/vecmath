/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javax.vecmath;

/**
 *
 * @author Gregery Barton
 */
public class VecMath {

	/**
	 *
	 */
	public static final float PI = (float) Math.PI;

	/**
	 *
	 * @param x
	 * @return
	 */
	public static float sin(float x) {
		return (float) Math.sin(x);
	}

	/**
	 *
	 * @param x
	 * @return
	 */
	public static float cos(float x) {
		return (float) Math.cos(x);
	}

	/**
	 *
	 * @param x
	 * @return
	 */
	public static float tan(float x) {
		return (float) Math.tan(x);
	}

	/**
	 *
	 * @param x
	 * @return
	 */
	public static float atan(float x) {
		return (float) Math.atan(x);
	}

	/**
	 *
	 * @param x
	 * @param y
	 * @return
	 */
	public static float atan2(float x, float y) {
		return (float) Math.atan2(x, y);
	}

	/**
	 *
	 * @param x
	 * @return
	 */
	public static float sqrt(float x) {
		return (float) Math.sqrt(x);
	}

	/**
	 *
	 * @param x
	 * @return
	 */
	public static float acos(float x) {
		return (float) Math.acos(x);
	}

	/**
	 *
	 * @param x
	 * @return
	 */
	public static double sin(double x) {
		return (double) StrictMath.sin(x);
	}

	/**
	 *
	 * @param x
	 * @return
	 */
	public static double cos(double x) {
		return (double) StrictMath.cos(x);
	}

	/**
	 *
	 * @param x
	 * @return
	 */
	public static double tan(double x) {
		return (double) StrictMath.tan(x);
	}

	/**
	 *
	 * @param x
	 * @return
	 */
	public static double atan(double x) {
		return (double) StrictMath.atan(x);
	}

	/**
	 *
	 * @param x
	 * @param y
	 * @return
	 */
	public static double atan2(double x, double y) {
		return (double) StrictMath.atan2(x, y);
	}

	/**
	 *
	 * @param x
	 * @return
	 */
	public static double sqrt(double x) {
		return (double) StrictMath.sqrt(x);
	}

	/**
	 *
	 * @param x
	 * @return
	 */
	public static double acos(double x) {
		return (double) StrictMath.acos(x);
	}

	static boolean different_epsilon(float a, float b, float epsilon) {
		float diff = a - b;
		if (Float.isNaN(diff)) {
			return false;
		}
		return Math.abs(diff) > epsilon;
	}
}
