package reportparser;

import java.util.ArrayList;

import report.Report;

public abstract class ReportParser {

	private String filePath;

	public abstract ArrayList<Report> getReports();
	
	public ReportParser(String filePath) {this.setFilePath(filePath);}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
