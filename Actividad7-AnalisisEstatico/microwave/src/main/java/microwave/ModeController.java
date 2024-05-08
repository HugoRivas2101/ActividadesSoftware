package microwave;

public class ModeController {

	public enum Mode {COOKING, SUSPENDED, SETUP};
	
	private boolean startPressed = false;
	private boolean clearPressed = false;
	private Mode mode = Mode.SETUP;
	private Mode preMode = Mode.SETUP;
	
	public synchronized boolean isStartPressed() {
		return startPressed;
	}

	public synchronized void setStartPressed(boolean startPressed) {
		this.startPressed = startPressed;
	}

	public synchronized boolean isClearPressed() {
		return clearPressed;
	}

	public synchronized void setClearPressed(boolean clearPressed) {
		this.clearPressed = clearPressed;
	}

	public synchronized Mode getMode() {
	 	return mode;
	}

	synchronized Mode tick(boolean doorOpen, boolean timeRemaining) {

		if (!timeRemaining) {
			mode = Mode.SETUP;
		}
		else if (doorOpen && mode == Mode.COOKING) {
			mode = Mode.SUSPENDED;
		} 
		else if (clearPressed) {
			if (mode == Mode.COOKING) {
				mode = Mode.SUSPENDED; 
			} else if (mode == Mode.SUSPENDED) {
				mode = Mode.SETUP;
			}
		} 
		else if (startPressed && !doorOpen) {
			mode = Mode.COOKING;
		}
		
		startPressed = false;
		clearPressed = false;
		
		return mode;
	}
	
	public boolean modeChanged() {
		return mode != preMode;
	}
	
	public boolean inCOOKING() {
		return (mode == preMode &&
				mode == Mode.COOKING);
	}
	
}
