package socket1;

import java.net.Socket;

/**
 * Prints debug output (to stdout) for the given Java Socket.
 */

class printSocketInformation 
{
	public static void printSocketInformation(Socket socket)
	{
		try
		{
			System.out.format("Port:                 %s\n",   socket.getPort());
			System.out.format("Canonical Host Name:  %s\n",   socket.getInetAddress().getCanonicalHostName());
			System.out.format("Host Address:         %s\n\n", socket.getInetAddress().getHostAddress());
			System.out.format("Local Address:        %s\n",   socket.getLocalAddress());
			System.out.format("Local Port:           %s\n",   socket.getLocalPort());
			System.out.format("Local Socket Address: %s\n\n", socket.getLocalSocketAddress());
			System.out.format("Receive Buffer Size:  %s\n",   socket.getReceiveBufferSize());
			System.out.format("Send Buffer Size:     %s\n\n", socket.getSendBufferSize());
			System.out.format("Keep-Alive:           %s\n",   socket.getKeepAlive());
			System.out.format("SO Timeout:           %s\n",   socket.getSoTimeout());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
