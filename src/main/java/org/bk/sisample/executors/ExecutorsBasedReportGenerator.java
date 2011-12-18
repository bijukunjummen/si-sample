package org.bk.sisample.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.bk.sisample.types.Report;
import org.bk.sisample.types.ReportPart;
import org.bk.sisample.types.ReportRequest;
import org.bk.sisample.types.ReportRequestPart;
import org.bk.sisamples.processors.ReportGenerator;
import org.bk.sisamples.processors.ReportPartGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutorsBasedReportGenerator implements ReportGenerator {
	private static final Logger logger = LoggerFactory.getLogger(ExecutorsBasedReportGenerator.class);
	
	private ReportPartGenerator reportPartGenerator;
	
	private ExecutorService executors = Executors.newFixedThreadPool(10);

	@Override
	public Report generateReport(ReportRequest reportRequest){
		List<ReportRequestPart> reportRequestParts = reportRequest.getRequestParts();
		
		List<Future<ReportPart>> responseForReportPartList = new ArrayList<Future<ReportPart>>();
		for (ReportRequestPart reportRequestPart: reportRequestParts){
			ReportPartRequestCallable reportPartRequestCallable = new ReportPartRequestCallable(reportRequestPart, reportPartGenerator);
			responseForReportPartList.add(executors.submit(reportPartRequestCallable));
		}
		

		
		List<ReportPart> reportParts = new ArrayList<ReportPart>();
		for (Future<ReportPart> reportPartFuture: responseForReportPartList){
		    try {
		        reportParts.add(reportPartFuture.get());
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            } 
		}
		
		return new Report(reportParts);
		
	}
	
	public void setReportPartGenerator(ReportPartGenerator reportPartGenerator){
		this.reportPartGenerator = reportPartGenerator;
	}

}
