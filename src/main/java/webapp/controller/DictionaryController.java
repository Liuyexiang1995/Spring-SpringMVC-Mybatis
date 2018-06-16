package webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dataObject.SysDictionary;
import mybatis.dataObject.SysDictionaryExample;
import webapp.service.DictionaryService;

/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: webapp.controller 
 * @author: createdByliuyx 
 * @date: 2018年6月11日 下午2:10:16 
 */
@Controller
@RequestMapping("/dicts")
public class DictionaryController {

	private Logger logger = Logger.getLogger(DictionaryController.class);
	
	@Autowired
	private DictionaryService  dictService;
	
	@RequestMapping
	public ModelAndView dicts(HttpServletRequest request, ModelMap model) {
		ModelAndView mv=new ModelAndView("dicts");
		
		SysDictionaryExample example=new SysDictionaryExample();
		example.createCriteria().andIdIsNotNull();
		List<SysDictionary> list=dictService.findListByExample(example);
		model.addAttribute("dicts",list);

		return mv;
	}
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request, ModelMap model,Long id) {
		
		ModelAndView mv=new ModelAndView("dict_add");
		SysDictionary dict;
		if(StringUtils.isEmpty(id)){
			dict=new SysDictionary();
		}else{
			dict=dictService.findById(id);
		}
		model.addAttribute("dict",dict);
		
		return mv;
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, ModelMap model,SysDictionary dict) {
		
		ModelAndView mv=new ModelAndView();
		try {
			dictService.saveOrUpdate(dict);
			mv.setViewName("redirect:/dicts");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv.setViewName("dict_add");
			mv.addObject("msg",e.getMessage());
			mv.addObject("model", dict);
		}
		return mv;
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap delete(HttpServletRequest request, ModelMap model,@RequestParam Long id) {
		
		ModelMap modelMap=new ModelMap();
		try {
			boolean success=dictService.deleteById(id);
			modelMap.put("success", success);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("msg", e.getMessage());
		}
		return modelMap;
	}
	
	
}
