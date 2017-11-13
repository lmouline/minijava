package org.tetrabox.minijava.xminijava.adapters.xminijavamt.miniJava;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import org.eclipse.emf.ecore.EClass;
import org.tetrabox.minijava.xminijava.adapters.xminijavamt.XMiniJavaMTAdaptersFactory;
import org.tetrabox.minijava.xminijava.miniJava.Parameter;
import org.tetrabox.minijava.xminijavamt.miniJava.TypeRef;

@SuppressWarnings("all")
public class ParameterAdapter extends EObjectAdapter<Parameter> implements org.tetrabox.minijava.xminijavamt.miniJava.Parameter {
  private XMiniJavaMTAdaptersFactory adaptersFactory;
  
  public ParameterAdapter() {
    super(org.tetrabox.minijava.xminijava.adapters.xminijavamt.XMiniJavaMTAdaptersFactory.getInstance());
    adaptersFactory = org.tetrabox.minijava.xminijava.adapters.xminijavamt.XMiniJavaMTAdaptersFactory.getInstance();
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
  public TypeRef getTypeRef() {
    return (TypeRef) adaptersFactory.createAdapter(adaptee.getTypeRef(), eResource);
  }
  
  @Override
  public void setTypeRef(final TypeRef o) {
    if (o != null)
    	adaptee.setTypeRef(((org.tetrabox.minijava.xminijava.adapters.xminijavamt.miniJava.TypeRefAdapter) o).getAdaptee());
    else adaptee.setTypeRef(null);
  }
  
  @Override
  public boolean compare(final org.tetrabox.minijava.xminijavamt.miniJava.Parameter other) {
    return org.tetrabox.minijava.xminijava.aspects.ParameterAspect.compare(adaptee, (org.tetrabox.minijava.xminijava.miniJava.Parameter)((EObjectAdapter)other).getAdaptee()
    );
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.tetrabox.minijava.xminijavamt.miniJava.MiniJavaPackage.eINSTANCE.getParameter();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.tetrabox.minijava.xminijavamt.miniJava.MiniJavaPackage.PARAMETER__NAME:
    		return getName();
    	case org.tetrabox.minijava.xminijavamt.miniJava.MiniJavaPackage.PARAMETER__TYPE_REF:
    		return getTypeRef();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.tetrabox.minijava.xminijavamt.miniJava.MiniJavaPackage.PARAMETER__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.tetrabox.minijava.xminijavamt.miniJava.MiniJavaPackage.PARAMETER__TYPE_REF:
    		return getTypeRef() != null;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.tetrabox.minijava.xminijavamt.miniJava.MiniJavaPackage.PARAMETER__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.tetrabox.minijava.xminijavamt.miniJava.MiniJavaPackage.PARAMETER__TYPE_REF:
    		setTypeRef(
    		(org.tetrabox.minijava.xminijavamt.miniJava.TypeRef)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
