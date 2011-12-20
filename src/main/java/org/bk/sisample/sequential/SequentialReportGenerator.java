package org.bk.sisample.sequential;

import java.util.ArrayList;
import java.util.List;

import org.bk.sisample.processors.ReportGenerator;
import org.bk.sisample.processors.ReportPartGenerator;
import org.bk.sisample.types.Report;
import org.bk.sisample.types.ReportPart;
import org.bk.sisample.types.ReportRequest;
import org.bk.sisample.types.ReportRequestPart;

public class SequentialReportGenerator implements ReportGenerator {
	
	private ReportPartGenerator reportPartGenerator;

	@Override
	public Report generateReport(ReportRequest reportRequest){
		List<ReportRequestPart> reportRequestParts = reportRequest.getRequestParts();
		List<ReportPart> reportSections = new ArrayList<ReportPart>();
		for (ReportRequestPart reportRequestPart: reportRequestParts){
			reportSections.add(reportPartGenerator.generateReportPart(reportRequestPart));
		}
		return new Report(reportSections);
	}
	
	
	public void setReportPartGenerator(ReportPartGenerator reportPartGenerator){
		this.reportPartGenerator = reportPartGenerator;
	}

}
