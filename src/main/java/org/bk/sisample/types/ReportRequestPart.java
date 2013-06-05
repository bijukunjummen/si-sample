package org.bk.sisample.types;

public class ReportRequestPart {
	private final Section section;
	private final Context context;

	public ReportRequestPart(Section section, Context context) {
		this.section = section;
		this.context = context;
	}


	public Context getContext() {
		return context;
	}


	public Section getSection() {
    	return section;
    }


	@Override
    public String toString() {
	    return "ReportRequestPart [section=" + section + ", context=" + context + "]";
    }


}
