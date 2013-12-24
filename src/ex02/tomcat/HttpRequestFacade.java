package ex02.tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HttpRequestFacade implements ServletRequest{
	private HttpRequest req;
	
	public HttpRequestFacade(HttpRequest req){
		this.req=req;
	}

	@Override
	public AsyncContext getAsyncContext() {
		return req.getAsyncContext();
	}

	@Override
	public Object getAttribute(String arg0) {
		return req.getAttribute(arg0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Enumeration<String> getAttributeNames() {
		return req.getAttributeNames();
	}

	@Override
	public String getCharacterEncoding() {
		return req.getCharacterEncoding();
	}

	@Override
	public int getContentLength() {
		return req.getContentLength();
	}

	@Override
	public long getContentLengthLong() {
		return req.getContentLengthLong();
	}

	@Override
	public String getContentType() {
		return req.getContentType();
	}

	@Override
	public DispatcherType getDispatcherType() {
		return req.getDispatcherType();
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		return req.getInputStream();
	}

	@Override
	public String getLocalAddr() {
		return req.getLocalAddr();
	}

	@Override
	public String getLocalName() {
		return req.getLocalName();
	}

	@Override
	public int getLocalPort() {
		return req.getLocalPort();
	}

	@Override
	public Locale getLocale() {
		return req.getLocale();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Enumeration<Locale> getLocales() {
		return  req.getLocales();
	}

	@Override
	public String getParameter(String arg0) {
		return req.getParameter(arg0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String[]> getParameterMap() {
		return req.getParameterMap();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Enumeration<String> getParameterNames() {
		return req.getParameterNames();
	}

	@Override
	public String[] getParameterValues(String arg0) {
		return req.getParameterValues(arg0);
	}

	@Override
	public String getProtocol() {
		return req.getProtocol();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return req.getReader();
	}

	@Override
	public String getRealPath(String arg0) {
		return req.getRealPath(arg0);
	}

	@Override
	public String getRemoteAddr() {
		return req.getRemoteAddr();
	}

	@Override
	public String getRemoteHost() {
		return req.getRemoteHost();
	}

	@Override
	public int getRemotePort() {
		return req.getRemotePort();
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String arg0) {
		return req.getRequestDispatcher(arg0);
	}

	@Override
	public String getScheme() {
		return req.getScheme();
	}

	@Override
	public String getServerName() {
		return req.getServerName();
	}

	@Override
	public int getServerPort() {
		return req.getServerPort();
	}

	@Override
	public ServletContext getServletContext() {
		return req.getServletContext();
	}

	@Override
	public boolean isAsyncStarted() {
		return req.isAsyncStarted();
	}

	@Override
	public boolean isAsyncSupported() {
		return req.isAsyncSupported();
	}

	@Override
	public boolean isSecure() {
		return req.isSecure();
	}

	@Override
	public void removeAttribute(String arg0) {
		req.removeAttribute(arg0);
	}

	@Override
	public void setAttribute(String arg0, Object arg1) {
		req.setAttribute(arg0, arg1);
	}

	@Override
	public void setCharacterEncoding(String arg0)
			throws UnsupportedEncodingException {
		req.setCharacterEncoding(arg0);
	}

	@Override
	public AsyncContext startAsync() throws IllegalStateException {
		return req.startAsync();
	}

	@Override
	public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1)
			throws IllegalStateException {
		return req.startAsync(arg0, arg1);
	}

}
