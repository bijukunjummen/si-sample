package org.bk.sisamples.processors;

import org.bk.sisample.types.ReportRequestPart;

public class DummyReportPartGenerator implements ReportPartGenerator{

	@Override
	public String generateReportPart(ReportRequestPart reportRequestPart) {
		try {
			//Deliberately introduce a delay
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Report for " + reportRequestPart.getSection();
	}

}
