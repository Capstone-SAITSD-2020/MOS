	package model;

public class Staff {

	private String sID;
	private String pin;
	private String isActive;
	private String lName;
	private String fName;

	private String jobID;
	private String contactNum;

	public Staff() {
		super();
	}

	public Staff(String sID, String pin, String isActive, String lName, String fName,  String jobID, String contactNum) {
		super();
		this.sID = sID;
		this.pin = pin;
		this.isActive = isActive;
		this.lName = lName;
		this.fName = fName;
		this.jobID = jobID;
		this.contactNum = contactNum;
	}

	public String getsID() {
		return sID;
	}

	public void setsID(String sID) {
		this.sID = sID;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getJobID() {
		return jobID;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Staff [sID=" + sID + ", pin=" + pin + ", isActive=" + isActive + ", lName=" + lName + ", fName=" + fName
				+ ", jobID=" + jobID + ", contactNum=" + contactNum + "]";
	}

		

}
