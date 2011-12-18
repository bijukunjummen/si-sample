package org.bk.sisample.rawthread;

import org.bk.sisample.types.ReportPart;
import org.bk.sisample.types.ReportRequestPart;
import org.bk.sisamples.processors.ReportPartGenerator;

public class ReportPartRequestRunnable implements Runnable {
	private final ReportRequestPart reportRequestPart;
	private final ReportPartGenerator reportPartGenerator;
	private ReportPart reportPart;

	public ReportPartRequestRunnable(ReportRequestPart reportRequestPart, ReportPartGenerator reportPartGenerator) {
	    this.reportRequestPart = reportRequestPart;
	    this.reportPartGenerator = reportPartGenerator;
    }

	@Override
    public void run() {
	   this.reportPart = this.reportPartGenerator.generateReportPart(reportRequestPart);
    }

	public ReportPart getReportPart() {
    	return reportPart;
    }
	
	
}
	
