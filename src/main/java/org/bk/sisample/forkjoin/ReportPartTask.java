package org.bk.sisample.forkjoin;

import java.util.concurrent.RecursiveTask;

import org.bk.sisample.processors.ReportPartGenerator;
import org.bk.sisample.types.ReportPart;
import org.bk.sisample.types.ReportRequestPart;

public class ReportPartTask extends RecursiveTask<ReportPart> {
	private static final long serialVersionUID = 1L;
	private final ReportRequestPart reportRequestPart;
	private final ReportPartGenerator reportPartGenerator;

	public ReportPartTask(ReportRequestPart reportRequestPart,
			ReportPartGenerator reportPartGenerator) {
		this.reportRequestPart = reportRequestPart;
		this.reportPartGenerator = reportPartGenerator;
	}

	@Override
	protected ReportPart compute() {
		return this.reportPartGenerator.generateReportPart(reportRequestPart);
	}
}
