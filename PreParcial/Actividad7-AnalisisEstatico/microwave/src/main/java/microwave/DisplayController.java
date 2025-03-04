package microwave;

public class DisplayController {

	public static final int NO_PRESS = -1;
	
	// my digit representation is 'big endian'.
	
	public static final int TENS_OF_MINUTES = 0;
	public static final int MINUTES = 1;
	public static final int TENS_OF_SECONDS = 2;
	public static final int SECONDS = 3;
	
	static final byte [] ROLLOVER = {5, 9, 5, 9};

	private boolean [] digitPressed = new boolean [10];
	private byte [] digits = new byte[4];
	private int tickRateInHz; 
	private int ticks;
	
	public DisplayController(int tickRateInHz) {
		this.tickRateInHz = tickRateInHz;
		this.ticks = 0;
	}
	
	
	public synchronized void digitPressed(int key) {
		if (key >= 0 && key <= 9) {
			digitPressed[key] = true;
		}
	}
	
	public synchronized void clearDigitPressed() {
		for (int i=0; i < 10; i++) {
			digitPressed[i] = false;
		}
	}
	
	public synchronized void clearKeyPressed(ModeController.Mode m) {
		if (m == ModeController.Mode.SUSPENDED ||
			m == ModeController.Mode.SETUP) {
			for (int i = 0; i < digits.length; i++) {
				digits[i] = 0;
			}
		}
	}
	
	public synchronized int timeToCook() {
		return digits[SECONDS] + 
			   10*digits[TENS_OF_SECONDS] + 
			   60*digits[MINUTES] + 
			   600*digits[TENS_OF_MINUTES];
	}

	public boolean secondElapsed() {
		return (ticks % tickRateInHz) == 0;
	}
	
	
	public synchronized void tick(ModeController.Mode mode) {

		switch (mode) {
		case SETUP:
			tickSetUp();
			break;
		case SUSPENDED: /* do nothing - wait for user */
			break;
		case COOKING:
			ticks++;
			tickCooking();
			break;
		}
		clearDigitPressed();
	}

	private void tickSetUp(){
		byte numberPressed = NO_PRESS;
		ticks = 0 ;

		for (byte i = 0; i < 10; i++) {
			if (digitPressed[i]) {
				numberPressed = i;
				break;
			}
		}

		if (numberPressed != NO_PRESS) {
			for (int i = 0; i < digits.length - 1; i++) {
				digits[i] = digits[i+1];
			}
			digits[digits.length - 1] = numberPressed;
		}
	}


	private void tickCooking(){
		if (secondElapsed() && timeToCook() != 0) {
			for (int i=digits.length - 1; i >= 0; i--) {
				if (digits[i] != 0) {
					digits[i]--;
					break;
				} else {
					digits[i] = ROLLOVER[i];
					// not carrying over to the next thing...oops.
				}
			}
		}
	}

	byte [] getDigits() {
		return digits;
	}
	
	int getTickRateInHz() {
		return tickRateInHz;
	}
	
	void setTickRateInHz(int tickRate) {
		tickRateInHz = tickRate;
	}
	void setDigits(byte [] digits) {
		if (digits.length != 4) {
			throw new IllegalArgumentException("Wrong number of digits!");
		}
		for (byte d: digits) {
			if (d < 0 || d > 9) {
				throw new IllegalArgumentException("digits must be between 0..9");
			}
		}
		this.digits = digits;
	}
	
	void setTimeToCook(int time) {
		if (time < 0 || time >= 6000) {
			throw new IllegalArgumentException("setTimeToCook: Time must be positive and < 6000 seconds");
		}
		byte seconds = (byte)(time % 10);
		byte tensOfSeconds = (byte)((time / 10) % 6); 
		byte minutes = (byte)((time / 60) % 10); 
		byte tensOfMinutes = (byte)((time / 600) % 10);
		byte [] myArray = {tensOfMinutes, minutes, tensOfSeconds, seconds}; 
		setDigits(myArray);
	}
}
