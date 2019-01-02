package com.bec.socratesrpt.rest.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestsModel{

		private String testName;
		private String testResults;
		private String testStartDate;
		private String testEndDate;

		public String getTestName() {
		return testName;
		}

		public void setTestName(String testName) {
		this.testName = testName;
		}

		public String getTestResults() {
		return testResults;
		}

		public void setTestResults(String testResults) {
		this.testResults = testResults;
		}

		public String getTestStartDate() {
		return testStartDate;
		}

		public void setTestStartDate(String testStartDate) {
		this.testStartDate = testStartDate;
		}

		public String getTestEndDate() {
		return testEndDate;
		}

		public void setTestEndDate(String testEndDate) {
		this.testEndDate = testEndDate;
		}

}
