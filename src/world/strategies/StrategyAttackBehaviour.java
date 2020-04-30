package world.strategies;

import world.Mobile;
import world.Movable;

public interface StrategyAttackBehaviour {
	
	public void attackBehavior(Mobile me, Movable enemy);
}
