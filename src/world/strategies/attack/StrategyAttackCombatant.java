package world.strategies.attack;

import world.Mobile;
import world.Movable;
import world.strategies.StrategyAttackBehaviour;

public class StrategyAttackCombatant implements StrategyAttackBehaviour {

	public StrategyAttackCombatant() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attackBehavior(Mobile me, Movable enemy) {

		me.resolveAttack(enemy);
	}
}
