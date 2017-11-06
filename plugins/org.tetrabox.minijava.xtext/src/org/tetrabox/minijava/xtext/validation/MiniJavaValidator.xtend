/*
 * generated by Xtext 2.10.0
 */
package org.tetrabox.minijava.xtext.validation

import com.google.common.collect.HashMultimap
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType
import org.tetrabox.minijava.xtext.MiniJavaModelUtil
import org.tetrabox.minijava.xtext.miniJava.Block
import org.tetrabox.minijava.xtext.miniJava.Class
import org.tetrabox.minijava.xtext.miniJava.Expression
import org.tetrabox.minijava.xtext.miniJava.FieldAccess
import org.tetrabox.minijava.xtext.miniJava.Method
import org.tetrabox.minijava.xtext.miniJava.MethodCall
import org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage
import org.tetrabox.minijava.xtext.miniJava.NamedElement
import org.tetrabox.minijava.xtext.miniJava.Program
import org.tetrabox.minijava.xtext.miniJava.Return
import org.tetrabox.minijava.xtext.miniJava.Super
import org.tetrabox.minijava.xtext.miniJava.VariableDeclaration
import org.tetrabox.minijava.xtext.scoping.MiniJavaIndex
import org.tetrabox.minijava.xtext.typing.MiniJavaTypeComputer
import org.tetrabox.minijava.xtext.typing.MiniJavaTypeConformance

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class MiniJavaValidator extends AbstractMiniJavaValidator {

	protected static val ISSUE_CODE_PREFIX = "org.tetrabox.minijava.xtext."
	public static val HIERARCHY_CYCLE = ISSUE_CODE_PREFIX + "HierarchyCycle"
	public static val FIELD_SELECTION_ON_METHOD = ISSUE_CODE_PREFIX + "FieldSelectionOnMethod"
	public static val METHOD_INVOCATION_ON_FIELD = ISSUE_CODE_PREFIX + "MethodInvocationOnField"
	public static val UNREACHABLE_CODE = ISSUE_CODE_PREFIX + "UnreachableCode"
	public static val MISSING_FINAL_RETURN = ISSUE_CODE_PREFIX + "MissingFinalReturn"
	public static val EXTRA_FINAL_RETURN = ISSUE_CODE_PREFIX + "ExtraFinalReturn"
	public static val DUPLICATE_ELEMENT = ISSUE_CODE_PREFIX + "DuplicateElement"
	public static val INCOMPATIBLE_TYPES = ISSUE_CODE_PREFIX + "IncompatibleTypes"
	public static val INVALID_ARGS = ISSUE_CODE_PREFIX + "InvalidArgs"
	public static val WRONG_METHOD_OVERRIDE = ISSUE_CODE_PREFIX + "WrongMethodOverride"
	public static val MEMBER_NOT_ACCESSIBLE = ISSUE_CODE_PREFIX + "MemberNotAccessible"
	public static val DUPLICATE_CLASS = ISSUE_CODE_PREFIX + "DuplicateClass"
	public static val WRONG_SUPER_USAGE = ISSUE_CODE_PREFIX + "WrongSuperUsage"
	public static val REDUCED_ACCESSIBILITY = ISSUE_CODE_PREFIX + "ReducedAccessibility"
	public static val ABSTRACT_METHOD_BODY = ISSUE_CODE_PREFIX + "AbstractMethodBody"
	public static val ABSTRACT_METHOD_CLASS = ISSUE_CODE_PREFIX + "AbstractMethodClass"

	@Inject extension MiniJavaModelUtil
	@Inject extension MiniJavaTypeComputer
	@Inject extension MiniJavaTypeConformance
	@Inject extension MiniJavaAccessibility
	@Inject extension MiniJavaIndex
	@Inject extension IQualifiedNameProvider

	@Check
	def checkClassHierarchy(Class c) {
		if (c.classHierarchy.contains(c)) {
			error("cycle in hierarchy of class '" + c.name + "'", MiniJavaPackage.eINSTANCE.class_Superclass,
				HIERARCHY_CYCLE, c.superclass.name)
		}
	}

	@Check
	def void checkUnreachableCode(Block block) {
		val statements = block.statements
		for (var i = 0; i < statements.length - 1; i++) {
			if (statements.get(i) instanceof Return) {
				// put the error on the statement after the return
				error("Unreachable code", statements.get(i + 1), null, // EStructuralFeature
				UNREACHABLE_CODE)
				return // no need to report further errors
			}
		}
	}

	@Check
	def void checkReturn(Method method) {
		if (method.typeRef.eClass !== MiniJavaPackage::eINSTANCE.voidTypeRef) {
			if (method.returnStatement === null) {
				error(
					"Method must end with a return statement",
					MiniJavaPackage.eINSTANCE.method_Body,
					MISSING_FINAL_RETURN
				)
			}
		} else {
			if (method.returnStatement !== null) {
				error(
					"Void method must not end with a return statement",
					MiniJavaPackage.eINSTANCE.method_Body,
					EXTRA_FINAL_RETURN
				)
			}
		}
	}

	@Check def void checkNoDuplicateClasses(Program p) {
		checkNoDuplicateElements(p.classes, "class")
	}

	@Check def void checkNoDuplicateMembers(Class c) {
		checkNoDuplicateElements(c.fields, "field")
		checkNoDuplicateElements(c.methods, "method")
	}

	@Check def void checkNoDuplicateSymbols(Method m) {
		checkNoDuplicateElements(m.params, "parameter")
		checkNoDuplicateElements(m.body.getAllContentsOfType(VariableDeclaration), "variable")
	}

	@Check def void checkConformance(Expression exp) {
		val actualType = exp.typeFor
		val expectedType = exp.expectedType
		if (expectedType === null || actualType === null)
			return; // nothing to check
		if (!actualType.isConformant(expectedType)) {
			error("Incompatible types. Expected '" + expectedType.name + "' but was '" + actualType.name + "'", null,
				INCOMPATIBLE_TYPES);
		}
	}

	@Check def void checkMethodInvocationArguments(MethodCall sel) {
		val method = sel.member
		if (method instanceof Method) {
			if (method.params.size != sel.args.size) {
				error("Invalid number of arguments: expected " + method.params.size + " but was " + sel.args.size,
					MiniJavaPackage.eINSTANCE.methodCall_Member, INVALID_ARGS)
			}
		}
	}

	@Check def void checkMethodOverride(Class c) {
		val hierarchyMethods = c.classHierarchyMethods

		for (m : c.methods) {
			val overridden = hierarchyMethods.get(m.name)
			if (overridden !== null && (!m.typeRef.type.isConformant(overridden.typeRef.type) ||
				!m.params.map[typeRef].map[type].elementsEqual(overridden.params.map[typeRef].map[type]))) {
				error("The method '" + m.name + "' must override a superclass method", m,
					MiniJavaPackage.eINSTANCE.namedElement_Name, WRONG_METHOD_OVERRIDE)
			} else if (m.access < overridden.access) {
				error("Cannot reduce access from " + overridden.access + " to " + m.access, m,
					MiniJavaPackage.eINSTANCE.member_Access, REDUCED_ACCESSIBILITY)
			}
		}
	}
	
	@Check
	def void checkMethodAbstract(Method method) {
		if (method.abstract && method.body !== null) {
			error('''The abstract method «method.name» cannot have a body.''', method,
					MiniJavaPackage.eINSTANCE.method_Body, ABSTRACT_METHOD_BODY)
		}
		
		if (method.abstract && !(method.eContainer as Class).abstract) {
			error('''The abstract method «method.name» must be contained in an abstract class.''', method,
					MiniJavaPackage.eINSTANCE.method_Abstract, ABSTRACT_METHOD_CLASS)
		}
	}
	

	@Check def void checkAccessibility(FieldAccess sel) {
		val member = sel.member
		if (member.name !== null && !member.isAccessibleFrom(sel))
			error(
				'''The «member.access» member «member.name» is not accessible here''',
				MiniJavaPackage.eINSTANCE.fieldAccess_Member,
				MEMBER_NOT_ACCESSIBLE
			)
	}

	@Check def void checkAccessibility(MethodCall sel) {
		val member = sel.member
		if (member.name !== null && !member.isAccessibleFrom(sel))
			error(
				'''The «member.access» member «member.name» is not accessible here''',
				MiniJavaPackage.eINSTANCE.methodCall_Member,
				MEMBER_NOT_ACCESSIBLE
			)
	}

	// perform this check only on file save
	@Check(CheckType.NORMAL)
	def checkDuplicateClassesInFiles(Program p) {
		val externalClasses = p.getVisibleExternalClassesDescriptions
		for (c : p.classes) {
			val className = c.fullyQualifiedName
			if (externalClasses.containsKey(className)) {
				error("The type " + c.name + " is already defined", c, MiniJavaPackage.eINSTANCE.namedElement_Name,
					DUPLICATE_CLASS)
			}
		}
	}

	@Check
	def void checkSuper(Super s) {
		if (s.eContainingFeature != MiniJavaPackage.eINSTANCE.methodCall_Receiver &&
			s.eContainingFeature != MiniJavaPackage.eINSTANCE.fieldAccess_Receiver)
			error("'super' can be used only as member selection receiver", null, WRONG_SUPER_USAGE)
	}
	
	
	def private void checkNoDuplicateElements(Iterable<? extends NamedElement> elements, String desc) {
		val multiMap = HashMultimap.create()

		for (e : elements)
			multiMap.put(e.name, e)

		for (entry : multiMap.asMap.entrySet) {
			val duplicates = entry.value
			if (duplicates.size > 1) {
				for (d : duplicates)
					error("Duplicate " + desc + " '" + d.name + "'", d, MiniJavaPackage.eINSTANCE.namedElement_Name,
						DUPLICATE_ELEMENT)
			}
		}
	}
}
