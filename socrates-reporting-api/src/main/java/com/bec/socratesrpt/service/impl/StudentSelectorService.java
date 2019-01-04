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
package com.bec.socratesrpt.service.impl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.bec.socratesrpt.core.exception.BenchmarkException;
import com.bec.socratesrpt.core.logger.Log;
import com.bec.socratesrpt.iservice.IStudentSelectorService;
import com.bec.socratesrpt.rest.model.ClassList;
import com.bec.socratesrpt.rest.model.RestRequestVO;
import com.bec.socratesrpt.rest.model.School;
import com.bec.socratesrpt.rest.model.Student;
import com.bec.socratesrpt.rest.model.StudentTestScoreDetails;
import com.bec.socratesrpt.rest.model.TestDetails;
import com.bec.socratesrpt.rest.model.TestScoreDetails;
import com.bec.socratesrpt.rest.model.TestsModel;

@Service
public class StudentSelectorService implements IStudentSelectorService{
	
	private static Log logger = com.bec.socratesrpt.core.logger.Logger.getLogger(StudentSelectorService.class);
	
	ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Override
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<School> getSchoolListByUserId(Integer userId, String sessionKey, String role){
		
		List<School> schoolList = null;
		
		String schoolListJson = "[{\"name\":\"Vijaya High School\",\"id\":\"BEC12\",\"address\":\"Aditya Nagar\"},{\"name\":\"St Andrews School\",\"id\":\"BEC13\",\"address\":\"Bowenpally\"},{\"name\":\"Delhi Public School\",\"id\":\"BEC14\",\"address\":\"Nacharam\"}]";
		
		try {
			schoolList = OBJECT_MAPPER.readValue(schoolListJson,OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, School.class));
		} catch (IOException e) {
			BenchmarkException.printExceptionTraceToLogFile(e, logger);
		}
		return schoolList;
	}
	
	@Override
	public List<ClassList> getClassListBySchoolId(Integer userId, String sessionKey, String role, String schoolId) {

		List<ClassList> classList = null;
		String classListJSON = "[{\"name\": \"English Literature\",\"id\":\"CL11\"},{\"name\": \"Hindi\",\"id\":\"CL12\"},{\"name\": \"Telugu\",\"id\":\"CL13\"},{\"name\":\"French\",\"id\":\"CL1\"},{\"name\":\"Spanish\",\"id\":\"CL15\"}]";
		try {
			classList = OBJECT_MAPPER.readValue(classListJSON, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, ClassList.class));
		}catch(Exception e) {
			BenchmarkException.printExceptionTraceToLogFile(e, logger);
		}
		return classList;
	}

	@Override
	public List<Student> getStudentListByClassId(Integer userId, String sessionKey, String role, String schoolId, String classId) {

		List<Student> studentList = null;
		String studentListJSON = "[{\"name\": \"Rahul Kanihal\",\"id\": \"ST12\",\"school\": \"Kendriya Vidayala\"},"+
				"{\"name\": \"Raheem Sheik\",\"id\":  \"ST13\",\"school\": \"Kendriya Vidayala\"}," + 
				"{\"name\": \"Prashant\",\"id\":  \"ST14\",\"school\": \"Kendriya Vidayala\"}," + 
				"{\"name\": \"Raj Kumar\",\"id\":  \"ST15\",\"school\": \"Kendriya Vidayala\"}," + 
				"{\"name\": \"Naresh Poola\",\"id\":  \"ST16\",\"school\": \"Kendriya Vidayala\"}," + 
				"{\"name\": \"Sam Ikkurty\",\"id\": \"ST17\",\"school\": \"Kendriya Vidayala\"}," + 
				"{\"name\": \"Satish Nampally\",\"id\":  \"ST18\",\"school\": \"Kendriya Vidayala\"}]";
		try {
			studentList = OBJECT_MAPPER.readValue(studentListJSON, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Student.class));
		}catch(Exception e) {
			BenchmarkException.printExceptionTraceToLogFile(e, logger);
		}
		return studentList;
	}
	
	/**
	 * fetches test score list based on student selected
	 * @param userId logged in user ID
	 * @return StudentTestScoreDetails
	 */
	@Override
	public List<StudentTestScoreDetails> getTestScoreByStudent(RestRequestVO requestVO){
		
		List<StudentTestScoreDetails> studentTestScoreList = null;
		
		String testScoreByStudentJSON = 
				 
				"[" + 
				"{" + 
				"\"testName\":\"interim1\"," + 
				"\"testScore\":\"35\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"unit1\"," + 
				"\"testScore\":\"45\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"unit 1 week 2\"," + 
				"\"testScore\":\"40\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"unit 1 week 3\"," + 
				"\"testScore\":\"40\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"" + 
				"{" + 
				"\"testName\":\"unit 2\"," + 
				"\"testScore\":\"50\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"unit 2 week 1\"," + 
				"\"testScore\":\"55\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"unit 2 week 2\"," + 
				"\"testScore\":\"50\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"interim 2\"," + 
				"\"testScore\":\"65\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"unit 3\"," + 
				"\"testScore\":\"70\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"unit 3 week 1\"," + 
				"\"testScore\":\"80\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"unit 3 week 2\"," + 
				"\"testScore\":\"58\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"unit 3 week 3\"," + 
				"\"testScore\":\"52\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"unit 4\"," + 
				"\"testScore\":\"40\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"unit 4 week 1\"," + 
				"\"testScore\":\"40\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"unit 4 week 2\"," + 
				"\"testScore\":\"50\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"unit 4 week 3\"," + 
				"\"testScore\":\"55\"," + 
				"\"submitedDate\":\"3/24/18\"" + 
				"}" + 
				"]";
		
		try {
			studentTestScoreList = OBJECT_MAPPER.readValue(testScoreByStudentJSON, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, StudentTestScoreDetails.class));
		}catch(Exception e) {
			BenchmarkException.printExceptionTraceToLogFile(e, logger);
		}
		return studentTestScoreList;
	}
	
	@Override
	public List<TestsModel> getTestsForUniverse(RestRequestVO requestObj) {
		List<TestsModel> testsList = null;
		String testsJSON = "[{" + 
				"\"testName\":\"Interim1\"," + 
				"\"testResults\":\"30\"," + 
				"\"testStartDate\":\"02-02-2018\"," + 
				"\"testEndDate\":\"02-03-2018\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"Unit 1\"," + 
				"\"testResults\":\"35\"," + 
				"\"testStartDate\":\"02-04-2018\", " + 
				"\"testEndDate\":\"02-05-2018\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"Unit 1 Week 2\"," + 
				"\"testResults\":\"40\"," + 
				"\"testStartDate\":\"02-06-2018\", " + 
				"\"testEndDate\":\"02-07-2018\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"Unit 2\"," + 
				"\"testResults\":\"30\"," + 
				"\"testStartDate\":\"02-08-2018\", " + 
				"\"testEndDate\":\"02-09-2018\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"Unit 2 Week 2\"," + 
				"\"testResults\":\"40\"," + 
				"\"testStartDate\":\"02-10-2018\"," + 
				"\"testEndDate\":\"02-11-2018\"" + 
				"}," + 
				"{" + 
				"\"testName\":\"Interim2\"," + 
				"\"testResults\":\"45\"," + 
				"\"testStartDate\":\"02-12-2018\"," + 
				"\"testEndDate\":\"02-13-2018\"" + 
				"}]";
		
		try {
			testsList = OBJECT_MAPPER.readValue(testsJSON, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, TestsModel.class));
		}catch(Exception e) {
			BenchmarkException.printExceptionTraceToLogFile(e, logger);
		}
		return testsList;
	}
	
	/**
	 * fetches test score list based on class selected
	 * @param userId logged in user ID
	 * @return TestScoreDetails
	 */
	@Override
	public List<TestScoreDetails> getTestScoreByClass(RestRequestVO requestVO){
		
		List<TestScoreDetails> testScoresClassList = null;
		
		String getTestScoreByClassJSON = "[{" + 
				"\"avgScore\":30," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"interim1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":40," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":35," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 1 week 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":35," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 1 week 3\"" + 
				"}," + 
				"" + 
				"{" + 
				"\"avgScore\":45," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":50," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 2 week 1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":45," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 2 week 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":60," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"interim2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":65," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 3\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":75," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 3 week 1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":53," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 3 week 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":47," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 3 week 3\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":35," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 4\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":35," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 4 week 1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":45," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 4 week 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":50," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 4 week 3\"" + 
				"}]";
		
		try {
			testScoresClassList = OBJECT_MAPPER.readValue(getTestScoreByClassJSON, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, TestScoreDetails.class));
		}catch(Exception e) {
			BenchmarkException.printExceptionTraceToLogFile(e, logger);
		}
		return testScoresClassList;
	}
	
	/**
	 * fetches test score list based on school selected
	 * @param userId logged in user ID
	 * @return TestScoreDetails
	 */
	@Override
	public List<TestScoreDetails> getTestScoreBySchool(RestRequestVO requestVO){

		List<TestScoreDetails> testScoresSchoolList = null;

		String getTestScoreBySchoolJSON = "[{" + 
				"\"avgScore\":25," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"interim1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":35," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":30," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 1 week 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":30," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 1 week 3\"" + 
				"}," + 
				"" + 
				"{" + 
				"\"avgScore\":40," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":45," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 2 week 1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":40," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 2 week 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":55," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"interim2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":60," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 3\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":70," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 3 week 1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":48," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 3 week 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":42," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 3 week 3\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":30," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 4\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":30," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 4 week 1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":40," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 4 week 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":45," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 4 week 3\"" + 
				"}]";

		try {
			testScoresSchoolList = OBJECT_MAPPER.readValue(getTestScoreBySchoolJSON, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, TestScoreDetails.class));
		}catch(Exception e) {
			BenchmarkException.printExceptionTraceToLogFile(e, logger);
		}
		return testScoresSchoolList;
	}
	
	/**
	 * fetches test score list based on district selected
	 * @param userId logged in user ID
	 * @return TestScoreDetails
	 */
	@Override
	public List<TestScoreDetails> getTestScoreByDistrict(RestRequestVO requestVO){
		
		List<TestScoreDetails> testScoresDistrictList = null;
		
		String getTestScoreByDistrictJSON = "[{" + 
				"\"avgScore\":20," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"interim1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":30," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":25," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 1 week 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":25," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 1 week 3\"" + 
				"}," + 
				"" + 
				"{" + 
				"\"avgScore\":35," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":40," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 2 week 1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":35," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 2 week 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":50," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"interim2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":55," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 3\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":65," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 3 week 1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":43," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 3 week 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":37," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 3 week 3\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":25," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 4\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":25," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 4 week 1\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":35," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 4 week 2\"" + 
				"}," + 
				"{" + 
				"\"avgScore\":40," + 
				"\"result\":30," + 
				"\"totalQuestions\":20," + 
				"\"testName\":\"unit 4 week 3\"" + 
				"}]";

		try {
			testScoresDistrictList = OBJECT_MAPPER.readValue(getTestScoreByDistrictJSON, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, TestScoreDetails.class));
		}catch(Exception e) {
			BenchmarkException.printExceptionTraceToLogFile(e, logger);
		}
		return testScoresDistrictList;
	}
	
	@Override
	public List<TestDetails> getOverTimeTestScores(RestRequestVO requestVO){
		List<TestDetails> overTimeClassTestScoreList = new LinkedList<TestDetails>();

		String overTimeClassTestScoresJSON = 

				"[" + 
						"{" + 
						"\"testName\":\"interim1\"," + 
						"\"testScore\":\"35\"," + 
						"}," + 
						"{" + 
						"\"testName\":\"unit1\"," + 
						"\"testScore\":\"45\"," + 
						"}," + 
						"{" + 
						"\"testName\":\"unit 1 week 2\"," + 
						"\"testScore\":\"40\"," + 
						"}," + 
						"{" + 
						"\"testName\":\"unit 1 week 3\"," + 
						"\"testScore\":\"40\"," + 
						"}," + 
						"" + 
						"{" + 
						"\"testName\":\"unit 2\"," + 
						"\"testScore\":\"50\"," + 
						"}," + 
						"{" + 
						"\"testName\":\"unit 2 week 1\"," + 
						"\"testScore\":\"55\"," + 
						"}," + 
						"{" + 
						"\"testName\":\"unit 2 week 2\"," + 
						"\"testScore\":\"50\"," + 
						"}," + 
						"{" + 
						"\"testName\":\"interim 2\"," + 
						"\"testScore\":\"65\"," + 
						"}," + 
						"{" + 
						"\"testName\":\"unit 3\"," + 
						"\"testScore\":\"70\"," + 
						"}," + 
						"{" + 
						"\"testName\":\"unit 3 week 1\"," + 
						"\"testScore\":\"80\"," + 
						"}," + 
						"{" + 
						"\"testName\":\"unit 3 week 2\"," + 
						"\"testScore\":\"58\"," + 
						"}," + 
						"{" + 
						"\"testName\":\"unit 3 week 3\"," + 
						"\"testScore\":\"52\"," + 
						"}," + 
						"{" + 
						"\"testName\":\"unit 4\"," + 
						"\"testScore\":\"40\"," + 
						"}," + 
						"{" + 
						"\"testName\":\"unit 4 week 1\"," + 
						"\"testScore\":\"40\"," + 
						"}," + 
						"{" + 
						"\"testName\":\"unit 4 week 2\"," + 
						"\"testScore\":\"50\"," + 
						"}," + 
						"{" + 
						"\"testName\":\"unit 4 week 3\"," + 
						"\"testScore\":\"55\"," + 
						"}" + 
						"]";

		try {
			overTimeClassTestScoreList = OBJECT_MAPPER.readValue(overTimeClassTestScoresJSON, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, TestDetails.class));
		}catch(Exception e) {
			BenchmarkException.printExceptionTraceToLogFile(e, logger);
		}

		return overTimeClassTestScoreList;
	}
	
	@Override
	public List<StudentTestScoreDetails> getStudentScoreDetailsByTest(RestRequestVO requestVO){
		 
		List<StudentTestScoreDetails> studentTestScoresList = null;
		
		String studentTestScoresJSON = 
				 
				"[" + 
				"{" + 
				"\"studentName\":\"Thomas\"," + 
				"\"studentId\":\"1\"," + 
				"\"submitedDate\":\"3/5/18\"," +
				"\"testScore\":\"90\"" +
				"}," + 
				"{" + 
				"\"studentName\":\"Hallie\"," + 
				"\"studentId\":\"2\"," + 
				"\"submitedDate\":\"3/10/18\"," +
				"\"testScore\":\"85\"" + 
				"}," + 
				"{" + 
				"\"studentName\":\"Oliver\"," + 
				"\"studentId\":\"3\"," + 
				"\"submitedDate\":\"3/10/18\"," +
				"\"testScore\":\"78\"" + 
				"}," + 
				"{" + 
				"\"studentName\":\"Hayden\"," + 
				"\"studentId\":\"4\"," + 
				"\"submitedDate\":\"3/11/18\"," +
				"\"testScore\":\"60\"" + 
				"}," + 
				"" + 
				"{" + 
				"\"studentName\":\"Ava\"," + 
				"\"studentId\":\"5\"," + 
				"\"submitedDate\":\"3/12/18\"," +
				"\"testScore\":\"55\"" + 
				"}," + 
				"{" + 
				"\"studentName\":\"Yasi\"," + 
				"\"studentId\":\"6\"," + 
				"\"submitedDate\":\"3/24/18\"," +
				"\"testScore\":\"50\"" + 
				"}," + 
				"{" + 
				"\"studentName\":\"Edith\"," + 
				"\"studentId\":\"7\"," + 
				"\"submitedDate\":\"3/9/18\"," +
				"\"testScore\":\"30\"" + 
				"}," + 
				"{" + 
				"\"studentName\":\"Darious\"," + 
				"\"studentId\":\"8\"," + 
				"\"submitedDate\":\"3/7/18\"," +
				"\"testScore\":\"23\"" + 
				"}," + 
				"{" + 
				"\"studentName\":\"Emma Watson\"," + 
				"\"studentId\":\"9\"," + 
				"\"submitedDate\":\"3/10/18\"," +
				"\"testScore\":\"22\"" +
				"}," + 
				"{" + 
				"\"studentName\":\"Hendrik\"," + 
				"\"studentId\":\"10\"," + 
				"\"submitedDate\":\"3/11/18\"," +
				"\"testScore\":\"22\"" +
				"}," + 
				"{" + 
				"\"studentName\":\"Jollin\"," + 
				"\"studentId\":\"11\"," + 
				"\"submitedDate\":\"3/9/18\"," +
				"\"testScore\":\"21\"" + 
				"}," + 
				"{" + 
				"\"studentName\":\"Ritwik\"," + 
				"\"studentId\":\"12\"," + 
				"\"submitedDate\":\"3/11/18\"," +
				"\"testScore\":\"20\"" + 
				"}," + 
				"]";
		
		try {
			studentTestScoresList = OBJECT_MAPPER.readValue(studentTestScoresJSON, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, StudentTestScoreDetails.class));
		}catch(Exception e) {
			BenchmarkException.printExceptionTraceToLogFile(e, logger);
		}
		
		return studentTestScoresList;
	}
	
}