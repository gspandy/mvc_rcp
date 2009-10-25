package de.ralfebert.rcpmvc.util.slot;

/**
 * A slot can be exposed as getter by a class to allow others to add and remove
 * listeners instead of exposing addListener/removeListener methods.
 * 
 * @author Ralf Ebert
 */
public interface ISlot<LISTENER> {

	public void addListener(LISTENER listener);

	public void removeListener(LISTENER listener);

}
