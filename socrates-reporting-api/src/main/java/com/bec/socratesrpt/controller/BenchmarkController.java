/*
*
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
 * DEC 12 2018		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.socratesrpt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bec.socratesrpt.core.common.Constants;
import com.bec.socratesrpt.core.logger.Log;
import com.bec.socratesrpt.iservice.IStudentSelectorService;
import com.bec.socratesrpt.rest.model.ClassList;
import com.bec.socratesrpt.rest.model.RestRequestVO;
import com.bec.socratesrpt.rest.model.RestResponseVO;
import com.bec.socratesrpt.rest.model.School;
import com.bec.socratesrpt.rest.model.Student;
import com.bec.socratesrpt.rest.model.StudentTestScoreDetails;
import com.bec.socratesrpt.rest.model.TestDetails;
import com.bec.socratesrpt.rest.model.TestScoreDetails;
import com.bec.socratesrpt.rest.model.TestsModel;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
	@ApiOperation(value = "View a list of schools permitted for logged in user",response = RestResponseVO.class)
    @ApiResponses(value = {
            @ApiResponse(code = Constants.API_SUCCESS_HTTP_RESPONSE_CODE, message = Constants.SUCCESSFULLY_RETRIEVED),
            @ApiResponse(code = Constants.BAD_CREDEENTIALS_HTTP_REDPONSE_CODE, message = Constants.NOT_AUTHORIZED_VIEW_RESOURCE),
            @ApiResponse(code = Constants.PERMISSION_DENIED_HTTP_REDPONSE_CODE, message = Constants.ACCESSING_FORBIDDEN),
            @ApiResponse(code = Constants.RESOURCE_NOT_FOUND_HTTP_REDPONSE_CODE, message = Constants.RESOURCE_NOT_FOUND),
            @ApiResponse(code = Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE, message = Constants.INTERNAL_SERVER_ERROR)
    }
    )
	@RequestMapping(value = "/getSchoolList", method = RequestMethod.GET)
	public RestResponseVO getSchoolList(@RequestParam Integer userId, @RequestParam String sessionKey, @RequestParam String role) {
		
		long startTime = logger.logPMTBegin("Get school list begin :", true);
		RestResponseVO restResponseVO = new RestResponseVO();
		
		try {
			List<School> schoolList = studentService.getSchoolListByUserId(userId, sessionKey, role);
			if (schoolList.size() > Constants.ZERO) {
				restResponseVO.setValue(schoolList);
			} else {
				restResponseVO.setStatusDescription("Required school list not available....!");
			}
			restResponseVO.setStatusCode(Constants.API_SUCCESS_HTTP_RESPONSE_CODE);
			restResponseVO.setSessionKey(sessionKey);
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.SUCCESS.name());
		}catch (Exception e) {
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
			restResponseVO.setStatusCode(Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE);
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
	@ApiOperation(value = "View a list of classes permitted for selected school",response = RestResponseVO.class)
    @ApiResponses(value = {
    		@ApiResponse(code = Constants.API_SUCCESS_HTTP_RESPONSE_CODE, message = Constants.SUCCESSFULLY_RETRIEVED),
            @ApiResponse(code = Constants.BAD_CREDEENTIALS_HTTP_REDPONSE_CODE, message = Constants.NOT_AUTHORIZED_VIEW_RESOURCE),
            @ApiResponse(code = Constants.PERMISSION_DENIED_HTTP_REDPONSE_CODE, message = Constants.ACCESSING_FORBIDDEN),
            @ApiResponse(code = Constants.RESOURCE_NOT_FOUND_HTTP_REDPONSE_CODE, message = Constants.RESOURCE_NOT_FOUND),
            @ApiResponse(code = Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE, message = Constants.INTERNAL_SERVER_ERROR)
    }
    )
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
			restResponseVO.setStatusCode(Constants.API_SUCCESS_HTTP_RESPONSE_CODE);
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.SUCCESS.name());
		}catch (Exception e) {
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
			restResponseVO.setStatusCode(Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE);
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
	@ApiOperation(value = "View a list of students for the school selected",response = RestResponseVO.class)
    @ApiResponses(value = {
    		@ApiResponse(code = Constants.API_SUCCESS_HTTP_RESPONSE_CODE, message = Constants.SUCCESSFULLY_RETRIEVED),
            @ApiResponse(code = Constants.BAD_CREDEENTIALS_HTTP_REDPONSE_CODE, message = Constants.NOT_AUTHORIZED_VIEW_RESOURCE),
            @ApiResponse(code = Constants.PERMISSION_DENIED_HTTP_REDPONSE_CODE, message = Constants.ACCESSING_FORBIDDEN),
            @ApiResponse(code = Constants.RESOURCE_NOT_FOUND_HTTP_REDPONSE_CODE, message = Constants.RESOURCE_NOT_FOUND),
            @ApiResponse(code = Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE, message = Constants.INTERNAL_SERVER_ERROR)
    }
    )
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
			restResponseVO.setStatusCode(Constants.API_SUCCESS_HTTP_RESPONSE_CODE);
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.SUCCESS.name());
		}catch (Exception e) {
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
			restResponseVO.setStatusCode(Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE);
			restResponseVO.setStatusDescription(e.getMessage());
		}
		logger.logPMTEnd("Get student list end :", startTime, true);
		return restResponseVO;
	}
	
	
	@ApiOperation(value = "gets test score for a student",response = RestResponseVO.class)
    @ApiResponses(value = {
    		@ApiResponse(code = Constants.API_SUCCESS_HTTP_RESPONSE_CODE, message = Constants.SUCCESSFULLY_RETRIEVED),
            @ApiResponse(code = Constants.BAD_CREDEENTIALS_HTTP_REDPONSE_CODE, message = Constants.NOT_AUTHORIZED_VIEW_RESOURCE),
            @ApiResponse(code = Constants.PERMISSION_DENIED_HTTP_REDPONSE_CODE, message = Constants.ACCESSING_FORBIDDEN),
            @ApiResponse(code = Constants.RESOURCE_NOT_FOUND_HTTP_REDPONSE_CODE, message = Constants.RESOURCE_NOT_FOUND),
            @ApiResponse(code = Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE, message = Constants.INTERNAL_SERVER_ERROR)
    }
    )
	@RequestMapping(value = "/getTestScoreByStudent", method = RequestMethod.POST)
	public RestResponseVO getTestScoreByStudent(@RequestBody RestRequestVO requestVO) throws Exception {
		
		long startTime = logger.logPMTBegin("Get test scores by student begin :", true);
		
		RestResponseVO restResponseVO = new RestResponseVO();
		try {
			List<StudentTestScoreDetails> studentTestScoreList = studentService.getTestScoreByStudent(requestVO);
			if (studentTestScoreList.size() > Constants.ZERO) {
				restResponseVO.setValue(studentTestScoreList);
			} else {
				restResponseVO.setStatusDescription("Required test score details not available...!");
			}
			restResponseVO.setStatusCode(Constants.API_SUCCESS_HTTP_RESPONSE_CODE);
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.SUCCESS.name());
		} catch (Exception e) {
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
			restResponseVO.setStatusCode(Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE);
			restResponseVO.setStatusDescription(e.getMessage());
		}
		logger.logPMTEnd("Get test scores by student end :", startTime, true);
		return restResponseVO;
	}
	
	
	@ApiOperation(value = "gets test score for a class average",response = RestResponseVO.class)
    @ApiResponses(value = {
    		@ApiResponse(code = Constants.API_SUCCESS_HTTP_RESPONSE_CODE, message = Constants.SUCCESSFULLY_RETRIEVED),
            @ApiResponse(code = Constants.BAD_CREDEENTIALS_HTTP_REDPONSE_CODE, message = Constants.NOT_AUTHORIZED_VIEW_RESOURCE),
            @ApiResponse(code = Constants.PERMISSION_DENIED_HTTP_REDPONSE_CODE, message = Constants.ACCESSING_FORBIDDEN),
            @ApiResponse(code = Constants.RESOURCE_NOT_FOUND_HTTP_REDPONSE_CODE, message = Constants.RESOURCE_NOT_FOUND),
            @ApiResponse(code = Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE, message = Constants.INTERNAL_SERVER_ERROR)
    }
    )
	@RequestMapping(value = "/getTestScoreByClass", method = RequestMethod.POST)
	public RestResponseVO getTestScoreByClass(@RequestBody RestRequestVO requestVO) throws Exception {
		
		long startTime = logger.logPMTBegin("Get test scores by class begin :", true);
		RestResponseVO restResponseVO = new RestResponseVO();
		try {
			List<TestScoreDetails> testScoreClassList = studentService.getTestScoreByClass(requestVO);
			if (testScoreClassList.size() > Constants.ZERO) {
				restResponseVO.setValue(testScoreClassList);
			} else {
				restResponseVO.setStatusDescription("Required testscore details not available...!");
			}
			restResponseVO.setStatusCode(Constants.API_SUCCESS_HTTP_RESPONSE_CODE);
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.SUCCESS.name());
		} catch (Exception e) {
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
			restResponseVO.setStatusCode(Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE);
			restResponseVO.setStatusDescription(e.getMessage());
		}
		logger.logPMTEnd("Get test scores by class end :", startTime, true);
		return restResponseVO;
	}
	
	@ApiOperation(value = "gets test score for a school average",response = RestResponseVO.class)
    @ApiResponses(value = {
    		@ApiResponse(code = Constants.API_SUCCESS_HTTP_RESPONSE_CODE, message = Constants.SUCCESSFULLY_RETRIEVED),
            @ApiResponse(code = Constants.BAD_CREDEENTIALS_HTTP_REDPONSE_CODE, message = Constants.NOT_AUTHORIZED_VIEW_RESOURCE),
            @ApiResponse(code = Constants.PERMISSION_DENIED_HTTP_REDPONSE_CODE, message = Constants.ACCESSING_FORBIDDEN),
            @ApiResponse(code = Constants.RESOURCE_NOT_FOUND_HTTP_REDPONSE_CODE, message = Constants.RESOURCE_NOT_FOUND),
            @ApiResponse(code = Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE, message = Constants.INTERNAL_SERVER_ERROR)
    }
    )
	@RequestMapping(value = "/getTestScoreBySchool", method = RequestMethod.POST)
	public RestResponseVO getTestScoreBySchool(@RequestBody RestRequestVO requestVO) throws Exception {
		
		long startTime = logger.logPMTBegin("Get test scores by school begin :", true);
		RestResponseVO restResponseVO = new RestResponseVO();
		try {
			List<TestScoreDetails> testScoreSchoolList = studentService.getTestScoreBySchool(requestVO);
			if (testScoreSchoolList.size() > Constants.ZERO) {
				restResponseVO.setValue(testScoreSchoolList);
			} else {
				restResponseVO.setStatusDescription("Required testscore details not available...!");
			}
			restResponseVO.setStatusCode(Constants.API_SUCCESS_HTTP_RESPONSE_CODE);
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.SUCCESS.name());
		} catch (Exception e) {
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
			restResponseVO.setStatusCode(Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE);
			restResponseVO.setStatusDescription(e.getMessage());
		}
		logger.logPMTEnd("Get test scores by school end :", startTime, true);
		return restResponseVO;
	}
	
	@ApiOperation(value = "gets test score for a district average",response = RestResponseVO.class)
    @ApiResponses(value = {
    		@ApiResponse(code = Constants.API_SUCCESS_HTTP_RESPONSE_CODE, message = Constants.SUCCESSFULLY_RETRIEVED),
            @ApiResponse(code = Constants.BAD_CREDEENTIALS_HTTP_REDPONSE_CODE, message = Constants.NOT_AUTHORIZED_VIEW_RESOURCE),
            @ApiResponse(code = Constants.PERMISSION_DENIED_HTTP_REDPONSE_CODE, message = Constants.ACCESSING_FORBIDDEN),
            @ApiResponse(code = Constants.RESOURCE_NOT_FOUND_HTTP_REDPONSE_CODE, message = Constants.RESOURCE_NOT_FOUND),
            @ApiResponse(code = Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE, message = Constants.INTERNAL_SERVER_ERROR)
    }
    )
	@RequestMapping(value = "/getTestScoreByDistrict", method = RequestMethod.POST)
	public RestResponseVO getTestScoreByDistrict(@RequestBody RestRequestVO requestVO) throws Exception {
		
		long startTime = logger.logPMTBegin("Get test scores by district begin :", true);
		RestResponseVO restResponseVO = new RestResponseVO();
		try {
			List<TestScoreDetails> testScoreDistrictList = studentService.getTestScoreByDistrict(requestVO);
			if (testScoreDistrictList.size() > Constants.ZERO) {
				restResponseVO.setValue(testScoreDistrictList);
			} else {
				restResponseVO.setStatusDescription("Required testscore details not available...!");
			}
			restResponseVO.setStatusCode(Constants.API_SUCCESS_HTTP_RESPONSE_CODE);
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.SUCCESS.name());
		} catch (Exception e) {
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
			restResponseVO.setStatusCode(Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE);
			restResponseVO.setStatusDescription(e.getMessage());
		}
		logger.logPMTEnd("Get test scores by district end :", startTime, true);
		return restResponseVO;
	}

	
	@ApiOperation(value = "fetch tests list for context is for a single class or student, the total number of tests listed will only be the universe of tests for which test data is available in the District Term selected.",response = RestResponseVO.class)
    @ApiResponses(value = {
    		@ApiResponse(code = Constants.API_SUCCESS_HTTP_RESPONSE_CODE, message = Constants.SUCCESSFULLY_RETRIEVED),
            @ApiResponse(code = Constants.BAD_CREDEENTIALS_HTTP_REDPONSE_CODE, message = Constants.NOT_AUTHORIZED_VIEW_RESOURCE),
            @ApiResponse(code = Constants.PERMISSION_DENIED_HTTP_REDPONSE_CODE, message = Constants.ACCESSING_FORBIDDEN),
            @ApiResponse(code = Constants.RESOURCE_NOT_FOUND_HTTP_REDPONSE_CODE, message = Constants.RESOURCE_NOT_FOUND),
            @ApiResponse(code = Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE, message = Constants.INTERNAL_SERVER_ERROR)
    }
    )
	@RequestMapping(value = "/getTestsForUniverse", method = RequestMethod.GET)
	public RestResponseVO getTestsList(@RequestBody RestRequestVO requestObject) {

		long startTime = logger.logPMTBegin("Get test list begin :", true);
		RestResponseVO restResponseVO = new RestResponseVO();
		try {
			List<TestsModel> testsList = studentService.getTestsForUniverse(requestObject);

			if (testsList.size() > Constants.ZERO) {
				restResponseVO.setValue(testsList);
			} else {
				restResponseVO.setStatusDescription("Required test list not available...!");
			}
			restResponseVO.setStatusCode(Constants.API_SUCCESS_HTTP_RESPONSE_CODE);
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.SUCCESS.name());
		}catch (Exception e) {
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
			restResponseVO.setStatusCode(Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE);
			restResponseVO.setStatusDescription(e.getMessage());
		}
		logger.logPMTEnd("Get test list end :", startTime, true);
		return restResponseVO;
	}
	
	@ApiOperation(value = "get over time test scores",response = RestResponseVO.class)
    @ApiResponses(value = {
    		@ApiResponse(code = Constants.API_SUCCESS_HTTP_RESPONSE_CODE, message = Constants.SUCCESSFULLY_RETRIEVED),
            @ApiResponse(code = Constants.BAD_CREDEENTIALS_HTTP_REDPONSE_CODE, message = Constants.NOT_AUTHORIZED_VIEW_RESOURCE),
            @ApiResponse(code = Constants.PERMISSION_DENIED_HTTP_REDPONSE_CODE, message = Constants.ACCESSING_FORBIDDEN),
            @ApiResponse(code = Constants.RESOURCE_NOT_FOUND_HTTP_REDPONSE_CODE, message = Constants.RESOURCE_NOT_FOUND),
            @ApiResponse(code = Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE, message = Constants.INTERNAL_SERVER_ERROR)
    }
    )
	@RequestMapping(value = "/getOverTimeTestScores", method = RequestMethod.POST)
	public RestResponseVO getOverTimeTestScores(@RequestBody RestRequestVO requestVO) throws Exception {
		
		long startTime = logger.logPMTBegin("Get over time test scores begin :", true);
		RestResponseVO restResponseVO = new RestResponseVO();
		try {
			List<TestDetails> overTimeTestScoresList = studentService.getOverTimeTestScores(requestVO);
			if (overTimeTestScoresList.size() > Constants.ZERO) {
				restResponseVO.setValue(overTimeTestScoresList);
			} else {
				restResponseVO.setStatusDescription("Required testscore details not available...!");
			}
			restResponseVO.setStatusCode(Constants.API_SUCCESS_HTTP_RESPONSE_CODE);
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.SUCCESS.name());
		} catch (Exception e) {
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
			restResponseVO.setStatusCode(Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE);
			restResponseVO.setStatusDescription(e.getMessage());
		}
		logger.logPMTEnd("Get over time test scores end :", startTime, true);
		return restResponseVO;
	}
	
	@ApiOperation(value = "get student scores by test",response = RestResponseVO.class)
    @ApiResponses(value = {
    		@ApiResponse(code = Constants.API_SUCCESS_HTTP_RESPONSE_CODE, message = Constants.SUCCESSFULLY_RETRIEVED),
            @ApiResponse(code = Constants.BAD_CREDEENTIALS_HTTP_REDPONSE_CODE, message = Constants.NOT_AUTHORIZED_VIEW_RESOURCE),
            @ApiResponse(code = Constants.PERMISSION_DENIED_HTTP_REDPONSE_CODE, message = Constants.ACCESSING_FORBIDDEN),
            @ApiResponse(code = Constants.RESOURCE_NOT_FOUND_HTTP_REDPONSE_CODE, message = Constants.RESOURCE_NOT_FOUND),
            @ApiResponse(code = Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE, message = Constants.INTERNAL_SERVER_ERROR)
    }
    )
	@RequestMapping(value = "/getStudentScoreDetailsByTest", method = RequestMethod.POST)
	public RestResponseVO getStudentScoreDetailsByTest(@RequestBody RestRequestVO requestVO) throws Exception {
		
		long startTime = logger.logPMTBegin("Get student scores details by test begin :", true);
		RestResponseVO restResponseVO = new RestResponseVO();
		try {
			List<StudentTestScoreDetails> overTimeTestScoresList = studentService.getStudentScoreDetailsByTest(requestVO);
			if (overTimeTestScoresList.size() > Constants.ZERO) {
				restResponseVO.setValue(overTimeTestScoresList);
			} else {
				restResponseVO.setStatusDescription("Required testscore details not available...!");
			}
			restResponseVO.setStatusCode(Constants.API_SUCCESS_HTTP_RESPONSE_CODE);
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.SUCCESS.name());
		} catch (Exception e) {
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
			restResponseVO.setStatusCode(Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE);
			restResponseVO.setStatusDescription(e.getMessage());
		}
		logger.logPMTEnd("Get student scores details by test end :", startTime, true);
		return restResponseVO;
	}
}