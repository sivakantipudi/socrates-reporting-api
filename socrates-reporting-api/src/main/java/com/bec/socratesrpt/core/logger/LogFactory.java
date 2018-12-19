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
package com.bec.socratesrpt.core.logger;

import java.io.Serializable;

import org.slf4j.LoggerFactory;

/**
 * This class is used maintain all the logs @ the class level
 *  
 * @author Sivaram
 * @version $Revision: 1.0 $
 */
public class LogFactory implements Serializable {

	private static final long serialVersionUID = 1L;

	private LogFactory() {

	}

	/**
	 * This method will return the application logger
	 * 
	 * @param classZ
	 * 
	 * @return Log
	 */
	public static Log getApplicationLogger(Class<?> classZ) {
		return new Log(LoggerFactory.getLogger(classZ.getName()));
	}

	/**
	 * This method will return the Tracer logger
	 * 
	 * @param classZ
	 * 
	 * @return Log
	 */
	public static Log getTraceLogger(Class<?> classZ) {
		return new Log(LoggerFactory.getLogger("TRACER." + classZ.getName()));
	}

	/**
	 * This method will return the Alert Logger
	 * 
	 * @param classZ
	 * 
	 * @return Log
	 */
	public static Log getAlertLogger(Class<?> classZ) {
		return new Log(LoggerFactory.getLogger("ALERT." + classZ.getName()));
	}
}
