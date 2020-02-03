	package model;

public class Staff {

	private String sID;
	private String lName;
	private String fName;
	private String pin;
	private String jobID;
	private String contactNum;

	public Staff() {
		super();
	}

	public Staff(String sID, String lName, String fName, String pin, String jobID, String contactNum) {
		super();
		this.sID = sID;
		this.lName = lName;
		this.fName = fName;
		this.pin = pin;
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

	@Override
	public String toString() {
		return "Staff [sID=" + sID + ", lName=" + lName + ", fName=" + fName + ", pin=" + pin + ", jobID=" + jobID
				+ ", contactNum=" + contactNum + "]";
	}
	
	

}
