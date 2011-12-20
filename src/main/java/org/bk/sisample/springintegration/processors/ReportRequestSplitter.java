package org.bk.sisample.springintegration.processors;

import java.util.List;

import org.bk.sisample.types.ReportRequest;
import org.bk.sisample.types.ReportRequestPart;

public interface ReportRequestSplitter {
	List<ReportRequestPart> split(ReportRequest reportRequest);
}
