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
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 *
 * @author Jeff Putney <jeffrey.putney@gmail.com>
 */
public class SampleServiceControllerTest extends AbstractContextControllerTests {
  private static final Logger logger = LoggerFactory.getLogger(SampleServiceControllerTest.class);
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
//		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
  
  public SampleServiceControllerTest() {
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
  public void testIndex() throws Exception {
    MvcResult result = mockMvc.perform(get("/index.html").accept(MediaType.TEXT_HTML)).andDo(MockMvcResultHandlers.print()).andReturn();
    //ResultActions andExpect = result.andExpect(MockMvcResultMatchers.content().string("Some Text"));
    logger.info("Got: {}", result.getResponse().getContentAsString());
  }

  /**
   * Test of simpleService method, of class SampleServiceController.
   */
  @Test
  public void testSimpleService() throws Exception {
    mockMvc.perform(get("/sample-service")).andDo(MockMvcResultHandlers.print())
            .andExpect(content().json("{Key1: 'Val1', Key2: 'Val2'}"));
  }
  
}
