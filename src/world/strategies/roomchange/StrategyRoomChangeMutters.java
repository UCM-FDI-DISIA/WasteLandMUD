package world.strategies.roomchange;

import world.Mobile;
import world.strategies.StrategyOnRoomChange;

public class StrategyRoomChangeMutters implements StrategyOnRoomChange {

	private Mobile mobile;

	public StrategyRoomChangeMutters() {
		
	}

	public StrategyRoomChangeMutters(Mobile mob) {
	
		mobile = mob;		
	}

	@Override
	public void onRoomChange() {

		// TODO not impplemented yet.
		//System.out.println(this.mobile.getName() + " changes room.");
	}
}
