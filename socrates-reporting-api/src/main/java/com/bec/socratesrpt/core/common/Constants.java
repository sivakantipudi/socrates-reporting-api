/*
 * Copyright Benchmark Education Company
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
package com.bec.socratesrpt.core.common;

/**
 *   Static class which shall include all the constants to be used in the
 *   application.
 *   @author Sivaram
 *   @version 1.0 (12/12/2018)
 */
public final class Constants {

	public static final String COMMA = ",";
	public static final String DOT = ".";
	
	public static final Integer ZERO = 0;
	
	public static final int API_SUCCESS_HTTP_RESPONSE_CODE 			= 200;
	public static final int VALIDATION_FAILURE_HTTP_RESPONSE_CODE 	= 400;
    public static final int BAD_CREDEENTIALS_HTTP_REDPONSE_CODE 	= 401;
    public static final int PERMISSION_DENIED_HTTP_REDPONSE_CODE 	= 403;
    public static final int RESOURCE_NOT_FOUND_HTTP_REDPONSE_CODE 	= 404;
    public static final int SERVER_FAILURE_HTTP_RESPONSE_CODE 		= 500;
    
    public static final String NOT_AUTHORIZED_VIEW_RESOURCE = "You are not authorized to view the resource";
    public static final String ACCESSING_FORBIDDEN = "Accessing the resource you were trying to reach is forbidden";
    public static final String RESOURCE_NOT_FOUND = "The resource you were trying to reach is not found";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error";
    public static final String SUCCESSFULLY_RETRIEVED = "Successfully retrieved list";
	
	public enum REST_RESPONSE_STATUS {
		SUCCESS,FAILED;
	}
	
	
}
