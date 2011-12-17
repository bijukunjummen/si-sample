package org.bk.sisamples.processors;

import java.util.Map;

import org.bk.sisample.types.ReportRequest;
import org.bk.sisample.types.Section;

public interface ReportGenerator {
	
	Map<Section, String> generateReport(ReportRequest reportRequest);

}
