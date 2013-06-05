package org.bk.sisample.taskexecutor;

import java.util.concurrent.Callable;

import org.bk.sisample.processors.ReportPartGenerator;
import org.bk.sisample.types.ReportPart;
import org.bk.sisample.types.ReportRequestPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable("reportPartRequestCallable")
public class ReportPartRequestCallable implements Callable<ReportPart> {
	private ReportRequestPart reportRequestPart;
	@Autowired private ReportPartGenerator reportPartGenerator;

	public ReportPartRequestCallable() {
    }

	@Override
    public ReportPart call() {
	   return this.reportPartGenerator.generateReportPart(reportRequestPart);
    }

	public void setReportRequestPart(ReportRequestPart reportRequestPart) {
		this.reportRequestPart = reportRequestPart;
	}

	public void setReportPartGenerator(ReportPartGenerator reportPartGenerator) {
		this.reportPartGenerator = reportPartGenerator;
	}
}
	
