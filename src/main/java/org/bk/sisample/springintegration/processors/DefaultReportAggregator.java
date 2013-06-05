package org.bk.sisample.springintegration.processors;

import java.util.List;

import org.bk.sisample.types.Report;
import org.bk.sisample.types.ReportPart;

public class DefaultReportAggregator implements ReportAggregator{

    @Override
    public Report aggregate(List<ReportPart> reportParts) {
        return new Report(reportParts);
    }

}
