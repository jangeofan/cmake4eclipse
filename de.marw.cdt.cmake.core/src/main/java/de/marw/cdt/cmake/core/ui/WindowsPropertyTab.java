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
package de.marw.cdt.cmake.core.ui;

import java.util.EnumSet;

import de.marw.cdt.cmake.core.settings.CMakePreferences;
import de.marw.cdt.cmake.core.settings.CmakeGenerator;
import de.marw.cdt.cmake.core.settings.WindowsPreferences;

/**
 * UI to control host Windows specific project properties and preferences for
 * cmake. This tab is responsible for storing its values.
 *
 * @author Martin Weber
 */
public class WindowsPropertyTab extends
    AbstractOsPropertyTab<WindowsPreferences> {

  private static final EnumSet<CmakeGenerator> generators = EnumSet.of(
      CmakeGenerator.MinGWMakefiles, CmakeGenerator.MSYSMakefiles,
      CmakeGenerator.UnixMakefiles, CmakeGenerator.Ninja,
      CmakeGenerator.NMakeMakefiles, CmakeGenerator.NMakeMakefilesJOM,
      CmakeGenerator.BorlandMakefiles, CmakeGenerator.WatcomWMake);

  /*-
   * @see de.marw.cdt.cmake.core.ui.AbstractOsPropertyTab#getOsPreferences(de.marw.cdt.cmake.core.internal.CMakePreferences)
   */
  @Override
  protected WindowsPreferences getOsPreferences(CMakePreferences prefs) {
    return prefs.getWindowsPreferences();
  }

  @Override
  protected EnumSet<CmakeGenerator> getAvailableGenerators() {
    return WindowsPropertyTab.generators;
  }

}
