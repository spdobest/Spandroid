package spandroid.dev.eventBus.event;


import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

public class GlobalBus {
	private static Bus     sBus;
	private static boolean isRegistered;

	public static Bus getBus() {
		if ( sBus == null ) {
			sBus = new Bus( ThreadEnforcer.MAIN );
		}
		return sBus;
	}

	public static void setIsRegistered( final boolean registered ) {
		isRegistered = registered;
	}

	public static boolean isRegistered() {
		return isRegistered;
	}

}