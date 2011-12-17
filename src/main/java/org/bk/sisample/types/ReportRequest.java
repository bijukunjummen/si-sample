package org.bk.sisample.types;

import java.util.List;

public class ReportRequest {
	private final List<ReportRequestPart> requestParts;

	public ReportRequest(List<ReportRequestPart> requestParts) {
		super();
		this.requestParts = requestParts;
	}

	@Override
	public String toString() {
		return "ReportRequest [requestParts=" + requestParts + "]";
	}

	public List<ReportRequestPart> getRequestParts() {
		return requestParts;
	}
	
	
	
}
