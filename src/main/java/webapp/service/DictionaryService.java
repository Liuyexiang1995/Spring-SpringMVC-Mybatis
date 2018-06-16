package webapp.service;

import java.util.List;

import mybatis.dataObject.SysDictionary;
import mybatis.dataObject.SysDictionaryExample;
import webapp.model.PageModel;

/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: webapp.service 
 * @author: createdByliuyx 
 * @date: 2018年6月11日 下午2:12:07 
 */
public interface DictionaryService {
	
	SysDictionary findById(Long id);
	
	List<SysDictionary> findListByExample(SysDictionaryExample example);
	
	boolean saveOrUpdate(SysDictionary sysDict);
	
	boolean deleteById(Long id);

	PageModel<SysDictionary> loadByParamsInPage(SysDictionaryExample example, PageModel<SysDictionary> pageModel);

}
