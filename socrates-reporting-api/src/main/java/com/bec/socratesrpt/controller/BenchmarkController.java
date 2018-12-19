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
 * DEC 12 2018		: BEC       : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.socratesrpt.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bec.socratesrpt.core.common.Constants;
import com.bec.socratesrpt.core.logger.Log;
import com.bec.socratesrpt.iservice.IStudentSelectorService;
import com.bec.socratesrpt.rest.model.ClassList;
import com.bec.socratesrpt.rest.model.RestResponseVO;
import com.bec.socratesrpt.rest.model.School;
import com.bec.socratesrpt.rest.model.Student;

@RestController
@RequestMapping("/api")
public class BenchmarkController {
	
	@Autowired
	private IStudentSelectorService studentService;
	
	private static Log logger = com.bec.socratesrpt.core.logger.Logger.getLogger(BenchmarkController.class);

	/**
	 *method used to get schools list
	 * @param  userId, sessionKey, role
	 * @return JSON
	 */
	@RequestMapping(value = "/getSchoolList", method = RequestMethod.GET)
	public RestResponseVO getSchoolList(@RequestParam Integer userId, @RequestParam String sessionKey, @RequestParam String role) {
		
		long startTime = logger.logPMTBegin("Get school list begin :", true);
		RestResponseVO restResponseVO = new RestResponseVO();
		
		try {
			List<School> schoolList = studentService.getSchoolListByUserId(userId, sessionKey, role);
			if (schoolList.size() > Constants.ZERO) {
				restResponseVO.setValue(schoolList);
			} else {
				restResponseVO.setStatusDescription("Required school list not available...!");
			}
			restResponseVO.setStatusCode(200);//status code have move to constants
			restResponseVO.setSessionKey(sessionKey);
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.SUCCESS.name());
		}catch (Exception e) {
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
			restResponseVO.setStatusCode(400);
			restResponseVO.setStatusDescription(e.getMessage());
		}
		logger.logPMTEnd("Get school list end :", startTime, true);
		return restResponseVO;
	}
	
	/**
	 * API method used to get classes list
	 * @param  userId, sessionKey, role, schoolId
	 * @return JSON
	 */

	@RequestMapping(value = "/getClassList", method = RequestMethod.GET)
	public RestResponseVO getClassList(@RequestParam Integer userId, @RequestParam String sessionKey, @RequestParam String role, @RequestParam String schoolId) {

		long startTime = logger.logPMTBegin("Get class list begin :", true);

		RestResponseVO restResponseVO = new RestResponseVO();
		try {
			List<ClassList> classList = studentService.getClassListBySchoolId(userId, sessionKey, role, schoolId);
			if (classList.size() > Constants.ZERO) {

				restResponseVO.setValue(classList);
			} else {
				restResponseVO.setStatusDescription("Required class list not available...!");
			}
			restResponseVO.setSessionKey(sessionKey);
			restResponseVO.setStatusCode(200);
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.SUCCESS.name());
		}catch (Exception e) {
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
			restResponseVO.setStatusCode(400);
			restResponseVO.setStatusDescription(e.getMessage());
		}
		logger.logPMTEnd("Get class list end :", startTime, true);
		return restResponseVO;
	}
	

	/**
	 * API method used to get students list
	 * @param  userId, sessionKey, role, schoolId, classId
	 * @return JSON
	 */

	@RequestMapping(value = "/getStudentList", method = RequestMethod.GET)
	public RestResponseVO getStudentList(@RequestParam Integer userId, @RequestParam String sessionKey, @RequestParam String role, @RequestParam String schoolId, @RequestParam String classId) {

		long startTime = logger.logPMTBegin("Get student list begin :", true);

		RestResponseVO restResponseVO = new RestResponseVO();
		try {
			List<Student> studentList = studentService.getStudentListByClassId(userId, sessionKey, role, schoolId, classId);

			if (studentList.size() > Constants.ZERO) {
				restResponseVO.setValue(studentList);
			} else {
				restResponseVO.setStatusDescription("Required student list not available...!");
			}
			restResponseVO.setSessionKey(sessionKey);
			restResponseVO.setStatusCode(200);
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.SUCCESS.name());
		}catch (Exception e) {
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
			restResponseVO.setStatusCode(400);
			restResponseVO.setStatusDescription(e.getMessage());
		}
		logger.logPMTEnd("Get student list end :", startTime, true);
		return restResponseVO;
	}
}
