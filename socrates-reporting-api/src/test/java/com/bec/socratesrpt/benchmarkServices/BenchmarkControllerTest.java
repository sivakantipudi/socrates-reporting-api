package com.bec.socratesrpt.benchmarkServices;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bec.socratesrpt.controller.BenchmarkController;
import com.bec.socratesrpt.iservice.IStudentSelectorService;
import com.bec.socratesrpt.rest.model.School;
import com.google.gson.reflect.TypeToken;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

//Register the SpringExtension which integrates the Spring TestContext Framework into Junit 5’s Jupiter programming model
@ExtendWith(SpringExtension.class) 
//Auto configure Spring MVC infrastructure and MockMvc. It will only scan beans related to Web layer, like @Controller, @ControllerAdvice, WebMvcConfigurer etc. This is useful because we are interested only in web layer when unit testing Controller classes. In our case, we are limiting it to BenchmarkController.class.
@WebMvcTest(BenchmarkController.class)
public class BenchmarkControllerTest{

	//It adds Mockito mocks as a bean in Spring ApplicationContext.
	@MockBean
	private IStudentSelectorService studentService;

	//Provide Spring MVC infrastructure without starting the HTTP Server.
	@Autowired
	private MockMvc mockMvc;
//
//	//Custom display name that will be displayed by test runners and test reporting.
//	@DisplayName("Should get schoolList")
//	//declared just like regular @Test method but with at least one source of arguments. here it's CSV source for us
//	@ParameterizedTest(name = "{index} => userId={1}, sessionKey={0}, role={2}")
//	//allows you to express argument lists as comma-separated values (i.e., String literals). Our test runs for 4 different request params to display variations
//	@CsvSource({
////		"100, 123,  teacher",
////		"200, 123,  student",
////		"514, 123,  BECAdmin",
//		"105, 123,  DistrictAdmin"
//	})
//	public void testSchoolList(int userId, String sessionKey, String role) throws Exception { 
//
//		//My URL to be tested
//		String URL = "/api/getSchoolList";
//
//		//content inside value object which get from service call
//		String myContent = "[{\"name\":\"Vijaya High School\",\"id\":\"BEC12\",\"address\":\"Aditya Nagar\"},{\"name\":\"St Andrews School\",\"id\":\"BEC13\",\"address\":\"Bowenpally\"},{\"name\":\"Delhi Public School\",\"id\":\"BEC14\",\"address\":\"Nacharam\"}]";
//		
//		
//
//		//Total result json after API call
//		String resultContent = "{" + 
//				"\"sessionKey\":\"123\"," + 
//				"\"statusCode\":200," + 
//				"\"statusDescription\":null," + 
//				"\"status\":\"SUCCESS\"," + 
//				"\"value\":" + 
//				myContent + 
//				"}";
//
//		//GSON conversion from JSON String to listObject
//		TypeToken<List<School>> listType = new TypeToken<List<School>>() {};
//		@SuppressWarnings("unchecked")
//		List<School> resultEmployee = TestUtils.jsonToList(myContent, listType);
//
//		//Mock Service and the data which is to be returned by it
//		when(studentService.getSchoolListByUserId(userId, sessionKey, role)).thenReturn(resultEmployee);
//
//
//		//Mock API call and return result. param has requestParams for the call.
//		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON_UTF8)
//				.param("sessionKey", sessionKey+"")
//				.param("userId", userId+"")
//				.param("role",role+"")).andDo(MockMvcResultHandlers.print())
//				.andReturn();
//
//		// verify the API call
//		int status = result.getResponse().getStatus();
//		assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");
//
//		// verify that service method was called once
//		verify(studentService).getSchoolListByUserId(userId, sessionKey, role);
//
//		//Compare results either as strings or objects. Objects would be more easy since strings are compared with spaces too
//		assertEquals(resultContent, result.getResponse().getContentAsString(), "Incorrect school List");
//
//
//	}

}
