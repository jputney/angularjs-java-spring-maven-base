/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.putney.controllers;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jputney
 */
@Controller
@RequestMapping(produces = {"application/json"}, method = {RequestMethod.GET})
public class SampleServiceController {

  private static final Logger logger = LoggerFactory.getLogger(SampleServiceController.class);
  
  // This teaches DispatcherServlet how to fetch the welcome-page
  @RequestMapping(value = "/", produces = "text/html")
  public String home(ModelMap map) {
    return "index.html";
  }

  @RequestMapping(value = "sample-service")
  public void sampleService(Model model) {
    heroData = new ArrayList();
    for (String h:heroes) {
      heroData.add(getHero(h));
    }
    model.addAttribute("heroes", heroData);
  }

  @RequestMapping(value = "sample-service-response-body")
  @ResponseBody
  public List sampleServiceResponseBody(Model model) {
    heroData = new ArrayList();
    for (String h:heroes) {
      heroData.add(getHero(h));
    }
    return heroData;
  }

  @RequestMapping(value = "sample-lookup/{val}")
  @ResponseBody
  public Map sampleServiceResponseBody(@PathVariable("val") String val) {
    for (Map<String,Object> h:heroData) {
      String name = (String)h.get("name");
      if (Objects.equal(name, val)) {
        return h;
      }
    }
    return null;
  }

  
  List<Map<String, Object>> heroData = Collections.EMPTY_LIST;  
  static String[] powers = {"invisibility", "strength", "flying", "laser eyes", "stickiness", "super sniffer", "stretchiness"};
  static String[] heroes = {"jane", "bob", "vincent", "jerry", "harriet"};  
  static String[] titles = {"spy", "mayor", "cleaner", "judge", "fixer"}; 
  
  static Map getHero(String name) {
    Map<String, Object> hero = new HashMap<String, Object>();
    hero.put("name", name);
    hero.put("title", titles[(int)Math.floor(Math.random() * titles.length)]);    
    hero.put("age", (int) (Math.random() * 100));
    List powers = new ArrayList();
    for (int i = 0; i < 1 + Math.random() * 3; i ++) {
      powers.add(getPower());
    }
    hero.put("powers", powers);
    return hero;
  }
  
  static Map getPower() {
    Map<String, Object> power = new HashMap<String, Object>();
    power.put("name", powers[(int)Math.floor(Math.random() * powers.length)]);
    power.put("level", (int) (Math.random() * 10));
    return power;
  }

}
