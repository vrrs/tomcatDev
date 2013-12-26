package ex03.tomcat;

import java.io.OutputStream;
import java.net.Socket;

public class HttpProcessor {

	private HttpRequest request;
	private HttpResponse response;

	public HttpProcessor(HttpConnector con) {

	}

	public void process(Socket socket) {
		SocketInputStream input = null;
		OutputStream output = null;
		try {
			input = new SocketInputStream(socket.getInputStream(), 2048);
			output = socket.getOutputStream();
			// create HttpRequest object and parse
			request = new HttpRequest(input);
			// create HttpResponse object
			response = new HttpResponse(output);
			response.setRequest(request);
			response.setHeader("Server", "Pyrmont Servlet Container");
			parseRequest(input, output);
			parseHeaders(input);
			// check if this is a request for a servlet or a static resource //a
			// request for a servlet begins with "/servlet/"
			if (request.getRequestURI().startsWith("/servlet/")) {
				ServletProcessor processor = new ServletProcessor();
				processor.process(request, response);
			} else {
				StaticResourceProcessor processor = new StaticResourceProcessor();
				processor.process(request, response);
			}
			// Close the socket socket.close();
			// no shutdown for this application
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void parseHeaders(SocketInputStream input) {
		// TODO Auto-generated method stub

	}

	private void parseRequest(SocketInputStream input, OutputStream output) {
		// TODO Auto-generated method stub

	}
}
