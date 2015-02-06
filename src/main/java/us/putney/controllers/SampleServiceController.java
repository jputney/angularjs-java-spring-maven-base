/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.putney.controllers;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author juggler
 */
@Controller
@RequestMapping(produces = {"application/json"}, method = {RequestMethod.GET})
public class SampleServiceController {

  private static final Logger logger = LoggerFactory.getLogger(SampleServiceController.class);

  public void init() {
  }

  // This teaches DispatcherServlet how to fetch the welcome-page
  @RequestMapping(value="/", produces = "text/html")
  public String home(ModelMap map) {
    return "index.html";
  }

  @RequestMapping(value="sample-service", produces = {"application/json", "application/javascript"})
  public void simpleService(Model model) {
    Map<String, Object> vals = new HashMap<String, Object>();
    vals.put("Key1", "Val1");
    vals.put("Key2", "Val2");
    logger.info("Response: {}", vals);
    model.addAllAttributes(vals);
  }
}
