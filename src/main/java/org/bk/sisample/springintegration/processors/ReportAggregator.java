package org.bk.sisample.springintegration.processors;

import java.util.List;

import org.bk.sisample.types.Report;
import org.bk.sisample.types.ReportPart;

public interface ReportAggregator {
    Report aggregate(List<ReportPart> reportParts);
}
