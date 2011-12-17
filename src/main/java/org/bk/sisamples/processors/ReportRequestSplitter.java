package org.bk.sisamples.processors;

import java.util.List;

import org.bk.sisample.types.ReportRequest;
import org.bk.sisample.types.ReportRequestPart;

public interface ReportRequestSplitter {
	List<ReportRequestPart> split(ReportRequest reportRequest);
}
