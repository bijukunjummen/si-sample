package org.bk.sisample.types;

public class ReportPart {
	private final Section section;
	private final String reportPartDetail;
	public ReportPart(Section section, String reportPartDetail) {
	    super();
	    this.section = section;
	    this.reportPartDetail = reportPartDetail;
    }
	public Section getSection() {
    	return section;
    }
	public String getReportPartDetail() {
    	return reportPartDetail;
    }
	@Override
    public String toString() {
	    return "ReportPart [section=" + section + ", reportPartDetail=" + reportPartDetail + "]";
    }
}
