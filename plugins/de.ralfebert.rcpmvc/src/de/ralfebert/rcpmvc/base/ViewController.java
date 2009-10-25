package de.ralfebert.rcpmvc.base;

import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;

import de.ralfebert.rcpmvc.contracts.IBaseController;
import de.ralfebert.rcpmvc.contracts.IPassiveView;

public class ViewController<VIEW extends IPassiveView, MODEL> extends SubModuleController implements IBaseController<VIEW, MODEL> {

	private VIEW view;
	private MODEL model;

	public VIEW getView() {
		return view;
	}

	public void setView(final VIEW view) {
		this.view = view;
		
		this.view.getUiAvailableSlot().addListener(new IActionListener() {
			@Override
			public void callback() {
				view.getViewDelegate().injectAndBind(ViewController.this);
			}
		});
		
		this.view.getDisposeSlot().addListener(new IActionListener() {
			@Override
			public void callback() {
				view.getViewDelegate().unbind(ViewController.this);
			}
		});
	}

	public MODEL getModel() {
		return model;
	}

	public void setModel(MODEL model) {
		this.model = model;
	}

}