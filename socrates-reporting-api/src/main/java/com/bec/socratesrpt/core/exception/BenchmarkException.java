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
package com.bec.socratesrpt.core.exception;

import com.bec.socratesrpt.core.common.Constants;
import com.bec.socratesrpt.core.logger.Log;
import com.bec.socratesrpt.core.logger.LogFactory;
import com.bec.socratesrpt.core.logger.Logger;

/**
 * Custom exception class
 */
public class BenchmarkException {
	
	private static Log logger = Logger.getLogger(BenchmarkException.class);

	/**
	 * Custom exception method to be used in all the service to return
	 * error or exception during api calls
	 * @param message
	 * @param arguments
	 */
	public static void throwBenchmarkException(String message, Object... arguments) {
		//message = String.format(message, arguments);
		message = message+Constants.COMMA+arguments[0]+Constants.COMMA+arguments[1]+Constants.COMMA+arguments[2];
		// message may be formatted with the var args input
		logger.error(message);
		throw new BaseException(message);
	}

	/**
	 * method will handle all null pointer and Illegal Argument exception traces are trimmed
	 * and only top 4 lines are displayed
	 * @param exception
	 * @param logger
	 */
	public static void printExceptionTraceToLogFile(Throwable exception, Log logger) {
		logger = logger == null ? LogFactory.getApplicationLogger(BenchmarkException.class) : logger;
		logger.error(exception.getMessage());
		if (exception instanceof NullPointerException || exception instanceof IllegalArgumentException
				|| exception instanceof BaseException) {
			StackTraceElement[] stack = exception.getStackTrace();
			logger.error("Exception trace");
			for (int i = 0; i <= (stack.length > 4 ? 4 : stack.length); i++) {
				StackTraceElement element = stack[i];
				logger.error(element.getClassName() + Constants.DOT + element.getMethodName() + Constants.DOT + element.getLineNumber());
			}
		} else {
			exception.printStackTrace();
		}
	}
	
}
