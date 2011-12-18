package org.bk.sisample.rawthread;

import java.util.ArrayList;
import java.util.List;

import org.bk.sisample.types.Report;
import org.bk.sisample.types.ReportPart;
import org.bk.sisample.types.ReportRequest;
import org.bk.sisample.types.ReportRequestPart;
import org.bk.sisamples.processors.ReportGenerator;
import org.bk.sisamples.processors.ReportPartGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RawThreadBasedReportGenerator implements ReportGenerator {
	private static final Logger logger = LoggerFactory.getLogger(RawThreadBasedReportGenerator.class);
	
	private ReportPartGenerator reportPartGenerator;

	@Override
	public Report generateReport(ReportRequest reportRequest){
		List<ReportRequestPart> reportRequestParts = reportRequest.getRequestParts();
		List<Thread> threads = new ArrayList<Thread>();
		List<ReportPartRequestRunnable> runnablesList = new ArrayList<ReportPartRequestRunnable>();
		for (ReportRequestPart reportRequestPart: reportRequestParts){
			ReportPartRequestRunnable reportPartRequestRunnable = new ReportPartRequestRunnable(reportRequestPart, reportPartGenerator);
			runnablesList.add(reportPartRequestRunnable);
			Thread thread = new Thread(reportPartRequestRunnable);
			threads.add(thread);
			thread.start();
		}
		
		for (Thread thread: threads){
			try {
	            thread.join();
            } catch (InterruptedException e) {
	            logger.error(e.getMessage(),e);
            }
		}
		
		List<ReportPart> reportParts = new ArrayList<ReportPart>();
		
		for (ReportPartRequestRunnable reportPartRequestRunnable: runnablesList){
			reportParts.add(reportPartRequestRunnable.getReportPart());
		}
		
		return new Report(reportParts);
		
	}
	
	public void setReportPartGenerator(ReportPartGenerator reportPartGenerator){
		this.reportPartGenerator = reportPartGenerator;
	}

}
