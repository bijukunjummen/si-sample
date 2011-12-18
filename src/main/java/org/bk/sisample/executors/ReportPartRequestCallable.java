package org.bk.sisample.executors;

import java.util.concurrent.Callable;

import org.bk.sisample.types.ReportPart;
import org.bk.sisample.types.ReportRequestPart;
import org.bk.sisamples.processors.ReportPartGenerator;

public class ReportPartRequestCallable implements Callable<ReportPart> {
	private final ReportRequestPart reportRequestPart;
	private final ReportPartGenerator reportPartGenerator;

	public ReportPartRequestCallable(ReportRequestPart reportRequestPart, ReportPartGenerator reportPartGenerator) {
	    this.reportRequestPart = reportRequestPart;
	    this.reportPartGenerator = reportPartGenerator;
    }

	@Override
    public ReportPart call() {
	   return this.reportPartGenerator.generateReportPart(reportRequestPart);
    }	
}
	
