/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.putney.json;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Configure things so that RequestMappings that use @ResponseBody to return results can be used with jsonp in the same
 * way that MappingJackson handles jsonp in the MappingJackson2JsonView
 * @author jputney
 */
@ControllerAdvice
public class JsonpResponseBodyAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonpResponseBodyAdvice() {
        super("callback","jsonp");
    }
}
