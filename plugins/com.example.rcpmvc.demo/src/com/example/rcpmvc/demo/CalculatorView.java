package com.example.rcpmvc.demo;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;

import de.ralfebert.rcpmvc.base.PassiveViewPart;

public class CalculatorView extends PassiveViewPart {

	public static final String VIEW_ID = "com.example.rcpmvc.demo.calculator";

	@Override
	public void basicCreatePartControl(Composite parent) {
		RowLayout layout = new RowLayout();
		layout.spacing = 10;
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);
		
		UIControlsFactory.createText(parent, SWT.BORDER, "nr1");
		UIControlsFactory.createText(parent, SWT.BORDER, "nr2");
		UIControlsFactory.createButton(parent, "Calculate", "calculate");
		UIControlsFactory.createText(parent, SWT.BORDER, "result");
	}

}