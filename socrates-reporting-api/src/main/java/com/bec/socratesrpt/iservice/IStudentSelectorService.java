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
 * DEC 15 2018		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.socratesrpt.iservice;

import java.util.List;
import com.bec.socratesrpt.rest.model.ClassList;
import com.bec.socratesrpt.rest.model.RestRequestVO;
import com.bec.socratesrpt.rest.model.School;
import com.bec.socratesrpt.rest.model.Student;
import com.bec.socratesrpt.rest.model.StudentTestScoreDetails;
import com.bec.socratesrpt.rest.model.TestDetails;
import com.bec.socratesrpt.rest.model.TestScoreDetails;
import com.bec.socratesrpt.rest.model.TestsModel;

public interface IStudentSelectorService {

	/**
	 * 
	 * fetches School List in Universal Selector, while student tab is selected
	 * @param userId logged in user ID
	 * @param sessionKey session key which manages the authorization
	 * @param role role of the logged in user (BEC admin/ teacher/ school admin/ district admin)
	 * @return school list object
	 */
	List<School> getSchoolListByUserId(Integer userId, String sessionKey, String role);

	/**
	 * 
	 * fetches class List in Universal Selector, while student tab is selected
	 * @param userId logged in user ID
	 * @param sessionKey session key which manages the authorization
	 * @param role role of the logged in user (BEC admin/ teacher/ school admin/ district admin)
	 * @param schoolId the ID of school which is selected from the school List.
	 * @return class list object
	 */
	List<ClassList> getClassListBySchoolId(Integer userId, String sessionKey, String role, String schoolId);

	/**
	 * fetches student list based on school and class selected
	 * @param userId logged in user ID
	 * @param sessionKey session key which manages the authorization
	 * @param role role of the logged in user (BEC admin/ teacher/ school admin/ district admin)
	 * @param schoolId the ID of school which is selected from the school List.
	 * @param classId the ID of class which is selected
	 * @return
	 */
	List<Student> getStudentListByClassId(Integer userId, String sessionKey, String role, String schoolId, String classId);

	/**
	 * fetches test score list based on student selected
	 * @param userId logged in user ID
	 * @return StudentTestScoreDetails
	 */
	List<StudentTestScoreDetails> getTestScoreByStudent(RestRequestVO requestVO);
	
	/**
	 * fetches test score list based on class selected
	 * @param userId logged in user ID
	 * @return TestScoreDetails
	 */
	List<TestScoreDetails> getTestScoreByClass(RestRequestVO requestVO);
	
	/**
	 * fetches test score list based on school selected
	 * @param userId logged in user ID
	 * @return TestScoreDetails
	 */
	List<TestScoreDetails> getTestScoreBySchool(RestRequestVO requestVO);
	
	/**
	 * fetches test score list based on district selected
	 * @param userId logged in user ID
	 * @return TestScoreDetails
	 */
	List<TestScoreDetails> getTestScoreByDistrict(RestRequestVO requestVO);
	
	/**
	 * fetches tests list if context is for a single class or student, the total number 
	 * of tests listed will only be the universe of tests for which test data is available in the District Term selected.
	 * @param Object The request object
	 * @return
	 */
	List<TestsModel> getTestsForUniverse(RestRequestVO requestObj);

	/**
	 * fetches over time test scores details 
	 * @param userId logged in user ID
	 * @return TestDetails
	 */
	List<TestDetails> getOverTimeTestScores(RestRequestVO requestVO);

	/**
	 * fetches student score details by test 
	 * @param userId logged in user ID
	 * @return StudentTestScoreDetails
	 */
	List<StudentTestScoreDetails> getStudentScoreDetailsByTest(RestRequestVO requestVO);

}