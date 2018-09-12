/**
 *
 * $Id$
 */
package org.tetrabox.minijava.xminijava.miniJava.validation;

import org.eclipse.emf.common.util.EList;

import org.tetrabox.minijava.xminijava.miniJava.ArrayInstance;
import org.tetrabox.minijava.xminijava.miniJava.Frame;
import org.tetrabox.minijava.xminijava.miniJava.ObjectInstance;
import org.tetrabox.minijava.xminijava.miniJava.OutputStream;

/**
 * A sample validator interface for {@link org.tetrabox.minijava.xminijava.miniJava.State}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface StateValidator {
	boolean validate();

	boolean validateRootFrame(Frame value);
	boolean validateObjectsHeap(EList<ObjectInstance> value);
	boolean validateOutputStream(OutputStream value);
	boolean validateArraysHeap(EList<ArrayInstance> value);
}
