package de.ralfebert.rcpmvc.base;

import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.swt.uibinding.AbstractViewBindingDelegate;
import org.eclipse.riena.ui.ridgets.swt.uibinding.DefaultSwtBindingDelegate;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.part.ViewPart;

import de.ralfebert.rcpmvc.contracts.IPassiveView;
import de.ralfebert.rcpmvc.util.slot.ActionSlot;
import de.ralfebert.rcpmvc.util.slot.ISlot;

public abstract class PassiveViewPart extends ViewPart implements IPassiveView {

	private DefaultSwtBindingDelegate delegate = new DefaultSwtBindingDelegate();
	private ActionSlot uiAvailableSlot = new ActionSlot();
	private ActionSlot disposeSlot = new ActionSlot();

	@Override
	public AbstractViewBindingDelegate getViewDelegate() {
		return delegate;
	}

	@Override
	public ISlot<IActionListener> getDisposeSlot() {
		return disposeSlot;
	}

	@Override
	public ISlot<IActionListener> getUiAvailableSlot() {
		return uiAvailableSlot;
	}

	@Override
	public final void createPartControl(Composite parent) {
		basicCreatePartControl(parent);

		addUIControls(parent);
		uiAvailableSlot.fireAction();

		parent.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				disposeSlot.fireAction();
			}
		});
	}

	private void addUIControls(Composite composite) {

		Control[] controls = composite.getChildren();
		for (Control uiControl : controls) {

			String bindingProperty = SWTBindingPropertyLocator.getInstance().locateBindingProperty(uiControl);
			if (!StringUtils.isEmpty(bindingProperty)) {
				if (isChildOfComplexComponent(uiControl)) {
					continue;
				}
				delegate.addUIControl(uiControl);
			}
			if (uiControl instanceof Composite) {
				addUIControls((Composite) uiControl);
			}

		}

	}
	
	private boolean isChildOfComplexComponent(Control uiControl) {

		if (uiControl.getParent() == null) {
			return false;
		}
		if (uiControl.getParent() instanceof IComplexComponent) {
			return true;
		}
		return isChildOfComplexComponent(uiControl.getParent());

	}

	
	@Override
	public void setFocus() {
		
	}
	
	protected abstract void basicCreatePartControl(Composite parent);

}
