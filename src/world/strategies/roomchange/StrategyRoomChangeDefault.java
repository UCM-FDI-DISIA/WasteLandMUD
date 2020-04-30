package world.strategies.roomchange;

import world.strategies.StrategyOnRoomChange;

public class StrategyRoomChangeDefault implements StrategyOnRoomChange {

	public StrategyRoomChangeDefault() {
		
	}

	@Override
	public void onRoomChange() {

		// Does nothing when it changes rooms. Shouldn't be changing rooms
		// anyway.
	}
}
