package ex03.tomcat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * This class manage logs inside the server.
 */
public class ServerLogger {
	private String fullClassName;
	private String className;
	private final static Map<String,ServerLogger> loggers=new HashMap<String,ServerLogger>();
	private final StringBuilder logs=new StringBuilder();
	private final String DELIM="\n";
	
	public ServerLogger(String className){
		this.fullClassName=className;
		loggers.put(className, this);
		this.className=getName(fullClassName);
	}
	
	private String getName(String name){
		String[] s=name.split("\\.");
		return s[s.length-1];
	}
	public String getLog(){
		return logs.toString();
	}
	
	public void log(String log){
		Date now=new Date();
		logs.append(now.toString()).append(" ").append(className).append(":").append(log).append(DELIM);
	}
	
	public synchronized static ServerLogger getLogger(String className){
		return loggers.get(className);
	}

	public String getString(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ServerLogger getManager(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
