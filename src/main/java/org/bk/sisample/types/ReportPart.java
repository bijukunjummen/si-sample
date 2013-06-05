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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((reportPartDetail == null) ? 0 : reportPartDetail.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportPart other = (ReportPart) obj;
		if (reportPartDetail == null) {
			if (other.reportPartDetail != null)
				return false;
		} else if (!reportPartDetail.equals(other.reportPartDetail))
			return false;
		if (section != other.section)
			return false;
		return true;
	}
	
	
}
