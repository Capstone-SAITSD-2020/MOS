package model;

public class Staff {

	String staffId;
	String staffName;
	String staffPin;

	public Staff(String staffId, String staffName, String staffPin) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffPin = staffPin;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffPin() {
		return staffPin;
	}

	public void setStaffPin(String staffPin) {
		this.staffPin = staffPin;
	}

}
