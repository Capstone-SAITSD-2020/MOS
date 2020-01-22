package model;

public class Staff {

	private String staffID;
	private String staffName;
	private String staffPin;

	public Staff() {
		super();
	}

	public Staff(String staffID, String staffName, String staffPin) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.staffPin = staffPin;
	}

	public String getstaffID() {
		return staffID;
	}

	public void setstaffID(String staffID) {
		this.staffID = staffID;
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
