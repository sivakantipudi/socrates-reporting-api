package com.bec.socratesrpt.rest.model;

public class StudentTestScoreDetails {

	private String studentName;
	private String submitedDate;
	private String studentScore;
	
	private String testName;
	
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the submitedDate
	 */
	public String getSubmitedDate() {
		return submitedDate;
	}
	/**
	 * @param submitedDate the submitedDate to set
	 */
	public void setSubmitedDate(String submitedDate) {
		this.submitedDate = submitedDate;
	}
	/**
	 * @return the studentScore
	 */
	public String getStudentScore() {
		return studentScore;
	}
	/**
	 * @param studentScore the studentScore to set
	 */
	public void setStudentScore(String studentScore) {
		this.studentScore = studentScore;
	}
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
}
