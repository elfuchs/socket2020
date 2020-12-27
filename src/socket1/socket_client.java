package socket1;

//java socket client example
import java.io.*;
import java.net.*;

public class socket_client
{
  public static void main(String[] args) throws IOException 
  {
      Socket s = new Socket();
	String host = "www.google.com";
		
      try 
      {
		s.connect(new InetSocketAddress(host , 80));
      }
      
      //Host not found
      catch (UnknownHostException e) 
      {
          System.err.println("Don't know about host : " + host);
          System.exit(1);
      }
      
      System.out.println("Connected");
  }
}
