package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import world.CreateWorld;
import world.World;
import world.WorldNotFoundException;
import world.creation.CreateWorldRefactored;
import world.creation.builder.WorldBuilder;
import world.creation.builder.WorldBuilderImpl;
import world.creation.builder.WorldBuilderImpl2;

/**
 * server.MudServer is the main server for our MUD. It will control all of the
 * clients that are current in game. When a network.Client requests a
 * connections, it will accept and create a server.Client and store it in an
 * array list to communicate with the network.Client. It will have a main method
 * that will start the server. The server will then wait for clients that are
 * attempting to connect and accept there request.
 * 
 * @author Matt Turner, Ross Bottorf, Zach Boe, Jonathan Perrine
 * 
 */
public class MudServer {

	private static final int LISTENER_PORT = 4000;
	private static ArrayList<server.Client> clients;
	private ServerSocket serverSocket;
	private int port;

	/**
	 * server.MudServer constructor will set the port that is read in, which
	 * will always be 4000 and initialize the ArrayList of clients.
	 * 
	 * @param port
	 *            Port of the server
	 */
	public MudServer(int port) {
		this.port = port;
		clients = new ArrayList<server.Client>();
	}

	/**
	 * main() is called once to load the Mud World, create an admin account if
	 * not already created, initialize a new MUD server and then call start on
	 * the server. Start will continuously wait for new clients who are
	 * attempting to connect.
	 * 
	 * @param args
	 *            Default command line array
	 * @throws WorldNotFoundException 
	 * @throws WorldNotFoundException 
	 */
	public static void main(String[] args)  {

		
		try {
			World.getInstance().loadWorld();
		} catch (WorldNotFoundException e) {
			// 0: original
			//new CreateWorld().createWorld();
			
			// 1: Gear and Mobile as factory 
			//new CreateWorldRefactored().createWorld();
			
			// 2: Gear and Mobile as factory, builder for Room 
			//
			WorldBuilder builder = new WorldBuilderImpl();			
			builder.buildWorld();	
		}
		
		if (!World.getInstance().confirmPlayer(
				"administrator", "password")) {
			World.getInstance().createPlayer("administrator",
					"password");
			World.getInstance().saveWorld();
			World.getInstance().savePlayer(
					World.getInstance().getPlayer(
							"administrator"));
		}
		MudServer mudServer = new MudServer(LISTENER_PORT);
		World.getInstance().saveWorld();
		mudServer.start();
	}

	/**
	 * This method returns the List of clients connected to the server.
	 * 
	 * @return - The list of clients connected to the server.
	 */
	public static List<Client> getClients() {
		return clients;
	}

	/**
	 * Start is the main method for the server. It will be called from main()
	 * and once it starts it will create a new ServerSocket and a new socket.
	 * The new socket will be used once the server gets a request to connect.
	 * Once it gets a request it will call accept on the connect, make a new
	 * client and call start on that client. It will do this until the server
	 * disconnects.
	 */
	public void start() {
		List<Client> removalList = new ArrayList<Client>();

		try {
			serverSocket = new ServerSocket(port);
			Socket connection;
			Client c;

			while (true) {

				connection = serverSocket.accept();

				c = new server.Client(connection, this);
				System.out.println("Got connection: " + connection);
				clients.add(c);
				c.start();

				// Check for disconnected clients
				removalList.clear();

				for (server.Client c2 : clients) {
					if (c2.getState() == ClientState.DONE) {
						removalList.add(c2);
					}
				}
				clients.removeAll(removalList);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException ioe2) {
					ioe2.printStackTrace();
				}
			}
		}
	}

	/**
	 * messageAllCleints will be used when a command is called that needs to be
	 * sent to all clients. The client ArrayList will be used here to get access
	 * to all connected clients.
	 * 
	 * @param msg
	 *            String to be sent to players
	 */
	public void messageAllClients(String msg) {
		for (Client c : clients) {
			if (c.getState() != ClientState.ERROR) {
				c.sendReply(msg);
			}
		}
	}
}
