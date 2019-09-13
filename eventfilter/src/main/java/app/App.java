package app;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.JAXBException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.json.simple.parser.ParseException;

import report.Report;
import reportparser.CSVReportParser;
import reportparser.JSONReportParser;
import reportparser.XMLReportParser;

public class App {

	private static void write(List<Report> reports) throws IOException {

		
		BufferedWriter writer = Files
				.newBufferedWriter(Paths.get("C:/Users/Joel/Desktop/reportFiles/eventfilter-master/output.csv"));

		CSVPrinter csvPrinter = new CSVPrinter(writer,
				CSVFormat.DEFAULT.withHeader("client-address", "client-guid", "request-time", "service-guid",
						"retries-request", "packets-requested", "packets-serviced", "max-hole-size"));

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss z");

		for (Report report : reports) {
			csvPrinter.printRecord(report.getClientAddress(), report.getClientGUID(),
					dateFormat.format(report.getRequestTime()), report.getServiceGUID(), report.getRetriesRequest(),
					report.getPacketsRequested(), report.getPacketsServiced(), report.getMaxHoleSize());
		}

		writer.close();
		csvPrinter.close();
	}

	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException, JAXBException {

		
		String folderPath = "./";
		if (args.length != 0) {
			folderPath = args[0];
		}

		String jsonPath = folderPath + "reports.json";
		String csvPath = folderPath + "reports.csv";
		String xmlPath = folderPath + "reports.xml";
		
		
		JSONReportParser jsonParser = new JSONReportParser(jsonPath);
		ArrayList<Report> jsonReports = jsonParser.getReports();

		CSVReportParser csvParser = new CSVReportParser(csvPath);
		ArrayList<Report> csvReports = csvParser.getReports();

		XMLReportParser xmlParser = new XMLReportParser(xmlPath);
		ArrayList<Report> xmlReports = xmlParser.getReports();

		ArrayList<Report> merged = new ArrayList<Report>();

		merged.addAll(jsonReports);
		merged.addAll(xmlReports);
		merged.addAll(csvReports);

		merged.removeIf(rep -> rep.getPacketsServiced() == 0L);

		Collections.sort(merged);

		write(merged);

		HashMap<String, Integer> counts = new HashMap<>();

		for (Report report : merged) {
			if (counts.containsKey(report.getServiceGUID())) {

				Integer val = counts.get(report.getServiceGUID());
				counts.replace(report.getServiceGUID(), ++val);
			} else {
				counts.put(report.getServiceGUID(), 1);
			}
		}

		System.out.println("Record counts by service-guid:");

		counts.forEach((K, V) -> {
			System.out.println(K + ": " + V);
		});
	}
}
