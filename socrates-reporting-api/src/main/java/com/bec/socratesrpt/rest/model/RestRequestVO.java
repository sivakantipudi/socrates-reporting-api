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

import java.util.Arrays;

public class RestRequestVO {

	private String studentId;
	private String classId;
	private String schoolId;
	private String districtId;
	private String jwtToken;
	private String userId;
	private String districtTerm;
	private Object[] testsArray;
	private String testId;
	
	
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
	/**
	 * @return the classId
	 */
	public String getClassId() {
		return classId;
	}
	/**
	 * @param classId the classId to set
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}
	/**
	 * @return the schoolId
	 */
	public String getSchoolId() {
		return schoolId;
	}
	/**
	 * @param schoolId the schoolId to set
	 */
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	/**
	 * @return the districtId
	 */
	public String getDistrictId() {
		return districtId;
	}
	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	/**
	 * @return the jwtToken
	 */
	public String getJwtToken() {
		return jwtToken;
	}
	/**
	 * @param jwtToken the jwtToken to set
	 */
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the districtTerm
	 */
	public String getDistrictTerm() {
		return districtTerm;
	}
	/**
	 * @param districtTerm the districtTerm to set
	 */
	public void setDistrictTerm(String districtTerm) {
		this.districtTerm = districtTerm;
	}
	/**
	 * @return the testsArray
	 */
	public Object[] getTestsArray() {
		return testsArray;
	}
	/**
	 * @param testsArray the testsArray to set
	 */
	public void setTestsArray(Object[] testsArray) {
		this.testsArray = testsArray;
	}
	
	/**
	 * @return the testId
	 */
	public String getTestId() {
		return testId;
	}
	/**
	 * @param testId the testId to set
	 */
	public void setTestId(String testId) {
		this.testId = testId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RestRequestVO [studentId=" + studentId + ", classId=" + classId + ", schoolId=" + schoolId
				+ ", districtId=" + districtId + ", jwtToken=" + jwtToken + ", userId=" + userId + ", districtTerm="
				+ districtTerm + ", testsArray=" + Arrays.toString(testsArray) + ", testId=" + testId + "]";
	}
}
