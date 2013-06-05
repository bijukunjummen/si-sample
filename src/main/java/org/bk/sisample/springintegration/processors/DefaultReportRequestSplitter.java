package org.bk.sisample.springintegration.processors;

import java.util.List;

import org.bk.sisample.types.ReportRequest;
import org.bk.sisample.types.ReportRequestPart;

public class DefaultReportRequestSplitter implements ReportRequestSplitter{

	@Override
	public List<ReportRequestPart> split(ReportRequest reportRequest) {
		return reportRequest.getRequestParts();
	}

}
