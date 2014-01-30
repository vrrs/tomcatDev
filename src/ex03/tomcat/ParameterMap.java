package ex03.tomcat;

import java.util.HashMap;
import java.util.Map;

public class ParameterMap extends HashMap<Object,Object> {
	private static final long serialVersionUID = 1L;
	private static final ServerLogger sm = ServerLogger.getManager("org.apache.catalina.util");
	
	public ParameterMap() {
		super();
	}

	public ParameterMap(int initialCapacity) {
		super(initialCapacity);
	}

	public ParameterMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	public ParameterMap(Map<Object,Object> map) {
		super(map);
	}

	private boolean locked = false;

	public boolean isLocked() {
		return (this.locked);
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public void clear() {
		if (locked)
			throw new IllegalStateException(sm.getString("parameterMap.locked"));
		super.clear();
	}

	public Object put(Object key, Object value) {
		if (locked)
			throw new IllegalStateException(sm.getString("parameterMap.locked"));
		return (super.put(key, value));
	}

	public void putAll(Map map) {
		if (locked)
			throw new IllegalStateException(sm.getString("parameterMap.locked"));
		super.putAll(map);
	}

	public Object remove(Object key) {
		if (locked)
			throw new IllegalStateException(sm.getString("parameterMap.locked"));
		return (super.remove(key));
	}
}
