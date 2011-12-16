package org.bk.sisamples.processors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bk.sisample.types.Context;
import org.bk.sisample.types.ReportRequest;
import org.bk.sisample.types.ReportRequestPart;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DummyReportPartGeneratorTest{

	@Test
	public void testGenerateReportPart() {
		List<ReportRequestPart> requestParts = new ArrayList<ReportRequestPart>();
		Map<String, String> attributes = new HashMap<String, String>();
		attributes.put("user","user");
		Context context = new Context(attributes );
		ReportRequestPart part1 = new ReportRequestPart("section1", context);
		ReportRequestPart part2 = new ReportRequestPart("section2", context);
		ReportRequestPart part3 = new ReportRequestPart("section3", context);
		ReportRequestPart part4 = new ReportRequestPart("section4", context);

		requestParts.add(part1);		
		requestParts.add(part2);
		requestParts.add(part3);
		requestParts.add(part4);
		
		ReportRequest reportRequest  = new ReportRequest(requestParts );
		
		
		ReportPartGenerator reportGenerator = new DummyReportPartGenerator();
		assertThat(reportGenerator.generateReportPart(part1), is("Report for section1"));
	}

}
