/*
 * generated by Xtext 2.12.0
 */
package org.tetrabox.minijava.xtext.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.tetrabox.minijava.xtext.miniJava.BasicType;
import org.tetrabox.minijava.xtext.miniJava.BoolConstant;
import org.tetrabox.minijava.xtext.miniJava.Cast;
import org.tetrabox.minijava.xtext.miniJava.ClassType;
import org.tetrabox.minijava.xtext.miniJava.Field;
import org.tetrabox.minijava.xtext.miniJava.FieldSelection;
import org.tetrabox.minijava.xtext.miniJava.IntConstant;
import org.tetrabox.minijava.xtext.miniJava.Method;
import org.tetrabox.minijava.xtext.miniJava.MethodBody;
import org.tetrabox.minijava.xtext.miniJava.MethodCall;
import org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage;
import org.tetrabox.minijava.xtext.miniJava.New;
import org.tetrabox.minijava.xtext.miniJava.Program;
import org.tetrabox.minijava.xtext.miniJava.Selection;
import org.tetrabox.minijava.xtext.miniJava.StringConstant;
import org.tetrabox.minijava.xtext.miniJava.This;
import org.tetrabox.minijava.xtext.miniJava.Variable;
import org.tetrabox.minijava.xtext.services.MiniJavaGrammarAccess;

