/*
 * generated by Xtext 2.12.0
 */
package org.tetrabox.minijava.xtext.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators = {MiniJavaValidator.class})
public abstract class AbstractMiniJavaValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage.eINSTANCE);
		return result;
	}
	
}