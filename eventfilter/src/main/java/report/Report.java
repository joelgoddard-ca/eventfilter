package report;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.csv.CSVRecord;
import org.json.simple.JSONObject;

import xmlskeleton.XMLReportSkeleton;

public class Report implements Comparable<Report>{

	private Long maxHoleSize;
	private Long packetsServiced;
	private Long packetsRequested;
	private String clientGUID;
	private String clientAddress;
	private Date requestTime;
	private String serviceGUID;
	private Long retriesRequest;
	
	public Report(JSONObject obj) {
		this.maxHoleSize = (Long) obj.get("max-hole-size");
		this.packetsRequested = (Long) obj.get("packets-requested");
		this.packetsServiced = (Long) obj.get("packets-serviced");
		this.clientGUID = (String) obj.get("client-guid");
		this.clientAddress = (String) obj.get("client-address");
		this.requestTime = new Date((Long) obj.get("request-time"));
		this.serviceGUID = (String) obj.get("service-guid");
		this.retriesRequest = (Long) obj.get("retries-request");
	}

	public Report(CSVRecord obj) {
		this.maxHoleSize = Long.valueOf(obj.get("max-hole-size"));
		this.packetsRequested = Long.valueOf(obj.get("packets-requested"));
		this.packetsServiced = Long.valueOf(obj.get("packets-serviced"));
		this.clientGUID = (String) obj.get("client-guid");
		this.clientAddress = (String) obj.get("client-address");
		
		this.retriesRequest = Long.valueOf(obj.get("retries-request"));
		
		try {
			//2016-06-29 07:22:30 ADT
			this.requestTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss z").parse(obj.get("request-time"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.serviceGUID = (String) obj.get("service-guid");
	}

	public Report(XMLReportSkeleton repSkel) {
		this.maxHoleSize = Long.valueOf(repSkel.getMaxHoleSize());
		this.packetsRequested = Long.valueOf(repSkel.getPacketsRequested());
		this.packetsServiced = Long.valueOf(repSkel.getPacketsServiced());
		this.clientGUID = repSkel.getClientGUID();
		this.clientAddress = repSkel.getClientAddress();
		
		this.retriesRequest = Long.valueOf(repSkel.getRetriesRequest());
		
		try {
			//2016-06-29 07:22:30 ADT
			this.requestTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss z").parse(repSkel.getRequestTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.serviceGUID = repSkel.getServiceGUID();
	
	}

	public Long getMaxHoleSize() {
		return maxHoleSize;
	}

	public void setMaxHoleSize(Long maxHoleSize) {
		this.maxHoleSize = maxHoleSize;
	}

	public Long getPacketsServiced() {
		return packetsServiced;
	}

	public void setPacketsServiced(Long packetsServiced) {
		this.packetsServiced = packetsServiced;
	}

	public Long getPacketsRequested() {
		return packetsRequested;
	}

	public void setPacketsRequested(Long packetsRequested) {
		this.packetsRequested = packetsRequested;
	}

	public String getClientGUID() {
		return clientGUID;
	}

	public void setClientGUID(String clientGUID) {
		this.clientGUID = clientGUID;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public String getServiceGUID() {
		return serviceGUID;
	}

	public void setServiceGUID(String serviceGUID) {
		this.serviceGUID = serviceGUID;
	}

	public Long getRetriesRequest() {
		return retriesRequest;
	}

	public void setRetriesRequest(Long retriesRequest) {
		this.retriesRequest = retriesRequest;
	}

	@Override
	public int compareTo(Report o) {
		return this.getRequestTime().compareTo(o.getRequestTime());
	}

}
