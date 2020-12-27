package socket1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * A simple TCP server. When a client connects, it sends the client the current
 * datetime, then closes the connection. This is arguably the simplest server
 * you can write. Beware though that a client has to be completely served its
 * date before the server will be able to handle another client.
 */
public class DateServer2 {
    public static void main(String[] args) throws IOException {
        try (var listener = new ServerSocket(59090)) {
        	// printSocketInformation(listener);
            System.out.println("The date server is running...");
            while (true) {
                try (var socket = listener.accept()) {
                	printSocketInformation(socket);
                    var out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                }
            }
        }
    }

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


