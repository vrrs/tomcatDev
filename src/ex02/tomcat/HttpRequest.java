package ex02.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

public class HttpRequest {
	private InputStream input; private String uri;
	￼￼￼￼public HttpRequest(InputStream input){
	￼this.input = input;
	}
	￼public String getUri() {
	￼return uri;
	￼}
	private String parseUri(String requestString) {
	int index1, index2;
	index1 = requestString.indexOf(' ');
	if (index1 != -1) {
	index2 = requestString.indexOf(' ', index1 + 1);
	}
	if (index2 > index1)
	return requestString.substring(index1 + 1, index2);
	return null;
	}
	public void parse() {
	// Read a set of characters from the socket
	StringBuffer request = new StringBuffer(2048);
	int i;
	byte[] buffer = new byte[2048];
	try {
	i = input.read(buffer);}
	catch (IOException e) {
	e.printStackTrace();
	i = -1;
	}
	for (int j=0; j<i; j++) {
	}
	request.append((char) buffer(j));
	System.out.print(request.toString());
	uri = parseUri(request.toString());
	}
	/* implementation of ServletRequest */ public Object getAttribute(String attribute) {
	return null; }
	public Enumeration getAttributeNames() { return null;
	}
	public String getRealPath(String path) {
		
	}
}