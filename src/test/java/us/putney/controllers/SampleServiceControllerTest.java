/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.putney.controllers;

import org.junit.Test;
import org.junit.Before;
import static org.junit.internal.matchers.StringContains.containsString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 *
 * @author jputney
 */
public class SampleServiceControllerTest extends AbstractContextControllerTests {

  private static final Logger logger = LoggerFactory.getLogger(SampleServiceControllerTest.class);
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
  
  /**
   * Test of home method, of class SampleServiceController.
   */
  @Test
  public void testHome() throws Exception {
    mockMvc.perform(get("/").accept(MediaType.TEXT_HTML))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.view().name("index.html"));
  }

  /**
   * Test of home method, of class SampleServiceController.
   */
  @Test
  public void testIndexHtml() throws Exception {
    mockMvc.perform(get("/index.html")
            .accept(MediaType.TEXT_HTML))
            .andDo(print())
            .andExpect(content().string(containsString("ng-app=\"sampleModule\"")));
  }

  /**
   * Test of sampleService method, of class SampleServiceController.
   */
  @Test
  public void testSampleService() throws Exception {
    mockMvc.perform(get("/sample-service")).andDo(MockMvcResultHandlers.print())
            .andExpect(content().json("{Key1: 'Val1', Key2: 'Val2'}"));
  }
  
  /**
   * Test of sampleService method, of class SampleServiceController.
   */
  @Test
  public void testSampleServiceResponseBody() throws Exception {
    mockMvc.perform(get("/sample-service-response-body")).andDo(MockMvcResultHandlers.print())
            .andExpect(content().json("{Key1: 'Val1', Key2: 'Val2'}"));
  }  
  
  @Test
  public void getData() {
    logger.debug("Power: {}", SampleServiceController.getPower());
    logger.debug("Hero: {}", SampleServiceController.getHero("Grrr"));    
  }
}
