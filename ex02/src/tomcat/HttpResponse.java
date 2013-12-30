package ex02.tomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class HttpResponse implements ServletResponse{
	private static final int BUFFER_SIZE = 1024;
	HttpRequest request;
	OutputStream output;
	PrintWriter writer;

	public HttpResponse(OutputStream output) {
		this.output = output;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	/* This method is used to serve static pages */
	public void sendStaticResource() throws IOException {
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			/* request.getUri has been replaced by request.getRequestURI */
			File file = new File(Constants.WEB_ROOT,request.getUri());
			fis = new FileInputStream(file);
			
			/* Http response format
			 * <protocol>/<version> <response_code> <response_code_message>\n
			<response_header1>: <value1>\n
			<response_headern>: <valuen>\r\n
			<body> */
			int ch = fis.read(bytes, 0, BUFFER_SIZE);
			while (ch != -1) {
				output.write(bytes, 0, ch);
				ch = fis.read(bytes, 0, BUFFER_SIZE);
			}
		} catch (FileNotFoundException e) {
			String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
					+ "Content-Type: text/html\r\n" + "Content-Length: 23\r\n"
					+ "\r\n" + "<h1>File Not Found</h1>";
			output.write(errorMessage.getBytes());
		} finally {
			if (fis != null)
				fis.close();
		}
	}

	/** implementation of ServletResponse */
	public void flushBuffer() throws IOException {
	}

	public int getBufferSize() {
		return 0;
	}

	public String getCharacterEncoding() {
		return null;
	}

	public Locale getLocale() {
		return null;
	}

	public ServletOutputStream getOutputStream() throws IOException {
		return null;
	}

	public boolean isCommitted() {
		return false;
	}

	public void reset() {
	}

	public void resetBuffer() {
	}

	public void setBufferSize(int size) {
	}

	public void setContentLength(int length) {
	}

	public void setContentType(String type) {
	}

	public void setLocale(Locale locale) {
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCharacterEncoding(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentLengthLong(long arg0) {
		// TODO Auto-generated method stub
		
	}
}
