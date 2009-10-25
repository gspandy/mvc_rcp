package de.ralfebert.rcpmvc.contracts;

public interface IBaseController<VIEW, MODEL> {

	public VIEW getView();
	public void setView(VIEW view);

	public MODEL getModel();
	public void setModel(MODEL model);

}
