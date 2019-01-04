/*
 * Copyright Benchmark Education Company
 *
 * (C) Copyright Benchmark	All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant here to is,
 *          and remains, the property of Benchmark.  Many of the
 *          intellectual and technical concepts contained herein are
 *          proprietary to Benchmark. Any dissemination of this
 *          information or reproduction of this material is strictly
 *          forbidden unless prior written permission is obtained
 *          from Benchmark.
 *
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 * Revision History
 * ========================================================================
 * DATE				: PROGRAMMER  : DESCRIPTION
 * ========================================================================
 * DEC 17 2018		: BEC       : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.socratesrpt.rest.model;

public class StudentTestScoreDetails {

	private String studentName;
	private String studentId;
	private String submitedDate;
	private String testScore;
	
	/**
	 * @return the testScore
	 */
	public String getTestScore() {
		return testScore;
	}
	/**
	 * @param testScore the testScore to set
	 */
	public void setTestScore(String testScore) {
		this.testScore = testScore;
	}
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
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentTestScoreDetails [studentName=" + studentName + ", studentId=" + studentId + ", submitedDate="
				+ submitedDate + ", testScore=" + testScore + ", testName=" + testName + "]";
	}
}
