package org.bk.sisample.springintegration;

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
@ContextConfiguration(locations={"test-springintegration.xml"})
public class SpringIntegrationBasedReportGeneratorTest {
	
	@Resource private SpringIntegrationBasedReportGenerator reportGenerator;
	
	private static final Logger logger = LoggerFactory.getLogger(SpringIntegrationBasedReportGeneratorTest.class);
	
	@Test
	public void testSpringIntegrationBasedReportGeneratorTime(){
		long startTime = System.currentTimeMillis();
		Report report = this.reportGenerator.generateReport(FixtureGenerator.generateReportRequest());
		long timeForReport = System.currentTimeMillis()-startTime;
		
		assertThat(report.getSectionReports().size(), is (5));

		logger.error(String.format("Spring Integration Based Report Generator : %s ms", timeForReport));
	}
	
	 

}
