package org.bk.sisample.primitivethread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bk.sisample.types.Report;
import org.bk.sisample.types.ReportRequest;
import org.bk.sisample.types.ReportRequestPart;
import org.bk.sisample.types.Section;
import org.bk.sisamples.processors.ReportGenerator;
import org.bk.sisamples.processors.ReportPartGenerator;

public class SequentialReportGenerator implements ReportGenerator {
	
	private ReportPartGenerator reportPartGenerator;

	@Override
	public Report generateReport(ReportRequest reportRequest){
		List<ReportRequestPart> reportRequestParts = reportRequest.getRequestParts();
		Map<Section, String> reportSectionsMap = new HashMap<Section, String>();
		for (ReportRequestPart reportRequestPart: reportRequestParts){
			reportSectionsMap.put(reportRequestPart.getSection(),reportPartGenerator.generateReportPart(reportRequestPart));
		}
		return new Report(reportSectionsMap);
	}
	
	public void setReportPartGenerator(ReportPartGenerator reportPartGenerator){
		this.reportPartGenerator = reportPartGenerator;
	}

}
