package ex02.tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;

public class HttpRequest {
	private InputStream input;
	private String uri;
	
	private String header_firstLine; //it contains the method, protocol,version and uri
	private String[] headers; 
	private String body;
	
	private final int BUFFER_SIZE=2048;

	public HttpRequest(InputStream input) {
		this.input = input;
	}

	public String getUri() {
		return uri;
	}

	private String parseUri(String firstLine) {
		String parts[]=firstLine.split(" ");
		if(parts.length>1)
			return parts[1];
		return null;
	}

	public void parse() {
		// Read a set of characters from the socket
		StringBuffer request = new StringBuffer(BUFFER_SIZE);
		int i;
		byte[] buffer = new byte[BUFFER_SIZE];
		try {
			i = input.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
			i = -1;
		}
		for (int j = 0; j < i; j++) {
			request.append((char) buffer[j]);
		}
		
		String requestString=request.toString();
		System.out.print(requestString);  //use logger component to log the request string
		
		String comp[]=requestString.split("\\r\\n");
		String[] head=comp[0].split("\n");
		header_firstLine=head[0];
		
		headers=new String[head.length-1];
		for(int j=1;j<comp.length;j++){
			headers[j-1]=head[j];
		}
		body=comp[1];
		uri = parseUri(header_firstLine);
	}

	/* implementation of ServletRequest */
	public Object getAttribute(String attribute) {
		return null;
	}

	public Enumeration getAttributeNames() {
		return null;
	}

	public String getRealPath(String path) {
		return null;
	}

	public RequestDispatcher getRequestDispatcher(String path) {
		return null;
	}

	public boolean isSecure() {
		return false;
	}

	public String getCharacterEncoding() {
		return null;
	}

	public int getContentLength() {
		return 0;
	}

	public String getContentType() {
		return null;
	}

	public ServletInputStream getInputStream() throws IOException {
		return null;
	}

	public Locale getLocale() {
		return null;
	}

	public Enumeration getLocales() {
		return null;
	}

	public String getParameter(String name) {
		return null;
	}

	public Map getParameterMap() {
		return null;
	}

	public Enumeration getParameterNames() {
		return null;
	}

	public String[] getParameterValues(String parameter) {
		return null;
	}

	public String getProtocol() {
		return null;
	}

	public BufferedReader getReader() throws IOException {
		return null;
	}

	public String getRemoteAddr() {
		return null;
	}

	public String getRemoteHost() {
		return null;
	}

	public String getScheme() {
		return null;
	}

	public String getServerName() {
		return null;
	}

	public int getServerPort() {
		return 0;
	}

	public void removeAttribute(String attribute) {
	}

	public void setAttribute(String key, Object value) {
	}

	public void setCharacterEncoding(String encoding) throws UnsupportedEncodingException {
	}

}
