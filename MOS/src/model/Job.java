package model;

public class Job {
	String jobId;
	String jobName;

	public Job(String jobId, String jobName) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

}
