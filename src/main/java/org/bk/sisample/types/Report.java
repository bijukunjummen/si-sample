package org.bk.sisample.types;

import java.util.ArrayList;
import java.util.List;

public class Report {
	private final List<ReportPart> sectionReports = new ArrayList<>();
	
	public Report(List<ReportPart> sectionReports){
		this.sectionReports.addAll(sectionReports); 
	}

	public List<ReportPart> getSectionReports() {
    	return this.sectionReports;
    }	
	
	public void addReportPart(ReportPart reportPart){
		this.sectionReports.add(reportPart);
	}
	
	public void combine(Report report){
		this.sectionReports.addAll(report.sectionReports);
	}
}
