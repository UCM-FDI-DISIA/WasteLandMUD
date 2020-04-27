package world.visitor.print;

import world.composite.LocationComposite;
import world.composite.LocationLeaf;
import world.location.Location;
import world.visitor.LocationVisitor;

public class LocationPrintVisitor implements LocationVisitor {	

	StringBuffer out;

	public LocationPrintVisitor() {
		out = new StringBuffer();
	}

	@Override
	public void visit(LocationLeaf loc) {
		out.append(loc.getName());
		out.append("\n");
	}

	@Override
	public void visit(LocationComposite loc) {
		out.append(loc.getName());
		out.append("\n");
		
		for(Location nestedLoc : loc.getChildren()) {
			nestedLoc.accept(this);
		}
	}
	
	public String getPrintOut() {
		return out.toString();
	}
}
