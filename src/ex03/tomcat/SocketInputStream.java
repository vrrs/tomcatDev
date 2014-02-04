package ex03.tomcat;

import java.io.IOException;
import java.io.InputStream;
/*
 * This class is the one present in apache commons. This class appears not visible in java.net package
 */
public class SocketInputStream extends InputStream{
	private byte[] buffer;
	private InputStream input;

	public SocketInputStream(InputStream inputStream, int i) {
		buffer=new byte[i];
		input=inputStream;
	}

	@Override
	public int read() throws IOException {
			// input is the InputStream from the socket.
		return  input.read(buffer); 
	}

	public void readRequestLine(HttpRequestLine requestLine) {
		// TODO Auto-generated method stub
		
	}

}
