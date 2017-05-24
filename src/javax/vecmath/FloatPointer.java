/*
  * Copyright (c) 2017  Gregery Barton
  * 
  * This software is provided 'as-is', without any express or implied warranty.
 * In no event will the authors be held liable for any damages arising from the use of this software.
 * Permission is granted to anyone to use this software for any purpose, 
 * including commercial applications, and to alter it and redistribute it freely, 
 * subject to the following restrictions:
 * 
 * 1. The origin of this software must not be misrepresented; you must not claim that you wrote the original software. If you use this software in a product, an acknowledgment in the product documentation would be appreciated but is not required.
 * 2. Altered source versions must be plainly marked as such, and must not be misrepresented as being the original software.
 * 3. This notice may not be removed or altered from any source distribution.
 */
package javax.vecmath;

import java.io.Serializable;

/**
 * Points to an element within an array. Use to emulate pointer arithmetic.
 *
 * @author Gregery Barton
 */
public class FloatPointer  implements Serializable{

 final private float[] array;
 final private int offset;

 /**
  * Construct a FloatPointer object that points to the value in the specified array at the specified
  * index
  *
  * @param array
  * @param index
  */
 public FloatPointer(float[] array, int index) {
  this.array = array;
  this.offset = index;
 }

 public FloatPointer(float[] array) {
  this.array = array;
  offset = 0;
 }

 /**
  * Construct a FloatPointer object from another FloatPointer object with a shifted base index
  *
  * @param base pointer to a value
  * @param delta shift the location the new object points to by delta indices relative to base
  * pointer
  */
 public FloatPointer(FloatPointer base, int delta) {
  array = base.array;
  offset = base.offset + delta;
 }

 /**
  * Construct a FloatPointer object by copying another FloatPointer object
  *
  * @param base pointer to a value
  */
 public FloatPointer(FloatPointer base) {
  array = base.array;
  offset = base.offset;
 }

 /**
  * Dereference this pointer to get a single value
  *
  * @return the value at the location this pointer points to
  */
 public float get() {
  return array[offset];
 }

 /**
  * Adjust the pointer by an offset and dereference to get a single value.
  *
  * @param delta the amount to move the pointer before dereferencing
  * @return the dereferenced value
  */
 public float get(int delta) {
  return array[offset + delta];
 }

 /**
  * Write a single value to the location that this pointer points to
  *
  * @param value the new value to write.
  */
 public void set(float value) {
  array[offset] = value;
 }

 /**
  * Write a single value to a location that is offset from the base location
  *
  * @param delta the amount to move the pointer by before writing the value
  * @param value the value to write
  */
 public void set(int delta, float value) {
  array[offset + delta] = value;
 }

 /**
  * Copy values from the pointed to location into an array.
  *
  * @param dest the array to copy values to, the number of values written will be the length of the
  * array.
  * @param length the number of values to copy. Will throw System.arraycopy exceptions if the length
  * is too long for the source or destination.
  */
 public void read(float[] dest, int length) {
  System.arraycopy(array, offset, dest, 0, length);
 }

 /**
  * Write an array of values starting at this pointer with each element at a higher address
  *
  * @param values the values to write, all values from index 0 to length-1 will be written.
  */
 public void write(float[] values) {
  System.arraycopy(values, 0, array, offset, values.length);
 }

 /**
  * Copy values from the location pointed to by a source pointer to the location pointed to by this
  * pointer.
  *
  * @param source The pointer to read values from
  * @param length the number of values to read.
  */
 public void copy(FloatPointer source, int length) {
  System.arraycopy(source.array, source.offset, array, offset, length);
 }

 /**
  * Determine if this pointer object points to the start of the specified array.
  *
  * @param array the array to compare with
  * @return true if the base location is at the start of the array, otherwise false
  */
 public boolean is_pointing_to(float[] array) {
  return (this.array == array) && (offset == 0);
 }

 /**
  * Determine if this pointer object points to any element of the specified array.
  *
  * @param array the array to hit test
  * @return true if this pointer points to any element of the array. Returns false if this pointer
  * references the array but has an invalid offset. Returns false if the array is not being pointed
  * to at all.
  */
 public boolean is_pointing_into(float[] array) {
  return (this.array == array) && (offset >= 0) && (offset < array.length);
 }
}
