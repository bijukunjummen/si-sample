package org.bk.sisample.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;

import org.bk.sisample.processors.ReportGenerator;
import org.bk.sisample.processors.ReportPartGenerator;
import org.bk.sisample.types.Report;
import org.bk.sisample.types.ReportPart;
import org.bk.sisample.types.ReportRequest;
import org.bk.sisample.types.ReportRequestPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForkJoinBasedReportGenerator implements ReportGenerator {
    private static final Logger logger = LoggerFactory.getLogger(ForkJoinBasedReportGenerator.class);

    private ReportPartGenerator reportPartGenerator;

    private ForkJoinPool forkJoinPool = new ForkJoinPool();

    @Override
    public Report generateReport(ReportRequest reportRequest) {
    	List<ForkJoinTask<ReportPart>> tasks = new ArrayList<>();
    	for (ReportRequestPart reportRequestPart: reportRequest.getRequestParts()){
    		tasks.add(new ReportPartTask(reportRequestPart, this.reportPartGenerator));
    	}
//    	forkJoinPool.invo
    	return null;

    }

    public void setReportPartGenerator(ReportPartGenerator reportPartGenerator) {
        this.reportPartGenerator = reportPartGenerator;
    }
}
