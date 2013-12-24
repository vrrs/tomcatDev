package ex02.tomcat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class HttpResponseFacade implements ServletResponse{
	
	private HttpResponse resp;

	public HttpResponseFacade(HttpResponse resp){
		this.resp=resp;
	}

	@Override
	public void flushBuffer() throws IOException {
		resp.flushBuffer();
	}

	@Override
	public int getBufferSize() {
		return resp.getBufferSize();
	}

	@Override
	public String getCharacterEncoding() {
		return resp.getCharacterEncoding();
	}

	@Override
	public String getContentType() {
		return resp.getContentType();
	}

	@Override
	public Locale getLocale() {
		return resp.getLocale();
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return resp.getOutputStream();
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		return resp.getWriter();
	}

	@Override
	public boolean isCommitted() {
		return resp.isCommitted();
	}

	@Override
	public void reset() {
		resp.reset();
	}

	@Override
	public void resetBuffer() {
		resp.resetBuffer();
	}

	@Override
	public void setBufferSize(int arg0) {
		resp.setBufferSize(arg0);
	}

	@Override
	public void setCharacterEncoding(String arg0) {
		resp.setCharacterEncoding(arg0);
	}

	@Override
	public void setContentLength(int arg0) {
		resp.setContentLength(arg0);
	}

	@Override
	public void setContentLengthLong(long arg0) {
		resp.setContentLengthLong(arg0);
	}

	@Override
	public void setContentType(String arg0) {
		resp.setContentType(arg0);
	}

	@Override
	public void setLocale(Locale arg0) {
		resp.setLocale(arg0);
	}

}
