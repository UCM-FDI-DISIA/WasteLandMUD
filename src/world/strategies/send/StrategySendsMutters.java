package world.strategies.send;

import java.util.Scanner;

import world.Mobile;
import world.Room;
import world.World;
import world.strategies.StrategyReactToSend;

public class StrategySendsMutters implements StrategyReactToSend {

	public StrategySendsMutters() {

	}

	@Override
	public void reactToSend(String sent, Mobile mob) {
		
		Scanner sentStuff = new Scanner(sent);
		String aPlayer = sentStuff.next().trim();
		if (World.getInstance().playerExists(aPlayer)) {
			((Room) mob.getLocation()).sendToRoom("" + mob.getName()
					+ " looks at " + aPlayer + ".");
		}
		
		sentStuff.close();
	}
}
