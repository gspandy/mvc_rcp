package com.example.rcpmvc.demo;

import org.eclipse.swt.SWT;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.addView(CalculatorView.VIEW_ID, SWT.LEFT, 1.0f, layout.getEditorArea());
		layout.setEditorAreaVisible(false);
	}
}
