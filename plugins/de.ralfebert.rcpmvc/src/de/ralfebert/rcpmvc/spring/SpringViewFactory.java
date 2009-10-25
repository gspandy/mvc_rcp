package de.ralfebert.rcpmvc.spring;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.springframework.util.SpringExtensionFactory;

import de.ralfebert.rcpmvc.contracts.IBaseController;

/**
 * SpringViewFactory extends SpringExtensionFactory. Expects a controller bean
 * implementing IBaseController. Instead of handing out the controller bean, the
 * value of the "view" property of the controller is handed out.
 * 
 * @author Ralf Ebert
 */
public class SpringViewFactory extends SpringExtensionFactory {

	@SuppressWarnings("unchecked")
	@Override
	public Object create() throws CoreException {

		Object obj = super.create();

		Assert.isTrue(obj instanceof IBaseController, "The referred bean should subclass ViewController, but was: "
				+ obj);

		IBaseController controller = (IBaseController) obj;

		return controller.getView();
	}

}
