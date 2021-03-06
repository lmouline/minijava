/**
 *
 * $Id$
 */
package org.tetrabox.minijava.xminijava.miniJava.validation;

import org.eclipse.emf.common.util.EList;

import org.tetrabox.minijava.xminijava.miniJava.Context;
import org.tetrabox.minijava.xminijava.miniJava.SymbolBinding;

/**
 * A sample validator interface for {@link org.tetrabox.minijava.xminijava.miniJava.Context}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ContextValidator {
	boolean validate();

	boolean validateBindings(EList<SymbolBinding> value);
	boolean validateParentContext(Context value);
	boolean validateChildContext(Context value);
}
