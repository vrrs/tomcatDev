package ex02.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
	/**
	 * WEB_ROOT is the directory where our HTML and other files reside. For this
	 * package, WEB_ROOT is the "webroot" directory under the working directory.
	 * The working directory is the location in the file system from where the
	 * java command was invoked.
	 */
	// shutdown command
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	// the shutdown command received
	private boolean shutdown = false;

	public static void main(String[] args) {
		HttpServer server = new HttpServer();
		server.await();
	}

	public void await() {
		ServerSocket serverSocket = null;
		int port = 8080;
		try {
			serverSocket = new ServerSocket(port, 1,
					InetAddress.getByName("127.0.0.1"));
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
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				// create Request object and parse
				HttpRequest request = new HttpRequest(input);
				request.parse();
				// create Response object
				HttpResponse response = new HttpResponse(output);
				response.setRequest(request);
				
				Thread runner;
				if (request.getUri().startsWith("/servlet/")) {
					ServletProcessor processor = new ServletProcessor(request, response);
					runner=new Thread(processor);
					runner.start();
				}else {
					if(!(shutdown = request.getUri().equals(SHUTDOWN_COMMAND))){
						StaticResourceProcessor processor = new StaticResourceProcessor(request, response);
						runner=new Thread(processor);
						runner.start();
					}
				}
				socket.close();
				// check if the previous URI is a shutdown command
				shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
