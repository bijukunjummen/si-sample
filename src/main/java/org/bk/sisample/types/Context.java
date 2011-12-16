package org.bk.sisample.types;

import java.util.Map;

public class Context {
	private final Map<String, String> attributes;
	
	public Context(Map<String, String> attributes){
		this.attributes = attributes;
	}
	
	public Map<String, String> getAttributes(){
		return this.attributes;
	}

	@Override
	public String toString() {
		return "Context [attributes=" + attributes + "]";
	}
	
	
}
