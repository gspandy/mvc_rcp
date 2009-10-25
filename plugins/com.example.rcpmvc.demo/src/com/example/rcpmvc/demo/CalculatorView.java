package com.example.rcpmvc.demo;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.ralfebert.rcpmvc.base.PassiveViewPart;

public class CalculatorView extends PassiveViewPart {

	public static final String VIEW_ID = "com.example.rcpmvc.demo.calculator";

	@Override
	public void basicCreatePartControl(Composite parent) {
		setPartName("Calculator");
		
		Text nr1 = UIControlsFactory.createText(parent, SWT.BORDER, "nr1");
		Text nr2 = UIControlsFactory.createText(parent, SWT.BORDER, "nr2");
		UIControlsFactory.createButton(parent, "Calculate", "calculate");
		Text result = UIControlsFactory.createText(parent, SWT.BORDER, "result");

		GridLayoutFactory.fillDefaults().numColumns(4).spacing(5, 3).margins(5, 5).applyTo(parent);
		GridDataFactory widthHint = GridDataFactory.fillDefaults().hint(80, SWT.DEFAULT);
		widthHint.applyTo(nr1);
		widthHint.applyTo(nr2);
		widthHint.applyTo(result);
	}

}