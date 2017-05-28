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

/**
 *
 * @author Gregery Barton
 */
abstract public class IntSmartPointer<T> {
  final T object;

 public IntSmartPointer(T object) {
  this.object = object;
 }

 public IntSmartPointer(FloatSmartPointer<T> copy) {
  object = copy.object;
 }

 public abstract int get();

 public abstract void set(int value);

 public final int plusEquals(int a) {
  set(get() + a);
  return get();
 }

 public final int timesEquals(int a) {
  set(get() * a);
  return get();
 }

 public final T object() {
  return (T) object;
 }
}
