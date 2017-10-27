/*
 * generated by Xtext 2.12.0
 */
package org.tetrabox.minijava.xtext.validation

import org.eclipse.xtext.validation.Check
import org.tetrabox.minijava.xtext.miniJava.Cast
import org.tetrabox.minijava.xtext.miniJava.Class
import org.tetrabox.minijava.xtext.miniJava.Field
import org.tetrabox.minijava.xtext.miniJava.Method
import org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage
import org.tetrabox.minijava.xtext.miniJava.New
import org.tetrabox.minijava.xtext.miniJava.Selection
import org.tetrabox.minijava.xtext.typing.MiniJavaTypeChecker

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class MiniJavaValidator extends AbstractMiniJavaValidator {

	MiniJavaTypeChecker typeChecker = new MiniJavaTypeChecker();

	public static final String INVALID_CLASS_NAME = "org.eclipse.xtext.fj.InvalidTypeName";

	@Check
	def public void checkClassNameStartsWithCapital(Class type) {
		if (!Character.isUpperCase(type.getName().charAt(0))) {
			warning("Class name should start with a capital", MiniJavaPackage.Literals.CLASS__NAME, INVALID_CLASS_NAME,
				type.getName());
		}
	}

	/**
	 * Checks that there are no cycles in the hierarchy. In the editor the error
	 * will show up only in cases 'class A extends A', while for recursive cases
	 * the linker itself will report errors since it cannot locate a class
	 * uniquely.
	 * 
	 * @param type
	 */
	@Check
	def public void checkAcyclicHierarchy(Class type) {
		val String errors = typeChecker.typeCheck(type);

		if (errors.length() > 0) {
			error("Cycle in the class hierarchy", MiniJavaPackage.Literals.CLASS__NAME);
			return;
		}
	}

	public static val String DUPLICATE_CLASS_NAMES = "org.eclipse.xtext.fj.DuplicateClassNames";

	/**
	 * Checks that there are no duplicate classes (classes with the same name)
	 * in a program uniquely.
	 * 
	 * @param type
	 */
	@Check
	def public void checkNoDuplicateClasses(Class type) {
		val String errors = typeChecker.typeCheck(type.eContainer());

		if (errors.length() > 0 && errors.contains("class " + type.getName() + " is already")) {
			error(errors, MiniJavaPackage.Literals.CLASS__NAME, DUPLICATE_CLASS_NAMES, type.getName());
			return;
		}
	}

	/**
	 * Checks that there are no duplicate fields in a class hierarchy
	 * 
	 * @param type
	 */
	@Check
	def public void checkField(Field field) {
		val String errors = typeChecker.typeCheck(field);

		if (errors.length() > 0) {
			error(errors, MiniJavaPackage.Literals.TYPED_ELEMENT__NAME);
			return;
		}
	}

	/**
	 * Checks the body of the method (if the body is consistent with its
	 * signature)
	 * 
	 * @param method
	 */
	@Check
	def public void checkMethodOk(Method method) {
		val String errors = typeChecker.typeCheck(method);

		if (errors !== null && errors.length() > 0) {
			error(errors, MiniJavaPackage.Literals.METHOD__BODY);
			return;
		}
	}

	/**
	 * Checks whether a method selection is correct
	 * 
	 * @param method
	 */
	@Check
	def public void checkMethodSelection(Selection selection) {
		val String errors = typeChecker.typeCheck(selection);

		if (errors !== null && errors.length() > 0) {
			error(errors, MiniJavaPackage.Literals.METHOD_CALL__ARGS);
			return;
		}
	}

	/**
	 * Checks that a new expression has the correct arguments (one for each of
	 * the fields in the hierarchy)
	 * 
	 * @param n
	 */
	@Check
	def public void checkNew(New n) {
		val String errors = typeChecker.typeCheck(n);

		if (errors !== null && errors.length() > 0) {
			error(errors, MiniJavaPackage.Literals.NEW__ARGS);
			return;
		}
	}

	/**
	 * Checks that type cast and the object to cast have no unrelated types.
	 * 
	 * @param n
	 */
	@Check
	def public void checkCast(Cast cast) {
		val String errors = typeChecker.typeCheck(cast);

		if (errors !== null && errors.length() > 0) {
			error(errors, MiniJavaPackage.Literals.CAST__TYPE);
			return;
		}
	}

/*
 * It's useless since now this is a keyword
 * 
 * @Check public void checkFieldNameDifferentFromThis(Field field) { if
 * (field.getName().equals("this")) {
 * error("Field name must be different from 'this'", FJPackage.FIELD__NAME);
 * } }
 */
}
