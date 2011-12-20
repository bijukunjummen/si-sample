package org.bk.sisample.processors;

import org.bk.sisample.types.ReportPart;
import org.bk.sisample.types.ReportRequestPart;

public class DummyReportPartGenerator implements ReportPartGenerator{

	@Override
	public ReportPart generateReportPart(ReportRequestPart reportRequestPart) {
		try {
			//Deliberately introduce a delay
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ReportPart(reportRequestPart.getSection(), "Report for " + reportRequestPart.getSection());
	}

}
