package ex02.tomcat;

import java.io.IOException;

public class StaticResourceProcessor implements Runnable{
	private HttpRequest request;
	private HttpResponse response;

	public StaticResourceProcessor(HttpRequest request, HttpResponse response) {
		this.request=request;
		this.response=response;
	}

	public void process(HttpRequest request, HttpResponse response) {
		try {
			response.sendStaticResource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		process(request,response);
	}

}
