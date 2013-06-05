package org.bk.sisample.springintegration;

import javax.annotation.Resource;

import org.bk.sisample.processors.ReportGenerator;
import org.bk.sisample.types.Report;
import org.bk.sisample.types.ReportRequest;

public class SpringIntegrationBasedReportGenerator implements ReportGenerator {
    @Resource private ReportGeneratorGateway reportGeneratorGateway;

    @Override
    public Report generateReport(ReportRequest reportRequest) {
        return this.reportGeneratorGateway.generateReport(reportRequest);
    }

}
