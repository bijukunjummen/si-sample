package org.bk.sisamples.processors;

import org.bk.sisample.types.ReportRequestPart;

public interface ReportPartGenerator {
	String generateReportPart(ReportRequestPart reportRequestPart);
}
