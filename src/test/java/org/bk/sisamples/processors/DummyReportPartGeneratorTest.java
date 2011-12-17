package org.bk.sisamples.processors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.bk.sisample.types.Context;
import org.bk.sisample.types.ReportRequestPart;
import org.bk.sisample.types.Section;
import org.junit.Test;

public class DummyReportPartGeneratorTest {

	@Test
	public void testGenerateReportPart() {
		Map<String, String> attributes = new HashMap<String, String>();
		attributes.put("user", "user");
		Context context = new Context(attributes);
		ReportRequestPart part1 = new ReportRequestPart(Section.SECTION1, context);

		ReportPartGenerator reportGenerator = new DummyReportPartGenerator();
		assertThat(reportGenerator.generateReportPart(part1), is("Report for SECTION1"));
	}
}
