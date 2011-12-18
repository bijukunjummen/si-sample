package org.bk.sisample.executors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.bk.sisample.testutil.FixtureGenerator;
import org.bk.sisample.types.Report;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"test-executors.xml"})
public class ExecutorsBasedReportGeneratorTest {
	
	@Resource private ExecutorsBasedReportGenerator reportGenerator;
	
	private static final Logger logger = LoggerFactory.getLogger(ExecutorsBasedReportGeneratorTest.class);
	
	@Test
	public void testExecutorsBasedReportGeneratorTime(){
		long startTime = System.currentTimeMillis();
		Report report = this.reportGenerator.generateReport(FixtureGenerator.generateReportRequest());
		long timeForReport = System.currentTimeMillis()-startTime;
		
		assertThat(report.getSectionReports().size(), is (5));

		logger.error(String.format("Executors Based Report Generator : %s ms", timeForReport));
	}
	
	 

}
