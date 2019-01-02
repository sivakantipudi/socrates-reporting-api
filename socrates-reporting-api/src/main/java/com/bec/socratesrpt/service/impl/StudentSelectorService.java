/*
 * Copyright Benchmark
 *
 * (C) Copyright Benchmark	All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant hereto is,
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
 * DEC 15 2018		: BEC       : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.socratesrpt.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@Override
	public List<StudentTestScoreDetails> getTestScoreByStudent(RestRequestVO requestVO){
		
		List<StudentTestScoreDetails> studentTestScoreList = new ArrayList<StudentTestScoreDetails>();
		
		StudentTestScoreDetails studentTestScoreDetails1 = new StudentTestScoreDetails();
		StudentTestScoreDetails studentTestScoreDetails2 = new StudentTestScoreDetails();
		StudentTestScoreDetails studentTestScoreDetails3 = new StudentTestScoreDetails();
		
		studentTestScoreDetails1.setTestName("interim 1");
		studentTestScoreDetails1.setStudentScore("35");
		studentTestScoreDetails1.setSubmitedDate("12/8/18");
		
		studentTestScoreDetails2.setTestName("unit1");
		studentTestScoreDetails2.setStudentScore("45");
		studentTestScoreDetails2.setSubmitedDate("09/9/18");
		
		studentTestScoreDetails3.setTestName("unit1 week2");
		studentTestScoreDetails3.setStudentScore("40");
		studentTestScoreDetails3.setSubmitedDate("08/10/18");
		
		studentTestScoreList.add(studentTestScoreDetails1);
		studentTestScoreList.add(studentTestScoreDetails2);
		studentTestScoreList.add(studentTestScoreDetails3);
		
		return studentTestScoreList;
	}
	
	@Override
	public Map<String,List<Object>> getTestScoresByClass(){
		
		Map<String,List<Object>> testNameByStudentTestDetails = new HashMap<String,List<Object>>();
		List<StudentTestScoreDetails> StudentTestScoreDetailsList = new ArrayList<StudentTestScoreDetails>();
		
		List<StudentTestScoreDetails> StudentTestScoreDetailsList1 = new ArrayList<StudentTestScoreDetails>();
		
		List<Object> objectList = new ArrayList<Object>();
		
		List<Object> objectList1 = new ArrayList<Object>();
		
		TestDetails testDetails = new TestDetails();
		testDetails.setTestName("test1");
		testDetails.setTotalTestScore("80");
		
		TestDetails testDetails1 = new TestDetails();
		testDetails1.setTestName("test2");
		testDetails1.setTotalTestScore("70");
		
		StudentTestScoreDetails studentTestScoreDetails = new StudentTestScoreDetails();
		studentTestScoreDetails.setStudentName("sivaram");
		studentTestScoreDetails.setStudentScore("80");
		studentTestScoreDetails.setSubmitedDate("3/5/18");
		
		StudentTestScoreDetails studentTestScoreDetails1 = new StudentTestScoreDetails();
		studentTestScoreDetails1.setStudentName("Sandeep");
		studentTestScoreDetails1.setStudentScore("80");
		studentTestScoreDetails1.setSubmitedDate("3/5/18");
		
		StudentTestScoreDetails studentTestScoreDetails2 = new StudentTestScoreDetails();
		studentTestScoreDetails2.setStudentName("Dinesh");
		studentTestScoreDetails2.setStudentScore("70");
		studentTestScoreDetails2.setSubmitedDate("3/5/18");
		
		StudentTestScoreDetails studentTestScoreDetails3 = new StudentTestScoreDetails();
		studentTestScoreDetails3.setStudentName("Rajesh");
		studentTestScoreDetails3.setStudentScore("70");
		studentTestScoreDetails3.setSubmitedDate("3/5/18");
		
		StudentTestScoreDetailsList.add(studentTestScoreDetails);
		StudentTestScoreDetailsList.add(studentTestScoreDetails1);
		
		StudentTestScoreDetailsList1.add(studentTestScoreDetails2);
		StudentTestScoreDetailsList1.add(studentTestScoreDetails3);
		
		objectList.add(testDetails);
		objectList.add(StudentTestScoreDetailsList);
		
		objectList1.add(testDetails1);
		objectList1.add(StudentTestScoreDetailsList1);
		
		testNameByStudentTestDetails.put("test1", objectList);
		testNameByStudentTestDetails.put("test2", objectList1);
		
		return testNameByStudentTestDetails;
	}
}
