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

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

import org.slf4j.Logger;

public class Log implements Serializable {

	private static final long serialVersionUID = 1L;

	private transient Logger LOGGER = null;

	/**
	 * Constructor for Log.
	 * 
	 * @param LOGGER
	 *            Logger
	 */
	public Log(final Logger LOGGER) {
		this.LOGGER = LOGGER;
	}

	/**
	 * Method formatMessage.
	 * 
	 * @param method
	 *            String
	 * @param traceCode
	 *            String
	 * @param traceType
	 *            String
	 * @param interval
	 *            String
	 * @return String
	 */
	public static String formatMessage(final String method, final String traceCode, final String traceType,
			final String interval) {
		StringBuilder buf = new StringBuilder(200);
		buf.append('[').append(method).append(']');
		buf.append('[').append(traceCode).append(']');
		buf.append('[').append(traceType).append(']');
		if (interval != null && interval.length() > 0) {
			buf.append('[').append(interval).append(']');
		}
		return buf.toString();
	}

	/**
	 * Method formatMessage.
	 * 
	 * @param method
	 *            String
	 * @param traceCode
	 *            String
	 * @param traceType
	 *            String
	 * @param interval
	 *            String
	 * @param returnObject
	 *            Object
	 * @return String
	 */
	public static String formatMessage(final String method, final String traceCode, final String traceType,
			final String interval, final Object returnObject) {
		StringBuilder buf = new StringBuilder(400);
		buf.append(formatMessage(method, traceCode, traceType, interval));
		buf.append('[').append(returnObject).append(']');
		return buf.toString();
	}

	/**
	 * Method trace.
	 * 
	 * @param method
	 *            String
	 * @param traceCode
	 *            String
	 * @param traceType
	 *            String
	 */
	public final void trace(final String method, final String traceCode, final String traceType) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(formatMessage(method, traceCode, traceType, null));
		}
	}

	/**
	 * Method trace.
	 * 
	 * @param method
	 *            String
	 * @param traceCode
	 *            String
	 * @param traceType
	 *            String
	 * @param interval
	 *            long
	 */
	public final void trace(final String method, final String traceCode, final String traceType, final long interval) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(formatMessage(method, traceCode, traceType, "" + interval));
		}
	}

	/**
	 * Method trace.
	 * 
	 * @param method
	 *            String
	 * @param traceCode
	 *            String
	 * @param traceType
	 *            String
	 * @param interval
	 *            long
	 * @param returnObject
	 *            Object
	 */
	public final void trace(final String method, final String traceCode, final String traceType, final long interval,
			final Object returnObject) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(formatMessage(method, traceCode, traceType, "" + interval, returnObject));
		}
	}

	/**
	 * Method infoTrace.
	 * 
	 * @param method
	 *            String
	 * @param traceCode
	 *            String
	 * @param traceType
	 *            String
	 */
	public final void infoTrace(final String method, final String traceCode, final String traceType) {
		LOGGER.info(formatMessage(method, traceCode, traceType, null));
	}

	/**
	 * Method infoTrace.
	 * 
	 * @param method
	 *            String
	 * @param traceCode
	 *            String
	 * @param traceType
	 *            String
	 * @param interval
	 *            long
	 */
	public final void infoTrace(final String method, final String traceCode, final String traceType,
			final long interval) {
		LOGGER.info(formatMessage(method, traceCode, traceType, "" + interval));
	}

	/**
	 * Method logStackTrace.
	 * 
	 * @param msg
	 *            String
	 * @param ex
	 *            Throwable
	 */
	public final void logStackTrace(final String msg, final Throwable ex) {
		error(msg);

		StringWriter stringWriter = new StringWriter();
		ex.printStackTrace(new PrintWriter(stringWriter));

		error(stringWriter.toString());
	}

	/**
	 * Method debug.
	 * 
	 * @param message
	 *            String
	 */
	public final void debug(final String message) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(message);
		}
	}

	/**
	 * Method debug.
	 * 
	 * @param format
	 *            String
	 * @param arguments
	 *            Object[]
	 */
	public final void debug(String format, Object... arguments) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(format, arguments);
		}
	}

	/**
	 * Method info.
	 * 
	 * @param message
	 *            String
	 */
	public final void info(final String message) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(message);
		}
	}

	public final void info(String format, Object... arguments) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(format, arguments);
		}
	}

	/**
	 * Method warn.
	 * 
	 * @param message
	 *            String
	 */
	public final void warn(final String message) {
		LOGGER.warn(message);
	}
	
	public final void warn(String format, Object... arguments) {
			LOGGER.warn(format, arguments);
	}

	/**
	 * Method error.
	 * 
	 * @param message
	 *            String
	 */
	public final void error(final String message) {
		LOGGER.error(message);
	}

	/**
	 * Method error.
	 * 
	 * @param message
	 *            String
	 * @param arguments
	 *            Object[]
	 */
	public final void error(final String message, Object... arguments) {
		LOGGER.error(message, arguments);
	}

	public final long logPMTBegin(final String message, final Boolean pmtLogsEnabled) {
		long startTime = System.currentTimeMillis();
		if (pmtLogsEnabled)
			LOGGER.info("Performance Logs - Begin " + message);
		return startTime;
	}

	public final void logPMTEnd(final String message, long startTime, final Boolean pmtLogsEnabled) {
		if (pmtLogsEnabled) {
			long endTime = System.currentTimeMillis();
			long timeInMilliSec = endTime - startTime;
			LOGGER.info("Performance Logs End - " + message + " Time taken : " + timeInMilliSec);
		}
	}
}