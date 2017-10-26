/**
 * generated by Xtext 2.12.0
 */
package org.tetrabox.miniJava;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domainmodel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.tetrabox.miniJava.Domainmodel#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.tetrabox.miniJava.MiniJavaPackage#getDomainmodel()
 * @model
 * @generated
 */
public interface Domainmodel extends EObject
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.tetrabox.miniJava.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.tetrabox.miniJava.MiniJavaPackage#getDomainmodel_Elements()
   * @model containment="true"
   * @generated
   */
  EList<Type> getElements();

} // Domainmodel
