package xmlskeleton;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * @author Joel
 *Bean-like class for mapping XML elements to Objects
 */
@XmlRootElement(name = "report")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLReportSkeleton {
	
	@XmlElement(name = "max-hole-size")
	private String maxHoleSize;
	
	@XmlElement(name = "packets-serviced")
	private String packetsServiced;
	
	@XmlElement(name = "packets-requested")
	private String packetsRequested;
	
	@XmlElement(name = "client-guid")
	private String clientGUID;
	
	@XmlElement(name = "client-address")
	private String clientAddress;
	
	@XmlElement(name = "request-time")
	private String requestTime;
	
	@XmlElement(name = "service-guid")
	private String serviceGUID;
	
	@XmlElement(name = "retries-request")
	private String retriesRequest;
	
	public String getMaxHoleSize() {
		return maxHoleSize;
	}
	
	public void setMaxHoleSize(String maxHoleSize) {
		this.maxHoleSize = maxHoleSize;
	}
	public String getPacketsServiced() {
		return packetsServiced;
	}
	public void setPacketsServiced(String packetsServiced) {
		this.packetsServiced = packetsServiced;
	}
	public String getPacketsRequested() {
		return packetsRequested;
	}
	public void setPacketsRequested(String packetsRequested) {
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
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	public String getServiceGUID() {
		return serviceGUID;
	}
	public void setServiceGUID(String serviceGUID) {
		this.serviceGUID = serviceGUID;
	}
	public String getRetriesRequest() {
		return retriesRequest;
	}
	public void setRetriesRequest(String retriesRequest) {
		this.retriesRequest = retriesRequest;
	}
}
