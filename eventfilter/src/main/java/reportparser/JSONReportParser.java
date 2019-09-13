package reportparser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import report.Report;

public class JSONReportParser extends ReportParser {
	
	public JSONReportParser(String filePath) {
		super(filePath);
	}

	private JSONArray getJSONArray() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();

		JSONArray array = (JSONArray) parser.parse(new FileReader(getFilePath()));
		return array;
	}

	@Override
	public ArrayList<Report> getReports() {
		ArrayList<Report> reports = new ArrayList<Report>();
		JSONArray jsonArray;
		try {
			jsonArray = getJSONArray();

			int length = jsonArray.size();

			for (int i = 0; i < length; i++) {
				JSONObject object = (JSONObject) jsonArray.get(i);
				//System.out.println(object);
				Report report = new Report(object);
				reports.add(report);

			}
			return reports;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
