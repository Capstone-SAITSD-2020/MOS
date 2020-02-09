	package model;

public class Staff {

	private int sID;
	private String pin;
	private String isActive;
	private String fName;
	private String lName;
	private String contactNum;
	private int jobID;

	public Staff() {
		super();
	}

	public Staff(int sID, String pin, String isActive, String fName, String lName, String contactNum, int jobID) {
		super();
		this.sID = sID;
		this.pin = pin;
		this.isActive = isActive;
		this.fName = fName;
		this.lName = lName;
		this.contactNum = contactNum;
		this.jobID = jobID;
	}

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
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

	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
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
		return "Staff [sID=" + sID + ", pin=" + pin + ", isActive=" + isActive + ", fName=" + fName + ", lName=" + lName
				+ ", contactNum=" + contactNum + ", jobID=" + jobID + "]";
	}


		

}
