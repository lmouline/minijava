/**
 *
 * $Id$
 */
package org.tetrabox.minijava.xminijava.miniJava.validation;

import org.tetrabox.minijava.xminijava.miniJava.Symbol;
import org.tetrabox.minijava.xminijava.miniJava.Value;

/**
 * A sample validator interface for {@link org.tetrabox.minijava.xminijava.miniJava.SymbolBinding}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SymbolBindingValidator {
	boolean validate();

	boolean validateValue(Value value);
	boolean validateSymbol(Symbol value);
}
