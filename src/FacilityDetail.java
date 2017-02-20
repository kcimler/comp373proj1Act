
public class FacilityDetail {
	private String fAddress;
	private int floorNumber;
	private String fName;
	private int facilityId;
	private String buildingType;
	        

	public String getAddress() {
		return fAddress;
		}
	public void setFAddress(String fAddress) {
	    this.fAddress = fAddress;
	    }
	public int getFloorNumber() {
		return floorNumber;
	    }
	public void setFloorNumber(int floorNumber) {
	    this.floorNumber = floorNumber;
	    }
	public String getFName() {
	    return fName;
	    }
	public void setFName(String fName) {
	    this.fName = fName;
	    }

	public int getFacilityId() {
	    return facilityId;
	    }
	public void setFacilityId(int facilityId) {
	    this.facilityId = facilityId;
	    }
	public String getBuidingType() {
	    return buildingType;
	    }   
	 public void setBuidingType(String buildingType) {
	    this.buildingType = buildingType;
	    }
}
