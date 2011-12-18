package org.bk.sisample.types;

import java.util.List;

public class Report {
	private final List<ReportPart> sectionReports;
	
	public Report(List<ReportPart> sectionReports){
		this.sectionReports = sectionReports; 
	}

	public List<ReportPart> getSectionReports() {
    	return sectionReports;
    }	
}
