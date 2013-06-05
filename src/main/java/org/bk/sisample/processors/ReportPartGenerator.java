package org.bk.sisample.processors;

import org.bk.sisample.types.ReportPart;
import org.bk.sisample.types.ReportRequestPart;

public interface ReportPartGenerator {
	ReportPart generateReportPart(ReportRequestPart reportRequestPart);
}
