package com.example.rcpmvc.demo;

import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import de.ralfebert.rcpmvc.base.ViewController;

public class CalculatorController extends ViewController<CalculatorView, CalculatorModel> {

	@Override
	public void configureRidgets() {
		ITextRidget nr1 = (ITextRidget) getRidget("nr1");
		ITextRidget nr2 = (ITextRidget) getRidget("nr2");
		final ITextRidget result = (ITextRidget) getRidget("result");
		IActionRidget calculate = (IActionRidget) getRidget("calculate");
		
		nr1.bindToModel(getModel(), "nr1");
		nr2.bindToModel(getModel(), "nr2");
		result.bindToModel(getModel(), "result");
		
		calculate.addListener(new IActionListener() {
			
			@Override
			public void callback() {
				getModel().setResult(getModel().getNr1() + getModel().getNr2());
				result.updateFromModel();
			}
		});

		updateAllRidgetsFromModel();
	}

}