/*******************************************************************************
 * Copyright (c) 2014 Martin Weber.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Martin Weber - Initial implementation
 *******************************************************************************/
package de.marw.cdt.cmake.core.internal.storage;

import org.eclipse.cdt.core.settings.model.ICStorageElement;

import de.marw.cdt.cmake.core.settings.CmakeUnDefine;

/**
 * Responsible for serialization/de-serialization of CmakeUndefine objects.
 *
 * @author Martin Weber
 */
public class CmakeUndefineSerializer implements
    StorageSerializer<CmakeUnDefine> {
  /**  */
  private static final String ELEM_UNDEFINE = "undef";
  /**  */
  private static final String ATTR_NAME = "name";

  public void toStorage(ICStorageElement parent, CmakeUnDefine item) {
    ICStorageElement elem = parent.createChild(ELEM_UNDEFINE);
    elem.setAttribute(ATTR_NAME, item.getName());
  }

  /*-
   * @see de.marw.cdt.cmake.core.internal.storage.StorageSerializer#fromStorage(org.eclipse.cdt.core.settings.model.ICStorageElement)
   */
  @Override
  public CmakeUnDefine fromStorage(ICStorageElement item) {
    if (!ELEM_UNDEFINE.equals(item.getName()))
      return null; // item is not an element representing a cmake undefine
    String nameVal = item.getAttribute(ATTR_NAME);
    if (nameVal != null) {
      return new CmakeUnDefine(nameVal);
    }
    return null;
  }
}