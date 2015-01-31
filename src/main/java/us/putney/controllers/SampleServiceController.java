/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.putney.controllers;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author juggler
 */
@Controller
@RequestMapping(produces = {"application/json"}, method = {RequestMethod.GET})
public class SampleServiceController {

  private static final Logger logger = LoggerFactory.getLogger(SampleServiceController.class);
  static Gson gson = new Gson();

  public void init() {
  }

  // This teaches DispatcherServlet how to fetch the welcome-page
  @RequestMapping("/")
  public String home(ModelMap map) {
    return "index.html";
  }

  @RequestMapping("sample-service")
  public @ResponseBody
  String simpleService() {
    Map<String, String> vals = new HashMap<String, String>();
    vals.put("Key1", "Val1");
    vals.put("Key2", "Val2");
    logger.info("Response: {}", vals);
    return gson.toJson(vals);
  }
}
