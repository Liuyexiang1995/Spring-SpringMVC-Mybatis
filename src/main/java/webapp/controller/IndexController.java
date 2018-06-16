package webapp.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: webapp.controller 
 * @author: createdByliuyx 
 * @date: 2018年6月11日 上午10:50:02 
 */
@Controller
public class IndexController {

	@RequestMapping(value={"","/index"})
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("now", new Date());
		return mv;
	}
	
	@RequestMapping(value={"","/default"})
	public ModelAndView defaultPage(){
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("now", new Date());
		return mv;
	}
	
	@RequestMapping(value = "request/page", method = RequestMethod.GET)
	public ModelAndView page(HttpServletRequest request, ModelMap model) {

		model.addAttribute("now", new Date());

		return new ModelAndView("test/page", model);
	}

}
