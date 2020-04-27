package world.location;

import java.util.List;

public interface Location {
	
	public String getName();
	
	public void add(Location loc);
	
	public void remove(Location loc);
	
	public Location getChild(int which);
	
	public String provideDescription();

	public List<Location> getChildren();
}
