/**
 * 
 */
package reportparser;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import report.Report;
import xmlskeleton.XMLReportSkeleton;
import xmlskeleton.XMLRootSkeleton;


public class XMLReportParser extends ReportParser {

	public XMLReportParser(String filePath) {
		super(filePath);
	}

	@Override
	public ArrayList<Report> getReports() {
		// TODO Auto-generated method stub
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(XMLRootSkeleton.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			File f = new File(getFilePath());
			XMLRootSkeleton root = (XMLRootSkeleton) jaxbUnmarshaller.unmarshal(f);

			ArrayList<Report> results = new ArrayList<Report>();
			for (XMLReportSkeleton repSkel : root.getReports()) {
				Report report = new Report(repSkel);
				results.add(report);

			}
			return results;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
