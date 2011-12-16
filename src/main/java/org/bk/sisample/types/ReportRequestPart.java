package org.bk.sisample.types;

public class ReportRequestPart {
	private final String sectionName;
	private final Context context;

	public ReportRequestPart(String sectionName, Context context) {
		super();
		this.sectionName = sectionName;
		this.context = context;
	}

	public String getSectionName() {
		return sectionName;
	}

	public Context getContext() {
		return context;
	}

	@Override
	public String toString() {
		return "ReportRequestPart [sectionName=" + sectionName + ", context="
				+ context + "]";
	}

}
