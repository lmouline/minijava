/**
 * generated by Xtext 2.12.0
 */
package org.tetrabox.minijava.xtext.miniJava.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.tetrabox.minijava.xtext.miniJava.Interface;
import org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.tetrabox.minijava.xtext.miniJava.impl.ClassImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.tetrabox.minijava.xtext.miniJava.impl.ClassImpl#getSuperclass <em>Superclass</em>}</li>
 *   <li>{@link org.tetrabox.minijava.xtext.miniJava.impl.ClassImpl#getImplements <em>Implements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl extends TypeDeclarationImpl implements org.tetrabox.minijava.xtext.miniJava.Class
{
  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

  /**
   * The cached value of the '{@link #getSuperclass() <em>Superclass</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperclass()
   * @generated
   * @ordered
   */
  protected org.tetrabox.minijava.xtext.miniJava.Class superclass;

  /**
   * The cached value of the '{@link #getImplements() <em>Implements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplements()
   * @generated
   * @ordered
   */
  protected EList<Interface> implements_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MiniJavaPackage.Literals.CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAbstract()
  {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbstract(boolean newAbstract)
  {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CLASS__ABSTRACT, oldAbstract, abstract_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.tetrabox.minijava.xtext.miniJava.Class getSuperclass()
  {
    if (superclass != null && superclass.eIsProxy())
    {
      InternalEObject oldSuperclass = (InternalEObject)superclass;
      superclass = (org.tetrabox.minijava.xtext.miniJava.Class)eResolveProxy(oldSuperclass);
      if (superclass != oldSuperclass)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.CLASS__SUPERCLASS, oldSuperclass, superclass));
      }
    }
    return superclass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.tetrabox.minijava.xtext.miniJava.Class basicGetSuperclass()
  {
    return superclass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuperclass(org.tetrabox.minijava.xtext.miniJava.Class newSuperclass)
  {
    org.tetrabox.minijava.xtext.miniJava.Class oldSuperclass = superclass;
    superclass = newSuperclass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CLASS__SUPERCLASS, oldSuperclass, superclass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Interface> getImplements()
  {
    if (implements_ == null)
    {
      implements_ = new EObjectResolvingEList<Interface>(Interface.class, this, MiniJavaPackage.CLASS__IMPLEMENTS);
    }
    return implements_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MiniJavaPackage.CLASS__ABSTRACT:
        return isAbstract();
      case MiniJavaPackage.CLASS__SUPERCLASS:
        if (resolve) return getSuperclass();
        return basicGetSuperclass();
      case MiniJavaPackage.CLASS__IMPLEMENTS:
        return getImplements();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MiniJavaPackage.CLASS__ABSTRACT:
        setAbstract((Boolean)newValue);
        return;
      case MiniJavaPackage.CLASS__SUPERCLASS:
        setSuperclass((org.tetrabox.minijava.xtext.miniJava.Class)newValue);
        return;
      case MiniJavaPackage.CLASS__IMPLEMENTS:
        getImplements().clear();
        getImplements().addAll((Collection<? extends Interface>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MiniJavaPackage.CLASS__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case MiniJavaPackage.CLASS__SUPERCLASS:
        setSuperclass((org.tetrabox.minijava.xtext.miniJava.Class)null);
        return;
      case MiniJavaPackage.CLASS__IMPLEMENTS:
        getImplements().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MiniJavaPackage.CLASS__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case MiniJavaPackage.CLASS__SUPERCLASS:
        return superclass != null;
      case MiniJavaPackage.CLASS__IMPLEMENTS:
        return implements_ != null && !implements_.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (abstract: ");
    result.append(abstract_);
    result.append(')');
    return result.toString();
  }

} //ClassImpl
