package model;

public class Job {
	private String jobID;
	private String jobName;

	public Job() {
		super();
	}

	public Job(String jobID, String jobName) {
		super();
		this.jobID = jobID;
		this.jobName = jobName;
	}

	public String getjobID() {
		return jobID;
	}

	public void setjobID(String jobID) {
		this.jobID = jobID;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

}
