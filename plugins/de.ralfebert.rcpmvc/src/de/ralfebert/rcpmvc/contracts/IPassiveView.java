package de.ralfebert.rcpmvc.contracts;

import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.swt.uibinding.AbstractViewBindingDelegate;

import de.ralfebert.rcpmvc.util.slot.ISlot;

public interface IPassiveView {

	public ISlot<IActionListener> getUiAvailableSlot();
	public ISlot<IActionListener> getDisposeSlot();

	public AbstractViewBindingDelegate getViewDelegate();
	
}
