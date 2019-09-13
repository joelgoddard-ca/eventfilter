package reportparser;

import java.io.FileReader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import report.Report;

public class CSVReportParser extends ReportParser {

	public CSVReportParser(String filePath) {
		super(filePath);
	}

	@Override
	public ArrayList<Report> getReports() {
		ArrayList<Report> reports = new ArrayList<Report>();

		FileReader reader;
		try {
			reader = new FileReader(super.getFilePath());

			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
			
			for (CSVRecord csvRecord : csvParser) {
				Report report = new Report(csvRecord);
				reports.add(report);
			}
			csvParser.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return reports;
	}

}
