package world.state;

import world.strategies.attack.StrategyAttackNoncombatant;
import world.strategies.roomchange.StrategyRoomChangeDefault;
import world.strategies.send.StrategySendGreets;

public class StateMutters extends StateGenericImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = -264938416479419232L;

	public StateMutters() {

		 attack = new StrategyAttackNoncombatant();
		 send = new StrategySendGreets();
		 roomChange = new StrategyRoomChangeDefault();
	}
}
