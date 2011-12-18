package org.bk.sisample.types;

import java.util.Map;

public class Report {
	private final Map<Section, String> sectionReports;
	
	public Report(Map<Section, String> sectionReports){
		this.sectionReports = sectionReports; 
	}

	public Map<Section, String> getSectionReports() {
    	return sectionReports;
    }	
}
