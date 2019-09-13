package xmlskeleton;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "records")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLRootSkeleton {
	
	@XmlElement(name = "report")
	private ArrayList<XMLReportSkeleton> reports;

	public ArrayList<XMLReportSkeleton> getReports() {
		return reports;
	}

	public void setReports(ArrayList<XMLReportSkeleton> reportsIn) {
		this.reports = reportsIn;
	}
	
	
}
