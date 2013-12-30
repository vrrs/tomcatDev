package ex01.tomcat;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	private boolean shutdown = false;

	public static void main(String[] args) {
		HttpServer server = new HttpServer();
		server.await();
	}

	public void await() {
		ServerSocket serverSocket = null;
		int port = 8080;
		try {
			serverSocket = new ServerSocket(port, 1,InetAddress.getByName("127.0.0.1")); 
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		// Loop waiting for a request
		while (!shutdown) {
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			try {
				//System.out.println("k2");
				
				/*
				 * 'block until' new connection has been made. runs in an infinite loop
				*/
				socket = serverSocket.accept(); 
				input = socket.getInputStream();
				output = socket.getOutputStream();
				// create Request object and parse
				HttpRequest request = new HttpRequest(input);
				request.parse();
				// create Response object
				HttpResponse response = new HttpResponse(output);
				response.setRequest(request);
				response.sendStaticResource();
				socket.close();
				// check if the previous URI is a shutdown command
				shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}

}
