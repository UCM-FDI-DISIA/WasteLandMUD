package world.creation.builder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.stream.Stream;

import world.Armor;
import world.GearContainer;
import world.HealthOrb;
import world.Mobile;
import world.Weapon;
import world.creation.factorymethod.ElementFactory;
import world.creation.factorymethod.ElementFactoryImpl;
import world.creation.factorymethod.MobileFactory;
import world.creation.factorymethod.MobileFactoryImpl;

public class WorldDataParser {
	
	String path;
	
	ElementFactory elementFactory;
	
	MobileFactory mobileFactory;	
	
	WorldBuilder builder;	
	
	public WorldDataParser() {
		
		elementFactory = new ElementFactoryImpl();	
		
		mobileFactory = new MobileFactoryImpl();
	}

	public WorldDataParser(WorldBuilder build) {
		builder = build;		
	}

	public WorldDataParser(String fileAddress, WorldBuilder build) {
		path = fileAddress;
		builder = build;		
	}
	
	public void construct() {
		this.parseFile(path);
	}
	
	public void parseFile(String fileAddress) {
		
		String fileContent = this.readLineByLineJava8(fileAddress);
		
		StringTokenizer st = new StringTokenizer(fileContent, "\n");
		
		this.process(st);
		
	}
	
	private void process(StringTokenizer st) {
		
		while(st.hasMoreTokens()) {
			String line = st.nextToken();
			
			//System.out.println("LINE: "+ line);
			
			//  Room structure
			
			if(line.startsWith("Room")) {
				this.buildRoom(line, st);				
			}

			if(line.startsWith("Exit")) {
				this.buildExit(line);				
			}

			if(line.startsWith("ADD")) {
				this.nestInstruction(line);				
			}	
			
			//  Gear			

			if(line.startsWith("Weapon")) {
				this.buildWeapon(st);				
			}		

			if(line.startsWith("Armor")) {
				this.buildArmor(st);				
			}

			if(line.startsWith("Orb")) {
				this.buildOrb(st);		
			}


			if(line.startsWith("GearContainer")) {
				this.buildGearContainer(st);		
			}			
			
			// Mobile

			if(line.startsWith("Mobile")) {
				this.buildMobile(st);				
			}

			if(line.startsWith("Stat")) {
				this.updateStat(line);			
			}			
		}		
	}
	
	private void buildRoom(String line, StringTokenizer st) {
		String id = line.substring(5);
		String name = st.nextToken().substring(5);
		
		StringBuffer description = new StringBuffer();
		boolean finished = false;
		while(st.hasMoreTokens() && !finished) {
			String nextLine = st.nextToken();
			finished = nextLine.equalsIgnoreCase("END");
			if(!finished) {
				description.append(nextLine);
			}			
		}
		builder.buildRoom(id, name, description.toString());
	}
	
	private void buildExit(String line) {

		StringTokenizer st = new StringTokenizer(line.substring(5), " ");
		
		String room1 = st.nextToken();
		String whichWay = st.nextToken();
		String room2 = st.nextToken();
		
		builder.buildExit(room1, whichWay, room2);		
	}

	private void nestInstruction(String line) {

		StringTokenizer st = new StringTokenizer(line.substring(4), " ");
		
		String room1 = st.nextToken();
		String room2 = st.nextToken();
		
		builder.nestRooms(room1, room2);		
	}

	private void buildWeapon(StringTokenizer st) {
				
		String name = st.nextToken().substring(5);
		
		StringBuffer description = new StringBuffer();
		boolean finished = false;
		while(st.hasMoreTokens() && !finished) {
			String nextLine = st.nextToken();
			finished = nextLine.equalsIgnoreCase("END");
			if(!finished) {
				description.append(nextLine);
			}			
		}
		
		String levelString = st.nextToken();
		int level = Integer.parseInt(levelString.substring(6));
		String damageString = st.nextToken();
		int damage = Integer.parseInt(damageString.substring(7));
		

		String locationString = st.nextToken();
		String where = locationString.substring(9);
				
		Weapon weapon = elementFactory.buildWeapon(name, description.toString(), level, damage);


		//System.out.println("Created " + weapon.getName());
		
		builder.addGear(where, weapon);		

		System.out.println("Added " + weapon.getName() + " to " + where);
	}

