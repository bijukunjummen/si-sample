package org.bk.sisample.processors;

import org.bk.sisample.types.Report;
import org.bk.sisample.types.ReportRequest;

public interface ReportGenerator {
	
	Report generateReport(ReportRequest reportRequest);

}
