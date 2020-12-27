package socket1;

//java server example
import java.io.*;
import java.net.*;

public class socket_server2
{
	public static void main(String args[])
	{
		ServerSocket s = null;
		Socket conn = null;
		PrintStream out = null;
		BufferedReader in = null;
		String message = null;
		
		try
		{
			//1. creating a server socket - 1st parameter is port number and 2nd is the backlog
			s = new ServerSocket(5000 , 10);
			
			//2. Wait for an incoming connection
			echo("Server socket created.Waiting for connection...");
			//get the connection socket
			conn = s.accept();
			//print the hostname and port number of the connection
			echo("Connection received from " + conn.getInetAddress().getHostName() + " : " + conn.getPort());
			
			//3. get Input and Output streams
			out = new PrintStream(conn.getOutputStream());
			out.flush();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			out.println("Welcome. Server version 1.0");
			out.flush();




			//4. The two parts communicate via the input and output streams
			do
			{
				//read input from client
				message = (String)in.readLine();
				echo("client>" + message);
				
				if(message != null)
				{
					out.println(message);
				}
				else
				{
					echo("Client has disconnected");
					break;
				}
			}
			while(!message.equals("bye"));
		}
		
		catch(IOException e)
		{
			System.err.println("IOException");
		}
		
		//5. close the connections and stream
		try
		{
			in.close();
			out.close();
			s.close();
		}
		
		catch(IOException ioException)
		{
			System.err.println("Unable to close. IOexception");
		}
	}
	
	public static void echo(String msg)
	{
		System.out.println(msg);
	}
}