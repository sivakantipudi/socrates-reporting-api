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
 * DEC 28 2018		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.socratesrpt.rest.model;

public class TestScoreDetails {
	
	private String avgScore;
	private String result;
	private String totalQuestions;
	private String testName;
	
	/**
	 * @return the avgScore
	 */
	public String getAvgScore() {
		return avgScore;
	}
	/**
	 * @param avgScore the avgScore to set
	 */
	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return the totalQuestions
	 */
	public String getTotalQuestions() {
		return totalQuestions;
	}
	/**
	 * @param totalQuestions the totalQuestions to set
	 */
	public void setTotalQuestions(String totalQuestions) {
		this.totalQuestions = totalQuestions;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestScoreDetails [avgScore=" + avgScore + ", result=" + result + ", totalQuestions=" + totalQuestions
				+ ", testName=" + testName + "]";
	}
}