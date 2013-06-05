package org.bk.sisample.springintegration;

import org.bk.sisample.types.Report;
import org.bk.sisample.types.ReportRequest;

public interface ReportGeneratorGateway {
    
    Report generateReport(ReportRequest reportRequest);

}
