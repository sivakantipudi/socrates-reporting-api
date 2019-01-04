package com.bec.socratesrpt.rest.model;

public class TestsModel{

	private String testName;
	private String testResults;
	private String testStartDate;
	private String testEndDate;
	/**
	 * @return the testName
	 */
	public String getTestName() {
		return testName;
	}
	/**
	 * @param testName the testName to set
	 */
	public void setTestName(String testName) {
		this.testName = testName;
	}
	/**
	 * @return the testResults
	 */
	public String getTestResults() {
		return testResults;
	}
	/**
	 * @param testResults the testResults to set
	 */
	public void setTestResults(String testResults) {
		this.testResults = testResults;
	}
	/**
	 * @return the testStartDate
	 */
	public String getTestStartDate() {
		return testStartDate;
	}
	/**
	 * @param testStartDate the testStartDate to set
	 */
	public void setTestStartDate(String testStartDate) {
		this.testStartDate = testStartDate;
	}
	/**
	 * @return the testEndDate
	 */
	public String getTestEndDate() {
		return testEndDate;
	}
	/**
	 * @param testEndDate the testEndDate to set
	 */
	public void setTestEndDate(String testEndDate) {
		this.testEndDate = testEndDate;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestsModel [testName=" + testName + ", testResults=" + testResults + ", testStartDate=" + testStartDate
				+ ", testEndDate=" + testEndDate + "]";
	}
}