	private void buildArmor(StringTokenizer st) {
				
		String name = st.nextToken().substring(5);
		
		StringBuffer description = new StringBuffer();
		boolean finished = false;
		while(st.hasMoreTokens() && !finished) {
			String nextLine = st.nextToken();
			finished = nextLine.equalsIgnoreCase("END");
			if(!finished) {
				description.append(nextLine);
			}			
		}
		
		String levelString = st.nextToken();
		int level = Integer.parseInt(levelString.substring(6));
		String damageString = st.nextToken();
		char type = damageString.substring(5).charAt(0);
		

		String locationString = st.nextToken();
		String where = locationString.substring(9);
				
		Armor armor = elementFactory.buildArmor(name, description.toString(), level, type);
		
		builder.addGear(where, armor);		

		System.out.println("Added " + armor.getName() + " to " + where);
	}

	private void buildOrb(StringTokenizer st) {
				
		String name = st.nextToken().substring(5);
		
		StringBuffer description = new StringBuffer();
		boolean finished = false;
		while(st.hasMoreTokens() && !finished) {
			String nextLine = st.nextToken();
			finished = nextLine.equalsIgnoreCase("END");
			if(!finished) {
				description.append(nextLine);
			}			
		}
		
		String levelString = st.nextToken();
		int healthPoints = Integer.parseInt(levelString.substring(13));

		String locationString = st.nextToken();
		String where = locationString.substring(9);
				
		HealthOrb orb = elementFactory.buildHealthOrb(name, description.toString(), healthPoints);
		
		builder.addGear(where, orb);		

		System.out.println("Added " + orb.getName() + " to " + where);
	}

	private void buildGearContainer(StringTokenizer st) {
				
		String name = st.nextToken().substring(5);
		
		StringBuffer description = new StringBuffer();
		boolean finished = false;
		while(st.hasMoreTokens() && !finished) {
			String nextLine = st.nextToken();
			finished = nextLine.equalsIgnoreCase("END");
			if(!finished) {
				description.append(nextLine);
			}			
		}
		
		String maxSizeString = st.nextToken();
		int maxSize = Integer.parseInt(maxSizeString.substring(8));
		
		String canCarryString = st.nextToken();
		String canCarryShort = canCarryString.substring(9);
		boolean canCarry = Boolean.parseBoolean(canCarryShort);

		String locationString = st.nextToken();
		String where = locationString.substring(9);
				
		GearContainer container = elementFactory.buildGearContainer(name, description.toString(), maxSize, canCarry);
		
		builder.addGear(where, container);		

		System.out.println("Added " + container.getName() + " to " + where);
	}

	private void buildMobile(StringTokenizer st) {
				
		String name = st.nextToken().substring(5);
		
		StringBuffer description = new StringBuffer();
		boolean finished = false;
		while(st.hasMoreTokens() && !finished) {
			String nextLine = st.nextToken();
			finished = nextLine.equalsIgnoreCase("END");
			if(!finished) {
				description.append(nextLine);
			}			
		}
		
		String strategyString = st.nextToken();
		
		StringTokenizer stStrategy = new StringTokenizer(strategyString," ");
		
		stStrategy.nextToken();
		
		String strategy = stStrategy.nextToken();
		String message4strategy = "";
		
		if(stStrategy.hasMoreTokens()) {
			message4strategy = stStrategy.nextToken();
		}

		String locationString = st.nextToken();
		String where = locationString.substring(9);
		
		Mobile mobile = mobileFactory.createMobile(name, description.toString(), strategy, message4strategy);
			
		//System.out.println("Buit mobile " + mobile.getName());
		
		builder.addMobile(where, mobile);
	}

	private void updateStat(String line) {
		
		StringTokenizer st = new StringTokenizer(line," ");
		
		st.nextToken();
		
		String name = st.nextToken();

		String trait = st.nextToken();

		String valueString = st.nextToken();
		int value = Integer.parseInt(valueString);
		
		builder.addStatToMobile(name, trait, value);
	}

    private String readLineByLineJava8(String filePath) {
    	
        StringBuilder contentBuilder = new StringBuilder();
 
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
 
        return contentBuilder.toString();
    }
}
