package org.bk.sisample.taskexecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.bk.sisample.processors.ReportGenerator;
import org.bk.sisample.processors.ReportPartGenerator;
import org.bk.sisample.types.Report;
import org.bk.sisample.types.ReportPart;
import org.bk.sisample.types.ReportRequest;
import org.bk.sisample.types.ReportRequestPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskExecutorsBasedReportGenerator implements ReportGenerator {
    private static final Logger logger = LoggerFactory.getLogger(TaskExecutorsBasedReportGenerator.class);

    @Autowired private ReportPartGenerator reportPartGenerator;

    @Autowired private ExecutorService executors;

    @Override
    public Report generateReport(ReportRequest reportRequest) {
        List<Callable<ReportPart>> tasks = new ArrayList<Callable<ReportPart>>();
        List<ReportRequestPart> reportRequestParts = reportRequest.getRequestParts();
        for (ReportRequestPart reportRequestPart : reportRequestParts) {
        	ReportPartRequestCallable reportPartRequestCallable = new ReportPartRequestCallable(); 
        	reportPartRequestCallable.setReportRequestPart(reportRequestPart);
            tasks.add(reportPartRequestCallable);
        }

        List<Future<ReportPart>> responseForReportPartList;
        List<ReportPart> reportParts = new ArrayList<ReportPart>();
        try {
            responseForReportPartList = executors.invokeAll(tasks);
            for (Future<ReportPart> reportPartFuture : responseForReportPartList) {
                reportParts.add(reportPartFuture.get());
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        return new Report(reportParts);
    }

    public void setReportPartGenerator(ReportPartGenerator reportPartGenerator) {
        this.reportPartGenerator = reportPartGenerator;
    }

	public void setExecutors(ExecutorService executors) {
		this.executors = executors;
	}
    
}
