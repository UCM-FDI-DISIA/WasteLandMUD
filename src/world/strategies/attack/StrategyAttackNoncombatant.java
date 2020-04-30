package world.strategies.attack;

import world.Mobile;
import world.Movable;
import world.Room;
import world.strategies.StrategyAttackBehaviour;

public class StrategyAttackNoncombatant implements StrategyAttackBehaviour {

	public StrategyAttackNoncombatant() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attackBehavior(Mobile me, Movable enemy) {
		
		((Room) me.getLocation()).sendToRoom(me.getName()
				+ " shouts, \" Help! " + enemy.getName()
				+ " is attacking me! \" ");
	}
}
