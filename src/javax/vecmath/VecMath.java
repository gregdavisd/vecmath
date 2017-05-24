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

 public static final boolean DEBUG_BLOCKS = true;
 public static final boolean USE_STRICT_MATH = false;
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
  if (!USE_STRICT_MATH) {
   return (float) Math.sin(x);
  } else {
   return (float) StrictMath.sin(x);
  }
 }

 public static float asin(float x) {
  if (!USE_STRICT_MATH) {
   return (float) Math.asin(x);
  } else {
   return (float) StrictMath.asin(x);
  }
 }

 /**
  *
  * @param x
  * @return
  */
 public static float cos(float x) {
  if (!USE_STRICT_MATH) {
   return (float) Math.cos(x);
  } else {
   return (float) StrictMath.cos(x);
  }
 }

 /**
  *
  * @param x
  * @return
  */
 public static float tan(float x) {
  if (!USE_STRICT_MATH) {
   return (float) Math.tan(x);
  } else {
   return (float) StrictMath.tan(x);
  }
 }

 /**
  *
  * @param x
  * @return
  */
 public static float atan(float x) {
  if (!USE_STRICT_MATH) {
   return (float) Math.atan(x);
  } else {
   return (float) StrictMath.atan(x);
  }
 }

 /**
  *
  * @param x
  * @param y
  * @return
  */
 public static float atan2(float x, float y) {
  if (!USE_STRICT_MATH) {
   return (float) Math.atan2(x, y);
  } else {
   return (float) StrictMath.atan2(x, y);
  }
 }

 /**
  *
  * @param x
  * @return
  */
 public static float sqrt(float x) {
  if (!USE_STRICT_MATH) {
   return (float) Math.sqrt(x);
  } else {
   return (float) StrictMath.sqrt(x);
  }
 }

 /**
  *
  * @param x
  * @return
  */
 public static float acos(float x) {
  if (!USE_STRICT_MATH) {
   return (float) Math.acos(x);
  } else {
   return (float) StrictMath.acos(x);
  }
 }

 /**
  *
  * @param x
  * @return
  */
 public static double sin(double x) {
  if (!USE_STRICT_MATH) {
   return (double) Math.sin(x);
  } else {
   return (double) StrictMath.sin(x);
  }
 }

 public static double asin(double x) {
  if (!USE_STRICT_MATH) {
   return (double) Math.asin(x);
  } else {
   return (double) StrictMath.asin(x);
  }
 }

 /**
  *
  * @param x
  * @return
  */
 public static double cos(double x) {
  if (!USE_STRICT_MATH) {
   return (double) Math.cos(x);
  } else {
   return (double) StrictMath.cos(x);
  }
 }

 /**
  *
  * @param x
  * @return
  */
 public static double tan(double x) {
  if (!USE_STRICT_MATH) {
   return (double) Math.tan(x);
  } else {
   return (double) StrictMath.tan(x);
  }
 }

 /**
  *
  * @param x
  * @return
  */
 public static double atan(double x) {
  if (!USE_STRICT_MATH) {
   return (double) Math.atan(x);
  } else {
   return (double) StrictMath.atan(x);
  }
 }

 /**
  *
  * @param x
  * @param y
  * @return
  */
 public static double atan2(double x, double y) {
  if (!USE_STRICT_MATH) {
   return (double) Math.atan2(x, y);
  } else {
   return (double) StrictMath.atan2(x, y);
  }
 }

 /**
  *
  * @param x
  * @return
  */
 public static double sqrt(double x) {
  if (!USE_STRICT_MATH) {
   return (double) Math.sqrt(x);
  } else {
   return (double) StrictMath.sqrt(x);
  }
 }

 /**
  *
  * @param x
  * @return
  */
 public static double acos(double x) {
  if (!USE_STRICT_MATH) {
   return (double) Math.acos(x);
  } else {
   return (double) StrictMath.acos(x);
  }
 }

 public static float pow(float x, float y) {
  if (!USE_STRICT_MATH) {
   return (float) Math.pow(x, y);
  } else {
   return (float) StrictMath.pow(x, y);
  }
 }

 public static double pow(double x, double y) {
  if (!USE_STRICT_MATH) {
   return (double) Math.pow(x, y);
  } else {
   return (double) StrictMath.pow(x, y);
  }
 }

 public static boolean different_epsilon(float a, float b, float epsilon) {
  float diff = a - b;
  if (Float.isNaN(diff)) {
   return false;
  }
  return Math.abs(diff) > epsilon;
 }

 public static boolean is_good_matrix(Matrix4f m) {
  if (Math.abs(m.determinant()) < 0.001f) {
   return false;
  }
  for (int r = 0; r < 4; ++r) {
   for (int c = 0; c < 4; ++c) {
    if (!Float.isFinite(m.getElement(r, c))) {
     return false;
    }
   }
  }
  return true;
 }

 public static boolean is_good_matrix(Matrix3f m) {
  if (Math.abs(m.determinant()) < 0.00001f) {
   return false;
  }
  for (int r = 0; r < 3; ++r) {
   for (int c = 0; c < 3; ++c) {
    if (!Float.isFinite(m.getElement(r, c))) {
     return false;
    }
   }
  }
  return true;
 }

 public static boolean zero_denormals(Matrix4f m, float epsilon) {
  boolean zeroed = false;
  for (int r = 0; r < 4; ++r) {
   for (int c = 0; c < 4; ++c) {
    float e = Math.abs(m.getElement(r, c));
    if (e > 0 && e < epsilon) {
     m.setElement(r, c, 0);
     zeroed = true;
    }
   }
  }
  return zeroed;
 }

 public static boolean zero_denormals(Matrix3f m, float epsilon) {
  boolean zeroed = false;
  for (int r = 0; r < 3; ++r) {
   for (int c = 0; c < 3; ++c) {
    float e = Math.abs(m.getElement(r, c));
    if (e > 0 && e < epsilon) {
     m.setElement(r, c, 0);
     zeroed = true;
    }
   }
  }
  return zeroed;
 }

 public static boolean zero_denormals(Tuple3f m, float epsilon) {
  boolean zeroed = false;
  for (int r = 0; r < 3; ++r) {
   float e = Math.abs(m.getElement(r));
   if (e > 0 && e < epsilon) {
    m.setElement(r, 0);
    zeroed = true;
   }
  }
  return zeroed;
 }

 public static boolean zero_denormals(Tuple4f m, float epsilon) {
  boolean zeroed = false;
  for (int r = 0; r < 4; ++r) {
   float e = Math.abs(m.getElement(r));
   if (e > 0 && e < epsilon) {
    m.setElement(r, 0);
    zeroed = true;
   }
  }
  return zeroed;
 }

 public static boolean epsilon_equals(float a, float b, float epsilon) {
  float diff = Math.abs(a - b);
  return diff <= epsilon;
 }
}
