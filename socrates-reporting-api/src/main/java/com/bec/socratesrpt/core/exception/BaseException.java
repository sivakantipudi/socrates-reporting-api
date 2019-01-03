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
package com.bec.socratesrpt.core.exception;

/**
 *  This class shall serve as the default exception class for the socrates reporting API  Services
 *  application. All exceptions caught in application layer should need to be encapsulated 
 *  with this exception.
 *  @author Sivaram
 *  @version 1.0 (12/12/2018)
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String benchmarkErrorCode;

	/**
	 * No-argument Constructor and in-turn no-argument super class constructor
	 */
	public BaseException() {
		super();
	}

	/**
	 * Parameterized Constructor with customized message 
	 * @param message
	 */
	public BaseException(final String message) {
		super(message);
	}
	
	/**
	 *  Parameterized Constructor for the exception class.
	 *  @param String   Exception message
	 *  @param String   Error code
     */	
	public BaseException(final String benchmarkErrorCode, final String message) {
		super(message);
		this.benchmarkErrorCode = benchmarkErrorCode;
	} 
	
	/**
	 * Parameterized Constructor that takes Throwable Object as parameter with
	 * the customized message
	 * 
	 * @param message
	 * @param cause
	 */
	public BaseException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Parameterized constructor with Throwable Object
	 * @param cause
	 */
	public BaseException(final Throwable cause) {
		super(cause);
	}

	//getter for @benchmarkErrorCode
	public String getBenchmarkErrorCode() {
		return benchmarkErrorCode;
	}

	//setter for @benchmarkErrorCode
	public void setBenchmarkErrorCode(String benchmarkErrorCode) {
		this.benchmarkErrorCode = benchmarkErrorCode;
	}
}
