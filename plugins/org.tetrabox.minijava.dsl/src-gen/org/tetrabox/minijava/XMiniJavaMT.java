package org.tetrabox.minijava;

import fr.inria.diverse.melange.lib.IModelType;
import java.io.IOException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.tetrabox.minijava.xminijavamt.miniJava.MiniJavaFactory;

@SuppressWarnings("all")
public interface XMiniJavaMT extends IModelType {
  public abstract EList<EObject> getContents();
  
  public abstract MiniJavaFactory getMiniJavaFactory();
  
  public abstract void save(final String uri) throws IOException;
}
