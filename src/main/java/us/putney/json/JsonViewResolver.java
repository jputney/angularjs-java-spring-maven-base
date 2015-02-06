/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.putney.json;

import java.util.Locale;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 *
 * @author jputney
 */
public class JsonViewResolver implements ViewResolver {

    MappingJackson2JsonView view = new MappingJackson2JsonView();

    public View resolveViewName(String viewName, Locale locale) throws Exception {
//        if (! StringUtils.isEmpty(viewName)) {
//            return null;
//        }

        view.setPrettyPrint(true);
        return view;
    }

}
