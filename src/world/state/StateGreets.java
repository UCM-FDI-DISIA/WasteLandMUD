package world.state;

import world.Mobile;
import world.Movable;
import world.strategies.StrategyAttackBehaviour;
import world.strategies.StrategyOnRoomChange;
import world.strategies.StrategyReactToSend;
import world.strategies.attack.StrategyAttackNoncombatant;
import world.strategies.roomchange.StrategyRoomChangeDefault;
import world.strategies.send.StrategySendGreets;

public class StateGreets extends State4Mobile {
	
	private static final long serialVersionUID = 3039773453796280139L;
	
	StrategyAttackBehaviour attack;
	StrategyReactToSend send;
	StrategyOnRoomChange roomChange;

	public StateGreets() {

		 attack = new StrategyAttackNoncombatant();
		 send = new StrategySendGreets();
		 roomChange = new StrategyRoomChangeDefault();
	}

	@Override
	public void attackBehavior(Mobile me, Movable enemy) {
		attack.attackBehavior(me, enemy);
	}

	@Override
	public void reactToSend(String sent, Mobile mob) {
		send.reactToSend(sent, mob);
	}

	@Override
	public void onRoomChange() {
		roomChange.onRoomChange();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new StateGreets();
	}
}