@SuppressWarnings("all")
public class MiniJavaSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MiniJavaGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == MiniJavaPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MiniJavaPackage.BASIC_TYPE:
				sequence_BasicType(context, (BasicType) semanticObject); 
				return; 
			case MiniJavaPackage.BOOL_CONSTANT:
				sequence_BoolConstant(context, (BoolConstant) semanticObject); 
				return; 
			case MiniJavaPackage.CAST:
				sequence_Cast(context, (Cast) semanticObject); 
				return; 
			case MiniJavaPackage.CLASS:
				sequence_Class(context, (org.tetrabox.minijava.xtext.miniJava.Class) semanticObject); 
				return; 
			case MiniJavaPackage.CLASS_TYPE:
				sequence_ClassType(context, (ClassType) semanticObject); 
				return; 
			case MiniJavaPackage.FIELD:
				sequence_Field(context, (Field) semanticObject); 
				return; 
			case MiniJavaPackage.FIELD_SELECTION:
				sequence_FieldSelection(context, (FieldSelection) semanticObject); 
				return; 
			case MiniJavaPackage.INT_CONSTANT:
				sequence_IntConstant(context, (IntConstant) semanticObject); 
				return; 
			case MiniJavaPackage.METHOD:
				sequence_Method(context, (Method) semanticObject); 
				return; 
			case MiniJavaPackage.METHOD_BODY:
				sequence_MethodBody(context, (MethodBody) semanticObject); 
				return; 
			case MiniJavaPackage.METHOD_CALL:
				sequence_MethodCall(context, (MethodCall) semanticObject); 
				return; 
			case MiniJavaPackage.NEW:
				sequence_New(context, (New) semanticObject); 
				return; 
			case MiniJavaPackage.PARAMETER:
				sequence_Parameter(context, (org.tetrabox.minijava.xtext.miniJava.Parameter) semanticObject); 
				return; 
			case MiniJavaPackage.PROGRAM:
				sequence_Program(context, (Program) semanticObject); 
				return; 
			case MiniJavaPackage.SELECTION:
				sequence_Expression(context, (Selection) semanticObject); 
				return; 
			case MiniJavaPackage.STRING_CONSTANT:
				sequence_StringConstant(context, (StringConstant) semanticObject); 
				return; 
			case MiniJavaPackage.THIS:
				sequence_This(context, (This) semanticObject); 
				return; 
			case MiniJavaPackage.VARIABLE:
				sequence_Variable(context, (Variable) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Type returns BasicType
	 *     BasicType returns BasicType
	 *
	 * Constraint:
	 *     (basic='int' | basic='boolean' | basic='String')
	 */
	protected void sequence_BasicType(ISerializationContext context, BasicType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns BoolConstant
	 *     Expression.Selection_1_0 returns BoolConstant
	 *     TerminalExpression returns BoolConstant
	 *     Paren returns BoolConstant
	 *     Constant returns BoolConstant
	 *     BoolConstant returns BoolConstant
	 *     Argument returns BoolConstant
	 *
	 * Constraint:
	 *     (constant='true' | constant='false')
	 */
	protected void sequence_BoolConstant(ISerializationContext context, BoolConstant semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Cast
	 *     Expression.Selection_1_0 returns Cast
	 *     TerminalExpression returns Cast
	 *     Cast returns Cast
	 *     Paren returns Cast
	 *     Argument returns Cast
	 *
	 * Constraint:
	 *     (type=ClassType object=TerminalExpression)
	 */
	protected void sequence_Cast(ISerializationContext context, Cast semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.CAST__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.CAST__TYPE));
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.CAST__OBJECT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.CAST__OBJECT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCastAccess().getTypeClassTypeParserRuleCall_1_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getCastAccess().getObjectTerminalExpressionParserRuleCall_3_0(), semanticObject.getObject());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Type returns ClassType
	 *     ClassType returns ClassType
	 *
	 * Constraint:
	 *     classref=[Class|ID]
	 */
	protected void sequence_ClassType(ISerializationContext context, ClassType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.CLASS_TYPE__CLASSREF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.CLASS_TYPE__CLASSREF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getClassTypeAccess().getClassrefClassIDTerminalRuleCall_0_1(), semanticObject.eGet(MiniJavaPackage.Literals.CLASS_TYPE__CLASSREF, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Class returns Class
	 *
	 * Constraint:
	 *     (name=ID extends=[Class|ID]? fields+=Field* methods+=Method*)
	 */
	protected void sequence_Class(ISerializationContext context, org.tetrabox.minijava.xtext.miniJava.Class semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Selection
	 *     Expression.Selection_1_0 returns Selection
	 *     TerminalExpression returns Selection
	 *     Paren returns Selection
	 *     Argument returns Selection
	 *
	 * Constraint:
	 *     (receiver=Expression_Selection_1_0 message=Message)
	 */
	protected void sequence_Expression(ISerializationContext context, Selection semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.SELECTION__RECEIVER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.SELECTION__RECEIVER));
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.SELECTION__MESSAGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.SELECTION__MESSAGE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExpressionAccess().getSelectionReceiverAction_1_0(), semanticObject.getReceiver());
		feeder.accept(grammarAccess.getExpressionAccess().getMessageMessageParserRuleCall_1_2_0(), semanticObject.getMessage());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Message returns FieldSelection
	 *     FieldSelection returns FieldSelection
	 *
	 * Constraint:
	 *     name=[Field|ID]
	 */
	protected void sequence_FieldSelection(ISerializationContext context, FieldSelection semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.FIELD_SELECTION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.FIELD_SELECTION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFieldSelectionAccess().getNameFieldIDTerminalRuleCall_0_1(), semanticObject.eGet(MiniJavaPackage.Literals.FIELD_SELECTION__NAME, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TypedElement returns Field
	 *     Field returns Field
	 *
	 * Constraint:
	 *     (type=Type name=ID)
	 */
	protected void sequence_Field(ISerializationContext context, Field semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.TYPED_ELEMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.TYPED_ELEMENT__TYPE));
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.TYPED_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.TYPED_ELEMENT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns IntConstant
	 *     Expression.Selection_1_0 returns IntConstant
	 *     TerminalExpression returns IntConstant
	 *     Paren returns IntConstant
	 *     Constant returns IntConstant
	 *     IntConstant returns IntConstant
	 *     Argument returns IntConstant
	 *
	 * Constraint:
	 *     constant=INT
	 */
	protected void sequence_IntConstant(ISerializationContext context, IntConstant semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.INT_CONSTANT__CONSTANT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.INT_CONSTANT__CONSTANT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIntConstantAccess().getConstantINTTerminalRuleCall_0(), semanticObject.getConstant());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     MethodBody returns MethodBody
	 *
	 * Constraint:
	 *     expression=Expression
	 */
	protected void sequence_MethodBody(ISerializationContext context, MethodBody semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.METHOD_BODY__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.METHOD_BODY__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMethodBodyAccess().getExpressionExpressionParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Message returns MethodCall
	 *     MethodCall returns MethodCall
	 *
	 * Constraint:
	 *     (name=[Method|ID] (args+=Argument args+=Argument*)?)
	 */
	protected void sequence_MethodCall(ISerializationContext context, MethodCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Method returns Method
	 *
	 * Constraint:
	 *     (returntype=Type name=ID (params+=Parameter params+=Parameter*)? body=MethodBody)
	 */
	protected void sequence_Method(ISerializationContext context, Method semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns New
	 *     Expression.Selection_1_0 returns New
	 *     TerminalExpression returns New
	 *     New returns New
	 *     Paren returns New
	 *     Argument returns New
	 *
	 * Constraint:
	 *     (type=ClassType (args+=Argument args+=Argument*)?)
	 */
	protected void sequence_New(ISerializationContext context, New semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypedElement returns Parameter
	 *     Parameter returns Parameter
	 *
	 * Constraint:
	 *     (type=Type name=ID)
	 */
	protected void sequence_Parameter(ISerializationContext context, org.tetrabox.minijava.xtext.miniJava.Parameter semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.TYPED_ELEMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.TYPED_ELEMENT__TYPE));
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.TYPED_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.TYPED_ELEMENT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Program returns Program
	 *
	 * Constraint:
	 *     ((classes+=Class+ main=Expression) | main=Expression)?
	 */
	protected void sequence_Program(ISerializationContext context, Program semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns StringConstant
	 *     Expression.Selection_1_0 returns StringConstant
	 *     TerminalExpression returns StringConstant
	 *     Paren returns StringConstant
	 *     Constant returns StringConstant
	 *     StringConstant returns StringConstant
	 *     Argument returns StringConstant
	 *
	 * Constraint:
	 *     constant=STRING
	 */
	protected void sequence_StringConstant(ISerializationContext context, StringConstant semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.STRING_CONSTANT__CONSTANT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.STRING_CONSTANT__CONSTANT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStringConstantAccess().getConstantSTRINGTerminalRuleCall_0(), semanticObject.getConstant());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns This
	 *     Expression.Selection_1_0 returns This
	 *     TerminalExpression returns This
	 *     This returns This
	 *     Paren returns This
	 *     Argument returns This
	 *
	 * Constraint:
	 *     variable='this'
	 */
	protected void sequence_This(ISerializationContext context, This semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.THIS__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.THIS__VARIABLE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getThisAccess().getVariableThisKeyword_0(), semanticObject.getVariable());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Variable
	 *     Expression.Selection_1_0 returns Variable
	 *     TerminalExpression returns Variable
	 *     Variable returns Variable
	 *     Paren returns Variable
	 *     Argument returns Variable
	 *
	 * Constraint:
	 *     paramref=[Parameter|ID]
	 */
	protected void sequence_Variable(ISerializationContext context, Variable semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MiniJavaPackage.Literals.VARIABLE__PARAMREF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MiniJavaPackage.Literals.VARIABLE__PARAMREF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVariableAccess().getParamrefParameterIDTerminalRuleCall_0_1(), semanticObject.eGet(MiniJavaPackage.Literals.VARIABLE__PARAMREF, false));
		feeder.finish();
	}
	
	
}
