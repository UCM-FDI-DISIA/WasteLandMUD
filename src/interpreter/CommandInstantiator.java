package interpreter;

import java.util.List;

import interpreter.command.Command;
import interpreter.command.ReformatLine;
import interpreter.command.impl.CommandCombat;
import interpreter.command.impl.CommandCommands;
import interpreter.command.impl.CommandDescribeMe;
import interpreter.command.impl.CommandDrop;
import interpreter.command.impl.CommandEmote;
import interpreter.command.impl.CommandGet;
import interpreter.command.impl.CommandGive;
import interpreter.command.impl.CommandInspect;
import interpreter.command.impl.CommandInventory;
import interpreter.command.impl.CommandLook;
import interpreter.command.impl.CommandMove;
import interpreter.command.impl.CommandRude;
import interpreter.command.impl.CommandSave;
import interpreter.command.impl.CommandSay;
import interpreter.command.impl.CommandScore;
import interpreter.command.impl.CommandSetClass;
import interpreter.command.impl.CommandShutdown;
import interpreter.command.impl.CommandSnipe;
import interpreter.command.impl.CommandTell;
import interpreter.command.impl.CommandUse;
import interpreter.command.impl.CommandWho;
import interpreter.command.impl.CommandWound;
import world.Player;

public class CommandInstantiator {
	
	public static Command instantiate(Player player, List<String> parsedCommandSequence) {
		
		Command command = null;
		
		String commandWord = parsedCommandSequence.get(0);
		
		switch(commandWord) {

			case "say":  
				if(parsedCommandSequence.size()>1) {

					String message  = 
							ReformatLine.reformat(
									parsedCommandSequence.subList(1, parsedCommandSequence.size())
									);

					 command = new CommandSay(player, message);
				}
				else {
					 command = new CommandSay(player, "Say what?");					
				}
				break;

			case "emote":
				if(parsedCommandSequence.size()>1) {

					String message  = 
							ReformatLine.reformat(
									parsedCommandSequence.subList(1, parsedCommandSequence.size())
									);

					 command = new CommandEmote(player, message);
				}
				else {
					 command = new CommandEmote(player, "Emote what?");					
				}
				
				break;

			case "rude":
				if(parsedCommandSequence.size()>1) {

					String target  = parsedCommandSequence.get(1);

					 command = new CommandRude(player, target);
				}
				else {
					 command = new CommandRude(player);					
				}
				
				break;

			case "commands":

				 command = new CommandCommands(player);	
				break;

			case "who":

				 command = new CommandWho(player);	
				break;

			case "save":

				 command = new CommandSave(player);	
				break;

			case "describeme":
				if(parsedCommandSequence.size()>1) {

					String description  = 
							ReformatLine.reformat(
									parsedCommandSequence.subList(1, parsedCommandSequence.size())
									);

					 command = new CommandDescribeMe(player, description);
				}
				else {
					 command = new CommandDescribeMe(player);					
				}
				
				break;

			case "tell":

				command = 
				     new CommandTell(
						player, 
						parsedCommandSequence.subList(1, parsedCommandSequence.size()));
				
				break;

			case "look":
				if(parsedCommandSequence.size()>1) {

					String target  = parsedCommandSequence.get(1);

					 command = new CommandLook(player, target);
				}
				else {
					 command = new CommandLook(player);					
				}
				
				break;

			case "inspect":
				if(parsedCommandSequence.size()>1) {

					String target  = parsedCommandSequence.get(1);

					 command = new CommandInspect(player, target);
				}
				else {
					 command = new CommandInspect(player);					
				}
				
				break;

			case "shutdown":

				command = new CommandShutdown(player);
				
				break;

			case "inventory":

				command = new CommandInventory(player);
				
				break;

			case "i":

				command = new CommandInventory(player);
				
				break;

			case "score":

				command = new CommandScore(player);
				
				break;

			case "drop":
				if(parsedCommandSequence.size()>1) {

					String target  = parsedCommandSequence.get(1);

					 command = new CommandDrop(player, target);
				}
				else {
					 command = new CommandDrop(player);					
				}
				
				break;

			case "use":
				if(parsedCommandSequence.size()>1) {

					String target  = parsedCommandSequence.get(1);

					 command = new CommandUse(player, target);
				}
				else {
					 command = new CommandUse(player);					
				}
				
				break;

			case "get":
				command = 
				  new CommandGet(
					player, 
					parsedCommandSequence.subList(1, parsedCommandSequence.size()));
				
				break;

			case "give":
				command = 
				  new CommandGive(
					player, 
					parsedCommandSequence.subList(1, parsedCommandSequence.size()));
				
				break;

			case "setclass":
				if(parsedCommandSequence.size()>1) {

					String target  = parsedCommandSequence.get(1);

					 command = new CommandSetClass(player, target);
				}
				else {
					 command = new CommandSetClass(player);					
				}
				
				break;
			
			//  movement commands

			case "north":
				 command = new CommandMove(player, "n");
				
				break;
				
			case "n":
				 command = new CommandMove(player, "n");
				
				break;
				
			case "south":
				 command = new CommandMove(player, "s");
				
				break;
				
			case "s":
				 command = new CommandMove(player, "s");
				
				break;

			case "east":
				 command = new CommandMove(player, "e");
				
				break;
				
			case "e":
				 command = new CommandMove(player, "e");
				
				break;
				
			case "west":
				 command = new CommandMove(player, "w");
				
				break;
				
			case "w":
				 command = new CommandMove(player, "w");
				
				break;
				
			case "up":
				 command = new CommandMove(player, "u");
				
				break;
				
			case "u":
				 command = new CommandMove(player, "u");
				
				break;
				
			case "down":
				 command = new CommandMove(player, "d");
				
				break;
				
			case "d":
				 command = new CommandMove(player, "d");
				
				break;
				
			//  combat commands

			case "attack":
				if(parsedCommandSequence.size()>1) {

					String target  = parsedCommandSequence.get(1);

					 command = new CommandCombat(player, target);
				}
				else {
					 command = new CommandCombat(player);					
				}
				
				break;

			case "kill":
				if(parsedCommandSequence.size()>1) {

					String target  = parsedCommandSequence.get(1);

					 command = new CommandCombat(player, target);
				}
				else {
					 command = new CommandCombat(player);					
				}
				
				break;

			case "snipe":
				if(parsedCommandSequence.size()>1) {

					String target  = parsedCommandSequence.get(1);

					 command = new CommandSnipe(player, target);
				}
				else {
					 command = new CommandSnipe(player);					
				}
				
				break;

			case "wound":
				if(parsedCommandSequence.size()>1) {

					String target  = parsedCommandSequence.get(1);

					 command = new CommandWound(player, target);
				}
				else {
					 command = new CommandWound(player);					
				}
				
				break;
			
			default :
				player.sendToPlayer(command + " is not understood.");
				
				break;
		}
		
		return command;		
	}
}
