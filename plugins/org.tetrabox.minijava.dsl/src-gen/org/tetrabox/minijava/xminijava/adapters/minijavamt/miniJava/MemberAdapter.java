package org.tetrabox.minijava.xminijava.adapters.minijavamt.miniJava;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import org.eclipse.emf.ecore.EClass;
import org.tetrabox.minijava.xminijava.adapters.minijavamt.MiniJavaMTAdaptersFactory;
import org.tetrabox.minijava.xminijava.miniJava.Member;
import org.tetrabox.minijava.xtext.miniJava.AccessLevel;
import org.tetrabox.minijava.xtext.miniJava.TypeRef;

@SuppressWarnings("all")
public class MemberAdapter extends EObjectAdapter<Member> implements org.tetrabox.minijava.xtext.miniJava.Member {
  private MiniJavaMTAdaptersFactory adaptersFactory;
  
  public MemberAdapter() {
    super(org.tetrabox.minijava.xminijava.adapters.minijavamt.MiniJavaMTAdaptersFactory.getInstance());
    adaptersFactory = org.tetrabox.minijava.xminijava.adapters.minijavamt.MiniJavaMTAdaptersFactory.getInstance();
  }
  
  @Override
  public String getName() {
    return adaptee.getName();
  }
  
  @Override
  public void setName(final String o) {
    adaptee.setName(o);
  }
  
  @Override
  public AccessLevel getAccess() {
    return org.tetrabox.minijava.xtext.miniJava.AccessLevel.get(adaptee.getAccess().getValue());
  }
  
  @Override
  public void setAccess(final AccessLevel o) {
    adaptee.setAccess(org.tetrabox.minijava.xminijava.miniJava.AccessLevel.get(o.getValue()));
  }
  
  @Override
  public TypeRef getTypeRef() {
    return (TypeRef) adaptersFactory.createAdapter(adaptee.getTypeRef(), eResource);
  }
  
  @Override
  public void setTypeRef(final TypeRef o) {
    if (o != null)
    	adaptee.setTypeRef(((org.tetrabox.minijava.xminijava.adapters.minijavamt.miniJava.TypeRefAdapter) o).getAdaptee());
    else adaptee.setTypeRef(null);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static AccessLevel ACCESS_EDEFAULT = org.tetrabox.minijava.xtext.miniJava.AccessLevel.PRIVATE;
  
  @Override
  public EClass eClass() {
    return org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage.eINSTANCE.getMember();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage.MEMBER__NAME:
    		return getName();
    	case org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage.MEMBER__TYPE_REF:
    		return getTypeRef();
    	case org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage.MEMBER__ACCESS:
    		return getAccess();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage.MEMBER__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage.MEMBER__TYPE_REF:
    		return getTypeRef() != null;
    	case org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage.MEMBER__ACCESS:
    		return getAccess() != ACCESS_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage.MEMBER__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage.MEMBER__TYPE_REF:
    		setTypeRef(
    		(org.tetrabox.minijava.xtext.miniJava.TypeRef)
    		 newValue);
    		return;
    	case org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage.MEMBER__ACCESS:
    		setAccess(
    		(org.tetrabox.minijava.xtext.miniJava.AccessLevel)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
