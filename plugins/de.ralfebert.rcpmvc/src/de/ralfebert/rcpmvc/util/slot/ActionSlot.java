package de.ralfebert.rcpmvc.util.slot;

import org.eclipse.riena.internal.ui.ridgets.swt.ActionObserver;
import org.eclipse.riena.ui.ridgets.IActionListener;

/**
 * Expose Riena-internal class ActionObserver as ActionSlot
 * 
 * @author Ralf Ebert
 */
@SuppressWarnings("restriction")
public class ActionSlot extends ActionObserver implements ISlot<IActionListener> {

	@Override
	public void fireAction() {
		super.fireAction();
	}
	
	@Override
	public void addListener(IActionListener listener) {
		super.addListener(listener);
	}
	
	@Override
	public void removeListener(IActionListener listener) {
		super.removeListener(listener);
	}
	
}
