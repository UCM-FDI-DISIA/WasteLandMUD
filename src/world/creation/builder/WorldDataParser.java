package world.creation.builder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class WorldDataParser {
	
	WorldBuilder builder;
	
	public WorldDataParser() {
		
	}

	public WorldDataParser(WorldBuilder build) {
		builder = build;		
	}
	
	public void parseFile(String fileAddress) {
		
		String fileContent = this.readLineByLineJava8(fileAddress);
		
		StringTokenizer st = new StringTokenizer(fileContent, "\n");
		
		this.process(st);
		
	}
	
	private void process(StringTokenizer st) {
		
		while(st.hasMoreTokens()) {
			String line = st.nextToken();
			
			if(line.startsWith("Room")) {
				this.buildRoom(line, st);				
			}

			if(line.startsWith("Exit")) {
				this.buildExit(line);				
			}

			if(line.startsWith("ADD")) {
				this.nestInstruction(line);				
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
