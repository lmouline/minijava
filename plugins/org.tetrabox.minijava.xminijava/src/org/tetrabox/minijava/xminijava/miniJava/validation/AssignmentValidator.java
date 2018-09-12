/**
 *
 * $Id$
 */
package org.tetrabox.minijava.xminijava.miniJava.validation;

import org.tetrabox.minijava.xminijava.miniJava.Assignee;
import org.tetrabox.minijava.xminijava.miniJava.Expression;

/**
 * A sample validator interface for {@link org.tetrabox.minijava.xminijava.miniJava.Assignment}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface AssignmentValidator {
	boolean validate();

	boolean validateAssignee(Assignee value);
	boolean validateValue(Expression value);
}
